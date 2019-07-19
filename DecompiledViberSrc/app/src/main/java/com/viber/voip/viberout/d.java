package com.viber.voip.viberout;

import android.text.TextUtils;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.ab;
import com.viber.voip.billing.b.t;
import com.viber.voip.market.MarketApi.g;
import com.viber.voip.market.VOPurchaseDialogActivity;
import com.viber.voip.market.b.f;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.ui.dialogs.b;

public class d extends DialerLocalCallStateListener
{
  private static final Logger a = ViberEnv.getLogger();

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    CallHandler localCallHandler = ViberApplication.getInstance().getEngine(true).getCallHandler();
    if ((paramInt1 == 12) || (paramInt1 == 15))
    {
      localCallHandler.handleHangup();
      localt = new b.t(localCallHandler.getLastCallInfo().getCallerInfo().getPhoneNumber());
      ab.a(localt);
      str = localt.b();
      localf = new f();
      if (TextUtils.isEmpty(str))
        localf.a(paramString, new MarketApi.g()
        {
          public void a(String paramAnonymousString1, String paramAnonymousString2)
          {
            VOPurchaseDialogActivity.b("no_credit_for_call", paramAnonymousString1, paramAnonymousString2);
          }
        });
    }
    while ((paramInt1 != 13) && (paramInt1 != 16))
      while (true)
      {
        b.t localt;
        String str;
        f localf;
        return;
        paramString = str;
      }
    b.h().d();
    localCallHandler.handleHangup();
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
  }

  public void onHangup()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.d
 * JD-Core Version:    0.6.2
 */