package com.company;

import com.company.models.Movie;
import com.company.services.impl.FindAbleImpl;
import com.company.services.impl.SortAbleImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        SortAbleImpl sortAble = new SortAbleImpl();
        FindAbleImpl findAble = new FindAbleImpl();
        commands();
        String a = button();
        if (a.equals("1")) {
            sortAble.printAllMovies();
        } else if (a.equals("2")) {
            System.out.print("Find a movie by full or part name: ");
            String movieName = in.nextLine();
            sortAble.findMovie(movieName);
        } else if (a.equals("3")) {
            System.out.print("Select sort order: ");
            int sortingMethod = in.nextInt();
            sortAble.sortByYear(sortingMethod);
        } else if (a.equals("4")) {
            System.out.print("Select sort order: ");
            int sortingMethod = in.nextInt();
            sortAble.sortByName(sortingMethod);
        } else if (a.equals("5")) {
            System.out.print("Select sort order: ");
            int sortingMethod = in.nextInt();
            sortAble.sortByDirector(sortingMethod);
        } else if (a.equals("6")) {
            System.out.print("Find a movie by actor name: ");
            String actorName = in.nextLine();
            findAble.findMoviesByActor(actorName);
        } else if (a.equals("7")) {
            System.out.print("Find a movie by director name: ");
            String directorName = in.nextLine();
            findAble.findMoviesByDirector(directorName);
        } else if (a.equals("8")) {
            System.out.print("Find a movie by year of production: ");
            int yearOfProduction = in.nextInt();
            findAble.findMoviesByYear(yearOfProduction);
        } else if (a.equals("9")) {
            System.out.print("Find a movie by actor name: ");
            String actorName1 = in.nextLine();
            findAble.findMoviesAndRoleByActor(actorName1);
        } else if (a.equals("10")) {
            findAble.showActorRoles();
        }
    }
    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }

    static String button(){
        System.out.print("Choose a command: ");
        return in.nextLine();
    }
}
