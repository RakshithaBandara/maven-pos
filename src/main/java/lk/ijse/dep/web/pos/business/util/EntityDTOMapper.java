package lk.ijse.dep.web.pos.business.util;

import lk.ijse.dep.web.pos.dto.CustomerDTO;
import lk.ijse.dep.web.pos.dto.ItemDTO;
import lk.ijse.dep.web.pos.dto.StudentDTO;
import lk.ijse.dep.web.pos.entity.Customer;
import lk.ijse.dep.web.pos.entity.Item;
import lk.ijse.dep.web.pos.entity.Student;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

@Mapper
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

//    default EntityDTOMapper getInstance(){
//        return Mappers.getMapper(EntityDTOMapper.class);
//    }

    Customer getCustomer(CustomerDTO dto);

    CustomerDTO getCustomerDTO(Customer customer);

    List<CustomerDTO> getCustomerDTOs(List<Customer> customers);

    Item getItem(ItemDTO dto);

    ItemDTO getItemDTO(Item item);

//    Order getOrder(OrderDTO dto);

    @Mapping(source = "id", target = "studentId")
    @Mapping(source = ".", target = "studentAddress", qualifiedBy = Address.class)
    @Mapping(source = ".", target = "studentName")
    Student getStudent(StudentDTO dto);

    @InheritInverseConfiguration
    @Mapping(source = ".", target = "firstName", qualifiedByName = "firstName")
    @Mapping(source = ".", target = "lastName", qualifiedByName = "lastName")
    @Mapping(source = ".", target = "firstAddress", qualifiedByName = "firstAddress")
    @Mapping(source = ".", target = "lastAddress", qualifiedByName = "lastAddress")
    @Mapping(source = ".", target = "contact", qualifiedByName = "defaultContact")
    StudentDTO getStudentDTO(Student student);

    default String getName(StudentDTO dto) {
        return dto.getFirstName() + " " + dto.getLastName();
    }

    @Address
    default String getAddress(StudentDTO dto) {
        return dto.getFirstAddress() + " " + dto.getLastAddress();
    }

    @Named("firstName")
    default String getFirstName(Student student) {
        return student.getStudentName().split(" ")[0];
    }

    @Named("lastName")
    default String getLastName(Student student) {
        return student.getStudentName().split(" ")[1];
    }

    @Named("firstAddress")
    default String getFirstAddress(Student student) {
        return student.getStudentAddress().split(" ")[0];
    }

    @Named("lastAddress")
    default String getLastAddress(Student student) {
        return student.getStudentAddress().split(" ")[1];
    }

    @Named("defaultContact")
    default String getDefaultContact(Student s) {
        return "077-1234567";
    }
}

@Qualifier
@Target(ElementType.METHOD)
@interface Address {

}
