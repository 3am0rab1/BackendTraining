package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "frenship_table")
public class Frenship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long frenshipId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "first_user", nullable = false)
    private User firstUser;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "second_user", nullable = false)
    private User secondUser;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    public Frenship() {
    }

    public Frenship(Long frenshipId, User firstUser, User secondUser, Boolean status) {
        this.frenshipId = frenshipId;
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.status = status;
    }

    public Long getFrenshipId() {
        return frenshipId;
    }

    public void setFrenshipId(Long frenshipId) {
        this.frenshipId = frenshipId;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Frenship{" +
                "frenshipId=" + frenshipId +
                ", firstUser=" + firstUser +
                ", secondUser=" + secondUser +
                ", status=" + status +
                '}';
    }
}
