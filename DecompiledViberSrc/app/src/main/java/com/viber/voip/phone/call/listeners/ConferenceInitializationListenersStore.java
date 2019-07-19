package com.viber.voip.phone.call.listeners;

import com.viber.voip.phone.conf.ConferenceCall;
import com.viber.voip.util.bo;
import com.viber.voip.util.bo.b;

public class ConferenceInitializationListenersStore extends bo<Listener, Params>
{
  public ConferenceInitializationListenersStore(bo.b<Listener, Params> paramb)
  {
    super(paramb, ConferenceInitializationListenersStore..Lambda.0.$instance);
  }

  public void notifyListeners(boolean paramBoolean, ConferenceCall paramConferenceCall)
  {
    notifyListeners(new Params(paramBoolean, paramConferenceCall));
  }

  public static abstract interface Listener
  {
    public abstract void onConferenceDeinitialized(ConferenceCall paramConferenceCall);

    public abstract void onConferenceInitialized(ConferenceCall paramConferenceCall);
  }

  public static class Params
  {
    public final ConferenceCall conference;
    public final boolean initialized;

    public Params(boolean paramBoolean, ConferenceCall paramConferenceCall)
    {
      this.initialized = paramBoolean;
      this.conference = paramConferenceCall;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore
 * JD-Core Version:    0.6.2
 */