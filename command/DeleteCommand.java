package command;

import java.util.ArrayList;
import main.Main;

public class DeleteCommand {
    public Main main;

    public DeleteCommand(Main main) {
        this.main = main;
    }

    public void raderaTransaktion(ArrayList<Transaktion> transaktioner, int index) {
        if (index >= 0 && index < transaktioner.size()) {
            transaktioner.remove(index);
            System.out.println("Transaktionen har tagits bort.");
        } else {
            System.out.println("Ogiltigt transaktionsnummer.");
        }
    }
}
