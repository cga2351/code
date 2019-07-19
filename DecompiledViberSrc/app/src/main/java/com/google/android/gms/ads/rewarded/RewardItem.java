package com.google.android.gms.ads.rewarded;

public abstract interface RewardItem
{
  public static final RewardItem DEFAULT_REWARD = new zza();

  public abstract int getAmount();

  public abstract String getType();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.rewarded.RewardItem
 * JD-Core Version:    0.6.2
 */