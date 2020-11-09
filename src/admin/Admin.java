package admin;

import java.util.ArrayList;

public class Admin {
    private String name;
    private int password;
    private Depot depot;
    private ArrayList<Depot> list = new ArrayList<>();

    public Admin(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public ArrayList<Depot> getList() {
        return list;
    }
}
