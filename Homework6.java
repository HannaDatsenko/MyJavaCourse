package ua.levelup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Homework6 {
    public static String firstNameOwner;
    public static String lastNameOwner;
    public static String ageOwner;
    public static String addressOwner;
    public static String phoneOwner;
    public static String namePet;
    public static String petOwner;
    public static String agePet;
    public static final String OWNER_PETS = "OneFile.json";
    public static JSONArray arrayOwners;
    public static JSONArray arrayPets;
    public static void main(String[] args) {
        OwnerReader ownerReader = new OwnerReader();
        arrayOwners = ownerReader.readOwners(OWNER_PETS);
        PetsReader petsReader = new PetsReader();
        arrayPets = petsReader.readPets(OWNER_PETS);

        for (Object owner : arrayOwners) {
            JSONObject ownerObject = (JSONObject)owner;
            firstNameOwner = ownerObject.getString("firstName");
            lastNameOwner = ownerObject.getString("lastName");
            addressOwner = ownerObject.getString("adrress");
            ageOwner = ownerObject.getString("age");
            phoneOwner = ownerObject.getString("phone");
            createOwner(firstNameOwner, lastNameOwner, ageOwner, addressOwner, phoneOwner);

        }

        for (Object pet : arrayPets) {
            JSONObject petObject = (JSONObject)pet;
            namePet = petObject.getString("name");
            petOwner = petObject.getString("owner");
            agePet = petObject.getString("age");
            createPet(namePet, petOwner, agePet);
        }


    }

    static void createOwner(String firstNameOwner, String lastNameOwner, String ageOwner, String addressOwner, String phoneOwner) {
      Owner owner = new Owner(firstNameOwner, lastNameOwner, ageOwner, addressOwner, phoneOwner);
      System.out.println(owner.equals(owner));
    }

    static void createPet(String namePet, String petOwner, String agePet) {
       Pet pet = new Pet(namePet, petOwner, agePet);
        System.out.println(pet.equals(pet));
    }

}
