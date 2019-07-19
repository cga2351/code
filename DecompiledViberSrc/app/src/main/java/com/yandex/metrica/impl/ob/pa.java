package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s.a;

public class pa
{
  private final oc<pb, oz> a;
  private final oc<s.a, oz> b;

  public pa(Context paramContext)
  {
    this(new ox(), new pc(), new ou(paramContext));
  }

  public pa(oz paramoz1, oz paramoz2, oz paramoz3)
  {
    this.a = new oc(paramoz1);
    this.a.a(pb.a, paramoz1);
    this.a.a(pb.b, paramoz2);
    this.a.a(pb.c, paramoz3);
    this.b = new oc(paramoz1);
    this.b.a(s.a.p, paramoz3);
  }

  public oz a(i parami)
  {
    s.a locala = s.a.a(parami.e());
    return (oz)this.b.a(locala);
  }

  public oz a(pb parampb)
  {
    return (oz)this.a.a(parampb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pa
 * JD-Core Version:    0.6.2
 */