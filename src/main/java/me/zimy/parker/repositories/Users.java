package me.zimy.parker.repositories;

import me.zimy.parker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 19.10.15.
 * Used for storing and extracting user email data
 */
@Repository
public interface Users extends JpaRepository<User, Long> {
}
