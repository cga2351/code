package com.viber.common.permission;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;

class f
{
  static void a(Object paramObject, String[] paramArrayOfString, int paramInt)
  {
    if ((paramObject instanceof Activity))
    {
      ActivityCompat.requestPermissions((Activity)paramObject, paramArrayOfString, paramInt);
      return;
    }
    if ((paramObject instanceof Fragment))
    {
      ((Fragment)paramObject).requestPermissions(paramArrayOfString, paramInt);
      return;
    }
    throw new IllegalArgumentException("Permission must be requested from Activity or Fragment");
  }

  static boolean a(Object paramObject, String paramString)
  {
    if ((paramObject instanceof Activity))
      return ActivityCompat.shouldShowRequestPermissionRationale((Activity)paramObject, paramString);
    if ((paramObject instanceof Fragment))
      return ((Fragment)paramObject).shouldShowRequestPermissionRationale(paramString);
    throw new IllegalArgumentException("Permission must be requested from Activity or Fragment");
  }

  static boolean a(Object paramObject, ArrayList<String> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
      if (!a(paramObject, (String)localIterator.next()))
        return true;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.permission.f
 * JD-Core Version:    0.6.2
 */