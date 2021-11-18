package com.example;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Flow.Subscription;

import com.example.event.TradeEvent;
// Java SE 9 : Flow API -> concurrency package -> reactive programming
public class StudyReactiveProgramming {
	public static void main(String[] args) {
		var events = List.of(new TradeEvent("orcl", 100, 5_000), new TradeEvent("orcl", 200, 2_000),
				new TradeEvent("ibm", 300, 3_000), new TradeEvent("gogle", 400, 4_000),
				new TradeEvent("msft", 500, 5_000));
		SubmissionPublisher<TradeEvent> publisher = new SubmissionPublisher<>();
		publisher.subscribe(new Algotrading());
		publisher.subscribe(new MetricGenerator());
		events.forEach(publisher::submit);
		publisher.close();
		try {TimeUnit.SECONDS.sleep(20);} catch (Exception e) {}
		System.err.println("Application is done.");
	}
}

class Algotrading implements Flow.Subscriber<TradeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		try {TimeUnit.SECONDS.sleep(3);} catch (Exception e) {}
		System.err.println("Algotrading has received new event: " + event);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error: " + throwable.getMessage());

	}

	@Override
	public void onComplete() {
		System.err.println("Algotrading has been completed!");
	}

}

class MetricGenerator implements Flow.Subscriber<TradeEvent> {
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}
	
	@Override
	public void onNext(TradeEvent event) {
		System.err.println("MetricGenerator has received new event: " + event);
		subscription.request(1);
	}
	
	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error: " + throwable.getMessage());
		
	}
	
	@Override
	public void onComplete() {
		System.err.println("MetricGenerator has been completed!");
	}
	
}
