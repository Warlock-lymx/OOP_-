package com.huawei.classroom.student.h07;

public class Barrack extends Building {

	public Barrack(int x, int y) {

		super(x,y);
		// super( Param.BARRACK_HEALTH,Param.BARRACK_STRENGTH);
		// TODO Auto-generated constructor stub
	}

	public GameObject traing(EnumObjectType type) {


		if (type == EnumObjectType.rifleSoldier) {
			GameObject gameObject = new RifleSoldier(this.getX(),this.getY());
			gameObject.setHealth(50);
			gameObject.setStrength(5);
			gameObject.setRange(5);
			return gameObject;
		} else if (type == EnumObjectType.RPGSoldier) {
			GameObject gameObject = new RPGSoldier(this.getX(),this.getY());
			gameObject.setHealth(50);
			gameObject.setStrength(10);
			gameObject.setRange(10);
			return gameObject;
		} else if (type == EnumObjectType.dog) {
			GameObject gameObject = new Dog(this.getX(),this.getY());
			gameObject.setHealth(50);
			gameObject.setStrength(5);
			gameObject.setRange(5);
			return gameObject;
		}
		else
			return null;
	}

}
