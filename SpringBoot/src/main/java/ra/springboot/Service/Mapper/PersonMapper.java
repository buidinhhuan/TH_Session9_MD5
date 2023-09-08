package ra.springboot.Service.Mapper;

import org.springframework.stereotype.Component;
import ra.springboot.Model.Domain.Person;
import ra.springboot.Model.Dto.Request.PersonRequest;
import ra.springboot.Model.Dto.Response.PersonResponse;
import ra.springboot.Service.IGenricMapper;

@Component
public class PersonMapper implements IGenricMapper<Person, PersonRequest, PersonResponse> {
    @Override
    public Person toEntity(PersonRequest personRequest) {
        return Person.builder()
                .name(personRequest.getName())
                .email(personRequest.getEmail())
                .phone(personRequest.getPhone())
                .sex(personRequest.isSex()).build();
    }

    @Override
    public PersonResponse toResponse(Person person) {
        return PersonResponse.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .sex(person.isSex()).build();
    }
}
