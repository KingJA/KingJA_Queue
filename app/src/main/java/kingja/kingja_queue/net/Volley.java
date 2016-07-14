package kingja.kingja_queue.net;

import android.content.Context;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1420:02
 * 修改备注：
 */
public class Volley {

    public static RequestQueue newRequestQueue(Context context) {
        RequestQueue requestQueue = new RequestQueue(new BasicNetwork(), new Cache());
        requestQueue.start();
        return requestQueue;

    }

}
