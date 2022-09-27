package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Cast;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.FindAble;
import com.company.services.SortAble;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindAbleImpl implements FindAble {

    private List<Movie> movieList = JsonIO.getMovies();

    @Override
    public void findMoviesByActor(String actorName) {
        List<List<Cast>> list = movieList.stream().map(x -> x.getCast()).toList();
        int n = 0;
        for (List<Cast> listElem: list) {
            if (listElem.stream().filter(x -> x.getFullName().contains(actorName)).anyMatch(x -> true)) {
                System.out.println(movieList.get(n).getName());
            };
            n++;
        }
    }

    @Override
    public void findMoviesByDirector(String directorName) {
        List<Director> list = movieList.stream().map(x -> x.getDirector()).toList();
        int n = 0;
        for (Director listElem: list) {
            if (listElem.getFullName().contains(directorName)) {
                System.out.println(movieList.get(n).getName());
            };
            n++;
        }
    }

    @Override
    public void findMoviesByYear(int year) {
        movieList.stream().filter(x -> x.getYear() == year).forEach(x -> System.out.println(x.getName() + ", " + x.getYear()));
    }

    @Override
    public void findMoviesAndRoleByActor(String actorName) {
        List<List<Cast>> list = movieList.stream().map(x -> x.getCast()).toList();
        int n = 0;
        for (List<Cast> listElem: list) {
            if (listElem.stream().filter(x -> x.getFullName().contains(actorName)).anyMatch(x -> true)) {
                System.out.print(movieList.get(n).getName() + ", ");
                listElem.stream().filter(x -> x.getFullName().contains(actorName)).forEach(x -> System.out.println(x.getRole()));
            };
            n++;
        }
    }

    @Override
    public void showActorRoles() {
        Set<Cast> set = movieList.stream().map(x -> x.getCast()).flatMap(x -> x.stream()).collect(Collectors.toSet());
        set.stream().sorted(compareByActorNameAsc).forEach(x -> System.out.println(x.getFullName() + ", " + x.getRole()));
    }

    public Comparator<Cast> compareByActorNameAsc = new Comparator<Cast>() {
        @Override
        public int compare(Cast o1, Cast o2) {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    };
}
