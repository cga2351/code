package com.viber.voip.phone.viber.conference.ui.controls;

import android.os.Handler;
import com.viber.jni.dialer.DialerCallInterruptionListener;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.phone.call.CallHandler;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceMicStateResolver_Factory
  implements d<ConferenceMicStateResolver>
{
  private final Provider<CallHandler> callHandlerProvider;
  private final Provider<DialerCallInterruptionListener> dialerCallInterruptionListenerProvider;
  private final Provider<DialerController> dialerControllerProvider;
  private final Provider<DialerPhoneStateListener> dialerPhoneStateListenerProvider;
  private final Provider<Handler> uiExecutorProvider;

  public ConferenceMicStateResolver_Factory(Provider<CallHandler> paramProvider, Provider<DialerController> paramProvider1, Provider<DialerPhoneStateListener> paramProvider2, Provider<DialerCallInterruptionListener> paramProvider3, Provider<Handler> paramProvider4)
  {
    this.callHandlerProvider = paramProvider;
    this.dialerControllerProvider = paramProvider1;
    this.dialerPhoneStateListenerProvider = paramProvider2;
    this.dialerCallInterruptionListenerProvider = paramProvider3;
    this.uiExecutorProvider = paramProvider4;
  }

  public static ConferenceMicStateResolver_Factory create(Provider<CallHandler> paramProvider, Provider<DialerController> paramProvider1, Provider<DialerPhoneStateListener> paramProvider2, Provider<DialerCallInterruptionListener> paramProvider3, Provider<Handler> paramProvider4)
  {
    return new ConferenceMicStateResolver_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public ConferenceMicStateResolver get()
  {
    return new ConferenceMicStateResolver((CallHandler)this.callHandlerProvider.get(), (DialerController)this.dialerControllerProvider.get(), (DialerPhoneStateListener)this.dialerPhoneStateListenerProvider.get(), (DialerCallInterruptionListener)this.dialerCallInterruptionListenerProvider.get(), (Handler)this.uiExecutorProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.controls.ConferenceMicStateResolver_Factory
 * JD-Core Version:    0.6.2
 */