package com.viber.voip.ui;

import android.view.View;
import com.viber.voip.util.dj;

public abstract class ac
{
  protected a c;

  public ac(a parama)
  {
    this.c = parama;
  }

  public abstract String a();

  public abstract void a(String paramString);

  public abstract void b();

  public abstract View c();

  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
      i();
    this.c = null;
  }

  public abstract void d();

  public abstract boolean e();

  public boolean i()
  {
    return dj.c(c());
  }

  public static abstract interface a
  {
    public abstract boolean onQueryTextChange(String paramString);

    public abstract boolean onQueryTextSubmit(String paramString);

    public abstract boolean onSearchViewShow(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ac
 * JD-Core Version:    0.6.2
 */