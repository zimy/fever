package me.zimy.parker.controllers;

import me.zimy.parker.model.ThermoEvent;
import me.zimy.parker.repositories.Thermos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Main and only HTTP controller
 *
 * @author Dmitriy &lt;Zimy&gt; Yakovlev
 * @since 12/9/14.
 */
@Controller
@RequestMapping("/")
public class WebInterface {

    @RequestMapping("/")
    public String getProbabilityResults(Model model) throws InterruptedException, ExecutionException {
        Random random = new Random();
        List<Integer> parts = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            parts.add(random.nextInt(18) + 20);
        }
        model.addAttribute("secondResult", parts);
        model.addAttribute("lastValue", parts.get(parts.size() - 1));
        return "answers";
    }
}
