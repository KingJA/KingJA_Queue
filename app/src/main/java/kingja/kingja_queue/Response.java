package kingja.kingja_queue;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1317:59
 * 修改备注：
 */
public class Response<T> {
    public interface Listener<T> {
         void onResponse(T response);
    }

    public interface ErrorListener {
         void onErrorResponse(Exception e);
    }
    public static <T> Response<T> success(T result) {
        return new Response<T>(result);
    }

    public static <T> Response<T> error(Exception error) {
        return new Response<T>(error);
    }

    public final T result;
    public final Exception error;
    /**
     * Returns whether this response is considered successful.
     */
    public boolean isSuccess() {
        return error == null;
    }

    private Response(T result) {
        this.result = result;
        this.error = null;
    }

    private Response(Exception error) {
        this.result = null;
        this.error = error;
    }
}
