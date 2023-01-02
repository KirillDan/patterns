package behavioral.observer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

interface Observer {
	public void update(String data);
}

class ConcreteObserver implements Observer {
	private Integer i = new Random().nextInt();

	@Override
	public void update(String data) {
		System.out.println(data + " " + i);
	}
	
}

interface Subject {
	public void attach(Observer observer);
	public void detach(Observer observer);
	public void notifyObservers();
}

class ConcreteSubject implements Subject {
	private String subjectState;
	private Set<Observer> observers = new HashSet();

	@Override
	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		this.observers.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.update(this.subjectState);
		}
	}

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
	}
}

public class ObserverMain {
	public static void main(String[] args) {
		Observer observer1 = new ConcreteObserver();
		Observer observer2 = new ConcreteObserver();
		ConcreteSubject concreteSubject = new ConcreteSubject();
		concreteSubject.attach(observer1);
		concreteSubject.attach(observer2);
		concreteSubject.setSubjectState("Hello");
		concreteSubject.notifyObservers();
	}
}
