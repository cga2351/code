package com.viber.voip.user.more;

import android.app.Activity;
import com.viber.voip.app.b;

class MoreScreenConfig
{
  private final boolean isDialog;
  private final boolean isEditOptionsItemVisible;
  private final boolean isLandscape;
  private final boolean isMoreActivity;
  private final boolean isMoreTab;
  private final boolean isTablet;

  MoreScreenConfig(Activity paramActivity, b paramb)
  {
    this.isLandscape = paramb.a();
    this.isTablet = paramb.a(paramActivity);
    this.isDialog = (paramActivity instanceof MoreDialogActivity);
    this.isMoreActivity = (paramActivity instanceof MoreActivity);
    if ((!this.isDialog) && (!this.isMoreActivity));
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.isMoreTab = bool1;
      boolean bool2;
      if (this.isTablet)
      {
        boolean bool3 = this.isDialog;
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      this.isEditOptionsItemVisible = bool2;
      return;
    }
  }

  public boolean isDialog()
  {
    return this.isDialog;
  }

  public boolean isEditOptionsItemVisible()
  {
    return this.isEditOptionsItemVisible;
  }

  public boolean isLandscape()
  {
    return this.isLandscape;
  }

  public boolean isMoreActivity()
  {
    return this.isMoreActivity;
  }

  public boolean isMoreTab()
  {
    return this.isMoreTab;
  }

  public boolean isTablet()
  {
    return this.isTablet;
  }

  public String toString()
  {
    return "MoreScreenConfig{isLandscape=" + this.isLandscape + ", isTablet=" + this.isTablet + ", isDialog=" + this.isDialog + ", isMoreActivity=" + this.isMoreActivity + ", isMoreTab=" + this.isMoreTab + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreScreenConfig
 * JD-Core Version:    0.6.2
 */