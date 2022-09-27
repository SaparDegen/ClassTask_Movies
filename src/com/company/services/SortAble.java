package com.company.services;

import com.company.models.Director;

public interface SortAble {

    void printAllMovies();

    void findMovie(String movieName);

    void sortByYear(int sortMethod);

    void sortByName(int sortMethod);

    void sortByDirector(int sortMethod);
}
