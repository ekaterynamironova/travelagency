package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public abstract class Command implements Serializable {

    private static final long serialVersionUID = 153927036339489067L;

    public abstract String execute(HttpServletRequest request,
                                   HttpServletResponse response) throws IOException, ServletException, AppException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}
