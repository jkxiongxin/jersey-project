import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * author: XiongXin
 * description: 测试验证资源
 * time: 2016/12/16.
 */
public class ValidationResourceTest extends BaseTest {

    @Test
    public void testValidation(){
        baseRequest(MediaType.TEXT_HTML_TYPE);
    }

    private void baseRequest(MediaType agreeType){
        final Response response = target().path("demo/xiongxin").request(agreeType).get();
        showResponse(response);
    }

    @Test
    public void testValidationJSON(){
        baseRequest(MediaType.APPLICATION_JSON_TYPE);
    }

    @Test
    public void testValidationXML(){
        baseRequest(MediaType.APPLICATION_XML_TYPE);
    }

    @Test
    public void testValidationPlain(){
        baseRequest(MediaType.TEXT_PLAIN_TYPE);
    }
}
