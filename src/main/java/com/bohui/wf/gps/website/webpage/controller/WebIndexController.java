package com.bohui.wf.gps.website.webpage.controller;


import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.WebIndex;
import com.bohui.wf.gps.website.webpage.service.WebIndexService;
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
 * @since 2019-10-21
 */

@RestController
@RequestMapping("/webIndex")
public class WebIndexController {

    @Autowired
    WebIndexService webIndexService;


    @GetMapping("/pages")
    public Result getPages() {

        List<WebIndex> webIndices = webIndexService.listPages();

        return Result.OK().setData(webIndices);

    }

}

