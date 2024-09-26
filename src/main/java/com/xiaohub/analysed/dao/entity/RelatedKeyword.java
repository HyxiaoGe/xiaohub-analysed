package com.xiaohub.analysed.dao.entity;

import com.xiaohub.analysed.dao.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_related_keyword")
@Data
public class RelatedKeyword extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    @ManyToOne
    @JoinColumn(name = "related_keyword_id")
    private Keyword relatedKeyword;

    private Double strength;

    private Integer coOccurrence;

}
