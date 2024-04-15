package bank.t2108a;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidateAccount validate = new ValidateAccount();
        Controller controller = new Controller();

        boolean isCheck = false;
        while (!isCheck){
            System.out.println("Nhập số điện thoại: ");
            String mobile = sc.nextLine();

            System.out.println("Nhập mật khẩu: ");
            String password = sc.nextLine();

            isCheck = validate.checkAccount(mobile, password);

        }
        while (true){
            menu();
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Số dư: ");
                    long balane = controller.getBalanceNumber();
                    System.out.println(balane);
                    break;

                case 2:
                    controller.actionTransfer();
                    break;
                case 3:
                    System.out.println("Lịch sử giao dịch: ");
                    controller.getHistory();
                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }

    }
    public static void  menu(){
        System.out.println("Lựa chọn của bạn: ");
        System.out.println("1: Xem số dư tài khoản");
        System.out.println("2: Chuyển khoản");
        System.out.println("3: Xem lịch sử giao dịch");
        System.out.println("0: Thoát");
    }
}
