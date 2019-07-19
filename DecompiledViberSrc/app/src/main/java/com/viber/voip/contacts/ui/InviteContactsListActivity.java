package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.contacts.c.d.m.a;
import com.viber.voip.util.x;

public class InviteContactsListActivity extends ContactsListActivity
{
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (!paramBoolean)
      return;
    long l = paramIntent.getLongExtra("contact_id", -1L);
    ViberApplication.getInstance().getContactManager().c().a(l, new m.a()
    {
      public void a(boolean paramAnonymousBoolean, com.viber.voip.model.a paramAnonymousa)
      {
        x.a(InviteContactsListActivity.this, paramAnonymousa, new ParticipantSelector.d()
        {
          public void a(ParticipantSelector.Participant paramAnonymous2Participant)
          {
          }

          public void a(boolean paramAnonymous2Boolean, ParticipantSelector.Participant paramAnonymous2Participant)
          {
            aj.a(InviteContactsListActivity.this, paramAnonymous2Participant.getNumber(), false);
          }
        });
      }
    });
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().b(R.string.conversation_info_invite_btn_text);
  }

  protected Fragment onCreatePane()
  {
    return new ap();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.InviteContactsListActivity
 * JD-Core Version:    0.6.2
 */