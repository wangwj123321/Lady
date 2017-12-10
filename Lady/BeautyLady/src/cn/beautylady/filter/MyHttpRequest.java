package cn.beautylady.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by 王 on 2017/11/25.
 */
public class MyHttpRequest extends HttpServletRequestWrapper{

    private final HttpServletRequest request;

    public MyHttpRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value == null) {
            return null;
        }
        try {
            value = new String(value.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String,String[]> map = super.getParameterMap();
        if (map == null) {
            return null;
        }
        for (String key: map.keySet()) {
            String[] values = map.get(key);
            for (int i=0 ; i<values.length ; i++) {
                try {
                    values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values == null) {
            return null;
        }
        for (int i=0 ; i<values.length ; i++) {
            try {
                values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return values;
    }
}
