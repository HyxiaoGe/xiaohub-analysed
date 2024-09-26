package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.Keyword;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface KeywordRepository extends BaseRepository<Keyword, Long> {

    Keyword findByKeyword(String keyword);
    List<Keyword> findByCategory(String category);

}
