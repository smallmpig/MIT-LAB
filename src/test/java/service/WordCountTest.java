package service;


import com.mapreduce.model.KeyValue;
import com.mapreduce.service.impl.WordCount;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCountTest {

    private String content="he he she she I I You You /t /n he he she she I I You You I,I";

    @Test
    public void testWordCount(){
        WordCount wordCount=new WordCount();
        List<KeyValue> keyValues=wordCount.mapF("",content);
        Map<String,List<String>> keyValMap=new HashMap<>();
        keyValues.stream().forEach(e->{
            List<String> values=keyValMap.getOrDefault(e.getKey(),new ArrayList<>());
            values.add(e.getValue());
            keyValMap.put(e.getKey(),values);
        });
        Map<String,String> retMap=new HashMap<>();

        keyValMap.forEach((k,v)->{
            String r=wordCount.reduceF(k,v);
            retMap.put(k,r);
        });

        Assert.assertEquals("4",retMap.get("he"));
        Assert.assertEquals("6",retMap.get("I"));
        Assert.assertEquals("4",retMap.get("You"));
    }
}
