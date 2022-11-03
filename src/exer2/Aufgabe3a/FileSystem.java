package exer2.Aufgabe3a;
import java.util.List;

public interface FileSystem {
    String print(int level);
    List<File> find (String regex);

}
