package kingja.kingja_queue.net;

import android.content.Context;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1420:17
 * 修改备注：
 */
public class VolleyManager {
    private static RequestQueue mRequestQueue;
    private static VolleyManager mVolleyManager;
    private static Context context;

    private VolleyManager(Context context) {
        this.context = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyManager getInstance(Context context) {
        if (mVolleyManager == null) {
            mVolleyManager = new VolleyManager(context);
        }
        return mVolleyManager;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
        return mRequestQueue;
    }

    /**
     * Adds a Request to the dispatch queue.
     *
     * @param request The request to service
     * @return The passed-in request
     */
    public <T> void add(Request<T> request) {
        getRequestQueue().add(request);
    }
}
