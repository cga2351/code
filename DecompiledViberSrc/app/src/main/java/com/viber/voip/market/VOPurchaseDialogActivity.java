package com.viber.voip.market;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.b.d;
import com.viber.voip.util.da;
import javax.inject.Inject;

public class VOPurchaseDialogActivity extends MarketDialogActivity
{
  private static final Logger k = ViberEnv.getLogger();

  @Inject
  dagger.a<e> d;
  private String l;
  private String m;
  private String n;

  public static void b(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = a(VOPurchaseDialogActivity.class);
    localIntent.putExtra("origin", paramString1);
    localIntent.putExtra("contact_name", paramString2);
    localIntent.putExtra("contact_country_code", paramString3);
    a(localIntent);
  }

  public static void d(String paramString)
  {
    Intent localIntent = a(VOPurchaseDialogActivity.class);
    localIntent.putExtra("origin", paramString);
    a(localIntent);
  }

  private String h(String paramString)
  {
    return Uri.parse(paramString).buildUpon().appendQueryParameter("origin", x()).build().toString();
  }

  private String i(String paramString)
  {
    if (getIntent().hasExtra("contact_name"))
      paramString = Uri.parse(paramString).buildUpon().appendQueryParameter("contact_name", getIntent().getStringExtra("contact_name")).appendQueryParameter("contact_cc", getIntent().getStringExtra("contact_country_code")).build().toString();
    return paramString;
  }

  private void l()
  {
    new d().a(new MarketApi.c()
    {
      public void a(String paramAnonymousString)
      {
        if (!VOPurchaseDialogActivity.this.isDestroyed())
          VOPurchaseDialogActivity.this.b(false);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        if (!VOPurchaseDialogActivity.this.isDestroyed())
        {
          VOPurchaseDialogActivity localVOPurchaseDialogActivity = VOPurchaseDialogActivity.this;
          Object[] arrayOfObject = new Object[4];
          arrayOfObject[0] = ap.c().W;
          arrayOfObject[1] = paramAnonymousString1;
          arrayOfObject[2] = Long.valueOf(paramAnonymousLong);
          arrayOfObject[3] = paramAnonymousString2;
          VOPurchaseDialogActivity.a(localVOPurchaseDialogActivity, String.format("%sphone/%s/ts/%s/token/%s", arrayOfObject));
          VOPurchaseDialogActivity.this.p();
          VOPurchaseDialogActivity.this.b();
        }
      }
    });
  }

  private String x()
  {
    if (da.a(this.m))
      return "vo_more_screen";
    return this.m;
  }

  protected String a(String paramString)
  {
    return i(h(super.a(paramString)));
  }

  protected String c()
  {
    if (this.l == null)
      l();
    return this.l;
  }

  protected String d()
  {
    return "";
  }

  protected int e()
  {
    return R.layout.vo_purchase_dialog_layout;
  }

  public void e_(String paramString)
  {
  }

  protected ViberWebApiActivity.b j()
  {
    return ViberWebApiActivity.b.d;
  }

  protected boolean k()
  {
    return false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    this.m = getIntent().getStringExtra("origin");
    this.n = getIntent().getStringExtra("contact_country_code");
    super.onCreate(paramBundle);
    if ("no_credit_for_call".equals(this.m))
      ((e)this.d.get()).a(this.n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.VOPurchaseDialogActivity
 * JD-Core Version:    0.6.2
 */