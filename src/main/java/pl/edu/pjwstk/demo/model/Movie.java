package pl.edu.pjwstk.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import pl.edu.pjwstk.demo.enums.Category;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Movie {

    private Long id;
    private String title;
    private Category category;
    @NonNull
    private boolean isAvailable;
}
