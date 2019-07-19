package com.viber.voip.phone.call.listeners;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerControllerDelegate.DialerIncomingScreen;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.CallType;
import com.viber.voip.sound.tones.IRingtonePlayer;
import dagger.a;
import java.util.Map;

public class RingerListener
  implements DialerControllerDelegate.DialerIncomingScreen, CallHandler.CallInfoReadyListener
{
  private static final Logger L = ViberEnv.getLogger();
  private CallInfo mCallInfo;
  private a<IRingtonePlayer> mRingtoneService;
  private boolean mShowReception = false;

  public RingerListener(a<IRingtonePlayer> parama)
  {
    this.mRingtoneService = parama;
  }

  public void hideReception()
  {
    this.mShowReception = false;
    this.mCallInfo = null;
    ((IRingtonePlayer)this.mRingtoneService.get()).stopCallTone();
  }

  public void onCallInfoReady(final CallInfo paramCallInfo)
  {
    if ((paramCallInfo != null) && (paramCallInfo.getType() == CallInfo.CallType.OUTGOING))
      return;
    av.a(av.e.e).post(new Runnable()
    {
      public void run()
      {
        RingerListener.access$002(RingerListener.this, paramCallInfo);
        if (RingerListener.this.mShowReception)
          ((IRingtonePlayer)RingerListener.this.mRingtoneService.get()).playCallTone(paramCallInfo);
      }
    });
  }

  public void showReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    this.mShowReception = true;
    if (this.mCallInfo != null)
      ((IRingtonePlayer)this.mRingtoneService.get()).playCallTone(this.mCallInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.listeners.RingerListener
 * JD-Core Version:    0.6.2
 */