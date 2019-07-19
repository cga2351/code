package com.viber.voip.market;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.ProductCategory;
import com.viber.voip.billing.ProductId;
import com.viber.voip.stickers.entity.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  public static String a = "paid";
  private static final Logger g = ViberEnv.getLogger();
  private static Map<ProductId, g> h = new ConcurrentHashMap();
  public ProductId b;
  public String c;
  public String d;
  public String e;
  public String[] f;

  private g()
  {
  }

  private g(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("id"))
        this.b = ProductId.fromString(paramJSONObject.getString("id"));
      this.c = paramJSONObject.optString("title");
      this.d = paramJSONObject.optString("price_string");
      this.e = paramJSONObject.optString("offer_type");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("formats");
      if (localJSONArray != null)
      {
        int i = localJSONArray.length();
        this.f = new String[i];
        for (int j = 0; j < i; j++)
          this.f[j] = localJSONArray.getString(j);
      }
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public static g a(ProductId paramProductId)
  {
    return (g)h.get(paramProductId);
  }

  public static g a(String paramString)
  {
    try
    {
      g localg = new g(new JSONObject(paramString));
      h.put(localg.b, localg);
      return localg;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static void a(a parama)
  {
    Iterator localIterator = h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((ProductId)localEntry.getKey()).getCategory() == ProductCategory.STICKER_PACKAGE) && (((ProductId)localEntry.getKey()).getPackageId() == parama.e()))
        localIterator.remove();
    }
  }

  static g b(ProductId paramProductId)
  {
    g localg = new g();
    localg.b = paramProductId;
    localg.c = ("Package " + paramProductId.getPackageId());
    return localg;
  }

  public String toString()
  {
    return "MarketProductExtraInfo{id:" + this.b + ", title:" + this.c + ", formats: " + Arrays.toString(this.f) + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.g
 * JD-Core Version:    0.6.2
 */