package org.anonhyme.entities.procedure;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/10/2015
 *
 * @author antoine
 */
//resultClasses = ReservationProcedure.class,
@NamedStoredProcedureQuery(
        name = "GetReservation",
        resultClasses = ReservationProcedure.class,
        procedureName = "get_reservation_table",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cat", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_jour", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_start_time", type = Time.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_end_time", type = Time.class),
        }
)
@Entity
public class ReservationProcedure implements Serializable{
    String periode;
    String local;
    String description;

    @Id
    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    @Column(name = "pav_local_id")
    @Id
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
