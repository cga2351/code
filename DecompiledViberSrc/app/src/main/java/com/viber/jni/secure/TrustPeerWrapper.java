package com.viber.jni.secure;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.PeerTrustState;
import com.viber.voip.ViberEnv;

public class TrustPeerWrapper
  implements TrustPeerController
{
  private static final Logger L = ViberEnv.getLogger();
  private TrustPeerController mWrappedController;

  public TrustPeerWrapper(TrustPeerController paramTrustPeerController)
  {
    this.mWrappedController = paramTrustPeerController;
  }

  public String[] getBreachedPeersList()
  {
    return this.mWrappedController.getBreachedPeersList();
  }

  public String[] getTrustedPeersList()
  {
    return this.mWrappedController.getTrustedPeersList();
  }

  public int handleClearSecureCallStorage()
  {
    return this.mWrappedController.handleClearSecureCallStorage();
  }

  public void handleSecureCallVerified(int paramInt, byte[] paramArrayOfByte)
  {
    this.mWrappedController.handleSecureCallVerified(paramInt, paramArrayOfByte);
  }

  public boolean handleTrustPeer(String paramString, boolean paramBoolean)
  {
    return this.mWrappedController.handleTrustPeer(paramString, paramBoolean);
  }

  public PeerTrustState isPeerTrusted(String paramString)
  {
    PeerTrustState localPeerTrustState;
    if (TextUtils.isEmpty(paramString))
      localPeerTrustState = new PeerTrustState(false, false);
    do
    {
      return localPeerTrustState;
      localPeerTrustState = this.mWrappedController.isPeerTrusted(paramString);
    }
    while (localPeerTrustState != null);
    return new PeerTrustState(false, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.TrustPeerWrapper
 * JD-Core Version:    0.6.2
 */