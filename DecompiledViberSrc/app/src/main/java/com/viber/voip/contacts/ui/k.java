package com.viber.voip.contacts.ui;

import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.secure.TrustPeerController;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.user.OnlineUserActivityHelper;
import dagger.a;

public final class k
  implements dagger.b<ContactDetailsFragment>
{
  public static void a(ContactDetailsFragment paramContactDetailsFragment, PhoneController paramPhoneController)
  {
    paramContactDetailsFragment.i = paramPhoneController;
  }

  public static void a(ContactDetailsFragment paramContactDetailsFragment, TrustPeerController paramTrustPeerController)
  {
    paramContactDetailsFragment.k = paramTrustPeerController;
  }

  public static void a(ContactDetailsFragment paramContactDetailsFragment, com.viber.voip.analytics.g paramg)
  {
    paramContactDetailsFragment.d = paramg;
  }

  public static void a(ContactDetailsFragment paramContactDetailsFragment, com.viber.voip.app.b paramb)
  {
    paramContactDetailsFragment.e = paramb;
  }

  public static void a(ContactDetailsFragment paramContactDetailsFragment, com.viber.voip.contacts.c.d.g paramg)
  {
    paramContactDetailsFragment.f = paramg;
  }

  public static void a(ContactDetailsFragment paramContactDetailsFragment, CallHandler paramCallHandler)
  {
    paramContactDetailsFragment.g = paramCallHandler;
  }

  public static void a(ContactDetailsFragment paramContactDetailsFragment, OnlineUserActivityHelper paramOnlineUserActivityHelper)
  {
    paramContactDetailsFragment.j = paramOnlineUserActivityHelper;
  }

  public static void a(ContactDetailsFragment paramContactDetailsFragment, a<DialerController> parama)
  {
    paramContactDetailsFragment.h = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.k
 * JD-Core Version:    0.6.2
 */