package com.iab.omid.library.appnexus.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  static float a = Resources.getSystem().getDisplayMetrics().density;
  private static WindowManager b = null;
  private static String[] c = { "x", "y", "width", "height" };

  static float a(int paramInt)
  {
    return paramInt / a;
  }

  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("x", a(paramInt1));
      localJSONObject.put("y", a(paramInt2));
      localJSONObject.put("width", a(paramInt3));
      localJSONObject.put("height", a(paramInt4));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.a("Error with creating viewStateObject", localJSONException);
    }
    return localJSONObject;
  }

  public static void a(Context paramContext)
  {
    if (paramContext != null)
    {
      a = paramContext.getResources().getDisplayMetrics().density;
      b = (WindowManager)paramContext.getSystemService("window");
    }
  }

  public static void a(JSONObject paramJSONObject)
  {
    a locala = b(paramJSONObject);
    try
    {
      paramJSONObject.put("width", locala.a);
      paramJSONObject.put("height", locala.b);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  public static void a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject.put("adSessionId", paramString);
      return;
    }
    catch (JSONException localJSONException)
    {
      c.a("Error with setting ad session id", localJSONException);
    }
  }

  public static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      c.a("JSONException during JSONObject.put for name [" + paramString + "]", localJSONException);
    }
  }

  public static void a(JSONObject paramJSONObject, List<String> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localJSONArray.put((String)localIterator.next());
    try
    {
      paramJSONObject.put("isFriendlyObstructionFor", localJSONArray);
      return;
    }
    catch (JSONException localJSONException)
    {
      c.a("Error with setting friendly obstruction", localJSONException);
    }
  }

  public static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject1.optJSONArray("childViews");
      if (localJSONArray == null)
      {
        localJSONArray = new JSONArray();
        paramJSONObject1.put("childViews", localJSONArray);
      }
      localJSONArray.put(paramJSONObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  private static boolean a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if ((paramJSONArray1 == null) && (paramJSONArray2 == null));
    do
    {
      return true;
      if ((paramJSONArray1 == null) || (paramJSONArray2 == null))
        return false;
    }
    while (paramJSONArray1.length() == paramJSONArray2.length());
    return false;
  }

  private static a b(JSONObject paramJSONObject)
  {
    float f1 = 0.0F;
    float f2;
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (b == null)
        break label174;
      Point localPoint = new Point(0, 0);
      b.getDefaultDisplay().getRealSize(localPoint);
      f2 = a(localPoint.x);
      f1 = a(localPoint.y);
    }
    while (true)
    {
      return new a(f2, f1);
      JSONArray localJSONArray = paramJSONObject.optJSONArray("childViews");
      if (localJSONArray != null)
      {
        int i = localJSONArray.length();
        int j = 0;
        f2 = 0.0F;
        while (j < i)
        {
          JSONObject localJSONObject = localJSONArray.optJSONObject(j);
          if (localJSONObject != null)
          {
            double d1 = localJSONObject.optDouble("x");
            double d2 = localJSONObject.optDouble("y");
            double d3 = localJSONObject.optDouble("width");
            double d4 = localJSONObject.optDouble("height");
            f2 = Math.max(f2, (float)(d1 + d3));
            f1 = Math.max(f1, (float)(d2 + d4));
          }
          j++;
        }
      }
      else
      {
        label174: f1 = 0.0F;
        f2 = 0.0F;
      }
    }
  }

  public static boolean b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null));
    do
    {
      return true;
      if ((paramJSONObject1 == null) || (paramJSONObject2 == null))
        return false;
    }
    while ((c(paramJSONObject1, paramJSONObject2)) && (d(paramJSONObject1, paramJSONObject2)) && (e(paramJSONObject1, paramJSONObject2)) && (f(paramJSONObject1, paramJSONObject2)));
    return false;
  }

  private static boolean c(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    for (String str : c)
      if (paramJSONObject1.optDouble(str) != paramJSONObject2.optDouble(str))
        return false;
    return true;
  }

  private static boolean d(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return paramJSONObject1.optString("adSessionId", "").equals(paramJSONObject2.optString("adSessionId", ""));
  }

  private static boolean e(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONArray localJSONArray1 = paramJSONObject1.optJSONArray("isFriendlyObstructionFor");
    JSONArray localJSONArray2 = paramJSONObject2.optJSONArray("isFriendlyObstructionFor");
    boolean bool2;
    if ((localJSONArray1 == null) && (localJSONArray2 == null))
      bool2 = true;
    boolean bool1;
    do
    {
      return bool2;
      bool1 = a(localJSONArray1, localJSONArray2);
      bool2 = false;
    }
    while (!bool1);
    for (int i = 0; ; i++)
    {
      if (i >= localJSONArray1.length())
        break label90;
      boolean bool3 = localJSONArray1.optString(i, "").equals(localJSONArray2.optString(i, ""));
      bool2 = false;
      if (!bool3)
        break;
    }
    label90: return true;
  }

  private static boolean f(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONArray localJSONArray1 = paramJSONObject1.optJSONArray("childViews");
    JSONArray localJSONArray2 = paramJSONObject2.optJSONArray("childViews");
    boolean bool2;
    if ((localJSONArray1 == null) && (localJSONArray2 == null))
      bool2 = true;
    boolean bool1;
    do
    {
      return bool2;
      bool1 = a(localJSONArray1, localJSONArray2);
      bool2 = false;
    }
    while (!bool1);
    for (int i = 0; ; i++)
    {
      if (i >= localJSONArray1.length())
        break label86;
      boolean bool3 = b(localJSONArray1.optJSONObject(i), localJSONArray2.optJSONObject(i));
      bool2 = false;
      if (!bool3)
        break;
    }
    label86: return true;
  }

  private static class a
  {
    final float a;
    final float b;

    a(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.d.b
 * JD-Core Version:    0.6.2
 */