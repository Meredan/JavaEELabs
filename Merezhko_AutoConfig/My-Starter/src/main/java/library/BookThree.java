package library;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value="book.three", havingValue="book3")
public class BookThree implements MyLibraryClass, InitializingBean {
    @Override
    public String bookName() {
       return  "Книга джунглів";
    }

    @Override
    public String author() {
        return "Редьярд Кіплінг";
    }

    @Override
    public String genre() {
        return "Пригоди";
    }

    @Override
    public Integer year() {
        return 1894;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String bookFour = "Book: "+bookName()+" ,author: "+author()+" ,genre: "+genre()+" ,presented in "+year()+".";
        System.out.println(bookFour);
    }
}
