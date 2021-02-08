package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDAO extends JpaRepository<Item, String> {

    List<Item> queryItemByQtyOnHandGreaterThanEqual(int qty);
}
