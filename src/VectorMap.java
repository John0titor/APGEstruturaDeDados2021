import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VectorMap implements Map<Integer, Estudante> {

    private static class VectorMapEntry implements Map.Entry<Integer, Estudante> {
        private Integer matricula;
        private Estudante estudante;

        public VectorMapEntry(Integer k, Estudante s) {
            matricula = k;
            estudante = s;
        }

        public Integer getKey() {
            return matricula;
        }

        public Estudante getEstudante() {
            return estudante;
        }

        public void setEstudante(Estudante s) {
            estudante = s;
        }

        @Override
        public Estudante getValue() {
            return estudante;
        }

        @Override
        public Estudante setValue(Estudante value) {
            estudante = value;
            return value;
        }
    }

    private int nElements;
    private VectorMapEntry[] entries;

    public VectorMap(int initialSize) {
        if (initialSize <= 0) {
            throw new IllegalArgumentException("Initial size must be positive.");
        }
        entries = new VectorMapEntry[initialSize];
    }

    @Override
    public int size() {
        return nElements;
    }

    @Override
    public boolean isEmpty() {
        return nElements == 0;
    }

    @Override
    public boolean containsKey(Object Integer) {
        boolean found = false;
        for (VectorMapEntry entry : entries) {
            if (entry == null) {
                break;
            }
            found = entry.getKey().equals(Integer);
            if (found) {
                break;
            }
        }
        return found;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean found = false;
        for (VectorMapEntry entry : entries) {
            if (entry == null) {
                break;
            }
            found = entry.getEstudante().equals(value);
            if (found) {
                break;
            }
        }
        return found;
    }

    @Override
    public Estudante get(Object Integer) {
        for (VectorMapEntry entry : entries) {
            if (entry == null) {
                break;
            }
            if (entry.getKey().equals(Integer)) {
                return entry.getEstudante();
            }
        }
        return null;
    }

    @Override
    public Estudante put(Integer Integer, Estudante value) {
        if (Integer == null) {
            throw new IllegalArgumentException("Null Integer.");
        }
        boolean found = false;
        for (VectorMapEntry entry : entries) {
            if (entry == null) {
                break;
            }
            if (entry.getKey().equals(Integer)) {
                entry.setEstudante(value);
                found = true;
                break;
            }
        }
        if (!found) {
            if (nElements == entries.length) {
                throw new RuntimeException("Map is full.");
            }
            entries[nElements] = new VectorMapEntry(Integer, value);
            nElements++;
        }
        return value;
    }

    @Override
    public Estudante remove(Object Integer) {
        int index = 0;
        Estudante s = null;
        for (VectorMapEntry entry : entries) {
            if (entry == null) {
                break;
            }
            if (entry.getKey().equals(Integer)) {
                s = entry.getEstudante();
                break;
            }
            index++;
        }
        if (index < nElements) {
            for (int i = index; i < nElements - 1; i++) {
                entries[i] = entries[i + 1];
            }
            nElements--;
        }
        return s;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Estudante> m) {
        if (m != null) {
            m.entrySet()
             .stream()
             .forEach(ent -> put(ent.getKey(), ent.getValue()));
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < nElements; i++) {
            entries[i] = null;
        }
        nElements = 0;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> IntegerSet = new HashSet<>();
        for (int i = 0; i < nElements; i++) {
            IntegerSet.add(entries[i].getKey());
        }
        return IntegerSet;
    }

    @Override
    public Collection<Estudante> values() {
        Collection<Estudante> vals = new ArrayList<>(nElements);
        for (int i = 0; i < nElements; i++) {
            vals.add(entries[i].getEstudante());
        }
        return vals;
    }

    @Override
    public Set<Map.Entry<Integer, Estudante>> entrySet() {
        Set<Map.Entry<Integer, Estudante>> entSet = new HashSet<>();
        for (int i = 0; i < nElements; i++) {
            entSet.add(entries[i]);
        }
        return entSet;
    }


}
