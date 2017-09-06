package com.philong.lazada.util;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Long on 9/6/2017.
 */

public class DownLoadJsonPost extends AsyncTask<String, Void, String> {

    protected ProtocolDownLoadJsonPost mProtocolDownLoadJsonPost;

    public DownLoadJsonPost(ProtocolDownLoadJsonPost protocolDownLoadJsonPost) {
        mProtocolDownLoadJsonPost = protocolDownLoadJsonPost;
    }

    // Zero : Base URL
    // Odd: Paramater
    // Even: Value
    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(strings[0]);
            Uri.Builder uriBuilder = new Uri.Builder();
            int length = strings.length - 1;
            for(int i = 1; i < length; i+=2){
                uriBuilder.appendQueryParameter(strings[i], strings[i + 1]);
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            String query = uriBuilder.build().getEncodedQuery();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(query);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

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


            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){

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
        mProtocolDownLoadJsonPost.completeDownLoadJsonPost(s);
    }

    public interface ProtocolDownLoadJsonPost{
        void completeDownLoadJsonPost(String s);
    }
}
