package com.viber.voip.messages.controller.manager;

import android.text.TextUtils;
import com.google.d.a.a;
import com.google.d.g;
import com.google.d.p;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSyncDataFromMyOtherDeviceMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesReplyMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.h;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.l;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.cd;
import com.viber.voip.util.upload.ObjectId;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class aw
  implements av
{
  private static final Logger a = ViberEnv.getLogger();
  private Im2Exchanger b;
  private PhoneController c;
  private final b d = new b();
  private final d e = new d();

  private Im2Exchanger a()
  {
    if (this.b == null)
      this.b = ViberApplication.getInstance().getEngine(true).getExchanger();
    return this.b;
  }

  private PhoneController b()
  {
    if (this.c == null)
      this.c = ViberApplication.getInstance().getEngine(true).getPhoneController();
    return this.c;
  }

  public void onCSyncDataFromMyOtherDeviceMsg(CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg)
  {
    if (!c.h.c.e());
    MessageEntity localMessageEntity;
    while (true)
    {
      return;
      String str = new String(paramCSyncDataFromMyOtherDeviceMsg.encryptedData);
      try
      {
        if ("Request".equalsIgnoreCase(new JSONObject(str).getString("Action")))
        {
          c localc = this.e.a(str);
          localMessageEntity = ab.b().k(localc.c);
          if (localMessageEntity == null)
          {
            a.a(new RuntimeException("CSyncDataFromMyOtherDeviceMsg - message not found"), "SyncLostMsg");
            return;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        a.a(new RuntimeException("CSyncDataFromMyOtherDeviceMsg - invalid json"), "SyncLostMsg");
        return;
      }
    }
    if (localMessageEntity.getObjectId() == null);
    long l2;
    for (long l1 = 0L; ; l1 = l2)
    {
      a locala = new a(localMessageEntity);
      CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(this.d.a(locala).getBytes(), 0, 2L, b().generateSequence(), l1);
      a().handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
      return;
      l2 = localMessageEntity.getObjectId().toLong();
    }
  }

  public void onCSyncDataToMyDevicesReplyMsg(CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg)
  {
  }

  public class a
  {

    @a
    @com.google.d.a.c(a="Type")
    public String a = "RestoreMessage";

    @a
    @com.google.d.a.c(a="Action")
    public String b = "Reply";

    @a
    @com.google.d.a.c(a="Token")
    public long c;

    @a
    @com.google.d.a.c(a="Sequence")
    public Integer d;

    @a
    @com.google.d.a.c(a="Status")
    public Integer e;

    @a
    @com.google.d.a.c(a="Message")
    public b f = new b();

    public a(MessageEntity arg2)
    {
      this.f.i = new a();
      Object localObject;
      if (localObject == null)
        return;
      int i = localObject.getFlag();
      String str1 = localObject.getDownloadId();
      if (localObject.isOutgoing())
      {
        i |= 16;
        if (localObject.isSticker())
        {
          ObjectId localObjectId = localObject.getObjectId();
          if (localObjectId != null)
            str1 = Integer.toHexString(localObjectId.toStickerId());
        }
      }
      this.c = localObject.getMessageToken();
      this.d = Integer.valueOf(localObject.getMessageSeq());
      this.e = Integer.valueOf(0);
      m localm = com.viber.voip.messages.d.c.c().c(localObject.getMemberId(), cd.j(localObject.getConversationType()));
      String str2;
      label161: b localb;
      if (localm == null)
      {
        str2 = "";
        this.f.a = str2;
        this.f.b = localObject.getMemberId();
        this.f.c = Long.toString(localObject.getMessageToken());
        this.f.d = Long.toString(localObject.getGroupId());
        localb = this.f;
        if (!localObject.isMediaWithThumbnail())
          break label440;
      }
      label440: for (String str3 = localObject.getDescription(); ; str3 = localObject.getBody())
      {
        localb.e = str3;
        this.f.f = localObject.getDate();
        this.f.g = Integer.valueOf(i);
        this.f.h = Integer.valueOf(localObject.getMessageSeq());
        this.f.i.a = Integer.valueOf(localObject.getLng());
        this.f.i.b = Integer.valueOf(localObject.getLat());
        this.f.j = l.b(localObject.getMimeType());
        this.f.k = localObject.getBucket();
        this.f.l = str1;
        this.f.m = localObject.getDuration();
        this.f.n = Integer.valueOf(0);
        this.f.o = localObject.getRawMessageInfo();
        if (7 == this.f.j)
        {
          this.f.o = this.f.e;
          this.f.e = null;
        }
        EncryptionParams localEncryptionParams = localObject.getEncryptionParams();
        if (localEncryptionParams == null)
          break;
        this.f.p = EncryptionParams.serializeEncryptionParams(localEncryptionParams);
        return;
        str2 = localm.getNumber();
        break label161;
      }
    }

    public class a
    {

      @a
      @com.google.d.a.c(a="longitude")
      public Integer a;

      @a
      @com.google.d.a.c(a="latitude")
      public Integer b;

      public a()
      {
      }
    }

    public class b
    {

      @a
      @com.google.d.a.c(a="OriginPhoneNumber")
      public String a;

      @a
      @com.google.d.a.c(a="MemberID")
      public String b;

      @a
      @com.google.d.a.c(a="MessageToken")
      public String c;

      @a
      @com.google.d.a.c(a="GroupID")
      public String d;

      @a
      @com.google.d.a.c(a="Text")
      public String e;

      @a
      @com.google.d.a.c(a="TimeSent")
      public long f;

      @a
      @com.google.d.a.c(a="Flags")
      public Integer g;

      @a
      @com.google.d.a.c(a="MessageSeq")
      public Integer h;

      @a
      @com.google.d.a.c(a="Location")
      public aw.a.a i;

      @a
      @com.google.d.a.c(a="MediaType")
      public int j;

      @a
      @com.google.d.a.c(a="BucketName")
      public String k;

      @a
      @com.google.d.a.c(a="DownloadID")
      public String l;

      @a
      @com.google.d.a.c(a="Duration")
      public long m;

      @a
      @com.google.d.a.c(a="UploadDuration")
      public Integer n;

      @a
      @com.google.d.a.c(a="MsgInfo")
      public String o;

      @a
      @com.google.d.a.c(a="DownloadEP")
      public String p;

      public b()
      {
      }
    }
  }

  public class b
  {
    public b()
    {
    }

    private com.google.d.f a()
    {
      return new g().a();
    }

    public String a(aw.a parama)
    {
      if (parama == null)
        return "{}";
      try
      {
        String str = a().b(parama);
        return str;
      }
      catch (p localp)
      {
      }
      return "{}";
    }
  }

  public class c
  {

    @a
    @com.google.d.a.c(a="Type")
    public String a = "RestoreMessage";

    @a
    @com.google.d.a.c(a="Action")
    public String b = "Request";

    @a
    @com.google.d.a.c(a="Token")
    public long c;

    public c()
    {
    }
  }

  public class d
  {
    public d()
    {
    }

    private com.google.d.f a()
    {
      return new g().a();
    }

    public aw.c a(String paramString)
    {
      aw.c localc;
      if ((TextUtils.isEmpty(paramString)) || ("{}".equals(paramString)))
        localc = new aw.c(aw.this);
      while (true)
      {
        return localc;
        try
        {
          localc = (aw.c)a().a(paramString, aw.c.class);
          if (localc != null)
            continue;
          return new aw.c(aw.this);
        }
        catch (p localp)
        {
          while (true)
            localc = null;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.aw
 * JD-Core Version:    0.6.2
 */