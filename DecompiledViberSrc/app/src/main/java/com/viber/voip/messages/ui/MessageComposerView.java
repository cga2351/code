package com.viber.voip.messages.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.TextKeyListener;
import android.text.method.TextKeyListener.Capitalize;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.array;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.action.OpenChatExtensionAction.Description;
import com.viber.voip.av.e;
import com.viber.voip.block.g.a;
import com.viber.voip.camrecorder.preview.l.a;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.msginfo.CommunityScreenshot;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.i.c.k;
import com.viber.voip.i.c.m;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.MessageEditText;
import com.viber.voip.messages.a.l.c;
import com.viber.voip.messages.controller.ai.g;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.bu;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extensions.ui.o.a;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.j;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.d.a.a;
import com.viber.voip.messages.ui.d.d.a;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.c;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.messages.ui.view.VideoPttRecordView;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.n;
import com.viber.voip.settings.d.r;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.sound.tones.SampleTone;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.u.a.f.a;
import com.viber.voip.u.a.f.c;
import com.viber.voip.ui.dialogs.ah;
import com.viber.voip.util.bj;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;
import com.viber.voip.util.u;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.widget.ac.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

public class MessageComposerView extends RelativeLayout
  implements View.OnClickListener, bx, d.h, a.a, d.a, ExpandablePanelLayout.c, x.b
{
  public static boolean a;
  public static int b;
  private static final Logger c = ViberEnv.getLogger();
  private static Pair<Long, Pair<List<SendMediaDataContainer>, Bundle>> n;
  private com.viber.voip.camrecorder.preview.l A;
  private com.viber.voip.messages.b.a.c B;
  private com.viber.voip.messages.a C;
  private i D;
  private int E = 1;
  private z F;
  private com.viber.voip.messages.controller.publicaccount.b G;
  private com.viber.voip.messages.ui.media.player.c H;
  private com.viber.voip.messages.extensions.c I;
  private dagger.a<com.viber.voip.messages.extensions.d.b> J;
  private LayoutInflater K;
  private Handler L;
  private com.viber.voip.messages.extensions.d.d M;
  private com.viber.voip.analytics.g N;
  private com.viber.voip.analytics.story.e.c O;
  private com.viber.voip.analytics.story.f.d P;
  private ConversationItemLoaderEntity Q;
  private com.viber.voip.messages.conversation.ab R;
  private int S = 0;
  private p T = new p(this.h, ViberApplication.getInstance().getMessagesManager().h())
  {
    public boolean b()
    {
      return MessageComposerView.b(MessageComposerView.this).g();
    }

    public void c()
    {
      String str = d.n.d.d();
      MessageComposerView.this.a(str, MessageComposerView.g(MessageComposerView.this).a(str));
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (paramAnonymousInt2 != paramAnonymousInt3)
        MessageComposerView.g(MessageComposerView.this).u();
      super.onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
    }
  };
  private final com.viber.voip.messages.c.a U = new com.viber.voip.messages.c.a()
  {
    public void a()
    {
      MessageComposerView.this.g().a();
      MessageComposerView.this.q();
    }

    public void b()
    {
      if (MessageComposerView.e(MessageComposerView.this) != null)
        MessageComposerView.e(MessageComposerView.this).setReplyBannerDraft("");
      MessageComposerView.this.g().a();
      MessageComposerView.this.q();
    }
  };
  private c d;
  private k e;
  private Context f;
  private com.viber.voip.messages.h g;
  private Handler h = av.e.a.a();
  private MessageEditText i;
  private TextView j;
  private a k;
  private com.viber.common.ui.c l;
  private Runnable m;
  private ai o;
  private com.viber.voip.messages.d.b p;
  private boolean q;
  private com.viber.common.permission.c r;
  private com.viber.common.permission.b s;
  private com.viber.voip.messages.extensions.ui.o t;
  private com.viber.voip.messages.c.a.a u;
  private com.viber.voip.messages.ui.c.b v;
  private ViewStub w;
  private VideoPttRecordView x;
  private com.viber.voip.u.a.f y;
  private f.c z;

  public MessageComposerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public MessageComposerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public MessageComposerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private com.viber.voip.messages.a A()
  {
    if (this.C == null)
      this.C = new com.viber.voip.messages.g();
    return this.C;
  }

  private boolean B()
  {
    return (!C()) && (com.viber.voip.messages.d.a.b(this.Q));
  }

  private boolean C()
  {
    return this.q;
  }

  private boolean D()
  {
    boolean bool1 = ViberApplication.isTablet(getContext());
    boolean bool2 = dj.c(getContext());
    return ((!bool1) || (bool2)) && (this.S != 0);
  }

  private void a(int paramInt1, int paramInt2)
  {
    MessageEntity localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramInt2, this.Q.getGroupId(), this.Q.getConversationType(), System.currentTimeMillis(), this.Q.getParticipantMemberId(), 16, 0L, j.a(paramInt1), 0, 1000);
    localMessageEntity.addExtraFlag(27);
    b(localMessageEntity, false, null);
  }

  private void a(Context paramContext)
  {
    if (isInEditMode())
      return;
    ViberApplication localViberApplication = ViberApplication.getInstance();
    Engine localEngine = localViberApplication.getEngine(false);
    this.H = new com.viber.voip.messages.ui.media.player.c(localEngine, localEngine.getDelegatesManager().getDialerPhoneStateListener(), new au(this));
    this.H.a();
    this.o = new ai(paramContext);
    this.p = com.viber.voip.messages.d.c.c();
    this.I = localViberApplication.getChatExtensionConfig();
    this.J = localViberApplication.getChatExSuggestionsManager();
    this.r = com.viber.common.permission.c.a(paramContext);
    this.f = paramContext;
    this.K = LayoutInflater.from(getContext());
    this.K.inflate(R.layout.message_composer_view, this);
    Context localContext = this.f;
    Pair[] arrayOfPair = new Pair[6];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(15);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(26);
    arrayOfPair[2] = com.viber.voip.permissions.m.a(27);
    arrayOfPair[3] = com.viber.voip.permissions.m.a(81);
    arrayOfPair[4] = com.viber.voip.permissions.m.a(103);
    arrayOfPair[5] = com.viber.voip.permissions.m.a(132);
    this.s = new com.viber.voip.permissions.f(localContext, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 15:
        case 81:
        case 103:
        case 132:
        }
        do
        {
          do
          {
            do
            {
              do
                return;
              while (MessageComposerView.a(MessageComposerView.this) == null);
              MessageComposerView.a(MessageComposerView.this).f();
              return;
            }
            while (MessageComposerView.a(MessageComposerView.this) == null);
            MessageComposerView.a(MessageComposerView.this).H_();
            return;
          }
          while (MessageComposerView.a(MessageComposerView.this) == null);
          MessageComposerView.a(MessageComposerView.this).j();
          return;
        }
        while (MessageComposerView.a(MessageComposerView.this) == null);
        MessageComposerView.a(MessageComposerView.this).e();
      }
    };
    this.k = new a(ViberApplication.isTablet(paramContext));
    this.k.a();
    this.i = ((MessageEditText)findViewById(R.id.send_text));
    this.j = ((TextView)findViewById(R.id.btn_time_bomb));
    this.j.setOnClickListener(this);
    if (paramContext.getResources().getConfiguration().fontScale > 1.0F);
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
        this.i.setTextSize(2, 14.0F);
      this.i.addTextChangedListener(this.T);
      this.i.addTextChangedListener(new ak(aj.b(), this.i));
      this.M = new com.viber.voip.messages.extensions.d.d(this.h, this.i, (com.viber.voip.messages.extensions.d.b)this.J.get(), this.I, this.k);
      this.M.b();
      this.i.setEditTextContextMenuCallback(new com.viber.voip.messages.g());
      if ((com.viber.common.d.a.k()) && (com.viber.common.d.c.a()))
        this.i.setGravity(21);
      this.i.setKeyListener(new TextKeyListener(TextKeyListener.Capitalize.SENTENCES, true));
      this.i.setOnClickListener(this);
      this.i.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          MessageComposerView.b(MessageComposerView.this).f(paramAnonymousBoolean);
          if ((paramAnonymousBoolean) && (MessageComposerView.c(MessageComposerView.this) != null))
            MessageComposerView.c(MessageComposerView.this).a();
        }
      });
      this.i.setOnSelectionChangedListener(new ac.a()
      {
        public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          Editable localEditable = MessageComposerView.d(MessageComposerView.this).getText();
          ImageSpan[] arrayOfImageSpan1;
          if ((paramAnonymousInt1 == paramAnonymousInt2) && (paramAnonymousInt1 > 0) && (paramAnonymousInt1 < localEditable.length()))
          {
            int i = paramAnonymousInt1 - 1;
            arrayOfImageSpan1 = (ImageSpan[])localEditable.getSpans(i, i, ImageSpan.class);
            if (arrayOfImageSpan1.length <= 0)
              break label140;
          }
          label134: label140: for (ImageSpan localImageSpan1 = arrayOfImageSpan1[0]; ; localImageSpan1 = null)
          {
            ImageSpan[] arrayOfImageSpan2;
            if (localImageSpan1 != null)
            {
              int j = paramAnonymousInt1 + 1;
              arrayOfImageSpan2 = (ImageSpan[])localEditable.getSpans(j, j, ImageSpan.class);
              if (arrayOfImageSpan2.length <= 0)
                break label134;
            }
            for (ImageSpan localImageSpan2 = arrayOfImageSpan2[0]; ; localImageSpan2 = null)
            {
              if (localImageSpan1 == localImageSpan2)
                MessageComposerView.d(MessageComposerView.this).setSelection(localEditable.getSpanStart(localImageSpan1));
              return;
            }
          }
        }
      });
      this.L = av.e.e.a();
      this.G = new com.viber.voip.messages.controller.publicaccount.b(this.f, this.r, this.I);
      this.N = com.viber.voip.analytics.g.a();
      this.O = this.N.c().g();
      this.P = this.N.c().b();
      return;
    }
  }

  private void a(final MessageEntity paramMessageEntity, final Bundle paramBundle)
  {
    if (this.R != null)
      this.h.post(new Runnable()
      {
        public void run()
        {
          if (paramMessageEntity.isVideoPttBehavior())
          {
            MessageComposerView.h(MessageComposerView.this).a(new f.a()
            {
              public void a(int paramAnonymous2Int)
              {
              }

              public void s()
              {
              }

              public void t()
              {
                MessageComposerView.h(MessageComposerView.this).b(this);
                MessageComposerView.i(MessageComposerView.this).c();
                MessageComposerView.b(MessageComposerView.this).s();
              }
            });
            MessageComposerView.k(MessageComposerView.this).a(paramMessageEntity, paramBundle, MessageComposerView.j(MessageComposerView.this));
            return;
          }
          if ((paramMessageEntity.isVoiceMessage()) && (MessageComposerView.this.getSendButton().getState() == 8))
          {
            if (MessageComposerView.a(MessageComposerView.this) != null)
              MessageComposerView.a(MessageComposerView.this).a(paramMessageEntity);
            MessageComposerView.this.a(paramMessageEntity);
            return;
          }
          if (paramMessageEntity.isVoiceMessage())
            MessageComposerView.l(MessageComposerView.this).post(new ay(this, paramMessageEntity));
          com.viber.voip.messages.conversation.ab localab = MessageComposerView.k(MessageComposerView.this);
          MessageEntity[] arrayOfMessageEntity = new MessageEntity[1];
          arrayOfMessageEntity[0] = paramMessageEntity;
          localab.a(arrayOfMessageEntity, paramBundle);
        }
      });
  }

  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i1;
    Drawable localDrawable1;
    if (paramBoolean1)
    {
      i1 = 0;
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
      if (MarginLayoutParamsCompat.getMarginEnd(localMarginLayoutParams) != i1)
      {
        MarginLayoutParamsCompat.setMarginEnd(localMarginLayoutParams, i1);
        this.i.setLayoutParams(localMarginLayoutParams);
      }
      if (paramBoolean1)
      {
        if (paramInt <= 0)
          break label153;
        localDrawable1 = ContextCompat.getDrawable(getContext(), R.drawable.ic_timer_on);
        this.j.setText(com.viber.voip.util.ae.a(getContext(), paramInt));
      }
    }
    while (true)
    {
      Drawable localDrawable2 = df.a(localDrawable1, dc.d(getContext(), R.attr.conversationComposeTimeBombTextColor), false);
      this.j.setCompoundDrawablesWithIntrinsicBounds(localDrawable2, null, null, null);
      if ((paramBoolean2) && (this.A != null))
        this.A.a(paramInt);
      dj.b(this.j, paramBoolean1);
      return;
      i1 = getResources().getDimensionPixelOffset(R.dimen.composer_textfield_right_margin);
      break;
      label153: localDrawable1 = ContextCompat.getDrawable(getContext(), R.drawable.ic_timer_off);
      this.j.setText(R.string.timebomb_off);
    }
  }

  private void b(MessageEntity paramMessageEntity)
  {
    if (com.viber.voip.messages.controller.manager.ab.b().f(paramMessageEntity.getConversationId()) != null)
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportVoiceMessage((int)TimeUnit.MILLISECONDS.toSeconds(paramMessageEntity.getDuration()), 1, 2);
  }

  private void b(Runnable paramRunnable)
  {
    this.m = paramRunnable;
    if (this.g != null)
    {
      this.m.run();
      this.m = null;
    }
  }

  private boolean b(String paramString)
  {
    return (paramString == null) || (da.a(da.l(paramString)));
  }

  private void c(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity != null) && (this.u != null) && (this.u.a()))
      d(paramMessageEntity);
  }

  private void d(MessageEntity paramMessageEntity)
  {
    Quote localQuote = getReplyBannerViewController().c();
    if (localQuote == null)
      return;
    com.viber.voip.messages.m.a(paramMessageEntity, localQuote);
    QuotedMessageData localQuotedMessageData = getReplyBannerViewController().e();
    if (localQuotedMessageData == null);
    for (TextMetaInfo[] arrayOfTextMetaInfo = null; ; arrayOfTextMetaInfo = localQuotedMessageData.getTextMetaInfo())
    {
      com.viber.voip.messages.m.a(localQuotedMessageData, 11, arrayOfTextMetaInfo);
      paramMessageEntity.setRawQuotedMessageData(com.viber.voip.flatbuffers.b.e.b().b().a(localQuotedMessageData));
      return;
    }
  }

  private Editable getComposedTextForSend()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.i.getText());
    da.a(localSpannableStringBuilder);
    if (this.Q != null)
      da.a(localSpannableStringBuilder, this.p, this.Q.getConversationType(), this.Q.getGroupRole());
    return localSpannableStringBuilder;
  }

  private boolean y()
  {
    return b(this.i.getText().toString());
  }

  private void z()
  {
    if ((c.m.a.e()) && (d.r.x.d()))
      if (cj.a(ViberApplication.getApplication()).a() != 0)
        break label55;
    label55: for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
      {
        com.viber.voip.ui.dialogs.k.b().a(getContext());
        d.r.x.a(false);
      }
      return;
    }
  }

  public void a()
  {
    a(2, false, false);
  }

  public void a(int paramInt)
  {
    com.viber.voip.messages.ui.expanel.c.a(this, paramInt);
  }

  public void a(final int paramInt1, final int paramInt2, final Bundle paramBundle)
  {
    b(new Runnable()
    {
      public void run()
      {
        MessageEntity localMessageEntity = MessageComposerView.f(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this).getResources(), paramInt1, paramInt2, null, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
        MessageComposerView.this.b(localMessageEntity, false, paramBundle);
      }
    });
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    if (paramInt1 == 3);
    for (boolean bool = true; ; bool = false)
    {
      this.k.a(bool, paramInt2);
      if ((this.S != paramInt1) && (paramInt1 != 2) && (paramInt1 != 1))
        a = false;
      if (paramInt1 == 0)
        this.F.u();
      this.S = paramInt1;
      b = this.S;
      return;
    }
  }

  public void a(final int paramInt1, final int paramInt2, final String paramString, final Bundle paramBundle)
  {
    b(new Runnable()
    {
      public void run()
      {
        MessageEntity localMessageEntity = MessageComposerView.f(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this).getResources(), paramInt1, paramInt2, paramString, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
        MessageComposerView.this.b(localMessageEntity, true, paramBundle);
      }
    });
  }

  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.F.a(paramInt, paramBoolean1);
    a(false, paramBoolean2);
  }

  public void a(long paramLong, List<SendMediaDataContainer> paramList, Bundle paramBundle)
  {
    if ((this.g == null) && (paramLong > -1L))
    {
      n = Pair.create(Long.valueOf(paramLong), Pair.create(paramList, paramBundle));
      return;
    }
    a(paramList, paramBundle);
  }

  public void a(Uri paramUri, Bundle paramBundle)
  {
    File localFile = com.viber.voip.util.at.a(getContext(), paramUri);
    if (localFile == null)
      return;
    b(this.g.a(localFile, this.Q.getTimebombTime()), true, paramBundle);
  }

  public void a(OpenChatExtensionAction.Description paramDescription)
  {
    this.k.a(paramDescription);
  }

  public void a(g.a parama)
  {
    if ((this.Q != null) && (!this.Q.isGroupBehavior()))
      com.viber.voip.block.g.a(getContext(), new Member(this.Q.getParticipantMemberId(), null, null, this.Q.getParticipantName(), null), parama);
    while (parama == null)
      return;
    parama.a(Collections.emptySet());
  }

  public void a(Pin paramPin)
  {
    if (!cj.a(true))
      return;
    if (!cd.g(this.Q.getGroupRole(), this.Q.getConversationType()))
    {
      com.viber.voip.ui.dialogs.l.n().a(getContext());
      return;
    }
    ViberApplication.getInstance().getMessagesManager().c().a(paramPin, this.Q.getId(), this.Q.getGroupId(), this.Q.getParticipantMemberId(), this.Q.getConversationType(), this.Q.getNativeChatType());
  }

  public void a(QuotedMessageData paramQuotedMessageData)
  {
    getReplyBannerViewController().a(paramQuotedMessageData, this.Q.getConversationType(), this.Q.getGroupRole());
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.Q = paramConversationItemLoaderEntity;
    if (paramBoolean2)
    {
      a.a(this.k);
      a.b(this.k);
    }
    this.g = new com.viber.voip.messages.controller.c.b(this.Q);
    if (this.m != null)
    {
      this.h.post(this.m);
      this.m = null;
    }
    if ((n != null) && (((Long)n.first).longValue() == paramConversationItemLoaderEntity.getId()))
    {
      a((List)((Pair)n.second).first, (Bundle)((Pair)n.second).second);
      n = null;
    }
    com.viber.voip.messages.b.a.c localc = getMentionsViewController();
    if ((paramConversationItemLoaderEntity.isGroupBehavior()) && (!paramConversationItemLoaderEntity.isBroadcastListType()))
    {
      localc.a(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getGroupRole());
      this.i.setEditTextContextMenuCallback(A());
    }
    while (true)
    {
      this.k.a(paramConversationItemLoaderEntity, paramBoolean1);
      this.G.a(this.Q);
      a(this.Q.isSecret(), this.Q.getTimebombTime(), true);
      this.M.a(this.Q);
      return;
      localc.d();
    }
  }

  public void a(com.viber.voip.messages.conversation.ui.at paramat)
  {
    this.k.a(paramat);
  }

  public void a(final com.viber.voip.messages.extensions.model.d paramd, final Bundle paramBundle)
  {
    if (!paramd.i())
    {
      a(paramd.l(), null, paramBundle);
      return;
    }
    b(new Runnable()
    {
      public void run()
      {
        String str1;
        if (da.a(paramd.l()))
        {
          str1 = paramd.g();
          if (!da.a(paramd.b()))
            break label114;
        }
        label114: for (String str2 = str1; ; str2 = paramd.b())
        {
          MessageEntity localMessageEntity = MessageComposerView.f(MessageComposerView.this).a(str1, str2, paramd.c(paramd.m()), paramd.d(paramd.n()), MessageComposerView.e(MessageComposerView.this).getTimebombTime());
          MessageComposerView.this.a(localMessageEntity, true, paramBundle);
          return;
          str1 = paramd.l();
          break;
        }
      }
    });
  }

  public void a(OpenShopChatPanelData paramOpenShopChatPanelData)
  {
    this.F.a(paramOpenShopChatPanelData);
    dj.c(this);
  }

  public void a(aj.a parama)
  {
    int i1 = this.i.getText().length();
    int i2 = getResources().getInteger(R.integer.max_message_input_length);
    String str = parama.c();
    if (i1 + str.length() < i2)
    {
      int i3 = this.i.getSelectionStart();
      this.i.getText().insert(this.i.getSelectionEnd(), str);
      int i4 = Math.min(i3 + str.length(), this.i.getText().length());
      this.i.setSelection(i4);
    }
  }

  public void a(final ComposeDataContainer paramComposeDataContainer, final bu parambu, final Bundle paramBundle)
  {
    b(new Runnable()
    {
      public void run()
      {
        if (paramComposeDataContainer == null)
          return;
        try
        {
          String str1 = bj.a(MessageComposerView.this.getContext().getAssets().open("contact_sharing/server_share_contact.json"));
          JSONObject localJSONObject = parambu.a(paramComposeDataContainer, str1);
          String str2 = bu.a(localJSONObject, true, false)[0];
          MessageEntity localMessageEntity = MessageComposerView.f(MessageComposerView.this).a(str2, localJSONObject.toString(), 0, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
          MessageComposerView.this.b(localMessageEntity, true, paramBundle);
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }

  public void a(MessageEntity paramMessageEntity)
  {
    a.a(this.k, paramMessageEntity);
  }

  public void a(MessageEntity paramMessageEntity, boolean paramBoolean, Bundle paramBundle)
  {
    a(new aw(this, paramMessageEntity, paramBoolean, paramBundle));
  }

  public void a(Sticker paramSticker, Bundle paramBundle)
  {
    a(paramSticker, false, false, paramBundle);
  }

  public void a(final Sticker paramSticker, final boolean paramBoolean1, final boolean paramBoolean2, final Bundle paramBundle)
  {
    b(new Runnable()
    {
      public void run()
      {
        MessageEntity localMessageEntity = MessageComposerView.f(MessageComposerView.this).a(4, ObjectId.fromLong(paramSticker.id), MessageComposerView.e(MessageComposerView.this).getTimebombTime());
        Bundle localBundle1 = paramBundle;
        Sticker localSticker = paramSticker;
        if (paramBoolean2);
        for (String str = "Keyboard - Sticker Search"; ; str = "Keyboard")
        {
          Bundle localBundle2 = com.viber.voip.analytics.story.n.a(localBundle1, localSticker, str, com.viber.voip.stickers.i.a().b().a(localMessageEntity));
          MessageComposerView.this.a(localMessageEntity, paramBoolean1, localBundle2);
          return;
        }
      }
    });
  }

  public void a(Runnable paramRunnable)
  {
    if ((this.Q != null) && (!this.Q.isGroupBehavior()))
    {
      if (this.Q.isSystemReplyableChat())
      {
        com.viber.voip.block.b.a().a(getContext(), this.Q.getAppId(), this.Q.getParticipantName(), paramRunnable);
        return;
      }
      com.viber.voip.block.g.a(getContext(), new Member(this.Q.getParticipantMemberId(), null, null, this.Q.getParticipantName(), null), new av(paramRunnable));
      return;
    }
    paramRunnable.run();
  }

  public void a(String paramString)
  {
    if ("keyboard".equals(paramString))
    {
      this.i.requestFocus();
      dj.b(this.i);
      return;
    }
    this.k.a(paramString);
  }

  @Deprecated
  public void a(String paramString1, String paramString2)
  {
    b(new ax(this, paramString1, paramString2));
  }

  public void a(final String paramString1, final String paramString2, final Bundle paramBundle)
  {
    if (!da.a(paramString1))
      b(new Runnable()
      {
        public void run()
        {
          MessageEntity localMessageEntity = MessageComposerView.f(MessageComposerView.this).a(0, paramString1, 0, paramString2, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
          MessageComposerView.this.a(localMessageEntity, true, paramBundle);
        }
      });
  }

  public void a(final List<SendMediaDataContainer> paramList, final Bundle paramBundle)
  {
    b(new Runnable()
    {
      public void run()
      {
        com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "sendMediaMessage");
        ArrayList localArrayList = new ArrayList(paramList.size());
        int i = 0;
        if (i < paramList.size())
        {
          SendMediaDataContainer localSendMediaDataContainer = (SendMediaDataContainer)paramList.get(i);
          MsgInfo localMsgInfo;
          label74: FileInfo.a locala;
          label141: MessageEntity localMessageEntity1;
          int j;
          if (localSendMediaDataContainer.winkDescription != null)
          {
            localMsgInfo = localSendMediaDataContainer.winkDescription.toMessageInfo();
            if ((localSendMediaDataContainer.mediaInfo != null) && ((localSendMediaDataContainer.mediaInfo.getMediaType() == MediaInfo.a.IMAGE) || (localSendMediaDataContainer.mediaInfo.getMediaType() == MediaInfo.a.VIDEO)))
            {
              FileInfo localFileInfo = localMsgInfo.getFileInfo();
              localFileInfo.setMediaInfo(localSendMediaDataContainer.mediaInfo);
              if (localSendMediaDataContainer.mediaInfo.getMediaType() != MediaInfo.a.IMAGE)
                break label610;
              locala = FileInfo.a.IMAGE;
              localFileInfo.setContentType(locala);
              File localFile1 = com.viber.voip.util.at.a(MessageComposerView.m(MessageComposerView.this), localSendMediaDataContainer.fileUri);
              if (localFile1 != null)
              {
                localFileInfo.setFileName(localFile1.getName());
                localFileInfo.setFileExt(com.viber.voip.util.at.j(localFile1));
              }
            }
            ScreenshotConversationData localScreenshotConversationData = localSendMediaDataContainer.screenshotConversationData;
            if ((localScreenshotConversationData != null) && (localScreenshotConversationData.hasNameAndLink()))
              localMsgInfo.setCommunityScreenshot(new CommunityScreenshot(localScreenshotConversationData.getCommunityName(), localScreenshotConversationData.getCommunityShareLink()));
            com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "sendMediaMessage toJson");
            String str = com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo);
            com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "sendMediaMessage toJson");
            localMessageEntity1 = MessageComposerView.f(MessageComposerView.this).a(localSendMediaDataContainer.type, localSendMediaDataContainer.fileUri.toString(), localSendMediaDataContainer.description, str, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
            if (localSendMediaDataContainer.winkDescription != null)
            {
              if (!localMsgInfo.getFileInfo().isWinkImage())
                break label618;
              j = 1003;
              label335: localMessageEntity1.setMimeType(j);
            }
            localMessageEntity1.addExtraFlag(localSendMediaDataContainer.mediaFlag);
            if ((!localSendMediaDataContainer.useConversionIfRequire) || (!localMessageEntity1.isVideo()) || (localMessageEntity1.isWinkVideo()))
              break label626;
            localMessageEntity1.setExtraStatus(8);
          }
          while (true)
          {
            localMessageEntity1.setStatus(4);
            localMessageEntity1.setDate(localMessageEntity1.getDate() + i);
            if ((MessageComposerView.e(MessageComposerView.this).isShareLocation()) && (!localMessageEntity1.isWink()))
              localMessageEntity1.setExtraStatus(0);
            if (MessageComposerView.e(MessageComposerView.this).isSecret())
              localMessageEntity1.addExtraFlag(27);
            if (localSendMediaDataContainer.thumbnailUri != null)
              localMessageEntity1.setBody(localSendMediaDataContainer.thumbnailUri.toString());
            MessageComposerView.b(MessageComposerView.this, localMessageEntity1);
            localArrayList.add(localMessageEntity1);
            while (true)
            {
              i++;
              break;
              if ((localSendMediaDataContainer.mediaInfo == null) || (localSendMediaDataContainer.mediaInfo.getMediaType() != MediaInfo.a.GIF))
                break label598;
              File localFile2 = com.viber.voip.util.at.a(MessageComposerView.this.getContext(), localSendMediaDataContainer.fileUri);
              if (localFile2 != null)
              {
                MessageEntity localMessageEntity2 = MessageComposerView.f(MessageComposerView.this).a(localFile2, null, localSendMediaDataContainer.mediaInfo, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
                if (MessageComposerView.e(MessageComposerView.this).isShareLocation())
                  localMessageEntity2.setExtraStatus(0);
                MessageComposerView.b(MessageComposerView.this, localMessageEntity2);
                localArrayList.add(localMessageEntity2);
              }
            }
            label598: localMsgInfo = new MsgInfo();
            break label74;
            label610: locala = FileInfo.a.VIDEO;
            break label141;
            label618: j = 1004;
            break label335;
            label626: localMessageEntity1.setExtraStatus(2);
            localMessageEntity1.addExtraFlag(15);
          }
        }
        if (!localArrayList.isEmpty())
        {
          MessageComposerView.k(MessageComposerView.this).a((MessageEntity[])localArrayList.toArray(new MessageEntity[localArrayList.size()]), paramBundle);
          MessageComposerView.this.getReplyBannerViewController().b();
        }
        com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "sendMediaMessage");
      }
    });
  }

  public void a(final List<Uri> paramList1, final List<Uri> paramList2, final List<GalleryItem> paramList, final Bundle paramBundle)
  {
    b(new Runnable()
    {
      public void run()
      {
        Iterator localIterator1 = paramList1.iterator();
        while (localIterator1.hasNext())
        {
          Uri localUri2 = (Uri)localIterator1.next();
          File localFile = com.viber.voip.util.at.a(MessageComposerView.this.getContext(), localUri2);
          if (localFile != null)
          {
            MessageEntity localMessageEntity3 = MessageComposerView.f(MessageComposerView.this).a(localFile, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
            MessageComposerView.this.b(localMessageEntity3, false, paramBundle);
          }
        }
        Iterator localIterator2 = paramList2.iterator();
        while (localIterator2.hasNext())
        {
          Uri localUri1 = (Uri)localIterator2.next();
          MessageEntity localMessageEntity2 = MessageComposerView.f(MessageComposerView.this).a(3, localUri1.toString(), "", null, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
          localMessageEntity2.setExtraStatus(8);
          MessageComposerView.this.b(localMessageEntity2, false, paramBundle);
        }
        Iterator localIterator3 = paramList.iterator();
        while (localIterator3.hasNext())
        {
          GalleryItem localGalleryItem = (GalleryItem)localIterator3.next();
          MessageEntity localMessageEntity1 = MessageComposerView.f(MessageComposerView.this).a(1, localGalleryItem.getItemUri().toString(), "", null, MessageComposerView.e(MessageComposerView.this).getTimebombTime());
          localMessageEntity1.setExtraStatus(2);
          MessageComposerView.this.b(localMessageEntity1, false, paramBundle);
        }
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    if (this.F != null)
      this.F.d(paramBoolean);
    a(true, true);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.k.b(paramBoolean1);
    if (paramBoolean2)
    {
      this.i.requestFocus();
      if (!dj.c(getContext()))
        dj.b(this.i);
    }
    else
    {
      return;
    }
    this.d.b();
  }

  public void a(final long[] paramArrayOfLong, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    b(new Runnable()
    {
      public void run()
      {
        ViberApplication.getInstance().getMessagesManager().c().a(paramArrayOfLong, paramBundle1, MessageComposerView.e(MessageComposerView.this), new ai.g()
        {
          public void a(List<MessageEntity> paramAnonymous2List1, final List<MessageEntity> paramAnonymous2List2)
          {
            if (u.a(paramAnonymous2List2))
            {
              ViberApplication.getInstance().showToast(R.string.thread_no_messages_text);
              return;
            }
            MessageComposerView.n(MessageComposerView.this).post(new Runnable()
            {
              public void run()
              {
                MessageComposerView.k(MessageComposerView.this).a((MessageEntity[])paramAnonymous2List2.toArray(new MessageEntity[paramAnonymous2List2.size()]), MessageComposerView.7.this.c);
              }
            });
          }
        });
      }
    });
  }

  public void b()
  {
    if (this.Q != null)
      this.O.a("Keyboard", this.Q);
    a(1, false, true);
  }

  public void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.k.c(paramInt);
      return;
    }
    q();
  }

  public void b(MessageEntity paramMessageEntity, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramMessageEntity == null) || (this.Q == null))
      return;
    paramMessageEntity.setConversationId(this.Q.getId());
    paramMessageEntity.setConversationType(this.Q.getConversationType());
    if (this.Q.isGroupBehavior())
      paramMessageEntity.setGroupId(this.Q.getGroupId());
    while (true)
    {
      paramMessageEntity.setParticipantId(1L);
      if ((this.Q.isSystemReplyableChat()) && (paramMessageEntity.isNeedFetchUrl()))
        paramMessageEntity.setExtraStatus(3);
      if ((this.Q.isShareLocation()) && ((paramMessageEntity.getLat() == 0) || (paramMessageEntity.getLng() == 0)))
        paramMessageEntity.setExtraStatus(0);
      if (getReplyBannerViewController().a())
      {
        d(paramMessageEntity);
        getReplyBannerViewController().b();
      }
      a(paramMessageEntity, paramBundle);
      if (!paramBoolean)
        break;
      this.F.b(false);
      return;
      paramMessageEntity.setMemberId(this.Q.getParticipantMemberId());
    }
  }

  public void b(boolean paramBoolean)
  {
    b(paramBoolean, true);
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.F.a(paramBoolean1, paramBoolean2))
      this.k.b(false);
  }

  public void c()
  {
    if (this.k.f())
    {
      g().a();
      b(true);
      return;
    }
    if (this.F != null)
      this.F.a(false);
    a(false);
    z();
  }

  public void c(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      this.q = paramBoolean;
      this.k.c(this.q);
    }
  }

  public void d()
  {
    if (e())
      this.A.a();
  }

  public boolean e()
  {
    return (this.A != null) && (this.A.b());
  }

  public void f()
  {
    this.g = null;
    this.G.a(null);
  }

  public com.viber.voip.messages.ui.c.b g()
  {
    if (this.v == null)
    {
      MessageEditText localMessageEditText = getMessageEdit();
      com.viber.voip.messages.ui.c.a locala = new com.viber.voip.messages.ui.c.a();
      com.viber.voip.messages.ui.c.c[] arrayOfc = new com.viber.voip.messages.ui.c.c[2];
      arrayOfc[0] = getReplyBannerViewController();
      arrayOfc[1] = j();
      this.v = new com.viber.voip.messages.ui.c.b(localMessageEditText, locala, arrayOfc);
    }
    return this.v;
  }

  public a getActionViewsHelper()
  {
    return this.k;
  }

  public com.viber.voip.messages.b.a.c getMentionsViewController()
  {
    if (this.B == null)
      this.B = new com.viber.voip.messages.b.a.c(getContext(), this.i, getResources().getInteger(R.integer.max_message_input_length), (View)getParent(), this.d.i(), ViberApplication.getInstance().getLazyMessagesManager(), this.p, this.N, this.h, com.viber.voip.h.a.b(), this.K);
    return this.B;
  }

  public MessageEditText getMessageEdit()
  {
    return this.i;
  }

  public int getRecordOrSendTextButtonState()
  {
    int i1 = d.r.l.d();
    boolean bool = this.k.i();
    if ((B()) && ((i1 == 1) || (!bool)))
      return 1;
    if (bool)
      return 4;
    return 0;
  }

  public com.viber.voip.messages.c.a.a getReplyBannerViewController()
  {
    if (this.u == null)
      this.u = new com.viber.voip.messages.c.a.a((ViewGroup)getParent(), this.U, this.o, this.p);
    return this.u;
  }

  public SendButton getSendButton()
  {
    return a.d(this.k);
  }

  public int getViewState()
  {
    return this.E;
  }

  public void h()
  {
    if (this.k.i())
    {
      this.k.j();
      a.c(this.k);
    }
  }

  public void i()
  {
    int i1 = getRecordOrSendTextButtonState();
    if (i1 == 1)
    {
      this.k.h();
      return;
    }
    if (i1 == 4)
    {
      this.k.j();
      return;
    }
    this.k.k();
  }

  public com.viber.voip.messages.extensions.ui.o j()
  {
    if (this.t == null)
    {
      o.a local15 = new o.a()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            MessageComposerView.this.getMentionsViewController().b();
            return;
          }
          MessageComposerView.this.getMentionsViewController().c();
        }
      };
      com.viber.voip.messages.extensions.ui.n localn = new com.viber.voip.messages.extensions.ui.n(aj.b());
      this.t = new com.viber.voip.messages.extensions.ui.o(getContext(), this.i, this, this, localn, local15, (View)getParent(), this.K);
    }
    return this.t;
  }

  public boolean k()
  {
    return com.viber.voip.messages.d.a.a(this.Q, this.I);
  }

  public void l()
  {
    this.k.q();
  }

  public void m()
  {
    this.r.a(this.s);
    this.G.a();
  }

  public void n()
  {
    this.r.b(this.s);
    this.G.b();
  }

  public void o()
  {
    this.H.b();
    if (this.t != null)
      this.t.a();
    if (this.B != null)
      this.B.a();
    this.k.r();
    this.T.a();
    this.M.c();
    s();
  }

  protected void onAttachedToWindow()
  {
    this.F.h(false);
    super.onAttachedToWindow();
    this.k.m();
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.send_text)
    {
      this.d.a(false);
      this.k.o();
      if (this.D != null)
        this.D.a();
    }
    while (i1 != R.id.btn_time_bomb)
      return;
    if (this.A == null)
      this.A = new com.viber.voip.camrecorder.preview.l(getContext(), new l.a()
      {
        public void c(int paramAnonymousInt)
        {
          MessageComposerView.a(MessageComposerView.this, true, paramAnonymousInt, false);
          int i = ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence();
          MessageComposerView.a(MessageComposerView.this, paramAnonymousInt, i);
          com.viber.voip.h.a.b().post(new l.c(i, MessageComposerView.e(MessageComposerView.this).getId(), MessageComposerView.e(MessageComposerView.this).getParticipantMemberId(), MessageComposerView.e(MessageComposerView.this).getGroupId(), paramAnonymousInt));
        }
      }
      , R.array.conversation_bomb_picker_values, R.array.conversation_bomb_picker_values_int, R.array.conversation_bomb_picker_units, this.Q.getTimebombTime(), this.K);
    this.A.a(this.i.getRootView());
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a = true;
    super.onConfigurationChanged(paramConfiguration);
    this.k.a(paramConfiguration);
  }

  protected void onDetachedFromWindow()
  {
    this.F.h(true);
    this.k.n();
    getReplyBannerViewController().f();
    super.onDetachedFromWindow();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramView == this) && (this.u != null))
      this.u.a(paramInt);
  }

  public void p()
  {
    this.k.a(null);
  }

  public void q()
  {
    if ((this.F != null) && ((this.F.n()) || (this.F.m())));
    do
    {
      return;
      int i1 = this.d.c();
      if ((this.d.e()) && ((!this.i.hasFocus()) || (y())))
      {
        this.k.l();
        return;
      }
      if (i1 > 0)
      {
        this.k.c(i1);
        return;
      }
      if ((!y()) || (this.u == null) || (this.u.a()))
        break;
    }
    while (getSendButton().getState() == 8);
    i();
    return;
    this.k.k();
  }

  void r()
  {
    if (this.l == null)
      this.l = com.viber.voip.ui.k.a.a(this);
    this.l.a();
  }

  void s()
  {
    if (this.l != null)
    {
      this.l.b();
      this.l = null;
    }
  }

  public void setHost(c paramc)
  {
    this.d = paramc;
  }

  public void setInputFieldInteractor(z paramz)
  {
    this.F = paramz;
  }

  public void setMessageSender(com.viber.voip.messages.conversation.ab paramab)
  {
    this.R = paramab;
  }

  public void setOnButtonsListener(e parame)
  {
    this.k.a(parame);
  }

  public void setOnMessageEditClickListener(i parami)
  {
    this.D = parami;
  }

  public void setSendMessageActions(k paramk)
  {
    this.e = paramk;
  }

  public void setVideoPttRecordStub(ViewStub paramViewStub)
  {
    this.w = paramViewStub;
  }

  public void setVideoPttViewAnimationController(com.viber.voip.u.a.f paramf)
  {
    this.y = paramf;
  }

  public void setViewState(int paramInt)
  {
    this.E = paramInt;
    switch (this.E)
    {
    default:
      return;
    case 2:
      setVisibility(0);
      return;
    case 3:
      setVisibility(8);
      return;
    case 1:
    }
    setVisibility(0);
    getLayoutParams().height = -2;
    requestLayout();
  }

  public void t()
  {
    this.k.D();
  }

  public void u()
  {
    getReplyBannerViewController().b();
  }

  public void v()
  {
    if ((this.u != null) && (this.u.a()))
      this.u.g();
  }

  public void w()
  {
    setViewState(1);
  }

  public class a
    implements View.OnClickListener, PreviewPttMessageView.a, RecordMessageView.a, SendButton.b, com.viber.voip.q.n, com.viber.voip.u.g
  {
    PreviewPttMessageView A;
    com.viber.voip.q.k B;
    protected final boolean C;
    com.viber.common.ui.c D;
    com.viber.common.ui.c E;
    AnimatorSet F;
    AnimatorSet G;
    long H;
    int I;
    boolean J;
    final ae.a K = new ae.a()
    {
      public void a(ae paramAnonymousae)
      {
        MessageComposerView.a.a(MessageComposerView.a.this, paramAnonymousae);
      }
    };
    public final TextView.OnEditorActionListener L = new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        switch (paramAnonymousInt)
        {
        case 5:
        default:
          return false;
        case 4:
          MessageComposerView.a.e(MessageComposerView.a.this);
          return true;
        case 3:
          MessageComposerView.a.this.e();
          return true;
        case 6:
        }
        MessageComposerView.a.f(MessageComposerView.a.this);
        return true;
      }
    };
    private SendButton N;
    private View O;
    private boolean P;
    private int Q;
    private MessageEntity R;
    private boolean S;
    private boolean T;
    private boolean U;
    private ag V;
    private am W;
    private Handler X;
    private Runnable Y;
    private Runnable Z;
    SparseArray<View> a;
    private Runnable aa;
    private Runnable ab;
    private ArrayList<ae> ac;
    private Runnable ad;
    private final Runnable ae = new Runnable()
    {
      public void run()
      {
        MessageComposerView.a.this.h.requestLayout();
        MessageComposerView.a.this.h.invalidate();
      }
    };
    MessageComposerView.j b;
    MessageComposerView.g c;
    MessageComposerView.d d;
    MessageComposerView.f e;
    MessageComposerView.f f;
    MessageComposerView.h g;
    LinearLayout h;
    af i;
    af j;
    af k;
    ad l;
    af m;
    af n;
    af o;
    ac p;
    ad q;
    ad r;
    ad s;
    ad t;
    ad u;
    ad v;
    ad w;
    ViewStub x;
    ViewStub y;
    RecordMessageView z;

    a(boolean arg2)
    {
      boolean bool;
      this.C = bool;
    }

    private void F()
    {
      int i1 = this.ac.size();
      for (int i2 = 0; i2 < i1; i2++)
        ((ae)this.ac.get(i2)).setTriggerClickListener(this.K);
    }

    private void G()
    {
      if (this.a == null)
        this.a = new SparseArray(17);
      while (true)
      {
        this.a.put(ab.a.a.p, this.j);
        this.a.put(ab.a.o.p, this.i);
        this.a.put(ab.a.d.p, this.k);
        this.a.put(ab.a.c.p, this.l);
        this.a.put(ab.a.b.p, this.m);
        this.a.put(ab.a.e.p, this.n);
        this.a.put(ab.a.f.p, this.o);
        this.a.put(ab.a.g.p, this.p);
        this.a.put(ab.a.h.p, this.q);
        this.a.put(ab.a.i.p, this.r);
        this.a.put(ab.a.j.p, this.s);
        this.a.put(ab.a.k.p, this.t);
        this.a.put(ab.a.l.p, this.u);
        this.a.put(ab.a.m.p, this.v);
        this.a.put(ab.a.n.p, this.w);
        return;
        this.a.clear();
      }
    }

    private void H()
    {
      Editable localEditable = MessageComposerView.o(MessageComposerView.this);
      MessageComposerView.this.a(localEditable.toString(), com.viber.voip.messages.m.a(localEditable), null);
    }

    private void I()
    {
      if ((MessageComposerView.a(MessageComposerView.this) != null) && (this.N.isEnabled()))
      {
        Editable localEditable = MessageComposerView.o(MessageComposerView.this);
        MessageComposerView.a(MessageComposerView.this).a(localEditable.toString(), com.viber.voip.messages.m.a(localEditable));
        MessageComposerView.p(MessageComposerView.this).f("Send");
      }
      while (true)
      {
        MessageComposerView.g(MessageComposerView.this).b(false);
        return;
        if (MessageComposerView.g(MessageComposerView.this).n())
          MessageComposerView.p(MessageComposerView.this).f("Cancel");
      }
    }

    private void J()
    {
      if (MessageComposerView.t(MessageComposerView.this).a(com.viber.voip.permissions.n.j))
      {
        if (MessageComposerView.a(MessageComposerView.this) != null)
          MessageComposerView.a(MessageComposerView.this).H_();
        return;
      }
      MessageComposerView.t(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this), 81, com.viber.voip.permissions.n.j);
    }

    private void K()
    {
      if (MessageComposerView.t(MessageComposerView.this).a(com.viber.voip.permissions.n.m))
      {
        if (MessageComposerView.a(MessageComposerView.this) != null)
          MessageComposerView.a(MessageComposerView.this).e();
        return;
      }
      MessageComposerView.t(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this), 132, com.viber.voip.permissions.n.m);
    }

    private void L()
    {
      if (MessageComposerView.t(MessageComposerView.this).a(com.viber.voip.permissions.n.m))
      {
        if (MessageComposerView.a(MessageComposerView.this) != null)
          MessageComposerView.a(MessageComposerView.this).j();
        return;
      }
      MessageComposerView.t(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this), 103, com.viber.voip.permissions.n.m);
    }

    private void M()
    {
      if (MessageComposerView.t(MessageComposerView.this).a(com.viber.voip.permissions.n.b))
      {
        if (MessageComposerView.a(MessageComposerView.this) != null)
          MessageComposerView.a(MessageComposerView.this).f();
        return;
      }
      MessageComposerView.t(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this), 15, com.viber.voip.permissions.n.b);
    }

    private boolean N()
    {
      switch (this.N.getState())
      {
      case 1:
      case 3:
      case 4:
      case 7:
      default:
        return true;
      case 0:
        H();
        return true;
      case 2:
        MessageComposerView.this.a(new Runnable()
        {
          public void run()
          {
            if (MessageComposerView.a(MessageComposerView.this) != null)
              MessageComposerView.a(MessageComposerView.this).s();
            MessageComposerView.a.h(MessageComposerView.a.this);
          }
        });
        return false;
      case 5:
        e();
        return true;
      case 6:
        I();
        return true;
      case 8:
      }
      O();
      return true;
    }

    private void O()
    {
      if ((MessageComposerView.a(MessageComposerView.this) != null) && (this.N.isEnabled()) && (this.A != null))
      {
        this.X.post(this.Z);
        ViberApplication.getInstance().getMessagesManager().m().a();
        MessageComposerView.a(MessageComposerView.this).q();
        this.A.b();
        MessageComposerView.b(MessageComposerView.this).h();
        Z();
      }
      MessageComposerView.g(MessageComposerView.this).b(false);
    }

    private void P()
    {
      MessageComposerView.r(MessageComposerView.this).a();
    }

    private void Q()
    {
      if ((this.i.a()) && (!a(this.i)) && (this.b != null))
        this.b.a(false);
    }

    private ag R()
    {
      if (this.V == null)
        this.V = new ag(MessageComposerView.m(MessageComposerView.this), MessageComposerView.this, this.i);
      return this.V;
    }

    private am S()
    {
      if (this.W == null)
        this.W = new am(MessageComposerView.m(MessageComposerView.this), MessageComposerView.this, this.N, MessageComposerView.x(MessageComposerView.this));
      return this.W;
    }

    private void T()
    {
      if (this.S)
      {
        boolean bool = this.N.c();
        this.N.e();
        if ((this.z != null) && (bool))
        {
          this.z.d();
          switch (this.N.getState())
          {
          default:
          case 7:
          case 1:
          case 4:
          }
        }
      }
      do
      {
        do
        {
          return;
          this.N.setState(1);
        }
        while (this.B == null);
        this.B.c();
        return;
      }
      while (MessageComposerView.i(MessageComposerView.this) == null);
      MessageComposerView.i(MessageComposerView.this).a();
    }

    private void U()
    {
      if (this.z != null)
        this.z.d();
      if (this.A != null)
        this.A.b();
      if (this.N.getState() == 8)
      {
        ViberApplication.getInstance().getMessagesManager().m().a();
        h();
        Z();
      }
    }

    private void V()
    {
      ViberApplication.getInstance().getRingtonePlayer().vibrate(60);
    }

    private AnimatorSet W()
    {
      this.F = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      int i1 = -1 + this.h.getChildCount();
      long l1 = 0L;
      for (int i2 = i1; i2 >= 0; i2--)
      {
        View localView = this.h.getChildAt(i2);
        if (localView.getVisibility() == 0)
        {
          localArrayList.add(a(localView, l1, true));
          l1 += 50L;
        }
      }
      this.F.playTogether(localArrayList);
      return this.F;
    }

    private AnimatorSet X()
    {
      this.G = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      long l1 = 0L;
      int i1 = this.h.getChildCount();
      for (int i2 = 0; i2 < i1; i2++)
      {
        View localView = this.h.getChildAt(i2);
        if (localView.getVisibility() == 0)
        {
          localArrayList.add(a(localView, l1, false));
          l1 += 50L;
        }
      }
      this.G.playTogether(localArrayList);
      return this.G;
    }

    private void Y()
    {
      if ((this.G != null) && (this.G.isRunning()))
        this.G.end();
      if (this.F == null)
        this.F = W();
      this.F.start();
    }

    private void Z()
    {
      if ((this.F != null) && (this.F.isRunning()))
        this.F.end();
      if (this.G == null)
        this.G = X();
      this.G.start();
    }

    private Animator a(View paramView, long paramLong, boolean paramBoolean)
    {
      float[] arrayOfFloat = new float[1];
      if (paramBoolean);
      ObjectAnimator localObjectAnimator;
      for (float f1 = this.h.getHeight(); ; f1 = 0.0F)
      {
        arrayOfFloat[0] = f1;
        localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", arrayOfFloat);
        localObjectAnimator.setStartDelay(paramLong);
        if (!paramBoolean)
          break;
        localObjectAnimator.setInterpolator(new AccelerateInterpolator());
        return localObjectAnimator;
      }
      localObjectAnimator.setInterpolator(new DecelerateInterpolator());
      return localObjectAnimator;
    }

    private void a(ab.b paramb)
    {
      boolean bool = paramb.b.contains(ab.a.n);
      if ((MessageComposerView.e(MessageComposerView.this) != null) && (MessageComposerView.e(MessageComposerView.this).canCreatePoll()));
      ag localag;
      for (int i1 = 1; ; i1 = 0)
      {
        if (i1 != 0)
        {
          localag = R();
          if (!bool)
            break;
          localag.getClass();
          this.ad = az.a(localag);
          MessageComposerView.n(MessageComposerView.this).postDelayed(this.ad, 1000L);
        }
        return;
      }
      if (this.ad != null)
        MessageComposerView.n(MessageComposerView.this).removeCallbacks(this.ad);
      localag.a();
    }

    private void a(SampleTone paramSampleTone)
    {
      ViberApplication.getInstance().getRingtonePlayer().playSample(paramSampleTone);
    }

    private boolean a(View paramView)
    {
      return this.h == paramView.getParent();
    }

    private void aa()
    {
      this.G = null;
      this.F = null;
    }

    private void ab()
    {
      if ((this.V != null) && (this.V.c()));
      for (int i1 = 1; ; i1 = 0)
      {
        if (i1 == 0)
          MessageComposerView.b(MessageComposerView.this).S().b();
        return;
      }
    }

    private void b(int paramInt, boolean paramBoolean)
    {
      switch (paramInt)
      {
      case 2:
      case 3:
      default:
        return;
      case 1:
        if (paramBoolean)
          this.N.setState(paramInt);
        while (true)
        {
          d.r.l.a(paramInt);
          return;
          this.N.a(paramInt);
        }
      case 4:
      }
      if (paramBoolean)
        this.N.setState(paramInt);
      while (true)
      {
        d.r.l.a(paramInt);
        return;
        this.N.a(paramInt);
      }
    }

    private void b(ae paramae)
    {
      boolean bool = paramae.a();
      a(paramae);
      a(paramae.getPanelId(), bool);
      if (((R.id.options_menu_open_old_chat_extensions != paramae.getPanelId()) || (!bool)) && (MessageComposerView.g(MessageComposerView.this) != null))
        MessageComposerView.g(MessageComposerView.this).a(false);
      MessageComposerView.this.b(false);
      MessageComposerView.this.g().a();
      if (bool)
        dj.c(MessageComposerView.this);
    }

    private void b(MessageEntity paramMessageEntity)
    {
      if (this.A == null)
      {
        this.A = ((PreviewPttMessageView)this.y.inflate());
        this.A.setPreviewDeletedListener(this);
      }
      if (this.z != null)
        this.z.a();
      this.A.c();
      this.A.a(paramMessageEntity);
      MessageComposerView.this.getActionViewsHelper().e(true);
    }

    private void b(boolean paramBoolean, int paramInt)
    {
      if (MessageComposerView.e(MessageComposerView.this) == null)
        return;
      ab.b localb = ab.a(MessageComposerView.this.getContext(), MessageComposerView.e(MessageComposerView.this), paramBoolean, paramInt, MessageComposerView.u(MessageComposerView.this));
      label161: LinearLayout localLinearLayout;
      if (localb.a(this.h))
      {
        this.h.removeAllViewsInLayout();
        int i4 = localb.a.size();
        for (int i5 = 0; i5 < i4; i5++)
        {
          View localView = (View)this.a.get(((ab.a)localb.a.get(i5)).p);
          if (i5 > 0)
            localb.a(localView);
          this.h.addView(localView);
        }
        MessageComposerView.n(MessageComposerView.this).removeCallbacks(this.ae);
        MessageComposerView.n(MessageComposerView.this).post(this.ae);
        MessageComposerView.r(MessageComposerView.this).a(localb.b);
        localLinearLayout = this.h;
        if (!paramBoolean)
          break label258;
      }
      label258: for (int i3 = 0; ; i3 = MessageComposerView.this.getResources().getDimensionPixelSize(R.dimen.composer_group_layout_height))
      {
        dj.b(localLinearLayout, i3);
        Q();
        if (!com.viber.voip.messages.m.b(MessageComposerView.e(MessageComposerView.this)))
          break;
        a(localb);
        return;
        int i1 = 1;
        int i2 = this.h.getChildCount();
        while (i1 < i2)
        {
          localb.a(this.h.getChildAt(i1));
          i1++;
        }
        break label161;
      }
    }

    private void g(boolean paramBoolean)
    {
      if ((!dj.c(MessageComposerView.this.getContext())) || (this.C) || ((paramBoolean) && (!MessageComposerView.this.j().b())));
      for (boolean bool = true; ; bool = false)
      {
        MessageComposerView.r(MessageComposerView.this).a(bool, false);
        return;
      }
    }

    private void h(boolean paramBoolean)
    {
      boolean bool1 = true;
      if ((MessageComposerView.g(MessageComposerView.this) != null) && (MessageComposerView.g(MessageComposerView.this).m()))
        return;
      if ((paramBoolean) || (!MessageComposerView.v(MessageComposerView.this)));
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        this.N.setEnabled(bool2);
        if (!bool2)
          break;
        this.N.a(0);
        return;
      }
      MessageComposerView.this.i();
      SendButton localSendButton = this.N;
      if (!a(0));
      while (true)
      {
        localSendButton.setEnabled(bool1);
        return;
        bool1 = false;
      }
    }

    private final void i(int paramInt)
    {
      int i1 = this.ac.size();
      int i2 = 0;
      if (i2 < i1)
      {
        ae localae = (ae)this.ac.get(i2);
        if (localae.getPanelId() == paramInt);
        for (boolean bool = true; ; bool = false)
        {
          localae.e_(bool);
          i2++;
          break;
        }
      }
    }

    private void i(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (!this.S)
          break label38;
        this.P = true;
      }
      while (true)
      {
        this.N.e();
        if (this.z != null)
          this.z.d();
        return;
        label38: u();
      }
    }

    private void j(int paramInt)
    {
      this.N.setEnabled(true);
      this.N.setSelectedMediaCount(paramInt);
      this.N.a(2);
    }

    public void A()
    {
      if (this.z != null)
        if (!a(4))
          break label28;
      label28: for (cm localcm = cm.b(); ; localcm = cm.a())
      {
        this.z.a(localcm);
        return;
      }
    }

    public void B()
    {
      if (a(new int[] { 1, 7 }))
        MessageComposerView.this.r();
      this.X.post(this.ab);
    }

    public void C()
    {
      if (this.T)
      {
        this.T = false;
        if (!this.S)
          MessageComposerView.r(MessageComposerView.this).a(2);
      }
      this.X.post(this.aa);
    }

    public void D()
    {
      this.p.a(false);
    }

    public final void a()
    {
      b();
      this.ac = new ArrayList();
      a(this.ac);
      F();
    }

    public void a(int paramInt1, int paramInt2)
    {
      switch (paramInt2)
      {
      default:
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        MessageComposerView.this.s();
        return;
        if (this.z != null)
          this.z.a();
        if ((paramInt1 == 1) && (this.B != null))
          this.B.b();
        while (true)
        {
          this.N.a(0.0F);
          break;
          if ((paramInt1 == 4) && (MessageComposerView.i(MessageComposerView.this) != null))
            MessageComposerView.i(MessageComposerView.this).b();
        }
        if ((paramInt1 == 1) && (this.B != null))
        {
          if (this.z != null)
            MessageComposerView.p(MessageComposerView.this).a(this.z.getCurrentTimeInMillis());
          this.B.c();
        }
        while (true)
        {
          this.N.a(-MessageComposerView.this.getWidth() + this.N.getRecordToggleMaxSize());
          if (this.z == null)
            break;
          this.z.b();
          break;
          if ((paramInt1 == 4) && (MessageComposerView.i(MessageComposerView.this) != null))
            MessageComposerView.i(MessageComposerView.this).a();
        }
        int i1 = 1 + d.r.m.d();
        if (i1 >= 3)
        {
          this.P = true;
          d.r.m.e();
        }
        else
        {
          d.r.m.a(i1);
        }
      }
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (paramInt1 != paramInt3)
      {
        b(MessageComposerView.w(MessageComposerView.this), paramInt1);
        this.N.setRecordToggleDragLimitPosition((paramInt1 - this.N.getRecordToggleMaxSize()) / 2.0F);
      }
    }

    public void a(int paramInt, SendButton.b.a parama, float paramFloat)
    {
      if ((this.z != null) && (parama.b()))
        this.z.a(parama, paramFloat);
    }

    public void a(int paramInt, boolean paramBoolean)
    {
      if (paramInt == R.id.options_menu_open_gallery)
        if (this.g != null)
          this.g.c(paramBoolean);
      while (true)
      {
        P();
        return;
        if (paramInt == R.id.options_menu_open_old_chat_extensions)
        {
          if (paramBoolean)
            this.o.e_(false);
          MessageComposerView.this.a(new a(paramBoolean));
        }
        else if (paramInt == R.id.bot_keyboard)
        {
          this.N.getBotKeyboardPanelTrigger().e_(paramBoolean);
          if (this.d != null)
            this.d.b(paramBoolean);
        }
        else if (paramInt == R.id.options_menu_open_share_and_shop)
        {
          if (paramBoolean)
            this.n.e_(false);
          MessageComposerView.r(MessageComposerView.this).b(paramBoolean);
        }
        else if (paramInt == R.id.options_menu_open_extra_section)
        {
          if (this.b != null)
            this.b.a(paramBoolean);
        }
        else if ((paramInt == R.id.options_menu_open_stickers) && (this.c != null))
        {
          MessageComposerView.b localb = MessageComposerView.b.values()[com.viber.voip.settings.d.ax.i.d()];
          this.c.a(paramBoolean, localb);
        }
      }
    }

    public void a(Configuration paramConfiguration)
    {
      aa();
      int i1 = MessageComposerView.this.getWidth();
      if (i1 > 0)
        b(MessageComposerView.w(MessageComposerView.this), i1);
    }

    public void a(OpenChatExtensionAction.Description paramDescription)
    {
      switch (paramDescription.interfaceType)
      {
      default:
      case 1:
      case 0:
      }
      label142: 
      do
      {
        do
          return;
        while (this.e == null);
        if (!da.a(paramDescription.publicAccountId))
          MessageComposerView.u(MessageComposerView.this).f(paramDescription.publicAccountId);
        MessageComposerView.f localf;
        if (paramDescription.searchQuery != null)
        {
          MessageComposerView.g(MessageComposerView.this).a(paramDescription.publicAccountId, paramDescription.searchQuery);
          localf = this.e;
          if (13 != paramDescription.cdrOpenTrigger)
            break label142;
        }
        for (int i1 = 3; ; i1 = 0)
        {
          localf.a(true, i1, true);
          dj.c(MessageComposerView.this);
          return;
          ViberApplication.getInstance().getMessagesManager().h().d(paramDescription.publicAccountId);
          break;
        }
        if ("stickers".equals(paramDescription.id))
        {
          MessageComposerView.this.a(1, true, true);
          return;
        }
        if (!"giphy".equals(paramDescription.id))
          break;
      }
      while (!com.viber.voip.messages.d.a.b());
      MessageComposerView.this.a(true);
      return;
      if (com.viber.voip.messages.d.a.b())
      {
        MessageComposerView.this.a(true);
        return;
      }
      MessageComposerView.this.a(1, true, true);
    }

    public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
    {
      if ((MessageComposerView.g(MessageComposerView.this) != null) && (!a(0)) && (!MessageComposerView.g(MessageComposerView.this).m()))
        this.N.setEnabled(true);
      p();
      long l1 = paramConversationItemLoaderEntity.getId();
      int i1 = paramConversationItemLoaderEntity.getGroupRole();
      boolean bool1 = SpamController.b(paramConversationItemLoaderEntity);
      int i2 = MessageComposerView.this.getWidth();
      boolean bool2 = paramConversationItemLoaderEntity.isSystemReplyableChat();
      if (((this.H != l1) || (this.I != i1)) && ((i2 > 0) || (bool2)))
        b(bool2, i2);
      this.H = l1;
      this.I = i1;
      this.J = bool1;
    }

    public void a(com.viber.voip.messages.conversation.ui.at paramat)
    {
      this.N.setRecordButtonSvgMainColor(paramat.d());
      this.N.setSendButtonBackground(paramat.c());
      this.N.setRecordIconInactiveBackground(paramat.b());
    }

    public void a(com.viber.voip.messages.extensions.d.a.a parama)
    {
      if (parama != null)
      {
        this.p.a(parama.b.getIcon());
        return;
      }
      this.p.a();
    }

    public void a(MessageComposerView.e parame)
    {
      this.b = parame;
      this.c = parame;
      this.d = parame;
      this.e = parame;
      this.f = parame;
      this.g = parame;
    }

    public final void a(ae paramae)
    {
      int i1 = this.ac.size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        ae localae = (ae)this.ac.get(i2);
        if ((paramae == null) || (localae != paramae))
          localae.e_(false);
      }
    }

    public void a(MessageEntity paramMessageEntity)
    {
      this.X.post(this.Z);
      if (paramMessageEntity == null)
        return;
      if ((MessageComposerView.e(MessageComposerView.this) != null) && (MessageComposerView.e(MessageComposerView.this).isShareLocation()))
        paramMessageEntity.setLocation(ViberApplication.getInstance().getLocationManager().a(2));
      if (this.S)
      {
        this.R = paramMessageEntity;
        return;
      }
      MessageComposerView.a(MessageComposerView.this, paramMessageEntity, null);
    }

    public void a(String paramString)
    {
      if (("menu".equals(paramString)) && (this.b != null))
        this.b.a(true);
      do
      {
        return;
        if (("stickers".equals(paramString)) && (this.c != null))
        {
          this.c.a(true, MessageComposerView.b.b);
          return;
        }
        if (("emoticons".equals(paramString)) && (this.c != null))
        {
          this.c.a(true, MessageComposerView.b.a);
          return;
        }
      }
      while ((!"gallery".equals(paramString)) || (this.g == null));
      this.g.c(true);
    }

    public void a(ArrayList<ae> paramArrayList)
    {
      paramArrayList.add(this.i);
      paramArrayList.add(this.j);
      paramArrayList.add(this.k);
      paramArrayList.add(this.N.getBotKeyboardPanelTrigger());
      paramArrayList.add(this.n);
      paramArrayList.add(this.o);
    }

    public void a(boolean paramBoolean)
    {
      if (this.O == null)
        d();
      dj.b(this.O, paramBoolean);
    }

    public void a(boolean paramBoolean, int paramInt)
    {
      a locala = MessageComposerView.b(MessageComposerView.this);
      int i1;
      if (paramBoolean)
      {
        i1 = paramInt;
        locala.i(i1);
        if ((paramInt != -1) && (paramBoolean))
          break label189;
      }
      label189: for (boolean bool1 = true; ; bool1 = false)
      {
        g(bool1);
        if ((paramBoolean) && (paramInt != R.id.options_menu_open_stickers))
          MessageComposerView.this.b(false);
        if ((paramInt == R.id.options_menu_open_gallery) && (paramBoolean) && (!a(2)) && (MessageComposerView.r(MessageComposerView.this).c() > 0))
          c(MessageComposerView.r(MessageComposerView.this).c());
        if ((MessageComposerView.g(MessageComposerView.this) != null) && (MessageComposerView.g(MessageComposerView.this).m()))
        {
          SendButton localSendButton = this.N;
          boolean bool2;
          if (paramBoolean)
          {
            int i2 = R.id.options_menu_open_old_chat_extensions;
            bool2 = false;
            if (i2 == paramInt);
          }
          else
          {
            bool2 = true;
          }
          localSendButton.setEnabled(bool2);
        }
        if ((paramInt != -1) && (paramBoolean))
          dj.c(MessageComposerView.this);
        return;
        i1 = -1;
        break;
      }
    }

    public boolean a(int paramInt)
    {
      return this.N.getState() == paramInt;
    }

    public boolean a(int[] paramArrayOfInt)
    {
      return Arrays.binarySearch(paramArrayOfInt, this.N.getState()) > 0;
    }

    public void b()
    {
      this.N = ((SendButton)MessageComposerView.this.findViewById(R.id.btn_send));
      this.N.setRecordStateSwitchRightExtraTouchArea(MessageComposerView.this.getResources().getDimensionPixelOffset(R.dimen.composer_send_button_margin_right));
      this.N.setOnClickListener(this);
      this.N.setRecordStateListener(this);
      MessageComposerView.this.setClipChildren(false);
      this.h = ((LinearLayout)MessageComposerView.this.findViewById(R.id.options_group));
      this.i = ((af)ab.a.o.a(MessageComposerView.this));
      this.j = ((af)ab.a.a.a(MessageComposerView.this));
      this.k = ((af)ab.a.d.a(MessageComposerView.this));
      this.m = ((af)ab.a.b.a(MessageComposerView.this));
      this.l = ((ad)ab.a.c.a(MessageComposerView.this));
      this.n = ((af)ab.a.e.a(MessageComposerView.this));
      this.o = ((af)ab.a.f.a(MessageComposerView.this));
      this.p = ((ac)ab.a.g.a(MessageComposerView.this));
      this.q = ((ad)ab.a.h.a(MessageComposerView.this));
      this.r = ((ad)ab.a.i.a(MessageComposerView.this));
      this.s = ((ad)ab.a.j.a(MessageComposerView.this));
      this.t = ((ad)ab.a.k.a(MessageComposerView.this));
      this.u = ((ad)ab.a.l.a(MessageComposerView.this));
      this.v = ((ad)ab.a.m.a(MessageComposerView.this));
      this.w = ((ad)ab.a.n.a(MessageComposerView.this));
      G();
      this.x = ((ViewStub)MessageComposerView.this.findViewById(R.id.record_message_view_stub));
      this.y = ((ViewStub)MessageComposerView.this.findViewById(R.id.message_preview_stub));
      this.l.setOnClickListener(this);
      this.m.setOnClickListener(this);
      this.q.setOnClickListener(this);
      this.t.setOnClickListener(this);
      this.s.setOnClickListener(this);
      this.r.setOnClickListener(this);
      this.u.setOnClickListener(this);
      this.v.setOnClickListener(this);
      this.p.setOnClickListener(this);
      this.w.setOnClickListener(this);
      this.X = com.viber.voip.av.a(av.e.f);
      this.Y = new Runnable()
      {
        public void run()
        {
          if (MessageComposerView.a.this.a(4))
          {
            if (c.k.b.e())
            {
              MessageComposerView.this.performHapticFeedback(0, 2);
              MessageComposerView.this.postDelayed(new bb(this), 125L);
              return;
            }
            MessageComposerView.a.a(MessageComposerView.a.this, SampleTone.VM_START_RECORDING);
            MessageComposerView.a.g(MessageComposerView.a.this);
            return;
          }
          MessageComposerView.a.g(MessageComposerView.a.this);
        }
      };
      this.Z = new Runnable()
      {
        public void run()
        {
          if (MessageComposerView.a.this.a(4))
          {
            if (!c.k.b.e())
            {
              MessageComposerView.a.a(MessageComposerView.a.this, SampleTone.VM_SEND);
              MessageComposerView.a.g(MessageComposerView.a.this);
            }
            return;
          }
          MessageComposerView.a.g(MessageComposerView.a.this);
        }
      };
      this.aa = new Runnable()
      {
        public void run()
        {
          MessageComposerView.a.a(MessageComposerView.a.this, SampleTone.VM_TRASH);
          MessageComposerView.a.g(MessageComposerView.a.this);
        }
      };
      this.ab = new Runnable()
      {
        public void run()
        {
          MessageComposerView.a.a(MessageComposerView.a.this, SampleTone.VM_MAXIMUM_DURATION_REACHED);
        }
      };
    }

    public void b(int paramInt)
    {
      if ((MessageComposerView.g(MessageComposerView.this) != null) && (MessageComposerView.g(MessageComposerView.this).m()));
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt)
            {
            case 2:
            default:
              return;
            case 0:
            case 1:
            case 4:
            case 3:
            }
          }
          while ((!a(new int[] { 1, 4, 7 })) && (!MessageComposerView.w(MessageComposerView.this)));
          this.N.setState(0);
          return;
        }
        while (!a(new int[] { 0, 4, 7 }));
        b(1, true);
        return;
      }
      while (!a(new int[] { 0, 1, 4, 7 }));
      b(4, true);
      return;
      this.N.setState(3);
      this.N.getBotKeyboardPanelTrigger().e_(true);
    }

    public void b(int paramInt1, int paramInt2)
    {
      switch (paramInt2)
      {
      case 1:
      default:
      case 0:
      case 2:
      }
      while (true)
      {
        this.S = false;
        if (this.P)
        {
          this.P = false;
          u();
        }
        if ((1 == paramInt1) || (7 == paramInt1) || ((4 == paramInt1) && (!this.T)) || (8 == paramInt1))
          MessageComposerView.r(MessageComposerView.this).a(2);
        if (this.R != null)
        {
          MessageComposerView.a(MessageComposerView.this, this.R, null);
          this.R = null;
        }
        if (this.Q > 0)
        {
          j(this.Q);
          this.Q = 0;
        }
        MessageComposerView.this.s();
        return;
        if ((this.U) && (8 != paramInt1))
        {
          Z();
          continue;
          d.r.l.a(paramInt1);
        }
      }
    }

    public void b(boolean paramBoolean)
    {
      if (paramBoolean)
        a(null);
      this.m.e_(paramBoolean);
      if (!a(4))
        if (3 == MessageComposerView.q(MessageComposerView.this))
          break label44;
      label44: for (boolean bool = true; ; bool = false)
      {
        g(bool);
        return;
      }
    }

    public void c(int paramInt)
    {
      if (this.S);
      for (int i1 = paramInt; ; i1 = 0)
      {
        this.Q = i1;
        T();
        U();
        if (this.Q <= 0)
          j(paramInt);
        return;
      }
    }

    public void c(boolean paramBoolean)
    {
      h(paramBoolean);
      p();
    }

    public boolean c()
    {
      return this.N.getState() == 6;
    }

    public void d()
    {
      if (this.O == null)
      {
        this.O = ((ViewStub)MessageComposerView.this.findViewById(R.id.chat_ex_input_close)).inflate();
        this.O.setOnClickListener(this);
      }
    }

    protected void d(int paramInt)
    {
      switch (paramInt)
      {
      case 2:
      case 3:
      default:
      case 1:
      case 4:
      }
      do
      {
        do
          return;
        while (this.B != null);
        this.B = ViberApplication.getInstance().getMessagesManager().l();
        this.B.a(this);
        return;
      }
      while (MessageComposerView.i(MessageComposerView.this) != null);
      MessageComposerView.a(MessageComposerView.this, (VideoPttRecordView)MessageComposerView.z(MessageComposerView.this).inflate());
      MessageComposerView.a(MessageComposerView.this, MessageComposerView.h(MessageComposerView.this).a(MessageComposerView.i(MessageComposerView.this)));
      MessageComposerView.i(MessageComposerView.this).a(this, MessageComposerView.j(MessageComposerView.this), MessageComposerView.r(MessageComposerView.this));
    }

    public void d(boolean paramBoolean)
    {
      this.N.setEnabled(paramBoolean);
    }

    public void e()
    {
      if (!g())
      {
        MessageComposerView.g(MessageComposerView.this).u();
        this.o.performClick();
      }
      dj.c(MessageComposerView.this);
    }

    public void e(int paramInt)
    {
      this.S = true;
      this.U = false;
      v();
      MessageComposerView.r(MessageComposerView.this).a(1);
    }

    void e(boolean paramBoolean)
    {
      d(paramBoolean);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void f(int paramInt)
    {
      if (d.r.m.d() > 0)
        d.r.m.e();
      switch (paramInt)
      {
      case 2:
      case 3:
      default:
        if ((MessageComposerView.e(MessageComposerView.this) != null) && (!MessageComposerView.e(MessageComposerView.this).isGroupBehavior()) && (com.viber.voip.block.g.a(new Member(MessageComposerView.e(MessageComposerView.this).getParticipantMemberId()))))
        {
          this.U = false;
          this.N.e();
          MessageComposerView.this.a(null);
        }
        break;
      case 1:
      case 4:
      }
      do
      {
        do
        {
          return;
          if (MessageComposerView.t(MessageComposerView.this).a(com.viber.voip.permissions.n.i))
            break;
          MessageComposerView.t(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this), 26, com.viber.voip.permissions.n.i);
          this.U = false;
          this.N.e();
          return;
          if (!MessageComposerView.t(MessageComposerView.this).a(com.viber.voip.permissions.n.f))
          {
            MessageComposerView.t(MessageComposerView.this).a(MessageComposerView.m(MessageComposerView.this), 27, com.viber.voip.permissions.n.f);
            this.U = false;
            this.N.e();
            return;
          }
          if ((MessageComposerView.i(MessageComposerView.this) != null) && (MessageComposerView.i(MessageComposerView.this).d()));
          for (int i1 = 1; i1 != 0; i1 = 0)
          {
            this.U = false;
            this.N.e();
            return;
          }
          break;
          this.U = true;
          Y();
          this.X.post(this.Y);
          d(paramInt);
          if (this.z == null)
          {
            this.z = ((RecordMessageView)this.x.inflate());
            if (this.z != null)
            {
              this.z.setRecordMessageViewListener(this);
              this.z.setHideAnimationDurationMillis(this.N.getAnimationDuration());
            }
          }
          if (this.z != null)
          {
            this.z.setOnClickListener(null);
            this.z.a(this.N.getSvgShowAnimationDurationMillis());
          }
          ViberApplication.getInstance().getRingtonePlayer().stopStickerPromo();
          com.viber.voip.stickers.b.e().d();
          switch (paramInt)
          {
          case 2:
          case 3:
          default:
            return;
          case 1:
          case 4:
          }
        }
        while (this.B == null);
        this.B.a(MessageComposerView.e(MessageComposerView.this).getId());
        return;
      }
      while (MessageComposerView.i(MessageComposerView.this) == null);
      this.T = true;
      MessageComposerView.i(MessageComposerView.this).a(MessageComposerView.e(MessageComposerView.this).getId(), MessageComposerView.A(MessageComposerView.this));
    }

    public void f(boolean paramBoolean)
    {
      MessageComposerView.this.q();
      if (paramBoolean)
        t();
    }

    public boolean f()
    {
      return this.m.a();
    }

    public void g(int paramInt)
    {
      if (paramInt == 0);
      for (boolean bool = true; ; bool = false)
      {
        i(bool);
        return;
      }
    }

    public boolean g()
    {
      return this.o.a();
    }

    public void h()
    {
      b(1, false);
    }

    public void h(int paramInt)
    {
      this.T = false;
      if (!this.S)
        MessageComposerView.r(MessageComposerView.this).a(2);
      boolean bool = false;
      if (paramInt == 0)
        bool = true;
      if ((!bool) && (3 != paramInt))
        ah.c().d();
      i(bool);
    }

    public boolean i()
    {
      return (!MessageComposerView.w(MessageComposerView.this)) && (MessageComposerView.e(MessageComposerView.this) != null) && (com.viber.voip.messages.d.a.a(MessageComposerView.e(MessageComposerView.this).isOneToOneWithPublicAccount()));
    }

    public void j()
    {
      b(4, false);
    }

    public void k()
    {
      if (!MessageComposerView.v(MessageComposerView.this));
      for (boolean bool = true; ; bool = false)
      {
        d(bool);
        this.N.a(0);
        this.N.getBotKeyboardPanelTrigger().e_(false);
        return;
      }
    }

    public void l()
    {
      this.N.setEnabled(true);
      this.N.a(3);
    }

    public void m()
    {
    }

    public void n()
    {
    }

    public void o()
    {
      t();
    }

    public void onClick(View paramView)
    {
      int i1 = paramView.getId();
      boolean bool;
      if (i1 == R.id.options_menu_open_custom_camera)
      {
        M();
        bool = true;
      }
      while (true)
      {
        if (bool)
          P();
        return;
        if (i1 == R.id.options_menu_search_gifs)
        {
          MessageComposerView.this.c();
          bool = true;
        }
        else if (i1 == R.id.options_menu_send_money)
        {
          if (MessageComposerView.a(MessageComposerView.this) == null)
            break label374;
          MessageComposerView.a(MessageComposerView.this).a();
          bool = true;
        }
        else if (i1 == R.id.options_menu_send_doodle)
        {
          K();
          bool = true;
        }
        else if (i1 == R.id.options_menu_send_location)
        {
          if (MessageComposerView.a(MessageComposerView.this) == null)
            break label374;
          MessageComposerView.a(MessageComposerView.this).l();
          bool = true;
        }
        else if (i1 == R.id.options_menu_send_file)
        {
          L();
          bool = true;
        }
        else if (i1 == R.id.options_menu_share_contact)
        {
          J();
          bool = true;
        }
        else if (i1 == R.id.options_menu_share_group_link)
        {
          if (MessageComposerView.a(MessageComposerView.this) == null)
            break label374;
          MessageComposerView.a(MessageComposerView.this).g();
          bool = true;
        }
        else if (i1 == R.id.btn_send)
        {
          bool = N();
        }
        else
        {
          if (i1 != R.id.chat_ex_input_close)
            break;
          d.n.d.d();
          MessageComposerView.g(MessageComposerView.this).b(true);
          bool = true;
        }
      }
      String str1;
      ChatExtensionLoaderEntity localChatExtensionLoaderEntity1;
      if (i1 == R.id.options_menu_open_chat_extensions)
      {
        if (MessageComposerView.a(MessageComposerView.this) == null)
          break label374;
        com.viber.voip.messages.extensions.d.a.a locala = MessageComposerView.s(MessageComposerView.this).a();
        if (locala == null)
          break label379;
        String str3 = locala.a;
        ChatExtensionLoaderEntity localChatExtensionLoaderEntity2 = locala.b;
        str1 = str3;
        localChatExtensionLoaderEntity1 = localChatExtensionLoaderEntity2;
      }
      while (true)
      {
        if (localChatExtensionLoaderEntity1 != null);
        for (String str2 = "Keyboard Suggestion"; ; str2 = "Keyboard")
        {
          MessageComposerView.a(MessageComposerView.this).a(this.p.b(), str2, localChatExtensionLoaderEntity1, str1);
          bool = true;
          break;
        }
        if ((i1 == R.id.options_menu_create_vote) && (MessageComposerView.a(MessageComposerView.this) != null))
          MessageComposerView.a(MessageComposerView.this).h();
        label374: bool = true;
        break;
        label379: localChatExtensionLoaderEntity1 = null;
        str1 = null;
      }
    }

    protected void p()
    {
      int i1 = 1;
      ArrayList localArrayList = new ArrayList(2);
      if (MessageComposerView.y(MessageComposerView.this))
        localArrayList.add(Integer.valueOf(i1));
      if (i())
        localArrayList.add(Integer.valueOf(4));
      SendButton localSendButton = this.N;
      if (!this.S);
      while (true)
      {
        localSendButton.a(localArrayList, i1);
        return;
        int i2 = 0;
      }
    }

    public void q()
    {
      T();
    }

    public void r()
    {
      v();
      this.D = null;
      this.E = null;
      if (this.a != null)
      {
        this.a.clear();
        this.a = null;
      }
      if (this.V != null)
        this.V.d();
      if (this.ad != null)
        MessageComposerView.n(MessageComposerView.this).removeCallbacks(this.ad);
      if (this.W != null)
        this.W.d();
    }

    public void s()
    {
      this.T = false;
      MessageComposerView.r(MessageComposerView.this).a(2);
    }

    protected void t()
    {
      if ((!this.C) && (a(2)) && (dj.c(MessageComposerView.this.getContext())))
        MessageComposerView.r(MessageComposerView.this).d();
    }

    void u()
    {
      if (a(4))
        if (this.E == null)
          this.E = com.viber.voip.ui.k.a.a(this.N, MessageComposerView.this.getContext(), true);
      for (com.viber.common.ui.c localc = this.E; ; localc = this.D)
      {
        localc.a();
        return;
        if (this.D == null)
          this.D = com.viber.voip.ui.k.a.a(this.N, MessageComposerView.this.getContext(), false);
      }
    }

    void v()
    {
      if (this.D != null)
        this.D.b();
      if (this.E != null)
        this.E.b();
    }

    public void w()
    {
      MessageComposerView.r(MessageComposerView.this).a(3);
      if (this.z != null)
        this.z.a(new ba(this));
    }

    public void x()
    {
      if (this.B != null)
        this.B.b();
      MessageComposerView.this.getActionViewsHelper().e(false);
      this.N.a(0.0F);
    }

    public void y()
    {
      this.N.f();
      Z();
    }

    public void z()
    {
      this.X.post(this.aa);
      ViberApplication.getInstance().getMessagesManager().m().a();
      h();
      Z();
      if (this.B != null)
        this.B.c();
      if (MessageComposerView.a(MessageComposerView.this) != null)
        MessageComposerView.a(MessageComposerView.this).r();
    }

    private class a
      implements Runnable
    {
      private final boolean b;

      a(boolean arg2)
      {
        boolean bool;
        this.b = bool;
      }

      private void a()
      {
        if (this.b)
          MessageComposerView.a.this.o.e_(true);
        if ((MessageComposerView.g(MessageComposerView.this) != null) && (this.b) && (!MessageComposerView.g(MessageComposerView.this).m()) && (!MessageComposerView.g(MessageComposerView.this).m()))
          MessageComposerView.g(MessageComposerView.this).b(1, true);
        MessageComposerView.f localf;
        boolean bool;
        if (MessageComposerView.a.this.e != null)
        {
          localf = MessageComposerView.a.this.e;
          bool = this.b;
          if (!MessageComposerView.a.this.o.b())
            break label170;
        }
        label170: for (int i = 2; ; i = 1)
        {
          localf.a(bool, i, true);
          if ((this.b) && (MessageComposerView.a.this.o.b()))
          {
            MessageComposerView.a.this.o.a(false);
            com.viber.voip.messages.extensions.i.a().c();
          }
          return;
        }
      }

      public void run()
      {
        a();
      }
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
    }
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(List<ab.a> paramList);

    public abstract void a(boolean paramBoolean);

    public abstract void a(boolean paramBoolean1, boolean paramBoolean2);

    public abstract void b();

    public abstract void b(boolean paramBoolean);

    public abstract int c();

    public abstract void d();

    public abstract boolean e();

    public abstract int f();

    public abstract int g();

    public abstract boolean h();

    public abstract LoaderManager i();
  }

  public static abstract interface d
  {
    public abstract void b(boolean paramBoolean);
  }

  public static abstract interface e extends MessageComposerView.d, MessageComposerView.f, MessageComposerView.g, MessageComposerView.h, MessageComposerView.j
  {
  }

  public static abstract interface f
  {
    public abstract void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  }

  public static abstract interface g
  {
    public abstract void a(boolean paramBoolean, MessageComposerView.b paramb);
  }

  public static abstract interface h
  {
    public abstract void c(boolean paramBoolean);
  }

  public static abstract interface i
  {
    public abstract void a();
  }

  public static abstract interface j
  {
    public abstract void a(boolean paramBoolean);
  }

  public static abstract interface k
  {
    public abstract void H_();

    public abstract void a();

    public abstract void a(MessageEntity paramMessageEntity);

    public abstract void a(String paramString1, String paramString2);

    public abstract void a(boolean paramBoolean, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void j();

    public abstract void l();

    public abstract void q();

    public abstract void r();

    public abstract void s();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.MessageComposerView
 * JD-Core Version:    0.6.2
 */