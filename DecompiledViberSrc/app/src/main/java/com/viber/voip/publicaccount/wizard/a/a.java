package com.viber.voip.publicaccount.wizard.a;

import android.os.Bundle;

public abstract class a
  implements c
{
  private final d a;
  private b b;
  private int c = -1;

  public a(d paramd)
  {
    this.a = paramd;
  }

  private void b(int paramInt, Bundle paramBundle)
  {
    this.c = paramInt;
    this.b = a(this.c, paramBundle);
    this.a.a(this.b, a(paramInt));
  }

  public abstract int a();

  public abstract b a(int paramInt, Bundle paramBundle);

  public void a(Bundle paramBundle)
  {
    b(0, paramBundle);
  }

  public void a(Bundle paramBundle, b paramb)
  {
    if (paramBundle != null)
    {
      this.c = paramBundle.getInt("paw_current_step_index", -1);
      if (b())
      {
        if (paramb == null)
          paramb = a(this.c, paramBundle.getBundle("paw_current_step"));
        this.b = paramb;
      }
      return;
    }
    this.c = -1;
  }

  public boolean a(int paramInt)
  {
    return paramInt > 0;
  }

  public void b(Bundle paramBundle)
  {
    if (b(this.c))
    {
      b(1 + this.c, paramBundle);
      return;
    }
    this.a.d();
  }

  public boolean b()
  {
    return this.c != -1;
  }

  public boolean b(int paramInt)
  {
    return paramInt + 1 < a();
  }

  public void c(Bundle paramBundle)
  {
    paramBundle.putInt("paw_current_step_index", this.c);
    if (b())
    {
      paramBundle.putBundle("paw_current_step", this.b.g());
      paramBundle.putString("current_fragment_identifier", this.b.f());
    }
  }

  public boolean c()
  {
    if (this.b == null);
    do
    {
      return false;
      if (this.b.e())
        return true;
    }
    while (!a(this.c));
    this.c = (-1 + this.c);
    b(this.c, this.b.c());
    return true;
  }

  public void e()
  {
    this.a.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.wizard.a.a
 * JD-Core Version:    0.6.2
 */