package com.exploreX.types.model.pojo;

public class Result<T> {

    // 结果状态码
    private int code;

    // 结果信息
    private String message;

    // 结果数据
    private T data;

    // 默认构造函数
    public Result() {}

    // 带参数的构造函数
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getter 和 Setter 方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 成功结果的静态方法
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    // 成功结果的静态方法，不带数据
    public static Result<Void> success() {
        return new Result<>(200, "Success", null);
    }

    // 错误结果的静态方法
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    // 错误结果的静态方法，带状态码
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }

    // 错误结果的静态方法，带状态码和数据
    public static <T> Result<T> error(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}