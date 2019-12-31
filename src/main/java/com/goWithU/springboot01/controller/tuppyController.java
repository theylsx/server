package com.goWithU.springboot01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class tuppyController {

//    @Autowired
//    personRepository prepository;
//
//    @GetMapping("/tuppy")
//    public List<Person> personList(){
//        return prepository.findAll();
//    }
//
//    @GetMapping("/tuppy/{id}")
//    public Person personOne(@PathVariable("id") Integer id){
//        return prepository.findById(id).orElse(null);
//    }
//
//    @PostMapping("/tuppy")
//    public Person personAdd(@RequestParam("name") String name, @RequestParam("age") Integer age){
//        Person one = new Person(name, age);
//        return prepository.save(one);
//    }
//    @GetMapping("/tuppy/findName/{name}")
//    public Person personFindbyname(@PathVariable("name") String name){
//        return prepository.findByname(name);
//    }
//
//
//    @DeleteMapping("/tuppy/{id}")
//    public void personDel(@PathVariable("id") Integer id){
//        prepository.deleteById(id);
//    }
//
//    @PostMapping("/tuppy/upload")
//    public String upvideo(@RequestParam("data") MultipartFile file){
//        String pathName = "/home/public/";//想要存储文件的地址
//        String pname = file.getOriginalFilename();//获取文件名（包括后缀）
//        pathName += pname;
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(pathName);
//            fos.write(file.getBytes()); // 写入文件
//            //System.out.println("文件上传成功");
//            return "文件上传成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "文件上传失败";
//        } finally {
//            try {
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
