package com.viber.voip.registration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;

public class a
{
  private Context a = ViberApplication.getApplication();
  private WindowManager b = (WindowManager)this.a.getSystemService("window");
  private final LayoutInflater c = LayoutInflater.from(this.a);
  private View d;

  public static a a()
  {
    return a.a();
  }

  public void b()
  {
    if (this.d == null)
    {
      this.d = this.c.inflate(R.layout.activation_call_popup, null);
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, 2003, 0, -3);
      this.b.addView(this.d, localLayoutParams);
    }
  }

  public void c()
  {
    if (this.d != null)
    {
      this.b.removeView(this.d);
      this.d = null;
    }
  }

  private static class a
  {
    private static final a a = new a(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.a
 * JD-Core Version:    0.6.2
 */