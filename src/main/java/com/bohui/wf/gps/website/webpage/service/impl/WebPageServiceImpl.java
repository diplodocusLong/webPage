package com.bohui.wf.gps.website.webpage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bohui.wf.gps.website.webpage.entity.Result;
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
 * @since 2019-10-21
 */
@Service
public class WebPageServiceImpl extends ServiceImpl<WebPageMapper, WebPage> implements WebPageService {


    @Autowired
    WebPageMapper webPageMapper;

    @Autowired
    WebDetailMapper webDetailMapper;

    @Override
    @Transactional(readOnly = true)
    public List<WebPage> fondPage(Integer id) {
        List<WebPage> webPages = webPageMapper.selectList(new QueryWrapper<WebPage>().eq("index_id",id).eq("page_status",1));


        for (WebPage webPage : webPages) {

            List<WebDetail> webDetails = webDetailMapper.selectList(
                    new QueryWrapper<WebDetail>().eq("page_id", webPage.getPageId()).eq("page_status",1));

            webPage.setWebDetails(webDetails);
        }
        return webPages;
    }


    @Override
    public Result updateSite(Integer id) {

        return null;
    }

    @Override
    public WebPage getNavigation() {

        WebPage navigation = webPageMapper.selectOne(new QueryWrapper<WebPage>().eq("index_id", 0));

        List<WebDetail> webDetails = webDetailMapper.selectList(new QueryWrapper<WebDetail>().eq("page_id", navigation.getPageId()));

        navigation.setWebDetails(webDetails);

        return navigation;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WebPage> listPage(Integer id) {

        List<WebPage> webPages = webPageMapper.selectAll(id);

        if(id==1){

            WebPage webPage = webPageMapper.selectById(1);

            webPages.add(webPage);

        }


/*        for (WebPage webPage : webPages) {

            List<WebDetail> webDetails = webDetailMapper.selectAll(id);

            webPage.setWebDetails(webDetails);
        }*/
        return webPages;




    }

    @Override
    @Transactional
    public WebPage updateWebpage(WebPage webPage) {

         webPageMapper.updateById(webPage);


       return  webPageMapper.selectById(webPage.getPageId());
    }

    @Override
    public WebPage addWebpage(WebPage webPage) {

         webPageMapper.insert(webPage);

        return webPage;
    }


}
