package com.viber.voip.backup;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.a.c.a;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.ActivationController;
import dagger.a;

public class s
  implements c.a<BackupInfo>
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final a<com.viber.common.permission.c> c;
  private final f d;
  private final a<com.viber.voip.backup.a.c> e;
  private ActivationController f;
  private boolean g;
  private int h = 0;
  private int i = 0;
  private boolean j;
  private boolean k;

  public s(Context paramContext, a<com.viber.common.permission.c> parama, a<com.viber.voip.backup.a.c> parama1, f paramf)
  {
    this.b = paramContext;
    this.c = parama;
    this.e = parama1;
    this.d = paramf;
  }

  private void b(int paramInt)
  {
    try
    {
      boolean bool = this.k;
      if (bool);
      while (true)
      {
        return;
        this.f.setStep(paramInt, true);
      }
    }
    finally
    {
    }
  }

  private void c()
  {
    try
    {
      if (this.d.e().isBackupExists())
        g();
      while (true)
      {
        return;
        f();
      }
    }
    finally
    {
    }
  }

  private void d()
  {
    while (true)
    {
      try
      {
        if (this.g)
        {
          g();
          return;
        }
        switch (this.i)
        {
        default:
          f();
          continue;
        case 1:
        case 2:
        }
      }
      finally
      {
      }
      b(19);
      continue;
      g();
    }
  }

  private void e()
  {
    try
    {
      if (1 != this.h)
      {
        this.h = 1;
        ((com.viber.voip.backup.a.c)this.e.get()).a(this);
        ((com.viber.voip.backup.a.c)this.e.get()).a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void f()
  {
    try
    {
      b(8);
      this.k = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void g()
  {
    try
    {
      b(20);
      this.k = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a()
  {
    while (true)
    {
      try
      {
        boolean bool = this.j;
        if (bool)
          return;
        if (!l.a(this.b))
        {
          f();
          this.j = true;
          continue;
        }
      }
      finally
      {
      }
      if (this.h == 0)
      {
        b();
        if (this.h == 0)
        {
          d();
          this.j = true;
        }
      }
      else
      {
        if (1 == this.h)
          b(19);
        if (2 == this.h)
          c();
        this.j = true;
      }
    }
  }

  public void a(int paramInt)
  {
    try
    {
      this.i = paramInt;
      if ((this.j) && (this.h == 0))
        d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(BackupInfo paramBackupInfo)
  {
    try
    {
      ((com.viber.voip.backup.a.c)this.e.get()).b(this);
      this.h = 2;
      if (this.j)
        c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(ActivationController paramActivationController)
  {
    try
    {
      this.f = paramActivationController;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b()
  {
    try
    {
      boolean bool = l.a(this.b);
      if (!bool);
      while (true)
      {
        return;
        if (((com.viber.common.permission.c)this.c.get()).a(n.j))
          e();
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.s
 * JD-Core Version:    0.6.2
 */