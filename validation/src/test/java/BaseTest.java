import com.xx.jersey.MyApplication;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Set;

/**
 * author: XiongXin
 * description: 测试基类，使用JerserTest
 * time: 2016/12/16.
 */
public class BaseTest extends JerseyTest{

    @Override
    protected Application configure() {
        return new MyApplication();
    }

    @Override
    protected void configureClient(ClientConfig config) {
        super.configureClient(config);
    }

    @Override
    protected URI getBaseUri() {
        return UriBuilder.fromUri(MyApplication.BASE_URI).build();
    }

    public void showResponseBody(Response response){
        String responseBodyStr = response.readEntity(String.class);
        System.out.println("Response Body is : \n" + responseBodyStr);
    }

    public void showResponseStatus(Response response){
        Integer status = response.getStatus();
        System.out.println("Response Status is: \n" + status);
    }

    public void showResponse(Response response){
        /**
         * 打印状态码
         */
        showResponseStatus(response);

        /**
         * 打印消息头
         */
        showResponseHeaders(response);

        /**
         * 打印响应消息体
         */
        showResponseBody(response);
    }

    public void showResponseHeaders(Response response){
        /**
         * 获取相应消息列表
         */
        MultivaluedMap<String, Object> headers = response.getHeaders();

        /**
         * 遍历map
         */
        Set<String> keys = headers.keySet();

        for( String key : keys ){
            Object value = headers.get(key);
            System.out.println("====> " + key + " : " + value);
        }
    }
}
