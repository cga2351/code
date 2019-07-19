package com.viber.voip.stickers;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.schedule.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  implements d.c
{
  private static final Logger a = ViberEnv.getLogger();
  private List<Integer> b = new ArrayList();
  private boolean c = false;
  private Context d;
  private i e;

  s(Context paramContext, i parami)
  {
    this.d = paramContext.getApplicationContext();
    this.e = parami;
  }

  private void a()
  {
    this.c = true;
    this.b = this.e.l();
  }

  private void a(ArrayList<Integer> paramArrayList)
  {
    if (!paramArrayList.equals(this.b))
    {
      this.b = paramArrayList;
      this.e.a(this.b);
    }
  }

  private ArrayList<Integer> b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get("promo");
        JSONArray localJSONArray = (JSONArray)new r()
        {
          public JSONArray a(JSONObject paramAnonymousJSONObject, String paramAnonymousString)
            throws JSONException
          {
            return paramAnonymousJSONObject.getJSONArray(paramAnonymousString);
          }
        }
        .a(this.d, localJSONObject1);
        long l1 = System.currentTimeMillis() / 1000L;
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
            if (!localJSONObject2.has("id"))
              break label168;
            Integer localInteger = Integer.valueOf(localJSONObject2.getInt("id"));
            if (!localJSONObject2.has("expires"))
              break label162;
            l2 = localJSONObject2.getLong("expires");
            Long localLong = Long.valueOf(l2);
            if ((localLong.longValue() != 0L) && (l1 >= localLong.longValue()))
              break label168;
            localArrayList.add(localInteger);
          }
        }
      }
      catch (JSONException localJSONException)
      {
      }
      return localArrayList;
      label162: long l2 = 0L;
      continue;
      label168: i++;
    }
  }

  public void a(JSONObject paramJSONObject)
  {
    if (!this.c)
      a();
    a(b(paramJSONObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.s
 * JD-Core Version:    0.6.2
 */