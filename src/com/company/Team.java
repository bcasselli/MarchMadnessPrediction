package com.company;

/**
 * Created by bc608 on 3/1/17.
 */
public class Team {

    public String name;
    public int seed, RPI_rank;
    public double points_scored, points_against, wins, losses, RPI;

    public Team(String a, int d, double rpi, int rpi_rank, int w, int l, double ps, double pa){
        name = a;
        seed = d;
        RPI = rpi;
        RPI_rank = rpi_rank;
        wins = w;
        losses = l;
        points_scored = ps;
        points_against = pa;

    }

    public Team Game(Team A, Team B, int round)
    {
        double avg_points_total = 70;
        double a_points_total = A.points_scored + A.points_against;
        double a_adj_points_scored = (avg_points_total / a_points_total) * A.points_scored;
        double a_adj_points_against = (avg_points_total / a_points_total) * A.points_against;
        double a_pythag = Math.pow(a_adj_points_scored, 11.5) / (Math.pow(a_adj_points_scored, 11.5) + Math.pow(a_adj_points_against, 11.5));

        double a_score = a_pythag + A.RPI;

        double b_points_total = B.points_scored + B.points_against;
        double b_adj_points_scored = (avg_points_total / b_points_total) * B.points_scored;
        double b_adj_points_against = (avg_points_total / b_points_total) * B.points_against;

        double b_pythag = Math.pow(b_adj_points_scored, 11.5) / (Math.pow(b_adj_points_scored, 11.5) + Math.pow(b_adj_points_against, 11.5));

        double b_score = b_pythag + B.RPI;

        return a_score >= b_score ? A:B;
    }
}
