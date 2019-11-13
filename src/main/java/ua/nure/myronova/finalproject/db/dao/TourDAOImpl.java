package ua.nure.myronova.finalproject.db.dao;

import ua.nure.myronova.finalproject.constants.Fields;
import ua.nure.myronova.finalproject.db.DBManager;
import ua.nure.myronova.finalproject.db.entity.*;
import ua.nure.myronova.finalproject.db.type.FoodType;
import ua.nure.myronova.finalproject.db.type.TourType;
import ua.nure.myronova.finalproject.exception.DAOException;
import ua.nure.myronova.finalproject.exception.DBException;
import ua.nure.myronova.finalproject.exception.Messages;

import java.sql.*;
import java.util.*;

public class TourDAOImpl implements TourDAO {

    private static final String SQL_FIND_ALL_UPCOMING_TOURS = "SELECT tours.*, routes.hotel_id, " +
            "routes.queue_hotel_number, hotels.*, services.*, cities.*, countries.* " +
            "FROM tours, routes, hotels, services, hotels_services, cities, countries " +
            "WHERE routes.tour_id = tours.id AND routes.hotel_id = hotels.id AND hotels_services.hotel_id = hotels.id " +
            "AND hotels_services.service_id = services.id AND hotels.city_id = cities.id " +
            "AND cities.country_id = countries.id AND tours.departure_date > ? AND tours.count_all > 0 " +
            "ORDER BY tours.last_minute DESC";

    private static final String SQL_CREATE_TOUR = "INSERT INTO `tours` VALUES (DEFAULT, )";

    private void extractTours(ResultSet rs, List<Tour> toursList) throws SQLException {
        Map<Long, Tour> tourMap = new LinkedHashMap<>();
        Map<Long, Hotel> hotelMap = new LinkedHashMap<>();
        Map<Long, City> cityMap = new LinkedHashMap<>();
        Map<Long, Country> countryMap = new LinkedHashMap<>();
        Map<Long, Service> serviceMap = new LinkedHashMap<>();

        while (rs.next()) {
            System.out.println("1 or more result in set");
            if (tourMap.containsKey(rs.getLong(Fields.TOUR_ID))) {
                Tour tour = tourMap.get(rs.getLong(Fields.TOUR_ID));
                Map<Integer, Hotel> route = tour.getRoute();
                extractHotel(rs, tour, hotelMap, serviceMap, cityMap, countryMap, route);
                tour.setRoute(route);
            } else {
                Tour tour = new Tour();
                tour.setId(rs.getLong(Fields.TOUR_ID));
                tour.setName(rs.getString(Fields.TOUR_NAME));
                System.out.println("tour " + tour.getName());
                if (tour.getName().equals("Amazing Europe")) {
                    System.out.println("---");
                }
                tour.setDescription(rs.getString(Fields.TOUR_DESCRIPTION));
                if (TourType.EXCURSION.getTypeName().equals(rs.getString(Fields.TOUR_TYPE))) {
                    tour.setType(TourType.EXCURSION);
                } else if (TourType.RECREATION.getTypeName().equals(rs.getString(Fields.TOUR_TYPE))) {
                    tour.setType(TourType.EXCURSION);
                } else {
                    tour.setType(TourType.SHOPPING);
                }
                if (FoodType.AI.name().equals(rs.getString(Fields.TOUR_FOOD_TYPE))) {
                    tour.setFoodType(FoodType.AI);
                } else if (FoodType.FB.name().equals(rs.getString(Fields.TOUR_FOOD_TYPE))) {
                    tour.setFoodType(FoodType.FB);
                } else if (FoodType.BB.name().equals(rs.getString(Fields.TOUR_FOOD_TYPE))) {
                    tour.setFoodType(FoodType.BB);
                } else if (FoodType.HB.name().equals(rs.getString(Fields.TOUR_FOOD_TYPE))) {
                    tour.setFoodType(FoodType.HB);
                } else {
                    tour.setFoodType(FoodType.OB);
                }
                tour.setCountPeople(rs.getInt(Fields.TOUR_COUNT_PEOPLE));
                tour.setDepartureDate(rs.getDate(Fields.TOUR_DEPARTURE_DATE));
                tour.setArrivalDate(rs.getDate(Fields.TOUR_ARRIVAL_DATE));
                tour.setLastMinute(rs.getBoolean(Fields.TOUR_LAST_MINUTE));
                tour.setPrice(rs.getDouble(Fields.TOUR_PRICE));
                tour.setImgPath(rs.getString(Fields.TOUR_IMG_PATH));
                tour.setCountAll(rs.getInt(Fields.TOUR_COUNT_ALL));
                Map<Integer, Hotel> route = new HashMap<>();
                extractHotel(rs, tour, hotelMap, serviceMap, cityMap, countryMap, route);
                tour.setRoute(route);
                tourMap.put(tour.getId(), tour);
                toursList.add(tour);
            }
        }
    }

    private void extractHotel(ResultSet rs, Tour tour, Map<Long, Hotel> hotelMap, Map<Long, Service> serviceMap,
                              Map<Long, City> cityMap, Map<Long, Country> countryMap,
                              Map<Integer, Hotel> route) throws SQLException {
            if (!hotelMap.containsKey(rs.getLong(Fields.HOTEL_ID))) {
                Hotel hotel = new Hotel();
                hotel.setId(rs.getLong(Fields.HOTEL_ID));
                hotel.setName(rs.getString(Fields.HOTEL_NAME));
                hotel.setCountStars(rs.getInt(Fields.HOTEL_COUNT_STARS));
                extractCity(rs, cityMap, countryMap, hotel);
                int queueHotelNumber = rs.getInt(Fields.ROUTE_QUEUE_HOTEL_NUMBER);
                extractService(rs, serviceMap, hotel);
                hotelMap.put(hotel.getId(), hotel);
                route.put(queueHotelNumber, hotel);
            } else {
                route.put(rs.getInt(Fields.ROUTE_QUEUE_HOTEL_NUMBER), hotelMap.get(rs.getLong(Fields.HOTEL_ID)));
            }
    }

    private void extractService(ResultSet rs, Map<Long, Service> serviceMap, Hotel hotel) throws SQLException {
        List<Service> services = new ArrayList<>();
        boolean first = true;

        while (rs.getLong(Fields.ROUTE_HOTEL_ID) == hotel.getId() && !rs.isLast()) {
            if (!first) {
                rs.next();
            } else {
                first = false;
            }
            if (!serviceMap.containsKey(rs.getLong(Fields.SERVICE_ID))) {
                Service service = new Service();
                service.setId(rs.getLong(Fields.SERVICE_ID));
                service.setName(rs.getString(Fields.SERVICE_NAME));
                serviceMap.put(service.getId(), service);
                services.add(service);
            } else {
                services.add(serviceMap.get(rs.getLong(Fields.SERVICE_ID)));
            }
        }
        hotel.setServices(services);
    }



    private void extractCity(ResultSet rs, Map<Long, City> cityMap, Map<Long, Country> countryMap, Hotel hotel) throws SQLException {
        if (!cityMap.containsKey(rs.getLong(Fields.HOTEL_CITY_ID))) {
            City city = new City();
            city.setId(rs.getLong(Fields.CITY_ID));
            city.setName(rs.getString(Fields.CITY_NAME));
            city.setCountry(extractCountry(rs, countryMap));
            cityMap.put(city.getId(), city);
            hotel.setCity(city);
        } else {
            hotel.setCity(cityMap.get(rs.getLong(Fields.HOTEL_CITY_ID)));
        }
    }

    private Country extractCountry(ResultSet rs, Map<Long, Country> countryMap) throws SQLException {
        Country country;
        if (!countryMap.containsKey(rs.getLong(Fields.CITY_COUNTRY_ID))) {
            country = new Country();
            country.setId(rs.getLong(Fields.COUNTRY_ID));
            country.setName(rs.getString(Fields.COUNTRY_NAME));

            countryMap.put(country.getId(), country);
        } else {
            country = countryMap.get(rs.getLong(Fields.CITY_COUNTRY_ID));
        }
        return country;
    }

    @Override
    public List<Tour> findAllUpcomingTours() throws DAOException {
        List<Tour> toursList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        DBManager dbManager = null;
        try {
            dbManager = DBManager.getInstance();
            System.out.println("dbmanager created");
            con = dbManager.getConnection();
            System.out.println("connection created " + con);
            stmt = con.prepareStatement(SQL_FIND_ALL_UPCOMING_TOURS);
            stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            System.out.println("statement created " + stmt);
            rs = stmt.executeQuery();
            extractTours(rs, toursList);
            System.out.println(toursList);

            con.commit();
        } catch (SQLException | DBException ex) {
            throw new DAOException(Messages.ERR_CANNOT_OBTAIN_UPCOMING_TOURS, ex);
        } finally {
            dbManager.close(con, stmt, rs);
        }
        return toursList;
    }

    @Override
    public List<Tour> findUpcomingToursByName(String name) throws DAOException {
        return null;
    }

    @Override
    public List<Tour> findAllSortedUpcomingTours(String criterion, boolean order) throws DAOException {
        return null;
    }

    @Override
    public boolean create(Tour entity) throws DAOException {
        return true;
    }

    @Override
    public Tour findEntityById(Long id) throws DAOException {
        return null;
    }

    @Override
    public List<Tour> findAllEntities() throws DAOException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return false;
    }

    @Override
    public boolean update(Tour entity) throws DAOException {
        return false;
    }
}
