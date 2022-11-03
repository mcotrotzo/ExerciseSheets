package exer4.Aufgabe1d;

public class Manga {

    private int id;
    private String name;
    private String downloadUrl;

    public Manga(int id,String name, String downloadUrl) {
        this.id = id;
        this.name = name;
        this.downloadUrl = downloadUrl;
    }

    public int getId() {
        return id;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    @Override
    public String toString() {
        return name;
    }
}
