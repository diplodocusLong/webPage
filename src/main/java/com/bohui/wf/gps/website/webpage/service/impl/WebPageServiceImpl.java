package com.bohui.wf.gps.website.webpage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bohui.wf.gps.website.webpage.entity.WebDetail;
import com.bohui.wf.gps.website.webpage.entity.WebPage;
import com.bohui.wf.gps.website.webpage.mapper.WebDetailMapper;
import com.bohui.wf.gps.website.webpage.mapper.WebPageMapper;
import com.bohui.wf.gps.website.webpage.service.WebPageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lianglong
 * @since 2019-10-10
 */
@Service
public class WebPageServiceImpl extends ServiceImpl<WebPageMapper, WebPage> implements WebPageService {


    @Autowired
    WebPageMapper webPageMapper;
    
    @Autowired
    WebDetailMapper webDetailMapper;

    @Override
    @Transactional(readOnly = true)
    public List<WebPage> fondPage() {
        List<WebPage> webPages = webPageMapper.selectList(null);

        QueryWrapper<WebPage> webPageQueryWrapper = new QueryWrapper<>();

        for (WebPage webPage : webPages) {

            List<WebDetail> webDetails = webDetailMapper.selectList(new QueryWrapper<WebDetail>().eq("page_id", webPage.getPageId()));

            webPage.setWebDetails(webDetails);
        }
        return webPages;
    }
}
