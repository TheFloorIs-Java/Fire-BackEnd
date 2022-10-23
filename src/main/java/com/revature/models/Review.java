package com.revature.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
@Builder
@ToString(exclude = "user")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name= "product_id",
            referencedColumnName = "id"
    )
    private Product product  ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name= "user_id",
            referencedColumnName = "id"
    )
    private  User user;
    private String review;
    private int score;



}
