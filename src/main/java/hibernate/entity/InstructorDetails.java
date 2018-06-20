package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChanel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetails", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id")
    private Instructor instructor;


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getYoutubeChanel() {
        return youtubeChanel;
    }

    public void setYoutubeChanel(String youtubeChanel) {
        this.youtubeChanel = youtubeChanel;
    }

    public String getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChanel='" + youtubeChanel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public InstructorDetails() {

    }

    public InstructorDetails(String youtubeChanel, String hobby, Instructor instructor) {
        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    public InstructorDetails(String youtubeChanel, String hobby) {

        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;

    }
}
