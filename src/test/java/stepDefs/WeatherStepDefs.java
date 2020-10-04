package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {

    private String city;
    private String country;
    private Response response;

    @Given("city is: {string}")
    public void set_city(String city) {
        this.city = city;
    }

    @Given("country is: {string}")
    public void set_country(String country){
        this.country = country.toLowerCase();
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(city, country);
       // System.out.println(requester.requestWeather(city, country).getCoord().getLat());
    }

    @Then("lon is: {double}")
    public void check_lon(Double lon){
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon value");
    }

    @Then("lat is: {double}")
    public void check_lat(Double lat){
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat value");

    }

    @Then("id is: {int}")
    public void check_id(int id){
       // Assertions.assertEquals(id, response.getCoord().getId(), "Wrong id value");
    }

    @Then("main is: {string}")
    public void check_main(String main){

    }

    @Then("description is: {string}")
    public void check_description(String description){

    }

    @Then("icon is: {string}")
    public void check_icon(String icon){

    }

    @Then("base is: {string}")
    public void check_base(String base){

    }

    @Then("temp is: {double}")
    public void check_temp(Double temp){
    }

    @Then("pressure is: {int}")
    public void check_pressure(int pressure){

    }

    @Then("humidity is: {int}")
    public void check_humidity(int humidity){

    }

    @Then("minimalTemp is: {double}")
    public void check_temp_min(Double minimalTemp) {

    }

    @Then("maximalTemp is: {double}")
    public void check_temp_max(Double maximalTemp){
    }

    @Then("visibility is: {int}")
    public void check_visibility(int visibility){

    }

    @Then("speed is: {double}")
    public void check_speed(Double speed){
    }

    @Then("deg is: {int}")
    public void check_deg(int deg){

    }

    @Then("all is: {int}")
    public void check_all(int all){

    }

    @Then("dt is: {int}")
    public void check_dt(int dt){

    }

    @Then("type is: {int}")
    public void check_type(int type){

    }


    @Then("message is: {double}")
    public void check_message(Double message){

    }

    @Then("sunrise is: {int}")
    public void check_sunrise(int sunrise){

    }

    @Then("sunset is: {int}")
    public void check_sunset(int sunset){

    }

    @Then("name is: {string}")
    public void check_name(String name){

    }

    @Then("cod is: {int}")
    public void check_cod(int cod){

    }






}
