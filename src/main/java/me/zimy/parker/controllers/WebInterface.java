package me.zimy.parker.controllers;

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
            parts.add(random.nextInt(8)+32);
        }
        model.addAttribute("secondResult", parts);
        return "answers";
    }
}
