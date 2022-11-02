package com.app.findcarbackend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiCarResponseObject {
    List<ApiCar> data;
}
