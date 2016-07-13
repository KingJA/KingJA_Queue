package kingja.kingja_queue;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 项目名称：常用工具类
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/7/1318:30
 * 修改备注：
 */
public class BasicNetwork {

    public NetworkResponse performRequest(Request<?> request) {
        HttpURLConnection httpURLConnection = null;
        byte[] bytes=null;
        try {
            //第一步：创建URL对象
            URL url = new URL(request.getUrl());
            httpURLConnection = (HttpURLConnection) url.openConnection();

            //第二步：设置头信息
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod(request.getMethod());
            httpURLConnection.connect();

            //第三步：判断响应码
            if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                Log.i("doNet", "网络错误异常");
                return new NetworkResponse(new RequestException("网络异常")) ;
            }
            //第四步：接受响应数据
            InputStream is = httpURLConnection.getInputStream();
//                String result = readStream(is);
            bytes = input2byte(is);
            String result = new String(bytes, "GB2312");
            Log.i("doNet", result);

        } catch (Exception e) {
            e.printStackTrace();
            return new NetworkResponse(e) ;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return new NetworkResponse(bytes);
    }


    public String readStream(InputStream is) {
        try {
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            StringBuilder sb = new StringBuilder();
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return baos.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int rc = 0;
        while ((rc = inStream.read(buff)) != -1) {
            swapStream.write(buff, 0, rc);
        }
        byte[] bytes = swapStream.toByteArray();
        return bytes;
    }
}
