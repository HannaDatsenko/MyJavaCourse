package ua.levelup;

public class Pet {
    private String name;
    private String owner;
    private String age;

    public Pet(String namePet, String petOwner, String agePet) {
        this.name = namePet;
        this.owner = petOwner;
        this.age = agePet;
    }
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Pet)) {
            return false;
        }
        return this.name == null||this.owner == null||this.age == null;
    }
}
