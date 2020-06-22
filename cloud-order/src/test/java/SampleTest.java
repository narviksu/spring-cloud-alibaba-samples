import com.narvik.common.entity.Order;
import com.narvik.cloud.order.Application;
import com.narvik.cloud.order.dao.OrderDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author narvik
 * @Date 2020/6/18 22:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SampleTest {
    @Resource
    private OrderDao orderDao;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Order> list = orderDao.getBaseMapper().selectList(null);
        Assert.assertEquals(1, list.size());
        list.forEach(System.out::println);
        System.out.println(orderDao.count());
    }
}
