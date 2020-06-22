package com.narvik.cloud.index.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.narvik.common.base.BaseController;
import com.narvik.common.entity.CommonResult;
import com.narvik.common.entity.dto.PurchaseDto;
import com.narvik.cloud.index.service.IndexService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author narvik
 * @Date 2020/5/8 18:11
 */
@RestController
public class IndexController extends BaseController {
    @Resource
    private IndexService indexService;

    @PostMapping(value = "/purchase")
    @SentinelResource(value = "purchase", blockHandlerClass = IndexResourceHandler.class, blockHandler = "handlePurchase", fallbackClass = IndexResourceHandler.class, fallback = "fallbackPurchase")
    public CommonResult<String> purchase(@RequestBody PurchaseDto dto) {
        return new CommonResult<>(indexService.purchase(dto.getUserId(), dto.getStockChangeMap()));
    }

}
