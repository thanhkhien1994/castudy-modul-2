package program;

import admin.Admin;
import admin.Depot;
import admin.HangSX;
import admin.Mobile;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private Admin admin;
    public HangSX hangSX;
   // public Depot depot;
    private Mobile mobile;

    public void start() {
        String choice;
        do {
            System.out.println("*-------------------------------------*");
            System.out.println("* Truy cập với tư cách là:            *");
            System.out.println("*     1.Quản trị viên                 *");
            System.out.println("*     2.Tiểu thương                   *");
            System.out.println("*     3.Thoát                         *");
            System.out.println("*-------------------------------------*");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    adminLogin();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    break;
            }

        } while (true);
    }

    private void adminLogin() {
        do {
            if (admin == null) {
                if (isCheckExitNow("Đăng kí tài khoản ngay\nXác nhận")) {
                    initAdmin();
                } else return;
            }

            if (isCheckLogin()) {
                System.out.println("*----------------Đăng nhập quyền quản trị*-----------------*");
                System.out.println("*      1.Kho                                               *");
                System.out.println("*      2.Tài sản                                           *");
                System.out.println("*      3.Tài khoản                                         *");
                System.out.println("*      Q.Quay lại \tT.Thoát                                *");
                System.out.println("*----------------------------------------------------------*");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        if (admin.getList().size() == 0) {
                            if (isCheckExitNow("Bạn chưa có kho chưa nào\nTạo ngay")) {
                                initDepot();
                            } else return;
                        }
                        depotLogin();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "Q":
                        return;
                    case "T":
                        break;
                    default:
                        break;
                }
            }
        } while (true);

    }

    private void depotLogin() {
        do {
            /* ----------Menu Kho---------*/
            System.out.println("*----------------admin\\depot\\------------------------------------------------------");
            System.out.println("* Lựa chọn: ");
            for (int i = 0; i < admin.getList().size(); i++) {
                System.out.println("*\t" + (i + 1) + "." + admin.getList().get(i).getName());
            }
            System.out.println("* Chức năng cho kho chứa: ");
            System.out.println("* \tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tThoát");
            System.out.println("*---------------------------------------------------------------------------------------");
            /*----------------Lựa chọn-------------*/
            String choiceDepot = scanner.nextLine().toUpperCase();
            /* -------------Lựa chọn chức năng---------------*/
            switch (choiceDepot) {
                case "C":
                    initDepot();
                    continue;
                case "E":

                    break;
                case "D":
                    break;
                case "Q":
                    return;
                case "T":
                    break;
            }
            /*------------Lựa chọn kho--------------------*/

            selectDepot(Integer.parseInt(choiceDepot) - 1);
            break;
        } while (true);

    }

    private void selectDepot(int choiceDepot) {
        do {
            /*-------------------Duyệt hãng----------------*/
            for (int indexDepot = 0; indexDepot < admin.getList().size(); indexDepot++) {
                /*---------------Nếu chưa có hãng nào trong kho thì thêm hãng mới-----------------*/
                if (admin.getList().get(choiceDepot).getListDepot().size() == 0) {
                    System.out.println("*-----admin\\depot\\hang\\creat-hang----------------------*");
                    if (isCheckExitNow("* Kho bạn đang trống\n* Thêm nhãn hàng ngay")) {
                        initHangSX(choiceDepot);
                    } else return;/*--------------->>>>>> Trả quyền điều khiển về cho selectDepot();*/
                    System.out.println("*--------------------------------------------------*");
                }

                /*-------------------kiểm tra admin lựa chọn hãng nào-----------------*/
                if (choiceDepot == indexDepot) {

                    System.out.println("*----------------admin\\depot\\hang\\------------------------------------------*");
                    int lengthHangSX = admin.getList().get(indexDepot).getListDepot().size();
                    int count = 1;
                    /*----Menu Hãng--------*/
                    for (int indexHangSX = 0; indexHangSX < lengthHangSX; indexHangSX++) {
                        System.out.println(
                                count + "." + admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getName()
                        );
                        count++;
                    }
                    System.out.println("Chức năng cho hãng sản xuất: ");
                    System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tThoát");
                    System.out.println("*------------------------------------------------------------------------------*");
                    /*-----Lựa chọn chức năng của hãng------- */

                    String choiceHangSX = scanner.nextLine().toUpperCase();

                    switch (choiceHangSX) {
                        case "C":
                            initHangSX(indexDepot);
                            continue;
                        case "E":
                            break;
                        case "D":
                            break;
                        case "Q":
                            return;
                        case "T":
                            break;
                        default:
                            selectHangSX(choiceHangSX, indexDepot);
                            continue;
                    }
                }else {
                    System.out.println("Không khớp");
                }
            }
        } while (true);

    }

    private void selectHangSX(String choiceHangSX, int indexDepot) {

        int indexChoiceHangSX = Integer.parseInt(choiceHangSX) - 1;
        int lengthMobile = admin.getList().get(indexDepot).getListDepot().get(indexChoiceHangSX).getListHangSX().size();
        if (lengthMobile == 0) {
            System.out.println("----admin\\depot\\hang\\mobile\\creat-mobile---------------");
            if (isCheckExitNow("Bạn chưa có sản phẩm nào cả\n Thêm ngay")) {
                initMobile(indexChoiceHangSX, indexDepot);
                return;
            }
            System.out.println("-------------------------------------------------");
        }

        do {
            for (int indexHangSX = 0; indexHangSX < lengthMobile; indexHangSX++) {

                if (indexChoiceHangSX == indexHangSX) {
                    System.out.println("--------------admin\\depot\\hang\\mobile\\--------------------------------------");
                    /*----------Menu Điện thoại -------------------------------------------------------------------------------------------------------------------*/
                    for (int indexMobile = 0; indexMobile < admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().size(); indexMobile++) {
                        System.out.println((indexMobile + 1) + "." + admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().get(indexMobile).getName());
                    }
                    /*----------Menu chức năng điện thoại-------------------------------------------------------------------------------------*/
                    System.out.println("Chức năng: ");
                    System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tThoát");
                    System.out.println("--------------------------------------------------------------------------------");
                    String choiceMobile = scanner.nextLine().toUpperCase();
                    /*-----------Chọn chức năng điện thoại------------------------------------------------------------------------------------*/
                    switch (choiceMobile) {
                        case "C":
                            initMobile(indexChoiceHangSX, indexDepot);
                            continue;
                        case "E":
                            editAllInfoMobile(indexDepot, indexHangSX);
                            break;
                        case "D":

                            break;
                        case "Q":
                            return;
                        case "T":
                            break;
                    }

                    /*-----------Chon điện thoại--------------------------*/
                    selectMobile(choiceMobile, indexDepot, indexHangSX);
                    return;
                }
            }
        } while (true);
    }

    private void editAllInfoMobile(int indexDepot, int indexHangSX) {
        System.out.println("*-------------Sửa thông tin điện thoại---admin\\depot\\hang\\mobile\\edit-------------------");
        System.out.print("*                  Chọn điện thoại bạn muốn sửa:                                      ");
        int choiceEdit = scanner.nextInt();
        System.out.println("\n");
        for (int i = 0; true; ) {
            if ((choiceEdit - 1) == i) {
                scanner.nextLine();
                System.out.println("*                Nhập tên mới cho thiết bị.                                         ");
                String name = scanner.nextLine();
                System.out.println("*                Nhập IME mới cho thiết bị.                                         ");
                int ime = scanner.nextInt();
                scanner.nextLine();
                System.out.println("                 Nhập giá mới cho thiết bị.                                         ");
                int price = scanner.nextInt();
                scanner.nextLine();
                System.out.println("                 Nhập số lượng mới cho thiết bị.                                    ");
                int amount = scanner.nextInt();
                scanner.nextLine();

                if (isCheckExitNow("Xác nhận thay đổi")) {
                    admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().get(i).setName(name);
                    admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().get(i).setIme(ime);
                    admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().get(i).setPrice(price);
                    admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().get(i).setAmount(amount);
                } else {
                    System.out.println("Đã hủy lệnh");
                    return;
                }
            } else {
                System.out.println("Không có thiết bị ở vị trí đó.");
                return;
            }
            System.out.println("------------------------------------------------------------------------------------");
        }
    }

    private void selectMobile(String choiceMobile, int indexDepot, int indexHangSX) {
        int indexChoiceMobile = Integer.parseInt(choiceMobile) - 1;
        do {
            /*--------Hiển thị thông tin điện thoại---------------------------------*/
            for (int indexMobile = 0; indexMobile < admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().size(); indexMobile++) {
                if (indexChoiceMobile == indexMobile) {
                    System.out.println("-----------------------Thông tin chi tiết---------------------------------------");
                    String mobileInfo = admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().get(indexMobile).toString();
                    String hangSXInfo = admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getName().toUpperCase();
                    String depot = admin.getList().get(indexDepot).getName();
                    String addressDepot = admin.getList().get(indexDepot).getAddress();
                    System.out.println("Đơn vị sản xuất: " + hangSXInfo);
                    System.out.println("Đang có hàng tại kho: " + depot + "\nĐịa chỉ: " + addressDepot.toUpperCase());
                    System.out.println(mobileInfo);
                    System.out.println("----------------------------******----------------------------------------------");
                } else continue;
            }
            /*-------------------Chức năng cho thiết bị đó----------------------------------------------------------------*/
            System.out.println("Chức năng: ");
            System.out.println("\tE.Sửa\tD.Xóa\tQ.Quay lại\tT.Thoát");
            String choice = scanner.nextLine().toUpperCase();

            /*-----------Chọn chức năng điện thoại------------------------------------------------------------------------*/
            switch (choice) {
                case "E":
                    editMobile(indexDepot, indexHangSX, indexChoiceMobile);
                    return;
                case "D":
                    admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().remove(indexChoiceMobile);
                    break;
                case "Q":
                    return;
                case "T":
                    if (isCheckExitNow("Xác nhận thoát")) {
                        System.exit(0);
                    }
                    break;
            }
            break;

        } while (true);

    }

    private void editMobile(int indexDepot, int indexHangSX, int indexChoiceMobile) {

        System.out.println("----------------------Thay đổi thông tin thiết bị-------------------------------------------");
        System.out.println("*           1.Sửa tên                                                                      *");
        System.out.println("*           2.Sửa IME                                                                      *");
        System.out.println("*           3.Sửa giá                                                                      *");
        System.out.println("*           4.Sửa số lượng                                                                 *");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.print("*             Điều hướng:\tQ.Quay lại\tT.Thoát\n");
        System.out.println("-------------------------------******-------------------------------------------------------");
        String choiceEditMobile = scanner.nextLine();

        if (choiceEditMobile.equals("1")) {
            System.out.println("Nhập tên mới cho thiết bị.");
            String name = scanner.nextLine();
            if (isCheckExitNow("Xác nhận thay đổi tên")) {
                admin.getList().get(indexDepot).getListDepot().get(indexHangSX).
                        getListHangSX().get(indexChoiceMobile).setName(name);
                System.out.println("Tên đã được thay đổi.");
                return;
            } else {
                System.out.println("Tên chưa được thay đổi.");
                return;
            }
        }

        if (choiceEditMobile.equals("2")) {
            System.out.println("Nhập IME mới cho thiết bị.");
            int ime = scanner.nextInt();
            if (isCheckExitNow("Xác nhận thay đổi IME")) {
                admin.getList().get(indexDepot).getListDepot().get(indexHangSX).
                        getListHangSX().get(indexChoiceMobile).setIme(ime);
                System.out.println("IME đã được thay đổi.");
                return;
            } else {
                System.out.println("IME chưa được thay đổi.");
                return;
            }
        }
        scanner.nextLine();

        if (choiceEditMobile.equals("3")) {
            System.out.println("Nhập giá mới cho thiết bị.");
            int price = scanner.nextInt();
            if (isCheckExitNow("Xác nhận thay đổi giá thiết bị")) {
                admin.getList().get(indexDepot).getListDepot().get(indexHangSX).
                        getListHangSX().get(indexChoiceMobile).setPrice(price);
                return;
            } else {
                System.out.println("Giá chưa được thay đổi.");
                return;
            }
        }
        scanner.nextLine();

        if (choiceEditMobile.equals("4")) {
            System.out.println("Nhập số lượng mới cho thiết bị.");
            int amount = scanner.nextInt();
            if (isCheckExitNow("Xác nhận thay đổi số lượng")) {
                admin.getList().get(indexDepot).getListDepot().get(indexHangSX).
                        getListHangSX().get(indexChoiceMobile).setAmount(amount);
                return;
            } else {
                System.out.println("Số lượng chưa được thay đổi.");
                return;
            }
        }
        scanner.nextLine();
        if (choiceEditMobile.equals("Q")) {
            return;
        }
        if (choiceEditMobile.equals("T")) {
            if (isCheckExitNow("Xác nhận thoát")) {
                System.exit(0);
            }
        }

        if (choiceEditMobile.equals("5")) {
            System.out.println("Nhập Loại mới cho thiết bị.");
            int ime = scanner.nextInt();
            if (isCheckExitNow("Xác nhận thay đổi Loại thiết bị")) {
                admin.getList().get(indexDepot).getListDepot().get(indexHangSX).
                        getListHangSX().get(indexChoiceMobile).setIme(ime);
                System.out.println("Loại thiết bị đã được thay đổi.");
                return;
            } else {
                System.out.println("Loại thiết bị chưa được thay đổi.");
                return;
            }
        }
    }

    public boolean isCheckLogin() {
        do {
            System.out.print("Tên đăng nhập: ");
            String userName = scanner.nextLine();
            System.out.print("\nMật khẩu: ");
            int password = scanner.nextInt();
            scanner.nextLine();
            boolean isUser = userName.toUpperCase().equals(admin.getName().toUpperCase());
            boolean isPassword = (password == admin.getPassword());

            if (isUser && !isPassword) {
                System.out.println("Sai mật khẩu ! ");
                if (isCheckExitNow("Nhập lại")) {
                    continue;
                } else return false;
            }

            if (isPassword && !isUser) {
                System.out.println("Sai tên đăng nhập ! ");
                if (isCheckExitNow("Tiếp tục")) {
                    continue;
                } else return false;
            }

            if (!isPassword && !isUser) {
                System.out.println("Sai tên đăng nhập và mật khẩu");
                if (isCheckExitNow("Nhập lại")) {
                    continue;
                } else return false;
            }

            if (isPassword) {
                return true;
            }
        } while (true);


    }

    public boolean isCheckExitNow(String mess) {
        do {
            System.out.println(mess + ":\tC\\K");
            String choice = scanner.nextLine().toUpperCase();
            boolean isContinue = choice.equals("C");
            boolean isExitNow = choice.equals("K");
            if (isContinue) return true;
            if (isExitNow) return false;
            System.out.println("Cảnh báo nhập sai!");
        } while (true);
    }

    public void initHangSX(int indexDepot) {
        System.out.print("Nhập vào tên hãng: ");
        String nameHangSX = scanner.nextLine().toUpperCase();
        hangSX = new HangSX(nameHangSX);
        admin.getList().get(indexDepot).getListDepot().add(hangSX);
    }

    public void initAdmin() {
        System.out.print("Creat admin name\t");
        String nameAdmin = scanner.nextLine().toUpperCase();
        System.out.println("Creat PIN");
        int password = scanner.nextInt();
        scanner.nextLine();
        admin = new Admin(nameAdmin, password);
        System.out.println("Tài khoản của bạn đã được tạo thành công với user: " + nameAdmin + " và password: " + password + "\n" +
                "Không chia sẻ với bất cứ ai.\nThông tin liên hệ: thanhkhien1994@gmail.com");
    }

    public void initDepot() {
        System.out.print("Nhập vào tên kho\n");
        String nameDepot = scanner.nextLine().toUpperCase();
        System.out.print("Nhập vào địa chỉ kho\n");
        String address = scanner.nextLine();
        Depot depot = new Depot(nameDepot, address);
        admin.getList().add(depot);

    }

    public void initMobile(int indexHangSX, int indexDepot) {
        System.out.println("Nhập vào tên điện thoại");
        String nameMobile = scanner.nextLine();
        System.out.println("Nhập vào số IME điện thoại");
        int imeNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập vào số tiền");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Nhập vào số lượng điện thoại");
        int amountPhone = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập vào kiểu (Loại) thiết bị");
        String loaiMobile = scanner.nextLine();
        mobile = new Mobile(nameMobile, loaiMobile, imeNumber, price, amountPhone);
        admin.getList().get(indexDepot).getListDepot().get(indexHangSX).getListHangSX().add(mobile);
    }
}
