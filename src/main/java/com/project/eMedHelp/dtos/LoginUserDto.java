/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.dtos;

/**
 *
 * @author Natasa
 */
public class LoginUserDto {
    
    private String lousername;
    private String lopassword;
    private int lorole;

    public int getLorole() {
        return lorole;
    }

    public void setLorole(int lorole) {
        this.lorole = lorole;
    }

    public String getLousername() {
        return lousername;
    }

    public void setLousername(String lousername) {
        this.lousername = lousername;
    }

    public String getLopassword() {
        return lopassword;
    }

    public void setLopassword(String lopassword) {
        this.lopassword = lopassword;
    }
    
    
    
}
