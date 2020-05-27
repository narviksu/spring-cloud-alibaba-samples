package com.narvik.cloud.base;

import com.narvik.cloud.common.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * @Author narvik
 * @Date 2020/5/8 18:18
 */
public abstract class BaseController {
    @Autowired
    protected RestTemplate restTemplate;
    @Value("${spring.application.name}")
    protected String appName;

    /**
     * 所有子类暴露一个connection接口（目前用该方法用来测试当前访问与目标服务的连通性）
     *
     * @param nextAppName 要访问的服务名
     * @return
     */
    @GetMapping(value = "/connection/{nextAppName}")
    public CommonResult<String> connection(@PathVariable("nextAppName") String nextAppName) {
        if (nextAppName.equals(appName)) {
            return new CommonResult<>(50500, "recycle connect error", null);
        } else if (nextAppName.equals("end")) {
            return new CommonResult<>("connect success");
        } else {
            String url = "http://" + nextAppName + "/connection/end";
            CommonResult<?> targetResult = restTemplate.getForObject(url, CommonResult.class);
            String data = targetResult.getData() == null ? "" : targetResult.getData().toString();
            return new CommonResult<>(appName + " -> " + nextAppName + " : " + data);
        }
    }

    @Bean(value = "restTemplate")
    //@LoadBalanced注解如果不加，无法直接通过http://appName访问到对应的服务，要注意
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
