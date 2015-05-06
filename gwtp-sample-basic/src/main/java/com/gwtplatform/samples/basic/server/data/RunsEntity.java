package com.gwtplatform.samples.basic.server.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA
 * Project: gwtp-sample-basic
 * on 5/6/2015
 *
 * @author antoine
 */
@Entity
@Table(name = "runs", schema = "", catalog = "kraken_db")
public class RunsEntity {
    private int runId;
    private Timestamp date;
    private int avgSpeed;
    private Integer currentSpeed;
    private int distance;
    private int totalTime;
    private Byte inProgress;

    @Id
    @Column(name = "run_id", nullable = false, insertable = true, updatable = true)
    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "avg_speed", nullable = false, insertable = true, updatable = true)
    public int getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(int avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    @Basic
    @Column(name = "current_speed", nullable = true, insertable = true, updatable = true)
    public Integer getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(Integer currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    @Basic
    @Column(name = "distance", nullable = false, insertable = true, updatable = true)
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "total_time", nullable = false, insertable = true, updatable = true)
    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    @Basic
    @Column(name = "in_progress", nullable = true, insertable = true, updatable = true)
    public Byte getInProgress() {
        return inProgress;
    }

    public void setInProgress(Byte inProgress) {
        this.inProgress = inProgress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunsEntity that = (RunsEntity) o;

        if (runId != that.runId) return false;
        if (avgSpeed != that.avgSpeed) return false;
        if (distance != that.distance) return false;
        if (totalTime != that.totalTime) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (currentSpeed != null ? !currentSpeed.equals(that.currentSpeed) : that.currentSpeed != null) return false;
        if (inProgress != null ? !inProgress.equals(that.inProgress) : that.inProgress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = runId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + avgSpeed;
        result = 31 * result + (currentSpeed != null ? currentSpeed.hashCode() : 0);
        result = 31 * result + distance;
        result = 31 * result + totalTime;
        result = 31 * result + (inProgress != null ? inProgress.hashCode() : 0);
        return result;
    }
}
