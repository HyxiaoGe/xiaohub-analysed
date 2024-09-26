package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.Keyword;
import com.xiaohub.analysed.dao.entity.RelatedKeyword;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;

import java.util.List;

public interface RelatedKeywordRepository extends BaseRepository<RelatedKeyword, Long> {

    List<RelatedKeyword> findByKeyword(Keyword keyword);
    List<RelatedKeyword> findByRelatedKeyword(Keyword relatedKeyword);
    List<RelatedKeyword> findByStrengthGreaterThan(Double strength);
    List<RelatedKeyword> findByCoOccurrenceGreaterThan(Integer coOccurrence);

}
