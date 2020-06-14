package DataProviders;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

public class UserDao {


    public User findTheUser(HttpServlet httpServlet, String email, String password, UserRoles role){

        HashMap<Long,User> userlist = (HashMap<Long, User>) httpServlet.getServletContext().getAttribute("users");
        if(userlist == null){
            return null;
        }else{
            User user = (User) userlist.get(email.trim());
            if(user != null){
                if(user.getRole() == role && user.checkPassword(password.trim())){
                    return user;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }
    }
}
