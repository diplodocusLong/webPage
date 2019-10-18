package com.bohui.wf.gps.website.webpage.controller;


import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.WebPage;
import com.bohui.wf.gps.website.webpage.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lianglong
 * @since 2019-10-10
 */
@CrossOrigin
@RestController
@RequestMapping("/webPage")
public class WebPageController {

    @Autowired
    WebPageService webPageService;


    /**
     * 首页资源
     * @return
     */
    @GetMapping("/index")
    public Result getPage(){

        List<WebPage> webPages = webPageService.fondPage();

        return Result.OK().setData(webPages);

    }
}

