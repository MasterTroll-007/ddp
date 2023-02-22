package ddp.entity;

/**
 * Represents activity levels of the {@link User} for recommended caloric intake calculation
 */
public enum ActivityLevel {
    SEDENTARY("Sedentary (little or no exercise)", 1.2),
    LIGHTLY_ACTIVE("Lightly Active (light exercise or sports 1-3 days a week)", 1.375),
    MODERATELY_ACTIVE("Moderately Active (moderate exercise or sports 3-5 days a week)", 1.55),
    VERY_ACTIVE("Very Active (hard exercise or sports 6-7 days a week)", 1.725),
    EXTREMELY_ACTIVE("Extremely Active (very hard exercise or sports, physical job or training twice a day)", 1.9);

    private final String label;
    private final double coefficient;

    ActivityLevel(String label, double coefficient) {
        this.label = label;
        this.coefficient = coefficient;
    }

    public String getLabel() {
        return label;
    }

    public double getCoefficient() {
        return coefficient;
    }
}