package com.viber.voip.shareviber.invitescreen.b;

import android.os.Handler;
import com.viber.voip.model.a;
import java.util.List;

public class k
{
  private final Handler a;
  private final Handler b;
  private final g c;

  public k(f paramf, Handler paramHandler1, Handler paramHandler2)
  {
    this.a = paramHandler1;
    this.b = paramHandler2;
    this.c = paramf.a();
  }

  public void a(final a parama)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        final List localList = k.a(k.this).a();
        k.b(k.this).post(new Runnable()
        {
          public void run()
          {
            k.1.this.a.a(localList);
          }
        });
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(List<a> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.k
 * JD-Core Version:    0.6.2
 */