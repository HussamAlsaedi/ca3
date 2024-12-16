package com.example.marketing.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer type_id;

    @NotEmpty(message = "Type name is mandatory")
    @Size(min = 3, max = 100, message = "Type name must be between 3 and 100 characters")
    @Column(nullable = false)
    private String type_name;

    @NotNull(message = "Type price is mandatory")
    @Min(value = 1, message = "Type price must be at least 1")
    @Column(nullable = false)
    private Integer type_price;

    @ManyToOne
    @JoinColumn(name = "platform_platform_id", nullable = false)
    private Platform platform;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<BookingOneTime> bookingOneTimes;


}
