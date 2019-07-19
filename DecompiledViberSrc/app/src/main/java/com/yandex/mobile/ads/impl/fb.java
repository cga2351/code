package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.ReporterConfig.Builder;
import com.yandex.metrica.YandexMetrica;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class fb
{
  private static final Object a = new Object();
  private static volatile fb b;
  private final IReporter c;
  private final fc d;
  private final fa e;

  private fb(IReporter paramIReporter, fc paramfc, fa paramfa)
  {
    this.c = paramIReporter;
    this.d = paramfc;
    this.e = paramfa;
    this.d.a(paramIReporter);
  }

  public static fb a(Context paramContext)
  {
    if (b == null);
    while (true)
    {
      synchronized (a)
      {
        String str;
        fc localfc;
        fa localfa;
        if (b == null)
        {
          if (!fl.a(paramContext))
            continue;
          str = "322a737a-a0ca-44e0-bc85-649b1c7c1db6";
          localfc = new fc(ah.a());
          localfa = new fa();
        }
        try
        {
          ReporterConfig.Builder localBuilder = ReporterConfig.newConfigBuilder(str);
          et localet = es.a().a(paramContext);
          if ((localet != null) && (localet.c()))
          {
            bool = true;
            YandexMetrica.activateReporter(paramContext, localBuilder.withStatisticsSending(bool).build());
            b = new fb(YandexMetrica.getReporter(paramContext.getApplicationContext(), str), localfc, localfa);
            return b;
            str = "478cb909-6ad1-4e12-84cc-b3629a789f93";
          }
        }
        catch (Throwable localThrowable)
        {
          b = new fb(null, localfc, localfa);
          continue;
        }
      }
      boolean bool = false;
    }
  }

  public final void a(fd paramfd)
  {
    if ((es.a().b()) && (this.c != null))
    {
      String str1 = paramfd.b();
      Map localMap = paramfd.a();
      try
      {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = localMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str2 = (String)localEntry.getKey();
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localEntry.getValue();
          localHashMap.put(str2, Arrays.deepToString(arrayOfObject));
        }
        new StringBuilder("reportEvent(), eventName = ").append(str1).append(", reportData = ").append(localHashMap);
        this.c.reportEvent(str1, localMap);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fb
 * JD-Core Version:    0.6.2
 */