package com.viber.voip.market;

import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.b.d;

@Deprecated
public class StickerPurchaseDialogActivity extends MarketDialogActivity
{
  private static final Logger d = ViberEnv.getLogger();
  private String k;

  public static void d(String paramString)
  {
    Intent localIntent = a(StickerPurchaseDialogActivity.class);
    localIntent.putExtra("checkout", paramString);
    a(localIntent);
  }

  private void l()
  {
    if (getIntent() != null);
    for (final String str = getIntent().getStringExtra("checkout"); ; str = "")
    {
      new d().a(new MarketApi.c()
      {
        public void a(String paramAnonymousString)
        {
          if (!StickerPurchaseDialogActivity.this.isDestroyed())
            StickerPurchaseDialogActivity.this.b(false);
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
        {
          if (!StickerPurchaseDialogActivity.this.isDestroyed())
          {
            StickerPurchaseDialogActivity localStickerPurchaseDialogActivity = StickerPurchaseDialogActivity.this;
            Object[] arrayOfObject = new Object[5];
            arrayOfObject[0] = ap.c().ar;
            arrayOfObject[1] = paramAnonymousString1;
            arrayOfObject[2] = str;
            arrayOfObject[3] = Long.valueOf(paramAnonymousLong);
            arrayOfObject[4] = paramAnonymousString2;
            StickerPurchaseDialogActivity.a(localStickerPurchaseDialogActivity, String.format("%s%s/checkout/%s/ts/%s/token/%s/", arrayOfObject));
            StickerPurchaseDialogActivity.this.p();
            StickerPurchaseDialogActivity.this.b();
          }
        }
      });
      return;
    }
  }

  protected String a(String paramString)
  {
    return paramString;
  }

  protected String c()
  {
    if (this.k == null)
      l();
    return this.k;
  }

  protected String d()
  {
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.StickerPurchaseDialogActivity
 * JD-Core Version:    0.6.2
 */