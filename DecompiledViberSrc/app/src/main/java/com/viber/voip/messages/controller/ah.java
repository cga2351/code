package com.viber.voip.messages.controller;

import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.model.entity.MessageEntity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ah
{
  private static final Map<String, Integer> a = new HashMap();

  static
  {
    a.put("answ_another_dev", Integer.valueOf(0));
    a.put("answ_another_dev_group", Integer.valueOf(0));
    a.put("transferred", Integer.valueOf(0));
    a.put("incoming_call", Integer.valueOf(0));
    a.put("incoming_call_group", Integer.valueOf(0));
    a.put("incoming_call_video", Integer.valueOf(0));
    a.put("outgoing_call", Integer.valueOf(1));
    a.put("outgoing_call_video", Integer.valueOf(1));
    a.put("vo", Integer.valueOf(3));
    a.put("missed_call", Integer.valueOf(2));
    a.put("missed_call_group", Integer.valueOf(2));
    a.put("missed_call_video", Integer.valueOf(2));
  }

  public static boolean a(MessageEntity paramMessageEntity1, MessageEntity paramMessageEntity2)
  {
    int i = 0;
    if (!((Integer)a.get(paramMessageEntity1.getBody())).equals(a.get(paramMessageEntity2.getBody())))
      return false;
    if ((!paramMessageEntity1.hasConferenceInfo()) && (!paramMessageEntity2.hasConferenceInfo()))
      return true;
    if (paramMessageEntity1.hasConferenceInfo() != paramMessageEntity2.hasConferenceInfo())
      return false;
    ConferenceInfo localConferenceInfo1 = paramMessageEntity1.getConferenceInfo();
    HashSet localHashSet1 = new HashSet(localConferenceInfo1.getParticipants().length);
    ConferenceParticipant[] arrayOfConferenceParticipant1 = localConferenceInfo1.getParticipants();
    int j = arrayOfConferenceParticipant1.length;
    for (int k = 0; k < j; k++)
      localHashSet1.add(arrayOfConferenceParticipant1[k].getMemberId());
    ConferenceInfo localConferenceInfo2 = paramMessageEntity2.getConferenceInfo();
    HashSet localHashSet2 = new HashSet(localConferenceInfo2.getParticipants().length);
    ConferenceParticipant[] arrayOfConferenceParticipant2 = localConferenceInfo2.getParticipants();
    int m = arrayOfConferenceParticipant2.length;
    while (i < m)
    {
      localHashSet2.add(arrayOfConferenceParticipant2[i].getMemberId());
      i++;
    }
    return localHashSet1.equals(localHashSet2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.ah
 * JD-Core Version:    0.6.2
 */