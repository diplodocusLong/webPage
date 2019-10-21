package com.bohui.wf.gps.website.webpage.service;

import com.bohui.wf.gps.website.webpage.entity.WebIndex;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lianglong
 * @since 2019-10-21
 */
public interface WebIndexService extends IService<WebIndex> {

    List<WebIndex> listPages();
}
