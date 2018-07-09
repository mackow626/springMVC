package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comments;

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Review(String comments) {
        this.comments = comments;
    }
}
