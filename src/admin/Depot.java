package admin;

import java.util.ArrayList;

public class Depot {
    private String name;
    private ArrayList<HangSX> listDepot = new ArrayList<>();;
    private HangSX hangSX;
    private String address;

    public Depot(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /*Phương thức add:
* 1.Khởi tạo đối tượng KDL HangSX
* 2.Thêm đối tượng vào mảng listDepot
* */

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HangSX getHangSX() {
        return hangSX;
    }

    public void setHangSX(HangSX hangSX) {
        this.hangSX = hangSX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<HangSX> getListDepot() {
        return listDepot;
    }
}
