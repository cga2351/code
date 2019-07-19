package com.viber.voip.messages.controller.manager;

import com.viber.voip.util.da;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

public class f
{
  private final int a;
  private final a b;
  private final HashMap<String, String> c;

  public f(int paramInt)
  {
    this(new b(null), paramInt);
  }

  public f(a parama, int paramInt)
  {
    this.a = paramInt;
    this.b = parama;
    this.c = new LinkedHashMap()
    {
      protected boolean removeEldestEntry(Map.Entry<String, String> paramAnonymousEntry)
      {
        return size() > f.a(f.this);
      }
    };
  }

  private boolean b(String paramString1, String paramString2)
  {
    return (!da.a(paramString1)) && (paramString2.equals(this.c.get(d(paramString1))));
  }

  private void c(String paramString)
  {
    if (!da.a(paramString))
      this.c.remove(d(paramString));
  }

  private static String d(String paramString)
  {
    if (paramString != null)
      return paramString.toLowerCase(Locale.US);
    return null;
  }

  public String a(String paramString)
  {
    if (da.a(paramString))
      return "";
    String str = this.b.a();
    this.c.put(d(paramString), str);
    return str;
  }

  public void a()
  {
    this.c.clear();
  }

  public boolean a(String paramString1, String paramString2)
  {
    if (b(paramString1, paramString2))
    {
      c(paramString1);
      return true;
    }
    return false;
  }

  public boolean b(String paramString)
  {
    return (!da.a(paramString)) && (this.c.containsKey(d(paramString)));
  }

  public static abstract interface a
  {
    public abstract String a();
  }

  private static class b
    implements f.a
  {
    private static final AtomicLong a = new AtomicLong();

    public String a()
    {
      return String.valueOf(a.incrementAndGet());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.f
 * JD-Core Version:    0.6.2
 */