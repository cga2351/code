package com.google.ads.mediation.mytarget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Iterator;

class a
{
  private static final e a = ViberEnv.getLogger();

  static int a(Context paramContext, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      a.d("Failed to request ad from MyTarget: Context is null.", new Object[0]);
      return -1;
    }
    if (paramBundle == null)
    {
      a.d("Failed to request ad from MyTarget: serverParameters is null.", new Object[0]);
      return -1;
    }
    String str = paramBundle.getString("slotId");
    if (TextUtils.isEmpty(str))
    {
      a.d("Failed to request ad from MyTarget: Missing or Invalid Slot ID.", new Object[0]);
      return -1;
    }
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      a.a(localNumberFormatException, "Failed to request ad from MyTarget.", new Object[0]);
    }
    return -1;
  }

  public static AdSize a(Context paramContext, AdSize paramAdSize, ArrayList<AdSize> paramArrayList)
  {
    Object localObject1 = null;
    if (paramArrayList != null)
    {
      localObject1 = null;
      if (paramAdSize != null);
    }
    else
    {
      return localObject1;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    AdSize localAdSize = new AdSize(Math.round(paramAdSize.getWidthInPixels(paramContext) / f), Math.round(paramAdSize.getHeightInPixels(paramContext) / f));
    Iterator localIterator = paramArrayList.iterator();
    label65: Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (AdSize)localIterator.next();
      if (!a(localAdSize, (AdSize)localObject2))
        break label118;
      if (localObject1 != null)
        break label107;
    }
    while (true)
    {
      localObject1 = localObject2;
      break label65;
      break;
      label107: localObject2 = b((AdSize)localObject1, (AdSize)localObject2);
      continue;
      label118: localObject2 = localObject1;
    }
  }

  private static boolean a(AdSize paramAdSize1, AdSize paramAdSize2)
  {
    if (paramAdSize2 == null);
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      i = paramAdSize1.getWidth();
      j = paramAdSize2.getWidth();
      k = paramAdSize1.getHeight();
      m = paramAdSize2.getHeight();
    }
    while ((0.5D * i > j) || (i < j) || (0.7D * k > m) || (k < m));
    return true;
  }

  private static AdSize b(AdSize paramAdSize1, AdSize paramAdSize2)
  {
    if (paramAdSize1.getWidth() * paramAdSize1.getHeight() > paramAdSize2.getWidth() * paramAdSize2.getHeight())
      return paramAdSize1;
    return paramAdSize2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.mytarget.a
 * JD-Core Version:    0.6.2
 */