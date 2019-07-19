package com.viber.voip.user.more;

abstract interface MorePermissionHelper
{
  public abstract void registerPermissionsGrantedListener(PermissionsGrantedListener paramPermissionsGrantedListener);

  public abstract void requestPermissionsWithCheck(int paramInt, String[] paramArrayOfString);

  public abstract void unregisterPermissionsGrantedListener();

  public static abstract interface PermissionsGrantedListener
  {
    public abstract void onPermissionsGranted(int paramInt, String[] paramArrayOfString, Object paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MorePermissionHelper
 * JD-Core Version:    0.6.2
 */