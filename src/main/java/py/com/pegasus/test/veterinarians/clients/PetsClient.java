package py.com.pegasus.test.veterinarians.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import py.com.pegasus.test.veterinarians.clients.dtos.PetsDto;

@FeignClient(name = "pets-api")
public interface PetsClient {

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    PetsDto getPetsByOwner(@RequestParam("owner") String ownerId);
}