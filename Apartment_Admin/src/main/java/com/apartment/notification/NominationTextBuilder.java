package com.apartment.notification;

import java.time.LocalDate;

public class NominationTextBuilder {

	public static String buildText(String name, String position, String election, LocalDate date) {
		StringBuffer stb = new StringBuffer("");
		stb.append("Hello ").append(name).append(",");
		stb.append("<br>");
		stb.append("You have applied in election ").append(election)
			.append(" which is held on ").append(date.toString())
			.append(" for the position of ").append(position).append(".");
		stb.append("Please contact election committee in case of any change.");
		stb.append("<br><br>");
		stb.append("Regards,");
		stb.append("<br>");
		stb.append("Cityviews Election Committee");
		return stb.toString();
	}
	
	public static String getSubject() {
		return "Cityviews | Election Nomination";
	}
}
