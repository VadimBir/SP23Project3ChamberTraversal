import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import org.example.ChamberTraversalDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ChamberTraversalTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream systemIn = System.in;

    // test flood functionality
    @Test
    public void testMoveFlooding() {
        int row = 8;
        int column = 18;
        char[][] TTTmaze = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '_', '_', '_', '_', '#', '#', '_', '_', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '#', '#', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '_', '#', '#', '#', '#', '_', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '#', '#', '#', '#', '#', '_', '#', '_', '#', '_', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '_', '_', '#', '#', '#', '_', '#', '_', '#', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '#', '_', '#', '_', '#', '_', '#', '_', '#', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '#', '_', '#', '_', '#', '#', '#', '#', '#', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '_', '_', '_', '#', '#', '#', '_', '_', '_', '_', '_', '_', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };
        ChamberTraversalDriver.move(TTTmaze, row, column, 1);
        char[][] expectedTTTmaze = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '_', '_', '_', '_', '#', '#', '_', '_', '_', '_', '#', '#', '1', '1', '1', '1', '1', '1', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '#', '#', '_', '_', '#', '#', '1', '1', '1', '1', '1', '1', '#'},
                {'#', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '_', '#', '#', '#', '#', '1', '#', '1', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '#', '#', '#', '#', '#', '_', '#', '_', '#', '1', '#', '1', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '_', '_', '#', '#', '#', '_', '#', '_', '#', '1', '1', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '#', '_', '#', '_', '#', '_', '#', '_', '#', '1', '1', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '#', '_', '#', '_', '#', '#', '#', '#', '#', '1', '1', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '_', '_', '_', '#', '#', '#', '1', '1', '1', '1', '1', '1', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };
        assertTrue("move method did not flood the maze correctly at row:" + row + " col:" + column, (Arrays.deepEquals(TTTmaze, expectedTTTmaze)));
    }

    // test counting functionality on a maze
    @Test
    public void testCounting() {
        char[][] TTTmaze = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '_', '_', '_', '_', '#', '#', '_', '_', '_', '_', '#', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '#', '#', '_', '_', '#', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '_', '#', '#', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '#', '#', '#', '#', '#', '_', '#', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '_', '_', '#', '#', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '#', '_', '#', '_', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '#', '_', '#', '_', '#', '#', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '_', '_', '_', '#', '#', '#', '_', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };
        int[] startPosition = {1, 1};
        int count = ChamberTraversalDriver.count(TTTmaze, startPosition);
        assertTrue("count method did not count correctly", count == 8);
    }

    // test read maze from the file functionality if 2D char array is equal to the expected maze
    // txt file field.txt is in the same directory as project root
    @Test
    public void testReadMaze() throws FileNotFoundException {
        char[][] actualFileMaze = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '_', '_', '_', '_', '#', '#', '_', '_', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '#', '#', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '_', '_', '_', '_', '_', '#', '#', '_', '#', '#', '#', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '#', '#', '#', '#', '#', '#', '_', '#', '_', '_', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '_', '_', '#', '#', '#', '_', '#', '_', '_', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '_', '#', '#', '_', '#', '_', '#', '#', '_', '_', '_', '#'},
                {'#', '_', '_', '#', '#', '_', '#', '_', '_', '#', '#', '_', '#', '#', '#', '#', '#', '#', '_', '#'},
                {'#', '_', '_', '#', '#', '#', '#', '_', '_', '_', '#', '#', '#', '_', '_', '_', '_', '_', '_', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        char[][] TTTmaze = ChamberTraversalDriver.readMaze("field.txt");
        assertTrue("readMaze method did not read the maze correctly or you have modified the file", Arrays.deepEquals(TTTmaze, actualFileMaze));
    }


    // test valid input functionality
    @Test
    public void testValidInput() {
        String inputData = "100 200\n 5 3\n5 3\n";
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        Scanner scannerObj = new Scanner(System.in);
        int[] startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("validInput method did not return the correct start position, may be split results in extra element?", startPosition[0] == 5 && startPosition[1] == 3);
    }
    // test extra credit, char then valid input functionality
    @Test
    public void testCharValidInput() {
        String inputData;
        InputStream in;
        Scanner scannerObj;
        int[] startPosition;

        inputData = "a a\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);

        inputData = "5 a\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);

        inputData = "a 5\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);
    }

    // test extra credit, str then valid input functionality
    @Test
    public void testSrtValidInput() {
        String inputData;
        InputStream in;
        Scanner scannerObj;
        int[] startPosition;

        inputData = "100.5 200.256\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);

        inputData = "asdf asdf\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);

        inputData = "5 asdf 3\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);

        inputData = "5 asdf\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);

        inputData = "asdf 5\n5 3\n";
        in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        scannerObj = new Scanner(System.in);
        startPosition = ChamberTraversalDriver.validInput(scannerObj, new char[10][20]);
        assertTrue("inputValidation Failed for "+ inputData, startPosition[0] == 5 && startPosition[1] == 3);
    }
}
