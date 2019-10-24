package com.bohui.wf.gps.website.webpage.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bohui.wf.gps.website.webpage.entity.WebDetail;
import com.bohui.wf.gps.website.webpage.entity.WebIndex;
import com.bohui.wf.gps.website.webpage.mapper.WebDetailMapper;
import com.bohui.wf.gps.website.webpage.mapper.WebIndexMapper;
import com.bohui.wf.gps.website.webpage.service.WebIndexService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lianglong
 * @since 2019-10-21
 */
@Service
public class WebIndexServiceImpl extends ServiceImpl<WebIndexMapper, WebIndex> implements WebIndexService {

    @Autowired
    WebIndexMapper webIndexMapper;

    @Autowired
    WebDetailMapper webDetailMapper;

    public List<WebIndex> listPages() {

        return webIndexMapper.selectList(null);
    }

    @Override
    public WebIndex addpage(WebIndex webIndex) {

         webIndexMapper.insert(webIndex);


        return webIndexMapper.selectById(webIndex.getIndexId());
    }

    @Override
    public WebIndex selectIndexById(Integer indexId) {

        return webIndexMapper.selectById(indexId);
    }

    @Override
    @Transactional
    public WebIndex updateWebIndex(WebIndex webIndex) {

        webIndexMapper.updateById(webIndex);

        new WebDetail().setDetailLink(webIndex.getIndexLink())
                .setDetailTitle(webIndex.getIndexContent())
                .setDetailRemark(webIndex.getIndexRemark())
                .update(
                        new UpdateWrapper<WebDetail>().eq("detail_level", webIndex.getIndexId())
                                .eq("page_id", 1)
                );


        return webIndexMapper.selectById(webIndex.getIndexId());
    }
}
