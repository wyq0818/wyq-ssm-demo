package com.wyq.cloud.producer.web.service.impl;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyq.cloud.producer.util.bean.BeanMapperUtils;
import com.wyq.cloud.producer.web.entity.UserDO;
import com.wyq.cloud.producer.web.entity.UserDTO;
import com.wyq.cloud.producer.web.entity.UserVO;
import com.wyq.cloud.producer.web.mapper.UserMapper;
import com.wyq.cloud.producer.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WuYongQiang
 * @since 2020-12-15
 */
@Service
public class UserServiceImpl  implements UserService {  //extends ServiceImpl<UserMapper, UserDTO>

    @Autowired
    UserMapper userMapper;

    @Override
    public Page<UserVO> selectPage(Page<UserVO> page, UserDTO userDTO) {
        return userMapper.selectPageVo(page,userDTO);
    }

    @Override
    public UserVO selectById(String id){
        UserVO userVO = null ;
        UserDO userDO =  userMapper.selectById(id);
        if (ObjectUtil.isNotEmpty(userDO)) {
            userVO = BeanMapperUtils.map(userDO, UserVO.class);
		}
        return userVO;
    }

    @Override
    public Integer update(UserDTO userDTO) {
        Date nowDate = DateUtil.date();
        UpdateWrapper<UserDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", userDTO.getId());
        UserDO entity = BeanMapperUtils.map(userDTO, UserDO.class);
        entity.setUpdateTime(nowDate);
        return userMapper.update(entity,updateWrapper);
    }

    @Override
    public Integer insert(UserDTO userDTO) {
        Date nowDate = DateUtil.date();
        UserDO entity = BeanMapperUtils.map(userDTO, UserDO.class);
        entity.setId(IdUtil.objectId());
        entity.setCreateTime(nowDate);
        return userMapper.insert(entity);
    }

    @Override
    public Integer delete(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer batchDelete(String ids) {
        return userMapper.deleteBatchIds(Arrays.asList(ids.split(",")));
    }
}
