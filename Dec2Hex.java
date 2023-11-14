import java.util.Scanner;

class Dec2Hex
{

    public static int Arg1;

    public static void main(String args[])
    {
	if(args.length==0)
	{
		log.debug("Error: no input provided!");
		System.exit(1);
		return;
	}

        try 
	{
	    int decimalInput;
            decimalInput = Integer.parseInt(args[0]);
        } 
	catch (NumberFormatException e) 
	{
            log.debug("Error: input provided is not integer!");
            System.exit(1);
            return;
        }

        Arg1 = Integer.parseInt(args[0]);
        char ch[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem;
	int num;
        num = Arg1;
        String hexadecimal="";
        log.debug("Converting the Decimal Value " + num + " to Hex...");

        while(num != 0)
        {
            rem=num%16;
            hexadecimal= ch[rem] + hexadecimal;
            num= num/16;
        }

        log.debug("Converted Hexadecimal representation is: " + hexadecimal);

    }
}
