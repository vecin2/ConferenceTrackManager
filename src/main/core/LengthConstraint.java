package main.core;

public class LengthConstraint extends BaseConstraint {

	private int threshold;
	private String type;
	private static String MAX_LENGTH ="MAX_LENGTH";
	private static String MIN_LENGTH ="MIN_LENGTH";

	public LengthConstraint(int threshold, String type) {
		this.threshold = threshold;
		this.type = type;
	}
	@Override
	public boolean isSatisfiedBy(int amount) {
		if(type == MAX_LENGTH){
		return threshold>=amount;
		}
		else{
			return threshold <= amount;
		}
	}

	public static Constraint maxLengthOf(int amount) {
		return  new LengthConstraint(amount, MAX_LENGTH);
	}
	public static Constraint minLengthOf(int amount) {
		return  new LengthConstraint(amount, MIN_LENGTH);
	}
	public static Constraint lengthBetween(int minLength, int maxLength) {
		return  new AndConstraint(minLengthOf(minLength), maxLengthOf(maxLength));
	}
	@Override
	public boolean canSatisfy(int amount) {
		if(type == MAX_LENGTH){
			return threshold>=amount;
			}
			else{
				return true;
			}
	}

	
	
}
