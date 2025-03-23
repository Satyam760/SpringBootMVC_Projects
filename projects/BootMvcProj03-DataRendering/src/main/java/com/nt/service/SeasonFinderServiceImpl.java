package com.nt.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class SeasonFinderServiceImpl implements ISeasonFinderService {

	@Override
	public String findSeason() {
		//get system date
		LocalDate date =LocalDate.now();
		//get current month
		int month=date.getMonthValue();
		//find season
		if(month>=3 && month<=6) {
			return "Summer Season";
		}
		else if(month>=7 && month<=10) {
			return "Rainy Season";
		}
		else {
			return "Winter Season";
		}
		
	}

}
