package com.my.target;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public abstract class al
{
  private final Map<String, String> a = new HashMap();

  protected Map<String, String> a()
  {
    try
    {
      Map localMap = this.a;
      return localMap;
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
      paramMap.putAll(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected boolean a(String paramString)
  {
    try
    {
      if (this.a.containsKey(paramString))
      {
        this.a.remove(paramString);
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  protected boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool2;
      if (!TextUtils.isEmpty(paramString1))
        if (paramString2 == null)
        {
          boolean bool1 = a(paramString1);
          bool2 = bool1;
        }
      while (true)
      {
        return bool2;
        this.a.put(paramString1, paramString2);
        bool2 = true;
        continue;
        bool2 = false;
      }
    }
    finally
    {
    }
  }

  protected void b()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.al
 * JD-Core Version:    0.6.2
 */