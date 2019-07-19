package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import com.mixpanel.android.b.b;
import com.mixpanel.android.b.c;
import com.mixpanel.android.b.i.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class a
{
  private static final Map<Context, a> d = new HashMap();
  protected final Context a;
  protected final i b;
  private final e c;

  a(Context paramContext)
  {
    this.a = paramContext;
    this.b = c(paramContext);
    this.c = a();
    b().a();
  }

  public static a a(Context paramContext)
  {
    synchronized (d)
    {
      Context localContext = paramContext.getApplicationContext();
      if (!d.containsKey(localContext))
      {
        locala = new a(localContext);
        d.put(localContext, locala);
        return locala;
      }
      a locala = (a)d.get(localContext);
    }
  }

  private void a(String paramString)
  {
    com.mixpanel.android.b.f.a("MixpanelAPI.Messages", paramString + " (Thread " + Thread.currentThread().getId() + ")");
  }

  private void a(String paramString, Throwable paramThrowable)
  {
    com.mixpanel.android.b.f.a("MixpanelAPI.Messages", paramString + " (Thread " + Thread.currentThread().getId() + ")", paramThrowable);
  }

  protected e a()
  {
    return new e();
  }

  public void a(a parama)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = parama;
    this.c.a(localMessage);
  }

  public void a(b paramb)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramb.e();
    if (paramb.a());
    for (int i = 1; ; i = 0)
    {
      localMessage.arg1 = i;
      this.c.a(localMessage);
      return;
    }
  }

  public void a(c paramc)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    localMessage.obj = paramc;
    this.c.a(localMessage);
  }

  public void a(d paramd)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramd;
    this.c.a(localMessage);
  }

  public void a(f paramf)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 12;
    localMessage.obj = paramf;
    this.c.a(localMessage);
  }

  protected com.mixpanel.android.b.i b()
  {
    return new c();
  }

  protected j b(Context paramContext)
  {
    return j.a(paramContext);
  }

  protected i c(Context paramContext)
  {
    return i.a(paramContext);
  }

  static class a extends a.c
  {
    private final String a;
    private final JSONObject b;
    private final JSONObject c;
    private final boolean d;

    public a(String paramString1, JSONObject paramJSONObject, String paramString2)
    {
      this(paramString1, paramJSONObject, paramString2, false, new JSONObject());
    }

    public a(String paramString1, JSONObject paramJSONObject1, String paramString2, boolean paramBoolean, JSONObject paramJSONObject2)
    {
      super();
      this.a = paramString1;
      this.b = paramJSONObject1;
      this.d = paramBoolean;
      this.c = paramJSONObject2;
    }

    public String a()
    {
      return this.a;
    }

    public JSONObject b()
    {
      return this.b;
    }

    public JSONObject c()
    {
      return this.c;
    }

    public boolean d()
    {
      return this.d;
    }
  }

  static class b extends a.c
  {
    private final boolean a;

    public b(String paramString)
    {
      this(paramString, true);
    }

    protected b(String paramString, boolean paramBoolean)
    {
      super();
      this.a = paramBoolean;
    }

    public boolean a()
    {
      return this.a;
    }
  }

  static class c
  {
    private final String a;

    public c(String paramString)
    {
      this.a = paramString;
    }

    public String e()
    {
      return this.a;
    }
  }

  static class d extends a.c
  {
    private final JSONObject a;

    public d(JSONObject paramJSONObject, String paramString)
    {
      super();
      this.a = paramJSONObject;
    }

    public JSONObject a()
    {
      return this.a;
    }

    public String toString()
    {
      return this.a.toString();
    }
  }

  class e
  {
    private final Object b = new Object();
    private Handler c = a();
    private long d = 0L;
    private long e = 0L;
    private long f = -1L;
    private t g;

    public e()
    {
    }

    private void b()
    {
      long l1 = System.currentTimeMillis();
      long l2 = 1L + this.d;
      if (this.f > 0L)
      {
        this.e = ((l1 - this.f + this.e * this.d) / l2);
        long l3 = this.e / 1000L;
        a.a(a.this, "Average send frequency approximately " + l3 + " seconds.");
      }
      this.f = l1;
      this.d = l2;
    }

    protected Handler a()
    {
      HandlerThread localHandlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
      localHandlerThread.start();
      return new a(localHandlerThread.getLooper());
    }

    public void a(Message paramMessage)
    {
      synchronized (this.b)
      {
        if (this.c == null)
        {
          a.a(a.this, "Dead mixpanel worker dropping a message: " + paramMessage.what);
          return;
        }
        this.c.sendMessage(paramMessage);
      }
    }

    class a extends Handler
    {
      private j b = null;
      private final e c;
      private final long d;
      private long e;
      private long f;
      private int g;

      public a(Looper arg2)
      {
        super();
        a.e.a(a.e.this, t.a(a.this.a));
        this.c = a();
        this.d = a.this.b.b();
      }

      private JSONObject a(a.a parama)
        throws JSONException
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = parama.b();
        JSONObject localJSONObject3 = b();
        localJSONObject3.put("token", parama.e());
        if (localJSONObject2 != null)
        {
          Iterator localIterator = localJSONObject2.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject3.put(str, localJSONObject2.get(str));
          }
        }
        localJSONObject1.put("event", parama.a());
        localJSONObject1.put("properties", localJSONObject3);
        localJSONObject1.put("$mp_metadata", parama.c());
        return localJSONObject1;
      }

      private void a(j paramj, String paramString)
      {
        if (!a.this.b().a(a.this.a, a.this.b.D()))
        {
          a.a(a.this, "Not flushing data to Mixpanel because the device is not connected to the internet.");
          return;
        }
        a(paramj, paramString, j.b.a, a.this.b.k());
        a(paramj, paramString, j.b.b, a.this.b.m());
      }

      private void a(j paramj, String paramString1, j.b paramb, String paramString2)
      {
        com.mixpanel.android.b.i locali = a.this.b();
        f localf = this.c.b(paramString1);
        boolean bool = true;
        if ((localf == null) || (localf.e() == null))
          bool = false;
        Object localObject1 = paramj.a(paramb, paramString1, bool);
        Object localObject2 = Integer.valueOf(0);
        if (localObject1 != null)
          localObject2 = Integer.valueOf(localObject1[2]);
        while (true)
        {
          String str1;
          String str2;
          HashMap localHashMap;
          int i;
          if ((localObject1 != null) && (((Integer)localObject2).intValue() > 0))
          {
            str1 = localObject1[0];
            str2 = localObject1[1];
            String str3 = b.a(str2);
            localHashMap = new HashMap();
            localHashMap.put("data", str3);
            if (i.a)
              localHashMap.put("verbose", "1");
            i = 1;
          }
          try
          {
            byte[] arrayOfByte = locali.a(paramString2, localHashMap, a.this.b.C());
            int j;
            if (arrayOfByte == null)
              j = 0;
            while (true)
            {
              MalformedURLException localMalformedURLException1;
              try
              {
                a.a(a.this, "Response was null, unexpected failure posting to " + paramString2 + ".");
                i = j;
                if (i == 0)
                  break label646;
                a.a(a.this, "Not retrying this batch of events, deleting them from DB.");
                paramj.a(str1, paramb, paramString1, bool);
                String[] arrayOfString = paramj.a(paramb, paramString1, bool);
                if (arrayOfString == null)
                  break label781;
                localObject3 = Integer.valueOf(arrayOfString[2]);
                localObject2 = localObject3;
                localObject1 = arrayOfString;
                break;
                j = 1;
              }
              catch (OutOfMemoryError localOutOfMemoryError3)
              {
                try
                {
                  String str4 = new String(arrayOfByte, "UTF-8");
                  if (this.g > 0)
                  {
                    this.g = 0;
                    removeMessages(2, paramString1);
                  }
                  a.a(a.this, "Successfully posted to " + paramString2 + ": \n" + str2);
                  a.a(a.this, "Response was " + str4);
                  continue;
                  localOutOfMemoryError3 = localOutOfMemoryError3;
                  i = j;
                  OutOfMemoryError localOutOfMemoryError1 = localOutOfMemoryError3;
                  com.mixpanel.android.b.f.e("MixpanelAPI.Messages", "Out of memory when posting to " + paramString2 + ".", localOutOfMemoryError1);
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  throw new RuntimeException("UTF not supported on this platform?", localUnsupportedEncodingException);
                }
              }
              catch (MalformedURLException localMalformedURLException3)
              {
                i = j;
                localMalformedURLException1 = localMalformedURLException3;
              }
              label457: com.mixpanel.android.b.f.e("MixpanelAPI.Messages", "Cannot interpret " + paramString2 + " as a URL.", localMalformedURLException1);
            }
          }
          catch (i.a locala)
          {
            while (true)
            {
              a.a(a.this, "Cannot post message to " + paramString2 + ".", locala);
              this.f = (1000 * locala.a());
              i = 0;
            }
          }
          catch (SocketTimeoutException localSocketTimeoutException)
          {
            while (true)
            {
              a.a(a.this, "Cannot post message to " + paramString2 + ".", localSocketTimeoutException);
              i = 0;
            }
          }
          catch (IOException localIOException)
          {
            while (true)
            {
              a.a(a.this, "Cannot post message to " + paramString2 + ".", localIOException);
              i = 0;
            }
            removeMessages(2, paramString1);
            this.f = Math.max(60000L * ()Math.pow(2.0D, this.g), this.f);
            this.f = Math.min(this.f, 600000L);
            Message localMessage = Message.obtain();
            localMessage.what = 2;
            localMessage.obj = paramString1;
            sendMessageDelayed(localMessage, this.f);
            this.g = (1 + this.g);
            a.a(a.this, "Retrying this batch of events in " + this.f + " ms");
            return;
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            break label457;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            while (true)
            {
              label646: continue;
              label781: Object localObject3 = localObject2;
            }
          }
        }
      }

      private void a(String paramString)
      {
        try
        {
          if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(a.this.a) != 0)
          {
            com.mixpanel.android.b.f.c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play Services are not installed.");
            return;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play services are not configured.");
          return;
        }
        catch (IOException localIOException)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.Messages", "Exception when trying to register for GCM", localIOException);
          return;
          final String str = InstanceID.getInstance(a.this.a).getToken(paramString, "GCM", null);
          MixpanelAPI.allInstances(new MixpanelAPI.a()
          {
            public void a(MixpanelAPI paramAnonymousMixpanelAPI)
            {
              com.mixpanel.android.b.f.a("MixpanelAPI.Messages", "Using existing pushId " + str);
              paramAnonymousMixpanelAPI.getPeople().c(str);
            }
          });
          return;
        }
        catch (NoClassDefFoundError localNoClassDefFoundError)
        {
          com.mixpanel.android.b.f.d("MixpanelAPI.Messages", "Google play services were not part of this build, push notifications cannot be registered or delivered");
        }
      }

      private JSONObject b()
        throws JSONException
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("mp_lib", "android");
        localJSONObject.put("$lib_version", "5.4.4-SNAPSHOT");
        localJSONObject.put("$os", "Android");
        String str1;
        if (Build.VERSION.RELEASE == null)
          str1 = "UNKNOWN";
        while (true)
        {
          localJSONObject.put("$os_version", str1);
          String str2;
          label73: String str3;
          label94: String str4;
          if (Build.MANUFACTURER == null)
          {
            str2 = "UNKNOWN";
            localJSONObject.put("$manufacturer", str2);
            if (Build.BRAND != null)
              break label520;
            str3 = "UNKNOWN";
            localJSONObject.put("$brand", str3);
            if (Build.MODEL != null)
              break label528;
            str4 = "UNKNOWN";
            label115: localJSONObject.put("$model", str4);
          }
          try
          {
            int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(a.this.a);
            switch (i)
            {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
            case 0:
              while (true)
              {
                DisplayMetrics localDisplayMetrics = a.e.c(a.e.this).f();
                localJSONObject.put("$screen_dpi", localDisplayMetrics.densityDpi);
                localJSONObject.put("$screen_height", localDisplayMetrics.heightPixels);
                localJSONObject.put("$screen_width", localDisplayMetrics.widthPixels);
                String str5 = a.e.c(a.e.this).a();
                if (str5 != null)
                {
                  localJSONObject.put("$app_version", str5);
                  localJSONObject.put("$app_version_string", str5);
                }
                Integer localInteger = a.e.c(a.e.this).b();
                if (localInteger != null)
                {
                  localJSONObject.put("$app_release", localInteger);
                  localJSONObject.put("$app_build_number", localInteger);
                }
                Boolean localBoolean1 = Boolean.valueOf(a.e.c(a.e.this).d());
                if (localBoolean1 != null)
                  localJSONObject.put("$has_nfc", localBoolean1.booleanValue());
                Boolean localBoolean2 = Boolean.valueOf(a.e.c(a.e.this).e());
                if (localBoolean2 != null)
                  localJSONObject.put("$has_telephone", localBoolean2.booleanValue());
                String str6 = a.e.c(a.e.this).g();
                if (str6 != null)
                  localJSONObject.put("$carrier", str6);
                Boolean localBoolean3 = a.e.c(a.e.this).h();
                if (localBoolean3 != null)
                  localJSONObject.put("$wifi", localBoolean3.booleanValue());
                Boolean localBoolean4 = a.e.c(a.e.this).i();
                if (localBoolean4 != null)
                  localJSONObject.put("$bluetooth_enabled", localBoolean4);
                String str7 = a.e.c(a.e.this).j();
                if (str7 != null)
                  localJSONObject.put("$bluetooth_version", str7);
                return localJSONObject;
                str1 = Build.VERSION.RELEASE;
                break;
                str2 = Build.MANUFACTURER;
                break label73;
                label520: str3 = Build.BRAND;
                break label94;
                label528: str4 = Build.MODEL;
                break label115;
                localJSONObject.put("$google_play_services", "available");
              }
            case 1:
            case 2:
            case 3:
            case 9:
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            while (true)
              localJSONObject.put("$google_play_services", "not configured");
          }
          catch (NoClassDefFoundError localNoClassDefFoundError)
          {
            while (true)
            {
              localJSONObject.put("$google_play_services", "not included");
              continue;
              localJSONObject.put("$google_play_services", "missing");
              continue;
              localJSONObject.put("$google_play_services", "out of date");
              continue;
              localJSONObject.put("$google_play_services", "disabled");
              continue;
              localJSONObject.put("$google_play_services", "invalid");
            }
          }
        }
      }

      protected e a()
      {
        return new e(a.this.a, a.this.b);
      }

      // ERROR //
      public void handleMessage(Message paramMessage)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: aload_0
        //   3: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   6: ifnonnull +81 -> 87
        //   9: aload_0
        //   10: aload_0
        //   11: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   14: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   17: aload_0
        //   18: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   21: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   24: getfield 35	com/mixpanel/android/mpmetrics/a:a	Landroid/content/Context;
        //   27: invokevirtual 512	com/mixpanel/android/mpmetrics/a:b	(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/j;
        //   30: putfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   33: aload_0
        //   34: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   37: invokestatic 518	java/lang/System:currentTimeMillis	()J
        //   40: aload_0
        //   41: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   44: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   47: getfield 51	com/mixpanel/android/mpmetrics/a:b	Lcom/mixpanel/android/mpmetrics/i;
        //   50: invokevirtual 520	com/mixpanel/android/mpmetrics/i:c	()J
        //   53: lsub
        //   54: getstatic 134	com/mixpanel/android/mpmetrics/j$b:a	Lcom/mixpanel/android/mpmetrics/j$b;
        //   57: invokevirtual 523	com/mixpanel/android/mpmetrics/j:a	(JLcom/mixpanel/android/mpmetrics/j$b;)V
        //   60: aload_0
        //   61: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   64: invokestatic 518	java/lang/System:currentTimeMillis	()J
        //   67: aload_0
        //   68: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   71: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   74: getfield 51	com/mixpanel/android/mpmetrics/a:b	Lcom/mixpanel/android/mpmetrics/i;
        //   77: invokevirtual 520	com/mixpanel/android/mpmetrics/i:c	()J
        //   80: lsub
        //   81: getstatic 142	com/mixpanel/android/mpmetrics/j$b:b	Lcom/mixpanel/android/mpmetrics/j$b;
        //   84: invokevirtual 523	com/mixpanel/android/mpmetrics/j:a	(JLcom/mixpanel/android/mpmetrics/j$b;)V
        //   87: bipush 253
        //   89: istore_3
        //   90: aload_1
        //   91: getfield 306	android/os/Message:what	I
        //   94: ifne +217 -> 311
        //   97: aload_1
        //   98: getfield 310	android/os/Message:obj	Ljava/lang/Object;
        //   101: checkcast 525	com/mixpanel/android/mpmetrics/a$d
        //   104: astore 44
        //   106: aload_0
        //   107: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   110: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   113: ldc_w 527
        //   116: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   119: aload_0
        //   120: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   123: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   126: new 215	java/lang/StringBuilder
        //   129: dup
        //   130: invokespecial 216	java/lang/StringBuilder:<init>	()V
        //   133: ldc_w 529
        //   136: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: aload 44
        //   141: invokevirtual 530	com/mixpanel/android/mpmetrics/a$d:toString	()Ljava/lang/String;
        //   144: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   147: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   150: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   153: aload 44
        //   155: invokevirtual 531	com/mixpanel/android/mpmetrics/a$d:e	()Ljava/lang/String;
        //   158: astore 9
        //   160: aload_0
        //   161: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   164: aload 44
        //   166: invokevirtual 533	com/mixpanel/android/mpmetrics/a$d:a	()Lorg/json/JSONObject;
        //   169: aload 9
        //   171: getstatic 142	com/mixpanel/android/mpmetrics/j$b:b	Lcom/mixpanel/android/mpmetrics/j$b;
        //   174: iconst_0
        //   175: invokevirtual 536	com/mixpanel/android/mpmetrics/j:a	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/j$b;Z)I
        //   178: istore_3
        //   179: iload_3
        //   180: aload_0
        //   181: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   184: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   187: getfield 51	com/mixpanel/android/mpmetrics/a:b	Lcom/mixpanel/android/mpmetrics/i;
        //   190: invokevirtual 537	com/mixpanel/android/mpmetrics/i:a	()I
        //   193: if_icmpge +9 -> 202
        //   196: iload_3
        //   197: bipush 254
        //   199: if_icmpne +848 -> 1047
        //   202: aload_0
        //   203: getfield 239	com/mixpanel/android/mpmetrics/a$e$a:g	I
        //   206: ifgt +841 -> 1047
        //   209: aload 9
        //   211: ifnull +836 -> 1047
        //   214: aload_0
        //   215: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   218: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   221: new 215	java/lang/StringBuilder
        //   224: dup
        //   225: invokespecial 216	java/lang/StringBuilder:<init>	()V
        //   228: ldc_w 539
        //   231: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   234: iload_3
        //   235: invokevirtual 542	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   238: ldc_w 544
        //   241: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   244: aload 9
        //   246: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   249: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   252: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   255: aload_0
        //   256: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   259: invokestatic 547	com/mixpanel/android/mpmetrics/a$e:a	(Lcom/mixpanel/android/mpmetrics/a$e;)V
        //   262: aload_0
        //   263: aload_0
        //   264: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   267: aload 9
        //   269: invokespecial 549	com/mixpanel/android/mpmetrics/a$e$a:a	(Lcom/mixpanel/android/mpmetrics/j;Ljava/lang/String;)V
        //   272: invokestatic 554	android/os/SystemClock:elapsedRealtime	()J
        //   275: lstore 12
        //   277: aload_0
        //   278: getfield 556	com/mixpanel/android/mpmetrics/a$e$a:e	J
        //   281: lstore 14
        //   283: lload 12
        //   285: lload 14
        //   287: lcmp
        //   288: iflt +22 -> 310
        //   291: aload_0
        //   292: getfield 48	com/mixpanel/android/mpmetrics/a$e$a:c	Lcom/mixpanel/android/mpmetrics/e;
        //   295: aload 9
        //   297: aload_0
        //   298: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   301: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   304: invokevirtual 115	com/mixpanel/android/mpmetrics/a:b	()Lcom/mixpanel/android/b/i;
        //   307: invokevirtual 559	com/mixpanel/android/mpmetrics/e:a	(Ljava/lang/String;Lcom/mixpanel/android/b/i;)V
        //   310: return
        //   311: aload_1
        //   312: getfield 306	android/os/Message:what	I
        //   315: iload_2
        //   316: if_icmpne +203 -> 519
        //   319: aload_1
        //   320: getfield 310	android/os/Message:obj	Ljava/lang/Object;
        //   323: checkcast 68	com/mixpanel/android/mpmetrics/a$a
        //   326: astore 33
        //   328: aload_0
        //   329: aload 33
        //   331: invokespecial 561	com/mixpanel/android/mpmetrics/a$e$a:a	(Lcom/mixpanel/android/mpmetrics/a$a;)Lorg/json/JSONObject;
        //   334: astore 39
        //   336: aload_0
        //   337: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   340: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   343: ldc_w 563
        //   346: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   349: aload_0
        //   350: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   353: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   356: new 215	java/lang/StringBuilder
        //   359: dup
        //   360: invokespecial 216	java/lang/StringBuilder:<init>	()V
        //   363: ldc_w 529
        //   366: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: aload 39
        //   371: invokevirtual 564	org/json/JSONObject:toString	()Ljava/lang/String;
        //   374: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   377: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   380: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   383: aload 33
        //   385: invokevirtual 77	com/mixpanel/android/mpmetrics/a$a:e	()Ljava/lang/String;
        //   388: astore 40
        //   390: aload 40
        //   392: astore 35
        //   394: aload_0
        //   395: getfield 48	com/mixpanel/android/mpmetrics/a$e$a:c	Lcom/mixpanel/android/mpmetrics/e;
        //   398: aload 35
        //   400: invokevirtual 162	com/mixpanel/android/mpmetrics/e:b	(Ljava/lang/String;)Lcom/mixpanel/android/mpmetrics/f;
        //   403: astore 41
        //   405: aload 41
        //   407: ifnull +19 -> 426
        //   410: aload 33
        //   412: invokevirtual 565	com/mixpanel/android/mpmetrics/a$a:d	()Z
        //   415: ifeq +11 -> 426
        //   418: aload 41
        //   420: invokevirtual 567	com/mixpanel/android/mpmetrics/f:f	()Z
        //   423: ifeq -113 -> 310
        //   426: aload_0
        //   427: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   430: aload 39
        //   432: aload 35
        //   434: getstatic 134	com/mixpanel/android/mpmetrics/j$b:a	Lcom/mixpanel/android/mpmetrics/j$b;
        //   437: aload 33
        //   439: invokevirtual 565	com/mixpanel/android/mpmetrics/a$a:d	()Z
        //   442: invokevirtual 536	com/mixpanel/android/mpmetrics/j:a	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/j$b;Z)I
        //   445: istore 42
        //   447: aload 35
        //   449: astore 43
        //   451: iload 42
        //   453: istore 38
        //   455: aload 43
        //   457: astore 37
        //   459: aload 37
        //   461: astore 9
        //   463: iload 38
        //   465: istore_3
        //   466: goto -287 -> 179
        //   469: astore 34
        //   471: aconst_null
        //   472: astore 35
        //   474: aload 34
        //   476: astore 36
        //   478: ldc 251
        //   480: new 215	java/lang/StringBuilder
        //   483: dup
        //   484: invokespecial 216	java/lang/StringBuilder:<init>	()V
        //   487: ldc_w 569
        //   490: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   493: aload 33
        //   495: invokevirtual 105	com/mixpanel/android/mpmetrics/a$a:a	()Ljava/lang/String;
        //   498: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   501: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   504: aload 36
        //   506: invokestatic 258	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   509: aload 35
        //   511: astore 37
        //   513: iload_3
        //   514: istore 38
        //   516: goto -57 -> 459
        //   519: aload_1
        //   520: getfield 306	android/os/Message:what	I
        //   523: iconst_2
        //   524: if_icmpne +188 -> 712
        //   527: aload_0
        //   528: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   531: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   534: ldc_w 571
        //   537: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   540: aload_0
        //   541: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   544: invokestatic 547	com/mixpanel/android/mpmetrics/a$e:a	(Lcom/mixpanel/android/mpmetrics/a$e;)V
        //   547: aload_1
        //   548: getfield 310	android/os/Message:obj	Ljava/lang/Object;
        //   551: checkcast 97	java/lang/String
        //   554: astore 27
        //   556: aload_1
        //   557: getfield 574	android/os/Message:arg1	I
        //   560: iload_2
        //   561: if_icmpne +62 -> 623
        //   564: aload_0
        //   565: aload_0
        //   566: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   569: aload 27
        //   571: invokespecial 549	com/mixpanel/android/mpmetrics/a$e$a:a	(Lcom/mixpanel/android/mpmetrics/j;Ljava/lang/String;)V
        //   574: iload_2
        //   575: ifeq +41 -> 616
        //   578: invokestatic 554	android/os/SystemClock:elapsedRealtime	()J
        //   581: lstore 28
        //   583: aload_0
        //   584: getfield 556	com/mixpanel/android/mpmetrics/a$e$a:e	J
        //   587: lstore 30
        //   589: lload 28
        //   591: lload 30
        //   593: lcmp
        //   594: iflt +22 -> 616
        //   597: aload_0
        //   598: getfield 48	com/mixpanel/android/mpmetrics/a$e$a:c	Lcom/mixpanel/android/mpmetrics/e;
        //   601: aload 27
        //   603: aload_0
        //   604: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   607: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   610: invokevirtual 115	com/mixpanel/android/mpmetrics/a:b	()Lcom/mixpanel/android/b/i;
        //   613: invokevirtual 559	com/mixpanel/android/mpmetrics/e:a	(Ljava/lang/String;Lcom/mixpanel/android/b/i;)V
        //   616: aload 27
        //   618: astore 9
        //   620: goto -441 -> 179
        //   623: iconst_0
        //   624: istore_2
        //   625: goto -61 -> 564
        //   628: astore 32
        //   630: aload_0
        //   631: invokestatic 554	android/os/SystemClock:elapsedRealtime	()J
        //   634: sipush 1000
        //   637: aload 32
        //   639: invokevirtual 276	com/mixpanel/android/b/i$a:a	()I
        //   642: imul
        //   643: i2l
        //   644: ladd
        //   645: putfield 556	com/mixpanel/android/mpmetrics/a$e$a:e	J
        //   648: goto -32 -> 616
        //   651: astore 4
        //   653: ldc 251
        //   655: ldc_w 576
        //   658: aload 4
        //   660: invokestatic 258	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   663: aload_0
        //   664: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   667: invokestatic 579	com/mixpanel/android/mpmetrics/a$e:b	(Lcom/mixpanel/android/mpmetrics/a$e;)Ljava/lang/Object;
        //   670: astore 5
        //   672: aload 5
        //   674: monitorenter
        //   675: aload_0
        //   676: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   679: aconst_null
        //   680: invokestatic 582	com/mixpanel/android/mpmetrics/a$e:a	(Lcom/mixpanel/android/mpmetrics/a$e;Landroid/os/Handler;)Landroid/os/Handler;
        //   683: pop
        //   684: invokestatic 588	android/os/Looper:myLooper	()Landroid/os/Looper;
        //   687: invokevirtual 591	android/os/Looper:quit	()V
        //   690: ldc 251
        //   692: ldc_w 593
        //   695: aload 4
        //   697: invokestatic 258	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   700: aload 5
        //   702: monitorexit
        //   703: return
        //   704: astore 6
        //   706: aload 5
        //   708: monitorexit
        //   709: aload 6
        //   711: athrow
        //   712: aload_1
        //   713: getfield 306	android/os/Message:what	I
        //   716: bipush 12
        //   718: if_icmpne +114 -> 832
        //   721: aload_0
        //   722: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   725: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   728: ldc_w 595
        //   731: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   734: aload_1
        //   735: getfield 310	android/os/Message:obj	Ljava/lang/Object;
        //   738: checkcast 164	com/mixpanel/android/mpmetrics/f
        //   741: astore 20
        //   743: aload_0
        //   744: getfield 48	com/mixpanel/android/mpmetrics/a$e$a:c	Lcom/mixpanel/android/mpmetrics/e;
        //   747: aload 20
        //   749: invokevirtual 598	com/mixpanel/android/mpmetrics/e:a	(Lcom/mixpanel/android/mpmetrics/f;)V
        //   752: invokestatic 554	android/os/SystemClock:elapsedRealtime	()J
        //   755: lstore 21
        //   757: aload_0
        //   758: getfield 556	com/mixpanel/android/mpmetrics/a$e$a:e	J
        //   761: lstore 23
        //   763: lload 21
        //   765: lload 23
        //   767: lcmp
        //   768: istore 25
        //   770: aconst_null
        //   771: astore 9
        //   773: iload 25
        //   775: iflt -596 -> 179
        //   778: aload_0
        //   779: getfield 48	com/mixpanel/android/mpmetrics/a$e$a:c	Lcom/mixpanel/android/mpmetrics/e;
        //   782: aload 20
        //   784: invokevirtual 599	com/mixpanel/android/mpmetrics/f:a	()Ljava/lang/String;
        //   787: aload_0
        //   788: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   791: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   794: invokevirtual 115	com/mixpanel/android/mpmetrics/a:b	()Lcom/mixpanel/android/b/i;
        //   797: invokevirtual 559	com/mixpanel/android/mpmetrics/e:a	(Ljava/lang/String;Lcom/mixpanel/android/b/i;)V
        //   800: aconst_null
        //   801: astore 9
        //   803: goto -624 -> 179
        //   806: astore 26
        //   808: aload_0
        //   809: invokestatic 554	android/os/SystemClock:elapsedRealtime	()J
        //   812: sipush 1000
        //   815: aload 26
        //   817: invokevirtual 276	com/mixpanel/android/b/i$a:a	()I
        //   820: imul
        //   821: i2l
        //   822: ladd
        //   823: putfield 556	com/mixpanel/android/mpmetrics/a$e$a:e	J
        //   826: aconst_null
        //   827: astore 9
        //   829: goto -650 -> 179
        //   832: aload_1
        //   833: getfield 306	android/os/Message:what	I
        //   836: bipush 13
        //   838: if_icmpne +20 -> 858
        //   841: aload_0
        //   842: aload_1
        //   843: getfield 310	android/os/Message:obj	Ljava/lang/Object;
        //   846: checkcast 97	java/lang/String
        //   849: invokespecial 601	com/mixpanel/android/mpmetrics/a$e$a:a	(Ljava/lang/String;)V
        //   852: aconst_null
        //   853: astore 9
        //   855: goto -676 -> 179
        //   858: aload_1
        //   859: getfield 306	android/os/Message:what	I
        //   862: bipush 6
        //   864: if_icmpne +42 -> 906
        //   867: aload_1
        //   868: getfield 310	android/os/Message:obj	Ljava/lang/Object;
        //   871: checkcast 603	com/mixpanel/android/mpmetrics/a$c
        //   874: invokevirtual 604	com/mixpanel/android/mpmetrics/a$c:e	()Ljava/lang/String;
        //   877: astore 9
        //   879: aload_0
        //   880: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   883: getstatic 134	com/mixpanel/android/mpmetrics/j$b:a	Lcom/mixpanel/android/mpmetrics/j$b;
        //   886: aload 9
        //   888: invokevirtual 607	com/mixpanel/android/mpmetrics/j:a	(Lcom/mixpanel/android/mpmetrics/j$b;Ljava/lang/String;)V
        //   891: aload_0
        //   892: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   895: getstatic 142	com/mixpanel/android/mpmetrics/j$b:b	Lcom/mixpanel/android/mpmetrics/j$b;
        //   898: aload 9
        //   900: invokevirtual 607	com/mixpanel/android/mpmetrics/j:a	(Lcom/mixpanel/android/mpmetrics/j$b;Ljava/lang/String;)V
        //   903: goto -724 -> 179
        //   906: aload_1
        //   907: getfield 306	android/os/Message:what	I
        //   910: iconst_5
        //   911: if_icmpne +84 -> 995
        //   914: ldc 251
        //   916: new 215	java/lang/StringBuilder
        //   919: dup
        //   920: invokespecial 216	java/lang/StringBuilder:<init>	()V
        //   923: ldc_w 609
        //   926: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   929: invokestatic 615	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   932: invokevirtual 618	java/lang/Thread:getId	()J
        //   935: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   938: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   941: invokestatic 371	com/mixpanel/android/b/f:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   944: aload_0
        //   945: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   948: invokestatic 579	com/mixpanel/android/mpmetrics/a$e:b	(Lcom/mixpanel/android/mpmetrics/a$e;)Ljava/lang/Object;
        //   951: astore 17
        //   953: aload 17
        //   955: monitorenter
        //   956: aload_0
        //   957: getfield 25	com/mixpanel/android/mpmetrics/a$e$a:b	Lcom/mixpanel/android/mpmetrics/j;
        //   960: invokevirtual 620	com/mixpanel/android/mpmetrics/j:a	()V
        //   963: aload_0
        //   964: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   967: aconst_null
        //   968: invokestatic 582	com/mixpanel/android/mpmetrics/a$e:a	(Lcom/mixpanel/android/mpmetrics/a$e;Landroid/os/Handler;)Landroid/os/Handler;
        //   971: pop
        //   972: invokestatic 588	android/os/Looper:myLooper	()Landroid/os/Looper;
        //   975: invokevirtual 591	android/os/Looper:quit	()V
        //   978: aload 17
        //   980: monitorexit
        //   981: aconst_null
        //   982: astore 9
        //   984: goto -805 -> 179
        //   987: astore 18
        //   989: aload 17
        //   991: monitorexit
        //   992: aload 18
        //   994: athrow
        //   995: ldc 251
        //   997: new 215	java/lang/StringBuilder
        //   1000: dup
        //   1001: invokespecial 216	java/lang/StringBuilder:<init>	()V
        //   1004: ldc_w 622
        //   1007: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1010: aload_1
        //   1011: invokevirtual 625	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1014: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1017: invokestatic 627	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1020: aconst_null
        //   1021: astore 9
        //   1023: goto -844 -> 179
        //   1026: astore 16
        //   1028: aload_0
        //   1029: invokestatic 554	android/os/SystemClock:elapsedRealtime	()J
        //   1032: sipush 1000
        //   1035: aload 16
        //   1037: invokevirtual 276	com/mixpanel/android/b/i$a:a	()I
        //   1040: imul
        //   1041: i2l
        //   1042: ladd
        //   1043: putfield 556	com/mixpanel/android/mpmetrics/a$e$a:e	J
        //   1046: return
        //   1047: iload_3
        //   1048: ifle -738 -> 310
        //   1051: aload_0
        //   1052: iconst_2
        //   1053: aload 9
        //   1055: invokevirtual 631	com/mixpanel/android/mpmetrics/a$e$a:hasMessages	(ILjava/lang/Object;)Z
        //   1058: ifne -748 -> 310
        //   1061: aload_0
        //   1062: getfield 20	com/mixpanel/android/mpmetrics/a$e$a:a	Lcom/mixpanel/android/mpmetrics/a$e;
        //   1065: getfield 30	com/mixpanel/android/mpmetrics/a$e:a	Lcom/mixpanel/android/mpmetrics/a;
        //   1068: new 215	java/lang/StringBuilder
        //   1071: dup
        //   1072: invokespecial 216	java/lang/StringBuilder:<init>	()V
        //   1075: ldc_w 633
        //   1078: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1081: iload_3
        //   1082: invokevirtual 542	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1085: ldc_w 635
        //   1088: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1091: aload_0
        //   1092: getfield 58	com/mixpanel/android/mpmetrics/a$e$a:d	J
        //   1095: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   1098: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1101: invokestatic 129	com/mixpanel/android/mpmetrics/a:a	(Lcom/mixpanel/android/mpmetrics/a;Ljava/lang/String;)V
        //   1104: aload_0
        //   1105: getfield 58	com/mixpanel/android/mpmetrics/a$e$a:d	J
        //   1108: lconst_0
        //   1109: lcmp
        //   1110: iflt -800 -> 310
        //   1113: invokestatic 303	android/os/Message:obtain	()Landroid/os/Message;
        //   1116: astore 10
        //   1118: aload 10
        //   1120: iconst_2
        //   1121: putfield 306	android/os/Message:what	I
        //   1124: aload 10
        //   1126: aload 9
        //   1128: putfield 310	android/os/Message:obj	Ljava/lang/Object;
        //   1131: aload 10
        //   1133: iconst_1
        //   1134: putfield 574	android/os/Message:arg1	I
        //   1137: aload_0
        //   1138: aload 10
        //   1140: aload_0
        //   1141: getfield 58	com/mixpanel/android/mpmetrics/a$e$a:d	J
        //   1144: invokevirtual 314	com/mixpanel/android/mpmetrics/a$e$a:sendMessageDelayed	(Landroid/os/Message;J)Z
        //   1147: pop
        //   1148: return
        //   1149: astore 8
        //   1151: ldc 251
        //   1153: ldc_w 637
        //   1156: aload 8
        //   1158: invokestatic 258	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   1161: goto -461 -> 700
        //   1164: astore 36
        //   1166: goto -688 -> 478
        //
        // Exception table:
        //   from	to	target	type
        //   328	390	469	org/json/JSONException
        //   597	616	628	com/mixpanel/android/b/i$a
        //   90	179	651	java/lang/RuntimeException
        //   179	196	651	java/lang/RuntimeException
        //   202	209	651	java/lang/RuntimeException
        //   214	283	651	java/lang/RuntimeException
        //   291	310	651	java/lang/RuntimeException
        //   311	328	651	java/lang/RuntimeException
        //   328	390	651	java/lang/RuntimeException
        //   394	405	651	java/lang/RuntimeException
        //   410	426	651	java/lang/RuntimeException
        //   426	447	651	java/lang/RuntimeException
        //   478	509	651	java/lang/RuntimeException
        //   519	564	651	java/lang/RuntimeException
        //   564	574	651	java/lang/RuntimeException
        //   578	589	651	java/lang/RuntimeException
        //   597	616	651	java/lang/RuntimeException
        //   630	648	651	java/lang/RuntimeException
        //   712	763	651	java/lang/RuntimeException
        //   778	800	651	java/lang/RuntimeException
        //   808	826	651	java/lang/RuntimeException
        //   832	852	651	java/lang/RuntimeException
        //   858	903	651	java/lang/RuntimeException
        //   906	956	651	java/lang/RuntimeException
        //   992	995	651	java/lang/RuntimeException
        //   995	1020	651	java/lang/RuntimeException
        //   1028	1046	651	java/lang/RuntimeException
        //   1051	1148	651	java/lang/RuntimeException
        //   675	684	704	finally
        //   684	700	704	finally
        //   700	703	704	finally
        //   706	709	704	finally
        //   1151	1161	704	finally
        //   778	800	806	com/mixpanel/android/b/i$a
        //   956	981	987	finally
        //   989	992	987	finally
        //   291	310	1026	com/mixpanel/android/b/i$a
        //   684	700	1149	java/lang/Exception
        //   394	405	1164	org/json/JSONException
        //   410	426	1164	org/json/JSONException
        //   426	447	1164	org/json/JSONException
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.a
 * JD-Core Version:    0.6.2
 */