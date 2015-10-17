package me.zimy.parker.repositories;

import me.zimy.parker.model.ThermoEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Cacheable;
import java.time.LocalDateTime;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 07.10.15.
 * JPA to extract and store thermoEvents
 */
@Repository
@Cacheable
public interface Thermos extends JpaRepository<ThermoEvent, Long>{
    ThermoEvent findByTimestamp(LocalDateTime id);
}
