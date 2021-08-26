package models.user_step_builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserStepBuilder {

    private UserStepBuilder() { }

    public static UUIDStep newBuilder() {
        return new UserSteps();
    }

    public interface UUIDStep {
        FirstNameStep uuid(UUID uuid);
    }

    public interface FirstNameStep {
        LastNameStep fistName(String firstName);
    }

    public interface LastNameStep {
        PhoneNumberEmailStep lastName(String lastName);
    }

    public interface PhoneNumberEmailStep {
        ValidPhoneNumberStep phoneNumber(String phoneNumber);

        ValidEmailStep email(String email);
    }

    public interface ValidPhoneNumberStep {
        CountryStep isValidPhoneNumber(boolean isValidPhoneNumber);
    }

    public interface ValidEmailStep {
        CountryStep isValidEmail(boolean isValidEmail);
    }

    public interface CountryStep {
        StateStep country(String country);
    }

    public interface StateStep {
        AddressStep state(String state);

        AddressStep stateNotAvailable();
    }

    public interface AddressStep {
        AddressStep address(String address);

        CreatedAtStep noMoreAddress();
    }

    public interface CreatedAtStep {
        BuildStep createdAt(long createdAt);
    }

    public interface BuildStep {
        User build();
    }


    private static class UserSteps implements UUIDStep,
                                              FirstNameStep,
                                              LastNameStep,
                                              PhoneNumberEmailStep,
                                              ValidPhoneNumberStep,
                                              ValidEmailStep,
                                              CountryStep,
                                              StateStep,
                                              AddressStep,
                                              CreatedAtStep,
                                              BuildStep {

        private UUID uuid;

        private String firstName;
        private String lastName;

        private String  email;
        private boolean isEmailVerified;

        private String  phone;
        private boolean isPhoneNumberVerified;

        private String country;

        private String state;

        private List<String> addresses = new ArrayList<>();

        private long createdAt;


        @Override
        public FirstNameStep uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        @Override
        public LastNameStep fistName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public PhoneNumberEmailStep lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public ValidPhoneNumberStep phoneNumber(String phoneNumber) {
            this.phone = phoneNumber;
            return this;
        }

        @Override
        public ValidEmailStep email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public CountryStep isValidPhoneNumber(boolean isValidPhoneNumber) {
            this.isPhoneNumberVerified = isValidPhoneNumber;
            return this;
        }

        @Override
        public CountryStep isValidEmail(boolean isValidEmail) {
            this.isEmailVerified = isValidEmail;
            return this;
        }

        @Override
        public StateStep country(String country) {
            this.country = country;
            return this;
        }

        @Override
        public AddressStep state(String state) {
            this.state = state;
            return this;
        }

        @Override
        public AddressStep stateNotAvailable() {
            return this;
        }

        @Override
        public AddressStep address(String address) {
            this.addresses.add(address);
            return this;
        }

        @Override
        public CreatedAtStep noMoreAddress() {
            return this;
        }

        @Override
        public BuildStep createdAt(long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @Override
        public User build() {
            User user = new User(uuid, firstName, lastName, country, createdAt);

            if (phone != null) {
                user.setPhone(phone);
                user.setPhoneNumberVerified(isPhoneNumberVerified);
            }
            else {
                user.setEmail(email);
                user.setEmailVerified(isEmailVerified);
            }

            if (state != null && !state.isEmpty()) {
                user.setState(state);
            }

            if (!addresses.isEmpty()) {
                user.setAddresses(addresses);
            }

            return user;
        }
    }
}
