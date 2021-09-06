package controllers;

import java.util.UUID;

import com.doom.geoservice.models.user_step_builder.User;

public interface IUserController {

    UUID registerUser(User user) throws Exception;

    void print();
}
