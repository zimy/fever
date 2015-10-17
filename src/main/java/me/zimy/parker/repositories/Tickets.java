package me.zimy.parker.repositories;

import me.zimy.parker.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 17.10.15.
 * Extracts and stores information about tickets
 */
public interface Tickets extends JpaRepository<Ticket, Long> {
}
