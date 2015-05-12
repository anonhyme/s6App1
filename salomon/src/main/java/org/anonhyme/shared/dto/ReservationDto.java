package org.anonhyme.shared.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/10/2015
 *
 * @author antoine
 */
public class ReservationDto implements Serializable{
    String periode;
    String local;
    String description;

    public ReservationDto() {
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

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
