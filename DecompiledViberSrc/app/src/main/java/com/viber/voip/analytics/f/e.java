package com.viber.voip.analytics.f;

import android.content.Context;
import com.viber.voip.analytics.a;
import com.viber.voip.analytics.story.j;
import com.viber.voip.analytics.y;

public class e extends a
  implements d
{
  private boolean c;
  private a d = a.a;
  private b e;

  public e(Context paramContext, y paramy)
  {
    super(paramy);
    a(a(paramContext, this.d));
  }

  private b a(Context paramContext, a parama)
  {
    this.d = parama;
    switch (1.a[parama.ordinal()])
    {
    default:
      return null;
    case 1:
    }
    return new b();
  }

  private void a(b paramb)
  {
    this.e = paramb;
    g();
  }

  private void g()
  {
    if (this.e != null)
    {
      if (this.c)
        this.e.a();
    }
    else
      return;
    this.e.b();
  }

  protected void b(String paramString)
  {
  }

  protected boolean c(com.viber.voip.analytics.story.e parame)
  {
    if (this.e != null)
    {
      this.e.a(parame);
      return true;
    }
    return false;
  }

  protected boolean c(j paramj)
  {
    return false;
  }

  protected void d(com.viber.voip.analytics.story.e parame)
  {
  }

  protected void e()
  {
    this.c = false;
    g();
  }

  protected void q_()
  {
    this.c = true;
    g();
  }

  static enum a
  {
    private final int c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(int paramInt)
    {
      this.c = paramInt;
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(com.viber.voip.analytics.story.e parame);

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.f.e
 * JD-Core Version:    0.6.2
 */