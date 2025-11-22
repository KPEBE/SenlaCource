package hotel.collections;

import hotel.interfaces.IInspectable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseCollection<T extends IInspectable, C extends BaseCollection<T, C>> implements Serializable {
    protected final ArrayList<T> elements;

    protected Stream<T> getStream() { return this.elements.stream(); }

    public void each(Consumer<? super T> a) { this.getStream().forEach(a); }

    protected C filter(Predicate<? super T> f) {
        List<T> list = this.getStream().filter(f).collect(Collectors.toList());
        return New(list);
    }

    protected T find(Predicate<? super T> f) {
        T found;
        try { found = this.getStream().filter(f).findFirst().get(); }
        catch (Exception e) { found = null; }
        return found;
    }

    protected C sort(Comparator<? super T> s) {
        List<T> list = this.getStream().sorted(s).collect(Collectors.toList());
        return New(list);
    }

    public C limit(int count) {
        List<T> list = this.getStream().limit(count).collect(Collectors.toList());
        return New(list);
    }

    protected abstract C New(List<T> elements);
    public BaseCollection(List<T> elements) { this.elements = new ArrayList(elements); }
    public BaseCollection() { this.elements = new ArrayList(); }

    public ArrayList<T> get() { return this.elements; }
    public void show() { this.each(e->e.inspect()); }
}