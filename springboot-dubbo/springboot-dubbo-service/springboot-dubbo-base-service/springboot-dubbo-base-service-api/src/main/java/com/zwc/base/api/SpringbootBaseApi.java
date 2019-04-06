package com.zwc.base.api;

import com.zwc.base.dto.response.SpringbootBaseResponseDTO;

import java.util.List;

/**
 * @ClassName SpringbootBaseApi
 * @Desc TODO   地区表 服务类
 * @Date 2019/4/6 14:19
 * @Version 1.0
 */
public interface SpringbootBaseApi {

    // 获取全部地区
    List<SpringbootBaseResponseDTO> getAllBase();

}
