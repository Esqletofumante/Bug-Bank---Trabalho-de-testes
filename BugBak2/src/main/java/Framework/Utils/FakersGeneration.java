package Framework.Utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakersGeneration {

    private Faker faker;
    private String firstName;
    private String senha;
    private String email;

    public FakersGeneration() {

        faker = new Faker(new Locale("pt-BR"));
    }

    public String getFirstName() {

        firstName = faker.name().firstName();
        return firstName;

        //return faker.name().firstName();

    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generatePassword() {
        return faker.internet().password();
    }


    public String getEmail(){

        email = faker.internet().emailAddress();
        return email;
    }
}
