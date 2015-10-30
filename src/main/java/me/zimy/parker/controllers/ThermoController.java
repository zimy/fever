package me.zimy.parker.controllers;

import me.zimy.parker.model.ThermoEvent;
import me.zimy.parker.repositories.Thermos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 27.09.15.
 * Controller for posting sensor information
 */
@RestController
public class ThermoController {
    @Autowired
    Thermos thermos;

    @RequestMapping("/dweet/for/wetrackfever")
    public void postThermo(@RequestParam Double temperature) {
        ThermoEvent thermoEvent = new ThermoEvent(temperature, LocalDateTime.now());
        thermos.save(thermoEvent);
    }

    @RequestMapping("/thermos")
    public Collection<ThermoEvent> getAll() {
        return thermos.findAll();
    }

    @RequestMapping("/measurements")
    public List<Double> getMeasurements() {
        return thermos.findAll().stream().map(ThermoEvent::getTemperature).collect(Collectors.toList());
    }
}
