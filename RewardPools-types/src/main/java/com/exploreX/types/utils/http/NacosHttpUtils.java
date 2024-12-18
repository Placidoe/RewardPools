package com.exploreX.types.utils.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Map;
import java.util.StringJoiner;

public class NacosHttpUtils {

    /**
     * 发送 GET 请求到 Nacos Open API
     *
     * @param url   请求的完整 URL
     * @param headers   请求头参数
     * @return 响应内容
     * @throws Exception 可能抛出的异常
     */
    public static String get(String url, Map<String, String> headers) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        setHeaders(connection, headers);
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
        final InputStream inputStream = connection.getInputStream();
        return readInputStream(new InputStreamReader(inputStream,"utf-8"));
    }

    /**
     * 发送 POST 请求到 Nacos Open API
     *
     * @param url   请求的完整 URL
     * @param headers   请求头参数
     * @param body 请求体
     * @return 响应内容
     * @throws Exception 可能抛出的异常
     */
    public static String post(String url, Map<String, String> headers, String body) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        setHeaders(connection, headers);
        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = body.getBytes("utf-8");
            os.write(input, 0, input.length);           
        }
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
        final InputStream inputStream = connection.getInputStream();
        return readInputStream(new InputStreamReader(inputStream,"utf-8"));
    }

    /**
     * 设置请求头
     *
     * @param connection   HTTP 连接
     * @param headers   请求头参数
     */
    private static void setHeaders(HttpURLConnection connection, Map<String, String> headers) {
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    }

    /**
     * 从输入流中读取响应内容
     *
     * @param inputStream 输入流
     * @return 响应内容
     * @throws Exception 可能抛出的异常
     */
    private static String readInputStream(InputStreamReader inputStream) throws Exception {
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(inputStream)) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
        return response.toString();
    }

    /**
     * 生成基本认证的请求头值
     *
     * @param username 用户名
     * @param password 密码
     * @return 基本认证的请求头值
     */
    public static String basicAuth(String username, String password) {
        String auth = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
    }

    public static void main(String[] args) {
//        try {
//            // 示例：获取 Nacos 配置
//            String nacosUrl = "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example-dataId&group=DEFAULT_GROUP";
//            Map<String, String> headers = Map.of(
//                "Authorization", basicAuth("nacos", "nacos")
//            );
//            String config = get(nacosUrl, headers);
//            System.out.println(config);
//
//            // 示例：更新 Nacos 配置
//            String updateUrl = "http://127.0.0.1:8848/nacos/v1/cs/configs";
//            headers = Map.of(
//                "Authorization", basicAuth("nacos", "nacos")
//            );
//            String configContent = "{\"content\":\"example content\"}";
//            String updatedConfig = post(updateUrl, headers, configContent);
//            System.out.println(updatedConfig);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}