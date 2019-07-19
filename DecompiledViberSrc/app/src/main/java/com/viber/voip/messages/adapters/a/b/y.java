package com.viber.voip.messages.adapters.a.b;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.ReplacementSpan;
import android.text.style.StyleSpan;
import android.util.Pair;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.j;
import com.viber.voip.messages.j.a;
import com.viber.voip.messages.j.b;
import com.viber.voip.messages.l;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.ui.b.a.b;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.ce;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dr;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class y<T extends com.viber.voip.messages.adapters.a.a> extends e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final TextView c;
  private final b d;
  private final j e;
  private final ai f;
  private a g;

  public y(Context paramContext, TextView paramTextView, b paramb, j paramj, ai paramai)
  {
    this.b = paramContext;
    this.c = paramTextView;
    this.d = paramb;
    this.e = paramj;
    this.f = paramai;
    this.g = new a(null);
  }

  private Pair<String, Integer> a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (com.viber.voip.messages.m.e(paramConversationLoaderEntity.getConversationType()))
      return new Pair(paramConversationLoaderEntity.getLastMsgText(), Integer.valueOf(l.a(paramConversationLoaderEntity.getLastMediaType())));
    return new Pair("", Integer.valueOf(-1));
  }

  private CharSequence a(T paramT, ConversationLoaderEntity paramConversationLoaderEntity, boolean paramBoolean, com.viber.voip.messages.adapters.a.c.a parama)
  {
    CharSequence localCharSequence1 = paramConversationLoaderEntity.getSpannableSubjectText();
    if (localCharSequence1 != null)
      return localCharSequence1;
    boolean bool1 = paramConversationLoaderEntity.isGroupBehavior();
    boolean bool2 = paramConversationLoaderEntity.hasMessages();
    boolean bool3 = paramConversationLoaderEntity.isNotificationLast();
    String str1 = parama.e();
    int i = paramT.d();
    int j = paramConversationLoaderEntity.getGroupRole();
    boolean bool4;
    String str2;
    label94: String str3;
    label108: e locale;
    String str5;
    int k;
    if ((paramConversationLoaderEntity.isSecret()) || ((SpamController.a(paramConversationLoaderEntity)) && (paramConversationLoaderEntity.getMimeType() != 1002)))
    {
      bool4 = true;
      if (!paramConversationLoaderEntity.isOwner())
        break label210;
      str2 = parama.s();
      if (!paramConversationLoaderEntity.isOwner())
        break label219;
      str3 = parama.r();
      locale = new e(this.b, this.f);
      if (!bool1)
        break label879;
      if (bool2)
        break label545;
      Pair localPair = a(paramConversationLoaderEntity);
      str5 = (String)localPair.first;
      k = ((Integer)localPair.second).intValue();
      if ((!da.a(str5)) || (k > 0))
        break label407;
      if (!paramBoolean)
        break label228;
      locale.a(str2);
      locale.a(str1);
    }
    label303: 
    while (true)
    {
      return locale.a(parama);
      bool4 = false;
      break;
      label210: str2 = paramConversationLoaderEntity.getParticipantBiDiName();
      break label94;
      label219: str3 = paramConversationLoaderEntity.getParticipantBiDiName();
      break label108;
      label228: if (paramConversationLoaderEntity.getMessageId() > 0L)
      {
        locale.a(str2);
        locale.a(parama.f());
      }
      else
      {
        if (paramConversationLoaderEntity.showInvitePreviewMessageCommunity())
        {
          long l = paramConversationLoaderEntity.getCreatorParticipantInfoId();
          com.viber.voip.model.entity.m localm = this.d.b(l);
          String str7;
          String str8;
          if (localm != null)
          {
            str7 = dg.a(localm, paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole());
            str8 = c.a(str7);
            if (!paramConversationLoaderEntity.isNotJoinedCommunity())
              break label373;
          }
          label373: for (String str9 = this.b.getString(R.string.invited_you_to_join_community_title, new Object[] { str8 }); ; str9 = this.b.getString(R.string.invited_you_to_community_title, new Object[] { str8 }))
          {
            locale.a(Html.fromHtml(str9));
            locale.a(str8);
            break;
            str7 = this.b.getString(R.string.unknown);
            break label303;
          }
        }
        locale.a(str1);
        continue;
        String str6;
        j.b localb3;
        if (com.viber.voip.messages.m.a(parama.a(), paramConversationLoaderEntity.getSenderPhone()))
        {
          str6 = parama.r();
          localb3 = this.e.a(k, paramConversationLoaderEntity.getMessageExtraFlags(), str5, "", paramConversationLoaderEntity, this.f, i, bool4);
          locale.a(str6);
          if (paramBoolean)
            break label539;
        }
        for (boolean bool7 = true; ; bool7 = false)
        {
          locale.b(bool7);
          locale.a(localb3.b);
          locale.a(localb3.a.toString(), parama.f());
          break;
          str6 = this.d.a(paramConversationLoaderEntity.getSenderPhone(), paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole(), paramConversationLoaderEntity.getSenderName());
          break label429;
        }
        if ((bool3) && (!bool4))
        {
          locale.a(this.e.a(paramConversationLoaderEntity.getBody(), paramConversationLoaderEntity.getConversationType(), j, str3).a);
        }
        else if (paramConversationLoaderEntity.isPinMessage())
        {
          Pin localPin = paramConversationLoaderEntity.getParsedMsgInfo().getPin();
          if (Pin.a.CREATE == localPin.getAction())
          {
            CharSequence localCharSequence2 = dg.a(localPin, paramConversationLoaderEntity.getBodySpans(), this.f, this.d, paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole(), false);
            locale.a(str2);
            locale.b(true);
            locale.a(R.drawable.ic_chat_list_pin_inset);
            locale.a(this.b.getString(R.string.snippet_type_pin, new Object[] { localCharSequence2 }));
            locale.a(true);
          }
          else if (Pin.a.DELETE == localPin.getAction())
          {
            if (paramConversationLoaderEntity.isIncoming());
            for (String str4 = this.b.getString(R.string.unpinned_msg_notification, new Object[] { str2 }); ; str4 = this.b.getString(R.string.your_pinned_msg_notification))
            {
              locale.a(str4);
              break;
            }
          }
        }
        else
        {
          j.b localb2 = this.e.a(paramConversationLoaderEntity.getMimeType(), paramConversationLoaderEntity.getMessageExtraFlags(), paramConversationLoaderEntity.getBody(), paramConversationLoaderEntity.getBodySpans(), paramConversationLoaderEntity, this.f, i, bool4);
          locale.a(str2);
          boolean bool5;
          if (!paramBoolean)
          {
            bool5 = true;
            locale.b(bool5);
            locale.a(localb2.b);
            if ("no_sp".equals(paramConversationLoaderEntity.getBodySpans()))
              break label873;
          }
          label873: for (boolean bool6 = true; ; bool6 = false)
          {
            locale.a(bool6);
            locale.a(localb2.a.toString(), parama.f());
            break;
            bool5 = false;
            break label806;
          }
          label879: if ((bool2) && (!paramConversationLoaderEntity.isNewUserJoinedConversation()))
          {
            if ((bool3) && (!bool4))
            {
              locale.a(this.e.a(paramConversationLoaderEntity.getBody(), paramConversationLoaderEntity.getConversationType(), j, str3).a.toString());
            }
            else
            {
              j.b localb1 = this.e.a(paramConversationLoaderEntity.getMimeType(), paramConversationLoaderEntity.getMessageExtraFlags(), paramConversationLoaderEntity.getBody(), paramConversationLoaderEntity.getBodySpans(), paramConversationLoaderEntity, this.f, i, bool4);
              locale.a(localb1.b);
              locale.a(localb1.a);
              locale.c(paramConversationLoaderEntity.isMissedCall());
            }
          }
          else if (paramConversationLoaderEntity.isNewUserJoinedConversation())
            locale.a(c(paramConversationLoaderEntity, parama));
          else
            locale.a(str1);
        }
      }
    }
  }

  private CharSequence a(ConversationLoaderEntity paramConversationLoaderEntity, com.viber.voip.messages.adapters.a.c.a parama)
  {
    if (paramConversationLoaderEntity.isGroupBehavior());
    for (String str = parama.a(paramConversationLoaderEntity.getGroupId(), paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole()); da.a(str); str = parama.a(paramConversationLoaderEntity.getParticipantMemberId(), paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.isSecret(), paramConversationLoaderEntity.isVlnConversation()))
    {
      this.g.a();
      return "";
    }
    d locald = new d(null);
    locald.a(str);
    locald.a(0);
    this.g.a(new z(this, locald, parama));
    return locald.a(parama);
  }

  private void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama, ConversationLoaderEntity paramConversationLoaderEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if ((paramConversationLoaderEntity.getBody() != null) && (paramConversationLoaderEntity.getBody().toLowerCase().contains(parama.p().trim().toLowerCase())));
    for (int j = i; (paramBoolean2) && (j == 0); j = 0)
    {
      this.c.setVisibility(8);
      return;
    }
    Object localObject = "";
    int k;
    if (!paramBoolean2)
    {
      k = i;
      if (k != 0)
        localObject = a(paramConversationLoaderEntity, parama);
      if ((!da.a((CharSequence)localObject)) || (paramBoolean2) || (paramConversationLoaderEntity.isSecret()) || (paramConversationLoaderEntity.isNewUserJoinedConversation()) || (!paramConversationLoaderEntity.canWrite()) || (paramConversationLoaderEntity.isDisabledConversation()) || (paramT.l() != 0))
        break label209;
    }
    while (true)
    {
      if (i != 0)
        localObject = b(paramConversationLoaderEntity, parama);
      if (da.a((CharSequence)localObject))
      {
        localObject = a(paramT, paramConversationLoaderEntity, paramBoolean2, parama);
        paramConversationLoaderEntity.setSpannableSubjectText((CharSequence)localObject);
      }
      this.c.setVisibility(0);
      this.c.setText((CharSequence)localObject);
      a(paramT, parama, paramBoolean1);
      return;
      k = 0;
      break;
      label209: i = 0;
    }
  }

  private void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama, boolean paramBoolean)
  {
    int i = paramT.a().getMimeType();
    String str1 = parama.p();
    String str2;
    int j;
    if (!da.a(str1))
    {
      str2 = str1.trim();
      if (i != 0)
        break label125;
      j = 1;
      boolean bool = ce.l.matcher(str2).matches();
      String str3 = null;
      if (bool)
        str3 = dr.a(ViberApplication.getInstance(), str2, null);
      if (!paramBoolean)
        break label131;
      if ((!dg.a(this.c, str2, 20)) && (str3 != null))
        dg.a(this.c, str3, 20);
      if (j != 0)
        dg.a(this.c, str2, 27);
    }
    label125: 
    while (j == 0)
    {
      return;
      j = 0;
      break;
    }
    label131: dg.a(this.c, str2, 60);
  }

  private CharSequence b(ConversationLoaderEntity paramConversationLoaderEntity, com.viber.voip.messages.adapters.a.c.a parama)
  {
    if (!paramConversationLoaderEntity.hasMessageDraft())
      return "";
    b localb = new b(this.b, this.f, this.d, paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole());
    localb.a(paramConversationLoaderEntity.getMessageDraft(), paramConversationLoaderEntity.getMessageDraftSpans());
    return localb.a(parama);
  }

  private String c(ConversationLoaderEntity paramConversationLoaderEntity, com.viber.voip.messages.adapters.a.c.a parama)
  {
    if (paramConversationLoaderEntity.isUserRejoinedConversation())
    {
      if (paramConversationLoaderEntity.isEngagementConversation())
        return parama.b(paramConversationLoaderEntity.getContactName());
      return parama.C();
    }
    if (paramConversationLoaderEntity.isEngagementConversation())
      return parama.a(paramConversationLoaderEntity.getContactName());
    return parama.B();
  }

  public void a()
  {
    super.a();
    this.g.a();
  }

  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    boolean bool1 = localConversationLoaderEntity.isGroupBehavior();
    String str = parama.p();
    if ((!parama.w()) && (!da.a(str)));
    for (boolean bool2 = true; ; bool2 = false)
    {
      a(paramT, parama, localConversationLoaderEntity, bool1, bool2);
      return;
    }
  }

  private static class a
  {
    private static final int[] a = { 1, 2, 3, 4 };
    private ValueAnimator b;

    void a()
    {
      if (this.b != null)
      {
        this.b.cancel();
        this.b = null;
      }
    }

    void a(final a parama)
    {
      if (this.b == null)
      {
        this.b = ValueAnimator.ofInt(a);
        this.b.setDuration(1000L);
        this.b.setRepeatCount(-1);
        this.b.addListener(new a.b()
        {
          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            paramAnonymousAnimator.removeListener(this);
            ((ValueAnimator)paramAnonymousAnimator).removeAllUpdateListeners();
          }
        });
      }
      this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int c;

        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = Math.min(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), "...".length());
          if (i != this.c)
          {
            this.c = i;
            if (parama != null)
              parama.a(i);
          }
        }
      });
      this.b.start();
    }

    static abstract interface a
    {
      public abstract void a(int paramInt);
    }
  }

  private static class b
  {
    final int a;
    final int b;
    private Context c;
    private ai d;
    private b e;
    private String f;
    private String g;

    b(Context paramContext, ai paramai, b paramb, int paramInt1, int paramInt2)
    {
      this.c = paramContext;
      this.d = paramai;
      this.e = paramb;
      this.a = paramInt1;
      this.b = paramInt2;
    }

    private void a(SpannableStringBuilder paramSpannableStringBuilder)
    {
      paramSpannableStringBuilder.append(da.a(this.f, this.d, this.e, this.g, false, false, true, false, aj.c, this.a, this.b));
    }

    private void a(SpannableStringBuilder paramSpannableStringBuilder, com.viber.voip.messages.adapters.a.c.a parama)
    {
      aa.a(parama, paramSpannableStringBuilder, R.drawable.ic_chat_list_edit_inset, R.attr.callsRecentItemTypeMissedColor);
      String str = this.c.getString(R.string.chat_list_draft, new Object[] { "" });
      aa.a(paramSpannableStringBuilder, this.c, str, R.style.ChatListSubjectTextAppearance_Red);
    }

    public Spanned a(com.viber.voip.messages.adapters.a.c.a parama)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      a(localSpannableStringBuilder, parama);
      a(localSpannableStringBuilder);
      return localSpannableStringBuilder;
    }

    public void a(String paramString1, String paramString2)
    {
      this.f = paramString1;
      this.g = paramString2;
    }
  }

  private static class c extends ReplacementSpan
  {
    private final String a;

    private c(int paramInt)
    {
      int i = Math.min("...".length(), Math.max(0, paramInt));
      if (i == 0)
      {
        this.a = "";
        return;
      }
      this.a = "...".substring(0, i);
    }

    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCanvas.drawText(this.a, paramFloat, paramInt4, paramPaint);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject)
        return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      c localc = (c)paramObject;
      return this.a.equals(localc.a);
    }

    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      return (int)(0.5F + paramPaint.measureText("..."));
    }

    public int hashCode()
    {
      return this.a.hashCode();
    }
  }

  private static class d
  {
    private CharSequence a;
    private int b;
    private SpannableStringBuilder c;

    private void a()
    {
      this.c = null;
    }

    public Spanned a(com.viber.voip.messages.adapters.a.c.a parama)
    {
      if (this.c == null)
      {
        this.c = new SpannableStringBuilder(this.a);
        this.c.setSpan(new StyleSpan(2), 0, this.c.length(), 33);
      }
      y.c[] arrayOfc = (y.c[])this.c.getSpans(0, this.c.length(), y.c.class);
      if (arrayOfc.length > 0)
        this.c.removeSpan(arrayOfc[0]);
      while (true)
      {
        y.c localc = new y.c(this.b, null);
        this.c.setSpan(localc, -1 + this.c.length(), this.c.length(), 33);
        return new SpannedString(this.c);
        this.c.append(" ");
      }
    }

    public void a(int paramInt)
    {
      this.b = paramInt;
    }

    public void a(CharSequence paramCharSequence)
    {
      this.a = paramCharSequence;
      a();
    }
  }

  private static class e
  {
    private final Context a;
    private final ai b;
    private String c;
    private int d;
    private CharSequence e;
    private boolean f;
    private boolean g;
    private boolean h;

    public e(Context paramContext, ai paramai)
    {
      this.a = paramContext;
      this.b = paramai;
    }

    private int a()
    {
      if (this.h)
        return R.attr.callsRecentItemTypeMissedColor;
      return R.attr.conversationsListItemSubjectTextColor;
    }

    private boolean a(SpannableStringBuilder paramSpannableStringBuilder)
    {
      if ((!this.g) || (da.a(this.c)))
        return false;
      return aa.a(paramSpannableStringBuilder, this.a, this.c + ": ", b());
    }

    private boolean a(SpannableStringBuilder paramSpannableStringBuilder, com.viber.voip.messages.adapters.a.c.a parama)
    {
      return aa.a(parama, paramSpannableStringBuilder, this.d, a());
    }

    private int b()
    {
      return R.style.ParticipantNameTextAppearance;
    }

    private boolean b(SpannableStringBuilder paramSpannableStringBuilder)
    {
      if (da.a(this.e))
        return false;
      return aa.a(paramSpannableStringBuilder, this.a, this.e, c());
    }

    private int c()
    {
      if (this.h)
        return R.style.ChatListSubjectTextAppearance_Red;
      return R.style.ChatListSubjectTextAppearance;
    }

    private boolean c(SpannableStringBuilder paramSpannableStringBuilder)
    {
      if (!this.f)
        return false;
      this.b.a(paramSpannableStringBuilder, aj.c);
      return true;
    }

    public Spanned a(com.viber.voip.messages.adapters.a.c.a parama)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      a(localSpannableStringBuilder);
      a(localSpannableStringBuilder, parama);
      b(localSpannableStringBuilder);
      c(localSpannableStringBuilder);
      return localSpannableStringBuilder;
    }

    public void a(int paramInt)
    {
      this.d = paramInt;
    }

    public void a(CharSequence paramCharSequence)
    {
      this.e = paramCharSequence;
    }

    public void a(String paramString)
    {
      this.c = paramString;
    }

    public void a(String paramString1, String paramString2)
    {
      if (da.a(paramString1));
      while (true)
      {
        this.e = paramString2;
        return;
        paramString2 = paramString1;
      }
    }

    public void a(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }

    public void b(boolean paramBoolean)
    {
      this.g = paramBoolean;
    }

    public void c(boolean paramBoolean)
    {
      this.h = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.y
 * JD-Core Version:    0.6.2
 */