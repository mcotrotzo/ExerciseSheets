package exer2.Aufgabe3a;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Directory implements FileSystem{
    private String name;
    private List<FileSystem> kids;

    public Directory(String name, List<FileSystem> kids) {
        this.kids = kids;
        this.name = name;
    }
   @Override
    public String print(int level) {
        if(level < 0 ){
            throw new InvalidParameterException("Level should be positive");
        }

        StringBuilder s = new StringBuilder();
        String pad = " ".repeat(level);
        s.append(pad).append(name).append("/\n");

        for(FileSystem kid: kids){
            if(kid instanceof Directory){

                s.append(kid.print(level + 1));
            }
            if(kid instanceof File){
                s.append(kid.print(level+1));
            }
        }
       return s.toString();
    }

    @Override
    public List<File> find(String regex) {
        List<File> list = new ArrayList<>();
        for(FileSystem fileSystem: kids){

                if(fileSystem instanceof File){
                    list.addAll(((File)fileSystem).find(regex));
                }

            list.addAll(fileSystem.find(regex));
        }

        return new HashSet<>(list).stream().toList();
    }
}
