package exer4.Aufgabe1d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RealManga implements MangaServiceInterface{

    private HashMap<Integer,Manga> mangaList = new HashMap<>();

    public void addManga(Manga manga){
        if(mangaList.containsKey(manga.getId())){
            throw new IllegalArgumentException("Manga is already in the inventory");
        }
        mangaList.put(manga.getId(),manga);
    }


    @Override
    public List<Manga> listMangas() {
        return mangaList.values().stream().toList();
    }

    @Override
    public Manga getMangaContent(int id, User user) throws MangaException {
        if(user == null || id < 0 ){
            throw new IllegalArgumentException("Id below zero or user which does not exist");
        }
        if(!mangaList.containsKey(id)){
            throw new IllegalArgumentException("Manga is not in the inventory");
        }
        if(user.getMangaLimit() == 0){
            throw new IllegalStateException("User reached Limit");
        }
        return mangaList.get(id);
    }

    @Override
    public String downloadUrl(int id, User user) throws MangaException {
        return mangaList.get(id).getDownloadUrl();
    }
}
