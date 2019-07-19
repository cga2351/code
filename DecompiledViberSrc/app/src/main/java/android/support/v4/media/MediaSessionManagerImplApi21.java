package android.support.v4.media;

import android.content.Context;

class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase
{
  MediaSessionManagerImplApi21(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }

  private boolean hasMediaControlPermission(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", paramRemoteUserInfoImpl.getPid(), paramRemoteUserInfoImpl.getUid()) == 0;
  }

  public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    return (hasMediaControlPermission(paramRemoteUserInfoImpl)) || (super.isTrustedForMediaControl(paramRemoteUserInfoImpl));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaSessionManagerImplApi21
 * JD-Core Version:    0.6.2
 */