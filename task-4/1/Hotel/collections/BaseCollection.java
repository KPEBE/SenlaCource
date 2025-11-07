package hotel.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import hotel.interfaces.IInspectable;

public abstract class BaseCollection<T extends IInspectable, C extends BaseCollection<T, C>> {
    protected final ArrayList<T> elements;

    protected Stream<T> GetStream() { return this.elements.stream(); }

    protected void Each(Consumer<? super T> a) { this.GetStream().forEach(a); }

    protected C Filter(Predicate<? super T> f) {
        List<T> list = this.GetStream().filter(f).collect(Collectors.toList());
        return New(list);
    }

    protected C Sort(Comparator<? super T> s) {
        List<T> list = this.GetStream().sorted(s).collect(Collectors.toList());
        return New(list);
    }

    public C Limit(int count) {
        List<T> list = this.GetStream().limit(count).collect(Collectors.toList());
        return New(list);
    }

    protected abstract C New(List<T> elements);
    public BaseCollection(List<T> elements) { this.elements = new ArrayList<T>(elements); }
    public BaseCollection() { this.elements = new ArrayList<T>(); }

    public ArrayList<T> Get() { return this.elements; }
    public void Show() { this.Each(e->e.Inspect()); }
}