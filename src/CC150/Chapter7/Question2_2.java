package CC150.Chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question2_2 {

}

class CallHandler {
	static final int LEVELS = 3; // we have 3 levels of employees
	static final int NUM_FRESHERS = 5; // we have freshers
	ArrayList<Employee2>[] employeeLevels = new ArrayList[LEVELS];
	// queues for each call¡¯s rank
	Queue<Call>[] callQueues = new LinkedList[LEVELS];

	public CallHandler() {
		// ...
	}

	Employee2 getCallHandler(Call call) {
		for (int level = call.rank; level < LEVELS - 1; level++) {
			ArrayList<Employee2> employeeLevel = employeeLevels[level];
			for (Employee2 emp : employeeLevel) {
				if (emp.free) {
					return emp;
				}
			}
		}
		return null;
	}

	// routes the call to an available employee, or adds to a queue
	void dispatchCall(Call call) {
		// try to route the call to an employee with minimal rank
		Employee2 emp = getCallHandler(call);
		if (emp != null) {
			emp.ReceiveCall(call);
		} else {
			// place the call into queue according to its rank
			callQueues[call.rank].add(call);
		}
	}

	void getNextCall(Employee2 e) {
		// ...
	} // look for call for e¡¯s rank

}

class Call {
	int rank = 0; // minimal rank of employee who can handle this call

	public void reply(String message) { // ...

	}

	public void disconnect() { // ...

	}
}

class Employee2 {
	CallHandler callHandler;
	int rank; // 0- fresher, 1 - technical lead, 2 - product manager
	boolean free;

	Employee2(int rank) {
		this.rank = rank;
	}

	void ReceiveCall(Call call) {
		// ...
	}

	void CallHandled(Call call) {
		// ...
	} // call is complete

	void CannotHandle(Call call) { // escalate call
		call.rank = rank + 1;
		callHandler.dispatchCall(call);
		free = true;
		callHandler.getNextCall(this); // look for waiting call
	}
}

class Fresher2 extends Employee2 {
	public Fresher2() {
		super(0);
	}
}

class TechLead extends Employee2 {
	public TechLead() {
		super(1);
	}
}

class ProductManager2 extends Employee2 {
	public ProductManager2() {
		super(2);
	}
}