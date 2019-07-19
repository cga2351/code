package com.viber.voip.user.viberid;

import com.viber.common.b.b;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.bg;
import com.viber.voip.ui.dialogs.ae;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.dd;
import com.viber.voip.util.i;

public class ViberIdDialogController
  implements d.b
{
  private static final Logger L = ViberEnv.getLogger();
  private final d mAppBackgroundChecker;
  private final DialogShowDelegate mDialogShowDelegate;
  private final b mShowDetailsUpdatedDialogPref;

  public ViberIdDialogController(d paramd)
  {
    this(paramd, d.bg.g, new DialogShowDelegate()
    {
      public void show()
      {
        ae.e().d();
      }
    });
  }

  ViberIdDialogController(d paramd, b paramb, DialogShowDelegate paramDialogShowDelegate)
  {
    this.mAppBackgroundChecker = paramd;
    this.mShowDetailsUpdatedDialogPref = paramb;
    this.mDialogShowDelegate = paramDialogShowDelegate;
  }

  void init()
  {
    this.mAppBackgroundChecker.a(this);
    dd.a(new Runnable()
    {
      public void run()
      {
        if (ViberIdDialogController.this.mAppBackgroundChecker.b())
          ViberIdDialogController.this.onForeground();
      }
    });
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    i.a(this);
  }

  public void onForeground()
  {
    if (this.mShowDetailsUpdatedDialogPref.d())
      showAccountDitailsUpdatedOnRakutenSide();
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }

  void showAccountDitailsUpdatedOnRakutenSide()
  {
    dd.a(new Runnable()
    {
      public void run()
      {
        if (ViberIdDialogController.this.mAppBackgroundChecker.b())
        {
          ViberIdDialogController.this.mShowDetailsUpdatedDialogPref.e();
          ViberIdDialogController.this.mDialogShowDelegate.show();
          return;
        }
        ViberIdDialogController.this.mShowDetailsUpdatedDialogPref.a(true);
      }
    });
  }

  static abstract interface DialogShowDelegate
  {
    public abstract void show();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdDialogController
 * JD-Core Version:    0.6.2
 */