package ra.springboot.Service;

import ra.springboot.Exception.PersonException;
import ra.springboot.Model.Domain.Person;
import ra.springboot.Model.Dto.Request.PersonRequest;
import ra.springboot.Model.Dto.Response.PersonResponse;

import java.util.List;

public interface IPersonService {
    List<PersonResponse> findAll();

    PersonResponse findById(Long id);

    PersonResponse save(PersonRequest personRequest) throws PersonException;

    PersonResponse update(PersonRequest personRequest, Long id);

    PersonResponse delete(Long id);

}
