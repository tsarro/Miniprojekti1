package fi.academy.json.esimerkki;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Comparator;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Asematieto {

    private String stationName;
    private String stationShortCode;
    private boolean passengerTraffic;
    private String type;
    private int stationUICCode;
    private String countryCode;
    private double longitude;
    private double latitude;

    public String perustietoja() {
        return "Asemakaupunki: " + stationName + ", " + stationShortCode + ", Onko matkustusliikennettä: " +
                passengerTraffic;
    }

    public String getStationName() { return stationName; }
    public String getStationShortCode() {return stationShortCode;}

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setStationShortCode(String stationShortCode) {
        this.stationShortCode = stationShortCode;
    }

    public boolean isPassengerTraffic() {
        return passengerTraffic;
    }

    public void setPassengerTraffic(boolean passengerTraffic) {
        this.passengerTraffic = passengerTraffic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStationUICCode() {
        return stationUICCode;
    }

    public void setStationUICCode(int stationUICCode) {
        this.stationUICCode = stationUICCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}

/*Tämä luokka tehtiin aakkosjärjestystä varten, ei enää välttämättä tarpeellinen:
class AsemaVertailija implements Comparator<Asematieto> {
    @Override
    public int compare (Asematieto asematieto1, Asematieto asematieto2) {
        if(asematieto1.isPassengerTraffic()!=asematieto2.isPassengerTraffic())
            return asematieto1.isPassengerTraffic() ?  -1 : 1;
        return asematieto1.getStationName().compareTo(asematieto2.getStationName());
    }
}*/

