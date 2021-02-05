package org.yu.elasticsearchmodule.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.yu.elasticsearchmodule.bean.Book;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/4 19:23
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
