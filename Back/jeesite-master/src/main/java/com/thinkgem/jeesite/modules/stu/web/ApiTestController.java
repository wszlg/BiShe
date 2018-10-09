package com.thinkgem.jeesite.modules.stu.web;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zuser.entity.ZUser;
import com.thinkgem.jeesite.modules.zuser.service.ZUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 *
 */


/**
 *


 CREATE TABLE `z_user` (
 `id` varchar(64) NOT NULL,
 `name` varchar(255) DEFAULT NULL,
 `age` int(11) DEFAULT NULL,
 `sex` int(1) DEFAULT NULL,
 `password` varchar(255) NOT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表'


 *
 */


@Controller
@RequestMapping(value = "${apiPath}/user")
public class ApiTestController extends BaseController {


    @Autowired
    private ZUserService zUserService;


    @ResponseBody
    @RequestMapping(value = {"login"}, method = RequestMethod.GET)
    public Map login(String username, String password) {

        Map map = new HashMap();

        ZUser zUser = new ZUser();
        zUser.setName(username);
        zUser.setPassword(password);
        List<ZUser> list = zUserService.findList(zUser);

        if (list.size() > 0) {
            map.put("status", 1);
        } else  {
            map.put("status", 0);

        }
        return map;
    }


    @ResponseBody
    @RequestMapping(value = {"register"}, method = RequestMethod.GET)
    public Map register(String username, String password) {

//        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        Map map = new HashMap();

        ZUser zUser = new ZUser();
        zUser.setName(username);
//        zUser.setPassword(password);
        List<ZUser> list = zUserService.findList(zUser);

        if (list.size() > 0) {
            map.put("status", 0);
            map.put("message", "该用户已被注册");
        } else  {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            zUser.setId(uuid);
            zUser.setIsNewRecord(true);
            zUserService.save(zUser);
            map.put("status", 1);
            map.put("message", "注册成功");
        }
        return map;
    }


}
