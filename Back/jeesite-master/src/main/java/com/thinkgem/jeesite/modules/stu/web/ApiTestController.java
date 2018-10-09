package com.thinkgem.jeesite.modules.stu.web;

import com.thinkgem.jeesite.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


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
@RequestMapping(value = "${apiPath}")
public class ApiTestController extends BaseController {


    @ResponseBody
    @RequestMapping(value = {"list"})
    public Map list(HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        map.put("name", "zlg");
        map.put("age", 30);
        return map;
    }


}
