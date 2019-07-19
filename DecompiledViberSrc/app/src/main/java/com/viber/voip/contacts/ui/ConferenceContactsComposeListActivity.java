package com.viber.voip.contacts.ui;

import android.os.Bundle;
import com.viber.voip.phone.MinimizedCallManager;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore;
import com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore.Listener;
import javax.inject.Inject;

public class ConferenceContactsComposeListActivity extends ContactsComposeListActivity
  implements SwitchToConferenceListenersStore.Listener
{

  @Inject
  CallHandler a;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.getSwitchToConferenceListenersStore().registerListener(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.a.getSwitchToConferenceListenersStore().unregisterListener(this);
  }

  protected void onStart()
  {
    super.onStart();
    MinimizedCallManager.getInstance().setCallProximityEnabled(false);
  }

  protected void onStop()
  {
    super.onStop();
    MinimizedCallManager.getInstance().setCallProximityEnabled(true);
  }

  public void onSwitchToConference()
  {
    finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ConferenceContactsComposeListActivity
 * JD-Core Version:    0.6.2
 */