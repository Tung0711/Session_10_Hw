package RA.Entity;

import RA.IShop;

import java.util.List;
import java.util.Scanner;

import static RA.Presentation.CatalogMenu.lsCatalog;
import static RA.Presentation.ProductMenu.lsPro;

public class Product implements IShop {
    //Cac thuoc tinh lop Product
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean status;

    //Constructor ko tham so
    public Product() {
    }

    //Constructor co tham so
    public Product(String productId, String productName, float price, String title, int catalogId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    //Cac phuong thuc getter/setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //Cac phuong thuc inputData va displayData
    @Override
    public void inputData(Scanner scanner) {
        this.productId = inputProId(scanner);
        this.productName = inputProductName(scanner);
        this.price = inputPrice(scanner);
        System.out.println("Nhập vào tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();
        this.catalogId = inputCatalogId(scanner);
        this.status = inputProductStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá sản phẩm: %.1f", this.productId, this.productName, this.price);
        System.out.printf("Tiêu đề: %s - Mã danh mục: %d - Trạng thái sản phẩm: %b", this.title, this.catalogId, this.status);
    }

    public String inputProId(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm: ");
        do {
            try {
                String productId = scanner.nextLine();
                if (productId.length() == 5) {
                    if (productId.charAt(0) == 'P') {
                        boolean isExit = false;
                        for (int i = 0; i < lsPro.size(); i++) {
                            if (lsPro.get(i).getProductId().equals(productId)) {
                                isExit = true;
                                break;
                            }
                        }
                        if (isExit) {
                            System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại!");
                        } else {
                            return productId;
                        }
                    } else {
                        System.err.println("Mã sản phẩm bắt đầu là P, Vui lòng nhập lại!");
                    }
                } else {
                    System.err.println("Mã sản phẩm gồm 5 ký tự, vui lòng nhập lại!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner) {
        //Nhập tên sản phẩm
        System.out.println("Nhập tên sản phẩm: ");
        do {
            try {
                String productName = scanner.nextLine();
                boolean isExist = false;
                for (int i = 0; i < lsPro.size(); i++) {
                    if (lsPro.get(i).getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại!");
                } else {
                    return productName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Nhập giá sản phẩm: ");
        do {
            float price = 0;
            try {
                price = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (price > 0) {
                return price;
            } else {
                System.err.println("Giá sản phẩm phải có giá trị lớn hơn 0, vui lòng nhập lại!");
            }
        } while (true);
    }

    public int inputCatalogId(Scanner scanner) {
        System.out.println("Chọn danh mục của sản phẩm: ");
        for (int i = 0; i < lsCatalog.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, lsCatalog.get(catalogId).getCatalogName());
        }
        System.out.println("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        return lsCatalog.get(choice - 1).getCatalogId();
    }

    public boolean inputProductStatus(Scanner scanner) {
        //Nhập trạng thái sản phẩm
        System.out.println("Nhập trạng thái sản phẩm: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái sản phẩm chỉ nhận giá trị true hoặc false, vui lòng nhập lại!");
            }
        } while (true);
    }
}
