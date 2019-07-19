package com.viber.voip.publicaccount.ui.holders.publication;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;
import com.viber.voip.publicaccount.ui.holders.d;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.r;

public final class a extends PublicAccountEditUIHolder<PublicationData, b>
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, m.c
{
  private final Fragment c;
  private final d d;

  public a(Fragment paramFragment, d paramd)
  {
    this.c = paramFragment;
    this.d = paramd;
  }

  private void a(boolean paramBoolean)
  {
    if (((PublicationData)this.a).mIsPublished != paramBoolean)
    {
      if ((!paramBoolean) && (((PublicationData)this.a).mShouldShowUnpublishWarningMessage))
      {
        ((PublicationData)this.a).mShouldShowUnpublishWarningMessage = false;
        r.p().a(this.c).b(this.c);
      }
    }
    else
      return;
    ((PublicationData)this.a).mIsPublished = paramBoolean;
    ((b)this.b).a(paramBoolean);
    f();
  }

  private void f()
  {
    this.d.a(this, true);
  }

  protected void a(PublicationData paramPublicationData, b paramb)
  {
  }

  protected void a(b paramb, PublicationData paramPublicationData)
  {
    paramb.a(paramPublicationData.mIsPublished);
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    return new c(paramView, this, this);
  }

  protected PublicationData e()
  {
    return new PublicationData();
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == R.id.checker)
      a(paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.publish_public_account_toggle_container)
      if (((PublicationData)this.a).mIsPublished)
        break label31;
    label31: for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D2105))
      switch (paramInt)
      {
      default:
      case -1:
      case -2:
      }
    while (true)
    {
      f();
      return;
      a(false);
      continue;
      a(true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.publication.a
 * JD-Core Version:    0.6.2
 */