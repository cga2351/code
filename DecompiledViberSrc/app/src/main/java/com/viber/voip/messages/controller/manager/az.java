package com.viber.voip.messages.controller.manager;

import android.os.Handler;
import com.google.d.a.c;
import com.google.d.f;
import com.google.d.p;
import com.viber.dexshared.Logger;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSyncDataFromMyOtherDeviceMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesReplyMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.d.b;
import com.viber.voip.messages.a.k;
import com.viber.voip.messages.controller.ai;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

public class az
  implements av
{
  private static final Logger a = ViberEnv.getLogger();
  private volatile boolean b = false;
  private final dagger.a<f> c;
  private final Im2Exchanger d;
  private final PhoneController e;
  private final ConnectionController f;
  private final Handler g;
  private final ab h;
  private final com.viber.common.b.d i;
  private final com.viber.common.b.d j;
  private final EventBus k;
  private final ai l;
  private final com.viber.voip.model.a.d m;
  private boolean n;
  private final ConnectionDelegate o = new ConnectionDelegate()
  {
    public void onConnect()
    {
      az.a(az.this);
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };

  public az(dagger.a<f> parama, Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, ConnectionController paramConnectionController, Handler paramHandler, ab paramab, com.viber.common.b.d paramd1, com.viber.common.b.d paramd2, EventBus paramEventBus, ai paramai, com.viber.voip.model.a.d paramd, boolean paramBoolean)
  {
    this.c = parama;
    this.d = paramIm2Exchanger;
    this.e = paramPhoneController;
    this.f = paramConnectionController;
    this.g = paramHandler;
    this.i = paramd1;
    this.j = paramd2;
    this.h = paramab;
    this.n = paramBoolean;
    this.k = paramEventBus;
    this.l = paramai;
    this.m = paramd;
  }

  private void a()
  {
    c localc = new c(this.h.G());
    int i1 = this.e.generateSequence();
    this.i.a(i1);
    if (!this.f.isConnected())
      return;
    CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(((f)this.c.get()).b(localc).getBytes(), 0, 2L, i1, 0L);
    this.d.handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
  }

  private void a(String paramString)
  {
    b localb = (b)((f)this.c.get()).a(paramString, b.class);
    this.l.a(b.a(localb), System.currentTimeMillis());
  }

  private void a(Map<String, a> paramMap)
  {
    int i1 = this.e.generateSequence();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.m.b("not_sync_community_state", (String)localEntry.getKey(), i1);
    }
    a(paramMap, i1);
  }

  private void a(Map<String, a> paramMap, int paramInt)
  {
    b localb = new b(paramMap);
    if (!this.f.isConnected())
      return;
    CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(((f)this.c.get()).b(localb).getBytes(), 0, 2L, paramInt, 0L);
    this.d.handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
  }

  private void b()
  {
    int i1 = this.e.generateSequence();
    this.j.a(i1);
    if (!this.f.isConnected())
      return;
    CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(((f)this.c.get()).b(new d()).getBytes(), 0, 1L, i1, 0L);
    this.d.handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
  }

  private void b(String paramString)
  {
    c localc = (c)((f)this.c.get()).a(paramString, c.class);
    this.l.a(c.a(localc), System.currentTimeMillis());
  }

  private void c()
  {
    if ((!this.n) && (this.j.d() > 0))
      b();
    if ((this.n) && (this.i.d() > 0))
      a();
    Set localSet = this.m.b("not_sync_community_state");
    if (localSet.size() > 0)
    {
      HashSet localHashSet = new HashSet(localSet.size());
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        localHashSet.add(Long.valueOf(((com.viber.voip.model.a.d.a)localIterator.next()).b));
      this.m.c("not_sync_community_state");
      a(this.h.l(localHashSet));
    }
  }

  public void a(ConnectionListener paramConnectionListener)
  {
    if (this.b)
      return;
    this.b = true;
    this.k.register(this);
    paramConnectionListener.registerDelegate(this.o, this.g);
  }

  public void onCSyncDataFromMyOtherDeviceMsg(CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg)
  {
    String str1 = new String(paramCSyncDataFromMyOtherDeviceMsg.encryptedData);
    try
    {
      String str2 = new JSONObject(str1).getString("Action");
      if ((this.n) && ("Request".equalsIgnoreCase(str2)))
      {
        a();
        return;
      }
      if ("Change".equalsIgnoreCase(str2))
      {
        a(str1);
        return;
      }
      if (("Reply".equalsIgnoreCase(str2)) && (!this.n))
      {
        b(str1);
        return;
      }
    }
    catch (p localp)
    {
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public void onCSyncDataToMyDevicesReplyMsg(CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg)
  {
    if (paramCSyncDataToMyDevicesReplyMsg.status == 0)
    {
      if (paramCSyncDataToMyDevicesReplyMsg.seq == this.i.d())
        this.i.e();
      while (true)
      {
        Iterator localIterator = this.m.b("not_sync_community_state").iterator();
        while (localIterator.hasNext())
        {
          com.viber.voip.model.a.d.a locala = (com.viber.voip.model.a.d.a)localIterator.next();
          if ((locala.c != null) && (locala.c.equals(Integer.valueOf(paramCSyncDataToMyDevicesReplyMsg.seq))))
          {
            com.viber.voip.model.a.d locald = this.m;
            String[] arrayOfString = new String[1];
            arrayOfString[0] = String.valueOf(locala.b());
            locald.a("not_sync_community_state", arrayOfString);
          }
        }
        if (paramCSyncDataToMyDevicesReplyMsg.seq == this.j.d())
          this.j.e();
      }
    }
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void sendChangeMessage(d.b paramb)
  {
    sendChangeMessage(Collections.singleton(paramb));
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void sendChangeMessage(Set<d.b> paramSet)
  {
    int i1 = this.e.generateSequence();
    HashMap localHashMap = new HashMap(paramSet.size());
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      this.m.b("not_sync_community_state", String.valueOf(localb.a), i1);
      localHashMap.put(String.valueOf(localb.a), new a(localb.b, localb.c));
    }
    a(localHashMap, i1);
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void sendRequestMessage(com.viber.voip.messages.a.d.a parama)
  {
    b();
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void sendRequestMessage(k paramk)
  {
    b();
  }

  public static class a
  {

    @c(a="Mute")
    private Boolean a;

    @c(a="Snooze")
    private Boolean b;

    public a()
    {
    }

    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = Boolean.valueOf(paramBoolean1);
      this.b = Boolean.valueOf(paramBoolean2);
    }

    public Boolean a()
    {
      return this.a;
    }

    public Boolean b()
    {
      return this.b;
    }
  }

  public static class b
  {

    @com.google.d.a.a(b=false)
    @c(a="Type")
    private final String a = as.a.d.a();

    @com.google.d.a.a(b=false)
    @c(a="Action")
    private final String b = "Change";

    @c(a="Groups")
    private Map<String, az.a> c;

    public b()
    {
    }

    public b(Map<String, az.a> paramMap)
    {
      this.c = paramMap;
    }

    public String toString()
    {
      return "SyncGroupSettingsChangeMessage{mType='" + this.a + '\'' + ", mAction='" + "Change" + '\'' + ", mChangedGroupItems=" + this.c + '}';
    }
  }

  public static class c
  {

    @com.google.d.a.a(b=false)
    @c(a="Type")
    private final String a = as.a.d.a();

    @com.google.d.a.a(b=false)
    @c(a="Action")
    private final String b = "Reply";

    @c(a="Groups")
    private Map<String, az.a> c;

    public c()
    {
    }

    public c(Map<String, az.a> paramMap)
    {
      this.c = paramMap;
    }

    public String toString()
    {
      return "SyncGroupSettingsReplyMessage{mType='" + this.a + '\'' + ", mAction='" + "Reply" + '\'' + ", mGroupItems=" + this.c + '}';
    }
  }

  public static class d
  {

    @com.google.d.a.a(b=false)
    @c(a="Type")
    private final String a = as.a.d.a();

    @com.google.d.a.a(b=false)
    @c(a="Action")
    private final String b = "Request";

    public String toString()
    {
      return "SyncGroupSettingsRequestMessage{mType='" + this.a + '\'' + ", mAction='" + "Request" + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.az
 * JD-Core Version:    0.6.2
 */