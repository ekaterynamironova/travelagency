package ua.nure.myronova.finalproject.web.command;

import ua.nure.myronova.finalproject.constants.Path;
import ua.nure.myronova.finalproject.db.dao.TourDAOImpl;
import ua.nure.myronova.finalproject.db.entity.Country;
import ua.nure.myronova.finalproject.db.entity.Tour;
import ua.nure.myronova.finalproject.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StartCommand extends Command {

    private static final long serialVersionUID = -5221913061023856722L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        List<Tour> tours = new TourDAOImpl().findAllUpcomingTours();
        Set<Country> countrySet = new HashSet<>();
        request.setAttribute("tours", tours);
        for (Tour tour : tours) {
            tour.getRoute().forEach((k,v) -> {
                System.out.println(v.getCity().getName());
                countrySet.add(v.getCity().getCountry());
            });
        }
        request.setAttribute("countries", countrySet);
        request.setAttribute("title", "ParadiseTravel");
        return Path.PAGE_HOME_PAGE;
    }
}
