package ru.itis.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"productList", "account"})
@ToString(exclude = {"productList", "account"})
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToMany(mappedBy = "carts")
    private List<Product> productList;
}
