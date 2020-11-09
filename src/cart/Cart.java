package cart;

import admin.Mobile;

import java.util.ArrayList;

public class Cart {
    private Client client;
    private ArrayList<Mobile> listCart;

    public Cart() {
        listCart = new ArrayList<>();
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Mobile> getListCart() {
        return listCart;
    }
}
