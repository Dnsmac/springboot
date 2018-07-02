package com.login;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.session.SessionProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    
    @Resource(name="smartkitJdbcTemplate")
    private JdbcTemplate Jdbc;
    
    
    @Resource(name="logCenterJdbcTemplate")
    private JdbcTemplate logCenter;
    
    @RequestMapping(value={"","/"})
    public String login(Model modal){
        modal.addAttribute("title", "标题");
        String queryForObject = Jdbc.queryForObject("select category_name from category_type where category_id = 6", String.class);
        String exception = logCenter.queryForObject("select type from yw_exception_day where id = 1592", String.class);
        modal.addAttribute("exception", exception);
        modal.addAttribute("hi", queryForObject);
        return "index";
    }

}
