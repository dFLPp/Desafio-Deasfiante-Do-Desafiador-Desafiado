package co.funzies.exceptions.UserExcp;

import co.funzies.exceptions.UserCrudExcp;

public class UserDeleteExcp extends UserCrudExcp{
    public UserDeleteExcp(String msg){
        super(msg);
    }
}
