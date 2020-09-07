package web.Service;

import org.springframework.stereotype.Service;
import web.models.Role;


public interface RoleService extends ServiceDTO<Role>{
    Role getRole(String name);
}
