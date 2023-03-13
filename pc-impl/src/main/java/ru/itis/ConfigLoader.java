package ru.itis;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigLoader {

    static {
        System.setProperty("liquibase.duplicateFileMode", "WARN");
    }
}
