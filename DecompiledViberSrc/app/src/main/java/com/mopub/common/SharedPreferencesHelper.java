package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesHelper
{
  public static final String DEFAULT_PREFERENCE_NAME = "mopubSettings";

  public static SharedPreferences getSharedPreferences(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return paramContext.getSharedPreferences("mopubSettings", 0);
  }

  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    return paramContext.getSharedPreferences(paramString, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.SharedPreferencesHelper
 * JD-Core Version:    0.6.2
 */