package com.viber.voip.phone.viber.dialog;

import android.app.Activity;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k.a;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.controller.SecureCallListener;
import com.viber.voip.ui.dialogs.b;
import com.viber.voip.util.cs;

public class SecureStateDescription
{
  private Activity mActivity;
  private CallInfo mCallInfo;

  public SecureStateDescription(Activity paramActivity, CallInfo paramCallInfo)
  {
    this.mActivity = paramActivity;
    this.mCallInfo = paramCallInfo;
  }

  public void showSecureStateDialog()
  {
    InCallState localInCallState = this.mCallInfo.getInCallState();
    String str = this.mCallInfo.getCallerInfo().getSecureStateContactName();
    int i = SecureCallListener.SECURITY_TRUST_STATE_SELECTOR.a(localInCallState.getSecureState());
    if (PeerTrustState.PeerTrustEnum.SECURE_TRUSTED.ordinal() == i)
      b.a(str, localInCallState.getSharedSecretString()).a(this.mActivity);
    do
    {
      return;
      if (PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED.ordinal() == i)
      {
        b.a(str, localInCallState.getSharedSecretString(), localInCallState.getPeerCid(), localInCallState.getSharedSecret()).a(this.mActivity);
        return;
      }
    }
    while (PeerTrustState.PeerTrustEnum.SECURE_TRUSTED_BREACH.ordinal() != i);
    if (localInCallState.isCallEncrypted())
    {
      b.b(str, localInCallState.getSharedSecretString(), localInCallState.getPeerCid(), localInCallState.getSharedSecret()).a(this.mActivity);
      return;
    }
    b.b(str).a(this.mActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.dialog.SecureStateDescription
 * JD-Core Version:    0.6.2
 */