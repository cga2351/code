package com.mixpanel.android.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import com.mixpanel.android.b.g;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.MixpanelAPI.c;
import com.mixpanel.android.mpmetrics.i;
import com.mixpanel.android.mpmetrics.p.b;
import com.mixpanel.android.mpmetrics.s;
import com.mixpanel.android.mpmetrics.v;
import com.mixpanel.android.mpmetrics.v.a;
import com.mixpanel.android.mpmetrics.v.b;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(16)
public class m
  implements j, l, o.i
{
  private final i a;
  private final Context b;
  private final MixpanelAPI c;
  private final b d;
  private final d e;
  private final v f;
  private final Map<String, String> g;
  private final f h;
  private final float i;
  private final Set<com.mixpanel.android.mpmetrics.l> j;

  public m(Context paramContext, String paramString, MixpanelAPI paramMixpanelAPI, v paramv)
  {
    this.a = i.a(paramContext);
    this.b = paramContext;
    this.e = new d();
    this.f = paramv;
    this.g = paramMixpanelAPI.getDeviceInfo();
    this.i = Resources.getSystem().getDisplayMetrics().scaledDensity;
    this.j = Collections.newSetFromMap(new ConcurrentHashMap());
    HandlerThread localHandlerThread = new HandlerThread(m.class.getCanonicalName());
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.h = new f(paramContext, paramString, localHandlerThread.getLooper(), this);
    this.d = new b(paramMixpanelAPI, this.h);
    this.c = paramMixpanelAPI;
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    this.f.a(new v.a()
    {
      public void a()
      {
        Message localMessage = m.a(m.this).obtainMessage(4);
        m.a(m.this).sendMessage(localMessage);
      }
    });
  }

  public void a()
  {
    this.h.a();
    b();
  }

  public void a(o.e parame)
  {
    Message localMessage = this.h.obtainMessage();
    localMessage.what = 12;
    localMessage.obj = parame;
    this.h.sendMessage(localMessage);
  }

  public void a(String paramString)
  {
    Message localMessage = this.h.obtainMessage();
    localMessage.what = 7;
    localMessage.obj = paramString;
    this.h.sendMessage(localMessage);
  }

  public void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Message localMessage = this.h.obtainMessage(13);
      localMessage.obj = paramJSONArray;
      this.h.sendMessage(localMessage);
    }
  }

  public void b()
  {
    this.h.sendMessage(this.h.obtainMessage(0));
  }

  public void b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Message localMessage = this.h.obtainMessage(5);
      localMessage.obj = paramJSONArray;
      this.h.sendMessage(localMessage);
    }
  }

  public void c(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Message localMessage = this.h.obtainMessage(9);
      localMessage.obj = paramJSONArray;
      this.h.sendMessage(localMessage);
    }
  }

  private class a
    implements e.a
  {
    private a()
    {
    }

    public void a()
    {
      Message localMessage = m.a(m.this).obtainMessage(4);
      m.a(m.this).sendMessage(localMessage);
    }

    public void a(JSONObject paramJSONObject)
    {
      Message localMessage = m.a(m.this).obtainMessage(2);
      localMessage.obj = paramJSONObject;
      m.a(m.this).sendMessage(localMessage);
    }

    public void b()
    {
      Message localMessage = m.a(m.this).obtainMessage(8);
      m.a(m.this).sendMessage(localMessage);
    }

    public void b(JSONObject paramJSONObject)
    {
      Message localMessage = m.a(m.this).obtainMessage(3);
      localMessage.obj = paramJSONObject;
      m.a(m.this).sendMessage(localMessage);
    }

    public void c(JSONObject paramJSONObject)
    {
      Message localMessage = m.a(m.this).obtainMessage(10);
      localMessage.obj = paramJSONObject;
      m.a(m.this).sendMessage(localMessage);
    }

    public void d(JSONObject paramJSONObject)
    {
      Message localMessage = m.a(m.this).obtainMessage(6);
      localMessage.obj = paramJSONObject;
      m.a(m.this).sendMessage(localMessage);
    }

    public void e(JSONObject paramJSONObject)
    {
      Message localMessage = m.a(m.this).obtainMessage(11);
      localMessage.obj = paramJSONObject;
      m.a(m.this).sendMessage(localMessage);
    }
  }

  private class b
    implements Runnable
  {
    private volatile boolean b = true;

    public b()
    {
    }

    public void a()
    {
      this.b = false;
      m.a(m.this).post(this);
    }

    public void b()
    {
      this.b = true;
      m.a(m.this).removeCallbacks(this);
    }

    public void run()
    {
      if (!this.b)
      {
        Message localMessage = m.a(m.this).obtainMessage(1);
        m.a(m.this).sendMessage(localMessage);
      }
      m.a(m.this).postDelayed(this, 30000L);
    }
  }

  private class c
    implements Application.ActivityLifecycleCallbacks, f.a
  {
    private final f b = new f(this);
    private final m.b c = new m.b(m.this);

    public c()
    {
    }

    private void a(Activity paramActivity)
    {
      if ((b()) && (!m.d(m.this).f()))
        this.c.a();
      while (m.d(m.this).e())
        return;
      SensorManager localSensorManager = (SensorManager)paramActivity.getSystemService("sensor");
      Sensor localSensor = localSensorManager.getDefaultSensor(1);
      localSensorManager.registerListener(this.b, localSensor, 3);
    }

    private void b(Activity paramActivity)
    {
      if ((b()) && (!m.d(m.this).f()))
        this.c.b();
      while (m.d(m.this).e())
        return;
      ((SensorManager)paramActivity.getSystemService("sensor")).unregisterListener(this.b);
    }

    private boolean b()
    {
      if ((!Build.HARDWARE.toLowerCase().equals("goldfish")) && (!Build.HARDWARE.toLowerCase().equals("ranchu")));
      while (((!Build.BRAND.toLowerCase().startsWith("generic")) && (!Build.BRAND.toLowerCase().equals("android")) && (!Build.BRAND.toLowerCase().equals("google"))) || (!Build.DEVICE.toLowerCase().startsWith("generic")) || (!Build.PRODUCT.toLowerCase().contains("sdk")) || (!Build.MODEL.toLowerCase(Locale.US).contains("sdk")))
        return false;
      return true;
    }

    public void a()
    {
      m.b(m.this).track("$ab_gesture3");
      Message localMessage = m.a(m.this).obtainMessage(1);
      m.a(m.this).sendMessage(localMessage);
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void onActivityDestroyed(Activity paramActivity)
    {
    }

    public void onActivityPaused(Activity paramActivity)
    {
      m.c(m.this).b(paramActivity);
      b(paramActivity);
    }

    public void onActivityResumed(Activity paramActivity)
    {
      a(paramActivity);
      m.c(m.this).a(paramActivity);
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void onActivityStarted(Activity paramActivity)
    {
    }

    public void onActivityStopped(Activity paramActivity)
    {
    }
  }

  private static class d
  {
    public final String a;
    public final String b;
    public final JSONObject c;
    public final g<Integer, Integer> d;

    public d(String paramString1, String paramString2, JSONObject paramJSONObject, g<Integer, Integer> paramg)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramJSONObject;
      this.d = paramg;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof d;
      boolean bool2 = false;
      if (bool1)
      {
        int i = paramObject.hashCode();
        int j = hashCode();
        bool2 = false;
        if (i == j)
          bool2 = true;
      }
      return bool2;
    }

    public int hashCode()
    {
      return this.a.hashCode();
    }
  }

  private static class e
  {
    public final String a;
    public final JSONObject b;
    public final g<Integer, Integer> c;

    public e(String paramString, JSONObject paramJSONObject, g<Integer, Integer> paramg)
    {
      this.a = paramString;
      this.b = paramJSONObject;
      this.c = paramg;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof e;
      boolean bool2 = false;
      if (bool1)
      {
        int i = paramObject.hashCode();
        int j = hashCode();
        bool2 = false;
        if (i == j)
          bool2 = true;
      }
      return bool2;
    }

    public int hashCode()
    {
      return this.a.hashCode();
    }
  }

  private class f extends Handler
  {
    private e b;
    private n c;
    private final String d;
    private final Lock e;
    private final c f;
    private final com.mixpanel.android.b.d g;
    private final Map<String, g<String, JSONObject>> h;
    private final Map<String, g<String, Object>> i;
    private final List<String> j;
    private final Map<String, g<String, JSONObject>> k;
    private final Set<m.d> l;
    private final Set<m.e> m;
    private final Set<g<Integer, Integer>> n;
    private final Set<g<String, JSONObject>> o;
    private final Set<g<String, JSONObject>> p;
    private final Set<g<Integer, Integer>> q;

    public f(Context paramString, String paramLooper, Looper parami, o.i arg5)
    {
      super();
      this.d = paramLooper;
      this.c = null;
      String str = m.d(m.this).B();
      if (str == null)
        str = paramString.getPackageName();
      p.b localb = new p.b(str, paramString);
      this.g = new com.mixpanel.android.b.d(paramString, "ViewCrawler");
      o.i locali;
      this.f = new c(paramString, localb, this.g, locali);
      this.p = new HashSet();
      this.h = new HashMap();
      this.i = new HashMap();
      this.j = new ArrayList();
      this.k = new HashMap();
      this.l = new HashSet();
      this.m = new HashSet();
      this.n = new HashSet();
      this.o = new HashSet();
      this.q = new HashSet();
      this.e = new ReentrantLock();
      this.e.lock();
    }

    private void a(o.e parame)
    {
      if ((this.b == null) || (!this.b.a()) || (!this.b.b()))
        return;
      JsonWriter localJsonWriter = new JsonWriter(new OutputStreamWriter(this.b.c()));
      try
      {
        localJsonWriter.beginObject();
        localJsonWriter.name("type").value("layout_error");
        localJsonWriter.name("exception_type").value(parame.a());
        localJsonWriter.name("cid").value(parame.b());
        localJsonWriter.endObject();
        try
        {
          localJsonWriter.close();
          return;
        }
        catch (IOException localIOException4)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException4);
          return;
        }
      }
      catch (IOException localIOException2)
      {
        localIOException2 = localIOException2;
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", localIOException2);
        try
        {
          localJsonWriter.close();
          return;
        }
        catch (IOException localIOException3)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException3);
          return;
        }
      }
      finally
      {
      }
      try
      {
        localJsonWriter.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        while (true)
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException1);
      }
    }

    private void a(String paramString)
    {
      if (paramString != null)
        try
        {
          JSONArray localJSONArray = new JSONArray(paramString);
          this.o.clear();
          for (int i1 = 0; i1 < localJSONArray.length(); i1++)
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
            String str = com.mixpanel.android.b.e.a(localJSONObject, "target_activity");
            this.o.add(new g(str, localJSONObject));
          }
        }
        catch (JSONException localJSONException)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.ViewCrawler", "JSON error when loading event bindings, clearing persistent memory", localJSONException);
          SharedPreferences.Editor localEditor = g().edit();
          localEditor.remove("mixpanel.viewcrawler.bindings");
          localEditor.apply();
        }
    }

    private void a(String paramString, boolean paramBoolean)
    {
      if (paramString != null)
        try
        {
          JSONArray localJSONArray1 = new JSONArray(paramString);
          int i1 = localJSONArray1.length();
          for (int i2 = 0; i2 < i1; i2++)
          {
            JSONObject localJSONObject1 = localJSONArray1.getJSONObject(i2);
            int i3 = localJSONObject1.getInt("id");
            g localg = new g(Integer.valueOf(localJSONObject1.getInt("experiment_id")), Integer.valueOf(i3));
            JSONArray localJSONArray2 = localJSONObject1.getJSONArray("actions");
            int i4 = localJSONArray2.length();
            for (int i5 = 0; i5 < i4; i5++)
            {
              JSONObject localJSONObject2 = localJSONArray2.getJSONObject(i5);
              String str = com.mixpanel.android.b.e.a(localJSONObject2, "target_activity");
              m.d locald = new m.d(localJSONObject2.getString("name"), str, localJSONObject2, localg);
              this.l.add(locald);
            }
            JSONArray localJSONArray3 = localJSONObject1.getJSONArray("tweaks");
            int i6 = localJSONArray3.length();
            for (int i7 = 0; i7 < i6; i7++)
            {
              JSONObject localJSONObject3 = localJSONArray3.getJSONObject(i7);
              m.e locale = new m.e(localJSONObject3.getString("name"), localJSONObject3, localg);
              this.m.add(locale);
            }
            if (!paramBoolean)
              this.q.add(localg);
            if ((i6 == 0) && (i4 == 0))
              this.n.add(localg);
          }
        }
        catch (JSONException localJSONException)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", localJSONException);
          SharedPreferences.Editor localEditor = g().edit();
          localEditor.remove("mixpanel.viewcrawler.changes");
          localEditor.apply();
        }
    }

    private void a(Set<g<Integer, Integer>> paramSet)
    {
      if ((paramSet != null) && (paramSet.size() > 0))
      {
        final JSONObject localJSONObject1 = new JSONObject();
        try
        {
          Iterator localIterator = paramSet.iterator();
          while (localIterator.hasNext())
          {
            g localg = (g)localIterator.next();
            int i1 = ((Integer)localg.first).intValue();
            int i2 = ((Integer)localg.second).intValue();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("$experiment_id", i1);
            localJSONObject2.put("$variant_id", i2);
            localJSONObject1.put(Integer.toString(i1), i2);
            m.b(m.this).getPeople().a("$experiments", localJSONObject1);
            m.b(m.this).updateSuperProperties(new s()
            {
              public JSONObject a(JSONObject paramAnonymousJSONObject)
              {
                try
                {
                  paramAnonymousJSONObject.put("$experiments", localJSONObject1);
                  return paramAnonymousJSONObject;
                }
                catch (JSONException localJSONException)
                {
                  com.mixpanel.android.b.f.f("MixpanelAPI.ViewCrawler", "Can't write $experiments super property", localJSONException);
                }
                return paramAnonymousJSONObject;
              }
            });
            m.b(m.this).track("$experiment_started", localJSONObject2);
          }
        }
        catch (JSONException localJSONException)
        {
          com.mixpanel.android.b.f.f("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", localJSONException);
        }
      }
    }

    private void a(JSONArray paramJSONArray)
    {
      SharedPreferences.Editor localEditor = g().edit();
      localEditor.putString("mixpanel.viewcrawler.changes", paramJSONArray.toString());
      localEditor.apply();
    }

    private void a(JSONObject paramJSONObject)
    {
      long l1 = System.currentTimeMillis();
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("payload");
        if (localJSONObject.has("config"))
        {
          this.c = this.f.b(localJSONObject);
          com.mixpanel.android.b.f.a("MixpanelAPI.ViewCrawler", "Initializing snapshot with configuration");
        }
        if (this.c == null)
        {
          b("No snapshot configuration (or a malformed snapshot configuration) was sent.");
          com.mixpanel.android.b.f.d("MixpanelAPI.ViewCrawler", "Mixpanel editor is misconfigured, sent a snapshot request without a valid configuration.");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Payload with snapshot config required with snapshot request", localJSONException);
        b("Payload with snapshot config required with snapshot request");
        return;
      }
      catch (c.a locala)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Editor sent malformed message with snapshot request", locala);
        b(locala.getMessage());
        return;
      }
      BufferedOutputStream localBufferedOutputStream = this.b.c();
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localBufferedOutputStream);
      try
      {
        localOutputStreamWriter.write("{");
        localOutputStreamWriter.write("\"type\": \"snapshot_response\",");
        localOutputStreamWriter.write("\"payload\": {");
        localOutputStreamWriter.write("\"activities\":");
        localOutputStreamWriter.flush();
        this.c.a(m.c(m.this), localBufferedOutputStream);
        long l2 = System.currentTimeMillis() - l1;
        localOutputStreamWriter.write(",\"snapshot_time_millis\": ");
        localOutputStreamWriter.write(Long.toString(l2));
        localOutputStreamWriter.write("}");
        localOutputStreamWriter.write("}");
        try
        {
          localOutputStreamWriter.close();
          return;
        }
        catch (IOException localIOException4)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException4);
          return;
        }
      }
      catch (IOException localIOException2)
      {
        localIOException2 = localIOException2;
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't write snapshot request to server", localIOException2);
        try
        {
          localOutputStreamWriter.close();
          return;
        }
        catch (IOException localIOException3)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException3);
          return;
        }
      }
      finally
      {
      }
      try
      {
        localOutputStreamWriter.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        while (true)
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException1);
      }
    }

    private void b()
    {
      SharedPreferences localSharedPreferences = g();
      String str1 = localSharedPreferences.getString("mixpanel.viewcrawler.changes", null);
      String str2 = localSharedPreferences.getString("mixpanel.viewcrawler.bindings", null);
      this.l.clear();
      this.m.clear();
      this.q.clear();
      a(str1, false);
      this.o.clear();
      a(str2);
      f();
    }

    private void b(String paramString)
    {
      if ((this.b == null) || (!this.b.a()) || (!this.b.b()))
        return;
      JSONObject localJSONObject = new JSONObject();
      OutputStreamWriter localOutputStreamWriter;
      try
      {
        localJSONObject.put("error_message", paramString);
        localOutputStreamWriter = new OutputStreamWriter(this.b.c());
      }
      catch (JSONException localJSONException)
      {
        try
        {
          while (true)
          {
            localOutputStreamWriter.write("{\"type\": \"error\", ");
            localOutputStreamWriter.write("\"payload\": ");
            localOutputStreamWriter.write(localJSONObject.toString());
            localOutputStreamWriter.write("}");
            try
            {
              localOutputStreamWriter.close();
              return;
            }
            catch (IOException localIOException4)
            {
              com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", localIOException4);
              return;
            }
            localJSONException = localJSONException;
            com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Apparently impossible JSONException", localJSONException);
          }
        }
        catch (IOException localIOException2)
        {
          localIOException2 = localIOException2;
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't write error message to editor", localIOException2);
          try
          {
            localOutputStreamWriter.close();
            return;
          }
          catch (IOException localIOException3)
          {
            com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", localIOException3);
            return;
          }
        }
        finally
        {
        }
      }
      try
      {
        localOutputStreamWriter.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        while (true)
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", localIOException1);
      }
    }

    private void b(JSONArray paramJSONArray)
    {
      a(paramJSONArray);
      a(paramJSONArray.toString(), true);
      f();
    }

    private void b(JSONObject paramJSONObject)
    {
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONObject("payload").getJSONArray("actions");
        for (int i1 = 0; i1 < localJSONArray.length(); i1++)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          String str1 = com.mixpanel.android.b.e.a(localJSONObject, "target_activity");
          String str2 = localJSONObject.getString("name");
          this.h.put(str2, new g(str1, localJSONObject));
        }
        f();
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad change request received", localJSONException);
      }
    }

    private void c()
    {
      com.mixpanel.android.b.f.a("MixpanelAPI.ViewCrawler", "connecting to editor");
      if ((this.b != null) && (this.b.a()))
      {
        com.mixpanel.android.b.f.a("MixpanelAPI.ViewCrawler", "There is already a valid connection to an events editor.");
        return;
      }
      SSLSocketFactory localSSLSocketFactory = m.d(m.this).C();
      if (localSSLSocketFactory == null)
      {
        com.mixpanel.android.b.f.a("MixpanelAPI.ViewCrawler", "SSL is not available on this device, no connection will be attempted to the events editor.");
        return;
      }
      String str = i.a(m.e(m.this)).r() + this.d;
      try
      {
        Socket localSocket = localSSLSocketFactory.createSocket();
        this.b = new e(new URI(str), new m.a(m.this, null), localSocket);
        return;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Error parsing URI " + str + " for editor websocket", localURISyntaxException);
        return;
      }
      catch (e.c localc)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Error connecting to URI " + str, localc);
        return;
      }
      catch (IOException localIOException)
      {
        com.mixpanel.android.b.f.c("MixpanelAPI.ViewCrawler", "Can't create SSL Socket to connect to editor service", localIOException);
      }
    }

    private void c(String paramString)
    {
      if ((this.b == null) || (!this.b.a()) || (!this.b.b()))
        return;
      JsonWriter localJsonWriter = new JsonWriter(new OutputStreamWriter(this.b.c()));
      try
      {
        localJsonWriter.beginObject();
        localJsonWriter.name("type").value("track_message");
        localJsonWriter.name("payload");
        localJsonWriter.beginObject();
        localJsonWriter.name("event_name").value(paramString);
        localJsonWriter.endObject();
        localJsonWriter.endObject();
        localJsonWriter.flush();
        try
        {
          localJsonWriter.close();
          return;
        }
        catch (IOException localIOException4)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException4);
          return;
        }
      }
      catch (IOException localIOException2)
      {
        localIOException2 = localIOException2;
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", localIOException2);
        try
        {
          localJsonWriter.close();
          return;
        }
        catch (IOException localIOException3)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException3);
          return;
        }
      }
      finally
      {
      }
      try
      {
        localJsonWriter.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        while (true)
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close writer.", localIOException1);
      }
    }

    private void c(JSONArray paramJSONArray)
    {
      SharedPreferences.Editor localEditor = g().edit();
      localEditor.putString("mixpanel.viewcrawler.bindings", paramJSONArray.toString());
      localEditor.apply();
      a(paramJSONArray.toString());
      f();
    }

    private void c(JSONObject paramJSONObject)
    {
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONObject("payload").getJSONArray("actions");
        for (int i1 = 0; i1 < localJSONArray.length(); i1++)
        {
          String str = localJSONArray.getString(i1);
          this.h.remove(str);
        }
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad clear request received", localJSONException);
        f();
      }
    }

    private void d()
    {
      if ((this.b == null) || (!this.b.a()) || (!this.b.b()))
        return;
      JsonWriter localJsonWriter = new JsonWriter(new OutputStreamWriter(this.b.c()));
      while (true)
      {
        v.b localb;
        try
        {
          localJsonWriter.beginObject();
          localJsonWriter.name("type").value("device_info_response");
          localJsonWriter.name("payload").beginObject();
          localJsonWriter.name("device_type").value("Android");
          localJsonWriter.name("device_name").value(Build.BRAND + "/" + Build.MODEL);
          localJsonWriter.name("scaled_density").value(m.f(m.this));
          Iterator localIterator1 = m.g(m.this).entrySet().iterator();
          if (localIterator1.hasNext())
          {
            Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
            localJsonWriter.name((String)localEntry2.getKey()).value((String)localEntry2.getValue());
            continue;
          }
        }
        catch (IOException localIOException2)
        {
          localIOException2 = localIOException2;
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't write device_info to server", localIOException2);
          try
          {
            localJsonWriter.close();
            return;
          }
          catch (IOException localIOException3)
          {
            com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", localIOException3);
            return;
          }
          Map localMap = m.h(m.this).a();
          localJsonWriter.name("tweaks").beginArray();
          Iterator localIterator2 = localMap.entrySet().iterator();
          if (localIterator2.hasNext())
          {
            Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
            localb = (v.b)localEntry1.getValue();
            String str = (String)localEntry1.getKey();
            localJsonWriter.beginObject();
            localJsonWriter.name("name").value(str);
            localJsonWriter.name("minimum").value(localb.d());
            localJsonWriter.name("maximum").value(localb.e());
            switch (localb.a)
            {
            default:
              com.mixpanel.android.b.f.f("MixpanelAPI.ViewCrawler", "Unrecognized Tweak Type " + localb.a + " encountered.");
              localJsonWriter.endObject();
              continue;
            case 1:
            case 2:
            case 3:
            case 4:
            }
          }
        }
        finally
        {
        }
        try
        {
          localJsonWriter.close();
          throw localObject;
          localJsonWriter.name("type").value("boolean");
          localJsonWriter.name("value").value(localb.c().booleanValue());
          localJsonWriter.name("default").value(((Boolean)localb.f()).booleanValue());
          continue;
          localJsonWriter.name("type").value("number");
          localJsonWriter.name("encoding").value("d");
          localJsonWriter.name("value").value(localb.b().doubleValue());
          localJsonWriter.name("default").value(((Number)localb.f()).doubleValue());
          continue;
          localJsonWriter.name("type").value("number");
          localJsonWriter.name("encoding").value("l");
          localJsonWriter.name("value").value(localb.b().longValue());
          localJsonWriter.name("default").value(((Number)localb.f()).longValue());
          continue;
          localJsonWriter.name("type").value("string");
          localJsonWriter.name("value").value(localb.a());
          localJsonWriter.name("default").value((String)localb.f());
          continue;
          localJsonWriter.endArray();
          localJsonWriter.endObject();
          localJsonWriter.endObject();
          try
          {
            localJsonWriter.close();
            return;
          }
          catch (IOException localIOException4)
          {
            com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", localIOException4);
            return;
          }
        }
        catch (IOException localIOException1)
        {
          while (true)
            com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", localIOException1);
        }
      }
    }

    private void d(JSONObject paramJSONObject)
    {
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONObject("payload").getJSONArray("tweaks");
        int i1 = localJSONArray.length();
        for (int i2 = 0; i2 < i1; i2++)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i2);
          g localg = this.f.c(localJSONObject);
          this.i.put(localg.first, localg);
        }
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad tweaks received", localJSONException);
        f();
        return;
      }
      catch (c.a locala)
      {
        while (true)
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad tweaks received", locala);
      }
    }

    private void e()
    {
      this.h.clear();
      this.k.clear();
      this.i.clear();
      this.o.addAll(this.p);
      this.p.clear();
      this.c = null;
      com.mixpanel.android.b.f.a("MixpanelAPI.ViewCrawler", "Editor closed- freeing snapshot");
      f();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.g.c(str);
      }
    }

    private void e(JSONObject paramJSONObject)
    {
      JSONArray localJSONArray;
      int i1;
      try
      {
        localJSONArray = paramJSONObject.getJSONObject("payload").getJSONArray("events");
        i1 = localJSONArray.length();
        this.k.clear();
        if ((this.o.isEmpty()) || (!this.p.isEmpty()))
          break label162;
        this.p.addAll(this.o);
        Iterator localIterator = this.o.iterator();
        while (localIterator.hasNext())
        {
          g localg = (g)localIterator.next();
          try
          {
            this.k.put(((JSONObject)localg.second).get("path").toString(), localg);
          }
          catch (JSONException localJSONException3)
          {
            localJSONException3.printStackTrace();
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad event bindings received", localJSONException1);
        return;
      }
      this.o.clear();
      label162: int i2 = 0;
      while (true)
        if (i2 < i1)
          try
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i2);
            String str = com.mixpanel.android.b.e.a(localJSONObject, "target_activity");
            this.k.put(localJSONObject.get("path").toString(), new g(str, localJSONObject));
            i2++;
          }
          catch (JSONException localJSONException2)
          {
            while (true)
              com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad event binding received from editor in " + localJSONArray.toString(), localJSONException2);
          }
      f();
    }

    private void f()
    {
      ArrayList localArrayList = new ArrayList();
      HashSet localHashSet1 = new HashSet();
      HashSet localHashSet2 = new HashSet();
      Iterator localIterator1 = this.l.iterator();
      while (localIterator1.hasNext())
      {
        m.d locald = (m.d)localIterator1.next();
        try
        {
          c.c localc2 = this.f.a(locald.c);
          localArrayList.add(new g(locald.b, localc2.a));
          if (!this.q.contains(locald.d))
            localHashSet1.add(locald.d);
        }
        catch (c.b localb4)
        {
          com.mixpanel.android.b.f.a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", localb4);
        }
        catch (c.d locald4)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.ViewCrawler", locald4.getMessage());
        }
        catch (c.a locala5)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad persistent change request cannot be applied.", locala5);
        }
      }
      Iterator localIterator2 = this.m.iterator();
      while (localIterator2.hasNext())
      {
        m.e locale = (m.e)localIterator2.next();
        g localg7;
        while (true)
        {
          try
          {
            localg7 = this.f.c(locale.b);
            if (this.q.contains(locale.c))
              break label331;
            localHashSet1.add(locale.c);
            localHashSet2.add(localg7.first);
            if (m.h(m.this).a().containsKey(localg7.first))
              break label372;
            v.b localb3 = v.b.a(locale.b);
            m.h(m.this).a((String)localg7.first, localb3);
          }
          catch (c.a locala4)
          {
            com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", locala4);
          }
          break;
          label331: if (m.h(m.this).b((String)localg7.first, localg7.second))
            localHashSet2.add(localg7.first);
        }
        label372: m.h(m.this).a((String)localg7.first, localg7.second);
      }
      if (this.m.size() == 0)
      {
        Iterator localIterator9 = m.h(m.this).b().entrySet().iterator();
        while (localIterator9.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator9.next();
          v.b localb2 = (v.b)localEntry.getValue();
          String str = (String)localEntry.getKey();
          if (m.h(m.this).b(str, localb2.g()))
          {
            m.h(m.this).a(str, localb2.g());
            localHashSet2.add(str);
          }
        }
      }
      Iterator localIterator3 = this.h.values().iterator();
      while (localIterator3.hasNext())
      {
        g localg6 = (g)localIterator3.next();
        try
        {
          c.c localc1 = this.f.a((JSONObject)localg6.second);
          localArrayList.add(new g(localg6.first, localc1.a));
          this.j.addAll(localc1.b);
        }
        catch (c.b localb1)
        {
          com.mixpanel.android.b.f.a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", localb1);
        }
        catch (c.d locald3)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.ViewCrawler", locald3.getMessage());
        }
        catch (c.a locala3)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad editor change request cannot be applied.", locala3);
        }
      }
      Iterator localIterator4 = this.i.values().iterator();
      while (localIterator4.hasNext())
      {
        g localg5 = (g)localIterator4.next();
        if (m.h(m.this).b((String)localg5.first, localg5.second))
          localHashSet2.add(localg5.first);
        m.h(m.this).a((String)localg5.first, localg5.second);
      }
      if ((this.k.size() == 0) && (this.p.size() == 0))
      {
        Iterator localIterator8 = this.o.iterator();
        while (localIterator8.hasNext())
        {
          g localg4 = (g)localIterator8.next();
          try
          {
            o localo2 = this.f.a((JSONObject)localg4.second, m.i(m.this));
            localArrayList.add(new g(localg4.first, localo2));
          }
          catch (c.d locald2)
          {
            com.mixpanel.android.b.f.c("MixpanelAPI.ViewCrawler", locald2.getMessage());
          }
          catch (c.a locala2)
          {
            com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad persistent event binding cannot be applied.", locala2);
          }
        }
      }
      Iterator localIterator5 = this.k.values().iterator();
      while (localIterator5.hasNext())
      {
        g localg3 = (g)localIterator5.next();
        try
        {
          o localo1 = this.f.a((JSONObject)localg3.second, m.i(m.this));
          localArrayList.add(new g(localg3.first, localo1));
        }
        catch (c.d locald1)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.ViewCrawler", locald1.getMessage());
        }
        catch (c.a locala1)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.ViewCrawler", "Bad editor event binding cannot be applied.", locala1);
        }
      }
      HashMap localHashMap = new HashMap();
      int i1 = localArrayList.size();
      int i2 = 0;
      if (i2 < i1)
      {
        g localg2 = (g)localArrayList.get(i2);
        Object localObject;
        if (localHashMap.containsKey(localg2.first))
          localObject = (List)localHashMap.get(localg2.first);
        while (true)
        {
          ((List)localObject).add(localg2.second);
          i2++;
          break;
          localObject = new ArrayList();
          localHashMap.put(localg2.first, localObject);
        }
      }
      m.c(m.this).a(localHashMap);
      Iterator localIterator6 = this.n.iterator();
      while (localIterator6.hasNext())
      {
        g localg1 = (g)localIterator6.next();
        if (!this.q.contains(localg1))
          localHashSet1.add(localg1);
      }
      this.q.addAll(localHashSet1);
      a(localHashSet1);
      this.n.clear();
      if (localHashSet2.size() > 0)
      {
        Iterator localIterator7 = m.j(m.this).iterator();
        while (localIterator7.hasNext())
          ((com.mixpanel.android.mpmetrics.l)localIterator7.next()).a(localHashSet2);
      }
    }

    private SharedPreferences g()
    {
      String str = "mixpanel.viewcrawler.changes" + this.d;
      return m.e(m.this).getSharedPreferences(str, 0);
    }

    public void a()
    {
      this.e.unlock();
    }

    public void handleMessage(Message paramMessage)
    {
      this.e.lock();
      while (true)
      {
        try
        {
          int i1 = paramMessage.what;
          switch (i1)
          {
          default:
            return;
          case 0:
            b();
            continue;
          case 1:
          case 4:
          case 2:
          case 7:
          case 12:
          case 9:
          case 3:
          case 5:
          case 6:
          case 10:
          case 11:
          case 8:
          case 13:
          }
        }
        finally
        {
          this.e.unlock();
        }
        c();
        continue;
        d();
        continue;
        a((JSONObject)paramMessage.obj);
        continue;
        c((String)paramMessage.obj);
        continue;
        a((o.e)paramMessage.obj);
        continue;
        b((JSONArray)paramMessage.obj);
        continue;
        b((JSONObject)paramMessage.obj);
        continue;
        c((JSONArray)paramMessage.obj);
        continue;
        e((JSONObject)paramMessage.obj);
        continue;
        c((JSONObject)paramMessage.obj);
        continue;
        d((JSONObject)paramMessage.obj);
        continue;
        e();
        continue;
        a((JSONArray)paramMessage.obj);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.m
 * JD-Core Version:    0.6.2
 */