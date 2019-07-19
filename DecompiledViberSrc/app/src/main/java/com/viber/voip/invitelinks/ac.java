package com.viber.voip.invitelinks;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.util.az;
import dagger.a.d;
import javax.inject.Provider;

public final class ac
  implements d<q>
{
  private final Provider<ab> a;
  private final Provider<PhoneController> b;
  private final Provider<GroupController> c;
  private final Provider<bv> d;
  private final Provider<az> e;

  public ac(Provider<ab> paramProvider, Provider<PhoneController> paramProvider1, Provider<GroupController> paramProvider2, Provider<bv> paramProvider3, Provider<az> paramProvider4)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static ac a(Provider<ab> paramProvider, Provider<PhoneController> paramProvider1, Provider<GroupController> paramProvider2, Provider<bv> paramProvider3, Provider<az> paramProvider4)
  {
    return new ac(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public q a()
  {
    return new q((ab)this.a.get(), (PhoneController)this.b.get(), (GroupController)this.c.get(), (bv)this.d.get(), (az)this.e.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.ac
 * JD-Core Version:    0.6.2
 */