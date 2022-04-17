import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)
    // Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //
        //
        // CLOSE SCANNER SOMEWHERE
        Scanner scanner = new Scanner(System.in);
        // char[] menuOptions = { '1', '2', '3', '4', '5', '6', 'q' };
        char userInputMenu;
        ArrayList<Character> menuOptions = new ArrayList<Character>();
        Collections.addAll(menuOptions, '1', '2', '3', '4', '5', '6', 'q');
        boolean menuVal = true;
        boolean startDisplayMenu = true;

        // menu loop
        while (startDisplayMenu == true) {

            do {
                // Display the menu to user
                displayMenu();

                // NOTE: use .nextLine().charAt(0) since input is char
                userInputMenu = scanner.nextLine().charAt(0);

                // Input validation for a NON-VALID input
                if (menuOptions.contains(userInputMenu) == false) {
                    System.out.println("Please input a valid entry.");

                }

                // Input validation for a VALID input
                else if (menuOptions.contains(userInputMenu) == true) {
                    menuVal = false;
                    break;
                }
            } while (menuVal == true);

            // switch for user input
            switch (userInputMenu) {
                case '1':
                    intakeNewDog(scanner);
                    break;
                case '2':
                    intakeNewMonkey(scanner);
                    break;
                case '3':
                    reserveAnimal(scanner);
                    break;
                case '4':
                    String dogs = "Dogs";
                    printAnimals(dogs);
                    break;
                case '5':
                    String monkeys = "Monkeys";
                    printAnimals(monkeys);
                    break;
                case '6':
                    String available = "Available";
                    printAnimals(available);
                    break;
                case 'q':
                    break;
                default:
                    break;
            }

        }

    } // main()

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println();
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println();
        // Name
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to menu
            }
        }
        // Dog breed
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();

        // Dog gender
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();

        // Dog age
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();

        // Dog weight
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();

        // Dog acquisition date
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        // Dog acquisition country
        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        // Dog training status
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();

        // Dog service status
        System.out.println("What country is the dog in service?");
        String inServiceCountry = scanner.nextLine();

        boolean reserved = false;

        // Create dog obj
        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                reserved, inServiceCountry);
        // add dog obj to dogList
        dogList.add(dog);
        System.out.println(dogList.size());
        // Collections.addAll(dog,)

    }

    // Monkey intake
    public static void intakeNewMonkey(Scanner scanner) {
        // Allowed monkey species
        ArrayList<String> allowedMonkeySpecies = new ArrayList<String>();
        Collections.addAll(allowedMonkeySpecies, "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel Monkey",
                "Tamarin");

        // Monkey name
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();

        // Error handling for monkey name
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // returns to menu
            }

        }

        // Monkey Species
        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        // Validation for allowed monkey species
        if (allowedMonkeySpecies.contains(species) == false) {
            System.out.println("Sorry this monkey species not allowed.");
            return;
        }

        // Monkey Gender
        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();

        // Monkey age
        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();

        // Monkey Weight
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();

        // Monkey acquisition date
        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        // Monkey acquisition country
        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        // Monkey training status
        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();

        // Monkey service status
        System.out.println("What country is the monkey in service?");
        String inServiceCountry = scanner.nextLine();

        // Monkey tail length
        System.out.println("What is the monkeys tail length?");
        String tailLength = scanner.nextLine();

        // Monkey height
        System.out.println("What is the monkeys height?");
        String height = scanner.nextLine();

        // Monkey body length
        System.out.println("What is the monkeys body length?");
        String bodyLength = scanner.nextLine();

        boolean reserved = false;

        // Create monkey obj
        Monkey monkey = new Monkey(tailLength, height, bodyLength, name, species, gender,
                age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                reserved, inServiceCountry);

        // Add monkey obj to monkeyList
        monkeyList.add(monkey);
    }

    // Reserve animal method
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("What is the animal type?");
        String animalType = scanner.nextLine();
        System.out.println("What country is the monkey in service?");
        String inServiceCountry = scanner.nextLine();

        // dog reservation
        if (animalType.equalsIgnoreCase("Dog")) {
            // loop for dogList
            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry)) {
                    // Reserved is false
                    if (!dog.getReserved()) {
                        System.out.println(dog.getTrainingStatus());
                        dog.setReserved(true);
                        System.out.println("Dog is now reserved");
                    }
                    // Reserved is true
                    else {
                        System.out.println("No dogs were found that can be reserved.");
                    }
                }
            }
        }

        if (animalType.equalsIgnoreCase("Monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry)) {
                    // Reserved is false
                    if (!monkey.getReserved()) {
                        monkey.setReserved(true);
                        System.out.println("Dog is now reserved");
                    }
                    // Reserved is false
                    else {
                        System.out.println("No dogs were found that can be reserved.");
                    }
                }
            }
        }

    }

    // Print animal method
    public static void printAnimals(String input) {
        // Dogs
        if (input == "Dogs") {

            // for each dog
            for (Dog dog : dogList) {
                // print a string for the boolean result of dog.getReserved()
                String dogResStatus;

                System.out.println("Name: " + dog.getName());
                System.out.println("Training Status: " + dog.getTrainingStatus());
                System.out.println("Acquisition country: " + dog.getAcquisitionLocation());
                if (dog.getReserved() == false) {
                    dogResStatus = "Not Reserved";
                    System.out.println("Reservation status: " + dogResStatus);
                } else if (dog.getReserved() == true) {
                    dogResStatus = "Reserved";
                    System.out.println("Reservation status: " + dogResStatus);
                }
                System.out.println();
            }
        }
        if (input == "Monkeys") {
            String monkeyResStatus;
            // for each dog
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName());
                System.out.println("Training Status: " + monkey.getTrainingStatus());
                System.out.println("Acquisition country: " + monkey.getAcquisitionLocation());
                if (monkey.getReserved() == false) {
                    monkeyResStatus = "Not Reserved";
                    System.out.println("Reservation status: " + monkeyResStatus);
                } else if (monkey.getReserved() == true) {
                    monkeyResStatus = "Reserved";
                    System.out.println("Reservation status: " + monkeyResStatus);
                }
                System.out.println("Reservation Status" + monkey.getReserved());
                System.out.println();
            }
        }
        if (input == "Available") {
            // Monkeys
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equals("in service") && monkey.getReserved() == (false)) {
                    System.out.println("Species: " + monkey.getSpecies());
                    System.out.println("Name: " + monkey.getName());
                    System.out.println("Gender: " + monkey.getGender());
                    System.out.println("Age: " + monkey.getAge());
                    System.out.println("Weight " + monkey.getWeight());
                    System.out.println("Height: " + monkey.getHeight());
                    System.out.println("Body length: " + monkey.getBodyLength());
                    System.out.println("Tail Length: " + monkey.getTailLength());
                    System.out.println("Acquisition Date: " + monkey.getAcquisitionDate());
                    System.out.println("Acquisition Country: " + monkey.getAcquisitionLocation());
                }
                System.out.println();
            }
            // dogs
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equals("in service") && dog.getReserved() == (false)) {
                    System.out.println("Species: " + dog.getBreed());
                    System.out.println("Name: " + dog.getName());
                    System.out.println("Gender: " + dog.getGender());
                    System.out.println("Age: " + dog.getAge());
                    System.out.println("Weight " + dog.getWeight());
                    System.out.println("Acquisition Date: " + dog.getAcquisitionDate());
                    System.out.println("Acquisition Country: " + dog.getAcquisitionLocation());

                }
                System.out.println();
            }
        }

    }
}
