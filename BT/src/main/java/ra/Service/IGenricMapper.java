package ra.Service;

public interface IGenricMapper<T, K, V> {
    T toEntity(K k);

    V toResponse(T t);

}
