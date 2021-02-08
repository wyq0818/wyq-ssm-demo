package com.wyq.cloud.producer.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyq.cloud.producer.component.response.Response;
import com.wyq.cloud.producer.component.validator.ValidList;
import com.wyq.cloud.producer.util.bean.InputInjectFilter;
import com.wyq.cloud.producer.web.entity.UserDTO;
import com.wyq.cloud.producer.web.entity.UserVO;
import com.wyq.cloud.producer.web.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WuYongQiang
 * @since 2020-12-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 分页查询
     * @param userDTO
     * @return
     */
    @GetMapping("/query2")
    public Response<Page<UserVO>> getSelectPage2(@ApiParam UserDTO userDTO){
        userDTO = (UserDTO) InputInjectFilter.encodeInputString(userDTO,UserDTO.class);
        //统一分页参数 实体类继承分页类封装
        Page<UserVO> page = new Page<>(userDTO.getPageNo(),userDTO.getPageSize());
        Page<UserVO> result = userService.selectPage(page, userDTO);
        return Response.createBySuccess(result);
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @GetMapping("/getOneById/{id}")
    public Response<UserVO> getUserById(@PathVariable String id){
        UserVO user = userService.selectById(id);
        return Response.createBySuccess(user);
    }

    /**
     * 修改
     * @param userDTO
     * @return
     */
    @PutMapping("/update")
    public Response update(@Valid UserDTO userDTO){
        userDTO = (UserDTO) InputInjectFilter.encodeInputString(userDTO,UserDTO.class);
        Integer i = userService.update(userDTO);
        return Response.createBySuccess(i);
    }


    /**
     * 增加
     * @param userDTO
     * @return
     */
    @PostMapping("/insert")
    public Response insert(@Valid UserDTO userDTO){
        userDTO = (UserDTO) InputInjectFilter.encodeInputString(userDTO,UserDTO.class);
        Integer i = userService.insert(userDTO);
        return Response.createBySuccess(i);
    }
    /**
     * 批量增加
     * @param userDTOList
     * @return
     */
    @PostMapping("/batchInsert")
    public Response batchInsert(@RequestBody @Valid ValidList<UserDTO> userDTOList){
        Integer total = 0;
        if(userDTOList.size()>0){
            for (int i = 0; i < userDTOList.size(); i++) {
             UserDTO   userDTO = (UserDTO) InputInjectFilter.encodeInputString(userDTOList.get(i),UserDTO.class);
                Integer j = (Integer) userService.insert(userDTO);
                if(j==1){
                    total++;
                }
            }
        }
        return Response.createBySuccess(total);
    }

    /**
     * 单条删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable String id){
        Integer i = userService.delete(id);
        return Response.createBySuccess(i);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/batchDelete")
    public Response batchDelete(@RequestParam String ids){
        Integer i =  userService.batchDelete(ids);
        return Response.createBySuccess(i);
    }
}

