package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.telephony.TelephonyManager;
import com.yandex.metrica.impl.bw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nl
  implements nq<List<String>>
{
  private final nj a;
  private iv b;

  nl(nj paramnj, iv paramiv)
  {
    this.a = paramnj;
    this.b = paramiv;
  }

  @SuppressLint({"MissingPermission", "HardwareIds"})
  private String b()
  {
    try
    {
      boolean bool = this.b.d(this.a.d());
      Object localObject = null;
      if (bool)
      {
        String str = this.a.c().getDeviceId();
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  @TargetApi(23)
  private List<String> c()
  {
    HashSet localHashSet = new HashSet();
    try
    {
      if (this.b.d(this.a.d()))
        for (int i = 0; i < 10; i++)
        {
          String str = this.a.c().getDeviceId(i);
          if (str != null)
            localHashSet.add(str);
        }
    }
    catch (Exception localException)
    {
    }
    return new ArrayList(localHashSet);
  }

  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a.g())
    {
      if (bw.a(23))
        localArrayList.addAll(c());
    }
    else
      return localArrayList;
    localArrayList.add(b());
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nl
 * JD-Core Version:    0.6.2
 */