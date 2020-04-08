package cars.vendors;

import cars.Car;

public class Maruti extends Car {

	public void sayName() {
		System.out.println( "I am a Maruti Car" );
	}

	public static void main( String ... args ) {
		
		Maruti maruti = new Maruti();
		maruti.display();

		Car car = new Maruti();
		car.display();

		Car abstractCar = new Car();
		abstractCar.display();
	}
}
