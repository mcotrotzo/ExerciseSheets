package exer2.Aufgabe3a;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File implements FileSystem{

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String print(int level) {
        return  " ".repeat(level) + name + "\n";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public List<File> find(String regex) {

        List<File> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        boolean matchFound = matcher.find();
        if(matchFound) {
            list.add(this);
        }

        return list;
    }


}
