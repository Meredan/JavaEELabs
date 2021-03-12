package library;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MyLibraryAutoConfig.class)
public class MyLibraryAutoConfig {

    @Bean
    @ConditionalOnProperty(value = "book.four", havingValue = "book4")
    MyLibraryClass bookFourTest() {
        return new BookFour();
    }

    @Bean
    @ConditionalOnProperty(value = "book.one", havingValue = "book1")
    MyLibraryClass bookOneTest() {
        return new BookOne();
    }

    @Bean
    @ConditionalOnProperty(value = "book.two", havingValue = "book2")
    MyLibraryClass bookTwoTest() {
        return new BookTwo();
    }

    @Bean
    @ConditionalOnProperty(value = "book.three", havingValue = "book3")
    MyLibraryClass bookThreeTest() {
        return new BookThree();
    }



}
