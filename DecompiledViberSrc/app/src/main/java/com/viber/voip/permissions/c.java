package com.viber.voip.permissions;

import android.support.v4.app.Fragment;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.b;

public abstract class c extends b
  implements m.c
{
  protected final Fragment a;
  protected final com.viber.common.permission.c b;
  protected final a c;

  public c(Fragment paramFragment, com.viber.common.permission.c paramc, a parama)
  {
    this.a = paramFragment;
    this.b = paramc;
    this.c = parama;
  }

  public abstract void a();

  protected void a(boolean paramBoolean)
  {
    this.c.f_(paramBoolean);
  }

  public static abstract interface a
  {
    public abstract void f_(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.c
 * JD-Core Version:    0.6.2
 */