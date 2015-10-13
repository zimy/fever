package me.zimy.parker.controllers;

import me.zimy.parker.model.ThermoEvent;
import me.zimy.parker.repositories.Thermos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 27.09.15.
 * Controller for posting sensor information
 */
@Controller
@RequestMapping("/thermo")
public class ThermoController {
    @Autowired
    Thermos thermos;

    @RequestMapping()
    public String postThermo(@RequestParam float value, @RequestParam int room, @RequestParam int bed){
        ThermoEvent thermoEvent = new ThermoEvent(value, LocalDateTime.now());
        thermos.save(thermoEvent);
        return "200";
    }
    @RequestMapping("/all")
    public Collection<ThermoEvent> getAll(){
        return thermos.findAll();
    }
    @RequestMapping("/one")
    public ThermoEvent getOne(@RequestParam LocalDateTime id)
    {
        return thermos.findByTimestamp(id);
    }
}
