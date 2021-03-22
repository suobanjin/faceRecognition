package zzuli.informationizationcenter.it.facerecognition.controller;

import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import zzuli.informationizationcenter.it.facerecognition.domain.JsonResult;
import zzuli.informationizationcenter.it.facerecognition.domain.UserInfo;

/**
 * @ClassName UserInfoController
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/21 21:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户信息相关操作")
public class UserInfoController {

    @PostMapping("/insert")
    @ApiOperation(value = "用于用户信息的录入",httpMethod = "POST",
                  response = JsonResult.class
    )
    @ApiImplicitParams({
           @ApiImplicitParam(name = "file",
                   value = "用于接受前端传来的图片信息",
                   paramType = "body",
                   required = true,
                   allowMultiple = true
           )

    })
    public JsonResult<String> insertUserInfo(MultipartFile file,
                                  UserInfo userInfo){
        return null;
    }
}
