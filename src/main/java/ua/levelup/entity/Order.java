package ua.levelup.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "orders", schema = "hotel_hanna")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;
    private String guestQuant;
    private String surname;
    private String name;
    private String phone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="room_id")
    @JsonBackReference
    private Room room;

    public Order(){
   }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getDateFrom() {
        return dateFrom;
    }
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }
    public Date getDateTo() {
        return dateTo;
    }
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
    public String getGuestQuant() {
        return guestQuant;
   }
    public void setGuestQuant(String guestQuant) {
        this.guestQuant = guestQuant;
    }
     public Room getRoom() {
        return room;
     }
    public void setRoom(Room room) {
       this.room = room;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
