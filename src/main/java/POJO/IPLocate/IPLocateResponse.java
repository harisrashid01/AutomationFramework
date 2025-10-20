package POJO.IPLocate;

public class IPLocateResponse {

    private String ip;
    private String country;
    private String country_code;
    private Boolean is_eu;
    private String city;
    private String continent;
    private Double latitude;
    private Double longitude;
    private String time_zone;
    private String postal_code;
    private String subdivision;
    private String subdivision2;
    private String currency_code;
    private String calling_code;
    private String network;
    private Asn asn;
    private Privacy privacy;
    private Hosting hosting;
    private Company company;
    private Abuse abuse;

    public String getIp() {
        return ip;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public Boolean getIs_eu() {
        return is_eu;
    }

    public String getCity() {
        return city;
    }

    public String getContinent() {
        return continent;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public String getSubdivision2() {
        return subdivision2;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public String getCalling_code() {
        return calling_code;
    }

    public String getNetwork() {
        return network;
    }

    public Asn getAsn() {
        return asn;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public Hosting getHosting() {
        return hosting;
    }

    public Company getCompany() {
        return company;
    }

    public Abuse getAbuse() {
        return abuse;
    }
}