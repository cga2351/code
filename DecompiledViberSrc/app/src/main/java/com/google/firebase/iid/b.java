package com.google.firebase.iid;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import javax.annotation.Nullable;

@KeepForSdk
public abstract interface b
{
  @KeepForSdk
  public abstract Task<Void> a(String paramString);

  @KeepForSdk
  public abstract Task<Void> a(String paramString1, String paramString2, String paramString3);

  @KeepForSdk
  public abstract Task<String> a(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);

  @KeepForSdk
  public abstract boolean a();

  @KeepForSdk
  public abstract Task<Void> b(String paramString1, String paramString2, String paramString3);

  @KeepForSdk
  public abstract Task<Void> b(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);

  @KeepForSdk
  public abstract boolean b();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.b
 * JD-Core Version:    0.6.2
 */