package com.viber.voip.analytics.story;

import android.net.Uri;
import android.text.SpannableString;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.registration.ActivationController.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.j.ax;
import java.util.List;
import java.util.Locale;

public class o
{
  private final com.viber.voip.analytics.g a;
  private final boolean b;

  public o(com.viber.voip.analytics.g paramg, boolean paramBoolean)
  {
    this.a = paramg;
    this.b = paramBoolean;
  }

  public com.viber.voip.analytics.story.d.c a()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.d.e(this.a);
    return new com.viber.voip.analytics.story.d.c()
    {
      public void a()
      {
        com.viber.voip.analytics.story.d.d.a(this);
      }

      public void a(double paramAnonymousDouble, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.d.d.a(this, paramAnonymousDouble, paramAnonymousString);
      }

      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.d.d.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.d.d.a(this, paramAnonymousString1, paramAnonymousString2);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.d.d.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void b(double paramAnonymousDouble, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.d.d.b(this, paramAnonymousDouble, paramAnonymousString);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.d.d.b(this, paramAnonymousString);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.d.d.c(this, paramAnonymousString);
      }
    };
  }

  public com.viber.voip.analytics.story.f.d b()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.f.f(this.a);
    return new com.viber.voip.analytics.story.f.d()
    {
      public void a()
      {
        com.viber.voip.analytics.story.f.e.a(this);
      }

      public void a(long paramAnonymousLong)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousLong);
      }

      public void a(a paramAnonymousa, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousa, paramAnonymousBoolean);
      }

      public void a(aa paramAnonymousaa, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousaa, paramAnonymousString, paramAnonymousBoolean);
      }

      public void a(ActivationController.b paramAnonymousb)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousb);
      }

      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousString1, paramAnonymousString2);
      }

      public void a(boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousBoolean);
      }

      public void a(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousBoolean, paramAnonymousString);
      }

      public void a(boolean paramAnonymousBoolean1, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean2)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousBoolean1, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean2);
      }

      public void a(boolean paramAnonymousBoolean, String paramAnonymousString, Locale paramAnonymousLocale)
      {
        com.viber.voip.analytics.story.f.e.a(this, paramAnonymousBoolean, paramAnonymousString, paramAnonymousLocale);
      }

      public void b()
      {
        com.viber.voip.analytics.story.f.e.b(this);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.f.e.b(this, paramAnonymousString);
      }

      public void b(boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.f.e.b(this, paramAnonymousBoolean);
      }

      public void c()
      {
        com.viber.voip.analytics.story.f.e.c(this);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.f.e.c(this, paramAnonymousString);
      }

      public void c(boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.f.e.c(this, paramAnonymousBoolean);
      }

      public void d()
      {
        com.viber.voip.analytics.story.f.e.d(this);
      }

      public void d(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.f.e.d(this, paramAnonymousString);
      }

      public void e(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.f.e.e(this, paramAnonymousString);
      }

      public void f(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.f.e.f(this, paramAnonymousString);
      }
    };
  }

  public com.viber.voip.analytics.story.g.a c()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.g.c(this.a);
    return new com.viber.voip.analytics.story.g.a()
    {
      public void a()
      {
        com.viber.voip.analytics.story.g.b.a(this);
      }

      public void a(int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousInt);
      }

      public void a(long paramAnonymousLong)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousLong);
      }

      public void a(Language paramAnonymousLanguage1, Language paramAnonymousLanguage2)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousLanguage1, paramAnonymousLanguage2);
      }

      public void a(ax paramAnonymousax)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousax);
      }

      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString, int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString, paramAnonymousInt);
      }

      public void a(String paramAnonymousString1, int paramAnonymousInt, long paramAnonymousLong, String paramAnonymousString2, boolean paramAnonymousBoolean, String paramAnonymousString3, String paramAnonymousString4)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousInt, paramAnonymousLong, paramAnonymousString2, paramAnonymousBoolean, paramAnonymousString3, paramAnonymousString4);
      }

      public void a(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousLong, paramAnonymousString2);
      }

      public void a(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousLong, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, double paramAnonymousDouble)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousDouble);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject1, Object paramAnonymousObject2, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousObject1, paramAnonymousObject2, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean, String paramAnonymousString4)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean, paramAnonymousString4);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean, paramAnonymousString3);
      }

      public void a(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousString, paramAnonymousBoolean);
      }

      public void a(boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.g.b.a(this, paramAnonymousBoolean);
      }

      public void b()
      {
        com.viber.voip.analytics.story.g.b.b(this);
      }

      public void b(long paramAnonymousLong)
      {
        com.viber.voip.analytics.story.g.b.b(this, paramAnonymousLong);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.b(this, paramAnonymousString);
      }

      public void b(String paramAnonymousString, int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.g.b.b(this, paramAnonymousString, paramAnonymousInt);
      }

      public void b(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.g.b.b(this, paramAnonymousString1, paramAnonymousString2);
      }

      public void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        com.viber.voip.analytics.story.g.b.b(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.c(this, paramAnonymousString);
      }

      public void d(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.d(this, paramAnonymousString);
      }

      public void e(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.e(this, paramAnonymousString);
      }

      public void f(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.f(this, paramAnonymousString);
      }

      public void g(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.g(this, paramAnonymousString);
      }

      public void h(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.h(this, paramAnonymousString);
      }

      public void i(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.i(this, paramAnonymousString);
      }

      public void j(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.g.b.j(this, paramAnonymousString);
      }
    };
  }

  public com.viber.voip.analytics.story.h.c d()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.h.c(this.a);
    return new com.viber.voip.analytics.story.h.a(this.a);
  }

  public com.viber.voip.analytics.story.m.e e()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.m.g(this.a);
    return new com.viber.voip.analytics.story.m.e()
    {
      public void a()
      {
        com.viber.voip.analytics.story.m.f.a(this);
      }

      public void a(double paramAnonymousDouble)
      {
        com.viber.voip.analytics.story.m.f.a(this, paramAnonymousDouble);
      }

      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.m.f.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.m.f.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousString3);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.m.f.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void b()
      {
        com.viber.voip.analytics.story.m.f.b(this);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.m.f.b(this, paramAnonymousString);
      }

      public void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.m.f.b(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void c()
      {
        com.viber.voip.analytics.story.m.f.c(this);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.m.f.c(this, paramAnonymousString);
      }

      public void d(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.m.f.d(this, paramAnonymousString);
      }

      public void e(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.m.f.e(this, paramAnonymousString);
      }
    };
  }

  public com.viber.voip.analytics.story.j.c f()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.j.e(this.a);
    return new com.viber.voip.analytics.story.j.c()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.j.d.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }
    };
  }

  public com.viber.voip.analytics.story.e.c g()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.e.e(this.a);
    return new com.viber.voip.analytics.story.e.c()
    {
      public void a()
      {
        com.viber.voip.analytics.story.e.d.a(this);
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt1, paramAnonymousInt2);
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean);
      }

      public void a(int paramAnonymousInt, Uri paramAnonymousUri)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt, paramAnonymousUri);
      }

      public void a(int paramAnonymousInt, ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt, paramAnonymousConversationItemLoaderEntity, paramAnonymousBoolean);
      }

      public void a(int paramAnonymousInt, h paramAnonymoush)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt, paramAnonymoush);
      }

      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt, paramAnonymousString);
      }

      public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }

      public void a(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousInt, paramAnonymousString, paramAnonymousBoolean);
      }

      public void a(long paramAnonymousLong, int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousLong, paramAnonymousInt);
      }

      public void a(long paramAnonymousLong, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousLong, paramAnonymousString);
      }

      public void a(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramAnonymousSaveLinkActionMessage)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousSaveLinkActionMessage);
      }

      public void a(BotReplyRequest paramAnonymousBotReplyRequest, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousBotReplyRequest, paramAnonymousBoolean);
      }

      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousConversationItemLoaderEntity);
      }

      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousConversationItemLoaderEntity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
      }

      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, aa paramAnonymousaa)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousConversationItemLoaderEntity, paramAnonymousaa);
      }

      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousConversationItemLoaderEntity, paramAnonymousString);
      }

      public void a(ConversationLoaderEntity paramAnonymousConversationLoaderEntity)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousConversationLoaderEntity);
      }

      public void a(Sticker paramAnonymousSticker)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousSticker);
      }

      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString, ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString, paramAnonymousConversationItemLoaderEntity);
      }

      public void a(String paramAnonymousString1, ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousConversationItemLoaderEntity, paramAnonymousString2);
      }

      public void a(String paramAnonymousString1, ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousConversationItemLoaderEntity, paramAnonymousString2, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString, ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString, paramAnonymousConversationItemLoaderEntity, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString1, ConversationLoaderEntity paramAnonymousConversationLoaderEntity, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousConversationLoaderEntity, paramAnonymousString2, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString, ConversationLoaderEntity paramAnonymousConversationLoaderEntity, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString, paramAnonymousConversationLoaderEntity, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString, MessageEntity paramAnonymousMessageEntity, h paramAnonymoush, Locale paramAnonymousLocale, SpannableString paramAnonymousSpannableString, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString, paramAnonymousMessageEntity, paramAnonymoush, paramAnonymousLocale, paramAnonymousSpannableString, paramAnonymousBoolean1, paramAnonymousBoolean2);
      }

      public void a(String paramAnonymousString, MessageEntity paramAnonymousMessageEntity, Locale paramAnonymousLocale, SpannableString paramAnonymousSpannableString, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString, paramAnonymousMessageEntity, paramAnonymousLocale, paramAnonymousSpannableString, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString1, h paramAnonymoush, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymoush, paramAnonymousString2);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousString2);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Integer paramAnonymousInteger)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInteger);
      }

      public void a(String paramAnonymousString1, boolean paramAnonymousBoolean, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousString1, paramAnonymousBoolean, paramAnonymousString2);
      }

      public void a(boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.e.d.a(this, paramAnonymousBoolean);
      }

      public void b()
      {
        com.viber.voip.analytics.story.e.d.b(this);
      }

      public void b(long paramAnonymousLong, int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.e.d.b(this, paramAnonymousLong, paramAnonymousInt);
      }

      public void b(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.b(this, paramAnonymousConversationItemLoaderEntity, paramAnonymousString);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.b(this, paramAnonymousString);
      }

      public void b(String paramAnonymousString, ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        com.viber.voip.analytics.story.e.d.b(this, paramAnonymousString, paramAnonymousConversationItemLoaderEntity);
      }

      public void b(String paramAnonymousString1, h paramAnonymoush, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.e.d.b(this, paramAnonymousString1, paramAnonymoush, paramAnonymousString2);
      }

      public void b(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.e.d.b(this, paramAnonymousString1, paramAnonymousString2);
      }

      public void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.e.d.b(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void c()
      {
        com.viber.voip.analytics.story.e.d.c(this);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.e.d.c(this, paramAnonymousString);
      }

      public void d()
      {
        com.viber.voip.analytics.story.e.d.d(this);
      }
    };
  }

  public com.viber.voip.analytics.story.b.c h()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.b.e(this.a);
    return new com.viber.voip.analytics.story.b.c()
    {
      public void a()
      {
        com.viber.voip.analytics.story.b.d.a(this);
      }

      public void a(int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.b.d.a(this, paramAnonymousInt);
      }

      public void a(int paramAnonymousInt1, com.viber.voip.analytics.story.b.f paramAnonymousf, String paramAnonymousString, List paramAnonymousList, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, long paramAnonymousLong4, long paramAnonymousLong5)
      {
        com.viber.voip.analytics.story.b.d.a(this, paramAnonymousInt1, paramAnonymousf, paramAnonymousString, paramAnonymousList, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousLong3, paramAnonymousLong4, paramAnonymousLong5);
      }

      public void a(int paramAnonymousInt, String paramAnonymousString1, List paramAnonymousList, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3)
      {
        com.viber.voip.analytics.story.b.d.a(this, paramAnonymousInt, paramAnonymousString1, paramAnonymousList, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3);
      }

      public void a(CallInfo paramAnonymousCallInfo, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3, boolean paramAnonymousBoolean4, boolean paramAnonymousBoolean5, long paramAnonymousLong, String paramAnonymousString4)
      {
        com.viber.voip.analytics.story.b.d.a(this, paramAnonymousCallInfo, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3, paramAnonymousBoolean4, paramAnonymousBoolean5, paramAnonymousLong, paramAnonymousString4);
      }

      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.b.d.a(this, paramAnonymousString);
      }

      public void b()
      {
        com.viber.voip.analytics.story.b.d.b(this);
      }

      public void b(int paramAnonymousInt)
      {
        com.viber.voip.analytics.story.b.d.b(this, paramAnonymousInt);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.b.d.b(this, paramAnonymousString);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.b.d.c(this, paramAnonymousString);
      }
    };
  }

  public com.viber.voip.analytics.story.c.c i()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.c.e(this.a);
    return new com.viber.voip.analytics.story.c.c()
    {
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        com.viber.voip.analytics.story.c.d.a(this, paramAnonymousString, paramAnonymousLong);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.c.d.a(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.c.d.b(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }

      public void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.viber.voip.analytics.story.c.d.c(this, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }
    };
  }

  public com.viber.voip.analytics.story.i.c j()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.i.e(this.a);
    return new com.viber.voip.analytics.story.i.c()
    {
      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.i.d.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString, List paramAnonymousList, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.i.d.a(this, paramAnonymousString, paramAnonymousList, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        com.viber.voip.analytics.story.i.d.a(this, paramAnonymousString, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3)
      {
        com.viber.voip.analytics.story.i.d.a(this, paramAnonymousString, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.i.d.b(this, paramAnonymousString);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.i.d.c(this, paramAnonymousString);
      }

      public void d(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.i.d.d(this, paramAnonymousString);
      }
    };
  }

  public com.viber.voip.analytics.story.a.a k()
  {
    if (this.b)
      return new com.viber.voip.analytics.story.a.c(this.a);
    return new com.viber.voip.analytics.story.a.a()
    {
      public void a()
      {
        com.viber.voip.analytics.story.a.b.a(this);
      }

      public void a(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.a.b.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.viber.voip.analytics.story.a.b.a(this, paramAnonymousString1, paramAnonymousString2);
      }

      public void b(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.a.b.b(this, paramAnonymousString);
      }

      public void c(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.a.b.c(this, paramAnonymousString);
      }

      public void d(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.a.b.d(this, paramAnonymousString);
      }

      public void e(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.a.b.e(this, paramAnonymousString);
      }

      public void f(String paramAnonymousString)
      {
        com.viber.voip.analytics.story.a.b.f(this, paramAnonymousString);
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.o
 * JD-Core Version:    0.6.2
 */