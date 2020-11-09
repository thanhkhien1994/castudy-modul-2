package admin;

import java.util.ArrayList;

/*
 * Lớp này chứa
 * 1. Tên của hãng di động
 * 2. Biến mobile KDL Mobile
 * 3. Mảng listHangSX chứa các di động của hãng đó
 * */
public class HangSX {
    private String name;
    private Mobile mobile;
    private ArrayList<Mobile> listHangSX = new ArrayList<>();

    /*
     *Phương thức khởi tạo
     **/
    public HangSX(String name) {
        this.name = name;
    }

    /*
    * Các phương thức getter, setter
    * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public ArrayList<Mobile> getListHangSX() {
        return listHangSX;
    }
}
