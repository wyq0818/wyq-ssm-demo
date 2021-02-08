package com.wyq.cloud.producer.component.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/*
 * @Author:wuyongqiang
 * @Date:2020-12-23 17:14:17:14
 */
@ApiModel(value = "时间戳实体")
public class BaseDO implements Serializable {


    private static final long serialVersionUID = 424320555L;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
