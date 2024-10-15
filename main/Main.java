/*

<-----> En personal-finance applikation <----->

Funktionalitet:

I applikationen kan man göra följande:

- Lägga in transaktioner (manuellt; när du exempelvis har köpt något eller fått lön)

- Se alla transaktioner

- Radera transaktioner (manuellt)

- Se nuvarande kontobalans

- Se inkomster och utgifter årsvis, månadsvis, veckovis och dagvis
 */
package main;

import command.CommandManager;

public class Main {
    public boolean running = true;
    public CommandManager commandManager = new CommandManager(this);
        public static void main(String[] args) {
        System.out.println("Välkommen till din personliga finance app!");
        System.out.println("Skriv 'help' för en lista på kommandon.");
        Main main = new Main();
        while (main.running) {
            try {
                main.commandManager.readCommand();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
