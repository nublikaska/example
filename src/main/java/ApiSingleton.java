import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Singleton
public class ApiSingleton {
    private static Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.42.52:8080/career/")
            .build();

    private static ServiceApi serviceApi = retrofit.create(ServiceApi.class);

    public static ServiceApi getSetviceApi() {
        return serviceApi;
    }
}


