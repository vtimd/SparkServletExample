/*
 * ----------------------------------------------------------------------------
 * "THE BOOZE-WARE LICENSE"
 * Simon Rice wrote this file. As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me an alcoholic beverage in return.
 *
 * Simon Rice
 * ----------------------------------------------------------------------------
 */

package com.simonrice.sparkservletexample;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.servlet.SparkApplication;

public class HelloWorld implements SparkApplication {
    @Override
    public void init() {
        
        Spark.get("/",
                  (Request request, Response response) -> {
                      response.redirect("/currencyservice/hello");
                      return null;
            });
        
        Spark.get("/currencyservice",
                  (Request request, Response response) -> {
                      return "Welcome to the ACME Currency Service!";
                  });
        
        Spark.get("/currencyservice/:id",
                  (Request request, Response response) -> {
                      int input;
                      input = Integer.parseInt(request.params(":id"));
                      int output;
                      output = input * 10;
                      return  String.format(" %s", output);
                  });
    }
}