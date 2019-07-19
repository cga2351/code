package com.viber.voip.contacts.c.a;

import android.os.Handler;
import com.viber.voip.memberid.Member;
import java.util.Set;

public class b
  implements a
{
  private final a a;
  private final Handler b;

  public b(Handler paramHandler, a parama)
  {
    this.b = paramHandler;
    this.a = parama;
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

  public void a()
  {
    a(new a()
    {
      public void a(a paramAnonymousa)
      {
        paramAnonymousa.a();
      }
    });
  }

  public void a(final Member paramMember)
  {
    a(new a()
    {
      public void a(a paramAnonymousa)
      {
        paramAnonymousa.a(paramMember);
      }
    });
  }

  public void a(final Member paramMember, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(a paramAnonymousa)
      {
        paramAnonymousa.a(paramMember, paramBoolean);
      }
    });
  }

  public void a(final Set<Member> paramSet)
  {
    a(new a()
    {
      public void a(a paramAnonymousa)
      {
        paramAnonymousa.a(paramSet);
      }
    });
  }

  public void a(final Set<Member> paramSet, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(a paramAnonymousa)
      {
        paramAnonymousa.a(paramSet, paramBoolean);
      }
    });
  }

  private static abstract interface a
  {
    public abstract void a(a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.a.b
 * JD-Core Version:    0.6.2
 */