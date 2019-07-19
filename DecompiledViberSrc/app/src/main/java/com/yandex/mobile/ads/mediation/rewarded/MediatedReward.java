package com.yandex.mobile.ads.mediation.rewarded;

import com.yandex.mobile.ads.rewarded.Reward;

final class MediatedReward
  implements Reward
{
  private final int a;
  private final String b;

  public MediatedReward(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }

  public final int getAmount()
  {
    return this.a;
  }

  public final String getType()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.rewarded.MediatedReward
 * JD-Core Version:    0.6.2
 */