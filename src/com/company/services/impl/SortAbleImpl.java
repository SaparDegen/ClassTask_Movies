package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.Comparator;
import java.util.List;

public class SortAbleImpl implements SortAble {

    private List<Movie> movieList = JsonIO.getMovies();

    @Override
    public void printAllMovies() {
        movieList.stream().forEach(x -> System.out.println(x));
    }

    @Override
    public void findMovie(String movieName) {
        movieList.stream().filter(x -> x.getName().contains(movieName)).forEach(x -> System.out.println(x.getName() + ", " + x.getYear()));
    }

    @Override
    public void sortByYear(int sortMethod) {
        if (sortMethod == 1) {
            movieList.stream().sorted(compareByYearAsc).forEach(x -> System.out.println(x.getName() + ", " + x.getYear()));
        } else {
            movieList.stream().sorted(compareByYearDesc).forEach(x -> System.out.println(x.getName() + ", " + x.getYear()));
        }
    }

    @Override
    public void sortByName(int sortMethod) {
        if (sortMethod == 1) {
            movieList.stream().sorted(compareByNameAsc).forEach(x -> System.out.println(x.getName() + ", " + x.getYear()));
        } else {
            movieList.stream().sorted(compareByNameDesc).forEach(x -> System.out.println(x.getName() + ", " + x.getYear()));
        }
    }

    @Override
    public void sortByDirector(int sortMethod) {
        List<Movie> list;
        if (sortMethod == 1) {
            list = movieList.stream().sorted(compareByDirectorNameAsc).toList();
        } else {
            list = movieList.stream().sorted(compareByDirectorNameDesc).toList();
        }
        List<Director> list1 = list.stream().map(x -> x.getDirector()).toList();
        for (Director elem: list1) {
            System.out.println(elem.getFullName() + ", " + list.get(list1.indexOf(elem)).getName());
        }
    }

    public static Comparator<Movie> compareByYearDesc = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.getYear() - o1.getYear();
        }
    };

    public static Comparator<Movie> compareByYearAsc = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getYear() - o2.getYear();
        }
    };

    public static Comparator<Movie> compareByNameDesc = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    public static Comparator<Movie> compareByNameAsc = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public Comparator<Movie> compareByDirectorNameAsc = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
        }
    };

    public Comparator<Movie> compareByDirectorNameDesc = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.getDirector().getFullName().compareTo(o1.getDirector().getFullName());
        }
    };
}
