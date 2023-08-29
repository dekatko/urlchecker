package de.urlchecker.urlchecker.model;

import lombok.*;

@Data
@AllArgsConstructor
public class ServerStatus {
    public String serverUrl;

    public boolean available;

    public void printServerStatus() {
        System.out.println(String.format("%30s %25s %10s", this.getServerUrl(), "|", this.isAvailable()));
    }
}

