package com.viber.service.a;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.cdr.entity.SendMessageMediaTypeFactory;
import com.viber.jni.cdr.entity.SendMessageMediaTypeFactory.SendMessageMediaTypeData;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSendMessageMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.messenger.MessengerDelegate.MessagesSender;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.ProductId;
import com.viber.voip.gdpr.a.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.m;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.i.a;
import com.viber.voip.util.da;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends PhoneControllerDelegateAdapter
  implements MessengerDelegate.MessagesSender
{
  private static final Logger a = ViberEnv.getLogger();
  private SparseBooleanArray b = new SparseBooleanArray();
  private SparseArray<b> c = new SparseArray();

  public static a a()
  {
    return a.a();
  }

  private void a(long paramLong)
  {
    ViberApplication.getInstance().getMessagesManager().x().b().c();
    b(paramLong);
  }

  private void a(long paramLong, ProductId paramProductId)
  {
    switch (2.a[paramProductId.getCategory().ordinal()])
    {
    default:
    case 1:
    }
    while (true)
    {
      b(paramLong);
      return;
      this.b.put(paramProductId.getPackageId(), Boolean.TRUE.booleanValue());
      i.a().a(paramProductId.getPackageId(), i.a.c);
    }
  }

  private void a(long paramLong, JSONObject paramJSONObject)
  {
    final b localb = new b(null);
    b.a(localb, paramLong);
    try
    {
      b.a(localb, paramJSONObject.getJSONObject("Receiver"));
      b.b(localb, paramJSONObject.getJSONObject("Sender"));
      b.a(localb, paramJSONObject.getString("ToPhoneNum"));
      b.b(localb, paramJSONObject.getString("ToMid"));
      if (da.a(b.a(localb)))
      {
        if (b.b(localb).startsWith("+"));
        for (String str = b.b(localb); ; str = "+" + b.b(localb))
        {
          ViberApplication.getInstance().getMessagesManager().e().b(str, new ci.a()
          {
            public void onGetUserDetail(m[] paramAnonymousArrayOfm)
            {
              a.b.b(localb, paramAnonymousArrayOfm[0].a());
              if (!da.a(a.b.a(localb)))
                a.a(a.this, a.b.c(localb).toString(), localb);
            }

            public void onGetUserError()
            {
            }
          }
          , true);
          return;
        }
      }
      a(b.c(localb).toString(), localb);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void a(String paramString, b paramb)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    int i = localEngine.getPhoneController().generateSequence();
    this.c.put(i, paramb);
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(13);
    localEngine.getExchanger().handleCSendMessageMsg(new CSendMessageMsg(b.a(paramb), "", i, null, localSendMessageMediaTypeData.getMediaType(), 0L, new byte[0], 0, new byte[0], 0, 0, paramString, "", "", 0, 0, 0L, localSendMessageMediaTypeData.getCdrMediaType(), localSendMessageMediaTypeData.getCdrExtraData()));
  }

  private void b(long paramLong)
  {
    ViberApplication.getInstance().getEngine(true).getPhoneController().handleSendWebNotificationAck(paramLong);
  }

  public void onSendMessageReply(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    b localb = (b)this.c.get(paramInt1);
    if (localb != null)
    {
      String[] arrayOfString = com.viber.voip.wallet.a.a(null, b.d(localb).toString());
      if (arrayOfString != null)
      {
        MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.a(b.a(localb), paramLong, System.currentTimeMillis(), 16, 0, null, 0, 0).a(7, arrayOfString[0], 0, b.d(localb).toString(), 0);
        Member localMember = new Member(b.a(localb), b.b(localb));
        if (new bs(ViberApplication.getApplication()).a(localMessageEntity, null, localMember, "", 0, true, null).b)
          b(b.e(localb));
      }
    }
  }

  public boolean onWebNotification(long paramLong, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str = localJSONObject.optString("op");
      if ("unlock".equals(str))
        a(paramLong, ProductId.fromString(localJSONObject.getString("product_id")));
      else if (("wallet_sent_money_1n1".equals(str)) || ("wallet_after_request_money_1n1".equals(str)))
        a(paramLong, localJSONObject);
      else if ("gdpr_erase_local_data".equals(str))
        a(paramLong);
      label98: return true;
    }
    catch (JSONException localJSONException)
    {
      break label98;
    }
  }

  private static final class a
  {
    private static final a a;

    static
    {
      if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a);
      for (a locala = new a(null); ; locala = null)
      {
        a = locala;
        return;
      }
    }
  }

  private class b
  {
    private String b;
    private long c;
    private JSONObject d;
    private JSONObject e;
    private String f;

    private b()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.a.a
 * JD-Core Version:    0.6.2
 */