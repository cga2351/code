package com.viber.voip.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.camera.e.b.a;
import com.viber.voip.camera.e.b.a.b;
import com.viber.voip.util.dj;

public class an
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private final Activity c;
  private View d;

  public an(Activity paramActivity)
  {
    this.c = paramActivity;
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (e() != null))
    {
      if (paramBoolean2)
        e().a(1500L);
    }
    else
      return;
    e().a();
  }

  public void a()
  {
    this.d = this.c.getWindow().getDecorView().findViewById(16908290);
    a(true, false);
  }

  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }

  public void b()
  {
    if (this.d != null)
      this.d.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }

  public void c()
  {
    if (this.d != null)
      dj.b(this.d, this);
  }

  public void d()
  {
    a(true, false);
  }

  protected a e()
  {
    Activity localActivity;
    int i;
    if (this.b == null)
    {
      localActivity = this.c;
      if (Build.VERSION.SDK_INT < 19)
        break label59;
      i = 3;
      if (Build.VERSION.SDK_INT < 19)
        break label64;
    }
    label59: label64: for (int j = 2; ; j = 0)
    {
      this.b = new a(localActivity, i, j, new a.b()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          an.a(an.this, paramAnonymousBoolean, true);
        }
      });
      return this.b;
      i = 1;
      break;
    }
  }

  public void onGlobalLayout()
  {
    a(this.c.hasWindowFocus(), false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.an
 * JD-Core Version:    0.6.2
 */