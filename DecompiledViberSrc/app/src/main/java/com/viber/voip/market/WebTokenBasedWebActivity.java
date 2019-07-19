package com.viber.voip.market;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.market.b.d;

public abstract class WebTokenBasedWebActivity extends ViberWebApiActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;
  private boolean c;

  private void x()
  {
    new d().a(new MarketApi.c()
    {
      public void a(String paramAnonymousString)
      {
        if (!WebTokenBasedWebActivity.this.isDestroyed())
          WebTokenBasedWebActivity.this.b(false);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        String str1;
        if (!WebTokenBasedWebActivity.this.isDestroyed())
        {
          str1 = WebTokenBasedWebActivity.this.l();
          if (!WebTokenBasedWebActivity.a(WebTokenBasedWebActivity.this))
            break label107;
        }
        label107: for (String str2 = "user"; ; str2 = "phone")
        {
          Uri.Builder localBuilder = Uri.parse(str1).buildUpon();
          localBuilder.appendPath(str2).appendPath(paramAnonymousString1).appendPath("ts").appendPath(String.valueOf(paramAnonymousLong)).appendPath("token").appendPath(paramAnonymousString2);
          WebTokenBasedWebActivity.a(WebTokenBasedWebActivity.this, localBuilder.build().toString());
          WebTokenBasedWebActivity.this.p();
          WebTokenBasedWebActivity.this.b();
          return;
        }
      }
    });
  }

  protected final String c()
  {
    if (this.b == null)
      x();
    return this.b;
  }

  protected abstract String l();

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.WebTokenBasedWebActivity
 * JD-Core Version:    0.6.2
 */