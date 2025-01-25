import java.util.Scanner;
import backend.ToDoList;
import frontend.Format;
public class SirDuke {
    
    /**
     * Prints exit message and exits.
     */
    public static void sayBye() {
        System.out.println(Format.HORIZONTAL_LINE + "\n"
                + "Godspeed.\n"
                + Format.HORIZONTAL_LINE);
        System.exit(0);
    }

    /**
     * Prints welcome message and allows the SirDuke chatbot to start receiving commands
     * Reads user input from console and interprets them as commands
     * Executes commands accordingly
     */
    public static void start() {

        ToDoList list = new ToDoList();

        System.out.println(Format.HORIZONTAL_LINE + "\n"
                + "It's a pleasure to meet you. My name is Sir Duke Ellington.\n"
                + "What can I do you for?\n"
                + Format.HORIZONTAL_LINE);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String command = scanner.nextLine();
            switch (command) {
                case "bye":
                    SirDuke.sayBye();
                    break;
                case "list":
                    list.showList();
                    break;
                default:
                    list.createTask(command);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        SirDuke.start();
    }
}


