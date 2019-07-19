package com.viber.voip.contacts.ui.list;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.permission.c;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.p;

public class b
  implements a
{
  protected final Fragment a;
  private final d b;
  private c c;
  private final int d;
  private final com.viber.common.permission.b e;

  public b(d paramd, Fragment paramFragment, c paramc, int paramInt)
  {
    this.b = paramd;
    this.a = paramFragment;
    this.c = paramc;
    this.d = paramInt;
    FragmentActivity localFragmentActivity = paramFragment.getActivity();
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(this.d);
    this.e = new com.viber.voip.permissions.f(localFragmentActivity, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        if (b.a(b.this) == paramAnonymousInt)
          b.b(b.this).startGroupCall();
      }
    };
    this.c.a(this.e);
  }

  public void a()
  {
    if (this.c.a(n.h))
    {
      this.b.startGroupCall();
      return;
    }
    this.c.a(this.a.getContext(), this.d, n.h, null);
  }

  public boolean a(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D1102))
    {
      if (paramInt == -1)
      {
        this.b.startGroupCallWithoutFailedParticipants();
        return true;
      }
      this.b.handleClose();
      return true;
    }
    if (paramm.a(DialogCode.D1103))
    {
      if (paramInt == -1)
      {
        this.b.sendUpdateLink();
        return true;
      }
      this.b.handleClose();
      return true;
    }
    if (paramm.a(DialogCode.D1105))
    {
      if (paramInt == -1)
      {
        this.b.startGroupCallWithoutFailedParticipants();
        return true;
      }
      this.b.handleClose();
      return true;
    }
    if (paramm.a(DialogCode.D339))
      this.b.handleClose();
    return false;
  }

  public void close()
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.finish();
  }

  public void closeOnSuccess()
  {
    close();
  }

  public void onDestroy()
  {
    this.c.b(this.e);
  }

  public void onPause()
  {
    com.viber.voip.mvp.core.k.c(this);
  }

  public void onResume()
  {
    com.viber.voip.mvp.core.k.b(this);
  }

  public void onStart()
  {
    com.viber.voip.mvp.core.k.a(this);
  }

  public void onStop()
  {
    com.viber.voip.mvp.core.k.d(this);
  }

  public void showAllParticipantsUnsupportedVersionError()
  {
    com.viber.voip.ui.dialogs.b.j().a(this.a).b(this.a);
  }

  public void showGeneralError()
  {
    h.a locala = com.viber.voip.ui.dialogs.k.n();
    int i = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a.getResources().getString(R.string.dialog_339_reason_invite);
    locala.b(i, arrayOfObject).a(this.a).b(this.a);
  }

  public void showNoConnectionError()
  {
    ad.a().b(this.a);
  }

  public void showNoServiceError()
  {
    com.viber.voip.ui.dialogs.f.d().b(this.a);
  }

  public void showParticipantsUnavailableError(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    com.viber.voip.ui.dialogs.b.a(p.a(paramArrayOfConferenceParticipant, null)).a(this.a).b(this.a);
  }

  public void showSomeParticipantsUnsupportedVersionError(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    String str = p.a(paramArrayOfConferenceParticipant, null);
    com.viber.voip.ui.dialogs.b.b(paramArrayOfConferenceParticipant.length, str).a(this.a).b(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.b
 * JD-Core Version:    0.6.2
 */