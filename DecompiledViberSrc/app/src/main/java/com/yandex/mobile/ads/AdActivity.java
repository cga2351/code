package com.yandex.mobile.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.Window;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.impl.j;
import com.yandex.mobile.ads.impl.l;
import com.yandex.mobile.ads.impl.o;

public final class AdActivity extends Activity
{
  public static final String a = AdActivity.class.getCanonicalName();
  private RelativeLayout b;
  private j c;

  private static ResultReceiver a(Intent paramIntent)
  {
    try
    {
      ResultReceiver localResultReceiver = (ResultReceiver)paramIntent.getParcelableExtra("extra_receiver");
      return localResultReceiver;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final void onBackPressed()
  {
    if ((this.c == null) || (!this.c.c()))
      super.onBackPressed();
  }

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new RelativeLayout(this);
    RelativeLayout localRelativeLayout = this.b;
    Intent localIntent = getIntent();
    Window localWindow;
    ResultReceiver localResultReceiver;
    o localo;
    if (localIntent != null)
    {
      localWindow = getWindow();
      localResultReceiver = a(localIntent);
      localo = new o(this, localResultReceiver);
    }
    for (j localj = l.a().a(this, localRelativeLayout, localResultReceiver, localo, localIntent, localWindow); ; localj = null)
    {
      this.c = localj;
      if (this.c == null)
        break;
      this.c.a();
      this.c.b();
      setContentView(this.b);
      return;
    }
    finish();
  }

  protected final void onDestroy()
  {
    if (this.c != null)
    {
      this.c.d();
      this.c.g();
    }
    if (this.b != null)
      this.b.removeAllViews();
    super.onDestroy();
  }

  protected final void onPause()
  {
    if (this.c != null)
      this.c.f();
    super.onPause();
  }

  protected final void onResume()
  {
    super.onResume();
    if (this.c != null)
      this.c.e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.AdActivity
 * JD-Core Version:    0.6.2
 */