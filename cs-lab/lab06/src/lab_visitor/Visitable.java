package lab_visitor;

import java.util.LinkedList;


public interface Visitable {
	public void accept(Visitor v);
}

class Employee implements Visitable{
	protected String  name;
	protected float salary;
	protected float extraHours;
	
	public Employee(String name, float salary) {
		this.name       = name;
		this.salary     = salary;
	}
	
	public Employee(String name, float salary, float extraHours) {
		this.name       = name;
		this.salary     = salary;
		this.extraHours = extraHours;
	}
	
	public String getName() {
		return name;
	}
	public float getSalary() {
		return salary;
	} 
	public float getExtraHours(){
		return extraHours;
	}
	public void setExtraHours(int extraHours){
		this.extraHours = extraHours;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);  
	}
}

class Boss extends Employee {
	protected float bonus;
	private LinkedList<Visitable> subord;
		
	public Boss(String name, float salary, float bonus) {
		super(name, salary);
		this.bonus = bonus;
		this.subord = new LinkedList<Visitable>();
	}
	
	public Boss(String name, float salary, float extraHours, float bonus) {
		super(name, salary, extraHours);
		this.bonus = bonus;
		this.subord = new LinkedList<Visitable>();
	}
	
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	public LinkedList<Visitable> getSubordinates() {
		return subord;
	}
	public void addSubordinate(Visitable subordinate) {
		this.subord.add(subordinate);
	}
	
	//TODO ex1b - remove accept
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}

//TODO make Intern visitable
class Intern implements Visitable{
	
	private String  name;
	private int duration;  // in months
	
	public Intern(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
