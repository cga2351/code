package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cj extends ci
{
  public cj(ab paramab)
  {
    super(paramab);
  }

  public boolean a(i parami)
  {
    ab localab = a();
    fw localfw;
    HashSet localHashSet;
    if ((localab.B().d()) && (localab.A()))
    {
      localfw = localab.G();
      localHashSet = b();
    }
    try
    {
      ArrayList localArrayList = c();
      if (nu.a(localHashSet, localArrayList))
      {
        localab.q();
      }
      else
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
          localJSONArray.put(((hj)localIterator.next()).a());
        String str = new JSONObject().put("features", localJSONArray).toString();
        localab.g(new i(parami).a(s.a.H.a()).c(str));
        localfw.c(localJSONArray.toString());
      }
      label159: return false;
    }
    catch (JSONException localJSONException)
    {
      break label159;
    }
  }

  HashSet<hj> b()
  {
    String str = a().G().b();
    if (TextUtils.isEmpty(str))
      return null;
    try
    {
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = new JSONArray(str);
      for (int i = 0; i < localJSONArray.length(); i++)
        localHashSet.add(new hj(localJSONArray.getJSONObject(i)));
      return localHashSet;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  ArrayList<hj> c()
  {
    ArrayList localArrayList;
    try
    {
      ab localab = a();
      PackageInfo localPackageInfo = localab.c().getPackageManager().getPackageInfo(localab.c().getPackageName(), 16384);
      localArrayList = new ArrayList();
      if (bw.a(24));
      hi.b localb;
      for (Object localObject = new hi.a(); localPackageInfo.reqFeatures != null; localObject = localb)
      {
        FeatureInfo[] arrayOfFeatureInfo = localPackageInfo.reqFeatures;
        int i = arrayOfFeatureInfo.length;
        for (int j = 0; j < i; j++)
          localArrayList.add(((hi)localObject).b(arrayOfFeatureInfo[j]));
        localb = new hi.b();
      }
    }
    catch (Exception localException)
    {
      localArrayList = null;
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cj
 * JD-Core Version:    0.6.2
 */