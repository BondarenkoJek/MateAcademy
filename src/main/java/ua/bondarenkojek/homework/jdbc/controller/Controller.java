package ua.bondarenkojek.homework.jdbc.controller;

import ua.bondarenkojek.homework.jdbc.web.Request;
import ua.bondarenkojek.homework.jdbc.web.ViewModel;

public interface Controller {

    ViewModel process(Request request);
}
