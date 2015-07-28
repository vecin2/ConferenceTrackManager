package main.core;

public interface Constraint {
	public boolean isSatisfiedBy(int amount);

	public Constraint and(Constraint constraint);

	public boolean canSatisfy(int i);
}