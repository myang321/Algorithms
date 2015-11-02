package CC150.Chapter7;

public class Question2 {

}

class System {
	private Fresher[] freshers;
	private TechnicalLead technicalLead;
	private ProductManager productManager;

	public Employee getCallHandler(String message) {
		for (Fresher f : freshers) {
			if (f.isFree()) {
				if (f.answerCall(message))
					return f;
				else
					break;
			}
		}
		if (technicalLead.isFree() && technicalLead.answerCall(message))
			return technicalLead;
		return productManager;
	}
}

class Employee {
	private String name;
	private int rank;
	private boolean free;

	public Employee(String name, int rank) {

	}

	public String getName() {
		return name;
	}

	public boolean isFree() {
		return free;
	}
}

interface Workable {
	// true: call done, false: need to escalate
	public boolean answerCall(String message);

}

class Fresher extends Employee implements Workable {

	public Fresher(String name) {
		super(name, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean answerCall(String message) {
		// TODO Auto-generated method stub
		return false;
	}

}

class TechnicalLead extends Employee implements Workable {

	public TechnicalLead(String name) {
		super(name, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean answerCall(String message) {
		// TODO Auto-generated method stub
		return false;
	}

}

class ProductManager extends Employee implements Workable {

	public ProductManager(String name) {
		super(name, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean answerCall(String message) {
		// TODO Auto-generated method stub
		return false;
	}

}
