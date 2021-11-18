package com.example;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

@SuppressWarnings("deprecation")
public class StudyLegacyObserver {

	public static void main(String[] args) {
		var events = List.of(
			new TradeEvent("orcl", 100, 5_000),	
			new TradeEvent("orcl", 200, 2_000),	
			new TradeEvent("ibm", 300, 3_000),	
			new TradeEvent("gogle", 400, 4_000),	
			new TradeEvent("msft", 500, 5_000)	
		);
		var observable = new TradeObservable();
		Observer slowObserver = (o,event) -> {
			try { TimeUnit.SECONDS.sleep(3);}catch (Exception e) {}
			System.err.println("Slow observer has processed the event "+event);
		};
		Observer fastObserver = (o,event) -> {
			System.err.println("Fast observer has processed the event "+event);
		};
		observable.addObserver(slowObserver);
		observable.addObserver(fastObserver);
		events.forEach(observable::notifyObservers);
		System.err.println("Done.");
	}

}

@SuppressWarnings("deprecation")
class TradeObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}

}