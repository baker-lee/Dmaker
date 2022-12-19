package com.example.dmaker.controller;

import com.example.dmaker.service.DmakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DmakerController {
    private final DmakerService dmakerService;

    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("snow", "elsa", "olaf");
    }

    @GetMapping("/create-developers")
    public List<String> createDevelopers() {
        dmakerService.createDeveloper();

        return List.of("Olaf");
    }

}