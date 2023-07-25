
package service;

import dao.AccountDAO;
import entity.User;
import java.util.List;

public class AccountService implements MethodService<User> {

    @Override
    public List<User> getAll() {
        return new AccountDAO().getAll();
    }

    @Override
    public User getOne(int id) {
        return new AccountDAO().getOne(id);
    }

    @Override
    public boolean add(User object) {
        return new AccountDAO().add(object);
    }

    @Override
    public boolean update(User object, int id) {
        return new AccountDAO().update(object, id);
    }

    @Override
    public boolean remove(int id) {
        return new AccountDAO().remove(id);
    }

}
