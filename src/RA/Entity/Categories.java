package RA.Entity;

import RA.IShop;

import java.util.Scanner;

import static RA.Presentation.CatalogMenu.lsCatalog;

public class Categories implements IShop {
    //Cac thuoc tinh cua lop categories
    private int catalogId;
    private String catalogName;
    private boolean status;

    //Constructor khong tham so
    public Categories() {
    }

    //Constructor co tham so
    public Categories(int catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    //Cac phuong thuc getter/setter
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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
        this.catalogId = catalogIdAuto();
        this.catalogName = inputName(scanner);
        this.status = inputStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s - Trạng thái danh mục: %s\n",
                this.catalogId, this.catalogName, this.status ? "Còn hàng" : "Hết hàng");
    }

    public int catalogIdAuto() {
        //Ma danh muc tu dong tang
        if (lsCatalog.size() == 0) {
            return 1;
        } else {
            int max = lsCatalog.get(0).getCatalogId();
            for (int i = 0; i < lsCatalog.size(); i++) {
                if (max < lsCatalog.get(i).getCatalogId()) {
                    max = lsCatalog.get(i).getCatalogId();
                }
            }
            return max + 1;
        }
    }

    public String inputName(Scanner scanner) {
        System.out.println("Nhập vào tên danh mục: ");
        do {
            try {
                String name = scanner.nextLine();
                if ((name.length() >= 6) && (name.length() < 30)) {
                    boolean isExist = false;
                    for (int i = 0; i < lsCatalog.size(); i++) {
                        if (lsCatalog.get(i).getCatalogName().equalsIgnoreCase(name)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại!");
                    } else {
                        return name;
                    }
                } else {
                    System.err.println("Tên danh mục có từ 6-30 ký tự, vui lòng nhập lại!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
    }

    public boolean inputStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái danh mục: ");
        do {
            try {
                String status = scanner.nextLine();
                if (status.equals("true") || status.equals("false")) {
                    return Boolean.parseBoolean(status);
                } else {
                    System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, Vui lòng nhập lại!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
    }

    public void updateCatalog(Scanner scanner) {
        //Cập nhật danh mục
        boolean isExit = true;
        do {
            System.out.println("1. Cập nhật tên danh mục: ");
            System.out.println("2. Cập nhật trạng thái danh mục: ");
            System.out.println("3. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if ((choice != 1) && (choice != 2) && (choice != 3)) {
                }
            } catch (NumberFormatException ex) {
                System.err.println("Lựa chọn không phù hợp, vui lòng nhập lại!");
                ex.printStackTrace();
            }
            switch (choice) {
                case 1:
                    this.catalogName = inputName(scanner);
                    break;
                case 2:
                    this.status = inputStatus(scanner);
                    break;
                default:
                    isExit = false;
            }
        } while (isExit);
    }
}
