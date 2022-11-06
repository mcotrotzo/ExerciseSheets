package exer4.Aufgabe1d;



public class MangaClient {
    public static void main(String[] args)  {
        User user = new User("marco",true,10);
        User user2 = new User("marco2",false,10);
        Manga manga1 = new Manga(123,"manga1","manga1.com");
        Manga manga2 = new Manga(121,"manga2","manga2.com");
        RealManga realManga = new RealManga();
        realManga.addManga(manga1);
        realManga.addManga(manga2);
        MangaServiceInterface proxy = new MangaProxy(realManga);
        System.out.println(proxy.listMangas());
        System.out.println(proxy.getMangaContent(121,user));
        System.out.println(proxy.downloadUrl(123,user));
        System.out.println(proxy.downloadUrl(123,user2));


    }
}
