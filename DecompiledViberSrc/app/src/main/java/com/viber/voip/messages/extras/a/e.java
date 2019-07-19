package com.viber.voip.messages.extras.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Request.Callback;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.g.b.b;
import com.viber.voip.util.cj;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements ServiceStateDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] f = { "email" };
  private static HashMap<Long, Object> h = new HashMap();
  private final Context b = ViberApplication.getApplication();
  private final Engine c = ViberApplication.getInstance().getEngine(false);
  private final Handler d = av.a(av.e.d);
  private a e;
  private Collection<b> g = new HashSet(5);
  private boolean i;
  private final b<a> j;
  private Session.StatusCallback k = new Session.StatusCallback()
  {
    public void call(Session paramAnonymousSession, SessionState paramAnonymousSessionState, Exception paramAnonymousException)
    {
      e.a(e.this, paramAnonymousSession, paramAnonymousSessionState, paramAnonymousException);
    }
  };
  private Request.GraphUserCallback l = new Request.GraphUserCallback()
  {
    public void onCompleted(GraphUser paramAnonymousGraphUser, Response paramAnonymousResponse)
    {
      e.a(e.this, paramAnonymousGraphUser, paramAnonymousResponse);
    }
  };
  private c m;
  private Request.Callback n = new Request.Callback()
  {
    public void onCompleted(Response paramAnonymousResponse)
    {
      if (paramAnonymousResponse.getGraphObject() == null);
      do
      {
        FacebookRequestError localFacebookRequestError;
        do
        {
          return;
          localFacebookRequestError = paramAnonymousResponse.getError();
          if (localFacebookRequestError == null)
            break;
        }
        while (e.d(e.this) == null);
        e.d(e.this).a(e.a(e.this, localFacebookRequestError.getErrorMessage()));
        return;
      }
      while (e.d(e.this) == null);
      e.d(e.this).a();
    }
  };

  public e(String paramString)
  {
    this.c.getDelegatesManager().getServiceStateListener().registerDelegate(new ServiceStateDelegate[] { this });
    Settings.publishInstallAsync(this.b, paramString, null);
    this.j = new b()
    {
      protected a a()
      {
        return g.a().c().c();
      }
    };
  }

  private void a(Session paramSession, SessionState paramSessionState, Exception paramException)
  {
    if (paramSession.isOpened())
    {
      ((a)this.j.get()).a("Facebook", true);
      if (this.e != null)
        this.e.onAuthorizationSuccess(false);
      h();
    }
    while ((!paramSession.isClosed()) || (this.e == null))
      return;
    this.e.onAuthorizationCanceled();
  }

  private void a(GraphUser paramGraphUser, Response paramResponse)
  {
    if (paramGraphUser != null)
    {
      String str1 = paramGraphUser.getId();
      String str2 = paramGraphUser.getName();
      if (!str1.equals(i()))
      {
        a(str2, str1);
        b(str1, f().getAccessToken());
      }
    }
    while (true)
    {
      if (this.e != null)
        this.e.onFacebookProfileStored();
      return;
      if (paramResponse.getError() == null);
    }
  }

  private String b(String paramString)
  {
    String str = "Error";
    if (paramString != null)
    {
      str = paramString.replace("com.facebook.FacebookException:", "");
      if (str.contains("Error validating access token"))
        str = "Error validating access token";
    }
    return str;
  }

  private void b(final String paramString1, final String paramString2)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        if (e.a(e.this));
        do
        {
          return;
          e.b(e.this).isInitialized();
          cj.b(e.c(e.this));
        }
        while ((!e.b(e.this).isInitialized()) || (!cj.b(e.c(e.this))) || (!e.b(e.this).getCdrController().handleReportFacebookStatistics(paramString1, paramString2, 0)));
        e.this.a(true);
      }
    });
  }

  public static void c(Activity paramActivity)
  {
    e locale = ViberApplication.getInstance().getFacebookManager(false);
    if ((locale != null) && (paramActivity != null))
      locale.a(paramActivity);
  }

  public static void d(Activity paramActivity)
  {
    e locale = ViberApplication.getInstance().getFacebookManager(false);
    if ((locale != null) && (paramActivity != null))
      locale.b(paramActivity);
  }

  private Session f()
  {
    Session localSession = Session.getActiveSession();
    if (localSession == null)
    {
      localSession = new Session(this.b);
      Session.setActiveSession(localSession);
    }
    return localSession;
  }

  private void g()
  {
    boolean bool1 = cj.b(this.b);
    if (bool1)
    {
      boolean bool2 = j();
      if ((bool1) && (this.c.isInitialized()) && (!bool2) && (!TextUtils.isEmpty(i())) && (!TextUtils.isEmpty(f().getAccessToken())))
        b(i(), f().getAccessToken());
    }
  }

  private void h()
  {
    Request.newMeRequest(Session.getActiveSession(), this.l).executeAsync();
  }

  private String i()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.b.getApplicationContext()).getString("fb_id", "");
  }

  private boolean j()
  {
    try
    {
      boolean bool = PreferenceManager.getDefaultSharedPreferences(this.b.getApplicationContext()).getBoolean("fb_is_statistics_reported", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public android.graphics.Bitmap a(String paramString)
    throws c
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnonnull +14 -> 17
    //   6: new 343	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc_w 345
    //   13: invokespecial 347	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 349	android/os/Bundle
    //   20: dup
    //   21: invokespecial 350	android/os/Bundle:<init>	()V
    //   24: astore_3
    //   25: aload_3
    //   26: ldc_w 352
    //   29: iconst_0
    //   30: invokevirtual 355	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   33: aload_3
    //   34: ldc_w 357
    //   37: sipush 720
    //   40: invokestatic 361	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   43: invokevirtual 364	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_3
    //   47: ldc_w 366
    //   50: ldc_w 368
    //   53: invokevirtual 364	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_3
    //   57: ldc_w 370
    //   60: sipush 720
    //   63: invokestatic 361	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   66: invokevirtual 364	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: new 296	com/facebook/Request
    //   72: dup
    //   73: invokestatic 274	com/facebook/Session:getActiveSession	()Lcom/facebook/Session;
    //   76: new 372	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 375
    //   86: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 375
    //   96: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 381
    //   102: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aload_3
    //   109: getstatic 390	com/facebook/HttpMethod:GET	Lcom/facebook/HttpMethod;
    //   112: aconst_null
    //   113: invokespecial 393	com/facebook/Request:<init>	(Lcom/facebook/Session;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/Request$Callback;)V
    //   116: invokevirtual 397	com/facebook/Request:executeAndWait	()Lcom/facebook/Response;
    //   119: invokevirtual 401	com/facebook/Response:getGraphObject	()Lcom/facebook/model/GraphObject;
    //   122: invokeinterface 407 1 0
    //   127: ldc_w 409
    //   130: invokevirtual 415	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   133: ldc_w 417
    //   136: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 6
    //   141: aload 6
    //   143: astore 7
    //   145: aload 7
    //   147: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: istore 13
    //   152: aconst_null
    //   153: astore_2
    //   154: iload 13
    //   156: ifeq +85 -> 241
    //   159: new 372	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 421
    //   169: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_1
    //   173: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 375
    //   179: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc_w 381
    //   185: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 423
    //   191: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc_w 370
    //   197: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 425
    //   203: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: sipush 720
    //   209: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 430
    //   215: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 357
    //   221: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc_w 425
    //   227: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: sipush 720
    //   233: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore 7
    //   241: new 432	java/net/URL
    //   244: dup
    //   245: aload 7
    //   247: invokespecial 433	java/net/URL:<init>	(Ljava/lang/String;)V
    //   250: invokevirtual 437	java/net/URL:openStream	()Ljava/io/InputStream;
    //   253: astore 14
    //   255: aload 14
    //   257: astore 9
    //   259: aload 9
    //   261: invokestatic 442	com/viber/voip/util/dq:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   264: astore 15
    //   266: aload 15
    //   268: ifnonnull +59 -> 327
    //   271: new 333	com/viber/voip/messages/extras/a/c
    //   274: dup
    //   275: ldc_w 444
    //   278: invokespecial 445	com/viber/voip/messages/extras/a/c:<init>	(Ljava/lang/String;)V
    //   281: athrow
    //   282: astore 8
    //   284: aload 8
    //   286: athrow
    //   287: astore 10
    //   289: aload 9
    //   291: astore_2
    //   292: aload_2
    //   293: ifnull +7 -> 300
    //   296: aload_2
    //   297: invokevirtual 450	java/io/InputStream:close	()V
    //   300: aload 10
    //   302: athrow
    //   303: astore 5
    //   305: new 333	com/viber/voip/messages/extras/a/c
    //   308: dup
    //   309: aload 5
    //   311: invokespecial 453	com/viber/voip/messages/extras/a/c:<init>	(Ljava/lang/Throwable;)V
    //   314: athrow
    //   315: astore 4
    //   317: new 333	com/viber/voip/messages/extras/a/c
    //   320: dup
    //   321: aload 4
    //   323: invokespecial 453	com/viber/voip/messages/extras/a/c:<init>	(Ljava/lang/Throwable;)V
    //   326: athrow
    //   327: aload 9
    //   329: ifnull +8 -> 337
    //   332: aload 9
    //   334: invokevirtual 450	java/io/InputStream:close	()V
    //   337: aload 15
    //   339: areturn
    //   340: astore 12
    //   342: new 333	com/viber/voip/messages/extras/a/c
    //   345: dup
    //   346: aload 12
    //   348: invokespecial 453	com/viber/voip/messages/extras/a/c:<init>	(Ljava/lang/Throwable;)V
    //   351: athrow
    //   352: astore 10
    //   354: goto -62 -> 292
    //   357: astore 16
    //   359: aload 15
    //   361: areturn
    //   362: astore 11
    //   364: goto -64 -> 300
    //   367: astore 12
    //   369: aload 9
    //   371: astore_2
    //   372: goto -30 -> 342
    //   375: astore 8
    //   377: aconst_null
    //   378: astore 9
    //   380: goto -96 -> 284
    //
    // Exception table:
    //   from	to	target	type
    //   259	266	282	com/viber/voip/messages/extras/a/c
    //   271	282	282	com/viber/voip/messages/extras/a/c
    //   259	266	287	finally
    //   271	282	287	finally
    //   284	287	287	finally
    //   17	141	303	org/json/JSONException
    //   17	141	315	java/lang/NullPointerException
    //   145	152	340	java/lang/Exception
    //   159	241	340	java/lang/Exception
    //   241	255	340	java/lang/Exception
    //   145	152	352	finally
    //   159	241	352	finally
    //   241	255	352	finally
    //   342	352	352	finally
    //   332	337	357	java/io/IOException
    //   296	300	362	java/io/IOException
    //   259	266	367	java/lang/Exception
    //   271	282	367	java/lang/Exception
    //   145	152	375	com/viber/voip/messages/extras/a/c
    //   159	241	375	com/viber/voip/messages/extras/a/c
    //   241	255	375	com/viber/voip/messages/extras/a/c
  }

  public void a()
  {
    Session localSession = Session.getActiveSession();
    if ((localSession != null) && (!localSession.isClosed()))
    {
      localSession.closeAndClearTokenInformation();
      Session.setActiveSession(null);
    }
    a("", "");
  }

  public void a(Activity paramActivity)
  {
    if (!this.i)
    {
      this.i = true;
      AppEventsLogger.activateApp(paramActivity);
    }
  }

  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Session localSession;
    if ((Session.getActiveSession() != null) && (!paramActivity.isFinishing()))
    {
      localSession = Session.getActiveSession();
      if (paramIntent == null)
        break label42;
    }
    label42: for (Bundle localBundle = paramIntent.getExtras(); ; localBundle = null)
    {
      localSession.onActivityResult(paramActivity, paramInt1, paramInt2, localBundle);
      return;
    }
  }

  public void a(Activity paramActivity, a parama)
  {
    this.e = parama;
    Session localSession = f();
    if (((!localSession.isOpened()) && (!localSession.isClosed())) || (localSession.getState().equals(SessionState.CREATED_TOKEN_LOADED)))
    {
      localSession.openForRead(new Session.OpenRequest(paramActivity).setCallback(this.k).setPermissions(Arrays.asList(f)));
      return;
    }
    Session.openActiveSession(paramActivity, true, Arrays.asList(f), this.k);
  }

  public void a(a parama)
  {
    if (this.e == parama)
      this.e = null;
  }

  public void a(String paramString1, String paramString2)
  {
    PreferenceManager.getDefaultSharedPreferences(this.b).edit().putString("fb_name", paramString1).apply();
    PreferenceManager.getDefaultSharedPreferences(this.b).edit().putString("fb_id", paramString2).apply();
    a(false);
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(this.b).edit().putBoolean("fb_is_statistics_reported", paramBoolean).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean a(b paramb)
  {
    synchronized (this.g)
    {
      boolean bool = this.g.add(paramb);
      return bool;
    }
  }

  public d b()
  {
    Session localSession = f();
    if (localSession.getState().equals(SessionState.CREATED_TOKEN_LOADED))
      return d.a;
    if (localSession.isOpened())
      return d.b;
    return d.d;
  }

  public void b(Activity paramActivity)
  {
    if (!this.i)
    {
      this.i = false;
      AppEventsLogger.deactivateApp(paramActivity);
    }
  }

  public boolean b(b paramb)
  {
    synchronized (this.g)
    {
      boolean bool = this.g.remove(paramb);
      return bool;
    }
  }

  public void c()
  {
    a(false);
  }

  public e d()
  {
    Response localResponse = Request.newMeRequest(Session.getActiveSession(), null).executeAndWait();
    if ((localResponse != null) && (localResponse.getGraphObject() != null))
      try
      {
        JSONObject localJSONObject = localResponse.getGraphObject().getInnerJSONObject();
        e locale = new e(localJSONObject.optString("id"), localJSONObject.getString("name"), null);
        return locale;
      }
      catch (JSONException localJSONException)
      {
        return null;
      }
    if (localResponse.getError() != null)
      throw new d(b(localResponse.getError().getErrorMessage()));
    return null;
  }

  public String e()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.b.getApplicationContext()).getString("fb_name", "");
  }

  public void onServiceStateChanged(int paramInt)
  {
    if (paramInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal())
      g();
  }

  public static class a
  {
    public void onAuthorizationCanceled()
    {
    }

    public void onAuthorizationSuccess(boolean paramBoolean)
    {
    }

    public void onError()
    {
    }

    public void onFacebookProfileStored()
    {
    }

    public void onLogout()
    {
    }
  }

  public static abstract interface b
  {
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(String paramString);
  }

  public static enum d
  {
    static
    {
      d[] arrayOfd = new d[4];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
      arrayOfd[2] = c;
      arrayOfd[3] = d;
    }
  }

  public static final class e
  {
    private final String a;
    private final String b;

    private e(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.a.e
 * JD-Core Version:    0.6.2
 */