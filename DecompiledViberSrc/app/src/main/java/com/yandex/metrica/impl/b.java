package com.yandex.metrica.impl;

import android.util.Pair;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.ph;
import com.yandex.metrica.impl.ob.pk;
import com.yandex.metrica.impl.ob.pn;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private JSONObject a = new JSONObject();
  private long b;
  private boolean c;
  private pk d;

  public b(String paramString, long paramLong, of paramof)
  {
    this.b = paramLong;
    try
    {
      this.a = new JSONObject(paramString);
      this.d = new pk(30, 50, 100, "App Environment", paramof);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        this.a = new JSONObject();
        this.b = 0L;
      }
    }
  }

  private void b(String paramString1, String paramString2)
  {
    try
    {
      String str1 = this.d.a().a(paramString1);
      String str2 = this.d.b().a(paramString2);
      if (this.a.has(str1))
      {
        String str3 = this.a.getString(str1);
        if ((str2 == null) || (!str2.equals(str3)))
          a(str1, str2);
      }
      while (true)
      {
        label74: return;
        if (str2 != null)
          a(str1, str2);
      }
    }
    catch (JSONException localJSONException)
    {
      break label74;
    }
    finally
    {
    }
  }

  public void a()
  {
    try
    {
      this.a = new JSONObject();
      this.b = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Pair<String, String> paramPair)
  {
    try
    {
      b((String)paramPair.first, (String)paramPair.second);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(String paramString1, String paramString2)
    throws JSONException
  {
    try
    {
      if ((this.a.length() < this.d.c().a()) || ((this.d.c().a() == this.a.length()) && (this.a.has(paramString1))))
      {
        this.a.put(paramString1, paramString2);
        this.c = true;
      }
      while (true)
      {
        return;
        this.d.a(paramString1);
      }
    }
    finally
    {
    }
  }

  public a b()
  {
    try
    {
      if (this.c)
      {
        this.b = (1L + this.b);
        this.c = false;
      }
      a locala = new a(this.a.toString(), this.b);
      return locala;
    }
    finally
    {
    }
  }

  public String toString()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("Map size ");
      localStringBuilder.append(this.a.length());
      localStringBuilder.append(". Is changed ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(". Current revision ");
      localStringBuilder.append(this.b);
      String str = localStringBuilder.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static final class a
  {
    public final String a;
    public final long b;

    public a(String paramString, long paramLong)
    {
      this.a = paramString;
      this.b = paramLong;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
        if (this.b != locala.b)
          return false;
        if (this.a == null)
          break;
      }
      while (this.a.equals(locala.a));
      while (locala.a != null)
        return false;
      return true;
    }

    public int hashCode()
    {
      if (this.a != null);
      for (int i = this.a.hashCode(); ; i = 0)
        return i * 31 + (int)(this.b ^ this.b >>> 32);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.b
 * JD-Core Version:    0.6.2
 */