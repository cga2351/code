package com.yandex.metrica.impl.ob;

import com.yandex.metrica.CounterConfiguration;

public class bj extends lo<bm, bm.a, bm.b>
{
  private t a;

  public bj(bm.b paramb, mw parammw, t paramt)
  {
    super(paramb, new lo.a()
    {
      public bm.a a(bm.a paramAnonymousa, t paramAnonymoust)
      {
        CounterConfiguration localCounterConfiguration = paramAnonymoust.b();
        if (paramAnonymousa == null)
          return new bm.a(localCounterConfiguration.e(), localCounterConfiguration.h(), localCounterConfiguration.i(), localCounterConfiguration.f());
        String str1 = localCounterConfiguration.e();
        String str2 = paramAnonymousa.b;
        String str3;
        String str4;
        String str5;
        label74: String str6;
        String str7;
        String str8;
        label98: String str9;
        String str10;
        String str11;
        if (str1 == null)
        {
          str3 = (String)str2;
          str4 = localCounterConfiguration.h();
          str5 = paramAnonymousa.c;
          if (str4 != null)
            break label148;
          str6 = (String)str5;
          str7 = localCounterConfiguration.i();
          str8 = paramAnonymousa.d;
          if (str7 != null)
            break label155;
          str9 = (String)str8;
          str10 = localCounterConfiguration.f();
          str11 = paramAnonymousa.a;
          if (str10 != null)
            break label162;
        }
        while (true)
        {
          return new bm.a(str3, str6, str9, (String)str11);
          str2 = str1;
          break;
          label148: str5 = str4;
          break label74;
          label155: str8 = str7;
          break label98;
          label162: str11 = str10;
        }
      }
    }
    , parammw, paramt);
    this.a = paramt;
  }

  public t a()
  {
    return this.a;
  }

  public void a(t paramt)
  {
    try
    {
      a(new lm.c(c(), b(paramt)));
      b();
      this.a = paramt;
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
 * Qualified Name:     com.yandex.metrica.impl.ob.bj
 * JD-Core Version:    0.6.2
 */