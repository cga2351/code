package com.viber.voip.contacts.ui;

import android.support.v4.app.Fragment;
import com.viber.voip.ui.j.av;
import dagger.a;
import dagger.android.c;
import dagger.b;

public final class w
  implements b<ContactsComposeListActivity>
{
  public static void a(ContactsComposeListActivity paramContactsComposeListActivity, a<av> parama)
  {
    paramContactsComposeListActivity.c = parama;
  }

  public static void a(ContactsComposeListActivity paramContactsComposeListActivity, c<Fragment> paramc)
  {
    paramContactsComposeListActivity.b = paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.w
 * JD-Core Version:    0.6.2
 */