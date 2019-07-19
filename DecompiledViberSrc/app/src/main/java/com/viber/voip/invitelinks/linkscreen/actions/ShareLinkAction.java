package com.viber.voip.invitelinks.linkscreen.actions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.analytics.story.o;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.da;
import com.viber.voip.util.dw;

public class ShareLinkAction extends BaseShareLinkAction
{
  public static final Parcelable.Creator<ShareLinkAction> CREATOR = new Parcelable.Creator()
  {
    public ShareLinkAction a(Parcel paramAnonymousParcel)
    {
      return new ShareLinkAction(paramAnonymousParcel);
    }

    public ShareLinkAction[] a(int paramAnonymousInt)
    {
      return new ShareLinkAction[paramAnonymousInt];
    }
  };

  protected ShareLinkAction(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public ShareLinkAction(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }

  protected String prepareTextToShare(Activity paramActivity, String paramString)
  {
    return mergeLinkAndName(paramString);
  }

  protected void share(Activity paramActivity, g paramg, String paramString1, String paramString2)
  {
    Intent localIntent1 = ViberActionRunner.af.a(paramActivity, paramString1, this.mIsCommunity);
    Bundle localBundle = new Bundle(1);
    String str1 = paramActivity.getString(R.string.share_group_link);
    if (this.mIsCommunity);
    for (String str2 = "share_type_invite_community"; ; str2 = "share_type_invite_group")
    {
      Intent localIntent2 = dw.a(paramActivity, localIntent1, str1, str2, localBundle);
      if (ViberActionRunner.a(localIntent2, paramActivity))
      {
        if (!da.a(paramString2))
          paramg.c().g().c(paramString2);
        paramActivity.startActivity(localIntent2);
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.actions.ShareLinkAction
 * JD-Core Version:    0.6.2
 */