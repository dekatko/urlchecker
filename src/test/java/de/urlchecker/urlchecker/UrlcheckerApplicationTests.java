package de.urlchecker.urlchecker;

import de.urlchecker.urlchecker.service.ServerAvailabilityChecker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UrlcheckerApplicationTests {

    @Autowired
    ServerAvailabilityChecker checker;

    @Test
    void contextLoads() {
    }
}
