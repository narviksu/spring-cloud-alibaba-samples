import com.narvik.cloud.product.Application;
import com.narvik.cloud.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/18 22:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SampleTest {
    @Resource
    ProductService productService;

    @Test
    public void testUpdateProductStock() {
        String userId = "1";
        Map<String, Integer> stockChangeMap = new HashMap<>();
        stockChangeMap.put("1", -1);
        System.out.println(productService.updateProductStock(userId, stockChangeMap));
    }
}
