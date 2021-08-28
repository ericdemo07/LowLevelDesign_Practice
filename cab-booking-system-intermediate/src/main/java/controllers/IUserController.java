package controllers;

import java.util.UUID;

import models.user_step_builder.User;

public interface IUserController {

    UUID registerUser(User user) throws Exception;

    void print();
}
