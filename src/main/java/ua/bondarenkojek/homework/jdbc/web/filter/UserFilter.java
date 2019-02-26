package ua.bondarenkojek.homework.jdbc.web.filter;

import ua.bondarenkojek.homework.jdbc.config.Factory;
import ua.bondarenkojek.homework.jdbc.dao.UserDao;
import ua.bondarenkojek.homework.jdbc.model.Role;
import ua.bondarenkojek.homework.jdbc.model.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserFilter implements Filter {
    private UserDao userDao;
    private Map<String, Role> protectedUrl = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDao = Factory.getUserDao();
        protectedUrl.put("/administrator", new Role(2L,"Admin"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Cookie[] cookies = req.getCookies();
        String token = null;
        if (cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("MATE")) {
                    token = c.getValue();
                    break;
                }
            }
        }

        String path = req.getServletPath();

        if (token == null) {
            if (path.equals("/login") || path.equals("/registration")) {
                processAuthorized(req, resp, filterChain);
            } else {
                processUnauthorized(req, resp);
            }
        } else {
            User user = userDao.getByToken(token);

            if (user == null) {
                processUnauthorized(req, resp);
            } else {
                if (path.equals("/login") || path.equals("/registration")) {
                    req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
                }
                    if (verifyRole(user, path)) {
                        processAuthorized(req, resp, filterChain);
                    } else {
                        processDenied(req, resp);
                    }
            }
        }
    }

    private void processDenied(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        String redirectURL = "/WEB-INF/view/error.jsp";
        req.setAttribute("error", "HTTP Status 403");
        req.getRequestDispatcher(redirectURL).forward(req, resp);
    }

    private boolean verifyRole(User user, String path) {
        Role role = protectedUrl.get(path);
        return role == null ? true : user.getRoles().contains(role);
    }

    @Override
    public void destroy() {

    }

    private void processAuthorized(ServletRequest req,
                                   ServletResponse resp,
                                   FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    private void processUnauthorized(HttpServletRequest req,
                                     HttpServletResponse resp) throws ServletException, IOException {
//        String redirectURL = "/WEB-INF/view/login.jsp";
//        req.getRequestDispatcher(redirectURL).forward(req, resp);
        String path = req.getServletPath();
        String uri = "/login";
        if (!path.equals("/login")) {
            uri = String.format("/login?from=%s", path);
        }

        resp.sendRedirect(uri);
    }
}
