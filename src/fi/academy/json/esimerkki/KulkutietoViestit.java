package fi.academy.json.esimerkki;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class KulkutietoViestit {

    // Tällä metodilla voit hakea tietyn junan (huom: junaNumero String-muodossa) sijainnin edellisen ja seuraavan aseman perusteella.
    // Tieto perustuu kulkutietoviesteihin, datan laatu ei aina ole optimaalista joten asemia voi välillä puuttua.
    //-Paula-

    public static void haeAsema(String junaNumero) {
        List<KulkutietoJuna> junat = lueJunanJSONData();
        boolean loytyiko = false;
        for (int i = 0; i < junat.size(); i++) {
            if (junat.get(i).getTrainNumber().equals(junaNumero)) {
                KulkutietoJuna haettava = junat.get(i);

                String edellinenAsema= haettava.getNextStation();
                if(haettava.getNextStation()==null){
                    edellinenAsema=("Asemaa ei valitettavasti löydy.");
                } else {
                    edellinenAsema=Asemat.palautaKaupunki(edellinenAsema);
                }
                String seuraavaAsema= haettava.getPreviousStation();
                if(haettava.getPreviousStation()==null){
                    seuraavaAsema=("Asemaa ei valitettavasti löydy.");
                } else {
                    seuraavaAsema=Asemat.palautaKaupunki(seuraavaAsema);
                }
                System.out.println("Juna "+ junaNumero + ":\n");
                System.out.println("Edellinen asema: " + edellinenAsema);
                System.out.println("Seuraava asema: " + seuraavaAsema);

                loytyiko=true;
                break;
            }
        }
        if(!loytyiko){
            System.out.println("Tietoja hakemastasi junasta ei ole saatavilla.");
        }
    }

    private static List<KulkutietoJuna> lueJunanJSONData () {

        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(baseurl + "/train-tracking/");
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, KulkutietoJuna.class);
            List<KulkutietoJuna> junat = mapper.readValue(url, tarkempiListanTyyppi);
            return junat;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}