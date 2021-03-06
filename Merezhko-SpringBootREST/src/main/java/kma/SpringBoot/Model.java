package kma.SpringBoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @NotNull
    private String isbn;
    @NotNull
    private String title;
    @NotNull
    private String author;

}
