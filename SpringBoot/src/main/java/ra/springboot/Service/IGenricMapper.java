package ra.springboot.Service;

import ra.springboot.Model.Domain.Person;
import ra.springboot.Model.Dto.Response.PersonResponse;

public interface IGenricMapper<T, K, V> {
    T toEntity(K k);

    V toResponse(T t);

}
