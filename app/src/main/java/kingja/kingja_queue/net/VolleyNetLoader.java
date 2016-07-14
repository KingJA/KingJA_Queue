package kingja.kingja_queue.net;

import android.content.Context;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1418:43
 * 修改备注：
 */
public class VolleyNetLoader implements INetLoader {

    @Override
    public <T>void loadNet(Context context,String method, String url, Class<T> clazz, Response.Listener<T>listener, Response.ErrorListener errorListener) {
        JsonRequest<T> request = new JsonRequest<>(method, url, clazz, listener, errorListener);
        VolleyManager.getInstance(context).getRequestQueue().add(request);
    }
}
