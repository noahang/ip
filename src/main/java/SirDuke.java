import java.util.Scanner;
import backend.ToDoList;
import frontend.Format;

import static frontend.Format.HORIZONTAL_LINE;

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
            String regex = "[,\\.\\s]";
            String[] parsedCommand = command.split(regex);
            switch (parsedCommand[0]) { //first word of the command
                case "bye":
                    SirDuke.sayBye();
                    break;
                case "list":
                    list.showList();
                    break;
                case "mark":
                    try {
                        int index = Integer.parseInt(parsedCommand[1]);
                        list.markTaskAsDone(index);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    catch (NumberFormatException e) {
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "unmark":
                    try {
                        int index = Integer.parseInt(parsedCommand[1]);
                        list.unmarkTaskAsDone(index);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    catch (NumberFormatException e) {
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
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


