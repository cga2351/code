package com.viber.common.permission;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class b
{
  public int[] acceptOnly()
  {
    return null;
  }

  public void onCustomDialogAction(int paramInt1, String paramString, int paramInt2)
  {
  }

  public void onExplainPermissions(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
  }

  @Subscribe
  public final void onPermissionDialogAction(a parama)
  {
    int i = parama.a;
    int[] arrayOfInt = acceptOnly();
    if ((arrayOfInt != null) && (!com.viber.common.d.b.a(arrayOfInt, i)))
      return;
    onCustomDialogAction(parama.a, parama.b, parama.c);
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public final void onPermissionResult(e parame)
  {
    PermissionRequest localPermissionRequest = parame.b;
    int i = localPermissionRequest.mRequestCode;
    int[] arrayOfInt = acceptOnly();
    if ((arrayOfInt != null) && (!com.viber.common.d.b.a(arrayOfInt, i)))
      return;
    switch (parame.a)
    {
    default:
      return;
    case 0:
      onPermissionsGranted(i, parame.c, localPermissionRequest.mExtra);
      return;
    case 1:
    case 2:
      if (parame.a == 2);
      for (boolean bool = true; ; bool = false)
      {
        onPermissionsDenied(i, bool, parame.d, parame.c, localPermissionRequest.mExtra);
        return;
      }
    case 3:
    }
    onExplainPermissions(i, parame.d, localPermissionRequest.mExtra);
  }

  public abstract void onPermissionsDenied(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, Object paramObject);

  public abstract void onPermissionsGranted(int paramInt, String[] paramArrayOfString, Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.permission.b
 * JD-Core Version:    0.6.2
 */