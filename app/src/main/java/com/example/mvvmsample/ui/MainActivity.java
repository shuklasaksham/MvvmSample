package com.example.mvvmsample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.UserRepository;
import com.example.mvvmsample.ui.UserViewModel.UserViewModelFactory;
import com.example.mvvmsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory)
                new UserViewModelFactory(new UserRepository())).get(UserViewModel.class);
        UserAdapter adapter = new UserAdapter();
        viewModel.users.observe(this, users -> adapter.submitList(users));
        binding.rvUsers.setAdapter(adapter);
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        viewModel.fetchUsers();
    }
}