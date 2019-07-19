package com.viber.voip.user;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.extras.a.c;
import com.viber.voip.messages.extras.a.d;
import com.viber.voip.messages.extras.a.e;
import com.viber.voip.messages.extras.a.e.e;

final class LoadFacebookDetailsTask extends AsyncTask<e, Void, SocialUserDetails>
{
  private static final Logger L = ViberEnv.getLogger();
  private String errorMessage;
  private boolean isTaskFinished;
  private final FacebookDetailsListener listener;
  private Context mContext;
  private ProgressDialog progressDialog;

  LoadFacebookDetailsTask(Context paramContext, FacebookDetailsListener paramFacebookDetailsListener)
  {
    this.mContext = paramContext;
    this.listener = paramFacebookDetailsListener;
    this.errorMessage = "";
    this.progressDialog = new ProgressDialog(paramContext);
    this.progressDialog.setMessage(paramContext.getResources().getString(R.string.dialog_loading_facebook_profile));
  }

  private boolean isActivityDestroyed()
  {
    return ((Activity)this.mContext).isFinishing();
  }

  private SocialUserDetails loadFacebookDetails(e parame)
    throws c
  {
    e.e locale;
    try
    {
      locale = parame.d();
      if (locale == null)
        throw new c("Facebook user profile is null");
    }
    catch (d locald)
    {
      throw new c(locald.getMessage());
    }
    String str1 = locale.b();
    if (str1 == null)
      str1 = "";
    String str2 = locale.a();
    if (str2 == null)
      throw new c("Facebook user id is null");
    return new SocialUserDetails(str1, parame.a(str2));
  }

  private void restoreProgressDialog()
  {
    this.progressDialog = new ProgressDialog(this.mContext);
    this.progressDialog.setMessage(this.mContext.getResources().getString(R.string.dialog_loading_facebook_profile));
    this.progressDialog.show();
  }

  public void cancelProgressDialog()
  {
    if ((this.progressDialog.isShowing()) && (!isActivityDestroyed()))
      this.progressDialog.dismiss();
  }

  protected SocialUserDetails doInBackground(e[] paramArrayOfe)
  {
    if ((isCancelled()) || (isActivityDestroyed()))
      return null;
    e locale = paramArrayOfe[0];
    try
    {
      SocialUserDetails localSocialUserDetails = loadFacebookDetails(locale);
      return localSocialUserDetails;
    }
    catch (c localc)
    {
      this.errorMessage = localc.getMessage();
    }
    return null;
  }

  public boolean isFinished()
  {
    return this.isTaskFinished;
  }

  protected void onPostExecute(SocialUserDetails paramSocialUserDetails)
  {
    this.isTaskFinished = true;
    cancelProgressDialog();
    if (paramSocialUserDetails != null)
      this.listener.onLoaded(paramSocialUserDetails);
    while (isActivityDestroyed())
      return;
    this.listener.onLoadingError(this.errorMessage);
  }

  protected void onPreExecute()
  {
    super.onPreExecute();
    if (isActivityDestroyed())
    {
      cancel(true);
      return;
    }
    this.isTaskFinished = false;
    this.progressDialog.show();
  }

  public void restoreTask(Context paramContext)
  {
    this.mContext = paramContext;
    restoreProgressDialog();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.LoadFacebookDetailsTask
 * JD-Core Version:    0.6.2
 */