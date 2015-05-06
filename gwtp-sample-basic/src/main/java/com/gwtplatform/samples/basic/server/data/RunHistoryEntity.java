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
@Table(name = "run_history", schema = "", catalog = "kraken_db")
public class RunHistoryEntity {
    private int runDataId;
    private int runId;
    private int speed;
    private int time;

    @Id
    @Column(name = "run_data_id", nullable = false, insertable = true, updatable = true)
    public int getRunDataId() {
        return runDataId;
    }

    public void setRunDataId(int runDataId) {
        this.runDataId = runDataId;
    }

    @Basic
    @Column(name = "run_id", nullable = false, insertable = true, updatable = true)
    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    @Basic
    @Column(name = "speed", nullable = false, insertable = true, updatable = true)
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunHistoryEntity that = (RunHistoryEntity) o;

        if (runDataId != that.runDataId) return false;
        if (runId != that.runId) return false;
        if (speed != that.speed) return false;
        if (time != that.time) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = runDataId;
        result = 31 * result + runId;
        result = 31 * result + speed;
        result = 31 * result + time;
        return result;
    }
}
