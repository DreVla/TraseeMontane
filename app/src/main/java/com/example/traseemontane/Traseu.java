package com.example.traseemontane;

public class Traseu {

    private String title, details, marcaj, diff, dist, time, urcare, peak;

    public Traseu(String title, String details, String marcaj, String diff, String dist, String time, String urcare, String peak) {
        this.title = title;
        this.details = details;
        this.marcaj = marcaj;
        this.diff = diff;
        this.dist = dist;
        this.time = time;
        this.urcare = urcare;
        this.peak = peak;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMarcaj() {
        return marcaj;
    }

    public void setMarcaj(String marcaj) {
        this.marcaj = marcaj;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrcare() {
        return urcare;
    }

    public void setUrcare(String urcare) {
        this.urcare = urcare;
    }

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }
}
