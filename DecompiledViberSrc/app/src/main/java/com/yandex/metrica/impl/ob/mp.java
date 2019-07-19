package com.yandex.metrica.impl.ob;

import com.yandex.metrica.CounterConfiguration;
import java.util.List;
import java.util.Map;

public class mp extends lo<ls, ls.a, ls.b>
{
  mp(ls.b paramb, mw parammw, t paramt)
  {
    super(paramb, new lo.a()
    {
      public ls.a a(ls.a paramAnonymousa, t paramAnonymoust)
      {
        if (paramAnonymousa == null)
          return new ls.a(paramAnonymoust.b().e(), paramAnonymoust.b().h(), paramAnonymoust.b().i(), paramAnonymoust.a().d(), paramAnonymoust.a().c(), paramAnonymoust.a().a(), paramAnonymoust.a().b());
        String str1 = paramAnonymoust.b().e();
        String str2 = paramAnonymousa.b;
        String str3;
        String str4;
        String str5;
        label106: String str6;
        String str7;
        String str8;
        label133: String str9;
        String str10;
        String str11;
        label160: String str12;
        Map localMap1;
        Map localMap2;
        label187: Map localMap3;
        boolean bool;
        if (str1 == null)
        {
          str3 = (String)str2;
          str4 = paramAnonymoust.b().h();
          str5 = paramAnonymousa.c;
          if (str4 != null)
            break label260;
          str6 = (String)str5;
          str7 = paramAnonymoust.b().i();
          str8 = paramAnonymousa.d;
          if (str7 != null)
            break label267;
          str9 = (String)str8;
          str10 = paramAnonymoust.a().d();
          str11 = paramAnonymousa.a;
          if (str10 != null)
            break label274;
          str12 = (String)str11;
          localMap1 = paramAnonymoust.a().c();
          localMap2 = paramAnonymousa.e;
          if (localMap1 != null)
            break label281;
          localMap3 = (Map)localMap2;
          if (!paramAnonymoust.a().a())
            break label288;
          bool = paramAnonymoust.a().a();
          label213: if (!paramAnonymoust.a().a())
            break label297;
        }
        label260: label267: label274: label281: label288: label297: for (List localList = paramAnonymoust.a().b(); ; localList = paramAnonymousa.g)
        {
          return new ls.a(str3, str6, str9, str12, localMap3, bool, localList);
          str2 = str1;
          break;
          str5 = str4;
          break label106;
          str8 = str7;
          break label133;
          str11 = str10;
          break label160;
          localMap2 = localMap1;
          break label187;
          bool = paramAnonymousa.f;
          break label213;
        }
      }
    }
    , parammw, paramt);
  }

  public void a(t paramt)
  {
    try
    {
      a(new lm.c(c(), b(paramt)));
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mp
 * JD-Core Version:    0.6.2
 */