package com.google.android.gms.gcm;

import android.net.Uri;
import android.os.Bundle;
import java.util.List;

public class TaskParams
{
  private final Bundle extras;
  private final String tag;
  private final List<Uri> zzaa;
  private final long zzaz;

  public TaskParams(String paramString)
  {
    this(paramString, null);
  }

  public TaskParams(String paramString, Bundle paramBundle)
  {
    this(paramString, paramBundle, null);
  }

  TaskParams(String paramString, Bundle paramBundle, long paramLong, List<Uri> paramList)
  {
    this.tag = paramString;
    this.extras = paramBundle;
    this.zzaz = paramLong;
    this.zzaa = paramList;
  }

  public TaskParams(String paramString, Bundle paramBundle, List<Uri> paramList)
  {
    this(paramString, paramBundle, 180L, paramList);
  }

  public Bundle getExtras()
  {
    return this.extras;
  }

  public String getTag()
  {
    return this.tag;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.TaskParams
 * JD-Core Version:    0.6.2
 */