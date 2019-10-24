package com.bohui.wf.gps.website.webpage.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

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
 * @since 2019-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="WebIndex对象", description="")
public class WebIndex extends Model<WebIndex> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "页面id")
    @TableId(value = "index_id", type = IdType.AUTO)
    private Integer indexId;

    @ApiModelProperty(value = "内容")
    private String indexContent;

    @ApiModelProperty(value = "链接")
    private String indexLink;

    @ApiModelProperty(value = "状态，1为启用")
//    @TableLogic(value = "1",delval = "0")
    private Integer indexStatus;

    @ApiModelProperty(value = "备注")
    private String indexRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.indexId;
    }

}
