package com.gowithu.springboot.entity;

import java.util.List;
import jdk.nashorn.internal.ir.debug.PrintVisitor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author david
 */
@Document(collection = "work")
public class Work {
  private ObjectId id;
  private String stringId;
  private String workName;
  private String declaration;
  private String teacherOpenId;
  private String studentOpenId;
  private String filePath;
  private int count;
  private List<String> title;
  private List<String> pictureList;
  private List<String[]> selection;
  private List<String> answer;
  private float score;
  private String context;
  private int type;

  public String getContext() {
    return context;
  }

  public List<String> getPictureList() {
    return pictureList;
  }

  public void setPictureList(List<String> pl) {
    pictureList = pl;
  }

  public int getType() {
    return type;
  }

  public void setType(int t) {
    this.type = t;
  }

  public void setContext(String c) {
    this.context = c;
  }

  public float getScore() {
    return score;
  }

  public void setScore(float s) {
    this.score = s;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public ObjectId getId() {
    return id;
  }

  public String getStringId() {
    return stringId;
  }

  public void setStringId(String stringId) {
    this.stringId = stringId;
  }

  public String getWorkName() {
    return workName;
  }

  public void setWorkName(String workName) {
    this.workName = workName;
  }

  public String getDeclaration() {
    return declaration;
  }

  public void setDeclaration(String declaration) {
    this.declaration = declaration;
  }

  public String getTeacherOpenId() {
    return teacherOpenId;
  }

  public void setTeacherOpenId(String teacherOpenId) {
    this.teacherOpenId = teacherOpenId;
  }

  public String getStudentOpenId() {
    return studentOpenId;
  }

  public void setStudentOpenId(String studentOpenId) {
    this.studentOpenId = studentOpenId;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public List<String> getTitle() {
    return title;
  }

  public void setTitle(List<String> title) {
    this.title = title;
  }

  public List<String[]> getSelection() {
    return selection;
  }

  public void setSelection(List<String[]> selection) {
    this.selection = selection;
  }

  public List<String> getAnswer() {
    return answer;
  }

  public void setAnswer(List<String> answer) {
    this.answer = answer;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }
}
