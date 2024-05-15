package com.codecool.men.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
public class UserEntity {
    // egy user-hez több note is tartozhat
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Note> notes;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_roles") // Ez létrehoz egy külön táblát a role-oknak
    @Enumerated(EnumType.STRING) // Ez tárolja az enum értékeket mint String
    private Set<Role> roles = new HashSet<>();




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }


}
