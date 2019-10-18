package com.bohui.wf.gps.website.webpage.controller;


import com.bohui.wf.gps.website.webpage.entity.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lianglong
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/sysLog")
@Slf4j
public class SysLogController {



    @GetMapping("/date")
    public SysLog getDate(@RequestBody SysLog sys){

        LocalDateTime createTime = sys.getCreateTime();

        System.out.println(createTime);

        sys.setUpdateTime(LocalDateTime.now());

        return sys;

    }

}

