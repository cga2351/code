package com.viber.voip.ui.c;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.j.av;
import dagger.a;

public class i
{
  public static int a(Fragment paramFragment)
  {
    Bundle localBundle = paramFragment.getArguments();
    if (localBundle != null)
      return ((av)ViberApplication.getInstance().getThemeController().get()).a(localBundle.getInt("theme_id"));
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.c.i
 * JD-Core Version:    0.6.2
 */