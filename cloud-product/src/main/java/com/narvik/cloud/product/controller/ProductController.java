package com.narvik.cloud.product.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.narvik.cloud.base.BaseController;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.common.entity.dto.ProductStockUpdateDto;
import com.narvik.cloud.constant.TestResources;
import com.narvik.cloud.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author narvik
 * @Date 2020/5/8 18:11
 */
@RestController
public class ProductController extends BaseController {
    @Resource
    ProductService productService;

    @GetMapping(value = "/product/{id}")
    @SentinelResource(value = "getProduct", blockHandlerClass = ProductResourceHandler.class, blockHandler = "handleGetProduct", fallbackClass = ProductResourceHandler.class, fallback = "fallbackGetProduct")
    public CommonResult<Product> getProduct(@PathVariable("id") String id) {
        //测试sentinel fallback
        if ("0".equals(id)) {
            throw new IllegalArgumentException("test error");
        }
        Product product = TestResources.TEST_PRODUCTS.get(id);
        return new CommonResult<>(200, "success", product);
    }

    /**
     * 更新商品库存
     *
     * @param dto 更新商品库存参数，详情看class
     * @return 提示信息
     */
    @PutMapping(value = "/product/stock")
    @SentinelResource(value = "updateProductStock", blockHandlerClass = ProductResourceHandler.class, blockHandler = "handleUpdateProductStock", fallbackClass = ProductResourceHandler.class, fallback = "fallbackUpdateProductStock")
    public CommonResult<String> updateProductStock(@RequestBody ProductStockUpdateDto dto) {
        return new CommonResult<>(productService.updateProductStock(dto.getUserId(), dto.getStockChangeMap()));
    }

}
