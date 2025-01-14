package org.example.controller;


import com.alibaba.fastjson.JSONObject;
import org.example.domian.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

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


    private HashMap<Integer, SysUser> map = new HashMap<Integer, SysUser>();

    private AtomicInteger count =  new AtomicInteger(0);
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


    @PostMapping(value = "user")
    public JSONResult create() throws Exception {
        SysUser user = new SysUser();
        Integer id = count.get();
        user.setId(id);
        user.setUsername("spring boot" + new Date());
        user.setNickname("spring boot" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        map.put(id, user);
        return JSONResult.ok("保存成功");
    }

    @PutMapping(value = "user")
    public JSONResult update(SysUser user) {

        map.put(user.getId(), user);
        return JSONResult.ok("保存成功");
    }


    @DeleteMapping("user/{userId}")
    public JSONResult delete(@PathVariable String userId) {
        map.remove(userId);
        return JSONResult.ok("删除成功");
    }

    @GetMapping("user/{userId}")
    public JSONResult queryUserById(@PathVariable String userId) {
        return JSONResult.ok(map.get(userId));
    }



}

