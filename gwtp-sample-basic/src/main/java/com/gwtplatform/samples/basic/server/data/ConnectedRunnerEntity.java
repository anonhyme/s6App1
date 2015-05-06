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
@Table(name = "connected_runner", schema = "", catalog = "kraken_db")
public class ConnectedRunnerEntity {
    private String macId;
    private Integer runId;
    private int runnerId;

    @Basic
    @Column(name = "mac_id", nullable = false, insertable = true, updatable = true, length = 64)
    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    @Basic
    @Column(name = "run_id", nullable = true, insertable = true, updatable = true)
    public Integer getRunId() {
        return runId;
    }

    public void setRunId(Integer runId) {
        this.runId = runId;
    }

    @Id
    @Column(name = "runner_id", nullable = false, insertable = true, updatable = true)
    public int getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(int runnerId) {
        this.runnerId = runnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectedRunnerEntity that = (ConnectedRunnerEntity) o;

        if (runnerId != that.runnerId) return false;
        if (macId != null ? !macId.equals(that.macId) : that.macId != null) return false;
        if (runId != null ? !runId.equals(that.runId) : that.runId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = macId != null ? macId.hashCode() : 0;
        result = 31 * result + (runId != null ? runId.hashCode() : 0);
        result = 31 * result + runnerId;
        return result;
    }
}
