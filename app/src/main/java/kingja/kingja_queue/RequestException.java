package kingja.kingja_queue;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1323:34
 * 修改备注：
 */
public class RequestException extends Exception {
    /**
     * Constructs a new {@code Exception} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage the detail message for this exception.
     */
    public RequestException(String detailMessage) {
        super(detailMessage);
    }
}
