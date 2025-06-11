package software.ulpgc.moneycalculator.app.fixerApi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.architecture.IO.ExchangeRateLoader;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    private Currency from;
    private Currency to;

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        this.from = from;
        this.to = to;
        try {
            return toExchangeRate(fromJSON());
        } catch (IOException e){
            return null;
        }
    }

    private ExchangeRate toExchangeRate(String json) {
        System.out.println(json);

        Map<String, JsonElement> rates = new Gson().fromJson(json, JsonObject.class)
                .get("rates")
                .getAsJsonObject()
                .asMap();

        double rate= rates.get(to.code()).getAsDouble()/rates.get(from.code()).getAsDouble();
        System.out.println(rate);

        return new ExchangeRate(from, to, rate, LocalDate.now());
    }

    private String fromJSON() throws IOException{
        URL url = new URL("http://data.fixer.io/api/latest?access_key=" + FixerApi.apikey
                            + "&base=EUR" + "&symbols=" + from.code()+","+to.code());
        try(InputStream is = url.openStream()){
            return new String(is.readAllBytes());
        }
    }
}
