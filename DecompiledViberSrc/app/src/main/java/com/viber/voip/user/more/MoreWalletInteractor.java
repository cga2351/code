package com.viber.voip.user.more;

import com.viber.common.b.b;
import com.viber.voip.wallet.a;

class MoreWalletInteractor
{
  private final b mRakutenWalletNewFeaturePref;
  private final a mWalletController;
  private final b mWuFirstWelcomePref;

  MoreWalletInteractor(a parama, b paramb1, b paramb2)
  {
    this.mWalletController = parama;
    this.mRakutenWalletNewFeaturePref = paramb1;
    this.mWuFirstWelcomePref = paramb2;
  }

  boolean isViberWalletAvailable()
  {
    return this.mWalletController.f();
  }

  boolean isWesternUnionWalletAvailable()
  {
    return this.mWalletController.c();
  }

  void resetNewFeature()
  {
    if (this.mRakutenWalletNewFeaturePref.d())
      this.mRakutenWalletNewFeaturePref.a(false);
    if (this.mWuFirstWelcomePref.d())
      this.mWuFirstWelcomePref.a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreWalletInteractor
 * JD-Core Version:    0.6.2
 */