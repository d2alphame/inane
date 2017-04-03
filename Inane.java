import java.io.File;
import java.io.FileReader;
import java.io.FileOutputStream;


public class Inane {

    public static void main(String[] args) {

        /* args[0] is expected to be the name of the file to read input code from.
            So we open the file and read all the characters into a character array
        */

        // If the user doesn't specify any parameters while calling this code then
        // inform the user and exit'
        if (args.length == 0) {
            System.out.println("Please re-run the program and specify a file");
            return;
        }

        char[] source = new char[(int) new File(args[0]).length()];     // Use the length of the file to setup a fixed length character array
        byte[] output = new byte[65536];        // This shall be our output byte array
        int outputPointer = 0;     // Pointer to the output byte to operate on. Initially points to the first byte
        FileOutputStream fout = null;       // A File Output Stream so we can write the byte array to 

        // Initialize all bytes in the output byte array to 0
        for (int i = 0; i < 65536; i++) {
            output[i] = 0;
        }


        try {
            FileReader reader = new FileReader(args[0]);        // Create a file reader given the file to read from
            reader.read(source);                                // Read all characters from the file into the character array
            fout = new FileOutputStream("b.bin");               // Pass a file name to the FileOutputStream

            // Loop through all the characters in the source character array
            for (char c : source) {
                switch (c) {
                    case '+':
                        output[outputPointer] |= 1;         // If we detected '+' then set the least significant bit
                        break;
                    case '-':
                        output[outputPointer] <<= 1;        // If we detected '-' then shift left by 1
                        break;
                    case '>':
                        outputPointer += 1;                 // If we detected '>' then point to the next byte in the output array
                        break;
                    default:
                        break;
                }
            }

            // Write the byte array to the output file
            fout.write(output);
        }
        catch(Exception e) {
            e.getMessage();
        }

    }

}