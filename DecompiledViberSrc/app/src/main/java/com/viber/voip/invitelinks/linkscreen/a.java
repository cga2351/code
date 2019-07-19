package com.viber.voip.invitelinks.linkscreen;

import android.app.Activity;
import android.net.Uri;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.invitelinks.linkscreen.actions.ForwardCommunityLinkAction;
import com.viber.voip.invitelinks.linkscreen.actions.ForwardLinkAction;
import com.viber.voip.invitelinks.linkscreen.actions.ShareLinkAction;
import com.viber.voip.messages.conversation.ui.edit.group.AddGroupDetailsPresenter.AddDetailsGoNextAction;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.da;

public abstract class a
{
  private final Activity a;
  private final g b;
  private final boolean c;
  private String d;

  public a(Activity paramActivity, g paramg, boolean paramBoolean, String paramString)
  {
    this.a = paramActivity;
    this.b = paramg;
    this.c = paramBoolean;
    this.d = paramString;
  }

  private void a(AddGroupDetailsPresenter.AddDetailsGoNextAction paramAddDetailsGoNextAction, long paramLong, String paramString, Uri paramUri)
  {
    if (a(paramString, paramUri))
    {
      ViberActionRunner.af.a(this.a, paramLong, paramAddDetailsGoNextAction);
      return;
    }
    paramAddDetailsGoNextAction.goNext(this.a, this.b, paramString, paramUri, this.d);
  }

  public void a(long paramLong, String paramString1, Uri paramUri, String paramString2)
  {
    a(new ForwardCommunityLinkAction(paramString2, true), paramLong, paramString1, paramUri);
  }

  public void a(String paramString)
  {
    da.a(this.a, paramString, this.a.getString(R.string.link_copied));
  }

  protected abstract boolean a(String paramString, Uri paramUri);

  public void b(long paramLong, String paramString1, Uri paramUri, String paramString2)
  {
    a(new ForwardLinkAction(paramString2, this.c), paramLong, paramString1, paramUri);
  }

  public void c(long paramLong, String paramString1, Uri paramUri, String paramString2)
  {
    a(new ShareLinkAction(paramString2, this.c), paramLong, paramString1, paramUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.a
 * JD-Core Version:    0.6.2
 */