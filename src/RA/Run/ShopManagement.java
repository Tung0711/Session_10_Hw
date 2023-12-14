package RA.Run;

import RA.Presentation.CatalogMenu;
import RA.Presentation.ProductMenu;

import java.util.Scanner;

public class ShopManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatalogMenu ctl = new CatalogMenu();
        ProductMenu pro = new ProductMenu();
        //Hien thi menu
        do {
            System.out.println("************ SHOP MANAGEMENT ************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3.Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    ctl.displayCatalogMenu(scanner);
                    break;
                case 2:
                    pro.displayProductMenu(scanner);
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc, xin tạm biệt!");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp, vui lòng nhập lại!");
            }
        } while (true);
    }
}
