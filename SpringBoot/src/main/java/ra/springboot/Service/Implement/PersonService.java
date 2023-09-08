package ra.springboot.Service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springboot.Exception.PersonException;
import ra.springboot.Model.Domain.Person;
import ra.springboot.Model.Dto.Request.PersonRequest;
import ra.springboot.Model.Dto.Response.PersonResponse;
import ra.springboot.Repository.IPersonRepsository;
import ra.springboot.Service.IPersonService;
import ra.springboot.Service.Mapper.PersonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepsository iPersonRepsository;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonResponse> findAll() {
        return iPersonRepsository.findAll().stream()
                .map(c -> personMapper.toResponse(c)).collect(Collectors.toList());

    }

    @Override
    public PersonResponse findById(Long id) {
        Optional<Person> person = iPersonRepsository.findById(id);
        if (person.isPresent()) {
            return personMapper.toResponse(person.get());
        }
        return null;
    }

    @Override
    public PersonResponse save(PersonRequest personRequest) throws PersonException {
        if (iPersonRepsository.existsByPhone(personRequest.getPhone())) {
            throw new PersonException("Phone is Exists");
        }
        if (iPersonRepsository.existsByEmail(personRequest.getEmail())) {
            throw new PersonException("Email is Exists");
        }
        Person person = iPersonRepsository.save(personMapper.toEntity(personRequest));
        return personMapper.toResponse(person);
    }

    @Override
    public PersonResponse update(PersonRequest personRequest, Long id) {
        Person p = personMapper.toEntity(personRequest);
        p.setId(id);
        return personMapper.toResponse(iPersonRepsository.save(p));
    }

    @Override
    public PersonResponse delete(Long id) {
        Optional<Person> p = iPersonRepsository.findById(id);
        if (p.isPresent()) {
            iPersonRepsository.deleteById(id);
            return personMapper.toResponse(p.get());
        }
        return null;
    }
}
