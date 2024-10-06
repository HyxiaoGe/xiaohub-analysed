package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends BaseRepository<News, Long> {
    List<News> findByIsProcessedFalse();

    @Query(value = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY platform ORDER BY publication_date DESC) AS rn FROM t_news) AS ranked WHERE rn <= 20", nativeQuery = true)
    List<News> findLatestByPlatform();

    @Query("SELECT n FROM News n WHERE n.platform = '36kr' AND n.summary IS NOT NULL ORDER BY n.publicationDate DESC")
    List<News> findAISummarizedNews(Pageable pageable);
}
