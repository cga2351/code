package com.viber.voip.messages.controller;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.jni.im2.CSendGroupUserIsTypingMsg;
import com.viber.jni.im2.CSendGroupUserIsTypingMsg.Receiver;
import com.viber.jni.im2.CSendUserIsTypingMsg;
import com.viber.jni.im2.CSendUserIsTypingMsg.Receiver;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.d.c;
import com.viber.voip.messages.a.d.e;
import com.viber.voip.messages.conversation.ui.ck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class cl
  implements CSendGroupUserIsTypingMsg.Receiver, CSendUserIsTypingMsg.Receiver
{
  private static final Logger a = ViberEnv.getLogger();
  private final EventBus b;
  private final Handler c;
  private Map<String, com.viber.voip.messages.conversation.ui.cl> d = new HashMap();
  private LongSparseArray<Map<String, ck>> e = new LongSparseArray();
  private Map<String, Object> f = new HashMap();

  public cl(EventBus paramEventBus, Handler paramHandler)
  {
    this.b = paramEventBus;
    this.c = paramHandler;
  }

  private Object a(String paramString)
  {
    Object localObject = this.f.get(paramString);
    if (localObject == null)
    {
      localObject = new Object();
      this.f.put(paramString, localObject);
    }
    return localObject;
  }

  private Map<String, ck> a(long paramLong)
  {
    Object localObject = (Map)this.e.get(paramLong);
    if (localObject == null)
    {
      localObject = new HashMap();
      this.e.put(paramLong, localObject);
    }
    return localObject;
  }

  private void a(ck paramck, int paramInt, boolean paramBoolean)
  {
    d.e locale = new d.e(paramck, paramInt, paramBoolean);
    this.b.post(locale);
  }

  private void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(a(paramLong).values());
    if (!localArrayList.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      d.c localc = new d.c(paramLong, localArrayList, bool);
      this.b.post(localc);
      return;
    }
  }

  public LongSparseArray<Map<String, ck>> a()
  {
    return this.e.clone();
  }

  public Map<String, com.viber.voip.messages.conversation.ui.cl> b()
  {
    return new HashMap(this.d);
  }

  public void onCSendGroupUserIsTypingMsg(CSendGroupUserIsTypingMsg paramCSendGroupUserIsTypingMsg)
  {
    ck localck = new ck(paramCSendGroupUserIsTypingMsg.fromNumber, paramCSendGroupUserIsTypingMsg.deviceID.shortValue(), paramCSendGroupUserIsTypingMsg.isSecondaryDevice());
    String str = paramCSendGroupUserIsTypingMsg.fromNumber + paramCSendGroupUserIsTypingMsg.groupID;
    Object localObject = a(str);
    this.c.removeCallbacksAndMessages(localObject);
    if (paramCSendGroupUserIsTypingMsg.active)
    {
      a(paramCSendGroupUserIsTypingMsg.groupID).put(paramCSendGroupUserIsTypingMsg.fromNumber, localck);
      b(paramCSendGroupUserIsTypingMsg.groupID);
      this.c.postAtTime(new cn(this, str, paramCSendGroupUserIsTypingMsg), localObject, 6000L + SystemClock.uptimeMillis());
      return;
    }
    a(paramCSendGroupUserIsTypingMsg.groupID).remove(paramCSendGroupUserIsTypingMsg.fromNumber);
    b(paramCSendGroupUserIsTypingMsg.groupID);
  }

  public void onCSendUserIsTypingMsg(CSendUserIsTypingMsg paramCSendUserIsTypingMsg)
  {
    ck localck = new ck(paramCSendUserIsTypingMsg.fromNumber, paramCSendUserIsTypingMsg.deviceID.intValue(), paramCSendUserIsTypingMsg.isSecondaryDevice());
    String str = paramCSendUserIsTypingMsg.fromNumber + paramCSendUserIsTypingMsg.chatType;
    Object localObject = a(str);
    this.c.removeCallbacksAndMessages(localObject);
    a(localck, paramCSendUserIsTypingMsg.chatType.intValue(), paramCSendUserIsTypingMsg.active.booleanValue());
    if (paramCSendUserIsTypingMsg.active.booleanValue())
    {
      this.d.put(str, new com.viber.voip.messages.conversation.ui.cl(localck, paramCSendUserIsTypingMsg.chatType.intValue()));
      this.c.postAtTime(new cm(this, str, localck, paramCSendUserIsTypingMsg), localObject, 6000L + SystemClock.uptimeMillis());
      return;
    }
    this.d.remove(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.cl
 * JD-Core Version:    0.6.2
 */