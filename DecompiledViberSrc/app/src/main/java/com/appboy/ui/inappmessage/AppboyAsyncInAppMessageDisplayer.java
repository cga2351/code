package com.appboy.ui.inappmessage;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import com.appboy.b.a.e;
import com.appboy.e.h;
import com.appboy.e.j;
import com.appboy.e.l;
import com.appboy.e.m;
import com.appboy.f.c;
import com.appboy.f.k;
import com.appboy.g;
import java.io.File;

public class AppboyAsyncInAppMessageDisplayer extends AsyncTask<com.appboy.e.b, Integer, com.appboy.e.b>
{
  private static final String TAG = c.a(AppboyAsyncInAppMessageDisplayer.class);

  protected com.appboy.e.b doInBackground(com.appboy.e.b[] paramArrayOfb)
  {
    com.appboy.e.b localb;
    try
    {
      localb = paramArrayOfb[0];
      if (localb.A())
      {
        c.b(TAG, "Skipping in-app message preparation for control in-app message.");
        return localb;
      }
      c.b(TAG, "Starting asynchronous in-app message preparation.");
      if ((localb instanceof j))
      {
        if (!prepareInAppMessageWithHtml(localb))
        {
          localb.a(e.c);
          return null;
        }
      }
      else if (!prepareInAppMessageWithBitmapDownload(localb))
      {
        localb.a(e.a);
        return null;
      }
    }
    catch (Exception localException)
    {
      c.d(TAG, "Error running AsyncInAppMessageDisplayer", localException);
      localb = null;
    }
    return localb;
  }

  protected void onPostExecute(final com.appboy.e.b paramb)
  {
    if (paramb != null);
    try
    {
      c.b(TAG, "Finished asynchronous in-app message preparation. Attempting to display in-app message.");
      new Handler(AppboyInAppMessageManager.getInstance().getApplicationContext().getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          c.b(AppboyAsyncInAppMessageDisplayer.TAG, "Displaying in-app message.");
          AppboyInAppMessageManager.getInstance().displayInAppMessage(paramb, false);
        }
      });
      return;
      c.e(TAG, "Cannot display the in-app message because the in-app message was null.");
      return;
    }
    catch (Exception localException)
    {
      c.d(TAG, "Error running onPostExecute", localException);
    }
  }

  boolean prepareInAppMessageWithBitmapDownload(com.appboy.e.b paramb)
  {
    if (paramb.p() != null)
    {
      c.c(TAG, "In-app message already contains image bitmap. Not downloading image from URL.");
      paramb.c(true);
      return true;
    }
    String str1 = paramb.k();
    if ((!com.appboy.f.i.c(str1)) && (new File(str1).exists()))
    {
      c.c(TAG, "In-app message has local image url.");
      paramb.a(com.appboy.f.b.a(Uri.parse(str1)));
    }
    String str2;
    com.appboy.b.a locala;
    if (paramb.p() == null)
    {
      str2 = paramb.j();
      if (com.appboy.f.i.c(str2))
        break label191;
      c.c(TAG, "In-app message has remote image url. Downloading.");
      locala = com.appboy.b.a.g;
      if (!(paramb instanceof m))
        break label176;
      locala = com.appboy.b.a.f;
    }
    while (true)
    {
      Context localContext = AppboyInAppMessageManager.getInstance().getApplicationContext();
      paramb.a(com.appboy.a.a(localContext).h().a(localContext, str2, locala));
      if (paramb.p() == null)
        break;
      paramb.c(true);
      return true;
      label176: if ((paramb instanceof l))
        locala = com.appboy.b.a.e;
    }
    label191: c.d(TAG, "In-app message has no remote image url. Not downloading image.");
    if ((paramb instanceof h))
    {
      c.d(TAG, "In-app message full has no remote image url yet is required to have an image. Failing download.");
      return false;
    }
    return true;
    return false;
  }

  boolean prepareInAppMessageWithHtml(com.appboy.e.b paramb)
  {
    com.appboy.e.i locali = (com.appboy.e.i)paramb;
    String str1 = locali.B();
    if ((!com.appboy.f.i.c(str1)) && (new File(str1).exists()))
    {
      c.c(TAG, "Local assets for html in-app message are already populated. Not downloading assets.");
      return true;
    }
    if (com.appboy.f.i.c(locali.C()))
    {
      c.c(TAG, "Html in-app message has no remote asset zip. Continuing with in-app message preparation.");
      return true;
    }
    String str2 = k.a(k.a(AppboyInAppMessageManager.getInstance().getApplicationContext()), locali.C());
    if (!com.appboy.f.i.c(str2))
    {
      c.b(TAG, "Local url for html in-app message assets is " + str2);
      locali.f(str2);
      return true;
    }
    c.d(TAG, "Download of html content to local directory failed for remote url: " + locali.C() + " . Returned local url is: " + str2);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyAsyncInAppMessageDisplayer
 * JD-Core Version:    0.6.2
 */