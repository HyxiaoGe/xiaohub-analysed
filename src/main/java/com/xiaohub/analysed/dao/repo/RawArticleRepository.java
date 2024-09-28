package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.RawArticle;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;

import java.util.List;

public interface RawArticleRepository extends BaseRepository<RawArticle, Long> {
    List<RawArticle> findByIsProcessedFalse();
}
