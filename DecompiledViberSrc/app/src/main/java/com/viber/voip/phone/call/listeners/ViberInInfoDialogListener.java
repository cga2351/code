package com.viber.voip.phone.call.listeners;

import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallStats;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.m;

public class ViberInInfoDialogListener
  implements DialerControllerDelegate.DialerLocalCallState, CallHandler.CallInfoReadyListener
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int SHOW_TIMEOUT = 2000;
  private CallInfo mCallInfo;

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((this.mCallInfo == null) || (this.mCallInfo.getInCallState() == null));
    while ((!this.mCallInfo.isViberIn()) || (this.mCallInfo.isViberCall()) || (this.mCallInfo.getInCallState().getCallStats().getCallDuration() < 2000L) || (d.m.g.d()))
      return;
    d.m.g.a(bool);
    if (!ao.f());
    while (true)
    {
      com.viber.voip.ui.dialogs.b.a(bool).d();
      return;
      bool = false;
    }
  }

  public void onCallInfoReady(CallInfo paramCallInfo)
  {
    this.mCallInfo = paramCallInfo;
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
  }

  public void onHangup()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.listeners.ViberInInfoDialogListener
 * JD-Core Version:    0.6.2
 */