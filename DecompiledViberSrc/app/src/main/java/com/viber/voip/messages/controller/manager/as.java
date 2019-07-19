package com.viber.voip.messages.controller.manager;

import com.viber.common.a.e;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;
import com.viber.jni.im2.CSyncDataFromMyOtherDeviceAckMsg;
import com.viber.jni.im2.CSyncDataFromMyOtherDeviceMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesReplyMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class as extends PausedControllerListener<av>
  implements av
{
  private static final e a = ViberEnv.getLogger();
  private final au b;
  private final Im2Exchanger c;

  public as(au paramau, Im2Exchanger paramIm2Exchanger)
  {
    super(new av[0]);
    this.b = paramau;
    this.c = paramIm2Exchanger;
    registerDelegate(this, com.viber.voip.av.a(av.e.d));
  }

  public void onCSyncDataFromMyOtherDeviceMsg(final CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg)
  {
    String str = new String(paramCSyncDataFromMyOtherDeviceMsg.encryptedData);
    try
    {
      a locala = a.a(new JSONObject(str).getString("Type"));
      if (locala == null)
      {
        CSyncDataFromMyOtherDeviceAckMsg localCSyncDataFromMyOtherDeviceAckMsg3;
        return;
      }
      final av localav = (av)this.b.a(locala);
      if (localav != null)
        notifyListeners(new ControllerListener.ControllerListenerAction()
        {
          public void a(av paramAnonymousav)
          {
            localav.onCSyncDataFromMyOtherDeviceMsg(paramCSyncDataFromMyOtherDeviceMsg);
          }
        });
      CSyncDataFromMyOtherDeviceAckMsg localCSyncDataFromMyOtherDeviceAckMsg4;
      return;
    }
    catch (JSONException localJSONException)
    {
      CSyncDataFromMyOtherDeviceAckMsg localCSyncDataFromMyOtherDeviceAckMsg2;
      return;
    }
    finally
    {
      CSyncDataFromMyOtherDeviceAckMsg localCSyncDataFromMyOtherDeviceAckMsg1 = new CSyncDataFromMyOtherDeviceAckMsg(paramCSyncDataFromMyOtherDeviceMsg.token);
      this.c.handleCSyncDataFromMyOtherDeviceAckMsg(localCSyncDataFromMyOtherDeviceAckMsg1);
    }
  }

  public void onCSyncDataToMyDevicesReplyMsg(CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg)
  {
    Iterator localIterator = a.b().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      av localav = (av)this.b.a(locala);
      if (localav != null)
        localav.onCSyncDataToMyDevicesReplyMsg(paramCSyncDataToMyDevicesReplyMsg);
    }
  }

  public static enum a
    implements am.b
  {
    private static final List<a> e = Collections.unmodifiableList(Arrays.asList(values()));
    private final String f;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      g = arrayOfa;
    }

    private a(String paramString)
    {
      this.f = paramString;
    }

    public static a a(String paramString)
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a().equals(paramString))
          return locala;
      }
      return null;
    }

    public static List<a> b()
    {
      return e;
    }

    public String a()
    {
      return this.f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.as
 * JD-Core Version:    0.6.2
 */