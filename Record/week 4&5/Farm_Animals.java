class FarmAnimal {
    String name;
    String place;
    String food;
    String sound;

    FarmAnimal(String name, String place) {
        this.name = name;
        this.place = place;
        this.food = "Grass";
        this.sound = "Animal Sound";
    }

    FarmAnimal(String name, String place, String food, String sound) {
        this.name = name;
        this.place = place;
        this.food = food;
        this.sound = sound;
    }

    void showDetails() {
        System.out.println("Animal: " + name);
        System.out.println("Stays in: " + place);
        System.out.println("Eats: " + food);
        System.out.println("Sound: " + sound);
    }

    void showDetails(String message) {
        System.out.println(message);
        showDetails();
    }
}

public class FarmAnimals {
    public static void main(String[] args) {

        FarmAnimal cow = new FarmAnimal(
            "Cow", "Cowshed", "Grass", "Moo"
        );

        FarmAnimal pig = new FarmAnimal(
            "Pig", "Pigsty", "Vegetables", "Oink"
        );

        FarmAnimal horse = new FarmAnimal(
            "Horse", "Stable", "Grass", "Neigh"
        );

        cow.showDetails();
        System.out.println();

        pig.showDetails();
        System.out.println();

        horse.showDetails("Horse Details:");
    }
}
