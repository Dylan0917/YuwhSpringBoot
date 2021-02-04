package org.yu.elasticsearchmodule;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.indices.CreateIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yu.elasticsearchmodule.bean.Article;
import org.yu.elasticsearchmodule.bean.Book;
import org.yu.elasticsearchmodule.repository.BookRepository;

import java.io.IOException;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/2 18:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void contextLoads(){
        Article article = new Article();

        article.setId(1);
        article.setTitle("第一篇标题");
        article.setAuthor("ywh");
        article.setContent("hello world");
        //构建索引
        Index build = new Index.Builder(article).index("yu").type("article").build();
        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test01(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("fdfd");
        bookRepository.save(book);
    }


}
