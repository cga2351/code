package com.mopub.mobileads.dfp.adapters;

import android.graphics.drawable.Drawable;
import java.util.HashMap;

public abstract interface DrawableDownloadListener
{
  public abstract void onDownloadFailure();

  public abstract void onDownloadSuccess(HashMap<String, Drawable> paramHashMap);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.dfp.adapters.DrawableDownloadListener
 * JD-Core Version:    0.6.2
 */