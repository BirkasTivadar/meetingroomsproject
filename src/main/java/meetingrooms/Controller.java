package meetingrooms;

import java.util.Scanner;

public class Controller {

    private final Office office = new Office();

    public void readOffice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hány tárgyalót szeretne rögzíteni: ");
        int numberOfMeetingrooms = scanner.nextInt();
        scanner.nextLine();

        loadOffice(scanner, numberOfMeetingrooms);


    }

    private void loadOffice(Scanner scanner, int numberOfMeetingrooms) {
        String name;
        int width;
        int length;

        for (int i = 1; i <= numberOfMeetingrooms; i++) {
            System.out.printf("Kérem a(z) %d. tárgyaló nevét: %n", i);
            name = scanner.nextLine();
            System.out.printf("Kérem a(z) %d. tárgyaló szélességét: %n", i);
            width = scanner.nextInt();
            System.out.printf("Kérem a(z) %d. tárgyaló hosszúságát%n", i);
            length = scanner.nextInt();
            scanner.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, width, length));
        }
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján\n");
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Melyik menüpontot választja?");
        int menu = scanner.nextInt();
        scanner.nextLine();

        switch (menu) {
            case 1 -> office.printNames();
            case 2 -> office.printNamesReverse();
            case 3 -> office.printEventNames();
            case 4 -> office.printAreas();
            case 5 -> printWithName(scanner);
            case 6 -> printWithContains(scanner);
            case 7 -> printWithArea(scanner);

            default -> returnToMenu();
        }
    }

    private void printWithName(Scanner scanner) {
        System.out.println("Kérem a keresett tárgyaló nevét:");
        String name = scanner.nextLine();
        office.printMeetingRoomsWithName(name);
    }

    private void printWithContains(Scanner scanner) {
        System.out.println("Kérem a keresett tárgyaló nevének részletét:");
        String part = scanner.nextLine();
        office.printMeetingRoomsContains(part);
    }

    private void printWithArea(Scanner scanner) {
        System.out.println("Kérem a terület nagyságot");
        int area = scanner.nextInt();
        office.printAreasLargerThan(area);
    }

    private void returnToMenu() {
        System.out.println("Rossz menüpont");
        printMenu();
        runMenu();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();
        controller.printMenu();
        controller.runMenu();

        for (int i = 0; i < 10; i++) {
            controller.printMenu();
            controller.runMenu();
        }
    }
}
