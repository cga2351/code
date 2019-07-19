package com.viber.voip.messages.ui;

import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.c.a;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.b.h;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.entity.PublicAccountInteraction;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.analytics.story.StoryConstants.v.a;
import com.viber.voip.av.e;
import com.viber.voip.av.f;
import com.viber.voip.block.b.a;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.FavoritesMetadata;
import com.viber.voip.i.c.f;
import com.viber.voip.i.c.h;
import com.viber.voip.market.StickerMarketActivity;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.community.CommunityConversationFragment;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.view.e;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.BlockPublicGroupAction;
import com.viber.voip.messages.orm.entity.json.action.BlockTpaAction;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.r;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.bd;
import com.viber.voip.settings.d.g;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.Sticker.a;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.e.b;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.ax;
import com.viber.voip.util.ViberActionRunner.az.c;
import com.viber.voip.util.bu;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.upload.ObjectId;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class as extends bc
{
  private static final Logger g = ViberEnv.getLogger();
  private static final long h = TimeUnit.MINUTES.toMillis(2L);
  private int A;
  private int B;
  private e i;
  private final com.viber.voip.group.participants.settings.b j;
  private aa k;
  private ConversationFragment l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private final boolean t;
  private final com.viber.voip.messages.extensions.c u;
  private final com.viber.voip.messages.controller.ai v;
  private final com.viber.voip.invitelinks.d w;
  private r x;
  private int y;
  private int z;

  public as(Activity paramActivity, ContextMenu paramContextMenu, int paramInt1, aa paramaa, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt3, com.viber.voip.messages.conversation.ui.j paramj, boolean paramBoolean7, com.viber.voip.group.participants.settings.b paramb, boolean paramBoolean8, e parame, com.viber.voip.messages.extensions.c paramc, com.viber.voip.messages.controller.ai paramai, com.viber.voip.invitelinks.d paramd)
  {
    super(paramActivity, paramContextMenu, paramInt1, paramj);
    this.t = paramBoolean6;
    this.j = paramb;
    this.k = paramaa;
    this.o = paramBoolean8;
    this.y = paramInt2;
    this.z = paramInt3;
    this.m = paramBoolean1;
    this.n = paramBoolean2;
    this.q = paramBoolean3;
    this.p = paramBoolean7;
    this.r = paramBoolean4;
    this.s = paramBoolean5;
    this.u = paramc;
    this.v = paramai;
    this.w = paramd;
    this.A = this.k.bG();
    this.i = parame;
    d();
    a();
    a(R.id.menu_translate_message, new ai(k.f));
    a(R.id.menu_edit, new d(k.b));
    a(R.id.show_sticker_offer, new af(k.e));
    a(R.id.menu_reply, new u(k.a));
    a(R.id.menu_view_likes, new an(k.h));
    a(R.id.menu_pin, new t(k.g));
    a(R.id.menu_message_copy, new n(k.d));
    a(R.id.menu_message_view, a(k.k));
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = R.id.menu_message_delete;
    arrayOfInt[1] = R.id.menu_message_delete_all_for_participant;
    a(arrayOfInt, new p(k.i));
    a(R.id.menu_message_delete_all_copies, new o(k.j));
    a(R.id.menu_report_message, new v(k.l));
    a(R.id.menu_message_forward, new q(k.m));
    a(R.id.menu_get_sticker, new g(k.n));
    a(R.id.menu_block, new b(k.o));
    a(R.id.menu_system_info, new ag(k.r));
    a(R.id.menu_share, new ac(k.p));
  }

  private bc.b a(k paramk)
  {
    if (this.k.az())
      return new j(paramk);
    if (this.k.ay())
      return new m(paramk);
    if (this.k.aA())
      return new al(paramk);
    return null;
  }

  private r b(int paramInt)
  {
    ah localah;
    if ((!this.k.as()) && (!this.k.at()) && (paramInt == 0))
      localah = new ah();
    do
    {
      return localah;
      if (this.k.aD())
        return new ao();
      if (this.k.aJ())
        return new ad();
      if (this.k.aK())
        return new am();
      if (4 == paramInt)
        return new ae();
      if (5 == paramInt)
        return new l();
      if (1 == paramInt)
        return new i();
      if (1002 == paramInt)
        return new c();
      if (3 == paramInt)
        return new ak();
      if (7 == paramInt)
        return new f();
      if ((this.k.as()) || (this.k.at()) || (1000 == paramInt))
        return new s();
      if (9 == paramInt)
        return new ab();
      if (8 == paramInt)
        return new aj();
      if (10 == paramInt)
        return new e();
      if (1005 == paramInt)
        return new h();
      localah = null;
    }
    while (1006 != paramInt);
    return new x();
  }

  private void d()
  {
    this.B = this.k.q();
    this.x = b(this.B);
  }

  protected View a()
  {
    View localView = super.a();
    TextView localTextView = (TextView)localView.findViewById(R.id.text);
    if (this.x != null)
      this.x.a(localTextView);
    while (true)
    {
      ((ImageView)localView.findViewById(R.id.icon)).setImageResource(R.drawable.ic_message_context_header);
      return localView;
      localTextView.setText("");
    }
  }

  protected void a(int paramInt, bc.b paramb)
  {
    if (this.k.U())
    {
      if (R.id.menu_message_delete_all_copies != paramInt);
      for (int i1 = 1; i1 == 0; i1 = 0)
        return;
    }
    super.a(paramInt, paramb);
  }

  public void a(ConversationFragment paramConversationFragment)
  {
    this.l = paramConversationFragment;
  }

  public boolean a(int paramInt)
  {
    this.i.a(paramInt, this.k);
    return super.a(paramInt);
  }

  private abstract class a
  {
    protected final as.k a;

    public a(as.k arg2)
    {
      Object localObject;
      this.a = localObject;
    }
  }

  private class aa extends as.a
    implements bc.c
  {
    aa(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      as.this.b.add(0, R.id.menu_save_to_gallery, this.a.ordinal(), R.string.menu_save_to_gallery);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }

    public String[] b()
    {
      return n.m;
    }

    public int c()
    {
      return 135;
    }
  }

  private class ab extends as.r
  {
    public ab()
    {
      super();
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_share_contact_message);
    }
  }

  private class ac extends as.a
    implements bc.b
  {
    ac(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).j) && (!as.j(as.this)) && (!as.a(as.this).an()))
        as.this.b.add(0, R.id.menu_share, this.a.ordinal(), R.string.menu_message_share);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      boolean bool1 = as.l(as.this) instanceof com.viber.voip.messages.conversation.publicaccount.f;
      PublicAccountInteraction localPublicAccountInteraction = null;
      if (bool1)
      {
        boolean bool2 = as.l(as.this) instanceof CommunityConversationFragment;
        localPublicAccountInteraction = null;
        if (!bool2)
          localPublicAccountInteraction = ((com.viber.voip.messages.conversation.publicaccount.f)as.l(as.this)).a(as.a(as.this), null);
      }
      new ViberActionRunner.az.c(as.this.a, as.o(as.this), new com.viber.voip.invitelinks.f(as.p(as.this), cj.a(as.this.a))).a(as.a(as.this).b(), as.a(as.this), false, localPublicAccountInteraction);
    }
  }

  private class ad extends as.r
  {
    public ad()
    {
      super();
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_voice);
    }
  }

  private class ae extends as.r
  {
    public ae()
    {
      super();
      Sticker localSticker = as.a(as.this).bn();
      if ((localSticker.type == Sticker.a.c) && (!localSticker.isOwned()))
        this.g = true;
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_sticker);
    }
  }

  private class af extends as.a
    implements bc.b
  {
    public af(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if (as.a(as.this).ai())
        as.this.b.add(0, R.id.show_sticker_offer, this.a.ordinal(), R.string.show_sticker_offer);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      com.viber.voip.stickers.a.a locala = com.viber.voip.stickers.i.a().b();
      if ((locala.c(as.a(as.this))) && (as.a(as.this).ai()));
      for (int i = 1; ; i = 0)
      {
        if ((i != 0) && (cj.c(as.this.a)))
          locala.a(as.this.a, as.a(as.this), 1);
        return;
      }
    }
  }

  private class ag extends as.a
    implements bc.b
  {
    ag(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).i))
        as.this.b.add(0, R.id.menu_system_info, this.a.ordinal(), "System Info (Debug)");
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      boolean bool1 = as.a(as.this).ax();
      String str1 = null;
      if (bool1)
      {
        boolean bool2 = as.a(as.this).ai();
        str1 = null;
        if (bool2)
          str1 = "\nads ttl: " + (as.a(as.this).J() - System.currentTimeMillis()) / 1000L + "s";
      }
      StringBuilder localStringBuilder1 = new StringBuilder().append(as.a(as.this).bF().replace("-[", "\n").replace("[", "#\n").replace(", ", "\n"));
      StringBuilder localStringBuilder2;
      if (str1 != null)
      {
        localStringBuilder2 = localStringBuilder1.append(str1).append("\ntempFile: ");
        if (as.a(as.this).o() != null)
          break label208;
      }
      label208: for (String str2 = "null"; ; str2 = bu.a(Uri.parse(as.a(as.this).o()).getPath()))
      {
        final String str3 = str2.replace("]", "").replace(" ", "");
        com.viber.voip.av.a(av.e.d).post(new Runnable()
        {
          public void run()
          {
            MessageEntity localMessageEntity = ab.b().l(as.a(as.this).a());
            SpannableString localSpannableString2;
            if ((localMessageEntity != null) && ((localMessageEntity.isSecretMessage()) || (localMessageEntity.getTimebombInSec() > 0)))
            {
              String str1 = "Timebomb: " + localMessageEntity.getTimebombInSec() + "sec\n";
              if (localMessageEntity.getReadMessageTime() > 0L)
              {
                String str2 = str1 + "Read Time: " + localMessageEntity.getReadMessageTime() + "\n";
                String str3 = str2 + "Current Time: " + SystemClock.elapsedRealtime() + "\n";
                str1 = str3 + "Left time: " + (localMessageEntity.getReadMessageTime() + 1000 * localMessageEntity.getTimebombInSec() - SystemClock.elapsedRealtime()) / 1000L + "sec\n";
              }
              localSpannableString2 = new SpannableString(str1 + str3);
              localSpannableString2.setSpan(new ForegroundColorSpan(-65536), 0, str1.length(), 33);
            }
            for (final SpannableString localSpannableString1 = localSpannableString2; ; localSpannableString1 = new SpannableString(str3))
            {
              com.viber.voip.av.a(av.e.a).post(new Runnable()
              {
                public void run()
                {
                  new c.a(new ContextThemeWrapper(as.this.a, R.style.Theme_Viber)).a("System info").b(localSpannableString1).a(false).a("Close", null).c("Copy to clipboard", new DialogInterface.OnClickListener()
                  {
                    public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      ((ClipboardManager)ViberApplication.getApplication().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("System info", as.ag.1.this.a));
                    }
                  }).b().show();
                }
              });
              return;
            }
          }
        });
        return;
        str1 = "";
        break;
      }
    }
  }

  private class ah extends as.r
  {
    public ah()
    {
      super();
      if (!as.a(as.this).ag());
      for (boolean bool = true; ; bool = false)
      {
        this.j = bool;
        return;
      }
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(as.a(as.this).h());
      as.this.d.a(paramTextView, (int)paramTextView.getTextSize());
    }
  }

  private class ai extends as.a
    implements bc.b
  {
    ai(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((c.h.e.e()) && (as.a(as.this).aY()) && (!as.a(as.this).ba()) && (!as.a(as.this).aj()) && (!as.a(as.this).an()))
      {
        if (as.a(as.this).al())
          as.this.b.add(0, R.id.menu_translate_message, this.a.ordinal(), R.string.language_settings);
      }
      else
        return;
      as.this.b.add(0, R.id.menu_translate_message, this.a.ordinal(), R.string.translate);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      if (as.a(as.this).al())
      {
        ViberActionRunner.ax.a(as.l(as.this), 107, d.bd.d.d(), as.a(as.this).a());
        return;
      }
      as.l(as.this).c(as.a(as.this).a());
    }
  }

  private class aj extends as.f
  {
    public aj()
    {
      super();
    }
  }

  private class ak extends as.r
  {
    public ak()
    {
      super();
      this.c = true;
      if ((!as.a(as.this).ag()) && (as.a(as.this).o() != null) && (com.viber.voip.util.at.d(as.this.a, as.a(as.this).o())))
        this.j = true;
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_video);
    }
  }

  private class al extends as.a
    implements bc.b
  {
    public al(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) == null) || (!as.i(as.this).c));
      while ((as.a(as.this).g() == 0) && (as.d(as.this)))
        return;
      as.this.b.add(0, R.id.menu_message_view, this.a.ordinal(), R.string.menu_message_view);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }
  }

  private class am extends as.r
  {
    public am()
    {
      super();
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_video_ptt);
    }
  }

  private class an extends as.a
    implements bc.b
  {
    an(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.a(as.this).aS()) && (cd.b(as.b(as.this))));
      for (int i = 1; ; i = 0)
      {
        if ((as.i(as.this) != null) && (!as.a(as.this).as()) && (!as.a(as.this).at()) && ((!as.a(as.this).an()) || (!as.a(as.this).aV())) && (as.a(as.this).aq()) && ((as.a(as.this).bl()) || (i != 0)))
          as.this.b.add(0, R.id.menu_view_likes, this.a.ordinal(), R.string.message_info_title);
        return;
      }
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      paramj.a(as.a(as.this), as.l(as.this).ac(), as.b(as.this));
    }
  }

  private class ao extends as.r
  {
    public ao()
    {
      super();
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message);
    }
  }

  private class b extends as.a
    implements bc.b
  {
    private Action d;
    private boolean e;

    b(as.k arg2)
    {
      super(localk);
    }

    private b.a a(final boolean paramBoolean)
    {
      return new b.a()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          as.b.a(as.b.this, paramAnonymousBoolean);
          if (as.b.a(as.b.this))
            com.viber.voip.av.a(av.e.a).post(new Runnable()
            {
              public void run()
              {
                MenuItem localMenuItem = as.this.b.findItem(R.id.menu_block);
                if (as.b.1.this.a);
                for (int i = R.string.unblock; ; i = R.string.unblock_sender)
                {
                  localMenuItem.setTitle(i);
                  return;
                }
              }
            });
        }
      };
    }

    public void a()
    {
      if ((as.i(as.this) == null) || (!as.i(as.this).h));
      BlockTpaAction localBlockTpaAction;
      do
      {
        FormattedMessage localFormattedMessage;
        do
        {
          BlockPublicGroupAction localBlockPublicGroupAction;
          do
          {
            do
            {
              return;
              as.this.b.add(0, R.id.menu_block, this.a.ordinal(), R.string.block).setVisible(false);
              localFormattedMessage = as.a(as.this).L();
            }
            while ((ao.f()) || (localFormattedMessage == null));
            if (!localFormattedMessage.canDoAction(ActionType.BLOCK_PUBLIC_GROUP))
              break;
            localBlockPublicGroupAction = (BlockPublicGroupAction)localFormattedMessage.getAction(ActionType.BLOCK_PUBLIC_GROUP);
            this.d = localBlockPublicGroupAction;
          }
          while (localBlockPublicGroupAction == null);
          com.viber.voip.block.b.a().a(localBlockPublicGroupAction.getGroupId(), a(true));
          as.this.b.findItem(R.id.menu_block).setVisible(true);
          return;
        }
        while ((!d.g.a.d()) || (!localFormattedMessage.canDoAction(ActionType.BLOCK_TPA)));
        localBlockTpaAction = (BlockTpaAction)localFormattedMessage.getAction(ActionType.BLOCK_TPA);
        this.d = localBlockTpaAction;
      }
      while (localBlockTpaAction == null);
      com.viber.voip.block.b.a().a(localBlockTpaAction.getAppId(), a(false));
      as.this.b.findItem(R.id.menu_block).setTitle(R.string.block_sender).setVisible(true);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      com.viber.voip.block.o localo = new com.viber.voip.block.o(as.l(as.this).ag());
      if (this.d.getType() == ActionType.BLOCK_PUBLIC_GROUP)
        if (this.e)
          localo.a(((BlockPublicGroupAction)this.d).getGroupId(), as.a(as.this).ag());
      while (this.d.getType() != ActionType.BLOCK_TPA)
      {
        return;
        localo.a((BlockPublicGroupAction)this.d, as.a(as.this).ag());
        return;
      }
      int i = ((BlockTpaAction)this.d).getAppId();
      if (this.e)
      {
        localo.b(i, as.a(as.this).ag());
        return;
      }
      localo.a(i, as.a(as.this).ag());
    }
  }

  private class c extends as.r
  {
    public c()
    {
      super();
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.menu_call);
    }
  }

  private class d extends as.a
    implements bc.b
  {
    d(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((m.k(as.a(as.this).q())) && (as.a(as.this).ap()) && (as.a(as.this).aq()) && (!as.a(as.this).ba()) && (!as.a(as.this).aU()) && (!as.a(as.this).bN()) && (!as.a(as.this).V()) && (!as.a(as.this).aM()) && (!as.a(as.this).an()) && (!as.a(as.this).bO()))
        as.this.b.add(0, R.id.menu_edit, this.a.ordinal(), R.string.menu_contact_edit);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }
  }

  private class e extends as.r
  {
    public e()
    {
      super();
      if ((as.a(as.this).ao()) && (as.a(as.this).o() != null))
        as.this.a(R.id.menu_save_to_folder, new as.y(as.this, as.k.q));
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(as.a(as.this).h());
    }
  }

  private class f extends as.r
  {
    public f()
    {
      super();
      if ((!as.a(as.this).ag()) && (as.a(as.this).aL()))
        as.this.a(R.id.menu_save_link_to_favorites_bot, new as.z(as.this, as.k.c));
      if (as.a(as.this).aM())
      {
        String str = as.a(as.this).bx().getThumbnailUrl();
        File localFile1 = dv.u.b(as.this.a, str, false);
        File localFile2 = com.viber.voip.util.upload.o.a(str, 1005, as.this.a);
        boolean bool1 = as.a(as.this).ag();
        boolean bool2 = false;
        if (!bool1)
          bool2 = true;
        this.j = bool2;
        if ((!as.a(as.this).ag()) && (com.viber.voip.util.at.a(localFile1)) && (!com.viber.voip.util.at.a(localFile2)))
          as.this.a(R.id.menu_save_to_gallery, new as.aa(as.this, as.k.q));
      }
      if (as.a(as.this).af())
        as.this.a(R.id.menu_report_wallet, new as.w(as.this, as.k.q));
    }

    public void a(TextView paramTextView)
    {
      FormattedMessage localFormattedMessage = as.a(as.this).L();
      if (localFormattedMessage != null);
      for (String str = localFormattedMessage.getPreviewText(); ; str = "")
      {
        paramTextView.setText(str);
        return;
      }
    }
  }

  private class g extends as.a
    implements bc.b
  {
    g(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).g))
        as.this.b.add(0, R.id.menu_get_sticker, this.a.ordinal(), R.string.menu_get_sticker);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      StickerMarketActivity.b(com.viber.voip.stickers.c.g.f(com.viber.voip.stickers.i.a().u(as.a(as.this).r().toStickerId()).id), 3, "Chat", "Top");
    }
  }

  private class h extends as.r
  {
    public h()
    {
      super();
      if (as.a(as.this).o() != null)
        if ((as.a(as.this).ag()) || (!com.viber.voip.util.at.d(as.this.a, as.a(as.this).o())))
          break label150;
      label150: for (boolean bool = true; ; bool = false)
      {
        this.j = bool;
        if (as.a(as.this).ao())
        {
          File localFile1 = dv.u.b(as.this.a, as.a(as.this).C(), false);
          File localFile2 = com.viber.voip.util.upload.o.a(as.a(as.this).C(), as.a(as.this).q(), as.this.a);
          if ((!as.a(as.this).ag()) && (com.viber.voip.util.at.a(localFile1)) && (!com.viber.voip.util.at.a(localFile2)))
            as.this.a(R.id.menu_save_to_gallery, new as.aa(as.this, as.k.q));
        }
        return;
      }
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_gif);
    }
  }

  private class i extends as.r
  {
    public i()
    {
      super();
      this.c = true;
      if ((!as.a(as.this).ag()) && (as.a(as.this).o() != null) && (com.viber.voip.util.at.d(as.this.a, as.a(as.this).o())))
        this.j = true;
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_photo);
    }
  }

  private class j extends as.a
    implements bc.b
  {
    public j(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) == null) || (!as.i(as.this).c));
      while ((as.a(as.this).g() == 0) && (as.d(as.this)))
        return;
      as.this.b.add(0, R.id.menu_message_view, this.a.ordinal(), R.string.menu_message_view);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }
  }

  private static enum k
  {
    static
    {
      k[] arrayOfk = new k[18];
      arrayOfk[0] = a;
      arrayOfk[1] = b;
      arrayOfk[2] = c;
      arrayOfk[3] = d;
      arrayOfk[4] = e;
      arrayOfk[5] = f;
      arrayOfk[6] = g;
      arrayOfk[7] = h;
      arrayOfk[8] = i;
      arrayOfk[9] = j;
      arrayOfk[10] = k;
      arrayOfk[11] = l;
      arrayOfk[12] = m;
      arrayOfk[13] = n;
      arrayOfk[14] = o;
      arrayOfk[15] = p;
      arrayOfk[16] = q;
      arrayOfk[17] = r;
    }
  }

  private class l extends as.r
  {
    public l()
    {
      super();
      this.c = true;
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_location);
    }
  }

  private class m extends as.a
    implements bc.b
  {
    public m(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) == null) || (!as.i(as.this).c));
      while ((as.a(as.this).g() == 0) && (as.d(as.this)))
        return;
      as.this.b.add(0, R.id.menu_message_view, this.a.ordinal(), R.string.menu_message_view);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }
  }

  private class n extends as.a
    implements bc.b
  {
    public n(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).b) && (!as.j(as.this)) && (!as.a(as.this).an()))
        as.this.b.add(0, R.id.menu_message_copy, this.a.ordinal(), R.string.menu_message_copy);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      paramj.c(as.a(as.this));
    }
  }

  private class o extends as.a
    implements bc.b
  {
    public o(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((!as.a(as.this).aS()) && (!as.a(as.this).aU()) && (!as.e(as.this)) && (as.a(as.this).ap()) && (!as.a(as.this).as()) && (!as.a(as.this).at()) && (!as.a(as.this).av()) && (as.a(as.this).y() > 0L) && (!as.a(as.this).T()))
        as.this.b.add(0, R.id.menu_message_delete_all_copies, this.a.ordinal(), R.string.btn_msg_delete_for_everyone);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      ad.a(paramj, as.a(as.this).a(), as.a(as.this).aR()).b(as.l(as.this));
    }
  }

  private class p extends as.a
    implements bc.a
  {
    public p(as.k arg2)
    {
      super(localk);
    }

    private void b()
    {
      as.this.b.removeItem(R.id.menu_message_delete);
      as.this.b.removeItem(R.id.menu_message_delete_all_for_participant);
      as.this.b.removeGroup(R.id.menu_message_delete_submenu);
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).d))
      {
        b();
        if (!as.a(as.this).aV())
          break label338;
        if ((!cd.a(as.b(as.this), as.a(as.this).A(), as.k(as.this), as.a(as.this).ap())) || (as.a(as.this).as()) || (as.a(as.this).at()) || (!c.f.b.e()))
          break label280;
        localSubMenu = as.this.b.addSubMenu(0, R.id.menu_message_delete_submenu, this.a.ordinal(), R.string.btn_msg_delete);
        localSubMenu.add(0, R.id.menu_message_delete, 0, R.string.btn_msg_delete);
        localSpannableString = new SpannableString(as.this.a.getString(R.string.menu_delete_all_from_participant));
        localInteger = dj.a(as.this.a, R.attr.chatInfoTextRoseColor);
        if (localInteger == null)
          localInteger = Integer.valueOf(ContextCompat.getColor(as.this.a, R.color.red));
        localSpannableString.setSpan(new ForegroundColorSpan(localInteger.intValue()), 0, localSpannableString.length(), 33);
        localMenuItem = localSubMenu.add(0, R.id.menu_message_delete_all_for_participant, 0, localSpannableString);
        if (!com.viber.common.d.a.c())
          localMenuItem.setTitleCondensed(localSpannableString.toString());
      }
      label280: 
      while (!cd.a(as.b(as.this), as.a(as.this).ap(), as.k(as.this)))
      {
        SubMenu localSubMenu;
        SpannableString localSpannableString;
        Integer localInteger;
        MenuItem localMenuItem;
        return;
      }
      as.this.b.add(0, R.id.menu_message_delete, this.a.ordinal(), R.string.btn_msg_delete);
      return;
      label338: ContextMenu localContextMenu = as.this.b;
      int i = R.id.menu_message_delete;
      int j = this.a.ordinal();
      if (as.a(as.this).aS());
      for (int k = R.string.btn_msg_delete; ; k = R.string.btn_msg_delete_for_myself)
      {
        localContextMenu.add(0, i, j, k);
        return;
      }
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj, int paramInt)
    {
      if (paramInt == R.id.menu_message_delete)
        if (as.a(as.this).aS())
        {
          ad.a(paramj, as.a(as.this).a()).b(as.l(as.this));
          if ((com.viber.voip.analytics.a.j.a(as.a(as.this))) && (!as.a(as.this).aU()))
            com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.d(as.a(as.this).aR()));
        }
      while (paramInt != R.id.menu_message_delete_all_for_participant)
        while (true)
        {
          return;
          paramj.a(Collections.singletonList(Long.valueOf(as.a(as.this).a())), false);
        }
      if ((as.a(as.this).bH()) || (!cd.a(as.b(as.this), as.a(as.this).bG(), as.a(as.this).A())))
      {
        Resources localResources = as.l(as.this).getResources();
        int i = R.string.dialog_1029_body;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = as.a(as.this).c(as.b(as.this));
        String str = localResources.getString(i, arrayOfObject);
        ad.a(new e.b(as.a(as.this)), str).a(as.l(as.this)).b(as.l(as.this));
        return;
      }
      com.viber.voip.ui.dialogs.d.a(new e.b(as.a(as.this)), as.a(as.this).c(as.b(as.this))).a(as.l(as.this)).b(as.l(as.this));
    }
  }

  private class q extends as.a
    implements bc.c
  {
    q(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).f) && (!as.j(as.this)))
        as.this.b.add(0, R.id.menu_message_forward, this.a.ordinal(), R.string.menu_map_forward);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }

    public String[] b()
    {
      return n.m;
    }

    public int c()
    {
      return 139;
    }
  }

  private abstract class r
  {
    public boolean b;
    public boolean c;
    public boolean d = m.a(as.a(as.this), as.b(as.this), as.c(as.this));
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;

    protected r()
    {
      if (((as.a(as.this).aT()) && (as.a(as.this).Z())) || (((as.d(as.this)) || ((as.a(as.this).U()) && (!as.a(as.this).aV())) || ((as.a(as.this).V()) && (as.a(as.this).aZ()))) && (as.a(as.this).g() == 0)))
        this.e = bool1;
      this.h = bool1;
      this.i = false;
      this.b = as.a(as.this).bh();
      this.f = as.a(as.this).bi();
      boolean bool2;
      if ((as.a(as.this).bj()) && (as.c(as.this).canWrite()) && (!as.d(as.this)) && (!as.e(as.this)) && (!as.f(as.this)) && (!as.g(as.this)) && (!as.h(as.this)))
      {
        bool2 = bool1;
        this.k = bool2;
        if ((as.d(as.this)) || (as.e(as.this)) || (as.f(as.this)) || (as.g(as.this)) || (!as.a(as.this).b(as.b(as.this))))
          break label261;
      }
      while (true)
      {
        this.l = bool1;
        return;
        bool2 = false;
        break;
        label261: bool1 = false;
      }
    }

    public abstract void a(TextView paramTextView);
  }

  private class s extends as.r
  {
    public s()
    {
      super();
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_notification);
    }
  }

  private class t extends as.a
    implements bc.b
  {
    t(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((c.h.d.e()) && (as.i(as.this) != null) && (as.i(as.this).l))
        as.this.b.add(0, R.id.menu_pin, this.a.ordinal(), R.string.pin);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      TextMetaInfo[] arrayOfTextMetaInfo = null;
      String str;
      if (as.a(as.this).aM())
        str = as.this.a.getString(R.string.message_type_gif);
      while (true)
      {
        Pin localPin = new Pin();
        localPin.setMediaType(com.viber.voip.messages.l.b(as.a(as.this).q()));
        localPin.setText(str);
        localPin.setToken(as.a(as.this).y());
        localPin.setSeqInPG(as.a(as.this).F());
        localPin.setAction(Pin.a.CREATE);
        localPin.setTextMetaInfo(arrayOfTextMetaInfo);
        localPin.setFlags(com.viber.voip.util.av.b(localPin.getFlags(), 1, as.a(as.this).an()));
        com.viber.voip.ui.dialogs.l.a(paramj, localPin).b(as.l(as.this));
        return;
        if ((as.a(as.this).aE()) && (!as.a(as.this).aF()))
        {
          str = as.a(as.this).L().getPreviewText();
          arrayOfTextMetaInfo = null;
        }
        else
        {
          str = com.viber.voip.messages.c.b.a(as.a(as.this).q(), as.a(as.this).h());
          arrayOfTextMetaInfo = as.a(as.this).bx().getTextMetaInfo();
        }
      }
    }
  }

  private class u extends as.a
    implements bc.b
  {
    u(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).k) && (!as.q(as.this)) && (!as.r(as.this)))
        as.this.b.add(0, R.id.menu_reply, this.a.ordinal(), R.string.context_menu_reply_option);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }
  }

  private class v extends as.a
    implements bc.b
  {
    public v(as.k arg2)
    {
      super(localk);
    }

    private String a(long paramLong)
    {
      return a(ab.b().d(paramLong));
    }

    private String a(r paramr)
    {
      Object localObject = null;
      if (paramr != null);
      try
      {
        String str = URLEncoder.encode(paramr.d(), "UTF-8");
        localObject = str;
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
      return null;
    }

    private String a(String paramString)
    {
      return a(ab.b().a(paramString));
    }

    public void a()
    {
      if ((as.i(as.this) != null) && (as.i(as.this).e))
        as.this.b.add(0, R.id.menu_report_message, this.a.ordinal(), R.string.report_message);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      final aa localaa = as.a(as.this);
      com.viber.voip.av.a(av.e.f).post(new Runnable()
      {
        // ERROR //
        public void run()
        {
          // Byte code:
          //   0: iconst_0
          //   1: istore_1
          //   2: aconst_null
          //   3: astore_2
          //   4: aload_0
          //   5: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   8: invokevirtual 32	com/viber/voip/messages/conversation/aa:aZ	()Z
          //   11: istore_3
          //   12: lconst_0
          //   13: lstore 4
          //   15: iconst_1
          //   16: istore 6
          //   18: aload_0
          //   19: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   22: getfield 36	com/viber/voip/messages/ui/as$v:c	Lcom/viber/voip/messages/ui/as;
          //   25: getfield 41	com/viber/voip/messages/ui/as:a	Landroid/app/Activity;
          //   28: invokestatic 47	com/viber/voip/user/UserManager:from	(Landroid/content/Context;)Lcom/viber/voip/user/UserManager;
          //   31: invokevirtual 51	com/viber/voip/user/UserManager:getRegistrationValues	()Lcom/viber/voip/registration/af;
          //   34: invokevirtual 57	com/viber/voip/registration/af:l	()Ljava/lang/String;
          //   37: ldc 59
          //   39: invokestatic 65	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   42: astore 24
          //   44: aload 24
          //   46: astore 11
          //   48: aload_0
          //   49: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   52: invokevirtual 68	com/viber/voip/messages/conversation/aa:aS	()Z
          //   55: ifeq +232 -> 287
          //   58: aload_0
          //   59: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   62: invokevirtual 72	com/viber/voip/messages/conversation/aa:F	()I
          //   65: istore 43
          //   67: iload 43
          //   69: i2l
          //   70: lstore 12
          //   72: iload_3
          //   73: ifeq +272 -> 345
          //   76: aload_0
          //   77: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   80: invokevirtual 76	com/viber/voip/messages/conversation/aa:bx	()Lcom/viber/voip/flatbuffers/model/msginfo/MsgInfo;
          //   83: invokevirtual 82	com/viber/voip/flatbuffers/model/msginfo/MsgInfo:getPublicAccountMsgInfo	()Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountMsgInfo;
          //   86: invokevirtual 88	com/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountMsgInfo:getPublicAccountInfo	()Lcom/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountInfo;
          //   89: astore 40
          //   91: aload 40
          //   93: ifnull +210 -> 303
          //   96: aload 40
          //   98: invokevirtual 93	com/viber/voip/flatbuffers/model/msginfo/publicaccount/PublicAccountInfo:getUri	()Ljava/lang/String;
          //   101: astore 41
          //   103: aload 41
          //   105: astore 15
          //   107: aload 15
          //   109: invokestatic 98	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
          //   112: ifeq +19 -> 131
          //   115: aload_0
          //   116: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   119: aload_0
          //   120: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   123: invokevirtual 101	com/viber/voip/messages/conversation/aa:d	()Ljava/lang/String;
          //   126: invokestatic 104	com/viber/voip/messages/ui/as$v:a	(Lcom/viber/voip/messages/ui/as$v;Ljava/lang/String;)Ljava/lang/String;
          //   129: astore 15
          //   131: aload 15
          //   133: invokestatic 98	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
          //   136: ifne +199 -> 335
          //   139: aload_0
          //   140: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   143: invokevirtual 107	com/viber/voip/messages/conversation/aa:U	()Z
          //   146: ifeq +163 -> 309
          //   149: ldc 109
          //   151: astore_2
          //   152: iload 6
          //   154: ifeq +132 -> 286
          //   157: new 111	java/lang/StringBuilder
          //   160: dup
          //   161: ldc 113
          //   163: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   166: astore 16
          //   168: aload 16
          //   170: sipush 902
          //   173: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   176: pop
          //   177: aload 16
          //   179: ldc 122
          //   181: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   184: aload_2
          //   185: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   188: pop
          //   189: aload 16
          //   191: ldc 127
          //   193: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   196: lload 12
          //   198: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   201: pop
          //   202: aload 16
          //   204: ldc 132
          //   206: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   209: aload 11
          //   211: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   214: pop
          //   215: aload 16
          //   217: ldc 134
          //   219: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   222: aload 15
          //   224: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   227: pop
          //   228: aload 16
          //   230: ldc 136
          //   232: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   235: pop
          //   236: aload_0
          //   237: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   240: getfield 36	com/viber/voip/messages/ui/as$v:c	Lcom/viber/voip/messages/ui/as;
          //   243: invokestatic 139	com/viber/voip/messages/ui/as:d	(Lcom/viber/voip/messages/ui/as;)Z
          //   246: ifeq +10 -> 256
          //   249: aload 16
          //   251: iload_1
          //   252: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   255: pop
          //   256: aload_0
          //   257: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   260: getfield 36	com/viber/voip/messages/ui/as$v:c	Lcom/viber/voip/messages/ui/as;
          //   263: getfield 41	com/viber/voip/messages/ui/as:a	Landroid/app/Activity;
          //   266: new 141	android/content/Intent
          //   269: dup
          //   270: ldc 143
          //   272: aload 16
          //   274: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   277: invokestatic 152	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   280: invokespecial 155	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   283: invokevirtual 161	android/app/Activity:startActivity	(Landroid/content/Intent;)V
          //   286: return
          //   287: aload_0
          //   288: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   291: invokevirtual 165	com/viber/voip/messages/conversation/aa:y	()J
          //   294: lstore 26
          //   296: lload 26
          //   298: lstore 12
          //   300: goto -228 -> 72
          //   303: aconst_null
          //   304: astore 15
          //   306: goto -199 -> 107
          //   309: aload_0
          //   310: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   313: invokevirtual 168	com/viber/voip/messages/conversation/aa:aR	()Z
          //   316: ifeq +11 -> 327
          //   319: ldc 170
          //   321: astore_2
          //   322: iconst_0
          //   323: istore_1
          //   324: goto -172 -> 152
          //   327: ldc 172
          //   329: astore_2
          //   330: iconst_0
          //   331: istore_1
          //   332: goto -180 -> 152
          //   335: iconst_0
          //   336: istore 6
          //   338: iconst_0
          //   339: istore_1
          //   340: aconst_null
          //   341: astore_2
          //   342: goto -190 -> 152
          //   345: aload_0
          //   346: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   349: getfield 36	com/viber/voip/messages/ui/as$v:c	Lcom/viber/voip/messages/ui/as;
          //   352: invokestatic 139	com/viber/voip/messages/ui/as:d	(Lcom/viber/voip/messages/ui/as;)Z
          //   355: ifeq +45 -> 400
          //   358: aload_0
          //   359: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   362: getfield 36	com/viber/voip/messages/ui/as$v:c	Lcom/viber/voip/messages/ui/as;
          //   365: invokestatic 176	com/viber/voip/messages/ui/as:m	(Lcom/viber/voip/messages/ui/as;)I
          //   368: istore 36
          //   370: iload 36
          //   372: istore 8
          //   374: aload_0
          //   375: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   378: invokevirtual 179	com/viber/voip/messages/conversation/aa:bp	()Ljava/lang/String;
          //   381: astore 38
          //   383: ldc 181
          //   385: astore_2
          //   386: iload 8
          //   388: istore 39
          //   390: aload 38
          //   392: astore 15
          //   394: iload 39
          //   396: istore_1
          //   397: goto -245 -> 152
          //   400: aload_0
          //   401: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   404: getfield 36	com/viber/voip/messages/ui/as$v:c	Lcom/viber/voip/messages/ui/as;
          //   407: invokestatic 184	com/viber/voip/messages/ui/as:a	(Lcom/viber/voip/messages/ui/as;)Lcom/viber/voip/messages/conversation/aa;
          //   410: invokevirtual 107	com/viber/voip/messages/conversation/aa:U	()Z
          //   413: ifeq +39 -> 452
          //   416: ldc 186
          //   418: astore 29
          //   420: aload_0
          //   421: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   424: aload_0
          //   425: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   428: invokevirtual 101	com/viber/voip/messages/conversation/aa:d	()Ljava/lang/String;
          //   431: invokestatic 104	com/viber/voip/messages/ui/as$v:a	(Lcom/viber/voip/messages/ui/as$v;Ljava/lang/String;)Ljava/lang/String;
          //   434: astore 31
          //   436: aload 29
          //   438: astore 32
          //   440: aload 31
          //   442: astore 15
          //   444: aload 32
          //   446: astore_2
          //   447: iconst_0
          //   448: istore_1
          //   449: goto -297 -> 152
          //   452: ldc 188
          //   454: astore 29
          //   456: aload_0
          //   457: getfield 18	com/viber/voip/messages/ui/as$v$1:b	Lcom/viber/voip/messages/ui/as$v;
          //   460: aload_0
          //   461: getfield 20	com/viber/voip/messages/ui/as$v$1:a	Lcom/viber/voip/messages/conversation/aa;
          //   464: invokevirtual 190	com/viber/voip/messages/conversation/aa:c	()J
          //   467: invokestatic 193	com/viber/voip/messages/ui/as$v:a	(Lcom/viber/voip/messages/ui/as$v;J)Ljava/lang/String;
          //   470: astore 33
          //   472: aload 29
          //   474: astore 34
          //   476: aload 33
          //   478: astore 15
          //   480: aload 34
          //   482: astore_2
          //   483: iconst_0
          //   484: istore_1
          //   485: goto -333 -> 152
          //   488: astore 7
          //   490: iconst_0
          //   491: istore 8
          //   493: aconst_null
          //   494: astore 9
          //   496: aconst_null
          //   497: astore 10
          //   499: aload 10
          //   501: astore 11
          //   503: lload 4
          //   505: lstore 12
          //   507: iload 8
          //   509: istore 14
          //   511: aload 9
          //   513: astore 15
          //   515: iload 14
          //   517: istore_1
          //   518: iconst_0
          //   519: istore 6
          //   521: goto -369 -> 152
          //   524: astore 25
          //   526: aload 11
          //   528: astore 10
          //   530: aconst_null
          //   531: astore 9
          //   533: aconst_null
          //   534: astore_2
          //   535: iconst_0
          //   536: istore 8
          //   538: goto -39 -> 499
          //   541: astore 28
          //   543: lload 12
          //   545: lstore 4
          //   547: aload 11
          //   549: astore 10
          //   551: aconst_null
          //   552: astore 9
          //   554: aconst_null
          //   555: astore_2
          //   556: iconst_0
          //   557: istore 8
          //   559: goto -60 -> 499
          //   562: astore 42
          //   564: lload 12
          //   566: lstore 4
          //   568: aload 15
          //   570: astore 9
          //   572: aload 11
          //   574: astore 10
          //   576: aconst_null
          //   577: astore_2
          //   578: iconst_0
          //   579: istore 8
          //   581: goto -82 -> 499
          //   584: astore 35
          //   586: ldc 181
          //   588: astore_2
          //   589: lload 12
          //   591: lstore 4
          //   593: aload 11
          //   595: astore 10
          //   597: aconst_null
          //   598: astore 9
          //   600: iconst_0
          //   601: istore 8
          //   603: goto -104 -> 499
          //   606: astore 37
          //   608: ldc 181
          //   610: astore_2
          //   611: lload 12
          //   613: lstore 4
          //   615: aload 11
          //   617: astore 10
          //   619: aconst_null
          //   620: astore 9
          //   622: goto -123 -> 499
          //   625: astore 30
          //   627: lload 12
          //   629: lstore 4
          //   631: aload 29
          //   633: astore_2
          //   634: aload 11
          //   636: astore 10
          //   638: aconst_null
          //   639: astore 9
          //   641: iconst_0
          //   642: istore 8
          //   644: goto -145 -> 499
          //
          // Exception table:
          //   from	to	target	type
          //   18	44	488	java/lang/Exception
          //   48	67	524	java/lang/Exception
          //   287	296	524	java/lang/Exception
          //   76	91	541	java/lang/Exception
          //   96	103	541	java/lang/Exception
          //   345	358	541	java/lang/Exception
          //   400	416	541	java/lang/Exception
          //   107	131	562	java/lang/Exception
          //   131	149	562	java/lang/Exception
          //   309	319	562	java/lang/Exception
          //   358	370	584	java/lang/Exception
          //   374	383	606	java/lang/Exception
          //   420	436	625	java/lang/Exception
          //   456	472	625	java/lang/Exception
        }
      });
    }
  }

  private class w extends as.a
    implements bc.b
  {
    w(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      as.this.b.add(0, R.id.menu_report_wallet, this.a.ordinal(), R.string.menu_report);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      aa localaa = as.a(as.this);
      try
      {
        String str3 = URLEncoder.encode(UserManager.from(as.this.a).getRegistrationValues().n(), "UTF-8");
        str2 = str3;
      }
      catch (Exception localException1)
      {
        try
        {
          String str2;
          String str4 = URLEncoder.encode(localaa.d(), "UTF-8");
          str1 = str4;
          while (true)
          {
            if ((!da.a(str2)) && (!da.a(str1)))
            {
              StringBuilder localStringBuilder = new StringBuilder("https://www.viber.com/messages/reports?type=WL-MSG");
              localStringBuilder.append("&reporter=").append(str2);
              localStringBuilder.append("&reportee=").append(str1);
              GenericWebViewActivity.a(as.this.a, localStringBuilder.toString(), as.this.a.getString(R.string.menu_report));
            }
            return;
            localException1 = localException1;
            str1 = null;
            str2 = null;
          }
        }
        catch (Exception localException2)
        {
          while (true)
            String str1 = null;
        }
      }
    }
  }

  private class x extends as.r
  {
    public x()
    {
      super();
      if (a())
        as.this.a(R.id.menu_save_link_to_favorites_bot, new as.z(as.this, as.k.c));
    }

    private boolean a()
    {
      BotReplyConfig localBotReplyConfig = new com.viber.voip.flatbuffers.b.c.d().c(as.a(as.this).bw()).getPublicAccountMsgInfo().getRichMedia();
      return (localBotReplyConfig != null) && (!da.a(localBotReplyConfig.getFavoritesMetadata().getMetadata()));
    }

    public void a(TextView paramTextView)
    {
      paramTextView.setText(R.string.message_type_rich_message);
    }
  }

  private class y extends as.a
    implements bc.c
  {
    y(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      as.this.b.add(0, R.id.menu_save_to_folder, this.a.ordinal(), R.string.menu_message_save_to_folder);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
    }

    public String[] b()
    {
      return n.m;
    }

    public int c()
    {
      return 136;
    }
  }

  private class z extends as.a
    implements bc.b
  {
    z(as.k arg2)
    {
      super(localk);
    }

    public void a()
    {
      if (as.n(as.this).f())
        as.this.b.add(0, R.id.menu_save_link_to_favorites_bot, this.a.ordinal(), R.string.menu_save_to_favorites);
    }

    public void a(com.viber.voip.messages.conversation.ui.j paramj)
    {
      MsgInfo localMsgInfo = new com.viber.voip.flatbuffers.b.c.d().c(as.a(as.this).bw());
      BotFavoriteLinksCommunicator.SaveLinkActionMessage.a locala = BotFavoriteLinksCommunicator.SaveLinkActionMessage.builder();
      if (as.a(as.this).aZ())
        locala.a(localMsgInfo.getPublicAccountMsgInfo().getRichMedia());
      while (true)
      {
        if (System.currentTimeMillis() - 0L <= as.b())
          locala.b(true);
        boolean bool = m.a(as.a(as.this).A(), as.a(as.this).d(), null);
        BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = locala.e(as.n(as.this).e()).a(1).h(StoryConstants.v.a.a(as.a(as.this))).i(StoryConstants.g.a.a(as.a(as.this), bool)).b();
        ViberApplication.getInstance().getMessagesManager().t().a().a(localSaveLinkActionMessage);
        com.viber.voip.analytics.story.e.c localc = (com.viber.voip.analytics.story.e.c)ViberApplication.getInstance().getLazyMessagesTracker().get();
        av.f.d.execute(new at(localc, localSaveLinkActionMessage));
        return;
        if (as.a(as.this).aO())
        {
          locala.a(localMsgInfo.getUrl()).b(localMsgInfo.getTitle()).c(localMsgInfo.getThumbnailUrl()).g("video").c(true);
        }
        else if (as.a(as.this).aM())
        {
          locala.a(localMsgInfo.getUrl()).g("gif").a(localMsgInfo.getThumbnailWidth(), localMsgInfo.getThumbnailHeight());
        }
        else
        {
          locala.a(localMsgInfo.getUrl()).b(localMsgInfo.getTitle()).c(localMsgInfo.getThumbnailUrl());
          if (!as.a(as.this).aN())
            locala.c(true);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.as
 * JD-Core Version:    0.6.2
 */