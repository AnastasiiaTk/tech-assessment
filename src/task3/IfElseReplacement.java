package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class IfElseReplacement {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Feed Child With Ice Cream, Salad or Milk To See Child's Face Reaction : ");
        String food = reader.readLine();
        getFaceReactionV1(food);
        getFaceReactionV2(food);
        getFaceReactionV3(food);
    }


    public static void getFaceReactionV1(String food) {
        switch (food) {
            case "Ice Cream":
                System.out.println("Happy" + " " + "Face");
                break;
            case "Salad":
                System.out.println("Angry" + " " + "Face");
                break;
            case "Milk":
                System.out.println("Normal" + " " + "Face");
                break;
            default:
                System.out.println("Error" + " " + "Face");
        }
    }

    public static void getFaceReactionV2(String food) {
        Map<String, String> foodOptions = Map.of(
                "Ice Cream", "Happy" + " " + "Face",
                "Salad", "Angry" + " " + "Face",
                "Milk", "Normal" + " " + "Face");
        Optional.ofNullable(foodOptions.get(food)).ifPresentOrElse(v -> System.out.println(v),
                () -> System.out.println("Error" + " " + "Face"));
    }

    public static void getFaceReactionV3(String food) {
        Optional<FoodEnum> reaction = FoodEnum.getReactionByFood(food);
        reaction.ifPresentOrElse(value -> System.out.println(value.getReaction()),
                () -> System.out.println("Error" + " " + "Face"));
    }

    enum FoodEnum {
        ICE_CREAM("Ice Cream", "Happy" + " " + "Face"),
        SALAD("Salad", "Angry" + " " + "Face"),
        MILK("Milk", "Normal" + " " + "Face");

        String food;
        String reaction;

        FoodEnum(String food, String reaction) {
            this.food = food;
            this.reaction = reaction;
        }

        public String getFood() {
            return food;
        }

        public String getReaction() {
            return reaction;
        }

        public static Optional<FoodEnum> getReactionByFood(String food) {
            return Arrays.stream(FoodEnum.values())
                    .filter(foodName -> foodName.food.equals(food))
                    .findFirst();
        }
    }
}
