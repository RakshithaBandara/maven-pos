package lk.ijse.dep.web.pos.business.custom;

import lk.ijse.dep.web.pos.business.SuperBO;
import lk.ijse.dep.web.pos.dto.OrderDTO;

public interface OrderBO extends SuperBO {

    public void placeOrder(OrderDTO orderDTO) throws Exception;

}
