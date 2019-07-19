package com.viber.voip.messages.conversation.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.phone.CallFragmentManager;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.util.da;
import java.util.Locale;
import javax.inject.Inject;

public class b extends a
{
  private Context b;
  private Handler c;
  private com.viber.voip.app.b d;
  private final CallHandler e;
  private final DialerPhoneStateListener f;
  private Runnable g = new c(this);
  private final DialerControllerDelegate.DialerPhoneState h = new d(this);

  @Inject
  public b(Context paramContext, Handler paramHandler, com.viber.voip.app.b paramb, CallHandler paramCallHandler, DialerPhoneStateListener paramDialerPhoneStateListener)
  {
    this.b = paramContext;
    this.c = paramHandler;
    this.d = paramb;
    this.e = paramCallHandler;
    this.f = paramDialerPhoneStateListener;
  }

  public String a(boolean paramBoolean)
  {
    if (paramBoolean);
    String str;
    do
    {
      return null;
      str = CallFragmentManager.recentTabletConversationCallerMemberId(this.d.a(this.b));
    }
    while (da.a(str));
    return String.format(Locale.US, "CASE WHEN member_id = '%s' THEN 0 ELSE 1 END", new Object[] { str });
  }

  protected void b()
  {
    super.b();
    DialerPhoneStateListener localDialerPhoneStateListener = this.f;
    CallHandler localCallHandler = this.e;
    Handler localHandler = this.c;
    DialerControllerDelegate.DialerPhoneState[] arrayOfDialerPhoneState = new DialerControllerDelegate.DialerPhoneState[1];
    arrayOfDialerPhoneState[0] = this.h;
    localDialerPhoneStateListener.registerDelegateQueue(localCallHandler, localHandler, arrayOfDialerPhoneState);
  }

  protected void c()
  {
    super.c();
    this.f.removeDelegate(this.h);
    this.c.removeCallbacks(this.g);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.a.b
 * JD-Core Version:    0.6.2
 */