package com.philong.lazada.util;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Long on 9/6/2017.
 */

public class DownLoadJsonGet extends AsyncTask<String, Void, String> {

    protected ProtocolDownLoadJsonGet mProtocolDownLoadJsonGet;

    public DownLoadJsonGet(ProtocolDownLoadJsonGet protocolDownLoadJsonGet) {
        mProtocolDownLoadJsonGet = protocolDownLoadJsonGet;
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                return stringBuilder.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            httpURLConnection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mProtocolDownLoadJsonGet.compleDownLoadJsonGet(s);
    }

    public interface ProtocolDownLoadJsonGet {
        void compleDownLoadJsonGet(String s);
    }
}
