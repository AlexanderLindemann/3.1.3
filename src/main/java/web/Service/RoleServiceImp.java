package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.RoleDAO;
import web.models.Role;

import java.util.List;

@Service
@Transactional

public class RoleServiceImp implements RoleService {

    private final RoleDAO roleDao;

    @Autowired
    public RoleServiceImp(RoleDAO roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRole(String name) {
        return roleDao.findByRoleName(name);
    }

    @Override
    public List<Role> allEntity() {
        return null;
    }

    @Override
    public boolean addEntity(Role role) {
        return false;
    }

    @Override
    public boolean updateEntity(Role role) {
        return false;
    }

    @Override
    public void deleteEntity(Long id) {

    }

    @Override
    public Role getEntityById(Long id) {
        return null;
    }

    @Override
    public Role getEntityByName(String name) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
