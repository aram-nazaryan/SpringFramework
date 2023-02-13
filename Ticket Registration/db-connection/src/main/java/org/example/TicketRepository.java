package org.example;

public interface TicketRepository<T> {
    String save(T item);

    int countByActiveIsTrue();

    void consume(String itemID);
}
