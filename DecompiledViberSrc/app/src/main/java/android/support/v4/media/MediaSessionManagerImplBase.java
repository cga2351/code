package android.support.v4.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.support.v4.util.ObjectsCompat;
import android.text.TextUtils;
import android.util.Log;

class MediaSessionManagerImplBase
  implements MediaSessionManager.MediaSessionManagerImpl
{
  private static final boolean DEBUG = false;
  private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
  private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
  private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
  private static final String TAG = "MediaSessionManager";
  ContentResolver mContentResolver;
  Context mContext;

  MediaSessionManagerImplBase(Context paramContext)
  {
    this.mContext = paramContext;
    this.mContentResolver = this.mContext.getContentResolver();
  }

  private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl, String paramString)
  {
    if (paramRemoteUserInfoImpl.getPid() < 0)
      if (this.mContext.getPackageManager().checkPermission(paramString, paramRemoteUserInfoImpl.getPackageName()) != 0);
    while (this.mContext.checkPermission(paramString, paramRemoteUserInfoImpl.getPid(), paramRemoteUserInfoImpl.getUid()) == 0)
    {
      return true;
      return false;
    }
    return false;
  }

  public Context getContext()
  {
    return this.mContext;
  }

  boolean isEnabledNotificationListener(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    String str = Settings.Secure.getString(this.mContentResolver, "enabled_notification_listeners");
    boolean bool = false;
    String[] arrayOfString;
    if (str != null)
      arrayOfString = str.split(":");
    for (int i = 0; ; i++)
    {
      int j = arrayOfString.length;
      bool = false;
      if (i < j)
      {
        ComponentName localComponentName = ComponentName.unflattenFromString(arrayOfString[i]);
        if ((localComponentName != null) && (localComponentName.getPackageName().equals(paramRemoteUserInfoImpl.getPackageName())))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    do
      try
      {
        ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo(paramRemoteUserInfoImpl.getPackageName(), 0);
        if (localApplicationInfo.uid != paramRemoteUserInfoImpl.getUid())
        {
          if (DEBUG)
            Log.d("MediaSessionManager", "Package name " + paramRemoteUserInfoImpl.getPackageName() + " doesn't match with the uid " + paramRemoteUserInfoImpl.getUid());
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (!DEBUG);
        Log.d("MediaSessionManager", "Package " + paramRemoteUserInfoImpl.getPackageName() + " doesn't exist");
        return false;
      }
    while ((!isPermissionGranted(paramRemoteUserInfoImpl, "android.permission.STATUS_BAR_SERVICE")) && (!isPermissionGranted(paramRemoteUserInfoImpl, "android.permission.MEDIA_CONTENT_CONTROL")) && (paramRemoteUserInfoImpl.getUid() != 1000) && (!isEnabledNotificationListener(paramRemoteUserInfoImpl)));
    return true;
  }

  static class RemoteUserInfoImplBase
    implements MediaSessionManager.RemoteUserInfoImpl
  {
    private String mPackageName;
    private int mPid;
    private int mUid;

    RemoteUserInfoImplBase(String paramString, int paramInt1, int paramInt2)
    {
      this.mPackageName = paramString;
      this.mPid = paramInt1;
      this.mUid = paramInt2;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      RemoteUserInfoImplBase localRemoteUserInfoImplBase;
      do
      {
        return true;
        if (!(paramObject instanceof RemoteUserInfoImplBase))
          return false;
        localRemoteUserInfoImplBase = (RemoteUserInfoImplBase)paramObject;
      }
      while ((TextUtils.equals(this.mPackageName, localRemoteUserInfoImplBase.mPackageName)) && (this.mPid == localRemoteUserInfoImplBase.mPid) && (this.mUid == localRemoteUserInfoImplBase.mUid));
      return false;
    }

    public String getPackageName()
    {
      return this.mPackageName;
    }

    public int getPid()
    {
      return this.mPid;
    }

    public int getUid()
    {
      return this.mUid;
    }

    public int hashCode()
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.mPackageName;
      arrayOfObject[1] = Integer.valueOf(this.mPid);
      arrayOfObject[2] = Integer.valueOf(this.mUid);
      return ObjectsCompat.hash(arrayOfObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaSessionManagerImplBase
 * JD-Core Version:    0.6.2
 */