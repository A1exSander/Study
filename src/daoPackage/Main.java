package daoPackage;

public class Main {
    public static void main(String[] args) {
        Article article1 = new Article(1, "blabla1", 1);
        ArticleDao articleDao = new ArticleDao();
        articleDao.createArticleTable();
        articleDao.add(article1);

    }
}
