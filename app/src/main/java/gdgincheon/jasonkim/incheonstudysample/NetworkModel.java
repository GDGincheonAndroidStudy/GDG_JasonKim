package gdgincheon.jasonkim.incheonstudysample;

import retrofit.Call;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by kimjason on 16. 1. 15..
 */
public interface NetworkModel {


    @FormUrlEncoded
    @POST("/search")
    Call<String> postNewsGet(@Query("target") String target,@Query("query") String query,
                             @Query("display") String display,@Query("start") String start,
                             @Query("key") String key,@Query("sort")String sim);

}
