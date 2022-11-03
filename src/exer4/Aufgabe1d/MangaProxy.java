package exer4.Aufgabe1d;

import java.util.List;

public class MangaProxy implements MangaServiceInterface {

    private RealManga realmanga;
    public static int downloadCalls;

    public MangaProxy (RealManga realmanga) {
        downloadCalls = 0;
        this.realmanga = realmanga;
    }

    @Override
    public List<Manga> listMangas() {
        return realmanga.listMangas();
    }

    @Override
    public Manga getMangaContent(int id, User user) throws MangaException {
        return realmanga.getMangaContent(id,user);
    }

    @Override
    public String downloadUrl(int id, User user) throws MangaException {
        if(user == null || id < 0 ){
            throw new IllegalArgumentException("Id below zero or user which does not exist");
        }
        if(!user.hasDownloadPermissions()){
            throw new MangaException("User has no Download Permissions");
        }
        downloadCalls++;
        return realmanga.downloadUrl(id,user);
    }


}
