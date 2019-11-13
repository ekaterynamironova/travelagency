package ua.nure.myronova.finalproject.db.dao;

import ua.nure.myronova.finalproject.db.entity.Tour;
import ua.nure.myronova.finalproject.exception.DAOException;

import java.util.Date;
import java.util.List;

public interface TourDAO extends GenericDAO<Tour> {

    List<Tour> findAllUpcomingTours() throws DAOException;

    List<Tour> findUpcomingToursByName(String name) throws DAOException;

    List<Tour> findAllSortedUpcomingTours (String criterion, boolean order) throws DAOException;



}
