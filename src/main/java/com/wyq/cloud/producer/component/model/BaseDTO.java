package com.wyq.cloud.producer.component.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/*
 * 分页参数对象
 * @Author:wuyongqiang
 * @Date:2020-12-22 16:49:16:49
 */
@ApiModel(description = "分页对象实体")
public class BaseDTO implements Serializable {


    private static final long serialVersionUID = 424320555L;

    @Range(min = 1L)
    @ApiModelProperty(value = "页码")
    private long pageNo = 1L;

    @Range(min = 0L, max = 1000L)
    @ApiModelProperty(value = "每页数量")
    private long pageSize = 10L;

//    private String sortMapJson;

    public long getPageNo() {
        return this.pageNo;
    }

    public long getPageSize() {
        return this.pageSize;
    }



    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

//    public String getSortMapJson() {
//        return sortMapJson;
//    }
//    public void setSortMapJson(String sortMapJson) {
//        this.sortMapJson = sortMapJson;
//    }

//    public boolean equals(Object o) {
//        if (o == this) return true;
//        if (!(o instanceof BaseDTO)) return false;
//        BaseDTO other = (BaseDTO) o;
//        if (!(other.canEqual(this))) return false;
//        if (getPageNo() != other.getPageNo()) return false;
//        if (getPageSize() != other.getPageSize()) return false;
//        Object sortMapJson = this.getSortMapJson();
//        Object otherSortMapJson = other.getSortMapJson();
//        if (sortMapJson == null) if (otherSortMapJson == null) break label93;
//        label93:
//        return (sortMapJson.equals(otherSortMapJson));
//    }

//    protected boolean canEqual(Object other) {
//        return other instanceof BaseDTO;
//    }

//    public int hashCode() {
//        int PRIME = 59;
//        int result = 1;
//        long $pageNo = getPageNo();
//        result = result * 59 + (int) ($pageNo ^ $pageNo >>> 32);
//        long $pageSize = getPageSize();
//        result = result * 59 + (int) ($pageSize ^ $pageSize >>> 32);
//        Object $sortMapJson = getSortMapJson();
//        return (result * 59 + (($sortMapJson == null) ? 43 : $sortMapJson.hashCode()));
//    }

//    public String toString() {
//        return "BaseDTO(pageNo=" + getPageNo() + ", pageSize=" + getPageSize() + ", sortMapJson=" + getSortMapJson() + ")";
//    }

}
