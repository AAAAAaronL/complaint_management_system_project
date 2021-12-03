/*
package com.complaints.Dao;

import com.complaints.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    private static Map<Integer, User> user = null;
    static {
        user = new HashMap<Integer, User>();
        user.put(101, new User(12345,"Harris"));
        user.put(102, new User(12346,"Rose"));
        user.put(103, new User(12347,"Andrew"));
        user.put(104, new User(12348,"Loki"));
        user.put(105, new User(12349,"Leon"));
    }
    public Collection<User> getUsers(){
        return user.values();
    }
    public static User getUserById(Integer id){
        return user.get(id);
    }
}
*/
