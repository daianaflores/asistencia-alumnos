package asistenciaalumnos.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @JsonIgnore
    @CreatedBy
    @Column(name = "CREATED_BY")
    protected U createdBy;

    @JsonIgnore
    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "CREATION_DATE")
    protected Date creationDate;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    protected U lastModifiedBy;

    @JsonIgnore
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE")
    protected Date lastModifiedDate;

    /*
    @Temporal(TIMESTAMP)
    @Column(name = "LAST_ERASED_DATE")
    protected Date lastErasedDate;


    @Column(name = "ERASED_BY")
    protected U lastErasedBy;
*/
    public U getCreatedBy(){ return this.createdBy;}

    public void setCreatedBy(U createdBy){
        this.createdBy = createdBy;
    }

    public Date getCreationDate(){
        return this.creationDate;
    }

    public void setCreationDate(Date dateCreated){
        this.creationDate = creationDate;
    }

    public U getLastModifiedBy(){ return this.lastModifiedBy; }

    public void setLastModifiedBy(U lastModifiedBy){
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate(){
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate){
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setAuditable(Date date, U user){
        this.createdBy = user;
        this.creationDate = date;
        this.lastModifiedBy= user;
        this.lastModifiedDate = date;
    }

    public void setAuditableUpdate(Date date, U user){
        this.lastModifiedBy= user;
        this.lastModifiedDate = date;
    }
}