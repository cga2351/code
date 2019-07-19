package com.viber.voip.messages.controller;

import android.os.Handler;

public class ce
  implements cd
{
  private final cd a;
  private final Handler b;

  public ce(Handler paramHandler, cd paramcd)
  {
    this.a = paramcd;
    this.b = paramHandler;
  }

  private void a(final a parama)
  {
    this.b.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        parama.a(ce.a(ce.this));
      }
    });
  }

  public String a()
  {
    return this.a.a();
  }

  public void a(final cd.a parama)
  {
    a(new a()
    {
      public void a(cd paramAnonymouscd)
      {
        paramAnonymouscd.a(parama);
      }
    });
  }

  public void a(final String paramString)
  {
    a(new a()
    {
      public void a(cd paramAnonymouscd)
      {
        paramAnonymouscd.a(paramString);
      }
    });
  }

  public void b()
  {
    a(new a()
    {
      public void a(cd paramAnonymouscd)
      {
        paramAnonymouscd.b();
      }
    });
  }

  private static abstract interface a
  {
    public abstract void a(cd paramcd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.ce
 * JD-Core Version:    0.6.2
 */