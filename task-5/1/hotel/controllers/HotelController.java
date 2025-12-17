package hotel.controllers;

import hotel.config.AutoDI;
import hotel.views.HotelView;

public class HotelController {
    @AutoDI
    private HotelView view;

    public void show() { view.show(); }
}