package com.learnSpring.restfulwebservices.user;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserDaoService {

    private static List<User> users=new ArrayList<>();
    private static int userCount=0;
    static {
//        users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
//        users.add(new User(++userCount,"rgr", LocalDate.now().minusYears(40)));
//        users.add(new User(++userCount,"Adrgrgam", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){return users;}

    public User findOne(int id){
        Predicate<? super User> predicate=user-> user.getId().equals(id);
        Optional<User> found = Optional.empty();
        for (User user1 : users) {
            if (predicate.test(user1)) {
                found = Optional.of(user1);
                break;
            }
        }
        return found.orElse(null);

    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        Predicate<? super User> predicate=user-> user.getId().equals(id);
        Optional<User> found = Optional.empty();
        users.removeIf(predicate);
    }


}
