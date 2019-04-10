/*
 * ----------------------------------------------------------------------------
 * "THE BOOZE-WARE LICENSE"
 * Simon Rice wrote this file. As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me an alcoholic beverage in return.
 *
 * Simon Rice - test
 * ----------------------------------------------------------------------------
 */

package com.simonrice.sparkservletexample;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.servlet.SparkApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

public class HelloWorld implements SparkApplication {
    
    final static Logger logger = Logger.getLogger(HelloWorld.class);
    @Override
    public void init() {
        
        Spark.get("/",
                  (Request request, Response response) -> {
                      response.redirect("/currency/service");
                      return null;
            });
        
        Spark.get("/service",
                  (Request request, Response response) -> {
                      return "Welcome to the ACME Currency Service!";
                  });
        
        Spark.get("/service/:id",
                  (Request request, Response response) -> {
                      logger.info("This is a test of the emergency broadcast system");
                      float input;
                      System.out.println(request.params(":id"));
                      input = Float.parseFloat(request.params(":id"));
                      float output;
                      output = input * 10;
                      return  String.format(" %s", output);
                  });
    }
}