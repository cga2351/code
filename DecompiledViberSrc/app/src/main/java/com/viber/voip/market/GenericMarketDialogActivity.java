package com.viber.voip.market;

import android.content.Intent;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class GenericMarketDialogActivity extends MarketDialogActivity
{
  private static final Logger d = ViberEnv.getLogger();
  private String k;
  private String l;

  public static void a(String paramString1, String paramString2)
  {
    Intent localIntent = a(GenericMarketDialogActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("title", paramString2);
    a(localIntent);
  }

  protected String c()
  {
    return this.k;
  }

  protected String d()
  {
    return this.l;
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.k = getIntent().getStringExtra("url");
    this.l = getIntent().getStringExtra("title");
    super.onCreate(paramBundle);
    p();
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.GenericMarketDialogActivity
 * JD-Core Version:    0.6.2
 */