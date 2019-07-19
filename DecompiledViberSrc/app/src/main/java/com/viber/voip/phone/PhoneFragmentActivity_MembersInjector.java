package com.viber.voip.phone;

import com.viber.jni.dialer.DialerController;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.phone.call.CallHandler;
import dagger.a;
import dagger.b;
import javax.inject.Provider;

public final class PhoneFragmentActivity_MembersInjector
  implements b<PhoneFragmentActivity>
{
  private final Provider<CallHandler> mCallHandlerProvider;
  private final Provider<DialerController> mDialerControllerProvider;
  private final Provider<com.viber.common.permission.c> mPermissionManagerProvider;
  private final Provider<h> mUserStartsCallEventCollectorProvider;

  public PhoneFragmentActivity_MembersInjector(Provider<com.viber.common.permission.c> paramProvider, Provider<h> paramProvider1, Provider<CallHandler> paramProvider2, Provider<DialerController> paramProvider3)
  {
    this.mPermissionManagerProvider = paramProvider;
    this.mUserStartsCallEventCollectorProvider = paramProvider1;
    this.mCallHandlerProvider = paramProvider2;
    this.mDialerControllerProvider = paramProvider3;
  }

  public static b<PhoneFragmentActivity> create(Provider<com.viber.common.permission.c> paramProvider, Provider<h> paramProvider1, Provider<CallHandler> paramProvider2, Provider<DialerController> paramProvider3)
  {
    return new PhoneFragmentActivity_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public static void injectMCallHandler(PhoneFragmentActivity paramPhoneFragmentActivity, a<CallHandler> parama)
  {
    paramPhoneFragmentActivity.mCallHandler = parama;
  }

  public static void injectMDialerController(PhoneFragmentActivity paramPhoneFragmentActivity, a<DialerController> parama)
  {
    paramPhoneFragmentActivity.mDialerController = parama;
  }

  public static void injectMPermissionManager(PhoneFragmentActivity paramPhoneFragmentActivity, com.viber.common.permission.c paramc)
  {
    paramPhoneFragmentActivity.mPermissionManager = paramc;
  }

  public static void injectMUserStartsCallEventCollector(PhoneFragmentActivity paramPhoneFragmentActivity, a<h> parama)
  {
    paramPhoneFragmentActivity.mUserStartsCallEventCollector = parama;
  }

  public void injectMembers(PhoneFragmentActivity paramPhoneFragmentActivity)
  {
    injectMPermissionManager(paramPhoneFragmentActivity, (com.viber.common.permission.c)this.mPermissionManagerProvider.get());
    injectMUserStartsCallEventCollector(paramPhoneFragmentActivity, dagger.a.c.b(this.mUserStartsCallEventCollectorProvider));
    injectMCallHandler(paramPhoneFragmentActivity, dagger.a.c.b(this.mCallHandlerProvider));
    injectMDialerController(paramPhoneFragmentActivity, dagger.a.c.b(this.mDialerControllerProvider));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PhoneFragmentActivity_MembersInjector
 * JD-Core Version:    0.6.2
 */