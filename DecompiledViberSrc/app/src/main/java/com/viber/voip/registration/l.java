package com.viber.voip.registration;

import android.os.AsyncTask;
import android.support.v4.os.LocaleListCompat;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.m.c;
import com.viber.voip.registration.c.n;
import com.viber.voip.settings.d.ar;
import com.viber.voip.util.da;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.ResponseBody;

public class l
{
  private static final Logger a = ViberEnv.getLogger();
  private final p b;
  private final HardwareParameters c;
  private b d;
  private CountryCode e;
  private boolean f;
  private List<CountryCode> g;
  private String h;

  public l(p paramp, HardwareParameters paramHardwareParameters, b paramb)
  {
    this.b = paramp;
    this.c = paramHardwareParameters;
    this.d = paramb;
  }

  private CountryCode a(String paramString)
  {
    if (da.a(paramString))
      return null;
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      CountryCode localCountryCode = (CountryCode)localIterator.next();
      if (paramString.equalsIgnoreCase(localCountryCode.getCode()))
        return localCountryCode;
    }
    return null;
  }

  private void a(u.a parama)
    throws IOException
  {
    u localu = new u(this.b.a());
    localu.a(parama);
    localu.a();
    localu.c();
  }

  private void a(CountDownLatch paramCountDownLatch)
  {
    try
    {
      paramCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  private List<CountryCode> f()
    throws IOException
  {
    d locald = new d(this.b);
    a(locald);
    Collections.sort(d.a(locald));
    return d.a(locald);
  }

  private CountryCode g()
  {
    return a(this.c.getSimCC());
  }

  public CountryCode a()
    throws Exception
  {
    if ((this.f) && (this.e != null))
      return this.e;
    final CountryCode[] arrayOfCountryCode = new CountryCode[1];
    final Exception[] arrayOfException = new Exception[1];
    com.viber.voip.m.b localb = new com.viber.voip.m.b();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final ag localag = ViberApplication.getInstance().getRequestCreator().a();
    String str = new ar().a(localag.b());
    localb.a(localag.a(), str, new c()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        localAtomicBoolean.set(true);
        CountryCode localCountryCode = l.b(l.this);
        if (localCountryCode != null)
          arrayOfCountryCode[0] = localCountryCode;
        while (true)
        {
          localCountDownLatch.countDown();
          return;
          arrayOfException[0] = new IOException("Data receive failed status = " + paramAnonymousInt + " message " + paramAnonymousString);
        }
      }

      public void a(ResponseBody paramAnonymousResponseBody)
      {
        ar localar = new ar();
        try
        {
          localn = (n)localar.a(localag.c(), paramAnonymousResponseBody);
          if ("0".equals(localn.e()))
            throw new l.c(localn.f());
        }
        catch (l.c localc)
        {
          n localn;
          CountryCode localCountryCode = l.b(l.this);
          if (localCountryCode != null)
          {
            arrayOfCountryCode[0] = localCountryCode;
            while (true)
            {
              localCountDownLatch.countDown();
              return;
              d.ar.a.a(localn.g());
              localObject1 = new CountryCode(localn.b(), localn.a(), localn.c(), localn.d());
              ((CountryCode)localObject1).setDefaultName(l.a(l.this).b(((CountryCode)localObject1).getCode()));
              arrayOfCountryCode[0] = localObject1;
              List localList = l.this.b();
              if ((!localList.isEmpty()) && (arrayOfCountryCode[0] != null) && (arrayOfCountryCode[0].getIddCode() != null))
              {
                i = 0;
                if (i >= localList.size())
                  break label309;
                localObject2 = (CountryCode)localList.get(i);
                if (!arrayOfCountryCode[0].getIddCode().equals(((CountryCode)localObject2).getIddCode()))
                  break;
                if (!arrayOfCountryCode[0].getCode().equals(((CountryCode)localObject2).getCode()))
                  break label288;
                arrayOfCountryCode[0] = localObject2;
              }
            }
          }
        }
        catch (Exception localException)
        {
          while (true)
          {
            int i;
            arrayOfException[0] = localException;
            continue;
            Object localObject2 = localObject1;
            label288: i++;
            Object localObject1 = localObject2;
            continue;
            arrayOfException[0] = localc;
            continue;
            label309: localObject2 = localObject1;
          }
        }
      }
    });
    a(localCountDownLatch);
    if (arrayOfException[0] != null)
    {
      a(null, localAtomicBoolean.get());
      if (this.d != null)
        this.d.a(null);
      throw arrayOfException[0];
    }
    a(arrayOfCountryCode[0], localAtomicBoolean.get());
    if (this.d != null)
      this.d.a(arrayOfCountryCode[0]);
    return arrayOfCountryCode[0];
  }

  public void a(CountryCode paramCountryCode, boolean paramBoolean)
  {
    this.e = paramCountryCode;
    if (!paramBoolean)
      this.f = true;
  }

  public void a(b paramb)
  {
    try
    {
      this.d = paramb;
      if (this.f)
        paramb.a(this.e);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public List<CountryCode> b()
  {
    ArrayList localArrayList = new ArrayList(250);
    String str = Locale.getDefault().getLanguage();
    if ((this.g == null) || (!this.h.equals(str)));
    try
    {
      this.g = f();
      this.h = str;
      label49: if (this.g != null)
        localArrayList.addAll(this.g);
      return localArrayList;
    }
    catch (IOException localIOException)
    {
      break label49;
    }
  }

  public void b(b paramb)
  {
    try
    {
      if (this.d == paramb)
        this.d = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public CountryCode c()
  {
    CountryCode localCountryCode = g();
    LocaleListCompat localLocaleListCompat;
    int i;
    int j;
    if (localCountryCode == null)
    {
      localLocaleListCompat = LocaleListCompat.getDefault();
      if (!localLocaleListCompat.isEmpty())
      {
        i = 0;
        j = localLocaleListCompat.size();
      }
    }
    while (true)
    {
      if (i < j)
      {
        localCountryCode = a(localLocaleListCompat.get(i).getCountry());
        if (localCountryCode == null);
      }
      else
      {
        if (localCountryCode == null)
          localCountryCode = new CountryCode("US", "1", "United States of America", null);
        return localCountryCode;
      }
      i++;
    }
  }

  public void d()
  {
    if ((this.f) && (this.e != null))
      return;
    new a(null).execute(new Void[0]);
  }

  public void e()
  {
    this.f = false;
    this.e = null;
  }

  private class a extends AsyncTask<Void, Integer, Void>
  {
    private a()
    {
    }

    protected Void a(Void[] paramArrayOfVoid)
    {
      try
      {
        l.this.a();
        label8: return null;
      }
      catch (Exception localException)
      {
        break label8;
      }
    }
  }

  public static abstract interface b
  {
    public abstract void a(CountryCode paramCountryCode);
  }

  public static class c extends Exception
  {
    public c(String paramString)
    {
      super();
    }
  }

  private static class d
    implements u.a
  {
    private final p a;
    private final List<CountryCode> b = new ArrayList(255);

    public d(p paramp)
    {
      this.a = paramp;
    }

    public void a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      String str1 = this.a.a(paramString3);
      String str2 = this.a.b(paramString3);
      this.b.add(new CountryCode(paramString1, paramString2, str1, paramString4, str2));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.l
 * JD-Core Version:    0.6.2
 */