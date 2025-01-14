package org.example.controller;


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
@RequestMapping("/api/users")
public class UserController {
    /**
    * 服务对象
    */
//    @Autowired
//    private  UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public JSONObject register(String username, String password, String email, String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put( "status", "success");
        jsonObject.put("message", "User registered successfully");
        return jsonObject;
    }


    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(String username, String password){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put( "status", "success");
        jsonObject.put("token", "jwt_token_here");
        return jsonObject;
    }

}

