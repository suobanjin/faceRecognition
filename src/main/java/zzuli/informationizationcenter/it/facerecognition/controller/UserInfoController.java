package zzuli.informationizationcenter.it.facerecognition.controller;

import cn.hutool.http.HttpRequest;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zzuli.informationizationcenter.it.facerecognition.domain.JsonResult;
import zzuli.informationizationcenter.it.facerecognition.domain.UploadStatus;
import zzuli.informationizationcenter.it.facerecognition.domain.UserInfo;
import zzuli.informationizationcenter.it.facerecognition.utils.HttpUtils;
import zzuli.informationizationcenter.it.facerecognition.utils.UploadUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName UserInfoController
 * @Description TODO
 * @Author 哆啦是只小猫咪
 * @Date 2021/3/21 21:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户信息相关操作")
public class UserInfoController {
    @Value("${basePath}")
    private String path;
    private HttpUtils httpUtils;
    @Autowired
    public void setHttpUtils(HttpUtils httpUtils){
        this.httpUtils = httpUtils;
    }
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
                                             UserInfo userInfo,
                                             HttpServletRequest request){
        Map<String, String> imageMap = UploadUtils.upload(file, path, request);
        String url = imageMap.get(UploadStatus.URL);
        String path = imageMap.get(UploadStatus.PATH);
        String faceFeature = httpUtils.post(path);
        JsonResult<String> jsonResult = new JsonResult<>();
        if (faceFeature == null){
            jsonResult.setCode(400);
            jsonResult.setMsg("未检测到人脸，或者人脸被遮挡!");
            return jsonResult;
        }
        userInfo.setImageUrl(url);
        userInfo.setFeature(faceFeature);
        jsonResult.setCode(200);
        return jsonResult;
    }


    @ApiOperation(value = "人脸信息管理",
                  response = JsonResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "grade",
                    value = "学院班级",
                    required = false
            ),
            @ApiImplicitParam(
                    name = "username",
                    value = "用户名",
                    required = false
            ),
            @ApiImplicitParam(
                    name = "date",
                    value = "人脸录入日期",
                    required = false
            )
    })
    @GetMapping("/face/manage/query/{grade}/{username}/{date}")
    public JsonResult<UserInfo> findUserInfoCondition(@PathVariable String grade,
                                                      @PathVariable String username,
                                                      @PathVariable String date){
        return null;
    }

    @GetMapping("/face/manage/query/{username}")
    @ApiOperation("根据姓名查找第三个页面的信息")
    @ApiImplicitParam(
            name = "username",
            value = "用户名",
            required = false
    )
    public JsonResult<UserInfo> queryUserInfo(@PathVariable String username){
        return null;
    }


}
