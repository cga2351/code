package com.viber.voip.api.scheme.action;

import android.content.Context;
import android.net.Uri;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.dialogs.a;
import com.viber.voip.util.ViberActionRunner.ab;

public class v extends aa
{
  private final Uri f;

  public v(Uri paramUri)
  {
    this.f = paramUri;
  }

  void a(Context paramContext)
  {
    a.k().a(this.f).a(ViberActionRunner.ab.a(ViberApplication.isTablet(paramContext)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.v
 * JD-Core Version:    0.6.2
 */