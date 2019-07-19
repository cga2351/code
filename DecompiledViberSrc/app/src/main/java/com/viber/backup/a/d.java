package com.viber.backup.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.x;
import com.viber.voip.util.av;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final p.a c;
  private final com.viber.common.b.d d;

  public d(Context paramContext, p.a parama, com.viber.common.b.d paramd)
  {
    this.b = paramContext;
    this.d = paramd;
    this.c = parama;
  }

  public static d a(Context paramContext)
  {
    return new d(paramContext, p.a.i, d.x.b);
  }

  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0)
      localStringBuilder.append("STATE_IDLE");
    while (true)
    {
      return localStringBuilder.toString();
      a(paramInt, 1, "SUSPENDED_BY_GDPR", localStringBuilder);
      a(paramInt, 2, "INVALID_GOOGLE_ACCOUNT", localStringBuilder);
      a(paramInt, 4, "CAN_NOT_AUTO_CHOOSE_ACCOUNT", localStringBuilder);
      a(paramInt, 8, "UPDATE_ON_CURRENT_ACCOUNT", localStringBuilder);
      a(paramInt, 16, "MIGRATE_TO_MESSAGES_BACKUP_ACCOUNT", localStringBuilder);
      a(paramInt, 32, "DELETE_FROM_CURRENT_ACCOUNT", localStringBuilder);
    }
  }

  private void a(int paramInt1, int paramInt2, String paramString, StringBuilder paramStringBuilder)
  {
    if (av.d(paramInt1, paramInt2))
    {
      if (paramStringBuilder.length() > 0)
        paramStringBuilder.append(" | ");
      paramStringBuilder.append(paramString);
    }
  }

  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.d.d();
    boolean bool1 = i();
    if (paramBoolean1);
    for (int j = av.e(i, paramInt); ; j = av.f(i, paramInt))
    {
      this.d.a(j);
      boolean bool2 = i();
      if ((paramBoolean2) && (bool1 != bool2))
        j();
      return;
    }
  }

  private boolean i()
  {
    return (d()) || (e()) || (f());
  }

  private void j()
  {
    if (i())
    {
      this.c.b(this.b);
      return;
    }
    this.c.c(this.b);
  }

  private String k()
  {
    return a(this.d.d());
  }

  public void a()
  {
    j();
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (av.d(this.d.d(), 16))
        return;
      if (av.d(this.d.d(), 32))
        a(32, false, false);
    }
    a(8, paramBoolean, true);
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
      a(24, false, false);
    a(32, paramBoolean, true);
  }

  public boolean b()
  {
    return this.d.a();
  }

  public void c()
  {
    this.d.a(0);
    j();
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
      a(40, false, false);
    a(16, paramBoolean, true);
  }

  public void d(boolean paramBoolean)
  {
    a(4, paramBoolean, true);
  }

  public boolean d()
  {
    return this.d.d() == 8;
  }

  public void e(boolean paramBoolean)
  {
    a(2, paramBoolean, true);
  }

  public boolean e()
  {
    return this.d.d() == 16;
  }

  public boolean f()
  {
    return this.d.d() == 32;
  }

  public boolean g()
  {
    if (av.d(this.d.d(), 1))
    {
      a(1, false, true);
      return true;
    }
    return false;
  }

  public void h()
  {
    a(6, false, true);
  }

  public String toString()
  {
    return "FallbackUpdateResolver{mUpdateState=" + k() + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.a.d
 * JD-Core Version:    0.6.2
 */