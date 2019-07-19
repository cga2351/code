package com.viber.voip.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;

public class z extends y
{
  private static final Logger a = ViberEnv.getLogger();
  private final d[] b;
  private int c = 0;
  private TextView d;
  private boolean e = false;
  private volatile boolean f = false;
  private final d.a g = new d.a()
  {
    public void a()
    {
      z.this.hideInternally();
    }

    public void b()
    {
      if ((z.a(z.this)) && (!z.b(z.this)))
        z.this.showInternally();
    }

    public void c()
    {
    }
  };

  public z(Context paramContext, d[] paramArrayOfd)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: new 31	com/viber/voip/ui/z$2
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 34	com/viber/voip/ui/z$2:<init>	(Landroid/content/Context;)V
    //   10: aload_1
    //   11: invokestatic 40	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   14: invokespecial 43	com/viber/voip/ui/y:<init>	(Landroid/content/Context;Lcom/viber/voip/ui/y$a;Landroid/view/LayoutInflater;)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 45	com/viber/voip/ui/z:c	I
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 47	com/viber/voip/ui/z:e	Z
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 49	com/viber/voip/ui/z:f	Z
    //   32: aload_0
    //   33: new 51	com/viber/voip/ui/z$1
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 54	com/viber/voip/ui/z$1:<init>	(Lcom/viber/voip/ui/z;)V
    //   41: putfield 56	com/viber/voip/ui/z:g	Lcom/viber/voip/ui/d$a;
    //   44: aload_0
    //   45: aload_2
    //   46: putfield 58	com/viber/voip/ui/z:b	[Lcom/viber/voip/ui/d;
    //   49: return
  }

  private boolean b()
  {
    d[] arrayOfd = this.b;
    int i = arrayOfd.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfd[j].isAlertWindowVisible())
          bool = true;
      }
      else
        return bool;
    }
  }

  private void c()
  {
    if (this.d != null)
    {
      TextView localTextView = this.d;
      Resources localResources = this.mResources;
      int i = R.string.progress_percents;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.c);
      localTextView.setText(localResources.getString(i, arrayOfObject));
    }
  }

  public void a()
  {
    if (this.f);
    while (true)
    {
      return;
      this.f = true;
      d[] arrayOfd = this.b;
      int i = arrayOfd.length;
      for (int j = 0; j < i; j++)
        arrayOfd[j].registerCallback(this.g);
    }
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
    c();
  }

  public void hideAlertWindow()
  {
    super.hideAlertWindow();
    this.e = false;
  }

  protected void hideInternally()
  {
    removeMinimizedView();
    super.hideInternally();
  }

  protected void initMinimizedView()
  {
    super.initMinimizedView();
    this.d = ((TextView)dj.d(this.mView, R.id.syncing_progress));
  }

  public boolean isAlertWindowPendingVisible()
  {
    return (this.e) || (super.isAlertWindowPendingVisible());
  }

  protected void removeMinimizedView()
  {
    super.removeMinimizedView();
    this.d = null;
  }

  public void showAlertWindow()
  {
    super.showAlertWindow();
    this.e = true;
  }

  protected void showInternally()
  {
    if (!b())
      addMinimizedView();
    c();
    super.showInternally();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.z
 * JD-Core Version:    0.6.2
 */