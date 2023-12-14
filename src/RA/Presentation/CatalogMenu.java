package RA.Presentation;

import RA.Bussiness.CatalogBus;
import RA.Entity.Categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMenu {
    CatalogBus cat = new CatalogBus();
    public static List<Categories> lsCatalog = new ArrayList<>();

    public void displayCatalogMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("************ CATALOG MANAGEMENT ************");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật tên danh mục theo mã danh mục");
            System.out.println("4. Xóa danh mục theo mã danh mục");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    cat.inputCategories(scanner);
                    break;
                case 2:
                    cat.displayCategories();
                    break;
                case 3:
                    cat.updateCategories(scanner);
                    break;
                case 4:
                    cat.deleteCatalog(scanner);
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("Lựa chọn không phù hợp, Vui lòng nhập lại!");
            }
        } while (isExit);
    }
}
