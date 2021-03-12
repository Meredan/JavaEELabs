package library;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value="book.four", havingValue="book4")
public class BookFour implements MyLibraryClass,InitializingBean{
    @Override
    public String bookName() {
        return "Злочин і кара";
    }

    @Override
    public String author() {
        return "Федір Достоєвський";
    }

    @Override
    public String genre() {
        return "Психологічний реалізм";
    }

    @Override
    public Integer year() {
        return 1866;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    String bookFour = "Book: "+bookName()+" ,author: "+author()+" ,genre: "+genre()+" ,presented in "+year()+".";
    System.out.println(bookFour);
    }
}
