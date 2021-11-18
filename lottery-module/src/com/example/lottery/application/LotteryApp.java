package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.impl.StandardLotteryService;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

public class LotteryApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		var sls = new StandardLotteryService();
		var implementations = ServiceLoader.load(RandomNumberService.class);		
		var props = new Properties();
		props.load(new FileInputStream(new File("src","application.properties")));
		var level = QualityLevel.valueOf(props.get("randomNumberService").toString());
		for (var implementation : implementations) {
			var clazz = implementation.getClass();
			if (clazz.isAnnotationPresent(ServiceQuality.class)) {
				var serviceQuality = clazz.getAnnotation(ServiceQuality.class);
				if (serviceQuality.value() == level) {
					sls.setRandomNumberService(implementation);
				}
			}
		}
		sls.draw(60, 6, 10).forEach(System.err::println);
	}

}
