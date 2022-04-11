package online.cunho.blog.controller.backend;

import online.cunho.blog.annotation.AdminUserLogin;
import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.Const;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.BaseRequest;
import online.cunho.blog.dto.TbFileListDto;
import online.cunho.blog.entity.TbFileList;
import online.cunho.blog.service.AliyunService;
import online.cunho.blog.service.FileService;
import online.cunho.blog.util.PropertiesUtils;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/backend/file/handle")
public class FileController {

    @Autowired
    private AliyunService aliyunService;

    @Autowired
    private FileService fileService;

    @AdminUserLogin
    @PostMapping(value = "/upload")
    public Map<String, Object> file_upload_return_url(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();
        List<String> imgList = new ArrayList<>();
//        for (MultipartFile file : multipartFiles) {
        //Const.UPLOAD_IMAGE_MAX_SIZE : 2MB
        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 20)) {
            String file_path_url = aliyunService.uploadFileReturnURL(file);
            imgList.add(file_path_url);
            result.put("errno", 0);
            result.put("data", imgList);

        } else {
            result.put("errno", 99);
            result.put("data", imgList);
        }
//        }
        return result;
    }

    @AdminUserLogin
    @PostMapping(value = "/wangEditor/single/upload")
    public Map<String, Object> file_wangEditor_upload_return_url(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();
//        for (MultipartFile file : multipartFiles) {
        //Const.UPLOAD_IMAGE_MAX_SIZE : 2MB
        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 20)) {
            String file_path_url = aliyunService.uploadFileReturnURL(file);
            Map<String, String> returnData = new HashMap<>();
            returnData.put("url", file_path_url);
            result.put("errno", 0);
            result.put("data", returnData);

        } else {
            result.put("errno", 1);
            result.put("message", "上传失败");
        }
//        }
        return result;
    }

    @AdminUserLogin
    @PostMapping(value = "/single/image/upload")
    public Map<String, Object> image_upload_return_url(HttpServletRequest request, @RequestBody TbFileListDto tbFileListDto, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();
        //Const.UPLOAD_IMAGE_MAX_SIZE : 2MB
        Map<String, Object> imageMap = new HashMap<>();
        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 20)) {
            imageMap = aliyunService.uploadImageReturnURL(file);
            result.put("errno", 0);
            result.put("data", imageMap);
        } else {
            result.put("errno", 99);
            result.put("data", imageMap);
        }
        return result;
    }

    @AdminUserLogin
    @PostMapping(value = "/multie/image/upload")
    public BaseResponse image_multie_upload_return_url(HttpServletRequest request, @RequestParam("imageFiles") List<MultipartFile> multipartFileList, @RequestParam("authors") String username) {
        try {
            if (multipartFileList.size() > 0) {
                Map<String, Object> returnFileMap;
                boolean resultFlag = false;
                String resultMessage = "Fail";
                for (MultipartFile file : multipartFileList) {
                    // 1. aliyun oss save
                    returnFileMap = aliyunService.uploadImageReturnURL(file);

                    boolean isOSSSuccess = (boolean) returnFileMap.get("success");
                    if (isOSSSuccess) {
                        // 2. file info save in DB
                        TbFileList tbFileList = new TbFileList();
                        tbFileList.setFileType("01"); // 01: image, 02: audio, 03: video
                        tbFileList.setFileOriginName(returnFileMap.get("imageOriginName").toString());
                        tbFileList.setFileName(returnFileMap.get("imageName").toString());
                        tbFileList.setFilePath(returnFileMap.get("imagePath").toString());
                        tbFileList.setFileBucketName(PropertiesUtils.getAliyunOssFileBucketName());
                        tbFileList.setFileBucketObject(returnFileMap.get("imageObject").toString());
                        tbFileList.setFileSize(String.valueOf(file.getSize()));
                        tbFileList.setFileExtention(returnFileMap.get("imageExt").toString());
                        tbFileList.setFileUrl(returnFileMap.get("imageUrl").toString());
                        tbFileList.setFileSort(null);
                        tbFileList.setFileIsMain(null);
                        tbFileList.setFileRemark(null);
                        tbFileList.setStatus("1");
                        tbFileList.setOption01(username);
                        tbFileList.setOption02(null);
                        tbFileList.setOption03(null);
                        tbFileList.setOption04(null);
                        tbFileList.setOption05(null);

                        boolean isSuccessInsert = fileService.insertTbFileList(tbFileList);
                        if (isSuccessInsert) {
                            resultFlag = true;
                            resultMessage = ResponseCode.INSERT_SUCCESS.getDesc();
                        } else {
                            resultMessage = ResponseCode.INSERT_ERROR.getDesc();
                        }
                    } else {
                        resultMessage = "上传到阿里云服务器失败， 请重试或联系管理员";
                    }
                }

                if (resultFlag) {
                    return BaseResponse.valueOfSuccessMessage(resultMessage);
                }
                return BaseResponse.valueOfFailureMessage(resultMessage);
            } else {
                return BaseResponse.valueOfFailureMessage("系统未发现上传图片， 请确认");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }

    }

    @AdminUserLogin
    @PostMapping(value = "/single/image/delete")
    public BaseResponse image_delete(HttpServletRequest request, @RequestParam("imageUrl") String imageUrl) throws Exception {
        if (imageUrl == null || "".equals(imageUrl)) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Map<String, Object> mapParams = new HashMap<>();
        mapParams.put("imageUrl", imageUrl);
        aliyunService.deleteImage(mapParams);
        return BaseResponse.valueOfSuccessMessage("删除成功");
    }

    @AdminUserLogin
    @PostMapping(value = "/list")
    public BaseResponse getAllTbFileList(BaseRequest baseRequest, @RequestBody TbFileListDto tbFileListDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbFileListDto> returnData = fileService.getAllTbFileList(tbFileListDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @AdminUserLogin
    @GetMapping(value = "/info")
    public BaseResponse getTbFileListInfoByFileId(BaseRequest baseRequest, @RequestParam("fileId") Integer fileId) {
        if (fileId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbFileListDto tbFileListDto = fileService.getTbFileListInfoByFileId(fileId);
        return BaseResponse.valueOfSuccess(tbFileListDto);
    }

}
