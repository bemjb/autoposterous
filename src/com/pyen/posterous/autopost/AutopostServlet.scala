package com.pyen.posterous.autopost

import java.io.IOException
import javax.servlet.http._
import com.google.appengine.api.users.User
import com.google.appengine.api.users.UserService
import com.google.appengine.api.users.UserServiceFactory

class AutopostServlet extends HttpServlet {
    override def doGet(req: HttpServletRequest, res: HttpServletResponse) = {
        val userService = UserServiceFactory.getUserService()
        val user = userService.getCurrentUser()

        if (user != null) {
            res.setContentType("text/plain")
            res.getWriter().println("Hello " + user.getNickname())
        }
        else {
            res.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }
    }
}

// vim: set ts=4 sw=4 et:
