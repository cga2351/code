package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ResourceDrawableIdHelper
{
  private static final String LOCAL_RESOURCE_SCHEME = "res";
  private static volatile ResourceDrawableIdHelper sResourceDrawableIdHelper;
  private Map<String, Integer> mResourceDrawableIdMap = new HashMap();

  public static ResourceDrawableIdHelper getInstance()
  {
    if (sResourceDrawableIdHelper == null);
    try
    {
      if (sResourceDrawableIdHelper == null)
        sResourceDrawableIdHelper = new ResourceDrawableIdHelper();
      return sResourceDrawableIdHelper;
    }
    finally
    {
    }
  }

  public void clear()
  {
    try
    {
      this.mResourceDrawableIdMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public Drawable getResourceDrawable(Context paramContext, @Nullable String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0)
      return paramContext.getResources().getDrawable(i);
    return null;
  }

  public int getResourceDrawableId(Context paramContext, @Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return 0;
    String str = paramString.toLowerCase().replace("-", "_");
    try
    {
      int k = Integer.parseInt(str);
      return k;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        if (this.mResourceDrawableIdMap.containsKey(str))
        {
          int j = ((Integer)this.mResourceDrawableIdMap.get(str)).intValue();
          return j;
        }
      }
      finally
      {
      }
      int i = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
      this.mResourceDrawableIdMap.put(str, Integer.valueOf(i));
      return i;
    }
  }

  public Uri getResourceDrawableUri(Context paramContext, @Nullable String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0)
      return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    return Uri.EMPTY;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.imagehelper.ResourceDrawableIdHelper
 * JD-Core Version:    0.6.2
 */