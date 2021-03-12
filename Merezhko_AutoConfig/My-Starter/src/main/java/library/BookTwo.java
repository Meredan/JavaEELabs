package library;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value="book.two", havingValue="book2")
public class BookTwo implements MyLibraryClass,InitializingBean{
    @Override
    public String bookName() {
        return "Гаррі Поттер і філософський камінь";
    }

    @Override
    public String author() {
        return "Джоан Роулінг";
    }

    @Override
    public String genre() {
        return "Фентезі";
    }

    @Override
    public Integer year() {
        return 1997;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String bookFour = "Book: "+bookName()+" ,author: "+author()+" ,genre: "+genre()+" ,presented in "+year()+".";
        System.out.println(bookFour);
    }
}
