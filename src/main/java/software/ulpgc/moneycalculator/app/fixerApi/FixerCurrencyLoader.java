package software.ulpgc.moneycalculator.app.fixerApi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.persistence.CurrencyLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FixerCurrencyLoader implements CurrencyLoader {
    @Override
    public List<Currency> load() {
        try {
            return toList(loadJson());
        }catch (IOException e){
            return Collections.emptyList();
        }
    }

    private List<Currency> toList(String json){
        List<Currency> list = new ArrayList<>();
        Map<String, JsonElement> symbols = new Gson()
                .fromJson(json, JsonObject.class)
                .get("symbols")
                .getAsJsonObject()
                .asMap();

        for (String symbol : symbols.keySet()){
            list.add(new Currency(symbol, symbols.get(symbol).getAsString()));
        }

        return list;
    }

    private String loadJson() throws IOException{
        URL url = new URL("https://data.fixer.io.api/symbols?accces_key=" + FixerApi.apikey);
        try(InputStream is = url.openStream()){
            return new String(is.readAllBytes());
        }
    }
}
