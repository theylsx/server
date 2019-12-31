package com.tuppy.springboot01.controller.python;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    List<String> result = new ArrayList<String>();
    try {
      File dir = new File("getOpenid.py");
      Process process =
              Runtime.getRuntime().exec("python3 " + "C:\\Users\\dav1d\\Documents\\Ch\\JavaProject\\server\\springboot\\src\\main\\java\\com\\tuppy\\springboot01\\controller\\python\\getOpenid.py"+  " 023PEnMH1wRKX00vOFNH1DvvMH1PEnMO");
      BufferedReader in =
          new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
      String line = null;
      while ((line = in.readLine()) != null) {
        result.add(line);
        System.out.println(line);
      }
      in.close();
      int re = process.waitFor();
      System.out.println(re);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
