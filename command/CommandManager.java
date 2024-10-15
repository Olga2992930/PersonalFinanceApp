package command;

import java.util.Date;
import java.util.Scanner;
import main.Main;
import utility.StringToDate;

public class CommandManager {

    private HelpCommand helpCommand;
    private StopCommand stopCommand;
    private DeleteCommand deleteCommand;

    public CommandManager(Main main) {
        helpCommand = new HelpCommand(main);
        stopCommand = new StopCommand(main);
        deleteCommand = new DeleteCommand(main);
    }

    public void readCommand() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TransaktionsManager manager = new TransaktionsManager();
        if (input.isBlank()) {
            throw new IllegalArgumentException("Kommandot får inte vara tomt.");
        }

        String[] args = input.split(" ");
        if (args.length == 0) {
            throw new IllegalArgumentException("Kommandot får inte vara tomt.");
        }
        String command = args[0];
        if (command.equalsIgnoreCase("help")) {
            helpCommand.run(args);
        } else if (command.equalsIgnoreCase("stop")) {
            stopCommand.run(args);
        } else if (command.equalsIgnoreCase("create")) {
            System.out.print("Beskriv transaktionen: ");
            String beskrivning = scanner.nextLine();
            System.out.println("Ange belopp för transaktionen. ");
            System.out.print("Skriv `-` om det är utgift, skriv `+` om det är inkomst: ");
            double belopp = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Ange datum (yyyy-mm-dd): ");
            String dateString = scanner.nextLine();
            Date datum = StringToDate.parseString(dateString);
            if (datum == null) {
                System.out.println("Fel datumformat. Försök igen.");
                return;
            }
            manager.läggTillTransaktion(beskrivning, belopp, datum);
            System.out.println("______________________________________________________________");
            System.out.println("Kör vidare! ('create'/'list'/'balance'/'delete'/'expenses'/'income'/'help'/'stop')");

        } else if (command.equalsIgnoreCase("list")) {
            manager.visaAllaTransaktioner();
            System.out.println("______________________________________________________________");
            System.out.println("Kör vidare! ('create'/'list'/'balance'/'delete'/'expenses'/'income'/'help'/'stop')");

        } else if (command.equalsIgnoreCase("balance")) {
            manager.visaSaldo();
            System.out.println("______________________________________________________________");
            System.out.println("Kör vidare! ('create'/'list'/'balance'/'delete'/'expenses'/'income'/'help'/'stop')");

        } else if (command.equalsIgnoreCase("delete")) {
            manager.visaAllaTransaktioner();
            if (!manager.getTransaktioner().isEmpty()) {
                System.out.print("Ange transaktionsnumret att ta bort: ");
                int numret = scanner.nextInt() - 1;
                deleteCommand.raderaTransaktion(manager.getTransaktioner(), numret);
                manager.visaAllaTransaktioner();
            }
            System.out.println("______________________________________________________________");
            System.out.println("Kör vidare! ('create'/'list'/'balance'/'delete'/'expenses'/'income'/'help'/'stop')");

        } else if (command.equalsIgnoreCase("expenses")) {
            manager.visaUtgifter();
            System.out.println("______________________________________________________________");
            System.out.println("Kör vidare! ('create'/'list'/'balance'/'delete'/'expenses'/'income'/'help'/'stop')");

        } else if (command.equalsIgnoreCase("income")) {
            manager.visaInkomster();
            System.out.println("______________________________________________________________");
            System.out.println("Kör vidare! ('create'/'list'/'balance'/'delete'/'expenses'/'income'/'help'/'stop')");

        } else {
            throw new IllegalArgumentException(
                    "'" + command + "' är inte ett kommando. Skriv 'help' för en lista på kommandon.");
        }

    }
}
