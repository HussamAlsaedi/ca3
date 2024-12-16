package com.example.marketing.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BookingPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingPackageId;

    private int total;

    private Date bookingDate;

    private int bookingTotalPrice;

    private String bookingStatus;

    @ManyToOne
    @JoinColumn(name = "Company_company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "Influencer_Influencer_id", nullable = false)
    private Influencer influencer;

    @ManyToOne
    @JoinColumn(name = "package_idpackage", nullable = false)
    private Package packageEntity;
}
