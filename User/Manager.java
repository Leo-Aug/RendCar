package User;

import Service.MotoOperation;
import java.util.Scanner;

public class Manager extends User implements ManagerInterface {

    @Override
    public void BuyCar(MotoOperation motoMgr) {
        // TODO Auto-generated method stub
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎你，管理员。");
        System.out.println("1、轿车 \t2、客车");		
		System.out.print("请选择你要购入的汽车类型：");	
		int motoType=input.nextInt();
		String brand="";
		String type="";
		int seat=0;
        String id = null;
        int price = 0;
		if(motoType==1){
			System.out.print("请输入你要购入的汽车品牌：");
			brand=input.next();
			System.out.print("请输入你要购入的汽车类型：");
			type=input.next();
            System.out.print("请输入车牌：");
            id=input.next();
            System.out.print("请输入价格：");
            price = input.nextInt();
            motoMgr.AddCar(id, brand, type, price);
		}else if(motoType==2){
			type="";
			System.out.print("请输入你要购入的汽车品牌：");	
			brand=input.next();
			System.out.print("请输入你要购入的汽车座位数：");
			seat=input.nextInt();
            System.out.print("请输入车牌：");
            id=input.next();
            System.out.print("请输入价格：");
            price = input.nextInt();
            motoMgr.AddBus(id, brand, seat, price);
		}
        System.out.println("购买成功");
    }
    
}
