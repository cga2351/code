package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
public class StringResourceValueReader
{
  private final Resources zzeu;
  private final String zzev;

  public StringResourceValueReader(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.zzeu = paramContext.getResources();
    this.zzev = this.zzeu.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }

  @Nullable
  @KeepForSdk
  public String getString(String paramString)
  {
    int i = this.zzeu.getIdentifier(paramString, "string", this.zzev);
    if (i == 0)
      return null;
    return this.zzeu.getString(i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.StringResourceValueReader
 * JD-Core Version:    0.6.2
 */