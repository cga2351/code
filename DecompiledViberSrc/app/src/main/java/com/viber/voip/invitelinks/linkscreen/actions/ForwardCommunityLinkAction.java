package com.viber.voip.invitelinks.linkscreen.actions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.util.ViberActionRunner.d;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.da;

public class ForwardCommunityLinkAction extends BaseShareLinkAction
{
  public static final Parcelable.Creator<ForwardCommunityLinkAction> CREATOR = new Parcelable.Creator()
  {
    public ForwardCommunityLinkAction a(Parcel paramAnonymousParcel)
    {
      return new ForwardCommunityLinkAction(paramAnonymousParcel);
    }

    public ForwardCommunityLinkAction[] a(int paramAnonymousInt)
    {
      return new ForwardCommunityLinkAction[paramAnonymousInt];
    }
  };

  protected ForwardCommunityLinkAction(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public ForwardCommunityLinkAction(String paramString, boolean paramBoolean)
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
    Intent localIntent = ViberActionRunner.d.a(paramActivity, this.mLink, paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("invite_link", this.mLink);
    localBundle.putString("share_text", paramString1);
    if (!da.a(paramString2))
      localBundle.putString("share_entry_point_extra_key", paramString2);
    paramActivity.startActivityForResult(ViberActionRunner.u.a(localIntent, localBundle), 100);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.actions.ForwardCommunityLinkAction
 * JD-Core Version:    0.6.2
 */