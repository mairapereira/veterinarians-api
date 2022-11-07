package py.com.pegasus.test.veterinarians.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import py.com.pegasus.test.veterinarians.clients.dtos.PersonDto;

@FeignClient(name = "persons-api")
public interface PersonClient {

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    PersonDto getPersonById(@PathVariable("id") String id);
}