package main.core;

public class AndConstraint extends BaseConstraint {

	private Constraint c1;
	private Constraint c2;

	public AndConstraint(Constraint c1, Constraint c2) {
		this.c1 =c1;
		this.c2 =c2;
	}

	@Override
	public boolean isSatisfiedBy(int amount) {
		return c1.isSatisfiedBy(amount) && c2.isSatisfiedBy(amount);
	}
	@Override
	public boolean canSatisfy(int amount) {
		return c1.canSatisfy(amount) && c2.canSatisfy(amount);
	}



}
