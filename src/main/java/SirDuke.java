public class SirDuke {
    static final String horizontalLine =
            "____________________________________________________________";
    public static void sayBye() {
        System.out.println("Godspeed.\n" +
                horizontalLine);
    }
    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(horizontalLine + "\n" +
                "It's a pleasure to meet you. My name is Sir Duke Ellington.\n" +
                "What can I do you for?\n" +
                horizontalLine);

        SirDuke.sayBye();
    }
}


