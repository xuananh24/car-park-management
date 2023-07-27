package com.example.car_park_management.common.constant;

public class PathConstant {
    public static final String API_BASE_URL = "/api";
    public static final String API_EMPLOYEE_BASE_URL = API_BASE_URL + "/employee";
    public static final String API_BOOKING_OFFICE_BASE_URL = API_BASE_URL + "/booking-office";
    public static final String API_CAR_BASE_URL = API_BASE_URL + "/car";
    public static final String API_PARKING_LOT_BASE_URL = API_BASE_URL + "/parking-lot";
    public static final String API_TICKET_BASE_URL = API_BASE_URL + "/ticket";
    public static final String API_TRIP_BASE_URL = API_BASE_URL + "/trip";

    public static final String API_EMPLOYEE_CREATION_URL = API_EMPLOYEE_BASE_URL + "";
    public static final String API_EMPLOYEE_SHOW_URL = API_EMPLOYEE_BASE_URL + "/{page}/{pageSize}";

    public static final String API_BOOKING_OFFICE_CREATION_URL = API_BOOKING_OFFICE_BASE_URL + "";
    public static final String API_BOOKING_OFFICE_SHOW_URL = API_BOOKING_OFFICE_BASE_URL + "/{page}/{pageSize}";

    public static final String API_CAR_CREATION_URL = API_CAR_BASE_URL + "";
    public static final String API_CAR_SHOW_URL = API_CAR_BASE_URL + "/{page}/{pageSize}";

    public static final String API_PARKING_LOT_CREATION_URL = API_PARKING_LOT_BASE_URL + "";
    public static final String API_PARKING_LOT_SHOW_URL = API_PARKING_LOT_BASE_URL + "/{page}/{pageSize}";

    public static final String API_TICKET_CREATION_URL = API_TICKET_BASE_URL + "";
    public static final String API_TICKET_SHOW_URL = API_TICKET_BASE_URL + "/{page}/{pageSize}";
    public static final String API_TICKET_DELETE_URL = API_TICKET_BASE_URL + "/{ticketId}";

    public static final String API_TRIP_CREATION_URL = API_TRIP_BASE_URL + "";
    public static final String API_TRIP_SHOW_URL = API_TRIP_BASE_URL + "/{page}/{pageSize}";
}
