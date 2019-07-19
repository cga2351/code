package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.CounterConfiguration.a;
import com.yandex.metrica.impl.bt;

public class ap extends ln<lr, lr.a, lr.b>
{
  ap(lr.b paramb, a parama, mw parammw, t paramt)
  {
    super(paramb, parama, parammw, paramt);
  }

  public void a(t paramt)
  {
    try
    {
      super.a(paramt);
      lr.a locala = (lr.a)b(paramt);
      if (!locala.equals(d()))
      {
        a(new lm.c(c(), locala));
        b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static abstract class a
    implements lo.a<lr.a>
  {
    private final bt a;

    public a(bt parambt)
    {
      this.a = parambt;
    }

    public lr.a a(lr.a parama, t paramt)
    {
      CounterConfiguration localCounterConfiguration = paramt.b();
      boolean bool = a(this.a, paramt.b());
      if (parama == null)
        return new lr.a(localCounterConfiguration.e(), localCounterConfiguration.h(), localCounterConfiguration.i(), localCounterConfiguration.f(), localCounterConfiguration.g(), localCounterConfiguration.l(), localCounterConfiguration.n(), localCounterConfiguration.m(), localCounterConfiguration.j(), localCounterConfiguration.d(), localCounterConfiguration.c(), localCounterConfiguration.b(), localCounterConfiguration.k(), Boolean.valueOf(bool));
      String str1 = localCounterConfiguration.e();
      String str2 = parama.b;
      String str3;
      String str4;
      String str5;
      label129: String str6;
      String str7;
      String str8;
      label153: String str9;
      String str10;
      String str11;
      label177: String str12;
      Boolean localBoolean1;
      Boolean localBoolean2;
      label201: Boolean localBoolean3;
      Location localLocation1;
      Location localLocation2;
      label225: Location localLocation3;
      Boolean localBoolean4;
      Boolean localBoolean5;
      label249: Boolean localBoolean6;
      Boolean localBoolean7;
      Boolean localBoolean8;
      label273: Boolean localBoolean9;
      CounterConfiguration.a locala;
      Integer localInteger1;
      Integer localInteger2;
      label303: Integer localInteger3;
      Integer localInteger4;
      Integer localInteger5;
      label327: Integer localInteger6;
      Integer localInteger7;
      Integer localInteger8;
      label351: Integer localInteger9;
      Boolean localBoolean10;
      Boolean localBoolean11;
      if (str1 == null)
      {
        str3 = (String)str2;
        str4 = localCounterConfiguration.h();
        str5 = parama.c;
        if (str4 != null)
          break label424;
        str6 = (String)str5;
        str7 = localCounterConfiguration.i();
        str8 = parama.d;
        if (str7 != null)
          break label431;
        str9 = (String)str8;
        str10 = localCounterConfiguration.f();
        str11 = parama.a;
        if (str10 != null)
          break label438;
        str12 = (String)str11;
        localBoolean1 = localCounterConfiguration.g();
        localBoolean2 = parama.e;
        if (localBoolean1 != null)
          break label445;
        localBoolean3 = (Boolean)localBoolean2;
        localLocation1 = localCounterConfiguration.l();
        localLocation2 = parama.f;
        if (localLocation1 != null)
          break label452;
        localLocation3 = (Location)localLocation2;
        localBoolean4 = localCounterConfiguration.n();
        localBoolean5 = parama.g;
        if (localBoolean4 != null)
          break label459;
        localBoolean6 = (Boolean)localBoolean5;
        localBoolean7 = localCounterConfiguration.m();
        localBoolean8 = parama.h;
        if (localBoolean7 != null)
          break label466;
        localBoolean9 = (Boolean)localBoolean8;
        locala = localCounterConfiguration.j();
        localInteger1 = localCounterConfiguration.d();
        localInteger2 = parama.i;
        if (localInteger1 != null)
          break label473;
        localInteger3 = (Integer)localInteger2;
        localInteger4 = localCounterConfiguration.c();
        localInteger5 = parama.j;
        if (localInteger4 != null)
          break label480;
        localInteger6 = (Integer)localInteger5;
        localInteger7 = localCounterConfiguration.b();
        localInteger8 = parama.k;
        if (localInteger7 != null)
          break label487;
        localInteger9 = (Integer)localInteger8;
        localBoolean10 = localCounterConfiguration.k();
        localBoolean11 = parama.l;
        if (localBoolean10 != null)
          break label494;
      }
      while (true)
      {
        return new lr.a(str3, str6, str9, str12, localBoolean3, localLocation3, localBoolean6, localBoolean9, locala, localInteger3, localInteger6, localInteger9, (Boolean)localBoolean11, Boolean.valueOf(bool));
        str2 = str1;
        break;
        label424: str5 = str4;
        break label129;
        label431: str8 = str7;
        break label153;
        label438: str11 = str10;
        break label177;
        label445: localBoolean2 = localBoolean1;
        break label201;
        label452: localLocation2 = localLocation1;
        break label225;
        label459: localBoolean5 = localBoolean4;
        break label249;
        label466: localBoolean8 = localBoolean7;
        break label273;
        label473: localInteger2 = localInteger1;
        break label303;
        label480: localInteger5 = localInteger4;
        break label327;
        label487: localInteger8 = localInteger7;
        break label351;
        label494: localBoolean11 = localBoolean10;
      }
    }

    protected boolean a(bt parambt, CounterConfiguration paramCounterConfiguration)
    {
      return oq.a(paramCounterConfiguration.o(), true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ap
 * JD-Core Version:    0.6.2
 */