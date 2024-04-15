package bank.t2108a;

public class ValidateAccount {
    public final  String MOBILE = "123";
    public final String Password = "Quan";
    public boolean checkAccount(String mobile, String password){
        if(mobile.equals(MOBILE)){
            if(password.equals(Password)){
                System.out.println("Đăng nhập thaành công!");
                return true;
            }else {
                System.out.println("Sai mật khẩu");
                return false;
            }
        }else {
            System.out.println("Sai số điện thoại hoặc mật khẩu ");
            return  false;
        }
    }
}
