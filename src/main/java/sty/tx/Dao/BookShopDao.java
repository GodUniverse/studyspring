package sty.tx.Dao;

public interface BookShopDao {
    int findPriceByIsbn(String Isbn);

    void updateStock(String isbn);

    void updateUserAccount(String username, Integer price);
}
