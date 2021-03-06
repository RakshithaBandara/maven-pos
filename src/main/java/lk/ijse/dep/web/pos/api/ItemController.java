package lk.ijse.dep.web.pos.api;

import lk.ijse.dep.web.pos.business.custom.ItemBO;
import lk.ijse.dep.web.pos.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/items")
@RestController
public class ItemController {

    @Autowired
    private ItemBO itemBO;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() throws Exception {
        return itemBO.findAllItems();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveItem(@RequestBody ItemDTO item) throws Exception {
        itemBO.saveItem(item);
        return item.getCode();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code:C\\d{3}}")
    public void deleteItem(@PathVariable String code) throws Exception {
        itemBO.deleteItem(code);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{code:C\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@PathVariable String code,
                           @RequestBody ItemDTO item) throws Exception {
        item.setCode(code);
        itemBO.updateItem(item);
    }
}
