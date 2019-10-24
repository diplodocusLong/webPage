package com.bohui.wf.gps.website.webpage.service;

import com.bohui.wf.gps.website.webpage.entity.WebDetail;
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
public interface WebDetailService extends IService<WebDetail> {

    List<WebDetail> getDetailsById(Integer id );


    WebDetail updateDetail(WebDetail webDetail);

    WebDetail selectOne(Integer detailId);
}
