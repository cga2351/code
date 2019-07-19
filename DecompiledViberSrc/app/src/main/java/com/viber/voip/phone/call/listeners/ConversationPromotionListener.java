package com.viber.voip.phone.call.listeners;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.h;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.CallType;
import com.viber.voip.phone.call.CallStats;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.dr;
import java.util.Observable;
import java.util.Observer;

public class ConversationPromotionListener extends PhoneControllerDelegateAdapter
  implements Observer
{
  private static final Logger L = ViberEnv.getLogger();
  private CallInfo mCallInfo;

  public ConversationPromotionListener(CallInfo paramCallInfo)
  {
    this.mCallInfo = paramCallInfo;
  }

  private void openConversationActivity(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = m.a(paramString1, dr.a(ViberApplication.getInstance(), paramString2, paramString2), paramString3, paramBoolean, false, false, false);
    localIntent.addFlags(268435456);
    ViberApplication.getApplication().startActivity(localIntent);
  }

  public boolean doPromotion(InCallState paramInCallState)
  {
    int i;
    if ((ViberApplication.getInstance().isOnForeground()) && (paramInCallState.getEndReason() != 10) && ((paramInCallState.getCallStats().getCallDuration() != 0L) || (this.mCallInfo.getType() == CallInfo.CallType.OUTGOING)) && ((paramInCallState.getDisconnectStatus() == 3) || ((paramInCallState.getEndReason() == 3) && (paramInCallState.getDisconnectStatus() == 0))))
    {
      i = 1;
      if (i != 0)
        break label79;
    }
    label79: 
    while ((this.mCallInfo.getCallerInfo().getContact() == null) || (this.mCallInfo.isViberOut()) || (!this.mCallInfo.isViberCall()))
    {
      return false;
      i = 0;
      break;
    }
    av.e.d.a().post(new Runnable()
    {
      public void run()
      {
        h localh = ab.b().a(ConversationPromotionListener.this.mCallInfo.getCallerInfo().getPhoneNumber(), false);
        if ((localh != null) && (localh.I()))
        {
          ViberApplication.getApplication().startActivity(ViberActionRunner.ab.a(ViberApplication.getApplication()).addFlags(268435456));
          return;
        }
        ConversationPromotionListener.this.openConversationActivity(ConversationPromotionListener.this.mCallInfo.getCallerInfo().getMemberId(), ConversationPromotionListener.this.mCallInfo.getCallerInfo().getPhoneNumber(), ConversationPromotionListener.this.mCallInfo.getCallerInfo().getName(), ConversationPromotionListener.this.mCallInfo.isFromSecretConversation());
      }
    });
    return true;
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    InCallState localInCallState = (InCallState)paramObject;
    if (localInCallState.getState() != 0)
      return;
    doPromotion(localInCallState);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.listeners.ConversationPromotionListener
 * JD-Core Version:    0.6.2
 */