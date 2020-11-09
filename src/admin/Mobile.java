package admin;

/*Lớp Mobile chứa thông tin:
 * 1. Tên của thiết bị di dộng
 * 2. Mã số IME của thiết bị di dộng
 * 3. Giá của sản phẩm
 * 4. Số lượng
 * */
public class Mobile {
    String loai;
    private String name;
    private int ime;
    private double price;
    private int amount;

    /*Hàm khởi tạo 4 tham số
     * */
    public Mobile(String name, String loai, int ime, double price, int amount) {
        this.name = name;
        this.ime = ime;
        this.price = price;
        this.amount = amount;
        this.loai = loai;

    }

    /*Phương thức getter, setter*/

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIme() {
        return ime;
    }

    public void setIme(int ime) {
        this.ime = ime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Thông tin thiết bị: " + "\n" +
                "\tTên:       " + name.toUpperCase() + '\n' +
                "\tKiểu:      " + loai.toUpperCase() + '\n' +
                "\tLô số:     " + ime + '\n' +
                "\tGiá:       " + price + '\n' +
                "\tSố lượng:  " + amount +
                '\n';
    }
}
