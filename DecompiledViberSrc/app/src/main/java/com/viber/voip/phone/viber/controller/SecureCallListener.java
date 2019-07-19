package com.viber.voip.phone.viber.controller;

import android.util.SparseIntArray;
import android.widget.ImageButton;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.R.drawable;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.util.cs;
import java.util.Observable;
import java.util.Observer;

public class SecureCallListener
  implements Observer
{
  public static final cs SECURITY_TRUST_STATE_SELECTOR = new cs(arrayOfInt);
  private boolean mIsViberCall = true;
  private ImageButton mSecureCall;
  private SparseIntArray mSecurityIconSelector = new SparseIntArray(3);

  static
  {
    int[][] arrayOfInt = new int[6][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 4;
    arrayOfInt1[2] = PeerTrustState.PeerTrustEnum.SECURE_TRUSTED_BREACH.ordinal();
    arrayOfInt[0] = arrayOfInt1;
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 2;
    arrayOfInt2[2] = 4;
    arrayOfInt2[3] = PeerTrustState.PeerTrustEnum.SECURE_TRUSTED_BREACH.ordinal();
    arrayOfInt[1] = arrayOfInt2;
    int[] arrayOfInt3 = new int[4];
    arrayOfInt3[0] = 1;
    arrayOfInt3[1] = 2;
    arrayOfInt3[2] = 4;
    arrayOfInt3[3] = PeerTrustState.PeerTrustEnum.SECURE_TRUSTED_BREACH.ordinal();
    arrayOfInt[2] = arrayOfInt3;
    int[] arrayOfInt4 = new int[3];
    arrayOfInt4[0] = 1;
    arrayOfInt4[1] = 4;
    arrayOfInt4[2] = PeerTrustState.PeerTrustEnum.SECURE_TRUSTED.ordinal();
    arrayOfInt[3] = arrayOfInt4;
    int[] arrayOfInt5 = new int[3];
    arrayOfInt5[0] = 1;
    arrayOfInt5[1] = 2;
    arrayOfInt5[2] = PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED.ordinal();
    arrayOfInt[4] = arrayOfInt5;
    int[] arrayOfInt6 = new int[2];
    arrayOfInt6[0] = 1;
    arrayOfInt6[1] = PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED.ordinal();
    arrayOfInt[5] = arrayOfInt6;
  }

  public SecureCallListener(ImageButton paramImageButton)
  {
    this.mSecureCall = paramImageButton;
    this.mSecurityIconSelector.append(PeerTrustState.PeerTrustEnum.SECURE_TRUSTED_BREACH.ordinal(), R.drawable.btn_call_secure_breach_trusted);
    this.mSecurityIconSelector.append(PeerTrustState.PeerTrustEnum.SECURE_TRUSTED.ordinal(), R.drawable.btn_call_secure_trusted);
    this.mSecurityIconSelector.append(PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED.ordinal(), R.drawable.btn_call_secure_untrusted);
  }

  public void setSecureCallButton(ImageButton paramImageButton)
  {
    this.mSecureCall = paramImageButton;
  }

  public void setViberCallType(boolean paramBoolean)
  {
    this.mIsViberCall = paramBoolean;
    if (!this.mIsViberCall)
      this.mSecureCall.setVisibility(4);
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    if (!this.mIsViberCall)
    {
      this.mSecureCall.setVisibility(4);
      return;
    }
    InCallState localInCallState = (InCallState)paramObject;
    int i = this.mSecurityIconSelector.get(SECURITY_TRUST_STATE_SELECTOR.a(localInCallState.getSecureState()), -1);
    if (-1 != i)
    {
      if (i != 0)
        this.mSecureCall.setImageResource(i);
      while (true)
      {
        this.mSecureCall.setVisibility(0);
        return;
        this.mSecureCall.setImageDrawable(null);
      }
    }
    this.mSecureCall.setVisibility(4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.controller.SecureCallListener
 * JD-Core Version:    0.6.2
 */