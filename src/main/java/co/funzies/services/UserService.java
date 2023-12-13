package co.funzies.services;

import co.funzies.dtos.UserDTO;
import co.funzies.exceptions.UserExcp.UserCreationExcp;
import co.funzies.exceptions.UserExcp.UserDeleteExcp;
import co.funzies.exceptions.UserExcp.UserSearchExcp;
import co.funzies.exceptions.UserExcp.UserUpdateExcp;
import co.funzies.models.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;

@RequestScoped
public class UserService {
    
    @Transactional
    public void createUser(UserDTO userDTO) throws UserCreationExcp{
        userDTO.toEntity().persist();
    }

    public User readUserById(Long userId) throws UserSearchExcp{
        return User.getUserById(userId);
    }

    public User readUserByUsername(String username) throws UserSearchExcp{
        return User.getUserByUsername(username);
    }

    @Transactional
    public void updateUser(UserDTO userDTO, Long userId) throws UserUpdateExcp{
        User.updateUser(userId, userDTO.getName());
    }

    @Transactional
    public void deleteUser(Long userId) throws UserDeleteExcp{
        User.deleteUser(userId);
    }

    
}
