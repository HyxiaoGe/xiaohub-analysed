package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.CustomRule;
import com.xiaohub.analysed.dao.entity.Keyword;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;

import java.util.List;

public interface CustomRuleRepository extends BaseRepository<CustomRule, Long> {

    List<CustomRule> findByKeyword(Keyword keyword);
    List<CustomRule> findByRuleType(String ruleType);
    List<CustomRule> findByAction(String action);

}
