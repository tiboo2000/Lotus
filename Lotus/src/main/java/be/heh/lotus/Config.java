package be.heh.lotus;

import be.heh.lotus.adapter.out.persistance.BagAdapterPersistence;
import be.heh.lotus.adapter.out.persistance.CategoryAdapterPersistence;
import be.heh.lotus.adapter.out.persistance.ProductAdapterPersistence;
import be.heh.lotus.adapter.out.persistance.repository.BagRepository;
import be.heh.lotus.adapter.out.persistance.repository.CategoriesRepository;
import be.heh.lotus.adapter.out.persistance.repository.ProductRepository;
import be.heh.lotus.application.domain.service.GestionCategories;
import be.heh.lotus.application.domain.service.Gestion_Bag;
import be.heh.lotus.application.domain.service.Gestion_Product;
import be.heh.lotus.application.port.in.UseCase_In_Bag;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import be.heh.lotus.application.port.in.UseCase_In_Product;
import be.heh.lotus.application.port.out.Bag_Out;
import be.heh.lotus.application.port.out.Categories_Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJdbcRepositories
public class Config {
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BagRepository bagRepository;
    Bag_Out bagOut;
    @Bean
    public UseCase_In_Categories getCategoryUseCase(){
        return new GestionCategories(new CategoryAdapterPersistence(categoriesRepository));
    }
    @Bean
    public UseCase_In_Product getProductUseCase(){
        return new Gestion_Product(new ProductAdapterPersistence(productRepository));
    }
    @Bean
    public UseCase_In_Bag getBagUseCase(){
        return new Gestion_Bag(new BagAdapterPersistence(bagRepository));
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")
                        .allowedOrigins("http://localhost:3000") // Remplacez par l'URL de votre application React
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowedHeaders("")
                        .allowCredentials(true);
            }
        };
    }
}