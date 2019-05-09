package czuluaga.poc.retrofit;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitControllerAsync implements Callback<Data<List<Object>>>{

	static final String BASE_URL = "http://localhost:8080/library/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ILibrayApi api = retrofit.create(ILibrayApi.class);

        Call<Data<List<Object>>> call = api.getBook();
        call.enqueue(this);

    }

	public void onResponse(Call<Data<List<Object>>> call, Response<Data<List<Object>>> response) {
		
		System.out.println("ASYNC RESPONSE ================================");
		if(response.isSuccessful()) {
			Data<List<Object>> changesList = response.body();
            changesList.getData().forEach(book -> System.out.println(book.toString()));
        } else {
            System.out.println(response.errorBody());
        }
		System.out.println("================================");
		
	}

	public void onFailure(Call<Data<List<Object>>> call, Throwable t) {
		t.printStackTrace();
		
	}

  

}
