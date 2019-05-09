package czuluaga.poc.retrofit;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitControllerSync {

	static final String BASE_URL = "http://localhost:8080/library/";

    public void start() throws Exception{

    	Retrofit retrofit = new Retrofit.Builder()
    	        .baseUrl(BASE_URL)
    	        .addConverterFactory(GsonConverterFactory.create())
    	        .build();

    	    // Create an instance of our GitHub API interface.
    	    ILibrayApi api = retrofit.create(ILibrayApi.class);

    	    // Create a call instance for looking up Retrofit contributors.
    	    Call<Data<List<Object>>> call = api.getBook();

    	    // Fetch and print a list of the contributors to the library.
    	    System.out.println("SYNC RESPONSE ================================");
    	    Data<List<Object>> result = call.execute().body();
    	    System.out.println(result);
    	    System.out.println("================================");

    }
}
