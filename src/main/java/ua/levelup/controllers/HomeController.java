package ua.levelup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.levelup.dao.OrderRepository;
import ua.levelup.dao.RoomRepository;
import ua.levelup.dao.UsersRep;
import ua.levelup.entity.Order;
import ua.levelup.entity.Room;
import ua.levelup.entity.User;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    UsersRep usersRepository;
    @Autowired
    RoomRepository roomsRepository;
    @Autowired
    OrderRepository ordersRepository;
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
    @PostMapping("/registration")
    @ResponseBody
    public String save(@RequestBody User user) {

        if(usersRepository.findUserByLogin(user.getLogin())==null) {
             usersRepository.saveUser(user);
             return "Регистрация успешна";
        }
            return "Укажите другой логин";
    }
        @PostMapping("/authorization")
        @ResponseBody
    public String authorization(@RequestBody User user) {

            if (usersRepository.findUserByLoginAndPassword(user.getLogin(), user.getPassword())!=null) {
                return user.getLogin();
            }
           return "Not find";
    }
    @PostMapping("/freerooms")
    @ResponseBody
    public List<Room> findFreeRooms(@RequestBody Order order) {
        return roomsRepository.findRooms(order.getDateFrom(), order.getDateTo(), order.getGuestQuant());
    }
    @PostMapping("/bookroom")
    @ResponseBody
    public String bookFreeRoom(@RequestBody Order order) {

        List<Order> orders = ordersRepository.findOrders(order.getDateFrom(), order.getDateTo(), order.getRoom().getId());
        if(orders==null){
            ordersRepository.saveOrder(order);
            return "Номер успешно забронирован";
        }else{return "Номер занят";
        }
    }
}
