package models.user_step_builder;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID uuid;

    private String firstName;
    private String lastName;

    private String  email;
    private boolean isEmailVerified;

    private String  phone;
    private boolean isPhoneNumberVerified;

    private String country;

    private String state;

    private List<String> addresses;

    private long createdAt;

    public User(UUID uuid, String firstName, String lastName, String country, long createdAt) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.createdAt = createdAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhoneNumberVerified(boolean phoneNumberVerified) {
        isPhoneNumberVerified = phoneNumberVerified;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isEmailVerified=" + isEmailVerified +
                ", phone='" + phone + '\'' +
                ", isPhoneNumberVerified=" + isPhoneNumberVerified +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", addresses=" + addresses +
                ", createdAt=" + createdAt +
                '}';
    }
}
