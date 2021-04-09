package ru.itis.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phone;


    @Enumerated(value = EnumType.STRING)
    private State state;

    private String confirmCode;
    private Role role;


    @OneToMany(mappedBy = "account")
    private List<ProductReview> productReview;
}