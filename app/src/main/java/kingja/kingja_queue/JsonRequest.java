package kingja.kingja_queue;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1317:45
 * 修改备注：
 */
public class JsonRequest<T> extends Request<T>{

    private Class<T> clazz;
    private Response.Listener listener;
    private Gson gson = new Gson();

    public JsonRequest(String method, String url, Class<T> clazz, Response.Listener listener, Response.ErrorListener errlistener) {
        super(method, url, errlistener);
        this.clazz = clazz;
        this.listener = listener;
    }
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        if (response.exception != null) {
            return Response.error(response.exception);
        }
        try {
            String json = new String(response.data, "GB2312");
            return Response.success(gson.fromJson(json, clazz));
        } catch (UnsupportedEncodingException e) {
            return Response.error(e);
        } catch (JsonSyntaxException e) {
            return Response.error(e);
        }
    }

    @Override
    protected void deliverResponse(T response) {
        if (listener != null) {
            listener.onResponse(response);
        }
    }
}
