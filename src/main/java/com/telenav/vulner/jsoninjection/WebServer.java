package com.telenav.vulner.jsoninjection;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import javax.annotation.PostConstruct;

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
        post("/login", (req, res) -> login(req, res));
    }

    private Object login(Request req, Response res) {
        LoginResult result = new LoginResult();
        gson.fromJson(req.body(), LoginResult.class);
        return result;
    }


    private class LoginResult {
        String username = "";
        String role = "user";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
