package com.bohui.wf.gps.website.webpage.controller;


import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.WebDetail;
import com.bohui.wf.gps.website.webpage.service.WebDetailService;
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
 * @since 2019-10-21
 */
@RestController
@Api(value = "模块详情", tags = {"模块详情"})
@RequestMapping("/webDetail")
public class WebDetailController {

    @Autowired
    WebDetailService webDetailService;

    @ApiOperation("根据模块id查询 模块的详细内容")
    @ApiImplicitParam(name = "pageId", value = "模块的id", required = true)
    @GetMapping("/manager/list/{pageId}")
    public Result listDetailById(@PathVariable Integer pageId) {

        List<WebDetail> detailsById = webDetailService.getDetailsById(pageId);

        return Result.OK().setData(detailsById);
    }

    @ApiOperation("修改模块元素")
    @ApiImplicitParam(paramType = "WebDetail")
    @PutMapping("/manager")
    public Result disable(@RequestBody WebDetail webDetail) {

         webDetail = webDetailService.updateDetail(webDetail);

        return Result.OK().setData(webDetail);
    }


    @ApiOperation("根据detailId查询信息")
    @ApiImplicitParam(name = "detailId",value = "模块元素id",required = true)
    @GetMapping("/manager/{detailId}")
    public Result disable( @PathVariable Integer detailId) {

      WebDetail  webDetail = webDetailService.selectOne(detailId);

        return Result.OK().setData(webDetail);
    }



}

