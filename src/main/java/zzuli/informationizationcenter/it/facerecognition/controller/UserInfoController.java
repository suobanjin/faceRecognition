package zzuli.informationizationcenter.it.facerecognition.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;
import zzuli.informationizationcenter.it.facerecognition.domain.*;
import zzuli.informationizationcenter.it.facerecognition.service.HistoryInfoService;
import zzuli.informationizationcenter.it.facerecognition.service.UserInfoService;
import zzuli.informationizationcenter.it.facerecognition.utils.HttpUtils;
import zzuli.informationizationcenter.it.facerecognition.utils.UploadUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
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
    @Value("${baseFilePrefix}")
    private String path;
    private HttpUtils httpUtils;
    private UserInfoService userInfoService;
    private HistoryInfoService historyInfoService;

    @Autowired
    public void setHistoryInfoService(HistoryInfoService historyInfoService) {
        this.historyInfoService = historyInfoService;
    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
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
                                             @Validated UserInfo userInfo,
                                             BindingResult bindingResult,
                                             HttpServletRequest request){
        if (userInfo.getDate() == null){
            userInfo.setDate(new Date());
        }
        JsonResult<String> jsonResult = new JsonResult<>();
        if (bindingResult.hasErrors()){
            jsonResult.setCode(400);
            jsonResult.setMsg("基本信息填写错误，请检查后重试!");
            return jsonResult;
        }
        Map<String, String> imageMap = UploadUtils.upload(file, path, request);
        if (imageMap == null || imageMap.size() == 0){
            jsonResult.setCode(500);
            jsonResult.setMsg("服务器异常，请稍后重试!");
            return jsonResult;
        }
        String url = imageMap.get(UploadStatus.URL);
        String path = imageMap.get(UploadStatus.PATH);
        String faceFeature = httpUtils.post(path);
        if (faceFeature == null){
            jsonResult.setCode(401);
            jsonResult.setMsg("未检测到人脸，或者人脸被遮挡!");
            return jsonResult;
        }
        userInfo.setImageUrl(url);
        userInfo.setFeature(faceFeature);
        boolean isInsert = userInfoService.insert(userInfo);
        if (isInsert) {
            jsonResult.setCode(200);
        }else{
            jsonResult.setCode(400);
            jsonResult.setMsg("服务器异常，请稍后重试");
        }
        return jsonResult;
    }


    @ApiOperation(value = "分页查询人脸历史识别信息",
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
    @GetMapping("/face/history/query")
    public JsonResult<PageBean<UserAndHistoryInfo>> findUserInfoCondition(@RequestParam(name = "grade",required = false,defaultValue = "") String grade,
                                                      @RequestParam(name = "username",required = false,defaultValue = "") String username,
                                                      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam(name = "date",required = false) Date date,
                                                                int pageNum,
                                                                int pageSize){
        JsonResult<PageBean<UserAndHistoryInfo>> jsonResult = new JsonResult<>();
        PageBean<UserAndHistoryInfo> queryInfo = historyInfoService.findUserAndHistoryInfo(pageNum,pageSize,grade, username, date);
        if (queryInfo == null || queryInfo.getTotalPage() == 0){
            jsonResult.setCode(403);
            jsonResult.setMsg("未查询到相应的内容");
        }else{
            jsonResult.setCode(200);
            jsonResult.setMsg("共查询到"+queryInfo.getTotalPage()+"条信息");
            jsonResult.setPage(queryInfo);
        }
        return jsonResult;
    }

    @GetMapping("/face/manage/query")
    @ApiOperation("用户基本信息管理")
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
    public JsonResult<UserInfo> queryUserInfo(@RequestParam(name = "grade",required = false,defaultValue = "") String grade,
                                              @RequestParam(name = "username",required = false,defaultValue = "") String username,
                                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam(name = "date",required = false) Date date){
        if (grade.equals("") && username.equals("")){
            grade = null;
            username = null;
        }
        JsonResult<UserInfo> jsonResult = new JsonResult<>();
        List<UserInfo> userInfos = userInfoService.findUserInfos(0, 99999, grade, username, date);
        jsonResult.setData(userInfos);
        jsonResult.setCode(200);
        return jsonResult;
    }


}
