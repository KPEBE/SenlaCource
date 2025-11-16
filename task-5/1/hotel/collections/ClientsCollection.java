package hotel.collections;

import hotel.models.Client;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ClientsCollection extends BaseCollection<Client, ClientsCollection> {
    @Override
    protected ClientsCollection New(List<Client> elements) { return new ClientsCollection(elements); }
    public ClientsCollection() { super(); }
    public ClientsCollection(List<Client> elements) { super(elements); }

    public Client find(Integer id) { return this.find(c->Objects.equals(c.getID(), id)); }
    public Client findByFullname(String name) { return this.find(c->Objects.equals(c.getFullname(), name)); }

    public ClientsCollection sortByName() { return this.sort(Comparator.comparing(Client::getFullname)); }
    public ClientsCollection sortByEvictionDate() { return this.sort(Comparator.comparing(c->c.getRoom() == null ? LocalDate.MIN : c.getRoom().getEvictionDate())); }
}