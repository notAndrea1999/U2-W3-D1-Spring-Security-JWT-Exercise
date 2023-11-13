package andreademasi.runners;

import andreademasi.payloads.users.NewUserDTO;
import andreademasi.services.UserService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Slf4j
public class UserRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Supplier<NewUserDTO> userSupplier = () -> new NewUserDTO(faker.name().username(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress()
        );
//        for (int i = 0; i < 30; i++) {
//            userService.saveUser(userSupplier.get());
//        }


    }
}
