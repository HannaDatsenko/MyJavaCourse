package ua.levelup.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.levelup.entity.Room;
import java.util.Date;
import java.util.List;
@Repository
@Transactional
public class RoomRepository extends AbstractRepository{
    public  List<Room> findRooms(Date dateFrom, Date dateTo, String GuestQuant) {
        Integer guests = Integer.parseInt(GuestQuant);
        try {
            if (guests == 1) {
                return entityManager.createQuery("SELECT r FROM Room r WHERE r.roomGuest=2 AND NOT EXISTS (SELECT o FROM Order o WHERE o.room=r AND (:dateFrom BETWEEN o.dateFrom AND o.dateTo OR :dateTo BETWEEN o.dateFrom AND o.dateTo))", Room.class).setParameter("dateFrom", dateFrom).setParameter("dateTo", dateTo).getResultList();
            }
            return entityManager.createQuery("SELECT r FROM Room r WHERE r.roomGuest=:guests AND NOT EXISTS (SELECT o FROM Order o WHERE o.room=r AND (:dateFrom BETWEEN o.dateFrom AND o.dateTo OR :dateTo BETWEEN o.dateFrom AND o.dateTo))", Room.class).setParameter("dateFrom", dateFrom).setParameter("dateTo", dateTo).setParameter("guests", guests).getResultList();
        }catch (Exception e) {
            return null;
        }
    }
}
