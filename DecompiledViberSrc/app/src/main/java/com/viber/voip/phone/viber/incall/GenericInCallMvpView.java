package com.viber.voip.phone.viber.incall;

import android.net.Uri;
import com.viber.voip.contacts.ui.list.a;
import com.viber.voip.mvp.core.j;

public abstract interface GenericInCallMvpView extends a, j
{
  public abstract void loadPhoto(boolean paramBoolean, Uri paramUri);

  public abstract void openConferenceParticipantsSelector(String paramString, int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incall.GenericInCallMvpView
 * JD-Core Version:    0.6.2
 */