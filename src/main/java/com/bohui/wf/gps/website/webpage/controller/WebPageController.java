package com.bohui.wf.gps.website.webpage.controller;


import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.WebPage;
import com.bohui.wf.gps.website.webpage.service.WebPageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lianglong
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/webPage")
@Api(tags = {"模块"})
public class WebPageController {

    @Autowired
    WebPageService webPageService;


    /**
     * 首页资源
     *
     * @return
     */
    @GetMapping("/list/{indexId}")
    @ApiOperation(value = "根据页面id查询启用的模块信息")
    @ApiImplicitParam(name = "indexId", value = "页面id", required = true)
    public Result getPage(@PathVariable Integer indexId) {

        List<WebPage> webPages = webPageService.fondPage(indexId);

        return Result.OK().setData(webPages);

    }


    @ApiOperation(value = "根据页面id查询所有的模块信息")
    @ApiImplicitParam(name = "indexId", value = "页面id", required = true)
    @GetMapping("/manager/list/{indexId}")
    public Result getPageByManager(@PathVariable Integer indexId) {

        List<WebPage> webPages = webPageService.listPage(indexId);

        return Result.OK().setData(webPages);

    }


    @GetMapping("/navigation")
    @ApiOperation(value = "查询导航栏信息")
    public Result getNavigation() {

        WebPage navigation = webPageService.getNavigation();

        return Result.OK().setData(navigation);
    }


    @PutMapping("/manager")
    @ApiOperation(value = "修改模块信息")
    @ApiImplicitParam(paramType = "WebPage")
    public Result updateSite(@RequestBody WebPage webPage) {

        webPage = webPageService.updateWebpage(webPage);

        return Result.OK().setData(webPage);
    }

    @PostMapping("/manager")
    @ApiOperation(value = "添加模块信息")
    @ApiImplicitParam(paramType = "WebPage")
    public Result addWebpag(@RequestBody WebPage webPage) {

        webPage =  webPageService.addWebpage(webPage);

        return Result.OK().setData(webPage);
    }


}

