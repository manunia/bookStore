package mariaL.bookStore.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String text;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "name_name", nullable = false,
//                foreignKey = @ForeignKey(name = "BOOK_FK"))
//    private Autor name;
//
//    public Autor getName() {
//        return name;
//    }
//
//    public void setName(Autor name) {
//        this.name = name;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
