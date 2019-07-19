package com.viber.voip.market;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.billing.ac;
import com.viber.voip.billing.ae;
import com.viber.voip.billing.af;
import com.viber.voip.billing.g;
import com.viber.voip.gdpr.d;
import com.viber.voip.util.dl;
import org.greenrobot.eventbus.EventBus;

public class CommunityInsightsActivity extends ViberWebApiActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private long b;

  public static Intent a(long paramLong)
  {
    Intent localIntent = a(CommunityInsightsActivity.class);
    if (0L != paramLong)
      localIntent.putExtra("community_id", paramLong);
    return localIntent;
  }

  protected WebViewClient a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: new 36	com/viber/voip/market/CommunityInsightsActivity$1
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 39	com/viber/voip/market/CommunityInsightsActivity$1:<init>	(Lcom/viber/voip/market/CommunityInsightsActivity;Ljava/lang/Runnable;)V
    //   9: areturn
  }

  protected String a(String paramString)
  {
    Intent localIntent = getIntent();
    getSupportActionBar().a(d());
    String str1 = dl.e(dl.d(dl.h(dl.j(dl.b(paramString)))));
    try
    {
      ac localac2 = g.a().b();
      localac1 = localac2;
      String str2 = dl.a(str1, localac1);
      long l = localIntent.getLongExtra("community_id", 0L);
      return Uri.parse(str2).buildUpon().appendQueryParameter("community_id", Long.toString(l)).build().toString();
    }
    catch (ae localae)
    {
      while (true)
      {
        localae.printStackTrace();
        ac localac1 = null;
      }
    }
  }

  protected String c()
  {
    return ap.c().aE;
  }

  protected String d()
  {
    return getString(R.string.community_insights_title);
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (!ViberApplication.isTablet(this))
      com.viber.voip.n.a.d(this);
    super.onCreate(paramBundle);
  }

  protected void onResume()
  {
    super.onResume();
    d.a(this);
    com.viber.voip.h.a.b().post(new com.viber.voip.ui.e.a());
  }

  protected void onStart()
  {
    super.onStart();
    this.b = System.currentTimeMillis();
  }

  protected void onStop()
  {
    super.onStop();
  }

  protected boolean t_()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.CommunityInsightsActivity
 * JD-Core Version:    0.6.2
 */