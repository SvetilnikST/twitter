package by.svetilnik.twitter.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "twit")
public class Twit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String twit;

    @NotNull
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTwit() {
        return twit;
    }

    public void setTwit(String twit) {
        this.twit = twit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Twit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + twit + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Twit twit = (Twit) o;
        return Objects.equals(getId(), twit.getId()) &&
                Objects.equals(getTitle(), twit.getTitle()) &&
                Objects.equals(getTwit(), twit.getTwit()) &&
                Objects.equals(getUserId(), twit.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getTwit(), getUserId());
    }
}
