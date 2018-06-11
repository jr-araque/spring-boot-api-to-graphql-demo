package com.accenture.graphqlDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this.equals(o)) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;

        Author author = (Author) o;

        return this.getId().equals(author.getId());
    }

    @Override
    public int hashCode() {
        return this.getLastName().hashCode();
    }

    @Override
    public String toString() {
        return ("Author{" + "id=" + this.getId() + ", firstName='" + this.getFirstName() + "\'" + ", lastName='" + this.getLastName() + "\'" + "}");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
}
