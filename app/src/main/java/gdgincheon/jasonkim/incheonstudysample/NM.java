package gdgincheon.jasonkim.incheonstudysample;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by kimjason on 16. 1. 15..
 */
public class NM {
    private static final boolean DEBUG = true;
    private static final String TAG = "NM";

    private static NM m_instance;


    private NM() {
        return;
    }

    public static NM getInstance() {
        if (m_instance == null) {
            m_instance = new NM();
        }
        return m_instance;
    }

    public void getNews(String searchQuery,Context context) {

        Util.getInstance().printLog(DEBUG, TAG, "[DoGacha] uid : " + searchQuery);

        Retrofit retrofit_DoGacha = new Retrofit.Builder()
                .baseUrl(Util.getInstance().getServerURL())
                .addConverterFactory(new StringConverter())
                .client(new OkHttpClient())
                .build();


        NetworkModel networkModel = retrofit_DoGacha.create(NetworkModel.class);

        String APIKey = Util.getInstance().getAPIKEY(context);

        Call<String> jsonModelCall = networkModel.postNewsGet("news",searchQuery,"10","1",APIKey,"sim");

        try {
            Response<String> res = jsonModelCall.execute();
            String res_str = res.body();

            if (res_str.isEmpty()) {
                Util.getInstance().printLog(DEBUG,TAG,"GetNewsISBroken");
            } else {
               //Todo-여기에 XML파싱 하는 메서드 만들기.
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
