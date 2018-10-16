package com.thinkgem.jeesite.modules.stu.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zcoll.entity.ZCollect;
import com.thinkgem.jeesite.modules.zcoll.service.ZCollectService;
import com.thinkgem.jeesite.modules.zhum.entity.ZHum;
import com.thinkgem.jeesite.modules.zhum.service.ZHumService;
import com.thinkgem.jeesite.modules.zjmna.entity.ZJmna;
import com.thinkgem.jeesite.modules.zjmna.service.ZJmnaService;
import com.thinkgem.jeesite.modules.znews.entity.ZNews;
import com.thinkgem.jeesite.modules.znews.service.ZNewsService;
import com.thinkgem.jeesite.modules.zrec.entity.ZRec;
import com.thinkgem.jeesite.modules.zrec.service.ZRecService;
import com.thinkgem.jeesite.modules.ztec.entity.ZTec;
import com.thinkgem.jeesite.modules.ztec.service.ZTecService;
import com.thinkgem.jeesite.modules.zuser.entity.ZUser;
import com.thinkgem.jeesite.modules.zuser.service.ZUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;


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


// 建表模型


 CREATE TABLE `test_tree` (
 `id` varchar(64)   NOT NULL COMMENT '编号',
 `create_by` varchar(64)   NOT NULL COMMENT '创建者',
 `create_date` datetime NOT NULL COMMENT '创建时间',
 `update_by` varchar(64)   NOT NULL COMMENT '更新者',
 `update_date` datetime NOT NULL COMMENT '更新时间',
 `remarks` varchar(255)   DEFAULT NULL COMMENT '备注信息',
 `del_flag` char(1)   NOT NULL DEFAULT '0' COMMENT '删除标记',
 PRIMARY KEY (`id`),
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='树结构表'



 CREATE TABLE `z_news` (
 `title` varchar(255)   DEFAULT NULL COMMENT '新闻标题',
 `picurl` varchar(255)   DEFAULT NULL COMMENT '图片地址',
 `content` varchar(255)   DEFAULT NULL COMMENT '新闻详情',

 `id` varchar(64)   NOT NULL COMMENT '编号',
 `create_by` varchar(64)   NOT NULL COMMENT '创建者',
 `create_date` datetime NOT NULL COMMENT '创建时间',
 `update_by` varchar(64)   NOT NULL COMMENT '更新者',
 `update_date` datetime NOT NULL COMMENT '更新时间',
 `remarks` varchar(255)   DEFAULT NULL COMMENT '备注信息',
 `del_flag` char(1)   NOT NULL DEFAULT '0' COMMENT '删除标记',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻表'



 CREATE TABLE `z_collect` (
 `userid` varchar(64)   DEFAULT NULL COMMENT '用户id',
 `type` varchar(1)   DEFAULT NULL COMMENT '类型',
 `news_id` varchar(64)   DEFAULT NULL COMMENT '新闻id',

 `id` varchar(64)   NOT NULL COMMENT '编号',
 `create_by` varchar(64)   DEFAULT 'dddd' COMMENT '创建者',
 `create_date` datetime NOT NULL COMMENT '创建时间',
 `update_by` varchar(64)   DEFAULT 'ddddd' COMMENT '更新者',
 `update_date` datetime NOT NULL COMMENT '更新时间',
 `remarks` varchar(255)   DEFAULT NULL COMMENT '备注信息',
 `del_flag` char(1)   NOT NULL DEFAULT '0' COMMENT '删除标记',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表'




 *
 */


@Controller
@RequestMapping(value = "${apiPath}/user")
public class ApiTestController extends BaseController {


    @Autowired
    private ZUserService zUserService;

    @Autowired
    private ZNewsService zNewsService;

    @Autowired
    private ZTecService zTecService;

    @Autowired
    private ZHumService zHumService;

    @Autowired
    private ZJmnaService zJmnaService;

    @Autowired
    private ZRecService zRecService;

    @Autowired
    private ZCollectService zCollectService;



    @ResponseBody
    @RequestMapping(value = {"collect"}, method = RequestMethod.GET)
    public Map collect(String userid, String type, String id) {

        Map map = new HashMap();

        ZCollect zCollect = new ZCollect();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        zCollect.setIsNewRecord(true);
        zCollect.setId(uuid);
        zCollect.setNewsId(id);
        zCollect.setUserid(userid);
        zCollect.setType(type);

        zCollectService.save(zCollect);


        return map;
    }


    @ResponseBody
    @RequestMapping(value = {"getCollect"}, method = RequestMethod.GET)
    public Map getCollect(String userid, String type, String id) {

        Map map = new HashMap();

        ZCollect zCollect = new ZCollect();
        zCollect.setUserid(userid);

        List<ZCollect> list1 = zCollectService.findList(zCollect);

        List list = new ArrayList();

//        List<ZNews> newsList = zNewsService.findList(new ZNews());
//        List<ZTec> zTecList = zTecService.findList(new ZTec());
//        List<ZHum> zHumslist = zHumService.findList(new ZHum());
//        List<ZJmna> zJmnaList = zJmnaService.findList(new ZJmna());


        for (ZCollect zCollect1 : list1) {

            switch (Integer.valueOf(zCollect1.getType())) {
                case 0:
                {
                    ZNews zNews = new ZNews();
                    zNews.setId(zCollect1.getNewsId());
                    List<ZNews> list2 = zNewsService.findList(zNews);
                    if (list2.size() > 0) {
                        ZNews zNews1 = list2.get(0);
                        zNews1.setType("0");
                        list.add(zNews1);
                    }

                    break;
                }
                case 1:
                {
                    ZTec zNews = new ZTec();
                    zNews.setId(zCollect1.getNewsId());
                    List<ZTec> list2 = zTecService.findList(zNews);
                    if (list2.size() > 0) {
                        ZTec zNews1 = list2.get(0);
                        zNews1.setType("1");
                        list.add(zNews1);
                    }
                    break;
                }

                case 2:
                {
                    ZHum zNews = new ZHum();
                    zNews.setId(zCollect1.getNewsId());
                    List<ZHum> list2 = zHumService.findList(zNews);
                    if (list2.size() > 0) {
                        ZHum zNews1 = list2.get(0);
                        zNews1.setType("2");
                        list.add(zNews1);
                    }
                    break;
                }

                case 3:
                {
                    ZJmna zNews = new ZJmna();
                    zNews.setId(zCollect1.getNewsId());
                    List<ZJmna> list2 = zJmnaService.findList(zNews);
                    if (list2.size() > 0) {
                        ZJmna zNews1 = list2.get(0);
                        zNews1.setType("3");
                        list.add(zNews1);
                    }
                    break;
                }


            }
        }


        map.put("list", list);



        return map;
    }


    @ResponseBody
    @RequestMapping(value = {"recAddCount"}, method = RequestMethod.GET)
    public Map recAddCount(String userid, String type, HttpServletRequest request, HttpServletResponse response) {

        Map map = new HashMap();

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        ZRec zRec = new ZRec();
        zRec.setIsNewRecord(true);
        zRec.setId(uuid);
        zRec.setUserid(userid);
        zRec.setType(type);
        zRec.setCount("1");
        zRecService.save(zRec);

        return map;
    }


    @ResponseBody
    @RequestMapping(value = {"login"}, method = RequestMethod.GET)
    public Map login(String username, String password, HttpServletRequest request, HttpServletResponse response) {

        Map map = new HashMap();

        ZUser zUser = new ZUser();
        zUser.setName(username);
        zUser.setPassword(password);
//        List<ZUser> list = zUserService.findList(zUser);


        Page<ZUser> page = zUserService.findPage(new Page<ZUser>(request, response), zUser);


        if (page.getList().size() > 0) {
            map.put("status", 1);
            map.put("user", page.getList().get(0));

        } else  {
            map.put("status", 0);
            map.put("user", "");
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
        zUser.setPassword(password);
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
            map.put("user", zUser);
        }
        return map;
    }



    @ResponseBody
    @RequestMapping(value = {"getNews"}, method = RequestMethod.GET)
    public Map getNews(@ModelAttribute("zNews") ZNews zNews, HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        Page<ZNews> page = zNewsService.findPage(new Page<ZNews>(request, response), zNews);
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        Page p = new Page(pageNo, pageSize,page.getCount());
        Page<ZNews> page1 = zNewsService.findPage(p, zNews);
        for (ZNews zNews1 : page1.getList()) {
            zNews1.setType("0");
        }
        map.put("list", page1.getList());
        return map;
    }


    @ResponseBody
    @RequestMapping(value = {"getTec"}, method = RequestMethod.GET)
    public Map getTec(@ModelAttribute("zTec") ZTec zTec, HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        Page<ZTec> page = zTecService.findPage(new Page<ZTec>(request, response), zTec);
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        Page p = new Page(pageNo, pageSize,page.getCount());
        Page<ZTec> page1 = zTecService.findPage(p, zTec);
        for (ZTec zTec1 : page1.getList()) {
            zTec1.setType("1");
        }
        map.put("list", page1.getList());
        return map;
    }


    @ResponseBody
    @RequestMapping(value = {"getHum"}, method = RequestMethod.GET)
    public Map getHum(@ModelAttribute("zHum") ZHum zHum, HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        Page<ZHum> page = zHumService.findPage(new Page<ZHum>(request, response), zHum);
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        Page p = new Page(pageNo, pageSize,page.getCount());
        Page<ZHum> page1 = zHumService.findPage(p, zHum);
        for (ZHum zTec1 : page1.getList()) {
            zTec1.setType("2");
        }
        map.put("list", page1.getList());
        return map;
    }


    @ResponseBody
    @RequestMapping(value = {"getJman"}, method = RequestMethod.GET)
    public Map getJman(@ModelAttribute("zJmna") ZJmna zJmna, HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        Page<ZJmna> page = zJmnaService.findPage(new Page<ZJmna>(request, response), zJmna);
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        Page p = new Page(pageNo, pageSize,page.getCount());
        Page<ZJmna> page1 = zJmnaService.findPage(p, zJmna);
        for (ZJmna zTec1 : page1.getList()) {
            zTec1.setType("3");
        }
        map.put("list", page1.getList());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = {"getRecommand"}, method = RequestMethod.GET)
    public Map getRecommand(HttpServletRequest request, HttpServletResponse response, String userid) {
        Map map = new HashMap();

        List list = new ArrayList();




        List<ZNews> newsList = zNewsService.findList(new ZNews());
        List<ZTec> zTecList = zTecService.findList(new ZTec());
        List<ZHum> zHumslist = zHumService.findList(new ZHum());
        List<ZJmna> zJmnaList = zJmnaService.findList(new ZJmna());






        int size = zRecService.findList(new ZRec(userid, "0")).size();
        int size1 = zRecService.findList(new ZRec(userid, "1")).size();
        int size2 = zRecService.findList(new ZRec(userid, "2")).size();
        int size3 = zRecService.findList(new ZRec(userid, "3")).size();


//        List list1 = new

        int totalCount = size + size1 + size2 + size3;


        int[] list0 = {size, size1, size2, size3};
        int num = list0[0];
        int index = 0;
        for (int i = 0; i < list0.length; i++) {
            if (list0[i] > num) {
                num = list0[i];
            }
        }
        for (int i = 0; i < list0.length; i++) {
            if (list0[i] == num) {
                index = i;
            }
        }


        if (totalCount != 0) {
            switch (index) {
                case 0:
                {
                    for (ZNews zNews : newsList) {
                        zNews.setType("0");
                        list.add(zNews);
                    }
                    break;
                }

                case 1:
                {
                    for (ZTec zNews : zTecList) {
                        zNews.setType("1");
                        list.add(zNews);
                    }
                    break;
                }

                case 2:
                {
                    for (ZHum zNews : zHumslist) {
                        zNews.setType("2");
                        list.add(zNews);
                    }
                    break;
                }

                case 3:

                {
                    for (ZJmna zNews : zJmnaList) {
                        zNews.setType("3");
                        list.add(zNews);
                    }
                    break;
                }


            }
        }





        Random rand = new Random();
        for (int i = 0; i < newsList.size() + zTecList.size() + zHumslist.size() + zJmnaList.size(); i++) {

            ZNews zNews = newsList.get(rand.nextInt(newsList.size()));
            zNews.setType("0");
            list.add(zNews);

            ZTec zTec = zTecList.get(rand.nextInt(zTecList.size()));
            zTec.setType("1");
            list.add(zTec);

            ZHum zHum = zHumslist.get(rand.nextInt(zHumslist.size()));
            zHum.setType("2");
            list.add(zHum);

            ZJmna zJmna = zJmnaList.get(rand.nextInt(zJmnaList.size()));
            zJmna.setType("3");
            list.add(zJmna);

        }


        map.put("list", list);

        return map;
    }

}















