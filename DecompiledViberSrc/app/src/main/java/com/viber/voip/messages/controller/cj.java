package com.viber.voip.messages.controller;

import android.net.Uri;
import android.os.Handler;
import java.util.Set;

public class cj
  implements ci
{
  private final ci a;
  private final Handler b;

  public cj(Handler paramHandler, ci paramci)
  {
    this.a = paramci;
    this.b = paramHandler;
  }

  private void a(final a parama)
  {
    this.b.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        parama.a(cj.a(cj.this));
      }
    });
  }

  public void a(final Uri paramUri)
  {
    a(new a()
    {
      public void a(ci paramAnonymousci)
      {
        paramAnonymousci.a(paramUri);
      }
    });
  }

  public void a(final String paramString)
  {
    a(new a()
    {
      public void a(ci paramAnonymousci)
      {
        paramAnonymousci.a(paramString);
      }
    });
  }

  public void a(final String paramString, final ci.a parama, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(ci paramAnonymousci)
      {
        paramAnonymousci.a(paramString, parama, paramBoolean);
      }
    });
  }

  public void a(final Set<String> paramSet, final ci.a parama, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(ci paramAnonymousci)
      {
        paramAnonymousci.a(paramSet, parama, paramBoolean);
      }
    });
  }

  public void a(Set<String> paramSet, ci.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(new ck(paramSet, parama, paramBoolean1, paramBoolean2, paramBoolean3));
  }

  public void b(final String paramString, final ci.a parama, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(ci paramAnonymousci)
      {
        paramAnonymousci.b(paramString, parama, paramBoolean);
      }
    });
  }

  public void b(final Set<String> paramSet, final ci.a parama, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(ci paramAnonymousci)
      {
        paramAnonymousci.b(paramSet, parama, paramBoolean);
      }
    });
  }

  private static abstract interface a
  {
    public abstract void a(ci paramci);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.cj
 * JD-Core Version:    0.6.2
 */