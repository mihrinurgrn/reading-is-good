package com.mng.bookorderproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    protected String createdBy;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "MODIFIED_BY")
    protected String modifiedBy;

    @Column(name = "MODIFIED_AT")
    protected LocalDateTime modifiedAt;

    @PrePersist
    private void prePersist() {
        createdAt = LocalDateTime.now();
        createdBy = "SYSTEM";
    }

    @PreUpdate
    private void preUpdate() {
        modifiedAt = LocalDateTime.now();
        modifiedBy = "SYSTEM";
    }

}