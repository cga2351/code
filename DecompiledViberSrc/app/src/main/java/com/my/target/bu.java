package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import com.my.target.b.c.a.a;
import com.my.target.b.c.a.b;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bu
{
  private final f a;
  private final z b;
  private final Context c;
  private final ae d;
  private String e;

  private bu(f paramf, z paramz, Context paramContext)
  {
    this.a = paramf;
    this.b = paramz;
    this.c = paramContext;
    this.d = ae.a(paramf, paramz, paramContext);
  }

  public static bu a(f paramf, z paramz, Context paramContext)
  {
    return new bu(paramf, paramz, paramContext);
  }

  private void a(String paramString1, String paramString2)
  {
    y.a(paramString1).b(paramString2).a(this.b.c()).d(this.e).c(this.a.f()).a(this.c);
  }

  public final void a(JSONObject paramJSONObject, a parama)
  {
    this.d.a(paramJSONObject, parama);
    this.e = parama.k();
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("viewability");
    int k;
    double d1;
    if (localJSONObject1 != null)
    {
      if (localJSONObject1.has("percent"))
      {
        k = localJSONObject1.optInt("percent");
        if ((k < 5) || (k > 100))
          break label201;
        parama.c(k / 100.0F);
      }
      if (localJSONObject1.has("rate"))
      {
        d1 = localJSONObject1.optDouble("rate");
        if (d1 < 0.5D)
          break label227;
        parama.d((float)d1);
      }
    }
    label101: JSONArray localJSONArray = paramJSONObject.optJSONArray("cards");
    label201: label227: if (localJSONArray != null)
    {
      int i = localJSONArray.length();
      int j = 0;
      label124: if (j < i)
      {
        JSONObject localJSONObject3 = localJSONArray.optJSONObject(j);
        b localb;
        if (localJSONObject3 != null)
        {
          localb = b.a(parama);
          this.d.a(localJSONObject3, localb);
          if (!TextUtils.isEmpty(localb.q()))
            break label253;
          a("Required field", "no tracking link in nativeAdCard");
          localb = null;
        }
        while (true)
        {
          if (localb != null)
            parama.a(localb);
          j++;
          break label124;
          a("Bad value", "invalid viewability percent " + k);
          break;
          a("Bad value", "invalid viewability rate " + d1);
          break label101;
          label253: if (localb.l() == null)
          {
            a("Required field", "no image in nativeAdCard");
            localb = null;
          }
          else
          {
            localb.j(localJSONObject3.optString("cardID", localb.k()));
          }
        }
      }
    }
    if (parama.G().isEmpty())
    {
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("video");
      if ((localJSONObject2 != null) && (bf.a()))
      {
        k localk = k.D();
        localk.j(parama.k());
        if (af.a(this.a, this.b, this.c).a(localJSONObject2, localk))
          parama.a(localk);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bu
 * JD-Core Version:    0.6.2
 */