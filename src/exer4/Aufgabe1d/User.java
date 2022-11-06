package exer4.Aufgabe1d;

public class User {
    private String username;
    private boolean downloadPermissions;
    private int mangaLimit;

    public User(String username, boolean hasDownloadPermissions, int mangaLimit) {
        this.username = username;
        this.downloadPermissions = hasDownloadPermissions;
        this.mangaLimit = mangaLimit;
    }

    public boolean hasDownloadPermissions() {
        return downloadPermissions;
    }

    public int getMangaLimit() {
        mangaLimit -= 1;
        if(mangaLimit < 0){
            mangaLimit = 0;
        }
        return mangaLimit;
    }

    public String getUsername() {
        return username;
    }
}

