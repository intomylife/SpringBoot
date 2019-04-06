package com.zwc.base.controller;

import com.zwc.base.dto.response.SpringbootBaseResponseDTO;
import com.zwc.base.service.SpringbootBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SpringbootBaseController
 * @Desc TODO   地区表 前端控制器
 * @Date 2019/4/6 14:41
 * @Version 1.0
 */
@RestController
@RequestMapping("base")
public class SpringbootBaseController {

    @Autowired
    private SpringbootBaseService springbootBaseService;

    /*
     * @ClassName SpringbootBaseController
     * @Desc TODO   获取全部地区
     * @Date 2019/4/6 14:43
     * @Version 1.0
     */
    @RequestMapping("/getAllBase")
    @ResponseBody
    public List<SpringbootBaseResponseDTO> getAllBase(){
        return springbootBaseService.getAllBase();
    }

}
