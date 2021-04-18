package ru.itis.demo.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"carts", "category","productReviews"})
@ToString(exclude = {"carts", "category", "productReviews"})
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Date created;
    private Date updated;
    private String pictureUrl;
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "product_cart",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"))
    private List<Cart> carts;


    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;

}
