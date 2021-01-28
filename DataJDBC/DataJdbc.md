##DataSourceConfiguration

```java
@Configuration(proxyBeanMethods = false)
	@ConditionalOnClass(org.apache.tomcat.jdbc.pool.DataSource.class)
	@ConditionalOnMissingBean(DataSource.class)
	@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "org.apache.tomcat.jdbc.pool.DataSource",
			matchIfMissing = true)
	static class Tomcat {
```

数据源配置

####org.springframework.boot.autoconfigure.jdbc.DataSourceInitializer

执行数据库脚本

```java
boolean createSchema() {
		List<Resource> scripts = getScripts("spring.datasource.schema", this.properties.getSchema(), "schema");
		if (!scripts.isEmpty()) {
			if (!isEnabled()) {
				logger.debug("Initialization disabled (not running DDL scripts)");
				return false;
			}
			String username = this.properties.getSchemaUsername();
			String password = this.properties.getSchemaPassword();
			runScripts(scripts, username, password);
		}
		return !scripts.isEmpty();
	}

	/**
	 * Initialize the schema if necessary.
	 * @see DataSourceProperties#getData()
	 */
	void initSchema() {
		List<Resource> scripts = getScripts("spring.datasource.data", this.properties.getData(), "data");
		if (!scripts.isEmpty()) {
			if (!isEnabled()) {
				logger.debug("Initialization disabled (not running data scripts)");
				return;
			}
			String username = this.properties.getDataUsername();
			String password = this.properties.getDataPassword();
			runScripts(scripts, username, password);
		}
	}
private List<Resource> getScripts(String propertyName, List<String> resources, String fallback) {
		if (resources != null) {
			return getResources(propertyName, resources, true);
		}
		String platform = this.properties.getPlatform();
		List<String> fallbackResources = new ArrayList<>();
		fallbackResources.add("classpath*:" + fallback + "-" + platform + ".sql");
		fallbackResources.add("classpath*:" + fallback + ".sql");
		return getResources(propertyName, fallbackResources, false);
	}

	private List<Resource> getResources(String propertyName, List<String> locations, boolean validate) {
		List<Resource> resources = new ArrayList<>();
		for (String location : locations) {
			for (Resource resource : doGetResources(location)) {
				if (resource.exists()) {
					resources.add(resource);
				}
				else if (validate) {
					throw new InvalidConfigurationPropertyValueException(propertyName, resource,
							"The specified resource does not exist.");
				}
			}
		}
		return resources;
	}
```

##配置Druid的监控

```java
/**
     * 配置Druid的监控
     * 1、配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>(4);
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        //默认就是允许所有访问
        initParams.put("allow", "");
        initParams.put("deny", "192.168.15.21");
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 2、配置一个web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>(1);
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
```

