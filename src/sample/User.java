package sample;

public class User {

    private String voornaam;
    private String achternaam;
    private Integer nummer;

    private double sjoelbak;
    private double tonspel;
    private double toptafel;
    private double rolbiljart;
    private double mannetjesspel;


    User(String voornaam, String achternaam, Integer nummer, double sjoelbak, double tonspel, double toptafel, double rolbiljart, double mannetjesspel){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.nummer = nummer;

        this.sjoelbak = sjoelbak;
        this.tonspel = tonspel;
        this.toptafel = toptafel;
        this.rolbiljart = rolbiljart;
        this.mannetjesspel = mannetjesspel;
    }

    public String getInsertStatementSql(){

        Double totaal = this.sjoelbak + this.tonspel + this.toptafel + this.rolbiljart + this.mannetjesspel;

        String sql  = "insert into scores "
                + "(voornaam, achternaam, nummer, sjoelbak, tonspel, toptafel, rolbiljart, mannetjesspel, totaal)"
                + "values ('" + this.voornaam + "', '"+ this.achternaam +"', "+ this.nummer + ", "+ this.sjoelbak +", "+ this.tonspel +", "+ this.toptafel +", " + this.rolbiljart + ", "+ this.mannetjesspel +", "+totaal+")";

        return sql;
    }

}
