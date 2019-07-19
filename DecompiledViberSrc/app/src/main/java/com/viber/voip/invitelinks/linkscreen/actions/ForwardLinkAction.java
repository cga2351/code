package com.viber.voip.invitelinks.linkscreen.actions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.da;

public class ForwardLinkAction extends BaseShareLinkAction
{
  public static final Parcelable.Creator<ForwardLinkAction> CREATOR = new Parcelable.Creator()
  {
    public ForwardLinkAction a(Parcel paramAnonymousParcel)
    {
      return new ForwardLinkAction(paramAnonymousParcel);
    }

    public ForwardLinkAction[] a(int paramAnonymousInt)
    {
      return new ForwardLinkAction[paramAnonymousInt];
    }
  };

  protected ForwardLinkAction(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public ForwardLinkAction(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }

  protected String prepareTextToShare(Activity paramActivity, String paramString)
  {
    if (this.mIsCommunity);
    for (int i = R.string.join_community_on_viber; ; i = R.string.join_this_chat_in_viber)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = mergeLinkAndName(paramString);
      return paramActivity.getString(i, arrayOfObject);
    }
  }

  protected void share(Activity paramActivity, g paramg, String paramString1, String paramString2)
  {
    Intent localIntent = ViberActionRunner.u.a(paramString1, false);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("invite_link_sent_via_viber", true);
    if (!da.a(paramString2))
      localBundle.putString("share_entry_point_extra_key", paramString2);
    paramActivity.startActivity(ViberActionRunner.u.a(localIntent, localBundle));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.actions.ForwardLinkAction
 * JD-Core Version:    0.6.2
 */