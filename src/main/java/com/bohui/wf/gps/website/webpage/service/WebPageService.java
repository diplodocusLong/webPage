package com.bohui.wf.gps.website.webpage.service;

import com.bohui.wf.gps.website.webpage.entity.WebPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lianglong
 * @since 2019-10-10
 */
public interface WebPageService extends IService<WebPage> {

    List<WebPage> fondPage();
}
