package ua.levelup;

import java.io.FileInputStream;

public class Owner {
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private String phone;


    public Owner(String firstNameOwner, String lastNameOwner, String ageOwner, String addressOwner, String phoneOwner) {
        this.firstName = firstNameOwner;
        this.lastName = lastNameOwner;
        this.address = addressOwner;
        this.age = ageOwner;
        this.phone = phoneOwner;
    }
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Owner)) {
            return false;
        }
        return this.firstName == null||this.lastName == null||this.address == null;
    }
}
