package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer client_id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String avatar;
    private String phone;
    private String role;
    private String address;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;
    @OneToMany (mappedBy = "clientId", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                ", cart=" + cart +
                ", orderList=" + orderList +
                '}';
    }
}
