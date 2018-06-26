package com.javilet.vulner.jsoninjection;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import javax.annotation.PostConstruct;

import java.io.IOException;

import static spark.Spark.*;

/**
 * Created by jamie on 6/23/18
 */
public class WebServer {
    Gson gson = new Gson();

    @PostConstruct
    public void init() {
    }

    public void routes() {
        staticFileLocation("web");
        port(8080);
        post("/login2", (req, res) -> login2(req, res));
        post("/login", (req, res) -> login(req, res));
    }

    private Object login2(Request req, Response res) {
        String username = req.queryParams("username");
        String password = req.queryParams("password");

        /*
            Injection happens here
         */
        String jsonString = "{ 'username': " + username + ", 'password': " + password + "}";

        UserInfo userInfo = gson.fromJson(jsonString, UserInfo.class);

        if (!userInfo.getPassword().equals("password")) {
            return "Invalid Login";
        }

        if (userInfo.getUsername() == "admin") {
            userInfo.setRole("admin");
        }

        return "The role is " + userInfo.getRole() + ".";
    }

    private Object login(Request req, Response res) throws IOException {
        /*
            Injection can happen here.
         */
        UserInfo userInfo = gson.fromJson(req.body(), UserInfo.class);

        if (!userInfo.getPassword().equals("password")) {
            return "Invalid Login";
        }

        if (userInfo.getUsername() == "admin") {
            userInfo.setRole("admin");
        }

        return "The role is " + userInfo.getRole() + ".";
    }

}
