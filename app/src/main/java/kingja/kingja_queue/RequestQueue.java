package kingja.kingja_queue;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1317:10
 * 修改备注：
 */
public class RequestQueue {
    private final PriorityBlockingQueue<Request<?>> mQueue = new PriorityBlockingQueue<>();
    private NetworkDispatcher nNetworkDispatcher;

    private RequestQueue() {

    }
    private static RequestQueue requestQueue;

    public static RequestQueue getInstance() {
        if (requestQueue == null) {
            synchronized (RequestQueue.class) {
                if (requestQueue == null) {
                    requestQueue =new RequestQueue();
                }
            }
        }
        return requestQueue;
    }

    public void start() {
        stop();
        nNetworkDispatcher =new NetworkDispatcher(mQueue,new BasicNetwork(),new ExecutorDelivery(new Handler(Looper.getMainLooper())));
        nNetworkDispatcher.start();
    }

    public <T> void add(Request<T> request) {
        mQueue.add(request);
    }

    public void stop() {
        if (nNetworkDispatcher != null) {
            nNetworkDispatcher.quit();
        }
    }
}
