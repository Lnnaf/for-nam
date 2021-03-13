/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

import javax.persistence.*;

/**
 *
 * @author namna
 */
@Entity
public class nv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="fullname")
    private String fullname;
    @Column(name="gioitinh")
    private String gioitinh;
    @Column(name="cv")
    private String cv;
    @Column(name="email")
    private String email;
    @Column(name="sdt")
    private String sdt;
    @Column(name="dc")
    private String dc;
    private int tuoi;

    public nv(){
    }

    public nv(int id, String fullname, String gioitinh, String cv, String email, String sdt, String dc, int tuoi) {
        this.id = id;
        this.fullname = fullname;
        this.gioitinh = gioitinh;
        this.cv = cv;
        this.email = email;
        this.sdt = sdt;
        this.dc = dc;
        this.tuoi = tuoi;
    }

    public nv(String fullname, String gioitinh, String cv, String email, String sdt, String dc, int tuoi) {
        this.fullname = fullname;
        this.gioitinh = gioitinh;
        this.cv = cv;
        this.email = email;
        this.sdt = sdt;
        this.dc = dc;
        this.tuoi = tuoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    
}
