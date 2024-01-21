package be.heh.lotus.adapter.in.web;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Bag;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdapterWeb {
    private UseCase_In_Categories categoriesUseCase;

    private UseCase_In_Bag bagUseCase; //TO ADD
    public AdapterWeb(UseCase_In_Categories categoriesUseCase, UseCase_In_Bag bagUseCase) {
        this.bagUseCase=bagUseCase;//TO ADD
        this.categoriesUseCase=categoriesUseCase;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Categories>> getAllCategoriesWeb(){
        List<Categories> categoriesArrayList=categoriesUseCase.get();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(categoriesArrayList);
    }
    @GetMapping("/category")
    public ResponseEntity<Categories> getCategoryWeb(@RequestParam(required = true)int id, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        List<Categories> category=categoriesUseCase.getById(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(category.get(0));
    }
    @PostMapping("/category")
    public ResponseEntity<String> addCategoryWeb(@Validated @RequestBody Categories category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Category added");
        }
        categoriesUseCase.add(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category added successfully");
    }
    @DeleteMapping("/category")
    public ResponseEntity<String> removeCategoryWeb(@RequestParam(required = true)int id,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Category deleted");
        }
        categoriesUseCase.removeById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category deleted successfully");
    }
    //Max Bag
    @GetMapping("/bag")
    public ResponseEntity<Bag> getUserBag(@RequestParam(required = true)String user){
        Bag bagArrayList=bagUseCase.getBagUser(user);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(bagArrayList);
    }
    @GetMapping("/bag/getquantity")
    public ResponseEntity<Integer> getBagWeb(@RequestParam(required = true) Product product, @RequestParam(required = true) String nameuser, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        int bag=bagUseCase.getQuantity(product,nameuser);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(bag);
    }
    @PostMapping("/bag/add")
    public ResponseEntity<String> addBagWeb(@Validated @RequestParam(required = true)String nameuser, @Validated @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Bag added");
        }
        bagUseCase.AddToBag(product, nameuser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bag added successfully");
    }
    @DeleteMapping("/bag/delete")
    public ResponseEntity<String> removeBagWeb(@RequestParam(required = true)String nameuser,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Bag deleted");
        }
        bagUseCase.ResetBag(nameuser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bag deleted successfully");
    }

    @DeleteMapping("/bag/delete/product")
    public ResponseEntity<String> removeBagWeb(@RequestParam(required = true)String nameuser, @RequestParam(required = true)Product product,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Product deleted");
        }
        bagUseCase.SuppFromBag(product, nameuser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product deleted successfully");
    }

    @PutMapping("/bag/update")
    public ResponseEntity<String> updateBagWeb(@RequestParam(required = true)String nameuser, @RequestParam(required = true)Product product, @RequestParam(required = true)int quantity, @RequestParam(required = true)String operation,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Product updated");
        }
        bagUseCase.modifyQuantity(bagUseCase.getQuantity(product, nameuser),quantity, operation, nameuser ,product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Quantity Product updated successfully");
    }
}
