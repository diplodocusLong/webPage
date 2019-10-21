package com.bohui.wf.gps.website.webpage.service.impl;

import com.bohui.wf.gps.website.webpage.entity.WebIndex;
import com.bohui.wf.gps.website.webpage.mapper.WebIndexMapper;
import com.bohui.wf.gps.website.webpage.service.WebIndexService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lianglong
 * @since 2019-10-21
 */
@Service
public class WebIndexServiceImpl extends ServiceImpl<WebIndexMapper, WebIndex> implements WebIndexService {

    @Autowired
    WebIndexMapper webIndexMapper;

    public List<WebIndex> listPages() {

      return   webIndexMapper.selectList(null);
    }
}
