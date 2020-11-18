package com.apartment.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TotalResponse {
    private double sum;
    private int count;
    private List<Object> data;
}
