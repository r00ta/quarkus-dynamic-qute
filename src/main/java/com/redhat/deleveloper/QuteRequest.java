package com.redhat.deleveloper;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuteRequest {
    @JsonProperty("template")
    String template;

    @JsonProperty("data")
    Object data;
}
