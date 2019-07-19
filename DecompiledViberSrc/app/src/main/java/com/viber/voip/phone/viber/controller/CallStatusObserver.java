package com.viber.voip.phone.viber.controller;

import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallStats;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.widget.PausableChronometer;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class CallStatusObserver
  implements Observer
{
  private static Logger L = ViberEnv.getLogger();
  private CallInfo mCallInfo;
  private CallReconnect mCallReconnect;
  private WeakReference<PausableChronometer> mCallStatusViewRef;
  private VoiceQualityUpdater mVoiceQualityUpdater;

  public CallStatusObserver(PausableChronometer paramPausableChronometer, CallInfo paramCallInfo)
  {
    this.mCallStatusViewRef = new WeakReference(paramPausableChronometer);
    this.mCallReconnect = new CallReconnect(paramPausableChronometer);
    this.mCallInfo = paramCallInfo;
  }

  private void setChronometerText(int paramInt)
  {
    PausableChronometer localPausableChronometer = (PausableChronometer)this.mCallStatusViewRef.get();
    if (localPausableChronometer != null)
      localPausableChronometer.setText(paramInt);
  }

  public void setCallInfo(CallInfo paramCallInfo)
  {
    if (paramCallInfo != this.mCallInfo)
    {
      PausableChronometer localPausableChronometer = (PausableChronometer)this.mCallStatusViewRef.get();
      if (localPausableChronometer != null)
        localPausableChronometer.removeCallbacks(this.mCallReconnect);
      this.mCallReconnect = new CallReconnect(localPausableChronometer);
      this.mCallInfo = paramCallInfo;
    }
  }

  public void setVoiceQualityUpdater(VoiceQualityUpdater paramVoiceQualityUpdater)
  {
    this.mVoiceQualityUpdater = paramVoiceQualityUpdater;
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    int i = 1;
    InCallState localInCallState = (InCallState)paramObject;
    if (this.mCallInfo.isCallInProgress())
    {
      label62: label86: PausableChronometer localPausableChronometer2;
      if (localInCallState.isDataInterrupted())
      {
        this.mCallReconnect.start();
        if (this.mVoiceQualityUpdater != null)
          this.mVoiceQualityUpdater.updateQuality();
        if (!localInCallState.isHoldEnabled())
          break label160;
        setChronometerText(R.string.on_hold);
        if ((!localInCallState.isDataInterrupted()) && (!localInCallState.isTransferring()) && (!localInCallState.isHoldEnabled()))
          break label178;
        localPausableChronometer2 = (PausableChronometer)this.mCallStatusViewRef.get();
        if (localPausableChronometer2 != null)
        {
          if (i == 0)
            break label183;
          localPausableChronometer2.stop();
        }
      }
      while (true)
      {
        if ((localInCallState.isCallEnded()) || (!localInCallState.isDataInterrupted()))
          this.mCallReconnect.stop();
        return;
        this.mCallReconnect.stop();
        if (this.mVoiceQualityUpdater == null)
          break;
        this.mVoiceQualityUpdater.updateQuality();
        break;
        label160: if (!localInCallState.isTransferring())
          break label62;
        setChronometerText(R.string.card_title_transferring);
        break label62;
        label178: i = 0;
        break label86;
        label183: localPausableChronometer2.setBase(SystemClock.elapsedRealtime() - localInCallState.getCallStats().getCallDuration());
        localPausableChronometer2.start();
      }
    }
    PausableChronometer localPausableChronometer1 = (PausableChronometer)this.mCallStatusViewRef.get();
    if (localPausableChronometer1 != null)
      localPausableChronometer1.stop();
    int j;
    switch (localInCallState.getState())
    {
    default:
      if (localInCallState.getDisconnectStatus() == 8)
        j = R.string.card_title_unavailable;
      break;
    case 4:
    case 6:
    case 5:
    case 7:
    case 3:
    }
    while (true)
    {
      setChronometerText(j);
      break;
      j = R.string.card_title_outgoing_call;
      continue;
      if (localInCallState.isPeerRinging())
      {
        j = R.string.card_title_outgoing_call_ringing;
      }
      else
      {
        j = R.string.card_title_outgoing_call;
        continue;
        if (this.mCallInfo.isTransfer())
        {
          j = R.string.card_title_transferred_call;
        }
        else
        {
          j = R.string.msg_call_incoming;
          continue;
          j = R.string.card_title_answering_call;
          continue;
          j = R.string.card_title_inprogress_call;
          continue;
          if (localInCallState.getEndReason() == 6)
            j = R.string.card_title_no_answer;
          else if (localInCallState.getEndReason() == i)
            j = R.string.card_title_busy_call;
          else if ((localInCallState.getEndReason() == 4) && (localInCallState.getCallStats().getCallDuration() > 0L))
            j = R.string.card_title_disconected_call;
          else if (localInCallState.isFailed())
            j = R.string.card_title_failed_call;
          else
            j = R.string.card_title_call_ended;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.controller.CallStatusObserver
 * JD-Core Version:    0.6.2
 */