package co.funzies.exceptions.UserExcp;

import co.funzies.exceptions.UserCrudExcp;

public class UserUpdateExcp extends UserCrudExcp{
    public UserUpdateExcp(String msg){
        super(msg);
    }
}
