package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.t;
import java.util.Set;

public class ds
{
  private final int a;
  private final dw b;
  private dt c;

  public ds(Context paramContext, y paramy, int paramInt)
  {
    this(new dw(paramContext, paramy), paramInt);
  }

  ds(dw paramdw, int paramInt)
  {
    this.a = paramInt;
    this.b = paramdw;
  }

  private void b()
  {
    this.c = this.b.a();
    if (this.c.e() != this.a)
    {
      this.c.a(this.a);
      c();
    }
  }

  private void c()
  {
    this.b.a(this.c);
  }

  public t a(String paramString)
  {
    if (this.c == null)
      b();
    int i = paramString.hashCode();
    if (this.c.c().contains(Integer.valueOf(i)))
      return t.c;
    t localt;
    if (this.c.b())
    {
      localt = t.b;
      if (this.c.d() >= 1000)
        break label87;
      this.c.b(i);
    }
    while (true)
    {
      c();
      return localt;
      localt = t.a;
      break;
      label87: this.c.a(false);
    }
  }

  public void a()
  {
    if (this.c == null)
      b();
    this.c.a();
    this.c.a(true);
    c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ds
 * JD-Core Version:    0.6.2
 */