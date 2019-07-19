package com.viber.voip.billing;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.dialogs.af;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.QueryProductDetailsFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class ab extends u
{
  private static final Logger a = b.a(ab.class);
  private static b.t b;

  public ab(v paramv)
  {
    super(paramv);
  }

  private void a(int paramInt)
  {
    Application localApplication = ViberApplication.getApplication();
    Intent localIntent = new Intent("purchase_failure");
    localIntent.putExtra("purchase_iab_error", paramInt);
    LocalBroadcastManager.getInstance(localApplication).sendBroadcast(localIntent);
  }

  private void a(Purchase paramPurchase, aa paramaa)
  {
    Application localApplication = ViberApplication.getApplication();
    Intent localIntent = new Intent("purchase_verification");
    if (paramPurchase == null);
    for (String str = null; ; str = paramPurchase.getOrderId())
    {
      localIntent.putExtra("purchase_order_id", str);
      localIntent.putExtra("purchase_verification_result", paramaa.ordinal());
      LocalBroadcastManager.getInstance(localApplication).sendBroadcast(localIntent);
      return;
    }
  }

  public static void a(b.t paramt)
  {
    b = paramt;
  }

  private void c(final Purchase paramPurchase)
  {
    b.a().a(new b.j()
    {
      public void a(b.g paramAnonymousg)
      {
        if ((paramAnonymousg != null) && (paramAnonymousg.a()))
        {
          f localf = b.a().a(paramPurchase.getProductId());
          if (localf != null)
            ab.this.a(paramPurchase, localf.c(), "Viber Out credits", ()(1000000.0D * localf.e()), localf.d());
        }
      }
    });
  }

  public void a()
  {
    af.c().d(true).d();
  }

  public void a(Purchase paramPurchase)
  {
    if (!paramPurchase.isVerified())
    {
      b().a(paramPurchase, null);
      return;
    }
    if ((!paramPurchase.isConsumed()) && (paramPurchase.getProductId() != null) && ("inapp".equals(paramPurchase.getProductId().getItemType())))
    {
      b().a(paramPurchase);
      return;
    }
    paramPurchase.setPending(false);
    b().b(paramPurchase);
  }

  public void a(final Purchase paramPurchase, z paramz)
  {
    super.a(paramPurchase, paramz);
    a(paramPurchase, paramz.a);
    if (paramz.a == aa.a)
    {
      if (!paramPurchase.isRetrying())
        l.a().c().queryProductDetailsAsync(paramPurchase.getProductId(), new InAppBillingHelper.QueryProductDetailsFinishedListener()
        {
          public void onQueryProductDetailsFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
          {
            boolean bool = paramAnonymousIabResult.isSuccess();
            int i = 0;
            if (bool)
            {
              ProductDetails localProductDetails = paramAnonymousIabInventory.getProductDetails(paramPurchase.getProductId());
              i = 0;
              if (localProductDetails != null)
              {
                String str = localProductDetails.getPriceString();
                b.t localt = ab.c();
                ab.b(null);
                PurchaseSupportActivity.a(str, localt, paramPurchase.isCallingPlanPurchase(), paramPurchase.getAdditionalParams());
                i = 1;
              }
            }
            if (i == 0)
              ab.this.b().c();
            if ("inapp".equals(paramPurchase.getProductId().getItemType()))
              ab.this.b().a(paramPurchase);
          }
        });
      c(paramPurchase);
    }
  }

  public void a(final Purchase paramPurchase, String paramString, final u.a parama)
  {
    l.a().c().queryProductDetailsAsync(paramPurchase.getProductId(), new InAppBillingHelper.QueryProductDetailsFinishedListener()
    {
      public void onQueryProductDetailsFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        if (paramAnonymousIabResult.isSuccess())
        {
          ProductDetails localProductDetails = paramAnonymousIabInventory.getProductDetails(paramPurchase.getProductId());
          if (localProductDetails != null)
          {
            b.a().a(paramPurchase, localProductDetails, new b.y()
            {
              public void a(b.c paramAnonymous2c)
              {
                z localz;
                if (paramAnonymous2c.a())
                  localz = new z(aa.a);
                while (true)
                {
                  ab.2.this.b.a(localz);
                  return;
                  if (paramAnonymous2c.c() == 104)
                    localz = new z(aa.b, "verifyVOProductPurchase: INVALID RECEIPT: " + paramAnonymous2c.e());
                  else
                    localz = new z(aa.c, "verifyVOProductPurchase error: " + paramAnonymous2c.e());
                }
              }
            });
            return;
          }
          parama.a(new z(aa.c, "No product details"));
          return;
        }
        parama.a(new z(aa.c, "Query product details failed"));
      }
    });
  }

  public void a(Purchase paramPurchase, String paramString1, String paramString2, Bundle paramBundle)
  {
    b().b(paramPurchase);
    if (paramString2 == null)
      paramString2 = b().d().getString(R.string.viberout_dialog_payment_in_progress);
    b().a(paramString2);
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals("calling_plan")))
      paramPurchase.setCallingPlanPurchase(true);
    paramPurchase.setAdditionalParams(paramBundle);
    b().a(paramPurchase, null);
  }

  public void a(IabResult paramIabResult, IabProductId paramIabProductId)
  {
    b(paramIabResult, paramIabProductId);
    super.a(paramIabResult, paramIabProductId);
  }

  public void a(IabResult paramIabResult, Purchase paramPurchase)
  {
    b(paramIabResult, paramPurchase.getProductId());
    super.a(paramIabResult, paramPurchase);
  }

  public boolean a(IabProductId paramIabProductId)
  {
    ProductCategory localProductCategory = paramIabProductId.getProductId().getCategory();
    return (localProductCategory == ProductCategory.VIBER_OUT_CREDIT) || (localProductCategory == ProductCategory.VLN);
  }

  public void b(IabProductId paramIabProductId)
  {
    super.b(paramIabProductId);
    a(1);
  }

  void b(IabResult paramIabResult, IabProductId paramIabProductId)
  {
    a.a(new Exception("Purchase " + paramIabProductId + " failed: " + paramIabResult.getResponse()), paramIabResult.getMessage());
    a(paramIabResult.getResponse());
    if (paramIabResult.getResponse() == 7)
      b().a(paramIabProductId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.ab
 * JD-Core Version:    0.6.2
 */