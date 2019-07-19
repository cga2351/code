package com.viber.voip;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.viber.common.b.h;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.util.bp;
import com.viber.voip.util.dj;

public class ViberAppCompatActivity extends AppCompatActivity
{
  private String mUiLanguage;

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(bp.c(paramContext));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUiLanguage = d.ad.a.c.d();
  }

  protected void onResume()
  {
    super.onResume();
    bp.a(this, this.mUiLanguage);
  }

  public void setActionBarTitle(int paramInt)
  {
    dj.a(this, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ViberAppCompatActivity
 * JD-Core Version:    0.6.2
 */