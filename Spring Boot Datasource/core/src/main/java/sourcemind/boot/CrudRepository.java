package sourcemind.boot;

public interface CrudRepository<T, ID> {
    void save(T user);
}
