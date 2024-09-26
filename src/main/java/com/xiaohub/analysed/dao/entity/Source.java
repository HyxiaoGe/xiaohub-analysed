package com.xiaohub.analysed.dao.entity;

import com.xiaohub.analysed.dao.entity.base.BaseEntity;
import com.xiaohub.analysed.enums.SourceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_source")
@Data
public class Source extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "keywordId")
    private Keyword keyword;

    @Enumerated(EnumType.STRING)
    private SourceType sourceType;

    private String sourceName;

    private Integer frequency;

    private LocalDateTime lastSeenAt;

}
