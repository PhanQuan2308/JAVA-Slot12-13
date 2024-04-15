package bank.t2108a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static long balanceNumber = 1000000;
    List<TransactionHistory> listHistory = new ArrayList<>();

    public long getBalanceNumber(){
        return balanceNumber;
    }

    public void actionTransfer(){
        Scanner sc = new Scanner(System.in);

        // Nhập số tài khoản người nhận và mô tả số tiền chuyển khoản
        System.out.println("Nhập số tài khoản người nhận: ");
        String beneficiaryAccount = sc.nextLine();

        System.out.println("Nhập số tiền cần chuyển: ");
        long transferAmount = sc.nextLong();

        System.out.println("Nhập mô tả: ");
        sc.nextLine(); // Đọc dòng trống
        String description = sc.nextLine();

        // Kiểm tra tài khoản và mật khẩu
        System.out.println("Nhập số điện thoại: ");
        String mobile = sc.nextLine();

        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();

        ValidateAccount validateAccount = new ValidateAccount();

        boolean isValid = validateAccount.checkAccount(mobile, password);
        if(isValid){
            if(transferAmount < 50000){
                System.out.println("Số tiền cần chuyển > 50000");
            }
            if(transferAmount > balanceNumber){
                System.out.println("Số dư không đủ");
            }else {
                balanceNumber -= transferAmount;
                System.out.println("Chuyển tiền thành công ");
                System.out.println("Số dư mới: " + balanceNumber);

                TransactionHistory transactionHistory = new TransactionHistory(description, beneficiaryAccount,transferAmount);
                listHistory.add(transactionHistory);
            }
        }else{
            System.out.println("Xác thực không thành công, vui lòng kiểm tra lại");
        }
    }


    public void getHistory() {
        if (listHistory.isEmpty()) {
            System.out.println("Không có giao dịch nào được thực hiện.");
        } else {

            for (TransactionHistory transaction : listHistory) {
                System.out.println(transaction.toString());
            }
        }
    }




}
