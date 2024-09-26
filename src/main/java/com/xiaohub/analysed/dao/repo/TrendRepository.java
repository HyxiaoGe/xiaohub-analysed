package com.xiaohub.analysed.dao.repo;

import com.xiaohub.analysed.dao.entity.Keyword;
import com.xiaohub.analysed.dao.entity.Trend;
import com.xiaohub.analysed.dao.repo.base.BaseRepository;
import com.xiaohub.analysed.enums.Period;

import java.time.LocalDate;
import java.util.List;

public interface TrendRepository extends BaseRepository<Trend, Long> {

    List<Trend> findByKeyword(Keyword keyword);
    List<Trend> findByDate(LocalDate date);
    List<Trend> findByPeriod(Period period);
    List<Trend> findByKeywordAndDateBetween(Keyword keyword, LocalDate startDate, LocalDate endDate);

}
