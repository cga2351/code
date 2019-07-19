package com.viber.voip.contacts.ui.list;

import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.mvp.core.j;

public abstract interface a extends j
{
  public abstract void close();

  public abstract void closeOnSuccess();

  public abstract void showAllParticipantsUnsupportedVersionError();

  public abstract void showGeneralError();

  public abstract void showNoConnectionError();

  public abstract void showNoServiceError();

  public abstract void showParticipantsUnavailableError(ConferenceParticipant[] paramArrayOfConferenceParticipant);

  public abstract void showSomeParticipantsUnsupportedVersionError(ConferenceParticipant[] paramArrayOfConferenceParticipant);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.a
 * JD-Core Version:    0.6.2
 */