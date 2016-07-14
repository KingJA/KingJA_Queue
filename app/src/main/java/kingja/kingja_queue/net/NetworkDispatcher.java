package kingja.kingja_queue.net;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1218:38
 * 修改备注：
 */

public class NetworkDispatcher extends Thread {

    private static final String TAG = "NetworkDispatcher";
    private BlockingQueue<Request<?>> blockingQueue;
    private BasicNetwork network;
    private ResponseDelivery delivery;
    private boolean mQuit;


    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, BasicNetwork network, ResponseDelivery delivery) {
        this.blockingQueue = blockingQueue;
        this.network = network;
        this.delivery = delivery;
    }

    @Override
    public void run() {
        Request<?> request=null;
        while (true) {
            Log.e(TAG, "============================轮询=================================" );
            try {
                request=blockingQueue.take();
                NetworkResponse networkResponse = network.performRequest(request);

                Response<?> response = request.parseNetworkResponse(networkResponse);
                delivery.postResponse(request, response);

            } catch (InterruptedException e) {
                if (mQuit) {
                    return;
                }

            }
        }
    }

    public void quit() {
        mQuit = true;
        interrupt();
    }
}
