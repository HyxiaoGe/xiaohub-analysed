package com.xiaohub.analysed.dao.entity;

import com.xiaohub.analysed.dao.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_custom_rule")
@Data
public class CustomRule extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    private String ruleType;

    private String condition;

    private String value;

    private String action;

}
