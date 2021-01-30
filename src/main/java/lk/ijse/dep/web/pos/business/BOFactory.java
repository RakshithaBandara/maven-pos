package lk.ijse.dep.web.pos.business;

import lk.ijse.dep.web.pos.business.custom.impl.CustomerBOImpl;
import lk.ijse.dep.web.pos.business.custom.impl.ItemBOImpl;
import lk.ijse.dep.web.pos.business.custom.impl.OrderBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory != null) ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends SuperBO> T getBO(BOTypes boType) {
        switch (boType) {
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return (T) new OrderBOImpl();
            default:
                return null;
        }
    }
}
