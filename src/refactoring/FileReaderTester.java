package refactoring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTester extends TestCase {
    FileReader input;
    FileReader empty;

    public FileReaderTester(String name) {
        super(name);
    }

    protected void setUp() throws IOException {
        try {
            input = new FileReader("data.txt");
            empty = newEmptyFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("unable to open test file!");
        }
    }

    protected void tearDown() {
        try {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("error on closing test file!");
        }
    }

    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char)input.read();
        }
        assert ('d' == ch);
    }

    public void testReadAtEnt() throws IOException {
        int ch = -1234;
        for (int i = 0; i < 140; i++) {
            ch = input.read();
        }
        assertEquals("read at end", -1, ch);
    }

    public void testReadBoundaries() throws IOException {
        assertEquals("read first char", 'B', input.read());
        int ch;
        for (int i = 1; i < 137; i++) {
            ch = input.read();
        }
        assertEquals("read last char", '6', (char)input.read());
        assertEquals("read at end", -1, input.read());
        assertEquals("read at end", -1, input.read());
    }
    
    public void testEmptyRead() throws IOException {
        assertEquals(-1, empty.read());
    }
    
    private FileReader newEmptyFile() throws IOException {
        File empty = new File("empty.txt");
        FileOutputStream out = new FileOutputStream(empty);
        out.close();
        return new FileReader(empty);
    }
    
    public void testReadAfterClose() throws IOException {
        input.close();
        try {
            input.read();
            fail("no exception for read past end");
        } catch (IOException e) {}
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTester("testRead"));
        suite.addTest(new FileReaderTester("testReadAtEnt"));
        suite.addTest(new FileReaderTester("testReadBoundaries"));
        suite.addTest(new FileReaderTester("testEmptyRead"));
        suite.addTest(new FileReaderTester("testReadAfterClose"));
        
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
