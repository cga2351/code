package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.aw.a;
import java.util.EnumSet;

public class im
{
  private static final EnumSet<aw.a> a = EnumSet.of(aw.a.b, aw.a.a);
  private ny b = new nv();
  private final Context c;

  public im(Context paramContext)
  {
    this.c = paramContext;
  }

  public boolean a()
  {
    aw.a locala = this.b.a(this.c);
    return a.contains(locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.im
 * JD-Core Version:    0.6.2
 */