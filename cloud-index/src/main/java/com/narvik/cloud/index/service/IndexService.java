package com.narvik.cloud.index.service;

import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/13 20:03
 */
public interface IndexService {

    String purchase(String userId, Map<String, Integer> stockChangeMap);

}
