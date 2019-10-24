package com.bohui.wf.gps.website.webpage.controller;


import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.WebIndex;
import com.bohui.wf.gps.website.webpage.service.WebIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "页面操作",tags = {"页面"})
public class WebIndexController {

    @Autowired
    WebIndexService webIndexService;

    @ApiOperation(value="查询所有页面相关信息")
    @GetMapping("/manager/pages")
    public Result getPages() {

        List<WebIndex> webIndices = webIndexService.listPages();

        return Result.OK().setData(webIndices);

    }


    @PostMapping("/manager")
    @ApiOperation(value ="管理员新增一个页面信息或导航")
    @ApiImplicitParam(paramType = "WebIndex",value = "添加时间和更新时间不需要填写")
    public Result addPage(@RequestBody WebIndex webIndex){

        webIndex =  webIndexService.addpage(webIndex);


        return Result.OK().setData(webIndex);
    }


    @GetMapping("/manager/{indexId}")
    @ApiOperation(value ="查询一个页面的描述信息")
    @ApiImplicitParam(name = "indexId",value = "页面编号")
    public Result getOne( @PathVariable Integer indexId){

       WebIndex webIndex = webIndexService.selectIndexById(indexId);

        return Result.OK().setData(webIndex);
    }


    @PutMapping("/manager")
    @ApiOperation(value ="修改页面描述信息")
    @ApiImplicitParam(paramType = "WebIndex",value = "添加时间和更新时间不需要填写")
    public Result updateOne( @RequestBody WebIndex webIndex){

        webIndex = webIndexService.updateWebIndex(webIndex);

        return Result.OK().setData(webIndex);
    }


















}

