package com.viber.voip.billing;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class u
{
  private static final Logger a = b.a(u.class);
  private v b;

  public u(v paramv)
  {
    this.b = paramv;
  }

  public void a()
  {
    b().b();
  }

  public void a(Purchase paramPurchase)
  {
  }

  public void a(Purchase paramPurchase, z paramz)
  {
    switch (1.a[paramz.a.ordinal()])
    {
    default:
    case 1:
    case 2:
      do
      {
        do
        {
          return;
          paramPurchase.setVerified(true);
          b().b(paramPurchase);
        }
        while (!paramPurchase.isRetrying());
        l.a().e().b(paramPurchase);
        return;
        paramPurchase.setPending(false);
        b().b(paramPurchase);
        if (!paramPurchase.isRetrying())
          a(paramz.b);
      }
      while (!paramPurchase.isRetrying());
      l.a().e().b(paramPurchase);
      return;
    case 3:
    }
    if (!paramPurchase.isRetrying())
      a();
    b().c(paramPurchase);
  }

  public void a(Purchase paramPurchase, String paramString, a parama)
  {
    parama.a(new z(aa.c));
  }

  protected void a(Purchase paramPurchase, String paramString1, String paramString2, long paramLong, String paramString3)
  {
  }

  public void a(Purchase paramPurchase, String paramString1, String paramString2, Bundle paramBundle)
  {
    b().a();
    b().b(paramPurchase);
  }

  public void a(String paramString)
  {
    b().b();
  }

  public void a(IabResult paramIabResult, IabProductId paramIabProductId)
  {
    a(paramIabResult, paramIabProductId.getMerchantProductId());
  }

  public void a(IabResult paramIabResult, Purchase paramPurchase)
  {
    a(paramIabResult, paramPurchase.getProductId().getMerchantProductId());
  }

  void a(IabResult paramIabResult, String paramString)
  {
    l.a().a(paramIabResult, paramString);
  }

  public boolean a(IabProductId paramIabProductId)
  {
    return false;
  }

  public boolean a(IabProductId paramIabProductId, boolean paramBoolean)
  {
    return false;
  }

  protected v b()
  {
    return this.b;
  }

  public void b(IabProductId paramIabProductId)
  {
    b().c();
  }

  public void b(Purchase paramPurchase)
  {
    paramPurchase.setConsumed(true);
    paramPurchase.setPending(false);
    b().b(paramPurchase);
  }

  static abstract interface a
  {
    public abstract void a(z paramz);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.u
 * JD-Core Version:    0.6.2
 */