package org.example.hsf301.pojo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "koi_farms")
public class KoiFarms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "farmName")
    private String farmName;

    @Column(name = "farmPhoneNumber")
    private String farmPhoneNumber;

    @Column(name = "farmEmail")
    private String farmEmail;

    @Column(name="image")
    private String image;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "farmAddress")
    private String farmAddress;

    @Column(name = "website")
    private String website;

    @Column(name = "isActive")
    private boolean isActive;

    @OneToMany(mappedBy = "farm", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<TourDetail> tourDetails;

    @OneToMany(mappedBy = "koiFarms", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<KoiOfFarm> koiOfFarms;

}
