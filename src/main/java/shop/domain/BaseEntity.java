package shop.domain;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    private String createdBy;
    private LocalDateTime createdDAte;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDAte() {
        return createdDAte;
    }

    public void setCreatedDAte(LocalDateTime createdDAte) {
        this.createdDAte = createdDAte;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
