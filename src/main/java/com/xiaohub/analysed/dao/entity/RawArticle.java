package com.xiaohub.analysed.dao.entity;

import com.xiaohub.analysed.dao.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_raw_articles")
public class RawArticle extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String platform;


    @Column(nullable = false)
    private String title;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @Column(columnDefinition = "TEXT")
    private String keywords;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(name = "is_processed")
    private boolean isProcessed = false;
}
