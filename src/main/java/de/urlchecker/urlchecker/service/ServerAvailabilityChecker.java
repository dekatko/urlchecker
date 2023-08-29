package de.urlchecker.urlchecker.service;

import de.urlchecker.urlchecker.model.ServerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * This scheduled task provides the ability to check the status of a server,
 * and print a table showing the URL and the current status of the server
 */
@Component
public class ServerAvailabilityChecker {
    @Value("${server.urls}")
    private String serverUrls;

    @Autowired
    Environment env;

    /**
     * Interval for the scheduler can be set in application.properties in milliseconds
     */
    @Scheduled(initialDelay = 1000, fixedRateString = "${server.interval}")
    @Async
    public void getCurrentServerStatus() {

        List<String> urls = ServerStatusService.getUrlsFromParameter(serverUrls);

        ServerStatusService.printServerStatusHeader();

        for (String url : urls) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                ServerStatus serverStatus = new ServerStatus(url, true);
                serverStatus.printServerStatus();
            } catch (IOException e) {
                ServerStatus serverStatus = new ServerStatus(url, false);
                serverStatus.printServerStatus();
            }
        }
        ServerStatusService.printTableTailEnd();
    }
}