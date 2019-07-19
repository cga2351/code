package com.viber.voip.stickers;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.schedule.d.c;
import com.viber.voip.stickers.entity.a;
import org.json.JSONException;
import org.json.JSONObject;

public class m extends n
  implements d.c
{
  private static final Logger a = ViberEnv.getLogger();
  private int b;
  private boolean c = false;
  private Context d;
  private i e;

  m(Context paramContext, i parami)
  {
    this.d = paramContext.getApplicationContext();
    this.e = parami;
  }

  private void a()
  {
    this.c = true;
    this.b = this.e.m();
  }

  private int b(JSONObject paramJSONObject)
  {
    int i;
    if (this.b > 0)
      i = this.b;
    try
    {
      while (true)
      {
        JSONObject localJSONObject = (JSONObject)paramJSONObject.get("default");
        int j = ((Integer)new r()
        {
          public Integer a(JSONObject paramAnonymousJSONObject, String paramAnonymousString)
            throws JSONException
          {
            return Integer.valueOf(paramAnonymousJSONObject.getInt(paramAnonymousString));
          }
        }
        .a(this.d, localJSONObject)).intValue();
        return j;
        i = 400;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return i;
  }

  private void b(int paramInt)
  {
    if (this.b != paramInt)
      this.e.e(paramInt);
  }

  void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(JSONObject paramJSONObject)
  {
    if (!this.c)
      a();
    b(b(paramJSONObject));
  }

  public void onStickerPackageDeployed(a parama)
  {
    if ((parama.o()) && (parama.e() != 400))
      this.e.f(parama.e());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.m
 * JD-Core Version:    0.6.2
 */