package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    private List<String> title;
    private List<String[]> selection;
    private List<String> answer;

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
