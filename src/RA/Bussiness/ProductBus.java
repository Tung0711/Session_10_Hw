package RA.Bussiness;

import RA.Entity.Categories;
import RA.Entity.Product;

import java.util.*;

import static RA.Presentation.CatalogMenu.lsCatalog;
import static RA.Presentation.ProductMenu.lsPro;

public class ProductBus {

    public void inputPro(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm cần nhập thông tin:");
        int n = 0;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < n; i++) {
            Product pro = new Product();
            pro.inputData(scanner);
            lsPro.add(pro);
        }
    }

    public void displayPro() {
        System.out.println("THÔNG TIN CÁC SẢN PHẨM:");
        for (int i = 0; i < lsCatalog.size(); i++) {
            lsPro.get(i).displayData();
        }
    }

    public void updatePro(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm cần cập nhật:");
        int proIdUpdate = 0;
        try {
            proIdUpdate = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        boolean find = false;
        for (int i = 0; i < lsPro.size(); i++) {
            Product pro = lsPro.get(i);
            if (pro.getCatalogId() == proIdUpdate) {
                pro.inputPrice(scanner);
                System.out.println("Giá sản phẩm đã được cập nhật thành công!");
                find = true;
                break;
            }
        }
        if (!find) {
            System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại!");
        }
    }

    public void deletePro(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần xóa:");
        try {
            String proIdDelete = scanner.nextLine();
            boolean isDelete = false;
            for (Product product : lsPro) {
                if (product.getProductId().equals(proIdDelete)) {
                    lsPro.remove(product);
                    isDelete = true;
                    System.out.println("Xóa sản phẩm thành công!");
                    break;
                }
            }
            if (!isDelete) {
                System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sortProByPrice() {
        System.out.println("Sắp xếp sản phẩm theo giá sản phẩm tăng dần: ");
        Collections.sort(lsPro, Comparator.comparing(Product::getPrice));
    }

    public void sortProByName() {
        System.out.println("Sắp xếp sản phẩm theo tên tăng dần: ");
        Collections.sort(lsPro, Comparator.comparing(Product::getProductName));
    }

    public void findPro(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm: ");
        try {
            String findProductName = scanner.nextLine();
            boolean isFindPro = lsPro.stream().anyMatch(product -> product.getProductName().equalsIgnoreCase(findProductName));
            if (!isFindPro) {
                System.err.println("Sản phẩm không tồn tại!");
            } else {
                lsPro.stream().filter(product -> product.getProductName().equalsIgnoreCase(findProductName)).forEach(System.out::println);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void quantityStatisticsProduct() {
        try {
            for (Categories ctl : lsCatalog) {
                long countCatalog = lsPro.stream().filter(product -> product.getCatalogId() == ctl.getCatalogId()).count();
                System.out.printf("%s có chứa %d sản phẩm\n", ctl.getCatalogName(), countCatalog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
