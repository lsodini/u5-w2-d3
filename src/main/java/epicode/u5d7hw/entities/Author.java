package epicode.u5d7hw.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
    private String avatar;

    @OneToMany(mappedBy = "author")
    private List<Blogpost> blogposts;
}
