package lk.ijse.dep.web.pos.entity;

public interface CustomEntity3 {

    String getItemCode();       // itemCode

    int getQty();               // qty

    default void printDetails(){
        System.out.println("code=" + getItemCode() + ", qty=" + getQty());
    }
}
