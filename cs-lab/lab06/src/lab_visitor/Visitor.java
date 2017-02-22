package lab_visitor;

import java.util.LinkedList;

public interface Visitor {
	public void visit(Employee e);
	public void visit(Boss b);	
	public void visit(Intern i);
}

/**
 * Visitor for printing an employee's data. Applies the operation only on objects
 * that implement Visitable, currently Employee and Boss.
 *
 */
class RevenueVisitor implements Visitor { 
	@Override
	public void visit(Employee e) {
		System.out.println("E: " + e.getName() + " " + e.getSalary());
	}  
	@Override
	public void visit(Boss b) {
		System.out.println("B: " + b.getName() + " " + (b.getSalary() + b.getBonus()));
	}
	@Override
	public void visit(Intern i) {
		System.out.println("I: " + i.getName());
	}
}

/**
 * Visitor for finding if the average number of extra hours for bosses is higher
 * than the one for employees.
 * 
 * Interns are not taken into consideration.
 */

class MostHardworkingEmployeeFinder implements Visitor {
	private static float extraHoursEmp = 0;
	private static float extraHoursBoss = 0;
	private static int nEmp = 0;
	private static int nBoss = 0;
	
	@Override
	public void visit(Employee e) {
		extraHoursEmp += e.extraHours;
		nEmp++;
	}

	@Override
	public void visit(Boss b) {
		extraHoursBoss += b.extraHours;
		nBoss++;
	}
	
	public boolean isBossHardWorking() {
		return (extraHoursBoss/nBoss > extraHoursEmp/nEmp);
	}

	@Override
	public void visit(Intern i) {
		System.out.println("I: " + i.getName());
	}	
}


/**
 * Visitor for tree traversal - separate the concerns: a visitor for data
 * operations (e.g. compute average percentage) and this visitor for traversing
 * the nodes and applying the operation visitor.
 */

class TreeVisitor implements Visitor {

	private Visitor baseVisitor;

	public TreeVisitor(Visitor baseVisitor) {
		this.baseVisitor = baseVisitor;
	}

	@Override
	public void visit(Employee e) {
		//System.out.println("tree E: " + e.getName() + " " + e.getSalary());
		baseVisitor.visit(e);
	}

	@Override
	public void visit(Boss b) {
		LinkedList<Visitable> subord = b.getSubordinates();
		for(Visitable s: subord) {
			s.accept(this);
		}
		//System.out.println("tree B: " + b.getName() + " " + (b.getSalary() + b.getBonus()));
		baseVisitor.visit(b);
	}

	public Visitor getBaseVisitor() {
		return baseVisitor;
	}

	@Override
	public void visit(Intern i) {
		System.out.println("I: " + i.getName());
	}
}