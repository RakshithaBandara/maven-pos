package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.entity.CustomEntity3;
import lk.ijse.dep.web.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ItemDAO extends JpaRepository<Item, String> {

    List<Item> immediateStock();

    List<Item> queryItemByQtyOnHandLessThanEqual(int qty);

    @Query(value = "SELECT i.code as itemCode, SUM(order_detail.qty) as qty FROM order_detail INNER JOIN `order` o on order_detail.order_id = o.id INNER JOIN item i on order_detail.item_code = i.code WHERE o.date BETWEEN ?1 AND ?2 \n" +
            "GROUP BY item_code", nativeQuery = true)
    List<CustomEntity3> getMostSellingItems(Date from, Date to);

}
