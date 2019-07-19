package com.viber.voip.user;

import android.app.Activity;
import android.os.AsyncTask;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.extras.c.a;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import java.lang.ref.WeakReference;

public final class LoadVKDetailsTask extends AsyncTask<a, Void, SocialUserDetails>
{
  private static final Logger L = ViberEnv.getLogger();
  private String errorMessage;
  private boolean isTaskFinished;
  private WeakReference<Activity> mActivity;
  private WeakReference<com.viber.voip.messages.extras.c.a.a> mListener;

  public LoadVKDetailsTask(Activity paramActivity, com.viber.voip.messages.extras.c.a.a parama)
  {
    this.mActivity = new WeakReference(paramActivity);
    this.mListener = new WeakReference(parama);
    this.errorMessage = "";
  }

  private boolean isActivityDestroyed()
  {
    if (this.mActivity.get() != null)
      return ((Activity)this.mActivity.get()).isFinishing();
    return true;
  }

  public void cancelProgressDialog()
  {
    z.a(ViberApplication.getApplication(), DialogCode.D_PROGRESS);
  }

  // ERROR //
  protected SocialUserDetails doInBackground(a[] paramArrayOfa)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 80	com/viber/voip/user/LoadVKDetailsTask:isCancelled	()Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: invokespecial 82	com/viber/voip/user/LoadVKDetailsTask:isActivityDestroyed	()Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: iconst_0
    //   18: aaload
    //   19: invokevirtual 88	com/viber/voip/messages/extras/c/a:c	()Lcom/vk/sdk/api/VKResponse;
    //   22: getfield 94	com/vk/sdk/api/VKResponse:parsedModel	Ljava/lang/Object;
    //   25: checkcast 96	com/vk/sdk/api/model/VKList
    //   28: iconst_0
    //   29: invokevirtual 99	com/vk/sdk/api/model/VKList:get	(I)Lcom/vk/sdk/api/model/VKApiModel;
    //   32: checkcast 101	com/vk/sdk/api/model/VKApiUserFull
    //   35: astore_2
    //   36: new 103	java/net/URL
    //   39: dup
    //   40: aload_2
    //   41: getfield 106	com/vk/sdk/api/model/VKApiUserFull:photo_max	Ljava/lang/String;
    //   44: invokespecial 109	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 113	java/net/URL:openStream	()Ljava/io/InputStream;
    //   50: astore 7
    //   52: aload 7
    //   54: astore 4
    //   56: aload 4
    //   58: invokestatic 118	com/viber/voip/util/dq:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   61: astore 9
    //   63: new 120	com/viber/voip/user/SocialUserDetails
    //   66: dup
    //   67: new 122	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   74: aload_2
    //   75: getfield 126	com/vk/sdk/api/model/VKApiUserFull:first_name	Ljava/lang/String;
    //   78: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 132
    //   83: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: getfield 135	com/vk/sdk/api/model/VKApiUserFull:last_name	Ljava/lang/String;
    //   90: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aload 9
    //   98: invokespecial 142	com/viber/voip/user/SocialUserDetails:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   101: astore 10
    //   103: aload 4
    //   105: invokestatic 147	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   108: aload 10
    //   110: areturn
    //   111: astore 5
    //   113: aconst_null
    //   114: astore 6
    //   116: aload 6
    //   118: invokestatic 147	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_3
    //   124: aconst_null
    //   125: astore 4
    //   127: aload 4
    //   129: invokestatic 147	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   132: aload_3
    //   133: athrow
    //   134: astore_3
    //   135: goto -8 -> 127
    //   138: astore 8
    //   140: aload 4
    //   142: astore 6
    //   144: goto -28 -> 116
    //
    // Exception table:
    //   from	to	target	type
    //   36	52	111	java/io/IOException
    //   36	52	123	finally
    //   56	103	134	finally
    //   56	103	138	java/io/IOException
  }

  public boolean isFinished()
  {
    return this.isTaskFinished;
  }

  protected void onPostExecute(SocialUserDetails paramSocialUserDetails)
  {
    if (!this.isTaskFinished)
    {
      this.isTaskFinished = true;
      cancelProgressDialog();
      if ((paramSocialUserDetails == null) || (this.mListener.get() == null))
        break label47;
      ((com.viber.voip.messages.extras.c.a.a)this.mListener.get()).onGetUserDetails(paramSocialUserDetails);
    }
    label47: 
    while ((isActivityDestroyed()) || (this.mListener.get() == null))
      return;
    ((com.viber.voip.messages.extras.c.a.a)this.mListener.get()).onAuthError();
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
    ad.a(R.string.dialog_loading_vk_profile).d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.LoadVKDetailsTask
 * JD-Core Version:    0.6.2
 */