package com.viber.voip.market;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.b.d;

public class ViberOutWelcomeActivity extends MarketDialogActivity
{
  private static final Logger d = ViberEnv.getLogger();
  private String k;

  public static void d(String paramString)
  {
    Intent localIntent = a(ViberOutWelcomeActivity.class);
    localIntent.putExtra("origin", paramString);
    a(localIntent);
  }

  public static void l()
  {
    a(a(ViberOutWelcomeActivity.class));
  }

  private void x()
  {
    new d().a(new MarketApi.c()
    {
      public void a(String paramAnonymousString)
      {
        if (!ViberOutWelcomeActivity.this.isDestroyed())
          ViberOutWelcomeActivity.this.b(false);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        if (!ViberOutWelcomeActivity.this.isDestroyed())
        {
          ViberOutWelcomeActivity localViberOutWelcomeActivity = ViberOutWelcomeActivity.this;
          Object[] arrayOfObject = new Object[4];
          arrayOfObject[0] = ap.c().X;
          arrayOfObject[1] = paramAnonymousString1;
          arrayOfObject[2] = Long.valueOf(paramAnonymousLong);
          arrayOfObject[3] = paramAnonymousString2;
          ViberOutWelcomeActivity.a(localViberOutWelcomeActivity, String.format("%sphone/%s/ts/%s/token/%s", arrayOfObject));
          ViberOutWelcomeActivity.this.p();
          ViberOutWelcomeActivity.this.b();
        }
      }
    });
  }

  protected String a(String paramString)
  {
    String str = super.a(paramString);
    if (getIntent().hasExtra("origin"))
      str = Uri.parse(str).buildUpon().appendQueryParameter("origin", getIntent().getStringExtra("origin")).build().toString();
    return str;
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.c.setGravity(1);
  }

  protected String c()
  {
    if (this.k == null)
      x();
    return this.k;
  }

  protected String d()
  {
    return "";
  }

  protected ViberWebApiActivity.b j()
  {
    return ViberWebApiActivity.b.f;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.ViberOutWelcomeActivity
 * JD-Core Version:    0.6.2
 */