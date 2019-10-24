package com.bohui.wf.gps.website.webpage.service.impl;

import com.bohui.wf.gps.website.webpage.entity.WebDetail;
import com.bohui.wf.gps.website.webpage.entity.WebIndex;
import com.bohui.wf.gps.website.webpage.mapper.WebDetailMapper;
import com.bohui.wf.gps.website.webpage.mapper.WebIndexMapper;
import com.bohui.wf.gps.website.webpage.service.WebDetailService;
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
public class WebDetailServiceImpl extends ServiceImpl<WebDetailMapper, WebDetail> implements WebDetailService {

    @Autowired
    WebDetailMapper webDetailMapper;

    @Autowired
    WebIndexMapper webIndexMapper;

    @Override
    public List<WebDetail> getDetailsById(Integer id) {

        return webDetailMapper.selectAll(id);
    }

    @Override
    @Transactional
    public WebDetail updateDetail(WebDetail webDetail) {


          webDetailMapper.updateById(webDetail);

          if(webDetail.getPageId()==1){

              new WebIndex().setIndexContent(webDetail.getDetailTitle())
                            .setIndexLink(webDetail.getDetailLink())
                            .setIndexId(webDetail.getDetailLevel())
                            .setIndexRemark(webDetail.getDetailRemark())
                            .updateById();
          }


        webDetail = webDetailMapper.selectById(webDetail.getDetailId());

        return webDetail;
    }

    @Override
    public WebDetail selectOne(Integer detailId) {
        return webDetailMapper.selectById(detailId);
    }


}
