package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class jh
{
  private static final jo d = new jo("UNDEFINED_");
  protected jo a;
  protected final String b;
  protected final SharedPreferences c;
  private final Map<String, Object> e = new HashMap();
  private boolean f = false;

  public jh(Context paramContext, String paramString)
  {
    this.b = paramString;
    this.c = jp.a(paramContext, f());
    this.a = new jo(d.a(), this.b);
  }

  protected <T extends jh> T a(String paramString, Object paramObject)
  {
    if (paramObject != null);
    try
    {
      this.e.put(paramString, paramObject);
      return this;
    }
    finally
    {
    }
  }

  protected abstract String f();

  protected <T extends jh> T h()
  {
    try
    {
      this.f = true;
      this.e.clear();
      return this;
    }
    finally
    {
    }
  }

  protected <T extends jh> T h(String paramString)
  {
    try
    {
      this.e.put(paramString, this);
      return this;
    }
    finally
    {
    }
  }

  protected String i()
  {
    return this.b;
  }

  public void j()
  {
    while (true)
    {
      SharedPreferences.Editor localEditor;
      String str;
      Object localObject2;
      try
      {
        localEditor = this.c.edit();
        if (this.f)
        {
          localEditor.clear();
          localEditor.apply();
          this.e.clear();
          this.f = false;
          return;
        }
        Iterator localIterator = this.e.entrySet().iterator();
        if (!localIterator.hasNext())
          break label250;
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        str = (String)localEntry.getKey();
        localObject2 = localEntry.getValue();
        if (localObject2 == this)
        {
          localEditor.remove(str);
          continue;
        }
      }
      finally
      {
      }
      if ((localObject2 instanceof String))
      {
        localEditor.putString(str, (String)localObject2);
      }
      else if ((localObject2 instanceof Long))
      {
        localEditor.putLong(str, ((Long)localObject2).longValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        localEditor.putInt(str, ((Integer)localObject2).intValue());
      }
      else if ((localObject2 instanceof Boolean))
      {
        localEditor.putBoolean(str, ((Boolean)localObject2).booleanValue());
      }
      else if (localObject2 != null)
      {
        throw new UnsupportedOperationException();
        label250: localEditor.apply();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jh
 * JD-Core Version:    0.6.2
 */