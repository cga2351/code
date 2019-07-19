package com.yandex.metrica.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.yandex.metrica.impl.ob.oi;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class aj
  implements ai
{
  private Executor a;
  private ai b;

  public aj(ai paramai)
  {
    this(Executors.newSingleThreadExecutor(), paramai);
  }

  aj(Executor paramExecutor, ai paramai)
  {
    this.a = paramExecutor;
    this.b = paramai;
  }

  public void a()
  {
    this.a.execute(new oi()
    {
      public void a()
      {
        aj.a(aj.this).a();
      }
    });
  }

  public void a(final Intent paramIntent)
  {
    this.a.execute(new oi()
    {
      public void a()
      {
        aj.a(aj.this).a(paramIntent);
      }
    });
  }

  public void a(final Intent paramIntent, final int paramInt)
  {
    this.a.execute(new oi()
    {
      public void a()
      {
        aj.a(aj.this).a(paramIntent, paramInt);
      }
    });
  }

  public void a(final Intent paramIntent, final int paramInt1, final int paramInt2)
  {
    this.a.execute(new oi()
    {
      public void a()
      {
        aj.a(aj.this).a(paramIntent, paramInt1, paramInt2);
      }
    });
  }

  public void a(final Bundle paramBundle)
    throws RemoteException
  {
    this.a.execute(new oi()
    {
      public void a()
        throws Exception
      {
        aj.a(aj.this).a(paramBundle);
      }
    });
  }

  public void a(final String paramString1, final int paramInt, final String paramString2, final Bundle paramBundle)
    throws RemoteException
  {
    this.a.execute(new oi()
    {
      public void a()
        throws RemoteException
      {
        aj.a(aj.this).a(paramString1, paramInt, paramString2, paramBundle);
      }
    });
  }

  public void b()
  {
    this.b.b();
  }

  public void b(final Intent paramIntent)
  {
    this.a.execute(new oi()
    {
      public void a()
      {
        aj.a(aj.this).b(paramIntent);
      }
    });
  }

  public void c(final Intent paramIntent)
  {
    this.a.execute(new oi()
    {
      public void a()
      {
        aj.a(aj.this).c(paramIntent);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.aj
 * JD-Core Version:    0.6.2
 */