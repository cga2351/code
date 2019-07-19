package com.viber.voip.calls.ui;

import com.viber.voip.contacts.ui.list.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.model.Call;
import java.util.List;

public abstract interface d extends a
{
  public abstract void a(ConferenceParticipant paramConferenceParticipant);

  public abstract void a(String paramString);

  public abstract void a(List<ConferenceParticipant> paramList, List<Call> paramList1);

  public abstract void a(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.d
 * JD-Core Version:    0.6.2
 */