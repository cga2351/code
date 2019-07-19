package com.viber.voip.invitelinks.linkscreen.actions;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.conversation.ui.edit.group.AddGroupDetailsPresenter.AddDetailsGoNextAction;
import com.viber.voip.util.dg;

public abstract class BaseShareLinkAction
  implements AddGroupDetailsPresenter.AddDetailsGoNextAction
{
  protected static final Logger L = ViberEnv.getLogger();
  protected final boolean mIsCommunity;
  protected final String mLink;

  protected BaseShareLinkAction(Parcel paramParcel)
  {
    this.mLink = paramParcel.readString();
    if (paramParcel.readByte() > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsCommunity = bool;
      return;
    }
  }

  public BaseShareLinkAction(String paramString, boolean paramBoolean)
  {
    this.mLink = paramString;
    this.mIsCommunity = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public final void goNext(Activity paramActivity, g paramg, String paramString1, Uri paramUri, String paramString2)
  {
    share(paramActivity, paramg, prepareTextToShare(paramActivity, paramString1), paramString2);
  }

  protected final String mergeLinkAndName(String paramString)
  {
    return dg.b(paramString) + " " + this.mLink;
  }

  protected abstract String prepareTextToShare(Activity paramActivity, String paramString);

  protected abstract void share(Activity paramActivity, g paramg, String paramString1, String paramString2);

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mLink);
    if (this.mIsCommunity);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.actions.BaseShareLinkAction
 * JD-Core Version:    0.6.2
 */