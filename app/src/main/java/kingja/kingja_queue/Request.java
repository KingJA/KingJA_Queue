package kingja.kingja_queue;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1320:15
 * 修改备注：
 */
public abstract class Request<T> implements Comparable {
    protected String url;
    protected Map<String, String> param = new HashMap<>();
    protected String method;
    private Response.ErrorListener errorListener;

    protected Request(String method, String url, Response.ErrorListener errorListener) {
        this.method = method;
        this.url = url;
        this.errorListener = errorListener;
    }

    protected String getUrl() {
        return url;
    }

    protected Map<String, String> getParam() {
        return param;
    }

    protected void setParam(Map<String, String> param) {
        this.param = param;
    }

    protected String getMethod() {
        return method;
    }

    @Override
    public int compareTo(Object another) {
        return 1;
    }

    abstract protected Response<T> parseNetworkResponse(NetworkResponse response);

    abstract protected void deliverResponse(T response);

    public void deliverError(Exception error) {
        if (errorListener != null) {
            errorListener.onErrorResponse(error);
        }
    }
}
