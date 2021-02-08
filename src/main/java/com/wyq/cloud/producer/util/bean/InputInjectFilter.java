package com.wyq.cloud.producer.util.bean;

/*
 * @Author:wuyongqiang
 * @Date:2020-12-23 14:54:14:54
 */
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.util.Iterator;
import java.util.Set;
import org.springframework.web.util.HtmlUtils;

public class InputInjectFilter
{
    public static Object encodeInputString(Object obj, Class clz)
    {
        if (obj != null) {
            JSONObject jsObject = encodeInputString(JSONUtil.parseObj(obj));
            return JSONUtil.toBean(jsObject, clz);
        }
        return null;
    }

    public static JSONObject encodeInputString(JSONObject jsObject)
    {
        if (jsObject != null) {
            Set entrySet = jsObject.keySet();
            Iterator iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                if ((jsObject.get(key) != null) && (jsObject.get(key) instanceof String))
                    jsObject.putOpt(key, encodeInputString((String)jsObject.get(key)));
                else if ((jsObject.get(key) != null) && (jsObject.get(key) instanceof JSONArray))
                    jsObject.putOpt(key, encodeInputString(jsObject.getJSONArray(key)));
                else if ((jsObject.get(key) != null) && (jsObject.get(key) instanceof JSONObject))
                    jsObject.putOpt(key, encodeInputString(jsObject.getJSONObject(key)));
            }

        }

        return jsObject;
    }

    public static JSONObject decodeInputString(JSONObject jsObject)
    {
        if (jsObject != null) {
            Set entrySet = jsObject.keySet();
            Iterator iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                if ((jsObject.get(key) != null) && (jsObject.get(key) instanceof String))
                    jsObject.putOpt(key, decodeInputString((String)jsObject.get(key)));
                else if ((jsObject.get(key) != null) && (jsObject.get(key) instanceof JSONArray))
                    jsObject.putOpt(key, decodeInputString((JSONArray)jsObject.get(key)));
                else if ((jsObject.get(key) != null) && (jsObject.get(key) instanceof JSONObject))
                    jsObject.putOpt(key, decodeInputString(jsObject.getJSONObject(key)));

            }

        }

        return jsObject;
    }

    public static JSONArray encodeInputString(JSONArray jsonArray)
    {
        for (int i = 0; i < jsonArray.size(); ++i)
            if ((jsonArray.get(i) != null) && (jsonArray.get(i) instanceof String)) {
                jsonArray.set(i, encodeInputString((String)jsonArray.get(i)));
            }
            else if ((jsonArray.get(i) != null) && (jsonArray.get(i) instanceof JSONObject))
                encodeInputString(jsonArray.getJSONObject(Integer.valueOf(i)));


        return jsonArray;
    }

    public static JSONArray decodeInputString(JSONArray jsonArray)
    {
        for (int i = 0; i < jsonArray.size(); ++i)
            if ((jsonArray.get(i) != null) && (jsonArray.get(i) instanceof String)) {
                jsonArray.set(i, decodeInputString((String)jsonArray.get(i)));
            }
            else if ((jsonArray.get(i) != null) && (jsonArray.get(i) instanceof JSONObject))
                decodeInputString(jsonArray.getJSONObject(Integer.valueOf(i)));


        return jsonArray;
    }

    public static String encodeInputString(String input)
    {
        String resut = HtmlUtils.htmlEscape(input);
        return resut;
    }

    public static char[] encodeInputCharArray(char[] input)
    {
        return encodeInputString(input.toString()).toCharArray();
    }

    public static String decodeInputString(String input)
    {
        String resut = HtmlUtils.htmlUnescape(input);
        return resut;
    }
}