package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.UserTemplate;
import com.gowithu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.*;
import java.util.*;

/**
 * @author dav1d
 */
@Controller
public class UserController {
  String appId = "wx882769e007a9573e";
  String secret = "55867e74554df906a8f7d81036c91fa4";

  @Autowired
  private UserTemplate userTemplate;



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
    return userTemplate.findByOpenId(data.get("openId").toString());
  }
}
