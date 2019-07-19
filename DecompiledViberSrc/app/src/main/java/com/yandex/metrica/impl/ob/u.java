package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.yandex.metrica.g;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class u
{
  public static final String a = UUID.randomUUID().toString();
  private final ContentValues b;

  private u(ContentValues paramContentValues)
  {
    if (paramContentValues == null)
      paramContentValues = new ContentValues();
    this.b = paramContentValues;
  }

  public u(Context paramContext)
  {
    this.b = new ContentValues();
    this.b.put("PROCESS_CFG_PROCESS_ID", Integer.valueOf(Process.myPid()));
    this.b.put("PROCESS_CFG_PROCESS_SESSION_ID", a);
    this.b.put("PROCESS_CFG_SDK_API_LEVEL", Integer.valueOf(72));
    this.b.put("PROCESS_CFG_PACKAGE_NAME", paramContext.getPackageName());
  }

  public u(u paramu)
  {
    try
    {
      this.b = new ContentValues(paramu.b);
      return;
    }
    finally
    {
    }
  }

  public static u a(Bundle paramBundle)
  {
    if (paramBundle != null)
      try
      {
        ContentValues localContentValues = (ContentValues)paramBundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT");
        if (localContentValues == null)
          return null;
        u localu = new u(localContentValues);
        return localu;
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
    return null;
  }

  public void a(g paramg)
  {
    int i = 1;
    if (paramg != null);
    while (true)
    {
      try
      {
        if (paramg.d == null)
          break label85;
        j = i;
        if (j != 0)
          a(paramg.d);
        if (paramg.b == null)
          break label91;
        k = i;
        if (k != 0)
          a(ol.c(paramg.b));
        if (paramg.c == null)
          break label97;
        if (i != 0)
          a(paramg.c);
        return;
      }
      finally
      {
      }
      return;
      label85: int j = 0;
      continue;
      label91: int k = 0;
      continue;
      label97: i = 0;
    }
  }

  public void a(String paramString)
  {
    try
    {
      this.b.put("PROCESS_CFG_DISTRIBUTION_REFERRER", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(List<String> paramList)
  {
    try
    {
      this.b.put("PROCESS_CFG_CUSTOM_HOSTS", nz.a(paramList));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Map<String, String> paramMap)
  {
    try
    {
      this.b.put("PROCESS_CFG_CLIDS", nz.a(paramMap));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean a()
  {
    return this.b.containsKey("PROCESS_CFG_CUSTOM_HOSTS");
  }

  public List<String> b()
  {
    String str = this.b.getAsString("PROCESS_CFG_CUSTOM_HOSTS");
    if (TextUtils.isEmpty(str))
      return null;
    return nz.b(str);
  }

  public void b(Bundle paramBundle)
  {
    try
    {
      paramBundle.putParcelable("CFG_KEY_PROCESS_ENVIRONMENT", this.b);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Map<String, String> c()
  {
    return nz.a(this.b.getAsString("PROCESS_CFG_CLIDS"));
  }

  public String d()
  {
    return this.b.getAsString("PROCESS_CFG_DISTRIBUTION_REFERRER");
  }

  public Integer e()
  {
    return this.b.getAsInteger("PROCESS_CFG_PROCESS_ID");
  }

  public String f()
  {
    return this.b.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
  }

  public int g()
  {
    return this.b.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue();
  }

  public String h()
  {
    return this.b.getAsString("PROCESS_CFG_PACKAGE_NAME");
  }

  public String toString()
  {
    try
    {
      String str = "ProcessConfiguration{mParamsMapping=" + this.b + '}';
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.u
 * JD-Core Version:    0.6.2
 */