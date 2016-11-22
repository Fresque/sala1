package a2.t1mo.mobjav.a816.myapplication.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by polialva on 26/10/16.
 */
public class Pelicula implements Serializable{

    private String poster_path;
    private boolean adult;
    private String overview;
    private String release_date;
    private List<Integer> genere_ids;
    private String id;
    private String original_title;
    private String original_language;
    private String title;
    private String backdrop_path;
    private float popularity;
    private int vote_count;
    private boolean video;
    private float vote_average;

    private int budget;
    private String homepage;
    private String imdb_id;
    private int revenue;
    private int runtime;
    private belongs_to_collection belongs_to_collection;
    private List<genres> genres;
    private List<production_companies> production_companies;
    private contenedorDeVideos videos;
    private contenedorDeReviews reviews;
    private contenedorDeCreditos credits;


    //Clases para las variables complejas
    private class belongs_to_collection{
        int id;
        String name;
        String poster_path;
        String backdrop_path;
    }

    private class genres{
        int id;
        String name;
    }

    private class production_companies{
        String name;
        int id;
    }

    private class contenedorDeVideos {
        List<videos> results ;

        public List<Pelicula.videos> getResults() {
            return results;
        }
    }

    private class videos{
        String key;
        String name;
        String type;

        public String getKey() {
            return key;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }

    public List<videos> getVideos(){
        return videos.getResults();
    }

    public String getKey(int position){
        return videos.getResults().get(position).getKey();
    }

    public  String getVideoName(int position){
        return videos.getResults().get(position).getName();
    }

    public String getType(int position){
        return videos.getResults().get(position).getType();
    }


    private class contenedorDeReviews{
        List<reviews> results;

        public List<Pelicula.reviews> getResults() {
            return results;
        }


    }

    private class reviews{
        String id;
        String author;
        String content;

        public String getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }
    }

    public String getId(int position){
        return reviews.getResults().get(position).getId();
    }

    public String getAuthor(int position){
        return reviews.getResults().get(position).getAuthor();
    }

    public String getContent(int position){
        return reviews.getResults().get(position).getContent();
    }


    private class contenedorDeCreditos{
        List<credits> cast;

        public List<Pelicula.credits> getResults() {
            return cast;
        }
    }

    private class credits{
        String character;
        String name;
        String profile_path;

        public String getProfile_path() {
            return profile_path;
        }

        public String getName() {
            return name;
        }

        public String getCharacter() {
            return character;
        }
    }

    public String getCharacter(int position){
        return credits.getResults().get(position).getCharacter();
    }

    public String getCreditsName(int position){
        return credits.getResults().get(position).getName();
    }

    public String getProfilePath(int position){
        return credits.getResults().get(position).getProfile_path();
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Integer> getGenere_ids() {
        return genere_ids;
    }

    public void setGenere_ids(List<Integer> genere_ids) {
        this.genere_ids = genere_ids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

}