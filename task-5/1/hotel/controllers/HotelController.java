package hotel.controllers;

import hotel.views.HotelView;

public class HotelController {
    private final HotelView view = new HotelView();

    public void show() { view.show(); }
}