package juno.springboot.junopetclinic.Services.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractMapService<T,ID> {

    protected Map<ID,T> map = new HashMap<>();

    T save(ID id,T object){
        map.put(id,object);
        return object;
    }

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    void delete(T object){
        map.entrySet().removeIf(Entry -> Entry.equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

}
