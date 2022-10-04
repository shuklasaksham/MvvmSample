package com.example.mvvmsample.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmsample.data.UserRepository;
import com.example.mvvmsample.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {

    public final LiveData<List<User>> users;
    private final MutableLiveData<List<User>> _users;


    private final UserRepository repository;

    public UserViewModel(UserRepository repository) {
        this.repository = repository;
        this._users = new MutableLiveData<>(new ArrayList<>());
        this.users = _users;
    }

    public void fetchUsers() {
        repository.getUsers(users -> _users.setValue(users));
    }

    public static class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {

        private final UserRepository repository;

        public UserViewModelFactory(UserRepository repository){
          this.repository=repository;
        }
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new UserViewModel(repository);
        }
    }
}
