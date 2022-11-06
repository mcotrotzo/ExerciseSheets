package exer4.Aufgabe1d;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MangaTest {

    @Test
    void testMangaList(){
        User user = new User("marco",true,10);
        Manga manga1 = new Manga(123,"manga1","manga1.com");
        Manga manga2 = new Manga(121,"manga2","manga2.com");
        RealManga realManga = new RealManga();
        realManga.addManga(manga1);
        realManga.addManga(manga2);
        MangaServiceInterface proxy = new MangaProxy(realManga);
        assertEquals(proxy.listMangas().size(), List.of(manga1,manga2).size());
        assertTrue(proxy.listMangas().contains(manga1)&&proxy.listMangas().contains(manga2));
        assertEquals(proxy.listMangas().size(),realManga.listMangas().size());
        assertTrue(realManga.listMangas().contains(manga1)&&realManga.listMangas().contains(manga2));
    }
    @Test
    void getMangaContentExceptions(){
        User user = new User("marco",true,0);
        Manga manga1 = new Manga(123,"manga1","manga1.com");
        Manga manga2 = new Manga(121,"manga2","manga2.com");
        RealManga realManga = new RealManga();
        realManga.addManga(manga1);
        realManga.addManga(manga2);
        MangaServiceInterface proxy = new MangaProxy(realManga);
        assertThrows(IllegalArgumentException.class, () -> proxy.getMangaContent(12,null));
        assertThrows(IllegalArgumentException.class, () -> proxy.getMangaContent(-2,user));
        assertThrows(IllegalStateException.class, () -> proxy.getMangaContent(123,user));
        assertThrows(IllegalArgumentException.class, () -> realManga.getMangaContent(124,user));
    }

    @Test
    void getMangaContent(){
        User user = new User("marco",true,5);
        Manga manga1 = new Manga(123,"manga1","manga1.com");
        Manga manga2 = new Manga(121,"manga2","manga2.com");
        RealManga realManga = new RealManga();
        realManga.addManga(manga1);
        realManga.addManga(manga2);
        MangaServiceInterface proxy = new MangaProxy(realManga);

        assertEquals(proxy.getMangaContent(123,user),manga1);
        assertEquals(proxy.getMangaContent(123,user),realManga.getMangaContent(123,user));
    }
    @Test
    void getDownloadUrlException(){
        User user = new User("marco",true,3);
        Manga manga1 = new Manga(123,"manga1","manga1.com");
        Manga manga2 = new Manga(121,"manga2","manga2.com");
        RealManga realManga = new RealManga();
        realManga.addManga(manga1);
        realManga.addManga(manga2);
        MangaServiceInterface proxy = new MangaProxy(realManga);
        assertThrows(IllegalArgumentException.class, () -> proxy.downloadUrl(12,null));
        assertThrows(IllegalArgumentException.class, () -> proxy.downloadUrl(-2,user));

    }
    @Test
    void getDownloadUrl(){
        User user = new User("marco",true,3);
        Manga manga1 = new Manga(123,"manga1","manga1.com");
        Manga manga2 = new Manga(121,"manga2","manga2.com");
        RealManga realManga = new RealManga();
        realManga.addManga(manga1);
        realManga.addManga(manga2);
        MangaServiceInterface proxy = new MangaProxy(realManga);
        proxy.downloadUrl(123,user);
        assertEquals("manga1.com",proxy.downloadUrl(123,user));
        assertEquals(proxy.downloadUrl(123,user),realManga.downloadUrl(123,user));




    }


}
