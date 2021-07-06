package Service;

import java.util.Scanner;
import User.*;

public class Login {
    public static boolean DecideCanLogin(String username, String password){
        if(username.equals(password)){
            System.out.println("登陆成功");
            return true;
        }else{
            System.out.println("登陆失败，请重新登陆");
            return false;
        }
    }
    public static User login(){
		Scanner input = new Scanner(System.in);
		String username = null;
		String password = null;
        do{
		    System.out.print("请输入用户名：");
		    username = input.next();
		    System.out.print("请输入密码：");
		    password = input.next();
        }while(!DecideCanLogin(username, password));

        if(username.equals("admin")){
            return new Manager();
        }else{
            return new Customer();
        }
	}
}
