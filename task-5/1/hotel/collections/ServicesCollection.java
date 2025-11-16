package hotel.collections;

import hotel.models.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ServicesCollection extends BaseCollection<Service, ServicesCollection> {
    @Override
    protected ServicesCollection New(List<Service> elements) { return new ServicesCollection(elements); }
    public ServicesCollection() { super(); }
    public ServicesCollection(List<Service> elements) { super(elements); }

    public Service find(Integer id) { return this.find(s->Objects.equals(s.getID(), id)); }
    public Service findByTitle(String title) { return this.find(s->Objects.equals(s.getTitle(), title)); }

    public ServicesCollection sortByPrice() { return this.sort(Comparator.comparing(Service::getPrice)); }
    public ServicesCollection sortByType() { return this.sort(Comparator.comparing(Service::getType)); }
}