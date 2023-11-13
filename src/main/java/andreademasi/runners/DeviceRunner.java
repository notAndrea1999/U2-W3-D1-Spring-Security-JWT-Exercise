package andreademasi.runners;

import andreademasi.services.DeviceService;
import andreademasi.services.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DeviceRunner implements CommandLineRunner {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random rndm = new Random();
//        for (int i = 0; i < 30; i++) {
//
//            long usersId = userService.findUserById(rndm.nextInt(1, 21)).getUserId();
//            NewDeviceDTO deviceDTO = new NewDeviceDTO(
//                    faker.commerce().productName(),
//                    DeviceStatus.randomDeviceStatus(),
//                    usersId
//            );
//            deviceService.saveDevice(deviceDTO);
//        }
    }
}

