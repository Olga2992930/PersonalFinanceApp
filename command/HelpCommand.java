package command;

import main.Main;

public class HelpCommand {
    public Main main;

    public HelpCommand(Main main) {
        this.main = main;
    }

    public void run(String[] args) {
        System.out.println("Kommandon:");
        System.out.println("Skriv 'create' för att skapa en ny transaktion");
        System.out.println("Skriv 'list' för att skriva ut alla transaktioner");
        System.out.println("Skriv 'balance' för att visa saldo");
        System.out.println("Skriv 'delete' för att radera en transaktion");
        System.out.println("Skriv 'expenses' för att visa utgifter");
        System.out.println("Skriv 'income' för att visa inkomster");
        System.out.println("Skriv 'stop' för att avsluta appen");
        System.out.println(" ");
    }
}
