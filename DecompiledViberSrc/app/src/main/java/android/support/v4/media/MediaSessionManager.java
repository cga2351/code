package android.support.v4.media;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;

public final class MediaSessionManager
{
  static final boolean DEBUG = false;
  static final String TAG = "MediaSessionManager";
  private static final Object sLock = new Object();
  private static volatile MediaSessionManager sSessionManager;
  MediaSessionManagerImpl mImpl;

  private MediaSessionManager(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mImpl = new MediaSessionManagerImplApi28(paramContext);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mImpl = new MediaSessionManagerImplApi21(paramContext);
      return;
    }
    this.mImpl = new MediaSessionManagerImplBase(paramContext);
  }

  public static MediaSessionManager getSessionManager(Context paramContext)
  {
    MediaSessionManager localMediaSessionManager1 = sSessionManager;
    if (localMediaSessionManager1 == null)
      synchronized (sLock)
      {
        MediaSessionManager localMediaSessionManager2 = sSessionManager;
        if (localMediaSessionManager2 == null)
        {
          sSessionManager = new MediaSessionManager(paramContext.getApplicationContext());
          localMediaSessionManager2 = sSessionManager;
        }
        return localMediaSessionManager2;
      }
    return localMediaSessionManager1;
  }

  Context getContext()
  {
    return this.mImpl.getContext();
  }

  public boolean isTrustedForMediaControl(RemoteUserInfo paramRemoteUserInfo)
  {
    if (paramRemoteUserInfo == null)
      throw new IllegalArgumentException("userInfo should not be null");
    return this.mImpl.isTrustedForMediaControl(paramRemoteUserInfo.mImpl);
  }

  static abstract interface MediaSessionManagerImpl
  {
    public abstract Context getContext();

    public abstract boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl);
  }

  public static final class RemoteUserInfo
  {
    public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
    MediaSessionManager.RemoteUserInfoImpl mImpl;

    public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo paramRemoteUserInfo)
    {
      this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(paramRemoteUserInfo);
    }

    public RemoteUserInfo(String paramString, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(paramString, paramInt1, paramInt2);
        return;
      }
      this.mImpl = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(paramString, paramInt1, paramInt2);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject)
        return true;
      if (!(paramObject instanceof RemoteUserInfo))
        return false;
      return this.mImpl.equals(((RemoteUserInfo)paramObject).mImpl);
    }

    public String getPackageName()
    {
      return this.mImpl.getPackageName();
    }

    public int getPid()
    {
      return this.mImpl.getPid();
    }

    public int getUid()
    {
      return this.mImpl.getUid();
    }

    public int hashCode()
    {
      return this.mImpl.hashCode();
    }
  }

  static abstract interface RemoteUserInfoImpl
  {
    public abstract String getPackageName();

    public abstract int getPid();

    public abstract int getUid();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaSessionManager
 * JD-Core Version:    0.6.2
 */