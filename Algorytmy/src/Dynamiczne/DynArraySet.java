//package structures;
//
//public class DynArraySet<T> {
//
//    private DynamicArray<T> set;
//
//    public DynArraySet() {
//        set = new DynamicArray<>();
//    }
//
//    public boolean insert(T element) {
//        if(!member(element)) {
//            set.add(element);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean delete(T element) {
//        for(int i = 0; i < size(); i++) {
//            if(set.get(i).equals(element)) {
//                set.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public T get(int index) {
//
//    }
//
//    public boolean remove(int index) {
//
//    }
//
//    public boolean member(T element) {
//
//    }
//
//    public DynArraySet<T> union(DynArraySet<T> set) {
//        DynArraySet<T> temp = new DynArraySet<>();
//        for(int i = 0; i < size(); i++) {
//            temp.insert(get(i));
//        }
//
//        for(int i = 0; i < set.size(); i++) {
//            temp.insert(set.get(i));
//        }
//
//        return temp;
//    }
//
//    public DynArraySet<T> intersection(DynArraySet<T> set) {
//        DynArraySet<T> temp = new DynArraySet<>();
//        for(int i = 0; i < size(); i++) {
//            if(set.member(get(i))) {
//                temp.insert(get(i));
//            }
//        }
//        return temp;
//    }
//
//    public DynArraySet<T> difference(DynArraySet<T> set) {
//
//    }
//
//    public int size() {
//        return set.size();
//    }
//
//    public boolean isEmpty() {
//        return set.isEmpty();
//    }
//}
