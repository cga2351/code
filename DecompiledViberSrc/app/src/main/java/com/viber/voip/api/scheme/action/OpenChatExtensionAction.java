package com.viber.voip.api.scheme.action;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.d.a;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.g;
import com.viber.voip.model.j;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ao;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.ce;
import java.util.regex.Pattern;

public final class OpenChatExtensionAction extends f
{
  private static final Logger f = ViberEnv.getLogger();
  private final c g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final int n;
  private final com.viber.voip.messages.k o;

  public OpenChatExtensionAction(com.viber.voip.messages.k paramk, c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.o = paramk;
    this.g = paramc;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.m = paramString5;
    this.l = paramString6;
    this.n = paramInt;
  }

  private void a(long paramLong, final Bundle paramBundle, final Context paramContext, final c.a parama)
  {
    this.o.c().a(paramLong, new ai.e()
    {
      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        OpenChatExtensionAction.Description localDescription = (OpenChatExtensionAction.Description)paramBundle.getParcelable("open_chat_extension");
        if ((localDescription != null) && (1 == localDescription.interfaceType) && (!a.a(paramAnonymousConversationItemLoaderEntity, OpenChatExtensionAction.h(OpenChatExtensionAction.this))))
          OpenChatExtensionAction.a(paramContext, paramBundle);
        while (true)
        {
          parama.b();
          return;
          if ((paramAnonymousConversationItemLoaderEntity != null) && (paramAnonymousConversationItemLoaderEntity.canSendMessages(0)))
          {
            Intent localIntent = m.a(0L, 0L, 0L, paramAnonymousConversationItemLoaderEntity.getGroupId(), paramAnonymousConversationItemLoaderEntity.getParticipantMemberId(), paramAnonymousConversationItemLoaderEntity.getNumber(), paramAnonymousConversationItemLoaderEntity.getConversationType(), paramAnonymousConversationItemLoaderEntity.getViberName(), paramAnonymousConversationItemLoaderEntity.getContactName(), paramAnonymousConversationItemLoaderEntity.getGroupName(), 0, false, false, paramAnonymousConversationItemLoaderEntity.isSecret(), paramAnonymousConversationItemLoaderEntity.isInBusinessInbox(), paramAnonymousConversationItemLoaderEntity.isVlnConversation());
            localIntent.addFlags(67108864);
            localIntent.putExtra("go_up", true);
            localIntent.putExtras(paramBundle);
            y.a(paramContext, localIntent);
          }
          else
          {
            OpenChatExtensionAction.a(paramContext, paramBundle);
          }
        }
      }
    });
  }

  private void a(final Bundle paramBundle, final Context paramContext, c.a parama)
  {
    new h(this.j, new h.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString, g paramAnonymousg)
      {
        if (paramAnonymousInt == 0)
        {
          Intent localIntent = m.a(paramAnonymousg.n().a(), paramAnonymousString, paramAnonymousg.k(), false, false, false, false);
          localIntent.addFlags(67108864);
          localIntent.putExtra("go_up", true);
          localIntent.putExtras(paramBundle);
          y.a(paramContext, localIntent);
          return;
        }
        com.viber.voip.ui.dialogs.k.r().a(new ViberDialogHandlers.ao()).d();
      }
    }).a(paramContext, parama);
  }

  private void a(final a parama)
  {
    if ("up".equals(this.k))
    {
      if (this.h == null)
      {
        parama.a(null, 0);
        return;
      }
      if ("stickers".equals(this.h))
      {
        parama.a(null, 0);
        return;
      }
      if (("giphy".equals(this.h)) && (a.b()))
      {
        parama.a(null, 0);
        return;
      }
      parama.a();
      return;
    }
    if (!this.g.b())
    {
      parama.a();
      return;
    }
    if (this.h == null)
    {
      parama.a(null, 1);
      return;
    }
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        String str = OpenChatExtensionAction.h(OpenChatExtensionAction.this).i(OpenChatExtensionAction.d(OpenChatExtensionAction.this));
        if (str != null)
        {
          parama.a(str, 1);
          return;
        }
        parama.a();
      }
    });
  }

  private static void b(Context paramContext, Bundle paramBundle)
  {
    boolean bool1 = true;
    int[] arrayOfInt = new int[bool1];
    arrayOfInt[0] = 0;
    Intent localIntent = ViberActionRunner.u.a(arrayOfInt);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("extra_forward_chatex", bool1);
    localIntent.putExtra("show_broadcast_list_extra", false);
    Description localDescription = (Description)paramBundle.getParcelable("open_chat_extension");
    boolean bool2;
    if (localDescription != null)
    {
      if (localDescription.interfaceType != 0)
        break label102;
      bool2 = bool1;
      localIntent.putExtra("show_public_accounts_extra", bool2);
      if (localDescription.interfaceType != 0)
        break label108;
    }
    while (true)
    {
      localIntent.putExtra("show_secret_chats_extra", bool1);
      y.a(paramContext, localIntent);
      return;
      label102: bool2 = false;
      break;
      label108: bool1 = false;
    }
  }

  public void a(final Context paramContext, final c.a parama)
  {
    a(new a()
    {
      public void a()
      {
        com.viber.voip.ui.dialogs.k.r().a(new ViberDialogHandlers.ao()).d();
        parama.b();
      }

      public void a(String paramAnonymousString, int paramAnonymousInt)
      {
        if ("1".equals(OpenChatExtensionAction.a(OpenChatExtensionAction.this)));
        Bundle localBundle;
        for (long l = OpenChatExtensionAction.b(OpenChatExtensionAction.this).a().h(); ; l = OpenChatExtensionAction.b(OpenChatExtensionAction.this).a().b(false))
        {
          localBundle = new Bundle(2);
          boolean bool = "1".equals(OpenChatExtensionAction.c(OpenChatExtensionAction.this));
          localBundle.putParcelable("open_chat_extension", new OpenChatExtensionAction.Description(OpenChatExtensionAction.d(OpenChatExtensionAction.this), paramAnonymousString, paramAnonymousInt, OpenChatExtensionAction.e(OpenChatExtensionAction.this), bool, OpenChatExtensionAction.f(OpenChatExtensionAction.this)));
          if ((TextUtils.isEmpty(OpenChatExtensionAction.g(OpenChatExtensionAction.this))) || (!OpenChatExtensionAction.g(OpenChatExtensionAction.this).matches(ce.l.pattern())))
            break;
          OpenChatExtensionAction.a(OpenChatExtensionAction.this, localBundle, paramContext, parama);
          return;
        }
        if (-1L != l)
        {
          OpenChatExtensionAction localOpenChatExtensionAction = OpenChatExtensionAction.this;
          Context localContext = paramContext;
          c.a locala = parama;
          OpenChatExtensionAction.a(localOpenChatExtensionAction, l, localBundle, localContext, locala);
          return;
        }
        OpenChatExtensionAction.a(paramContext, localBundle);
        parama.b();
      }
    });
  }

  public static final class Description
    implements Parcelable
  {
    public static final Parcelable.Creator<Description> CREATOR = new Parcelable.Creator()
    {
      public OpenChatExtensionAction.Description a(Parcel paramAnonymousParcel)
      {
        return new OpenChatExtensionAction.Description(paramAnonymousParcel);
      }

      public OpenChatExtensionAction.Description[] a(int paramAnonymousInt)
      {
        return new OpenChatExtensionAction.Description[paramAnonymousInt];
      }
    };
    public final int cdrOpenTrigger;
    public final String id;
    public final int interfaceType;
    public final String publicAccountId;
    public final String searchQuery;
    public final boolean silentQuery;

    public Description(Parcel paramParcel)
    {
      this.id = paramParcel.readString();
      this.publicAccountId = paramParcel.readString();
      this.interfaceType = paramParcel.readInt();
      this.searchQuery = paramParcel.readString();
      if (paramParcel.readByte() > 0);
      for (boolean bool = true; ; bool = false)
      {
        this.silentQuery = bool;
        this.cdrOpenTrigger = paramParcel.readInt();
        return;
      }
    }

    public Description(String paramString1, String paramString2, int paramInt)
    {
      this(paramString1, paramString2, paramInt, null);
    }

    public Description(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      this(paramString1, paramString2, paramInt, paramString3, false, 0);
    }

    public Description(String paramString1, String paramString2, int paramInt1, String paramString3, boolean paramBoolean, int paramInt2)
    {
      this.id = paramString1;
      this.publicAccountId = paramString2;
      this.interfaceType = paramInt1;
      this.searchQuery = paramString3;
      this.silentQuery = paramBoolean;
      this.cdrOpenTrigger = paramInt2;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.publicAccountId);
      paramParcel.writeInt(this.interfaceType);
      paramParcel.writeString(this.searchQuery);
      if (this.silentQuery);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeInt(this.cdrOpenTrigger);
        return;
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(String paramString, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.OpenChatExtensionAction
 * JD-Core Version:    0.6.2
 */