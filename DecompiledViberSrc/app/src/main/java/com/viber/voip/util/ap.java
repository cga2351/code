package com.viber.voip.util;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ap
{
  private static final Logger a = ViberEnv.getLogger();
  private static SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
  private long c;
  private long d;
  private long e;
  private long f;
  private boolean g;
  private Calendar h = Calendar.getInstance();
  private long i = b(System.currentTimeMillis());
  private long j = this.i + this.f;

  private String a(long paramLong)
  {
    return b.format(new Date(paramLong));
  }

  private void a(String paramString, a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("count", parama.b);
      localJSONObject.put("global_count", parama.c);
      localJSONObject.put("time", parama.a);
      e.a("-2", paramString, localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private long b(long paramLong)
  {
    this.h.setTimeInMillis(paramLong);
    if (!this.g)
    {
      this.h.set(11, 0);
      this.h.set(12, 0);
    }
    while (true)
    {
      this.h.set(13, 0);
      this.h.set(14, 0);
      return this.h.getTimeInMillis();
      this.h.set(12, 3 * (this.h.get(12) / 3));
    }
  }

  // ERROR //
  private a g(String paramString)
  {
    // Byte code:
    //   0: ldc 114
    //   2: aload_1
    //   3: invokestatic 150	com/viber/voip/model/e:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +76 -> 84
    //   11: new 89	org/json/JSONObject
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 153	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_3
    //   20: new 94	com/viber/voip/util/ap$a
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 156	com/viber/voip/util/ap$a:<init>	(Lcom/viber/voip/util/ap;)V
    //   28: astore 4
    //   30: aload 4
    //   32: aload_3
    //   33: ldc 92
    //   35: invokevirtual 160	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   38: putfield 97	com/viber/voip/util/ap$a:b	I
    //   41: aload 4
    //   43: aload_3
    //   44: ldc 107
    //   46: invokevirtual 164	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   49: putfield 109	com/viber/voip/util/ap$a:a	J
    //   52: aload_3
    //   53: ldc 103
    //   55: invokevirtual 168	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   58: ifeq +14 -> 72
    //   61: aload 4
    //   63: aload_3
    //   64: ldc 103
    //   66: invokevirtual 160	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   69: putfield 105	com/viber/voip/util/ap$a:c	I
    //   72: aload 4
    //   74: areturn
    //   75: astore 6
    //   77: aconst_null
    //   78: areturn
    //   79: astore 5
    //   81: aload 4
    //   83: areturn
    //   84: aconst_null
    //   85: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   11	30	75	org/json/JSONException
    //   30	72	79	org/json/JSONException
  }

  private void h(String paramString)
  {
    e.a("-2", new String[] { paramString });
  }

  private long i(String paramString)
  {
    try
    {
      a locala = g(paramString);
      if (locala == null)
        locala = new a();
      locala.b();
      long l = locala.c;
      a(paramString, locala);
      return l;
    }
    finally
    {
    }
  }

  public void a(String paramString)
  {
    try
    {
      if (cj.b(ViberApplication.getApplication()))
        i(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString, int paramInt)
  {
    if (((paramInt > 0) && (paramInt < 200)) || (paramInt >= 300))
      a(paramString);
  }

  public long b(String paramString)
  {
    return i(paramString);
  }

  public boolean c(String paramString)
  {
    try
    {
      a locala = g(paramString);
      boolean bool1;
      if (locala != null)
        bool1 = locala.d();
      for (boolean bool2 = bool1; ; bool2 = true)
        return bool2;
    }
    finally
    {
    }
  }

  public void d(String paramString)
  {
    if (paramString != null);
    try
    {
      h(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void e(String paramString)
  {
    if (paramString != null);
    try
    {
      h(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void f(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      try
      {
        a locala = g(paramString);
        if (locala == null)
          continue;
        locala.a = 0L;
        a(paramString, locala);
      }
      finally
      {
      }
    }
  }

  class a
  {
    long a;
    int b;
    int c;

    a()
    {
    }

    long a()
    {
      switch (this.b)
      {
      default:
        return Math.max(c(), this.a + ap.c(ap.this));
      case 0:
        return System.currentTimeMillis();
      case 1:
        return this.a + ap.a(ap.this);
      case 2:
        return this.a + ap.b(ap.this);
      case 3:
      }
      return this.a + ap.c(ap.this);
    }

    void b()
    {
      if ((this.b >= 4) && (d()))
        this.b = 0;
      this.b = (1 + this.b);
      this.c = (1 + this.c);
      this.a = System.currentTimeMillis();
    }

    long c()
    {
      long l = System.currentTimeMillis();
      if (l >= ap.d(ap.this))
      {
        ap.a(ap.this, ap.b(ap.this, l));
        ap.c(ap.this, ap.e(ap.this) + ap.f(ap.this));
      }
      if (this.a < ap.e(ap.this))
      {
        this.b = 0;
        return l;
      }
      return ap.d(ap.this);
    }

    boolean d()
    {
      return System.currentTimeMillis() >= a();
    }

    public String toString()
    {
      return "Item{count:" + this.b + "/" + this.c + " next:" + ap.d(ap.this, a()) + "}";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ap
 * JD-Core Version:    0.6.2
 */