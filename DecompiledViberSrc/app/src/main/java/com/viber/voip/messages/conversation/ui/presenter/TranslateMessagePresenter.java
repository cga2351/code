package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Handler;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureTokenDelegate;
import com.viber.jni.secure.SecureTokenListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.c.a;
import com.viber.voip.messages.conversation.ui.view.q;
import com.viber.voip.messages.orm.entity.json.Data;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.messages.orm.entity.json.Translation;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class TranslateMessagePresenter extends BaseMvpPresenter<q, State>
  implements SecureTokenDelegate, com.viber.voip.messages.conversation.ui.b.g
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(5L);
  private a c;
  private Engine d;
  private ab e;
  private o f;
  private OkHttpClientFactory g;
  private com.viber.voip.messages.conversation.ui.b.f h;
  private String i;
  private Handler j;
  private final c k;
  private long l;
  private int m;

  public TranslateMessagePresenter(Engine paramEngine, a parama, ab paramab, o paramo, OkHttpClientFactory paramOkHttpClientFactory, Handler paramHandler, String paramString, com.viber.voip.messages.conversation.ui.b.f paramf, c paramc)
  {
    this.d = paramEngine;
    this.c = parama;
    this.e = paramab;
    this.f = paramo;
    this.g = paramOkHttpClientFactory;
    this.j = paramHandler;
    this.i = paramString;
    this.h = paramf;
    this.k = paramc;
  }

  private void a()
  {
    ((q)this.mView).b();
  }

  private boolean a(byte[] paramArrayOfByte)
  {
    int n = paramArrayOfByte.length;
    for (int i1 = 0; ; i1++)
    {
      boolean bool = false;
      if (i1 < n)
      {
        if (paramArrayOfByte[i1] != 0)
          bool = true;
      }
      else
        return bool;
    }
  }

  private void f(long paramLong)
  {
    if (this.e.l(paramLong) == null)
    {
      ((q)this.mView).a(false);
      return;
    }
    Language localLanguage = this.c.b(this.c.f());
    if (localLanguage != null)
      this.k.a(localLanguage.getLanguage(), ae.b());
    this.m = this.d.getPhoneController().generateSequence();
    this.l = paramLong;
    this.d.getDelegatesManager().getSecureTokenListener().registerDelegate(this, this.j);
    this.d.getPhoneController().handleSecureTokenRequest(this.m);
  }

  public void a(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case -1:
      this.k.b("Continue");
      d(paramLong);
      return;
    case -2:
      this.k.b("Don't Show Again");
      this.c.c();
      d(paramLong);
      return;
    case -3:
    }
    this.k.b("Cancel");
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramConversationItemLoaderEntity.isConversation1on1()) && (!paramConversationItemLoaderEntity.isSystemConversation()) && (!paramConversationItemLoaderEntity.isAnonymous()) && (!da.a(paramConversationItemLoaderEntity.getNumber())) && (this.c.g()) && (this.c.b()) && (!paramConversationItemLoaderEntity.getNumber().startsWith(this.c.a())) && (!((q)this.mView).a()))
    {
      ((q)this.mView).c();
      this.c.d();
    }
  }

  public void a(String paramString)
  {
    this.c.a(paramString);
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void c(long paramLong)
  {
    if (this.c.e())
    {
      ((q)this.mView).a(paramLong);
      return;
    }
    d(paramLong);
  }

  public void d(long paramLong)
  {
    ((q)this.mView).a(true);
    this.j.post(new aa(this, paramLong));
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.d.getDelegatesManager().getSecureTokenListener().removeDelegate(this);
    this.h.b(this);
  }

  public void onSecureTokenReply(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.m != paramInt)
      return;
    this.d.getDelegatesManager().getSecureTokenListener().removeDelegate(this);
    if (!a(paramArrayOfByte))
    {
      ((q)this.mView).a(false);
      ((q)this.mView).d();
      return;
    }
    OkHttpClient.Builder localBuilder = this.g.createBuilder().connectTimeout(b, TimeUnit.SECONDS).readTimeout(b, TimeUnit.SECONDS);
    MessageEntity localMessageEntity = this.e.l(this.l);
    try
    {
      i.a();
      JSONObject localJSONObject = this.c.a(paramLong, paramArrayOfByte, localMessageEntity);
      Request.Builder localBuilder1 = new Request.Builder().url(this.i).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), localJSONObject.toString()));
      Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
      if (localResponse.isSuccessful())
      {
        String str = localResponse.body().string();
        localMessageEntity.setDescription(((Translation)((Data)new com.google.d.g().a().a(str, Data.class)).getTranslations().get(0)).getTranslatedText());
        localMessageEntity.addExtraFlag(5);
        this.e.b(localMessageEntity);
        this.f.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      }
      while (true)
      {
        ((q)this.mView).a(false);
        return;
        a();
      }
    }
    catch (Exception localException)
    {
      while (true)
        a();
    }
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.h.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.TranslateMessagePresenter
 * JD-Core Version:    0.6.2
 */