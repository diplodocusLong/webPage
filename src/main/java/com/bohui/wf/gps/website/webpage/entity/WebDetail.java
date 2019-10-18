package com.bohui.wf.gps.website.webpage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lianglong
 * @since 2019-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="WebDetail对象", description="")
public class WebDetail extends Model<WebDetail> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "序号")
    @TableId(value = "detail_id", type = IdType.AUTO)
    private Integer detailId;

    @ApiModelProperty(value = "父页面id")
    private Integer pageId;

    @ApiModelProperty(value = "标题")
    private String detailTitle;

    @ApiModelProperty(value = "副标题")
    private String detailSubtitle;

    @ApiModelProperty(value = "图片1")
    private String detailImage1;

    @ApiModelProperty(value = "图片2")
    private String detailImage2;

    @ApiModelProperty(value = "图片3")
    private String detailImage3;

    @ApiModelProperty(value = "内容")
    private String detailContent;

    @ApiModelProperty(value = "链接")
    private String detailLink;

    @ApiModelProperty(value = "排序")
    private Integer detailLevel;

    @ApiModelProperty(value = "状态，1为启用")
    private Integer detailStatus;

    @ApiModelProperty(value = "备注")
    private String detailRemark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.detailId;
    }

}
