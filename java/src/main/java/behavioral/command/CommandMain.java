package behavioral.command;

interface Command {
	public void execute();
}

class Receiver {
	public void prepateAction() {
		System.out.println("prepare action");
	}
	
	public void finalAction() {
		System.out.println("final action");
	}
	
	public void action1() {
		System.out.println("make action1");
	}
	
	public void action2() {
		System.out.println("make action2");
	}
}

class ConcreteCommand1 implements Command {
	private Receiver receiver;

	public ConcreteCommand1(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		this.receiver.prepateAction();
		this.receiver.action1();
		this.receiver.finalAction();
	}
}

class ConcreteCommand2 implements Command {
	private Receiver receiver;

	public ConcreteCommand2(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		this.receiver.prepateAction();
		this.receiver.action2();
		this.receiver.finalAction();
	}
}

class Invoker {
	private Command concreteCommand1;
	private Command concreteCommand2;
	
	public Invoker(Command concreteCommand1, Command concreteCommand2) {
		this.concreteCommand1 = concreteCommand1;
		this.concreteCommand2 = concreteCommand2;
	}
	
	public void makeAction1() {
		this.concreteCommand1.execute();
	}
	
	public void makeAction2() {
		this.concreteCommand2.execute();
	}
}

public class CommandMain {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command concreteCommand1 = new ConcreteCommand1(receiver);
		Command concreteCommand2 = new ConcreteCommand2(receiver);
		Invoker invoker = new Invoker(concreteCommand1, concreteCommand2);
		invoker.makeAction1();
		System.out.println();
		invoker.makeAction2();
	}
}
