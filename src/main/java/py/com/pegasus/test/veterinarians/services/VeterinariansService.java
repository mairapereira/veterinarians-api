package py.com.pegasus.test.veterinarians.services;


import py.com.pegasus.test.veterinarians.exceptions.ApiException;
import py.com.pegasus.test.veterinarians.models.Person;

public interface VeterinariansService {
    Person findAllPetsByOwner(String owner) throws ApiException;
}
