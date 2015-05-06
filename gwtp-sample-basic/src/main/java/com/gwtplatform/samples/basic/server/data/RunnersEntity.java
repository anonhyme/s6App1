package com.gwtplatform.samples.basic.server.data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA
 * Project: gwtp-sample-basic
 * on 5/6/2015
 *
 * @author antoine
 */
@Entity
@Table(name = "runners", schema = "", catalog = "kraken_db")
public class RunnersEntity {
    private int runnerId;
    private String name;
    private int height;
    private String macId;
    private int level;
    private int lastRunId;

    @Id
    @Column(name = "runner_id", nullable = false, insertable = true, updatable = true)
    public int getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(int runnerId) {
        this.runnerId = runnerId;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "height", nullable = false, insertable = true, updatable = true)
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Basic
    @Column(name = "mac_id", nullable = true, insertable = true, updatable = true, length = 64)
    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    @Basic
    @Column(name = "level", nullable = false, insertable = true, updatable = true)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "last_run_id", nullable = false, insertable = true, updatable = true)
    public int getLastRunId() {
        return lastRunId;
    }

    public void setLastRunId(int lastRunId) {
        this.lastRunId = lastRunId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunnersEntity that = (RunnersEntity) o;

        if (runnerId != that.runnerId) return false;
        if (height != that.height) return false;
        if (level != that.level) return false;
        if (lastRunId != that.lastRunId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (macId != null ? !macId.equals(that.macId) : that.macId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = runnerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + height;
        result = 31 * result + (macId != null ? macId.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + lastRunId;
        return result;
    }
}
