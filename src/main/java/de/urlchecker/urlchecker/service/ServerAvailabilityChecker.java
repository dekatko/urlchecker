package de.urlchecker.urlchecker.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ServerAvailabilityChecker {
    @Value("${server.url}")
    private String serverUrl;

    @Scheduled(fixedRateString = "${server.interval}")
    public boolean isServerAvailable() {
        System.out.println("-- Start Check --");
        System.out.println("Server Url: " + serverUrl);

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(serverUrl).openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();

            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }
}