package com.bohui.wf.gps.website.webpage.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

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
@ApiModel(value="WebPage对象", description="")
public class WebPage extends Model<WebPage> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "序号")
    @TableId(value = "page_id", type = IdType.AUTO)
    private Integer pageId;

    @ApiModelProperty(value = "类型(英文code)")
    private String pageType;

    @ApiModelProperty(value = "标题")
    private String pageTitle;

    @ApiModelProperty(value = "排序")
    private Integer pageLevel;

    @ApiModelProperty(value = "备注")
    private String pageRemark;

    @ApiModelProperty(value = "状态，1为启用")
    @TableLogic(value = "1",delval = "0")
    private Integer pageStatus;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value="详细信息")
    @TableField(exist = false)
    private List<WebDetail> webDetails;

    @Override
    protected Serializable pkVal() {
        return this.pageId;
    }

}
