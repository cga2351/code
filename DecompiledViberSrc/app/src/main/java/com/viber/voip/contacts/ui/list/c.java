package com.viber.voip.contacts.ui.list;

import android.support.v4.app.Fragment;
import android.view.View;
import com.viber.common.dialogs.m;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.mvp.core.d;

public class c<PRESENTER extends BaseGroupCallParticipantsPresenterImpl> extends d<PRESENTER>
  implements a
{
  protected final Fragment a;
  private final b b;

  protected c(PRESENTER paramPRESENTER, View paramView, Fragment paramFragment, com.viber.common.permission.c paramc, int paramInt)
  {
    super(paramPRESENTER, paramView);
    this.a = paramFragment;
    this.b = new b(paramPRESENTER, paramFragment, paramc, paramInt);
  }

  protected void a()
  {
    this.b.a();
  }

  public void close()
  {
    this.b.close();
  }

  public void closeOnSuccess()
  {
    this.b.closeOnSuccess();
  }

  public void onDestroy()
  {
    this.b.onDestroy();
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    return this.b.a(paramm, paramInt);
  }

  public void showAllParticipantsUnsupportedVersionError()
  {
    this.b.showAllParticipantsUnsupportedVersionError();
  }

  public void showGeneralError()
  {
    this.b.showGeneralError();
  }

  public void showNoConnectionError()
  {
    this.b.showNoConnectionError();
  }

  public void showNoServiceError()
  {
    this.b.showNoServiceError();
  }

  public void showParticipantsUnavailableError(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    this.b.showParticipantsUnavailableError(paramArrayOfConferenceParticipant);
  }

  public void showSomeParticipantsUnsupportedVersionError(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    this.b.showSomeParticipantsUnsupportedVersionError(paramArrayOfConferenceParticipant);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.c
 * JD-Core Version:    0.6.2
 */