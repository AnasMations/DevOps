import java.util.logging.Logger;

public class Dec2Hex {

    private static final Logger log = Logger.getLogger(Dec2Hex.class.getName());

    public static int Arg1;

    public static void main(String args[]) {
        if (args.length == 0) {
            log.severe("Error: no input provided!");
            System.exit(1);
            return;
        }

        try {
            int decimalInput;
            decimalInput = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            log.severe("Error: input provided is not an integer!");
            System.exit(1);
            return;
        }

        Arg1 = Integer.parseInt(args[0]);
        char ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int rem;
        int num;
        num = Arg1;
        String hexadecimal = "";
        log.info("Converting the Decimal Value " + num + " to Hex...");

        while (num != 0) {
            rem = num % 16;
            hexadecimal = ch[rem] + hexadecimal;
            num = num / 16;
        }

        log.info("Converted Hexadecimal representation is: " + hexadecimal);
    }
}

