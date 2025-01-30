import java.util.Scanner;
import backend.ToDoList;
import frontend.Format;

import static frontend.Format.HORIZONTAL_LINE;

/**
 * Class that represents a chatbot
 */
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
     *<p>
     *     Using the chatbot:
     *     - To view the list, use the following command:
     *     list
     *
     *      - To add a To Do to the list, use the following format:
     *     deadline/description
     *
     *      - To add a Deadline to the list, use the following format:
     *     deadline/description/time to be completed by
     *
     *      - To add an Event to the list, use the following format:
     *      event/description/start time/end time
     *
     *      - To mark a task as done, use the following format:
     *      mark/task index
     *
     *      - To unmark a task as done, use the following format:
     *      unmark/task index
     *
     *      - To delete a task, use the following format:
     *      delete/task index
     *
     *      - To close the chatbot, use the following command:
     *      bye
     *
     *</p>
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
            String regex = "/";
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
                        int index = Integer.parseInt(parsedCommand[1]) - 1;
                        list.markTaskAsDone(index);
                    } catch (ArrayIndexOutOfBoundsException e) { //no index provided after "mark"
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index." +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (NumberFormatException e) { //index provided after "mark" is not a number
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "unmark":
                    try {
                        int index = Integer.parseInt(parsedCommand[1]) - 1;
                        list.unmarkTaskAsDone(index);
                    } catch (ArrayIndexOutOfBoundsException e) { //no index provided after "mark"
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (NumberFormatException e) { //index provided after "mark" is not a number
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "todo":
                    try {
                        list.createToDoTask(parsedCommand[1]);
                    } catch (ArrayIndexOutOfBoundsException e) { //incomplete deadline description
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("Your todo description is incomplete. " +
                                "Use the following format: todo/description");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "deadline":
                    try {
                        list.createDeadlineTask(parsedCommand[1], parsedCommand[2]);
                    } catch (ArrayIndexOutOfBoundsException e) { //incomplete deadline description
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("Your deadline description is incomplete. " +
                                "Use the following format: deadline/description/timeToBeCompletedBy");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "event":
                    try {
                        list.createEventTask(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                    } catch (ArrayIndexOutOfBoundsException e) { //incomplete deadline description
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("Your event description is incomplete. " +
                                "Use the following format: event/description/startTime/endTime");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "delete":
                    try {
                        int index = Integer.parseInt(parsedCommand[1]) - 1;
                        list.deleteTask(index);
                    } catch (ArrayIndexOutOfBoundsException e) { //no index provided after "mark"
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index." +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (NumberFormatException e) { //index provided after "mark" is not a number
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;

                default:
                    System.out.println(HORIZONTAL_LINE + "\n");
                    System.out.println("I'm afraid I don't understand what you mean.");
                    System.out.println(HORIZONTAL_LINE + "\n");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        SirDuke.start();
    }
}


