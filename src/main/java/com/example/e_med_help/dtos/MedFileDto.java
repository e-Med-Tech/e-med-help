package com.example.e_med_help.dtos;

import org.springframework.web.multipart.MultipartFile;

public class MedFileDto {

    private int userId;
    private String username, usersurname;
    private String userText;
    private MultipartFile userPdf;

    public MedFileDto() {
    }

    public MedFileDto(int userId, String username, String usersurname, String userText) {
        this.userId = userId;
        this.username = username;
        this.usersurname = usersurname;
        this.userText = userText;
    }

    public MedFileDto(int userId, String username, String usersurname, MultipartFile userPdf) {
        this.userId = userId;
        this.username = username;
        this.usersurname = usersurname;
        this.userPdf = userPdf;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
