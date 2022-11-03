package exer4.Aufgabe1d;

import java.util.List;

public interface MangaServiceInterface {
    List<Manga> listMangas();
    Manga getMangaContent(int id, User user) throws MangaException;
    String downloadUrl(int id, User user)throws MangaException;


}
