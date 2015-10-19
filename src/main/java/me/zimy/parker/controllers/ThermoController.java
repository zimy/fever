package me.zimy.parker.controllers;

import me.zimy.parker.model.ThermoEvent;
import me.zimy.parker.repositories.Thermos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 27.09.15.
 * Controller for posting sensor information
 */
@Controller
public class ThermoController {
    @Autowired
    Thermos thermos;

    @RequestMapping("/dweet/for/wetrackfever")
    @ResponseBody
    public void postThermo(@RequestParam Double temperature) {
        ThermoEvent thermoEvent = new ThermoEvent(temperature, LocalDateTime.now());
        thermos.save(thermoEvent);
    }

    @RequestMapping("/thermos")
    @ResponseBody
    public Collection<ThermoEvent> getAll() {
        return thermos.findAll();
    }
}
