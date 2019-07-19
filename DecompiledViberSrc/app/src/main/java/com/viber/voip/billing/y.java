package com.viber.voip.billing;

import android.os.Bundle;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.settings.d.f;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.i.a;
import com.viber.voip.ui.dialogs.af;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.QueryProductDetailsFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class y extends u
{
  private static final Logger a = b.a(y.class);

  public y(v paramv)
  {
    super(paramv);
  }

  private boolean b(IabResult paramIabResult, IabProductId paramIabProductId)
  {
    switch (paramIabResult.getResponse())
    {
    default:
      l.b(null, false);
      return false;
    case 7:
    }
    a(paramIabProductId, true);
    l.b(null, false);
    b().c();
    return true;
  }

  public void a(Purchase paramPurchase)
  {
    if (!paramPurchase.isVerified())
    {
      b().a(paramPurchase, null);
      return;
    }
    paramPurchase.setPending(false);
    b().b(paramPurchase);
  }

  public void a(Purchase paramPurchase, z paramz)
  {
    super.a(paramPurchase, paramz);
    if (paramz.a == aa.a)
    {
      d.f.g.a(true);
      b().c();
      int i = paramPurchase.getProductId().getProductId().getPackageId();
      i.a().a(i, i.a.a);
      paramPurchase.setPending(false);
      b().b(paramPurchase);
      a(paramPurchase, paramPurchase.getProductId().toString(), "Stickers", 1990000L, "USD");
    }
  }

  public void a(final Purchase paramPurchase, final String paramString, final u.a parama)
  {
    l.a().c().queryProductDetailsAsync(paramPurchase.getProductId(), new InAppBillingHelper.QueryProductDetailsFinishedListener()
    {
      public void onQueryProductDetailsFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        if (paramAnonymousIabResult.isSuccess())
        {
          ProductDetails localProductDetails = paramAnonymousIabInventory.getProductDetails(paramPurchase.getProductId());
          if (localProductDetails == null)
          {
            parama.a(new z(aa.c, "No product details"));
            return;
          }
          b.a().a(paramPurchase, paramString, localProductDetails, false, new b.x()
          {
            public void a(b.c paramAnonymous2c)
            {
              z localz;
              if (paramAnonymous2c.a())
                localz = new z(aa.a);
              while (true)
              {
                y.1.this.b.a(localz);
                return;
                if (paramAnonymous2c.c() == 104)
                  localz = new z(aa.b, "verifyPaidProductPurchase: INVALID RECEIPT: " + paramAnonymous2c.e());
                else
                  localz = new z(aa.c, "verifyPaidProductPurchase error: " + paramAnonymous2c.e());
              }
            }
          });
          return;
        }
        parama.a(new z(aa.c, "product details failed " + paramAnonymousIabResult));
      }
    });
  }

  public void a(Purchase paramPurchase, String paramString1, String paramString2, Bundle paramBundle)
  {
    b().b(paramPurchase);
    b().a();
    b().a(paramPurchase, paramString1);
  }

  public void a(String paramString)
  {
    af.a(paramString).d(true).a(PurchaseSupportActivity.class);
  }

  public void a(IabResult paramIabResult, IabProductId paramIabProductId)
  {
    if (!b(paramIabResult, paramIabProductId))
      super.a(paramIabResult, paramIabProductId);
  }

  public void a(IabResult paramIabResult, Purchase paramPurchase)
  {
    if (!b(paramIabResult, paramPurchase.getProductId()))
      super.a(paramIabResult, paramPurchase);
  }

  public boolean a(IabProductId paramIabProductId)
  {
    return paramIabProductId.getProductId().getCategory() == ProductCategory.STICKER_PACKAGE;
  }

  public boolean a(IabProductId paramIabProductId, boolean paramBoolean)
  {
    int i = paramIabProductId.getProductId().getPackageId();
    i locali = i.a();
    if (!locali.l(i))
    {
      if (paramBoolean);
      for (i.a locala = i.a.e; ; locala = i.a.d)
      {
        locali.a(i, locala);
        return true;
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.y
 * JD-Core Version:    0.6.2
 */