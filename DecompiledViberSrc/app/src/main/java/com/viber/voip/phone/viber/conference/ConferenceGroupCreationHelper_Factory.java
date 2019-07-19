package com.viber.voip.phone.viber.conference;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.util.cn;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceGroupCreationHelper_Factory
  implements d<ConferenceGroupCreationHelper>
{
  private final Provider<GroupController> groupControllerProvider;
  private final Provider<bv> messageNotificationManagerProvider;
  private final Provider<PhoneController> phoneControllerProvider;
  private final Provider<cn> resourceProvider;

  public ConferenceGroupCreationHelper_Factory(Provider<cn> paramProvider, Provider<GroupController> paramProvider1, Provider<PhoneController> paramProvider2, Provider<bv> paramProvider3)
  {
    this.resourceProvider = paramProvider;
    this.groupControllerProvider = paramProvider1;
    this.phoneControllerProvider = paramProvider2;
    this.messageNotificationManagerProvider = paramProvider3;
  }

  public static ConferenceGroupCreationHelper_Factory create(Provider<cn> paramProvider, Provider<GroupController> paramProvider1, Provider<PhoneController> paramProvider2, Provider<bv> paramProvider3)
  {
    return new ConferenceGroupCreationHelper_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public ConferenceGroupCreationHelper get()
  {
    return new ConferenceGroupCreationHelper((cn)this.resourceProvider.get(), (GroupController)this.groupControllerProvider.get(), (PhoneController)this.phoneControllerProvider.get(), (bv)this.messageNotificationManagerProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper_Factory
 * JD-Core Version:    0.6.2
 */