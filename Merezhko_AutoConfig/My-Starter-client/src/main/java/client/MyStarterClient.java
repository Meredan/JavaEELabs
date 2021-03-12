package client;

import library.BookFour;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyStarterClient {
    public static void main(String[] args) {
        SpringApplication.run(MyStarterClient.class, args);
    }

    @Bean
    @ConditionalOnMissingBean(BookFour.class)
    public void bookFourMiss() { System.out.println("Book four missing."); }

    @Bean
    @ConditionalOnBean(BookFour.class)
    public void bookFour_() {
        System.out.println("It is book number four.");
    }

    @Bean
    @ConditionalOnMissingBean(BookFour.class)
    public void bookOneMiss() { System.out.println("Book one missing.");   }

    @Bean
    @ConditionalOnBean(BookFour.class)
    public void bookOne_() {
        System.out.println("It is book number one.");
    }

    @Bean
    @ConditionalOnMissingBean(BookFour.class)
    public void bookTwoMiss() { System.out.println("Book two missing."); }

    @Bean
    @ConditionalOnBean(BookFour.class)
    public void bookTwo_() {
        System.out.println("It is book number two.");
    }

    @Bean
    @ConditionalOnMissingBean(BookFour.class)
    public void bookThreeMiss() { System.out.println("Book three missing.");   }


}
