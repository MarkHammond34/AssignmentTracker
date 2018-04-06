package edu.ben.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

import edu.ben.models.Assignment;

public class Priority {

	public static int getPriorityLevel(Assignment a) {

		long timeRequiredInMil = a.getTimeRequired() * 60 * 100;

		if (a.getDue().after(new Timestamp(System.currentTimeMillis() + timeRequiredInMil))) {
			return 1;
		} else if (a.getDue().before(new Timestamp(System.currentTimeMillis()))) {
			return 1;
		} else {
			long timeUntilDueInMil = System.currentTimeMillis() - a.getDue().getTime();
			if (timeUntilDueInMil < (3 * 60 * 60 * 100) && a.getDifficulty() > 4) {
				return 2;
			}
		}
		return 3;
	}

	public static ArrayList<Assignment> sortByPriority(ArrayList<Assignment> list) {

		for (Assignment a : list) {
			a.setPriority(getPriorityLevel(a));
		}

		if (list.size() > 1) {
			Collections.sort(list);
		}

		return list;
	}

}
