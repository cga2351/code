package com.viber.voip.flatbuffers.b.a;

import com.viber.voip.flatbuffers.a.a.b;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;

public class a
{
  public static ConferenceInfo a(com.viber.voip.flatbuffers.a.a.a parama)
  {
    if (parama == null)
      return null;
    ConferenceInfo localConferenceInfo = new ConferenceInfo();
    localConferenceInfo.setIsSelfInitiated(parama.c());
    a(localConferenceInfo, parama);
    return localConferenceInfo;
  }

  private static ConferenceParticipant a(b paramb)
  {
    if (paramb == null)
      return null;
    ConferenceParticipant localConferenceParticipant = new ConferenceParticipant();
    localConferenceParticipant.setMemberId(paramb.b());
    localConferenceParticipant.setName(paramb.c());
    localConferenceParticipant.setImage(paramb.d());
    return localConferenceParticipant;
  }

  private static void a(ConferenceInfo paramConferenceInfo, com.viber.voip.flatbuffers.a.a.a parama)
  {
    int i = parama.b();
    if (i > 0)
    {
      ConferenceParticipant[] arrayOfConferenceParticipant = new ConferenceParticipant[i];
      for (int j = 0; j < i; j++)
        arrayOfConferenceParticipant[j] = a(parama.f(j));
      paramConferenceInfo.setParticipants(arrayOfConferenceParticipant);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.a.a
 * JD-Core Version:    0.6.2
 */