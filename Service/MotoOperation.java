package Service;

import java.util.ArrayList;
import java.util.HashSet;
import Model.Bus;
import Model.Car;
import Model.MotoVehicle;

/**
 * 汽车业务
 */
public class MotoOperation {
	public ArrayList<MotoVehicle> motos = new ArrayList<MotoVehicle>();
	private HashSet<String> CarBrandSet = new HashSet<String>();
	private HashSet<String> CarTypeSet = new HashSet<String>();
	private HashSet<String> BusBrandSet = new HashSet<String>();
	private HashSet<Integer> BusSeatSet = new HashSet<Integer>();

	public void init(){
		AddCar("京NY28588", "宝马", "X6",800);
		AddCar("京CNY3284", "宝马", "550i",600);
		AddCar("京NT37465", "别克", "林荫大道",300);
		AddCar("京NT96968", "别克", "GL8",600);
		AddBus("京6566754", "金杯", 16,800);
		AddBus("京8696997", "金龙", 16,800);
		AddBus("京9696996", "金杯", 34,1500);
		AddBus("京8696998", "金龙", 34,1500);
	}

	public void AddCar(String vehicleId, String Brand, String Type, int price){
		motos.add(new Car(vehicleId, Brand, Type, price));
		CarBrandSet.add(Brand);
		CarTypeSet.add(Type);
	}
	public void AddBus(String vehicleId, String Brand, int seatCount, int price){
		motos.add(new Bus(vehicleId, Brand, seatCount, price));
		BusBrandSet.add(Brand);
		BusSeatSet.add(seatCount);
	}
	
	public HashSet<String> getCarBrandSet() {
		return CarBrandSet;
	}

	public HashSet<String> getCarTypeSet() {
		return CarTypeSet;
	}

	public HashSet<String> getBusBrandSet() {
		return BusBrandSet;
	}

	public HashSet<Integer> getBusSeatSet() {
		return BusSeatSet;
	}

	/**
	 * 租赁汽车 
	 * @return 汽车
	 */
	public MotoVehicle motoLeaseOut(String brand,String type,int seat){
		MotoVehicle moto=null;
		for (MotoVehicle mymoto : motos) {
			if(mymoto instanceof Car){
				Car car=(Car)mymoto;
				if(car.getBrand().equals(brand)&&car.getType().equals(type)){
					moto=car;
					break;
				}
			}else{
				Bus bus=(Bus)mymoto;
				if(bus.getBrand().equals(brand)&&bus.getSeatCount()==seat){
					moto=bus;
					break;
				}
			}
		}
		return moto;//返回一个汽车对象
	}
}
