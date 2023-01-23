package com.mapreduce.service;

import java.util.List;

public interface ReduceFunc {

    String reduceF(String key, List<String> values);

}
