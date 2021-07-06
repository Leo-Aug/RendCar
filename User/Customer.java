package User;

import Service.MotoOperation;
import Model.*;
import java.util.Scanner;

public class Customer extends User implements CustomerInterface {

    @Override
    public void RentCar(MotoOperation motoMgr) {
        Scanner input=new Scanner(System.in);
        MotoVehicle moto=null;//汽车
		System.out.println("***********欢迎光临汽车租赁公司***********");
		System.out.println("1、轿车 \t2、客车");		
		System.out.print("请选择你要租赁的汽车类型：");	
		int motoType=input.nextInt();
		String brand="";
		String type="";
		int seat=0;
		if(motoType==1){
			System.out.print("请选择你要租赁的汽车品牌：");
            for(String car_brand : motoMgr.getCarBrandSet()){
                System.out.print(car_brand + " ");
            }
			brand=input.next();
			System.out.print("请选择你要租赁的汽车类型：");
            for(String car_type : motoMgr.getCarTypeSet()){
                System.out.print(car_type + " ");
            }
			type=input.next();
		}else if(motoType==2){
			type="";
			System.out.print("请选择你要租赁的汽车品牌：");	
            for(String bus_brand : motoMgr.getBusBrandSet()){
                System.out.print(bus_brand + " ");
            }
			brand=input.next();
			System.out.print("请选择你要租赁的汽车座位数：");
            for(int bus_seatcount : motoMgr.getBusSeatSet()){
                System.out.print(bus_seatcount + " ");
            }
			seat=input.nextInt();
		}
		moto=motoMgr.motoLeaseOut(brand,type,seat);//获得 
		System.out.print("请输入您要租赁的天数：");
		int days=input.nextInt();
		double money=moto.calRent(days);//租赁费用
		System.out.println("分配给您的汽车牌号是："+moto.getVehicleId());
		System.out.println("您需要支付的租赁费用是："+money+"元。");
    }
    
}
