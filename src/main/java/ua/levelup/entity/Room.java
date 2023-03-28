package ua.levelup.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "rooms", schema = "hotel_hanna")
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Integer roomGuest;
    private String info;
    private Integer price;
    private String linkPhoto;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Order> orders;

    public Room(){
        this.orders = new ArrayList<>();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getRoomGuest() {
       return roomGuest;
    }
    public void setRoomGuest(Integer roomGuest) {
       this.roomGuest = roomGuest;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
       this.info = info;
   }
   public Integer getPrice() {
       return price;
    }
   public void setPrice(Integer price) {
       this.price = price;
    }
    public String getLinkPhoto() {
        return linkPhoto;
    }
   public void setLinkPhoto(String linkPhoto) {
        this.linkPhoto = linkPhoto;
    }
    public List<Order> getOrders() {
     return orders;
    }
}
