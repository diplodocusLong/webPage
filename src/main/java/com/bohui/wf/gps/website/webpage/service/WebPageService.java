package com.bohui.wf.gps.website.webpage.service;

import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.WebPage;
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
public interface WebPageService extends IService<WebPage> {

    List<WebPage> fondPage(Integer id);

    WebPage getNavigation();

    List<WebPage> listPage(Integer id);

    WebPage updateWebpage(WebPage webPage);

    WebPage addWebpage(WebPage webPage);

}
