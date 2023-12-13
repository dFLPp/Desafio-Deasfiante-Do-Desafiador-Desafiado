package co.funzies.exceptions.UserExcp;

import co.funzies.exceptions.UserCrudExcp;

public class UserCreationExcp extends UserCrudExcp{
    public UserCreationExcp(String msg){
        super(msg);
    }
}
