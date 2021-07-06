package Service;
import User.*;
/**
 * 汽车租赁管理类
 */
public class RentMgrSys {
	public static void main(String[]args){
		MotoOperation motoMgr=new MotoOperation();
		motoMgr.init();
		User user = Login.login();
		if(user instanceof Manager){
			((Manager)user).BuyCar(motoMgr);
		}else{
			((Customer)user).RentCar(motoMgr);
		}
	}
}
