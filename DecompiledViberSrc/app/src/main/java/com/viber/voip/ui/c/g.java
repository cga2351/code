package com.viber.voip.ui.c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.settings.d.bc;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class g extends c
{
  final av c;
  private String d;

  public g(a parama, av paramav)
  {
    super(parama);
    this.c = paramav;
  }

  public void a()
  {
    if (!d.bc.a.d().equals(this.d))
      this.b.recreate();
  }

  public void a(Intent paramIntent, Bundle paramBundle)
  {
  }

  public void a(Bundle paramBundle)
  {
  }

  protected void b()
  {
    if (!com.viber.common.d.a.j())
      return;
    AppCompatActivity localAppCompatActivity = this.b.getActivity();
    dj.b(localAppCompatActivity, dc.b(localAppCompatActivity, 16844000));
  }

  public final void b(Intent paramIntent)
  {
    if ((this.b.isSwitchingThemeSupported()) && (this.b.getDefaultTheme() != 0) && (!ViberApplication.isTablet(null)))
    {
      this.b.setTheme(c(paramIntent));
      b();
    }
    this.d = d.bc.a.d();
  }

  protected int c(Intent paramIntent)
  {
    int i = this.c.a(this.b.getDefaultTheme());
    this.b.getActivity();
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.c.g
 * JD-Core Version:    0.6.2
 */