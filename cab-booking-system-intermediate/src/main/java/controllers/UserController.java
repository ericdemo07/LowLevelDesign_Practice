package controllers;

import java.util.UUID;

import authentication_interceptor.AdvanceUserFilter;
import authentication_interceptor.BaseUserFilter;
import authentication_interceptor.FilterManager;
import datastore.BaseDataStore;
import models.Coordinates;
import models.user_step_builder.User;

public class UserController implements IUserController {

    private final FilterManager filterManager;
    private final BaseDataStore baseDataStore;

    public UserController(FilterManager filterManager) {
        this.filterManager = filterManager;

        filterManager.addFilter(new BaseUserFilter());
        filterManager.addFilter(new AdvanceUserFilter());

        baseDataStore = BaseDataStore.getInstance();
    }

    @Override
    public UUID registerUser(User user) throws Exception {
        StringBuilder stringBuilder = filterManager.filterRequest(user);

        if (stringBuilder.length() != 0) {
            throw new Exception(stringBuilder.toString());
        }
        UUID res = baseDataStore.createUser(user);
        return res;
    }


    @Override
    public void print() {
        baseDataStore.print();
    }
}
