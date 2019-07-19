package com.viber.voip.wallet.wu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.ui.ContactsFragment.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.o;
import com.viber.voip.model.c;
import com.viber.voip.ui.MenuSearchMediator;

public class a extends o
{
  private a B;
  private boolean C = true;

  protected void a(MenuItem paramMenuItem)
  {
  }

  protected void a(c paramc, ParticipantSelector.Participant paramParticipant)
  {
    if (getActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("selected_participant", paramParticipant);
      this.m.a(true, localIntent);
    }
  }

  public void c(int paramInt)
  {
  }

  protected String i()
  {
    return getString(R.string.wu_select_recipient_activity_search_hint);
  }

  public b.b k()
  {
    return b.b.c;
  }

  public boolean l()
  {
    return true;
  }

  protected boolean n()
  {
    return false;
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof a))
    {
      this.B = ((a)paramActivity);
      return;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramActivity.getClass().getSimpleName();
    arrayOfObject[1] = a.class.getSimpleName();
    throw new ClassCastException(String.format("Activity %s must implement fragment's callback %s.", arrayOfObject));
  }

  public void onDetach()
  {
    super.onDetach();
    this.B = null;
  }

  public void onResume()
  {
    super.onResume();
    android.support.v7.app.a locala = ((AppCompatActivity)getActivity()).getSupportActionBar();
    if (locala != null)
    {
      locala.b(R.string.wu_select_recipient_activity_title);
      locala.b("");
    }
  }

  public boolean onSearchViewShow(boolean paramBoolean)
  {
    if (this.C)
      this.C = false;
    while (paramBoolean)
      return true;
    if (this.B != null)
    {
      this.i.i();
      this.B.a();
    }
    return false;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.wallet.wu.a
 * JD-Core Version:    0.6.2
 */