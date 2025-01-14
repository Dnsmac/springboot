package org.example.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Monster
 * @since 2025-01-14
 */
@RestController
@RequestMapping("/api")
public class ResourceController {

    @RequestMapping("/resources")
    @ResponseBody
    public JSONObject resources(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put( "status", "success");
        JSONArray arr=  new JSONArray();
        JSONObject jsonO = new JSONObject();
        jsonO.put("id", 1);
        jsonO.put("name", "Article 1");
        jsonO.put(  "url","https://example.com/article1");
        jsonO.put( "type","article");
        arr.add(jsonO);


        JSONObject json2 = new JSONObject();
        jsonO.put("id", 2);
        jsonO.put("name", "Article 2");
        jsonO.put(  "url","https://example.com/article1");
        jsonO.put( "type","article");
        arr.add(json2);
        jsonObject.put("token", "jwt_token_here");
        jsonObject.put("data", arr);
        return jsonObject;
    }
}

