package com.mapreduce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyValue {

    private String key;
    private String value;
}
