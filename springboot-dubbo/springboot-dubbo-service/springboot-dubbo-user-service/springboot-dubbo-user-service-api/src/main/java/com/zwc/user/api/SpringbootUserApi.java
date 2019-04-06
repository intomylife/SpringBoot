package com.zwc.user.api;

import com.zwc.user.dto.response.SpringbootUserResponseDTO;

import java.util.List;

/**
 * @ClassName SpringbootUserApi
 * @Desc TODO   用户表 服务类
 * @Author zouwencong
 * @Date 2019/4/6 15:09
 * @Version 1.0
 */
public interface SpringbootUserApi {

    // 获取全部用户
    List<SpringbootUserResponseDTO> getAllUser();

}
