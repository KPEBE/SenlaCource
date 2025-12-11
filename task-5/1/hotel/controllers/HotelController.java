package hotel.controllers;

import hotel.lib.AutoDI;
import hotel.views.HotelView;

public class HotelController {
    @AutoDI
    private HotelView view;

    public void show() { view.show(); }
}