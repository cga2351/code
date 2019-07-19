package com.viber.voip.phone.call.listeners;

import com.viber.voip.util.bo;

public class SwitchToConferenceListenersStore extends bo<Listener, Void>
{
  public SwitchToConferenceListenersStore()
  {
    super(SwitchToConferenceListenersStore..Lambda.0.$instance);
  }

  public static abstract interface Listener
  {
    public abstract void onSwitchToConference();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore
 * JD-Core Version:    0.6.2
 */