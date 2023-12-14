package RA.Presentation;

import RA.Bussiness.ProductBus;
import RA.Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    ProductBus pro = new ProductBus();
    public static List<Product> lsPro = new ArrayList<>();

    public void displayProductMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("************ PRODUCT MANAGEMENT ************");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Cập nhật giá sản phẩm theo mã sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo tên tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục sản phẩm");
            System.out.println("8. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("9. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    pro.inputPro(scanner);
                    break;
                case 2:
                    pro.displayPro();
                    break;
                case 3:
                    pro.updatePro(scanner);
                    break;
                case 4:
                    pro.deletePro(scanner);
                    break;
                case 5:
                    pro.sortProByPrice();
                    break;
                case 6:
                    pro.sortProByName();
                    break;
                case 7:
                    pro.quantityStatisticsProduct();
                    break;
                case 8:
                    pro.findPro(scanner);
                    break;
                case 9:
                    isExit = false;
                    break;
                default:
                    System.err.println("Lựa chọn không phù hợp, vui lòng nhập lại!");
            }
        } while (isExit);
    }
}
