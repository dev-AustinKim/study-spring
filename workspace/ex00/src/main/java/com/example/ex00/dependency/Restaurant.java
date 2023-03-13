package com.example.ex00.dependency;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class Restaurant {
    private final Chef chef;
}
