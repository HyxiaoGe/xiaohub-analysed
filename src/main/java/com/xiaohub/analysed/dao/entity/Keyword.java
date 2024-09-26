package com.xiaohub.analysed.dao.entity;

import com.xiaohub.analysed.dao.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_keyword")
@Data
public class Keyword extends BaseEntity {

    @Column(nullable = false)
    private String keyword;

    private String category;

    private Integer frequency;

    private Double relevanceScore;

    private Double trustScore;

    private Double sentimentScore;

    private LocalDateTime lastSeenAt;

    private LocalDateTime lastAnalyzedAt;

    private Boolean isCustom;

    private Boolean isActive;

    private String status;

    @Column(columnDefinition = "TEXT")
    private String context;

    @Column(columnDefinition = "JSON")
    private String languages;

    private Integer version;

    @Column(columnDefinition = "JSON")
    private String metadata;

    @OneToMany(mappedBy = "keyword")
    private List<Source> sources;

    @OneToMany(mappedBy = "keyword")
    private List<Trend> trend;

    @OneToMany(mappedBy = "keyword")
    private List<RelatedKeyword> relatedKeyword;

    @OneToMany(mappedBy = "keyword")
    private List<CustomRule> customRule;

}