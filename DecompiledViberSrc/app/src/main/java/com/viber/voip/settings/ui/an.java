package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.preference.b;
import android.support.v7.view.d;
import android.view.View;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.j.av;

public class an extends b
{
  public static an b(String paramString)
  {
    an localan = new an();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("key", paramString);
    localan.setArguments(localBundle);
    return localan;
  }

  protected View a(Context paramContext)
  {
    return super.a(new d(paramContext, ((av)ViberApplication.getInstance().getThemeController().get()).a(R.style.Theme_Viber_EditTextPreferenceDialog)));
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new ao(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new ap(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.an
 * JD-Core Version:    0.6.2
 */