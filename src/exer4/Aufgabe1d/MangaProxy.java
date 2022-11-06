package exer4.Aufgabe1d;

import java.util.List;

public class MangaProxy implements MangaServiceInterface {

    private RealManga realmanga;
    private int downloadCalls;

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
            downloadCalls++;
            throw new MangaException("User has no Download Permissions!\nAmount of downloads: " + downloadCalls);
        }
        downloadCalls++;
        System.out.println(user.getUsername() + " is downloading!\nAmount of downloads:"+downloadCalls+"\n");
        return realmanga.downloadUrl(id,user);
    }


}
