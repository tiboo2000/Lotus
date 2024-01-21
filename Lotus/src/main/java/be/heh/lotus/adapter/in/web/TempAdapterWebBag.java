package be.heh.lotus.adapter.in.web;

import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.port.in.UseCase_In_Bag;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
public class TempAdapterWebBag {
    private UseCase_In_Categories categoriesUseCase;
    public TempAdapterWebBag(UseCase_In_Categories categoriesUseCase) {this.categoriesUseCase=categoriesUseCase;}
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

    private UseCase_In_Bag bagUseCase;

    public TempAdapterWebBag(UseCase_In_Bag bagUseCase) {this.bagUseCase=bagUseCase;}

    
}
