package com.viber.voip.s;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static final Logger a = ViberEnv.getLogger();

  private static String a(String paramString)
  {
    if (paramString.startsWith("﻿"))
      paramString = paramString.substring(1);
    return paramString;
  }

  public static final List<String> a(Context paramContext, String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(1500);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramContext.getAssets().open(paramString), "UTF8"));
      while (true)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null)
          break;
        if (j != 0)
        {
          str1 = a(str1);
          j = 0;
        }
        String str3 = str1.trim();
        if ((!TextUtils.isEmpty(str3)) && (!str3.startsWith("--")))
          localStringBuilder.append(str3).append(' ');
      }
      localBufferedReader.close();
      String[] arrayOfString = localStringBuilder.toString().split(";(?!\\s*END)");
      while (i < arrayOfString.length)
      {
        String str2 = arrayOfString[i].trim();
        if (!TextUtils.isEmpty(str2))
          localArrayList.add(str2);
        i++;
      }
    }
    catch (Exception localException)
    {
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.b
 * JD-Core Version:    0.6.2
 */