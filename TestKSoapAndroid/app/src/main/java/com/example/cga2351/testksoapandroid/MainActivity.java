package com.example.cga2351.testksoapandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {

//                //get city
//                getCity();
//
//                //get weather
//                getWeather();

                //get weather
                getWeatherServer();
            }
        }).start();
    }

    public void getCity() {

        final String SERVER_URL = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";
        final String NAME_SPACE = "http://WebXml.com.cn/";
        final String METHOD_GET_CITY = "getSupportCity";
        final String METHOD_GET_CITY_RESULT = "getSupportCityResult";

        HttpTransportSE httpSE = new HttpTransportSE(SERVER_URL);

        SoapObject soapObject = new SoapObject(NAME_SPACE, METHOD_GET_CITY);
        soapObject.addProperty("byProvinceName", "四川");

        SoapSerializationEnvelope soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);

        soapSerializationEnvelope.bodyOut = soapObject;
        soapSerializationEnvelope.dotNet = true;

        // 调用HttpTransportSE对象的call方法来调用 webserice
        try {
            httpSE.call(NAME_SPACE + METHOD_GET_CITY, soapSerializationEnvelope);
            if (soapSerializationEnvelope.getResponse() != null) {
                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject)soapSerializationEnvelope.bodyIn;
                SoapObject detail = (SoapObject)result.getProperty(METHOD_GET_CITY_RESULT);
                // 解析返回信息
                for (int i = 0; i < detail.getPropertyCount(); i++) {
                    Log.e(TAG, detail.getProperty(i).toString());
                }
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        } finally {
            ;
        }
    }

    public void getWeather() {
        final String SERVER_URL = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";
        final String NAME_SPACE = "http://WebXml.com.cn/";
        final String METHOD = "getWeatherbyCityName";
        final String METHOD_RESULT = "getWeatherbyCityNameResult";
        final String PARAM_NAME_1 = "theCityName";
        final String PARAM_VAL_1 = "成都";

//        final String METHOD = "getSupportCity";
//        final String METHOD_RESULT = "getSupportCityResult";
//        final String PARAM_NAME_1 = "byProvinceName";
//        final String PARAM_VAL_1 = "四川";

        //创建http传输对象
        HttpTransportSE httpSE = new HttpTransportSE(SERVER_URL);

        //创建soap对象，命名空间+方法名
        SoapObject soapObject = new SoapObject(NAME_SPACE, METHOD);

        //参数
        soapObject.addProperty(PARAM_NAME_1, PARAM_VAL_1);

        SoapSerializationEnvelope soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);

        soapSerializationEnvelope.bodyOut = soapObject;
        soapSerializationEnvelope.dotNet = true;

        // 调用HttpTransportSE对象的call方法来调用 webserice
        try {
            httpSE.call(NAME_SPACE + METHOD, soapSerializationEnvelope);
            if (soapSerializationEnvelope.getResponse() != null) {
                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject)soapSerializationEnvelope.bodyIn;
                SoapObject detail = (SoapObject)result.getProperty(METHOD_RESULT);
                // 解析返回信息
                for (int i = 0; i < detail.getPropertyCount(); i++) {
                    Log.e(TAG, detail.getProperty(i).toString());
                }
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        } finally {
            ;
        }
    }


    public void getWeatherServer() {

        final String SERVER_URL = "http://www.webxml.com.cn/WebServices/WeatherWS.asmx";
        final String NAME_SPACE = "http://WebXml.com.cn/";
        final String METHOD = "getWeather";
        final String METHOD_RESULT = "getWeatherResult";
        final String PARAM_NAME_1 = "theCityCode";
        final String PARAM_VAL_1 = "成都";
        final String PARAM_NAME_2 = "theUserID";
        final String PARAM_VAL_2 = "";



//        final String METHOD = "getSupportCity";
//        final String METHOD_RESULT = "getSupportCityResult";
//        final String PARAM_NAME_1 = "byProvinceName";
//        final String PARAM_VAL_1 = "四川";

        //创建http传输对象
        HttpTransportSE httpSE = new HttpTransportSE(SERVER_URL);

        //创建soap对象，命名空间+方法名
        SoapObject soapObject = new SoapObject(NAME_SPACE, METHOD);

        //参数
        soapObject.addProperty(PARAM_NAME_1, PARAM_VAL_1);
        soapObject.addProperty(PARAM_NAME_2, PARAM_VAL_2);

        SoapSerializationEnvelope soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);

        soapSerializationEnvelope.bodyOut = soapObject;
        soapSerializationEnvelope.dotNet = true;

        // 调用HttpTransportSE对象的call方法来调用 webserice
        try {
            httpSE.call(NAME_SPACE + METHOD, soapSerializationEnvelope);
            if (soapSerializationEnvelope.getResponse() != null) {
                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject)soapSerializationEnvelope.bodyIn;
                SoapObject detail = (SoapObject)result.getProperty(METHOD_RESULT);
                // 解析返回信息
                for (int i = 0; i < detail.getPropertyCount(); i++) {
                    Log.e(TAG, detail.getProperty(i).toString());
                }
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        } finally {
            ;
        }
    }
}
