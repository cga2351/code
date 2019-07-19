package com.viber.voip.stickers;

import android.content.Context;
import android.util.SparseArray;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.schedule.d.c;
import com.viber.voip.settings.d.ad;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.stickers.entity.b;
import com.viber.voip.util.cj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class t
  implements d.c
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private i c;

  t(Context paramContext, i parami)
  {
    this.b = paramContext;
    this.c = parami;
  }

  private void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    SparseArray localSparseArray = d(paramJSONObject);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = this.c.h().iterator();
    while (localIterator1.hasNext())
    {
      a locala2 = (a)localIterator1.next();
      a locala = (a)localSparseArray.get(locala2.e());
      if (locala != null)
      {
        b localb = (b)locala2;
        if (locala.b > localb.B())
        {
          localb.a(locala.b);
          if ((!locala2.o()) && (!locala.c));
          for (boolean bool = true; ; bool = false)
          {
            localb.a(bool);
            localArrayList1.add(localb);
            if ((localb.h()) && (!localb.i()))
              break;
            localb.g(true);
            localArrayList2.add(localb);
            break;
          }
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.c.b(localArrayList1);
      if (1 == cj.a(this.b).a())
      {
        Iterator localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          a locala1 = (a)localIterator2.next();
          this.c.a(locala1);
        }
      }
    }
  }

  private void c(JSONObject paramJSONObject)
  {
    d.ad.e.a(paramJSONObject.toString());
  }

  private SparseArray<a> d(JSONObject paramJSONObject)
  {
    SparseArray localSparseArray = new SparseArray();
    try
    {
      JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get("updates");
      Iterator localIterator = localJSONObject1.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          int i = Integer.parseInt(str);
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str);
          localSparseArray.put(i, new a(i, (float)localJSONObject2.getDouble("version"), localJSONObject2.optBoolean("silent", false)));
        }
        catch (JSONException localJSONException2)
        {
        }
      }
    }
    catch (JSONException localJSONException1)
    {
    }
    return localSparseArray;
  }

  public Float a(int paramInt)
  {
    String str = d.ad.e.d();
    if (str != null)
      try
      {
        a locala = (a)d(new JSONObject(str)).get(paramInt);
        if (locala != null)
        {
          Float localFloat = Float.valueOf(locala.b);
          return localFloat;
        }
      }
      catch (Exception localException)
      {
      }
    return null;
  }

  public void a(JSONObject paramJSONObject)
  {
    try
    {
      b(paramJSONObject);
      return;
    }
    catch (Exception localException)
    {
      a.a(localException, null);
    }
  }

  private class a
  {
    public final int a;
    public final float b;
    public final boolean c;

    public a(int paramFloat, float paramBoolean, boolean arg4)
    {
      this.a = paramFloat;
      this.b = paramBoolean;
      boolean bool;
      this.c = bool;
    }

    public String toString()
    {
      return "ServerPackageInfo [packageId=" + this.a + ", version=" + this.b + ", isSilent=" + this.c + "]";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.t
 * JD-Core Version:    0.6.2
 */