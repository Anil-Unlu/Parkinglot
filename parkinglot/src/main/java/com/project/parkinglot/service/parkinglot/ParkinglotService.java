package com.project.parkinglot.service.parkinglot;

public interface ParkinglotService {
    Parkinglot create(Parkinglot parkinglot);
    Parkinglot getParkinglot(long id);
    Parkinglot updateParkinglot( Parkinglot parkinglot, long id);
    void removeParkinglot(long id);
}
