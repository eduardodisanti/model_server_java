/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alstomgroup.modelserver.panama.minimalmodelserver;

import com.alstomgroup.modelserver.panama.model.providers.AlstomModel;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import org.json.simple.JSONObject;
 
/**
 *
 * @author eduardo
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/panama/")
@Slf4j
public class ModelServerController {
 
    private AlstomModel model = new AlstomModel("models/tree_regressor.pmml");
    
    @RequestMapping("/")
    String home() {
        return "Running";
    }
    
    @GetMapping("/eta")
    public String predict(
            @RequestParam(name="medlnc",      required = true) Double medlnc,
            @RequestParam(name="houseage",    required = true) Double houseage,
            @RequestParam(name="averooms",    required = true) Double averooms,
            @RequestParam(name="avebedrooms", required = true) Double avebedrooms,
            @RequestParam(name="population",  required = true) Double population,
            @RequestParam(name="aveoccup",    required = true) Double aveoccup,
            @RequestParam(name="latitude",    required = true) Double latitude,
            @RequestParam(name="longitude",   required = true) Double longitude
            ) {
        
        Double p;

        HashMap v = new HashMap();
        v.put(v, v);
        v.put("medlnc" ,medlnc);
        v.put("houseage" ,houseage);
        v.put("averooms" ,averooms);
        v.put("avebedrooms" ,avebedrooms);
        v.put("population"  ,population);
        v.put("aveoccup"  ,aveoccup);
        v.put("latitude"  ,latitude);
        v.put("longitude"  ,longitude);
        
        p = (Double) model.predict(v).get("predicted_price");
        return p.toString();
    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ModelServerController.class, args);
    }
}
