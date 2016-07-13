package kingja.kingja_queue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String url = "http://gc.ditu.aliyun.com/geocoding?a=%E8%8B%8F%E5%B7%9E%E5%B8%82";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void onStart(View view) {

        RequestQueue.getInstance().start();
    }

    public void onChange(View view) {
        JsonRequest<Result> request = new JsonRequest<>("GET", url, Result.class, new Response.Listener<Result>() {
            @Override
            public void onResponse(Result response) {
                Log.e(TAG, "onResponse: "+response.toString());
                tv.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(Exception e) {
                Log.e(TAG, "onErrorResponse: "+e.getMessage());
                tv.setText(e.getMessage());
            }
        });
        RequestQueue.getInstance().add(request);
    }

    public void onQuit(View view) {
        RequestQueue.getInstance().stop();
    }

}
