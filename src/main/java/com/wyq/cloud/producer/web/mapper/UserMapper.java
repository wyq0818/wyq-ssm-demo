package com.wyq.cloud.producer.web.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyq.cloud.producer.web.entity.UserDO;
import com.wyq.cloud.producer.web.entity.UserDTO;
import com.wyq.cloud.producer.web.entity.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WuYongQiang
 * @since 2020-12-15
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     *
     * @Description: 分页查询
     */
    Page<UserVO> selectPageVo(Page<UserVO> page, @Param("param") UserDTO user);


}
