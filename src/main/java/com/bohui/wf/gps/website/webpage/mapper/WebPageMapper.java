package com.bohui.wf.gps.website.webpage.mapper;

import com.bohui.wf.gps.website.webpage.entity.WebPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lianglong
 * @since 2019-10-21
 */
public interface WebPageMapper extends BaseMapper<WebPage> {

    List<WebPage> selectAll(Integer id);
}
