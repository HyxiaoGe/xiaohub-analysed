package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends BaseRepository<News, Long> {
    List<News> findByIsProcessedFalse();

    @Query(value = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY platform ORDER BY publication_date DESC) AS rn FROM t_news) AS ranked WHERE rn <= 20", nativeQuery = true)
    List<News> findTop10ByOrderByPublicationDateDesc();
}
