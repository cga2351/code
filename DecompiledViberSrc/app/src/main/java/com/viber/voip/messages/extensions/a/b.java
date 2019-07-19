package com.viber.voip.messages.extensions.a;

import android.os.Handler;

public final class b
  implements a
{
  private final a a;
  private final Handler b;

  public b(a parama, Handler paramHandler)
  {
    this.a = parama;
    this.b = paramHandler;
  }

  private void a(final a parama)
  {
    this.b.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        parama.a(b.a(b.this));
      }
    });
  }

  public void a(final String paramString, final com.viber.voip.messages.extensions.model.b paramb)
  {
    a(new a()
    {
      public void a(a paramAnonymousa)
      {
        paramAnonymousa.a(paramString, paramb);
      }
    });
  }

  @Deprecated
  public com.viber.voip.messages.extensions.model.a[] a()
  {
    return this.a.a();
  }

  private static abstract interface a
  {
    public abstract void a(a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.a.b
 * JD-Core Version:    0.6.2
 */