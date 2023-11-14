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
            int decimalInput = Integer.parseInt(args[0]);
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
        log.info(String.format("Converting the Decimal Value %s to Hex...", num));

	StringBuilder hexadecimalBuilder = new StringBuilder();

        while (num != 0) {
            rem = num % 16;
	    hexadecimalBuilder.insert(0, ch[rem]);
            num = num / 16;
        }

	String hexadecimal = hexadecimalBuilder.toString();

        log.info(String.format("Converted Hexadecimal representation is: %s", hexadecimal));
    }
}

