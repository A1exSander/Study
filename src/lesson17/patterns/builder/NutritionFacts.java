package lesson17.patterns.builder;

public class NutritionFacts {

    private final int servings;
    private final int energy;
    private final int fat;

    private NutritionFacts(Builder builder){
        servings = builder.servings;
        energy = builder.energy;
        fat = builder.fat;
    }

    public static void main(String[] args) {
        NutritionFacts beaf = new Builder(10, 4000).setFat(250).build();

        NutritionFacts prod = new Builder(2, 3000).build();
    }

    public static class Builder {
        private final int servings;
        private final int energy;
        private int fat = 0;

        public Builder(int servings, int energy) {
            this.servings = servings;
            this.energy = energy;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
}
