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
            //延迟，进行响应时间相关的熔断测试
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new CommonResult<>("connect success");
        } else {
            //当路由为 appName/connection/appName 这种连接自身的情况定义为不再连接新的服务
            String url = "http://" + nextAppName + "/connection/" + nextAppName;
            CommonResult<?> targetResult = restTemplate.getForObject(url, CommonResult.class);
            String data = targetResult == null || targetResult.getData() == null ? "" : targetResult.getData().toString();
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
