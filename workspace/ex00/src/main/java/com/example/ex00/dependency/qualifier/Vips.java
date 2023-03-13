package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
@Qualifier(value = "vips")
public class Vips implements Restaurant{
    private int steak = Restaurant.steak + 30000;

    @Override
    public boolean isSalad() {
        return true;
    }
}
