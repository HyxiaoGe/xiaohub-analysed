package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.Keyword;
import com.xiaohub.analysed.dao.entity.Source;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;
import com.xiaohub.analysed.enums.SourceType;

import java.time.LocalDateTime;
import java.util.List;

public interface SourceRepository extends BaseRepository<Source, Long> {

    List<Source> findByKeyword(Keyword keyword);
    List<Source> findBySourceType(SourceType sourceType);
    List<Source> findBySourceName(String sourceName);
    List<Source> findByLastSeenAtAfter(LocalDateTime date);

}
