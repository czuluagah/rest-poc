package czuluaga.poc.retrofit;

public class Runner {
	public static void main(String[] args) throws Exception {
		RetrofitControllerAsync starter = new RetrofitControllerAsync();
		starter.start();
				
		RetrofitControllerSync sync = new RetrofitControllerSync();
		sync.start();
	}
}
