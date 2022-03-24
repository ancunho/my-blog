package online.cunho.blog.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;
    private int code;
    private long count;
    private List<T> list;
    private T data;
    private int page;
    private int limit;
    private String msg;

    private BaseResponse(String msg) {
        this.msg = msg;
    }

    private BaseResponse(int status, int code, String msg, long count, List<T> list) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = (T) list;
    }

    private BaseResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private BaseResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private BaseResponse(int status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public static <T> BaseResponse<T> valueOfSuccess() {
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc());
    }

    public static <T> BaseResponse<T> valueOfSuccess(T data) {
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc(), data);
    }

    public static <T> BaseResponse<T> valueOfSuccessMessage(String msg) {
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> BaseResponse<T> valueOfSuccessList(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        pageInfo.setList(list);
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.CODE.getCode(), ResponseCode.SUCCESS.getDesc(), pageInfo.getTotal(), pageInfo.getList());
    }

    public static <T> BaseResponse<T> valueOfSuccessListMessage(String msg, List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        pageInfo.setList(list);
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.CODE.getCode(), msg, pageInfo.getTotal(), pageInfo.getList());
    }

    public static <T> BaseResponse<T> valueOfFailure() {
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> BaseResponse<T> valueOfFailure(T data) {
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.ERROR.getDesc(), data);
    }

    public static <T> BaseResponse<T> valueOfFailureMessage(String msg) {
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> BaseResponse<T> valueOfFailureCodeMessage(int code, String msg) {
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), code, msg);
    }

    public static <T> BaseResponse<T> valueOfFailureList(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        pageInfo.setList(list);
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.CODE_ERROR.getCode(), ResponseCode.ERROR.getDesc(), pageInfo.getTotal(), list);
    }

    public static <T> BaseResponse<T> valueOfFailureListMessage(String msg, List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        pageInfo.setList(list);
        return new BaseResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.CODE_ERROR.getCode(), msg, pageInfo.getTotal(), pageInfo.getList());
    }


    public int getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public long getCount() {
        return count;
    }

    public List<T> getList() {
        return list;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
