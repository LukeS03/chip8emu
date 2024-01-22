import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class CPU {

    private byte[] memory;

    private short programCounter;
    private short indexRegister;
    private byte delayTimer;
    private byte soundTimer;
    private byte[] gpRegisters;
    private Stack<Short> stack;

    public Display display;

    public CPU() {
        memory      = new byte[4096];
        gpRegisters = new byte[16];
        //Registers
        programCounter = 0;


    }

    public void loadMem(String filePath) {
        byte buffer[];
        Path inPath = Paths.get(filePath);
        try {
            buffer = Files.readAllBytes(inPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(buffer == null) {
            throw new RuntimeException("loadMem Error.");
        }

        for(int i = 0; i < 4096; i++) {
            memory[i] = buffer[i];
        }
    }

    public void runCycle() {
        byte instructByte1 = memory[programCounter+1];
        byte instructByte2 = memory[programCounter+2];
        programCounter+=2;


    }
}