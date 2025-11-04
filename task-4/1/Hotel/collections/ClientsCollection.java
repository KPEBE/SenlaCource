package hotel.collections;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import hotel.models.Client;

public class ClientsCollection extends BaseCollection<Client, ClientsCollection> {
    @Override
    protected ClientsCollection New(List<Client> elements) { return new ClientsCollection(elements); }
    public ClientsCollection() { super(); }
    public ClientsCollection(List<Client> elements) { super(elements); }

    public ClientsCollection SortByName() { return this.Sort(Comparator.comparing(Client::GetFullname)); }
    public ClientsCollection SortByEvictionDate() { return this.Sort(Comparator.comparing(c->c.GetRoom() == null ? LocalDate.MIN : c.GetRoom().GetEvictionDate())); }
}