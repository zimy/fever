package me.zimy.parker.repositories;

import me.zimy.parker.model.VisitorEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 17.10.15.
 * Extracts and stores information about stand visitors
 */
@Repository
public interface Visitors extends JpaRepository<VisitorEvent, Long> {
}
