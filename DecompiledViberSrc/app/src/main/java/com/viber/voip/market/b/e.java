package com.viber.voip.market.b;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.market.MarketApi.f;
import com.viber.voip.util.dd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static final Logger a = ViberEnv.getLogger();
  private MarketApi.f b;

  private String a(ArrayList<String> paramArrayList)
  {
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
        localJSONArray.put((String)localIterator.next());
    }
    catch (JSONException localJSONException)
    {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("destinations", localJSONArray);
    String str = localJSONObject.toString();
    return str;
  }

  public void a(final int paramInt, MarketApi.f paramf)
  {
    this.b = paramf;
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        Engine localEngine = ViberApplication.getInstance().getEngine(true);
        Set localSet = ViberApplication.getInstance().getContactManager().c().a();
        HashMap localHashMap = new HashMap();
        Iterator localIterator1 = localSet.iterator();
        while (localIterator1.hasNext())
        {
          String str1 = (String)localIterator1.next();
          CountryNameInfo localCountryNameInfo = localEngine.getPhoneController().getCountryName(str1);
          if (localCountryNameInfo != null)
          {
            String str2 = localCountryNameInfo.countryShortName;
            e.a locala = (e.a)localHashMap.get(str2);
            if (locala == null)
            {
              locala = new e.a(str2);
              localHashMap.put(str2, locala);
            }
            locala.b = (1 + locala.b);
          }
        }
        ArrayList localArrayList1 = new ArrayList(localHashMap.values());
        Collections.sort(localArrayList1, new Comparator()
        {
          public int a(e.a paramAnonymous2a1, e.a paramAnonymous2a2)
          {
            if (paramAnonymous2a1.b == paramAnonymous2a2.b)
              return paramAnonymous2a1.a.compareTo(paramAnonymous2a2.a);
            return paramAnonymous2a2.b - paramAnonymous2a1.b;
          }
        });
        Iterator localIterator2 = localArrayList1.iterator();
        while (localIterator2.hasNext())
          ((e.a)localIterator2.next());
        final ArrayList localArrayList2 = new ArrayList();
        int i = Math.min(paramInt, localArrayList1.size());
        for (int j = 0; j < i; j++)
          localArrayList2.add(((e.a)localArrayList1.get(j)).a);
        dd.a(new Runnable()
        {
          public void run()
          {
            e.a(e.this).a(e.a(e.this, localArrayList2));
          }
        });
      }
    });
  }

  private static class a
  {
    public final String a;
    public int b;

    public a(String paramString)
    {
      this.a = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.e
 * JD-Core Version:    0.6.2
 */