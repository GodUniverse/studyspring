package sty.tx.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sty.tx.Exception.BookStockException;
import sty.tx.Exception.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    public void updateStock(String isbn) {
        String sql = "select stock from book_stock where isbn = ?";
        Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);

        if (stock <= 0) {
            throw new BookStockException("库存不足");
        }

        sql = "update book_stock set stock = stock - 1 where isbn = ?";

        jdbcTemplate.update(sql, isbn);
    }

    public void updateUserAccount(String username, Integer price) {
        String sql = "select balance from account where username = ?";
        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class);

        if (balance < price) {
            throw new UserAccountException("余额不足");
        }

        sql = "update account set balance = balance - ? where username = ?";

        jdbcTemplate.update(sql,price,username);

    }
}
