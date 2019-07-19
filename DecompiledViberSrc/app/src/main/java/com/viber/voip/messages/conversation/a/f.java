package com.viber.voip.messages.conversation.a;

import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener..CC;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

public class f extends a
  implements ConferenceCallsRepository.ConferenceAvailabilityListener
{
  private final dagger.a<ConferenceCallsRepository> b;

  @Inject
  public f(dagger.a<ConferenceCallsRepository> parama)
  {
    this.b = parama;
  }

  public String a(boolean paramBoolean)
  {
    if (paramBoolean)
      return null;
    List localList = ((ConferenceCallsRepository)this.b.get()).getConversationConferenceIdsAvailableToJoin();
    if (localList.isEmpty());
    Locale localLocale;
    Object[] arrayOfObject;
    for (String str = null; ; str = String.format(localLocale, "CASE WHEN conversations._id IN (%s) THEN 0 ELSE 1 END", arrayOfObject))
    {
      return str;
      localLocale = Locale.US;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = com.viber.voip.s.a.a(localList);
    }
  }

  protected void b()
  {
    super.b();
    ((ConferenceCallsRepository)this.b.get()).registerConferenceAvailabilityListener(this);
  }

  protected void c()
  {
    super.c();
    ((ConferenceCallsRepository)this.b.get()).unregisterConferenceAvailabilityListener(this);
  }

  public void onConferenceMissedInProgress(OngoingConferenceCallModel paramOngoingConferenceCallModel, String paramString1, String paramString2)
  {
    ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferenceMissedInProgress(this, paramOngoingConferenceCallModel, paramString1, paramString2);
  }

  public void onConferencesAvailable(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    a();
  }

  public void onConferencesUnavailable(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.a.f
 * JD-Core Version:    0.6.2
 */