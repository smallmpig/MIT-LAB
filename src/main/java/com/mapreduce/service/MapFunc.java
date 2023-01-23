package com.mapreduce.service;

import com.mapreduce.model.KeyValue;

import java.util.List;

public interface MapFunc {

    List<KeyValue> mapF(String file, String cnt);
}
