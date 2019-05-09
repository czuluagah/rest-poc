package czuluaga.poc.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ILibrayApi {
	
	 @GET("books")
	 Call<Data<List<Object>>> getBook();
}
