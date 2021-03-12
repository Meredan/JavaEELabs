package library;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value="book.one", havingValue="book1")
public class BookOne implements MyLibraryClass,InitializingBean{
    @Override
    public String bookName() {
        return "Остання справа Холмса";
    }

    @Override
    public String author() {
        return "Артур Конан-Дойл";
    }

    @Override
    public String genre() {
        return "Детектив";
    }

    @Override
    public Integer year() {
        return 1893;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String bookFour = "Book: "+bookName()+" ,author: "+author()+" ,genre: "+genre()+" ,presented in "+year()+".";
        System.out.println(bookFour);
    }
}
