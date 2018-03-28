package com.rjp.shell.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {

    /**
     * 读取Assets文件
     * @param context
     * @param fileName
     * @return
     */
    public static String getAssets(Context context, String fileName){
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            return getStringFromInputStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取文件流 => String
     * @param a_is
     * @return
     */
    private static String getStringFromInputStream(InputStream a_is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(a_is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }
}
