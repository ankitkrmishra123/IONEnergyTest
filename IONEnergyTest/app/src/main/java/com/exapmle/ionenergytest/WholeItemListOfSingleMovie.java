package com.exapmle.ionenergytest;

class WholeItemListOfSingleMovie {

    private String movieUrl;
    private String movieName;
    private String movieRating;
    private String movieVoteCount;
    private String releaseDate;
    private Boolean adult;
    private String overview;
    private Double popularity;
    private String mediaType;

    public WholeItemListOfSingleMovie(String movieUrl, String movieName, String movieRating, String movieVoteCount, String releaseDate, Boolean adult, String overview, Double popularity, String mediaType) {
        this.movieUrl = movieUrl;
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieVoteCount = movieVoteCount;
        this.releaseDate = releaseDate;
        this.adult = adult;
        this.overview = overview;
        this.popularity = popularity;
        this.mediaType = mediaType;

    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getMovieVoteCount() {
        return movieVoteCount;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getMediaType() {
        return mediaType;
    }
}
