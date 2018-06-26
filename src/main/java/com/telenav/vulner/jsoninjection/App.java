package com.telenav.vulner.jsoninjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Starting here.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        new AnnotationConfigApplicationContext(ServerConfig.class);
        Object lock = new Object();
        synchronized (lock) {
            while (true) {
                lock.wait();
            }
        }
    }
}
