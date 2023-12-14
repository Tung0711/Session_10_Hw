package RA.Bussiness;

import RA.Entity.Categories;

import java.util.Scanner;

import static RA.Presentation.CatalogMenu.lsCatalog;

public class CatalogBus {

    public void inputCategories(Scanner scanner) {
        System.out.println("Nhập vào số lượng danh mục cần nhập thông tin:");
        int n = 0;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Số lượng danh mục là số nguyên, vui lòng nhập lại!");
        }
        for (int i = 0; i < n; i++) {
            Categories catalog = new Categories();
            catalog.inputData(scanner);
            lsCatalog.add(catalog);
        }
    }

    public void displayCategories() {
        System.out.println("THÔNG TIN CÁC DANH MỤC:");
        for (int i = 0; i < lsCatalog.size(); i++) {
            lsCatalog.get(i).displayData();

        }
    }

    public void updateCategories(Scanner scanner) {
        System.out.println("Nhập mã danh mục cần cập nhật:");
        int catalogIdUpdate = 0;
        try {
            catalogIdUpdate = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Mã danh mục là số nguyên, vui lòng nhập lại!");
        }
        boolean find = false;
        for (int i = 0; i < lsCatalog.size(); i++) {
            Categories catalog = lsCatalog.get(i);
            if (catalog.getCatalogId() == catalogIdUpdate) {
                catalog.inputName(scanner);
                System.out.println("Tên danh mục đã được cập nhật thành công!");
                find = true;
                break;
            }
        }
        if (!find) {
            System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại!");
        }
    }

    public void deleteCatalog(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        int catalogIdDelete = 0;
        try {
            catalogIdDelete = Integer.parseInt(scanner.nextLine());
            boolean isDelete = false;
            for (Categories ctl : lsCatalog) {
                if (ctl.getCatalogId() == catalogIdDelete) {
                    lsCatalog.remove(ctl);
                    isDelete = true;
                    System.out.println("Xóa danh mục thành công!");
                    break;
                }
            }
            if (!isDelete) {
                System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
