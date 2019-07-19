package com.viber.voip.messages.conversation.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.phone.call.CallHandler;
import dagger.a.d;
import javax.inject.Provider;

public final class e
  implements d<b>
{
  private final Provider<Context> a;
  private final Provider<Handler> b;
  private final Provider<com.viber.voip.app.b> c;
  private final Provider<CallHandler> d;
  private final Provider<DialerPhoneStateListener> e;

  public e(Provider<Context> paramProvider, Provider<Handler> paramProvider1, Provider<com.viber.voip.app.b> paramProvider2, Provider<CallHandler> paramProvider3, Provider<DialerPhoneStateListener> paramProvider4)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static e a(Provider<Context> paramProvider, Provider<Handler> paramProvider1, Provider<com.viber.voip.app.b> paramProvider2, Provider<CallHandler> paramProvider3, Provider<DialerPhoneStateListener> paramProvider4)
  {
    return new e(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public b a()
  {
    return new b((Context)this.a.get(), (Handler)this.b.get(), (com.viber.voip.app.b)this.c.get(), (CallHandler)this.d.get(), (DialerPhoneStateListener)this.e.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.a.e
 * JD-Core Version:    0.6.2
 */