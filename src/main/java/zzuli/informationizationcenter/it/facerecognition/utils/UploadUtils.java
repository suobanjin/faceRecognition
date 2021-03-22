package zzuli.informationizationcenter.it.facerecognition.utils;
import org.springframework.web.multipart.MultipartFile;
import zzuli.informationizationcenter.it.facerecognition.domain.UploadStatus;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UploadUtils {

    /**
     * @Date: 2021/3/22 21:11
     * @Author 索半斤
     * @Description: 该方法用于实现图片的上传功能
     * @MethodName: upload
     * @param path 基础路径
     * @param file file
     * @return map 返回值有多个，key为url表示上传的图片url，key为path表示图片在服务器的真实路径
     */
    public static Map<String,String> upload(MultipartFile file, String path, HttpServletRequest request) {
        System.out.println(file);
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) return null;
        int index = originalFilename.indexOf(".");
        if (index == -1)return null;
        String[] split = originalFilename.split("\\.");
        String newFileName = split[0] + UUIDUtils.uuid();
        String finalFileName = newFileName +"." + split[1];
        String childrenDir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File localFile = new File(path,childrenDir);
        localFile.mkdir();
        String url = request.getScheme() +"://" + request.getServerName() +":" +request.getServerPort() +"/";
        Map<String,String> map = new HashMap<>();
        String finalUrl = url + childrenDir + "/" + finalFileName;
        map.put(UploadStatus.URL, finalUrl);
        map.put(UploadStatus.PATH, localFile + "");
        return map;
    }
}
