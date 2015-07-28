package main.core;

public abstract class BaseConstraint implements Constraint{

	@Override
	public boolean isSatisfiedBy(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Constraint and(Constraint constraint) {
		return new AndConstraint(this, constraint);
	}

}
