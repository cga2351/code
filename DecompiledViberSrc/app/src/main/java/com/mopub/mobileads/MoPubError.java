package com.mopub.mobileads;

@Deprecated
public abstract interface MoPubError
{
  public static final int ER_ADAPTER_NOT_FOUND = 1;
  public static final int ER_INVALID_DATA = 3;
  public static final int ER_SUCCESS = 0;
  public static final int ER_TIMEOUT = 2;
  public static final int ER_UNSPECIFIED = 10000;

  public abstract int getIntCode();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.MoPubError
 * JD-Core Version:    0.6.2
 */