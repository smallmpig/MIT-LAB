package com.mapreduce.service.impl;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.mapreduce.model.KeyValue;
import com.mapreduce.service.MapFunc;
import com.mapreduce.service.ReduceFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordCount implements MapFunc, ReduceFunc {

    public WordCount(){
        super();
    }

    @Override
    public List<KeyValue> mapF(String file, String cnt) {
        List<String> words=splitStr(cnt);
        return words.stream().map(e->new KeyValue(e,"1")).collect(Collectors.toList());
    }

    @Override
    public String reduceF(String key, List<String> values) {
        return String.valueOf(values.size());
    }

    private List<String> splitStr(String content){
        List<String> ret = new ArrayList<>(32);
        Splitter.on(new CharMatcher() {
            @Override
            public boolean matches(char c) {
                return !Character.isLetter(c);
            }
        }).omitEmptyStrings().split(content).forEach(c -> {
            ret.add(c);
        });
        return ret;

    }
}
