package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class je
{
  private Context a;

  public je(Context paramContext)
  {
    this.a = paramContext;
  }

  private static List<String> a(Map<String, ?> paramMap, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(paramString))
        localArrayList.add(str.replace(paramString, ""));
    }
    return localArrayList;
  }

  private void a(fk paramfk, String paramString)
  {
    fz localfz = new fz(paramfk, paramString);
    jm localjm = new jm(this.a, paramString);
    String str1 = localjm.b(null);
    if (!TextUtils.isEmpty(str1))
      localfz.a(str1);
    String str2 = localjm.a();
    if (!TextUtils.isEmpty(str2))
      localfz.h(str2);
    String str3 = localjm.d(null);
    if (!TextUtils.isEmpty(str3))
      localfz.g(str3);
    String str4 = localjm.f(null);
    if (!TextUtils.isEmpty(str4))
      localfz.e(str4);
    String str5 = localjm.g(null);
    if (!TextUtils.isEmpty(str5))
      localfz.d(str5);
    String str6 = localjm.c(null);
    if (!TextUtils.isEmpty(str6))
      localfz.f(str6);
    long l = localjm.a(-1L);
    if (l != -1L)
      localfz.a(l);
    String str7 = localjm.e(null);
    if (!TextUtils.isEmpty(str7))
      localfz.c(str7);
    localfz.i();
    localjm.b();
  }

  public void a()
  {
    SharedPreferences localSharedPreferences = jp.a(this.a, "_bidoptpreferences");
    if (localSharedPreferences.getAll().size() > 0)
    {
      String str1 = localSharedPreferences.getString(jm.d.a(), null);
      jm localjm1 = new jm(this.a);
      if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(localjm1.a(null))))
      {
        localjm1.j(str1).j();
        localSharedPreferences.edit().remove(jm.d.a()).apply();
      }
      Map localMap = localSharedPreferences.getAll();
      if (localMap.size() > 0)
      {
        Iterator localIterator = a(localMap, jm.e.a()).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          String str3 = localSharedPreferences.getString(new jo(jm.e.a(), str2).b(), null);
          jm localjm2 = new jm(this.a, str2);
          if ((!TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(localjm2.b(null))))
            localjm2.i(str3).j();
        }
      }
      localSharedPreferences.edit().clear().apply();
    }
  }

  public void b()
  {
    fk localfk = fj.a(this.a).e();
    SharedPreferences localSharedPreferences = jp.a(this.a, "_startupserviceinfopreferences");
    fz localfz1 = new fz(localfk, null);
    String str = localSharedPreferences.getString(jm.d.a(), null);
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty(localfz1.a().b)))
    {
      localfz1.b(str).i();
      localSharedPreferences.edit().remove(jm.d.a()).apply();
    }
    fz localfz2 = new fz(localfk, this.a.getPackageName());
    boolean bool = localSharedPreferences.getBoolean(jm.f.a(), false);
    if (bool)
      localfz2.a(bool).i();
    a(localfk, this.a.getPackageName());
    Iterator localIterator = a(localSharedPreferences.getAll(), jm.e.a()).iterator();
    while (localIterator.hasNext())
      a(localfk, (String)localIterator.next());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.je
 * JD-Core Version:    0.6.2
 */