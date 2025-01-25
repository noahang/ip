import java.util.Objects;
import java.util.Scanner;
public class SirDuke {
    static final String HORIZONTAL_LINE =
            "____________________________________________________________";

    /**
     * Prints exit message and exits.
     */
    public static void sayBye() {
        System.out.println(HORIZONTAL_LINE + "\n"
                + "Godspeed.\n"
                + HORIZONTAL_LINE);
        System.exit(0);
    }

    /**
     * Prints welcome message and allows the SirDuke chatbot to start receiving commands.
     * Reads user input from console and interprets them as commands.
     */
    public static void start() {
        System.out.println(HORIZONTAL_LINE + "\n"
                + "It's a pleasure to meet you. My name is Sir Duke Ellington.\n"
                + "What can I do you for?\n"
                + HORIZONTAL_LINE);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String command = scanner.nextLine();
            if (Objects.equals(command, "bye")) {
                SirDuke.sayBye();
            } else {
                System.out.println(HORIZONTAL_LINE + "\n"
                        + command + "\n"
                        + HORIZONTAL_LINE);
            }
        }
    }
    public static void main(String[] args) {
        SirDuke.start();
    }
}


