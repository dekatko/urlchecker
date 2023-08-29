package de.urlchecker.urlchecker.service;

import java.util.Arrays;
import java.util.List;

public class ServerStatusService {
    public static void printServerStatusHeader() {
        System.out.println(String.format("%30s %25s %10s", "Server Url", "|", "Available"));
        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------"));
    }

    public static void printTableTailEnd() {
        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------"));
    }

    public static List<String> getUrlsFromParameter(String urls) {
        return Arrays.asList(urls.split("\\s+"));
    }
}
