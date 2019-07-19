package com.my.target;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dr
{
  public static ec a(ConsoleMessage paramConsoleMessage)
  {
    String str1 = paramConsoleMessage.message();
    if ((!TextUtils.isEmpty(str1)) && (a(str1)))
    {
      String str2 = str1.substring("adman://onEvent,".length());
      try
      {
        ec localec = a(new JSONObject(str2));
        return localec;
      }
      catch (JSONException localJSONException)
      {
        dp.b(localJSONException.getMessage());
      }
    }
    return null;
  }

  private static ec a(JSONObject paramJSONObject)
    throws JSONException
  {
    int i = 0;
    String str1 = paramJSONObject.getString("event");
    if (paramJSONObject.has("data"));
    for (JSONObject localJSONObject = paramJSONObject.getJSONObject("data"); ; localJSONObject = null)
    {
      int j = -1;
      dy localdy;
      switch (str1.hashCode())
      {
      default:
        switch (j)
        {
        default:
          localdy = new dy(str1);
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        break;
      case -1349867671:
      case 1109243225:
      case 172943136:
      case 747469392:
      case -1012956973:
      case 157935686:
      }
      boolean bool2;
      do
      {
        boolean bool1;
        do
        {
          do
          {
            boolean bool3;
            do
            {
              do
              {
                boolean bool6;
                do
                {
                  boolean bool5;
                  do
                  {
                    do
                    {
                      boolean bool8;
                      do
                      {
                        boolean bool7;
                        do
                        {
                          do
                          {
                            return localdy;
                            if (!str1.equals("onError"))
                              break;
                            j = 0;
                            break;
                            if (!str1.equals("onExpand"))
                              break;
                            j = 1;
                            break;
                            if (!str1.equals("onAdStart"))
                              break;
                            j = 2;
                            break;
                            if (!str1.equals("onSizeChange"))
                              break;
                            j = 3;
                            break;
                            if (!str1.equals("onStat"))
                              break;
                            j = 4;
                            break;
                            if (!str1.equals("onAdClick"))
                              break;
                            j = 5;
                            break;
                            if (localJSONObject != null)
                            {
                              String str5 = "jsError";
                              if (localJSONObject.has("error"))
                                str5 = str5 + " error: " + localJSONObject.getString("error");
                              if (localJSONObject.has("message"))
                                str5 = str5 + " message: " + localJSONObject.getString("message");
                              return new eb(str5);
                            }
                            return new eb();
                            if ((localJSONObject != null) && (localJSONObject.has("width")) && (localJSONObject.has("height")))
                              return new ed(localJSONObject.getInt("width"), localJSONObject.getInt("height"));
                            return new ed();
                            localdy = null;
                          }
                          while (localJSONObject == null);
                          bool7 = localJSONObject.has("format");
                          localdy = null;
                        }
                        while (!bool7);
                        bool8 = localJSONObject.has("banners");
                        localdy = null;
                      }
                      while (!bool8);
                      String str4 = localJSONObject.getString("format");
                      JSONArray localJSONArray2 = localJSONObject.getJSONArray("banners");
                      int m = localJSONArray2.length();
                      String[] arrayOfString = new String[m];
                      while (i < m)
                      {
                        arrayOfString[i] = localJSONArray2.getString(i);
                        i++;
                      }
                      return new ea(arrayOfString, str4);
                      localdy = null;
                    }
                    while (localJSONObject == null);
                    bool5 = localJSONObject.has("width");
                    localdy = null;
                  }
                  while (!bool5);
                  bool6 = localJSONObject.has("height");
                  localdy = null;
                }
                while (!bool6);
                return new ee(localJSONObject.getInt("width"), localJSONObject.getInt("height"));
                localdy = null;
              }
              while (localJSONObject == null);
              bool3 = localJSONObject.has("stats");
              localdy = null;
            }
            while (!bool3);
            JSONArray localJSONArray1 = localJSONObject.getJSONArray("stats");
            int k = localJSONArray1.length();
            ArrayList localArrayList = new ArrayList();
            while (i < k)
            {
              localArrayList.add(localJSONArray1.getString(i));
              i++;
            }
            boolean bool4 = localJSONObject.has("type");
            String str3 = null;
            if (bool4)
              str3 = localJSONObject.getString("type");
            return new ef(localArrayList, str3);
            localdy = null;
          }
          while (localJSONObject == null);
          bool1 = localJSONObject.has("format");
          localdy = null;
        }
        while (!bool1);
        bool2 = localJSONObject.has("bannerId");
        localdy = null;
      }
      while (!bool2);
      String str2 = localJSONObject.getString("format");
      return new dz(localJSONObject.getString("bannerId"), str2, localJSONObject.optString("url"));
    }
  }

  private static boolean a(String paramString)
  {
    return paramString.startsWith("adman://onEvent,");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dr
 * JD-Core Version:    0.6.2
 */