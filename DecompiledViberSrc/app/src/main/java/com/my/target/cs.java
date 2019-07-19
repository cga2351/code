package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import com.my.target.b.c.a.h;
import com.my.target.common.a.b;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cs
{
  private final f a;
  private final z b;
  private final Context c;

  private cs(f paramf, z paramz, Context paramContext)
  {
    this.a = paramf;
    this.b = paramz;
    this.c = paramContext;
  }

  private b a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("imageLink");
    if (TextUtils.isEmpty(str))
    {
      a("InterstitialAdImageBanner no imageLink for image", "Required field", paramString);
      return null;
    }
    int i = paramJSONObject.optInt("width");
    int j = paramJSONObject.optInt("height");
    if ((i <= 0) || (j <= 0))
    {
      a("InterstitialAdImageBanner  image has wrong dimensions, w = " + i + ", h = " + j, "Required field", paramString);
      return null;
    }
    return b.a(str, i, j);
  }

  public static cs a(f paramf, z paramz, Context paramContext)
  {
    return new cs(paramf, paramz, paramContext);
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    y.a(paramString2).b(paramString1).d(paramString3).a(this.b.c()).c(this.a.f()).a(this.c);
  }

  public final boolean a(JSONObject paramJSONObject, h paramh)
  {
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("portrait");
    JSONArray localJSONArray2 = paramJSONObject.optJSONArray("landscape");
    if (((localJSONArray1 == null) || (localJSONArray1.length() <= 0)) && ((localJSONArray2 == null) || (localJSONArray2.length() <= 0)))
      a("No images in InterstitialAdImageBanner", "Required field", paramh.k());
    do
    {
      return false;
      if (localJSONArray1 != null)
      {
        int k = localJSONArray1.length();
        for (int m = 0; m < k; m++)
        {
          JSONObject localJSONObject2 = localJSONArray1.optJSONObject(m);
          if (localJSONObject2 != null)
          {
            b localb2 = a(localJSONObject2, paramh.k());
            if (localb2 != null)
              paramh.f(localb2);
          }
        }
      }
      if (localJSONArray2 != null)
      {
        int i = localJSONArray2.length();
        for (int j = 0; j < i; j++)
        {
          JSONObject localJSONObject1 = localJSONArray2.optJSONObject(j);
          if (localJSONObject1 != null)
          {
            b localb1 = a(localJSONObject1, paramh.k());
            if (localb1 != null)
              paramh.g(localb1);
          }
        }
      }
    }
    while ((paramh.J().isEmpty()) && (paramh.I().isEmpty()));
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cs
 * JD-Core Version:    0.6.2
 */