package com.example.demo.Controller;

import com.example.demo.util.FirstCharUtil;
import com.example.demo.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(tags = "登录模块")
public class Login {
    @GetMapping("/login")
    @ApiOperation("登录操作")
    public String logins(){
            String host = "http://aliyunverifyidcard.haoservice.com";
            String path = "/idcard/VerifyIdcardv2";
            String method = "GET";
            String appcode = "b8b0ab7c26ad4d7098023563addc1e6c";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("cardNo", "510125199902285820");
            querys.put("realName", "胡晓琴");


            try {
                /**
                 * 重要提示如下:
                 * HttpUtils请从
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                 * 下载
                 *
                 * 相应的依赖请参照
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                 */
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(response.toString());

                //获取response的body
               System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {

                e.printStackTrace();
            }

        return "/logins.html";


    }
}
