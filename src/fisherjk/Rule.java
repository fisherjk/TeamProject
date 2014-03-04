package fisherjk;

/*Class to hold information about individual Rules for a transaction*/
public class Rule {

	private ItemSet antecedent;//IF part of the rule
	private ItemSet consequent;//THEN part of the rule
	private double minSupportLevel;// must have 4 digits of precision
	private double actualConfidenceLevel;// must have 4 digits of precision

	/*Constructors*/
	public Rule(ItemSet antecedent, ItemSet consequent, double minSupportLevel,
			double actualConfidenceLevel) {
		this.antecedent = antecedent;
		this.consequent = consequent;
		this.minSupportLevel = minSupportLevel;
		this.actualConfidenceLevel = actualConfidenceLevel;
	}

	public Rule() {
		this.antecedent = new ItemSet();
		this.consequent = new ItemSet();
		this.minSupportLevel = 0;
		this.actualConfidenceLevel = 0;
	}

	/*Respective Getters and Setters*/
	public ItemSet getX() {
		return antecedent;
	}

	public void setX(ItemSet x) {
		this.antecedent = x;
	}

	public ItemSet getY() {
		return consequent;
	}

	public void setY(ItemSet y) {
		this.consequent = y;
	}

	public double getMinSupportLevel() {
		return minSupportLevel;
	}

	public void setMinSupportLevel(double minSupportLevel) {
		this.minSupportLevel = minSupportLevel;
	}

	public double getActualConfidenceLevel() {
		return actualConfidenceLevel;
	}

	public void setActualConfidenceLevel(double actualConfidenceLevel) {
		this.actualConfidenceLevel = actualConfidenceLevel;
	}

	@Override
	public String toString() {
		this.actualConfidenceLevel = Math.round(this.actualConfidenceLevel *10000.0);
		this.actualConfidenceLevel = (this.actualConfidenceLevel /10000.0);
		return "IF " + this.antecedent.toStringWithoutSupport() + " THEN "
				+ this.consequent.toStringWithoutSupport() + " ("
				+ this.actualConfidenceLevel + ")";
	}

}
