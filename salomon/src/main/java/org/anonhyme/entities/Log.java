package org.anonhyme.entities;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/8/2015
 *
 * @author antoine
 */
@Entity
public class Log {
    private int logId;
    private String commentaire;
    private Date inscription;

    @Id
    @Column(name = "log_id", nullable = false, insertable = true, updatable = true)
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "commentaire", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Basic
    @Column(name = "_inscription", nullable = false, insertable = true, updatable = true)
    public Date getInscription() {
        return inscription;
    }

    public void setInscription(Date inscription) {
        this.inscription = inscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (logId != log.logId) return false;
        if (commentaire != null ? !commentaire.equals(log.commentaire) : log.commentaire != null)
            return false;
        if (inscription != null ? !inscription.equals(log.inscription) : log.inscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
        result = 31 * result + (inscription != null ? inscription.hashCode() : 0);
        return result;
    }
}
