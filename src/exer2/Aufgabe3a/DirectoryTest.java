package exer2.Aufgabe3a;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @Test
    void print() {
        File file1 = new File("kitten1.png");
        File file2 = new File("kitten2.png");
        File file3 = new File("ex01.java");
        File file4= new File("ex02.java");
        List<FileSystem> systemList = List.of(file1,file2);
        List<FileSystem> systemList2 = List.of(file3,file4);

        Directory dir2 = new Directory("src", systemList2);

        Directory dir3 = new Directory("kittens",systemList);
        Directory dir4 = new Directory("pics", List.of(dir3));
        Directory dir = new Directory("home", List.of(dir2,dir4));
        FileSystem system = new Directory("", List.of(dir));

        assertThrows(InvalidParameterException.class,()-> system.print(-1));
    }

    @Test
    void find() {
        File file1 = new File("kitten1.png");
        File file2 = new File("kitten2.png");
        File file3 = new File("ex01.java");
        File file4= new File("ex02.java");
        List<FileSystem> systemList = List.of(file1,file2);
        List<FileSystem> systemList2 = List.of(file3,file4);

        Directory dir2 = new Directory("src", systemList2);

        Directory dir3 = new Directory("kittens",systemList);
        Directory dir4 = new Directory("pics", List.of(dir3));
        Directory dir = new Directory("home", List.of(dir2,dir4));
        FileSystem system = new Directory("", List.of(dir));

        assertEquals(system.find("kitten.*"),systemList);
        assertEquals(system.find("ex.*"),systemList2);
        assertTrue(system.find("kittei.*").isEmpty());
    }
}