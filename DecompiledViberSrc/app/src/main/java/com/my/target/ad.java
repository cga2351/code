package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ad
{
  private final f a;
  private final z b;
  private final Context c;
  private final ah d;

  private ad(f paramf, z paramz, Context paramContext)
  {
    this.a = paramf;
    this.b = paramz;
    this.c = paramContext;
    this.d = ah.a(paramf, paramz, paramContext);
  }

  public static ad a(f paramf, z paramz, Context paramContext)
  {
    return new ad(paramf, paramz, paramContext);
  }

  private void a(String paramString1, String paramString2)
  {
    y.a(paramString1).b(paramString2).a(this.b.c()).c(this.a.f()).a(this.c);
  }

  public f a(JSONObject paramJSONObject)
  {
    double d1 = -1.0D;
    int i = this.a.j();
    if (i >= 5)
    {
      dp.a("got additional data, but max redirects limit exceeded");
      return null;
    }
    int j = paramJSONObject.optInt("id", this.a.d());
    String str1 = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(str1))
    {
      a("Required field", "No url in additionalData Id = " + j);
      return null;
    }
    f localf = f.a(str1);
    localf.b(i + 1);
    localf.a(j);
    localf.a(paramJSONObject.optBoolean("doAfter", localf.a()));
    localf.c(paramJSONObject.optInt("doOnEmptyResponseFromId", localf.b()));
    boolean bool = paramJSONObject.optBoolean("isMidrollPoint", localf.c());
    localf.b(bool);
    localf.c((float)paramJSONObject.optDouble("allowCloseDelay", localf.n()));
    if (paramJSONObject.has("allowClose"))
      localf.a(Boolean.valueOf(paramJSONObject.optBoolean("allowClose")));
    if (paramJSONObject.has("hasPause"))
      localf.b(Boolean.valueOf(paramJSONObject.optBoolean("hasPause")));
    if (paramJSONObject.has("allowSeek"))
      localf.c(Boolean.valueOf(paramJSONObject.optBoolean("allowSeek")));
    if (paramJSONObject.has("allowSkip"))
      localf.d(Boolean.valueOf(paramJSONObject.optBoolean("allowSkip")));
    if (paramJSONObject.has("allowTrackChange"))
      localf.e(Boolean.valueOf(paramJSONObject.optBoolean("allowTrackChange")));
    double d2 = paramJSONObject.optDouble("point");
    double d3;
    if (Double.isNaN(d2))
    {
      d2 = d1;
      d3 = paramJSONObject.optDouble("pointP");
      if (!Double.isNaN(d3))
        break label520;
      d3 = d1;
      label331: if ((!bool) || (d2 >= 0.0D) || (d3 >= 0.0D))
        break label589;
    }
    for (double d4 = 50.0D; ; d4 = d3)
    {
      localf.a((float)d1);
      localf.b((float)d4);
      localf.c(this.a.h());
      JSONArray localJSONArray = paramJSONObject.optJSONArray("serviceStatistics");
      if (localJSONArray != null)
      {
        int k = 0;
        while (true)
          if (k < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(k);
            if (localJSONObject != null)
            {
              String str2 = localJSONObject.optString("type", "");
              String str3 = localJSONObject.optString("url", "");
              if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
                localf.a(p.a(str2, str3));
            }
            k++;
            continue;
            if (d2 >= 0.0D)
              break;
            a("Bad value", "Wrong value " + d2 + " for point in additionalData object");
            break;
            label520: if (d3 >= 0.0D)
              break label331;
            a("Bad value", "Wrong value " + d3 + " for pointP in additionalData object");
            break label331;
          }
      }
      this.d.a(localf.q(), paramJSONObject, String.valueOf(localf.d()), -1.0F);
      return localf;
      label589: d1 = d2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ad
 * JD-Core Version:    0.6.2
 */