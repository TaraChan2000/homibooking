package com.booking.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;

    private Double price;

    private String sex;

    private Integer quantity;

    private Integer quantityRoom;

    private float area;

    private String description;

    private Integer deleted;

    private Timestamp createdDate;

    private Timestamp censorshipDate;

    private Integer actived;

    private String banner;

    @ManyToOne
    @JoinColumn(name = "user_feed_back")
    private User userFeedBack;

    @ManyToOne
    @JoinColumn(name = "room_status_id")
    private RoomStatus roomStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village address;

    private String detailAddress;

    @ManyToOne
    @JoinColumn(name = "type_room_id")
    private TypeRoom typeRoom;

    @JsonIgnoreProperties(value = {"room"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "room_utilities",
            joinColumns = { @JoinColumn(name = "room_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "utilities_id", referencedColumnName = "id") }
    )
    @BatchSize(size = 50)
    private List<Utilities> utilities = new ArrayList<>();

}
