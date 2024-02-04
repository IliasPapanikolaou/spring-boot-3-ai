package com.ipap.springboot3ai.dto;

import com.ipap.springboot3ai.model.Singer;

import java.util.ArrayList;
import java.util.List;

public record SingersResponse (
        List<Singer> singers
) {
}
