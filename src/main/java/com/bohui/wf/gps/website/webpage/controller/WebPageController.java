package com.bohui.wf.gps.website.webpage.controller;


import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.WebPage;
import com.bohui.wf.gps.website.webpage.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lianglong
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/webPage")
public class WebPageController {

    @Autowired
    WebPageService webPageService;


    /**
     * 首页资源
     * @return
     */
    @GetMapping("/index/{id}")
    public Result getPage(@PathVariable Integer id){

        List<WebPage> webPages = webPageService.fondPage(id);

        return Result.OK().setData(webPages);

    }



    @GetMapping("/manager/index/{id}")
    public Result getPageByManager(@PathVariable Integer id){

        List<WebPage> webPages = webPageService.listPage(id);

        return Result.OK().setData(webPages);

    }



    @GetMapping("/navigation")
    public Result getNavigation(){

        WebPage navigation = webPageService.getNavigation();

        return Result.OK().setData(navigation);
    }





    @PutMapping("/delete/{id}")
    public Result updateSite(@PathVariable Integer id){

        webPageService.updateSite(id);
        return null;
    }
}

