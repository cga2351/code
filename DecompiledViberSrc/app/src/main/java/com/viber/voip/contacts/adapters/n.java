package com.viber.voip.contacts.adapters;

import android.widget.ListAdapter;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import java.util.Set;

public abstract interface n extends ListAdapter
{
  public abstract void a(Set<ParticipantSelector.Participant> paramSet1, Set<ParticipantSelector.Participant> paramSet2, boolean paramBoolean);

  public abstract boolean a(int paramInt, ParticipantSelector.Participant paramParticipant);

  public abstract boolean e_(int paramInt);

  public abstract void notifyDataSetChanged();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.n
 * JD-Core Version:    0.6.2
 */