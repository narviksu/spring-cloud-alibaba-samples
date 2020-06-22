import com.narvik.cloud.index.Application;
import com.narvik.cloud.index.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/19 18:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SampleTest {
    @Resource
    IndexService indexService;

    //@Test
    public void testGlobalTransactional1() {
        String userId = "1";//为1时会触发创建订单报错，触发全局事务回滚
        Map<String, Integer> stockChangeMap = new HashMap<>();
        stockChangeMap.put("1", 1);
        indexService.purchase(userId, stockChangeMap);
    }

    @Test
    public void testGlobalTransactional2() {
        String userId = "2";//正常创建，事务正常提交
        Map<String, Integer> stockChangeMap = new HashMap<>();
        stockChangeMap.put("1", 1);
        indexService.purchase(userId, stockChangeMap);
    }
}
