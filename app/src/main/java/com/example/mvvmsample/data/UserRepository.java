package com.example.mvvmsample.data;

import com.example.mvvmsample.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void getUsers(UserDataListener callback) {
        User user1 = new User("A", "a@gmil.com", "1234567890");
        User user2 = new User("B", "b@gmil.com", "1234567890");
        User user3 = new User("C", "c@gmil.com", "1234567890");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        callback.onData(users);
    }

    public interface UserDataListener {
        void onData(List<User> users);
    }
}
