package com.gowithu.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.gowithu.springboot.dao.UserTemplate;
import com.gowithu.springboot.entity.User;
import com.gowithu.springboot.utils.DateValue;
import com.gowithu.springboot.utils.SendDataBody;
import com.gowithu.springboot.utils.SendRequestBody;
import com.gowithu.springboot.utils.StringValue;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {
  String appId = "wx882769e007a9573e";
  String secret = "55867e74554df906a8f7d81036c91fa4";

  @Autowired
  private UserTemplate userTemplate;

  @ResponseBody
  @PostMapping("/pushAppointment")
  public String pushAppointment(@RequestBody Map<String, Object> data) throws ParseException {
    // teacherOpenId: that.data.teacherOpenId,
    // teacherName: that.data.teacherName,
    // className: that.data.className,
    // time: that.data.time
    String teacherOpenId = data.get("teacherOpenId").toString();
    String studentId = data.get("studentId").toString();
    String className = data.get("className").toString();
    String time = data.get("time").toString();
    String formId = data.get("formId").toString();
    User user = userTemplate.findByOpenId(studentId);
    Map<String, Object> param = new HashMap<>();
    param.put("touser", teacherOpenId);
    param.put("template_id", "-LcIeb8ranqUmSo1oBVfxkuAmLLdbhupFlZ1u6o15Mk");
    param.put("page", "course");
    param.put("form_id", formId);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    HttpURLConnection connection = null;
    InputStream is = null;
    BufferedReader br = null;
    String result = null; // 返回结果字符串
    try {
      // 创建远程url连接对象
      URL url = new URL(
          "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx882769e007a9573e&secret=55867e74554df906a8f7d81036c91fa4");
      // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
      connection = (HttpURLConnection) url.openConnection();
      // 设置连接方式：get
      connection.setRequestMethod("GET");
      // 设置连接主机服务器的超时时间：15000毫秒
      connection.setConnectTimeout(15000);
      // 设置读取远程返回的数据时间：60000毫秒
      connection.setReadTimeout(60000);
      // 发送请求
      connection.connect();
      // 通过connection连接，获取输入流
      if (connection.getResponseCode() == 200) {
        is = connection.getInputStream();
        // 封装输入流is，并指定字符集
        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        // 存放数据
        StringBuffer sbf = new StringBuffer();
        String temp = null;
        while ((temp = br.readLine()) != null) {
          sbf.append(temp);
          sbf.append("\r\n");
        }
        result = sbf.toString();
      }
      System.out.println(result);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 关闭资源
      if (null != br) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (null != is) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      connection.disconnect(); // 关闭远程连接
    }

    result = result.split(":")[1].split(",")[0];
    String accessToken = result.substring(1, result.length() - 1);
    SendRequestBody sendRequestBody = new SendRequestBody();
    sendRequestBody.setTouser(teacherOpenId);
    sendRequestBody.setTemplate_id("-LcIeb8ranqUmSo1oBVfxkuAmLLdbhupFlZ1u6o15Mk");
    sendRequestBody.setForm_id(formId);
    sendRequestBody.setPage("course");
    SendDataBody sendDataBody = new SendDataBody();
    StringValue value1 = new StringValue();
    StringValue value2 = new StringValue();
    DateValue date1 = new DateValue();
    value1.setValue(user.getName());
    value2.setValue(className);
    date1.setDate(dateFormat.parse(time));
    sendRequestBody.setData(sendDataBody);
    String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken;
    JSONObject json = (JSONObject) JSON.toJSON(sendRequestBody);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, sendRequestBody, String.class);

    System.out.println(responseEntity.getBody());

    return "success";
  }

  @ResponseBody
  @PostMapping("/getOpenId")
  public String getOpenId(@RequestBody Map<String, Object> data) throws IOException {
    String code = data.get("code").toString();
    System.out.println(code);
    File dir = new File("");
    List<String> result = new ArrayList<>();
    try {
      System.out.println(dir.getAbsolutePath().replace("\\", "\\\\"));
      Process process = Runtime.getRuntime()
          .exec("python " + dir.getAbsolutePath() + "/python/getOpenid.py" + " " + code);
      process.waitFor();
      BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
      BufferedReader in1 = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
      String line = null;
      while ((line = in.readLine()) != null) {
        result.add(line);
        System.out.println(line);
      }
      while ((line = in1.readLine()) != null) {
        System.out.println(line);
      }
      in.close();
      // java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
      // 返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
      int re = process.waitFor();
      System.out.println(re);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(result.toString());
    return result.get(0);
  }

  @ResponseBody
  @PostMapping("/goWithU")
  public User judgeNewUser(@RequestBody Map<String, Object> data) {
    System.out.println(data.get("openId"));
    // System.out.println(userTemplate.findByOpenId(data.get("openId").toString()).getId());
    return userTemplate.findByOpenId(data.get("openId").toString());
  }
}
