/* This will be the database for Calculations*/

import java.util.*;
import 

public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	String activity, activityType, amount;

	while(true) {
		//ask for input
		activity = new input.next();

		activityType = new input.next();

		amount = new input.nextInt();

		if(stringCheck(activity) && stringCheck(activityType) && stringCheck(amount)){
			break;
		}

	}

	//Questions which will populate each class 
	// food

	System.out.println("Your diet:\n meat heavy, mixed, pescetarian, vegetarian, vegan");

	



}

public static boolean stringCheck(String test) {

	if(test.equals("Transportation") {
		return false;
	}

	else if(test.equals("Waste") {
		return false;
	}

	else if(test.equals("Food")) {
		return false;
	}

	else if(test.equals("Water")) {
		return false;
	}

	else if(test.matches("[-+]?\\d*\\.?\\d+") {
		return true;
	}

	else {
		return true; 
	}
}
