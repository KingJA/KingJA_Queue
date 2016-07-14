package kingja.kingja_queue.net;

import java.io.Serializable;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1321:15
 * 修改备注：
 */
public class NetworkResponse implements Serializable {
    public byte[] data;
    public Exception exception;

    public NetworkResponse(byte[] data) {
        this.data = data;
    }

    public NetworkResponse(Exception exception) {
        this.exception = exception;
    }
}
