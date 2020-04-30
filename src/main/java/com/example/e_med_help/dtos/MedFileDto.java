package com.example.e_med_help.dtos;

import org.springframework.web.multipart.MultipartFile;

public class MedFileDto {

    private int id;
    private String name;
    private String username;
    private String usersurname;
    private String userText;
    private MultipartFile userPdf;

    public MedFileDto() {
    }

    public MedFileDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MedFileDto(int id, String username, String usersurname, String userText) {
        this.id = id;
        this.username = username;
        this.usersurname = usersurname;
        this.userText = userText;
    }

    public MedFileDto(int id, String username, String usersurname, MultipartFile userPdf) {
        this.id = id;
        this.username = username;
        this.usersurname = usersurname;
        this.userPdf = userPdf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }

    public MultipartFile getUserPdf() {
        return userPdf;
    }

    public void setUserPdf(MultipartFile userPdf) {
        this.userPdf = userPdf;
    }
}
