package me.zimy.parker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 17.10.15.
 * Stores time, type and distance of user who hit distance sensor
 */
@Entity
public class VisitorEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Boolean start;
    LocalDateTime time;
    Integer distance;

    public VisitorEvent() {
    }

    public VisitorEvent(Boolean start, LocalDateTime time, Integer distance) {
        this.start = start;
        this.time = time;
        this.distance = distance;
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
