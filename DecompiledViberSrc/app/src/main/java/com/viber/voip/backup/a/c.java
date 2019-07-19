package com.viber.voip.backup.a;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.List;

public abstract class c<COMMON_DATA, BACKUP_INFO>
{
  private static final Logger f = ViberEnv.getLogger();
  protected final Context a;
  protected final b<COMMON_DATA> b;
  protected Handler c;
  protected List<a> d = new ArrayList();
  protected volatile boolean e;

  public c(Context paramContext, b<COMMON_DATA> paramb, Handler paramHandler)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = paramHandler;
  }

  private void a(BACKUP_INFO paramBACKUP_INFO)
  {
    if (this.d.size() == 0);
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList(this.d);
      for (int i = 0; i < localArrayList.size(); i++)
        ((a)localArrayList.get(i)).a(paramBACKUP_INFO);
    }
  }

  private void b(final a parama)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        c.a(c.this, parama);
      }
    });
  }

  private void c(a parama)
  {
    Object localObject1 = a(parama);
    try
    {
      a(localObject1);
      this.e = false;
      return;
    }
    finally
    {
    }
  }

  protected abstract BACKUP_INFO a(a parama);

  public void a()
  {
    if (!this.e)
    {
      this.e = true;
      a locala = this.b.a();
      if ((locala != null) && (locala.b().length > 0))
        b(locala);
    }
    else
    {
      return;
    }
    try
    {
      a(null);
      this.e = false;
      return;
    }
    finally
    {
    }
  }

  public void a(a parama)
  {
    try
    {
      if (!this.d.contains(parama))
        this.d.add(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(a parama)
  {
    try
    {
      this.d.remove(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static abstract interface a<BACKUP_INFO>
  {
    public abstract void a(BACKUP_INFO paramBACKUP_INFO);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.a.c
 * JD-Core Version:    0.6.2
 */