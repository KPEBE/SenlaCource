package hotel.collections;

import java.util.Comparator;
import java.util.List;
import hotel.models.Service;

public class ServicesCollection extends BaseCollection<Service, ServicesCollection> {
    @Override
    protected ServicesCollection New(List<Service> elements) { return new ServicesCollection(elements); }
    public ServicesCollection() { super(); }
    public ServicesCollection(List<Service> elements) { super(elements); }

    public ServicesCollection SortByPrice() { return this.Sort(Comparator.comparing(Service::GetPrice)); }
    public ServicesCollection SortByType() { return this.Sort(Comparator.comparing(Service::GetType)); }
}