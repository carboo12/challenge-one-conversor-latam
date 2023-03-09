package desafio.alura.conversor.utilidades;


import desafio.alura.conversor.enums.monedas;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class ConvertirMonedasImplem {

	//esta es mi api key la cual es gratis, la que me permite acceder a usar dicha appi
	private static final String API_KEY = "KPiZxi7bVjnvehgGRnBytXQbP8MDXIDW";
	  @SuppressWarnings("unused")
	public  Double callApi(double amount, monedas fromCurrency, monedas toCurrency) throws IOException {
		  double exchangeRate = 0.0;
		  //aqui con la variable apiUrl defino la conexion a la api
		  String API_URL = "https://api.apilayer.com/exchangerates_data/convert?to=" + toCurrency + "&from=" + fromCurrency + "&amount=" + amount;
		  try {
			  //para hacer uso de esta app se tiene que realizar peticiones de tipo Get de la manera que el servidor de la appi recomienda
			  OkHttpClient client = new OkHttpClient().newBuilder().build();
			  Request request = new Request.Builder()
					  .url(API_URL)
					  .addHeader("apikey", API_KEY)
					  .method("GET", null)
					  .build();
			  //aqui ejecuta la petucion y retorna una respuesta
			  Response response = client.newCall(request).execute();
			  //la respuesta la convierte en objeto Json el cual nos ayuda a extraer el resultado
			  JSONObject jsonObject = new JSONObject(response.body().string());
			  //de esta manera se extrae el resultado del objeto Json que creamos para retornarlo y mostralo al usuario
			  exchangeRate = jsonObject.getDouble("result");
		  } catch ( JSONException e) {
			  e.printStackTrace();
		  }
		  return exchangeRate;
	    }
}
