package com.xiaohub.analysed.dao.entity;

import com.xiaohub.analysed.dao.entity.base.BaseEntity;
import com.xiaohub.analysed.enums.Period;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_trend")
@Data
public class Trend extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Period period;

    private Integer frequency;

}
