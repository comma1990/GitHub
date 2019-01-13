package commaTools.utils.comma;
/**
 * Junit单元测试
 * 单元测试方法编写规范：public void 方法名(){...}    必须是public，必须是void（没有返回值），方法体中不能有参数
 * @Test 单元测试用例
 * @Ignore 忽略执行的测试用例
 * @Before 每个单元测试之前都会执行的测试用例
 * @After 每个单元测试结束后都会执行的测试用例
 *
 * Assert方法：断言，如：Assert.assertEquals("期望值","实际结果值");
 */

import commaTools.utils.common.GetDate;
import commaTools.utils.common.MathUtils;
import commaTools.utils.common.RandomDataUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static commaTools.utils.common.HttpPostClient.getHttpResponse;

public class JunitTest {
    /**
     * GetDate方法单元测试
     */
    @Test
    public void getDateTest(){
        GetDate getDate=new GetDate();
        System.out.println(getDate.getNowDate());
    }

    /**
     * MathUtils方法单元测试
     */
    @Test
    public void mathUtils(){
        MathUtils mathUtils=new MathUtils();
        System.out.println(mathUtils.sum(1,2,2,4));
        /**
         * 使用断言测试结果是否符合预期：Assert
         */
        Assert.assertEquals(10,mathUtils.sum(1,2,2,4));//结果不符合预期
    }

    /**
     * RandomDataUtils单元测试
     */

    @Test
    public void randomDateUtilsTest(){
        RandomDataUtils randomDataUtils=new RandomDataUtils();
        System.out.println(randomDataUtils.getRandomIntNumber(10,21));
        System.out.println(randomDataUtils.getRandomMobile());
        System.out.println(randomDataUtils.getRandomLongNumber(10000,100000));
    }


    @Test
    public void HttpPostClient() throws MalformedURLException {
        URL url=new URL("http://renterapp.yuyanfd.com/recommend/getEstateNearbyHouse.rest");
        JSONObject object=new JSONObject();
        object.put("rentId","1695");
        System.out.println(getHttpResponse(url,object));
    }
}
