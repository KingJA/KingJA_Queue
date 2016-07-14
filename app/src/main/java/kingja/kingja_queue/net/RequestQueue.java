package kingja.kingja_queue.net;

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
    private final PriorityBlockingQueue<Request<?>> mNetworkQueue = new PriorityBlockingQueue<>();
    private NetworkDispatcher nNetworkDispatcher;
    private BasicNetwork mBasicNetwork;
    private Cache mCache;
    private ExecutorDelivery mExecutorDelivery;

    public RequestQueue(BasicNetwork mBasicNetwork,Cache mCache) {
        this(mBasicNetwork,mCache,new ExecutorDelivery(new Handler(Looper.getMainLooper())));

    }
    public RequestQueue(BasicNetwork mBasicNetwork,Cache mCache,ExecutorDelivery mExecutorDelivery) {
        this.mBasicNetwork = mBasicNetwork;
        this.mCache = mCache;
        this.mExecutorDelivery = mExecutorDelivery;
    }


    public void start() {
        stop();
        nNetworkDispatcher =new NetworkDispatcher(mNetworkQueue,mBasicNetwork,mExecutorDelivery);
        nNetworkDispatcher.start();
    }

    public <T> void add(Request<T> request) {
        mNetworkQueue.add(request);
    }

    public void stop() {
        if (nNetworkDispatcher != null) {
            nNetworkDispatcher.quit();
        }
    }
}
