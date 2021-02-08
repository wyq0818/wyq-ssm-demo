package com.wyq.cloud.producer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyq.cloud.producer.web.entity.UserDTO;
import com.wyq.cloud.producer.web.entity.UserVO;

//import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WuYongQiang
 * @since 2020-12-15
 */
public interface UserService {  //extends IService<UserDTO>

    Page<UserVO> selectPage(Page<UserVO> page, UserDTO user);

    UserVO selectById(String id);

    Integer update(UserDTO userDTO);

    Integer insert(UserDTO userDTO);

    Integer delete(String id);

    Integer batchDelete(String ids);

}
