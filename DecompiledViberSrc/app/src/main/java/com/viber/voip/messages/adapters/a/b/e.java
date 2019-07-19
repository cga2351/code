package com.viber.voip.messages.adapters.a.b;

import android.content.Context;
import android.support.v4.text.BidiFormatter;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import com.viber.common.d.c;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.da;
import com.viber.voip.util.p;

public class e extends com.viber.voip.ui.g.e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private final Context a;
  private final ViberTextView b;
  private BidiFormatter c;
  private SpannableStringBuilder d;
  private SpannableStringBuilder e;

  public e(Context paramContext, ViberTextView paramViberTextView)
  {
    this.a = paramContext;
    this.b = paramViberTextView;
  }

  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Annotation localAnnotation = da.a(paramSpannableStringBuilder, "key", "items");
    if (localAnnotation != null)
      paramSpannableStringBuilder.setSpan(new TypefaceSpan("sans-serif-medium"), paramSpannableStringBuilder.getSpanStart(localAnnotation), paramSpannableStringBuilder.getSpanEnd(localAnnotation), 18);
    return paramSpannableStringBuilder;
  }

  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2)
  {
    Annotation localAnnotation = da.a(paramSpannableStringBuilder, "key", paramString1);
    if (localAnnotation != null)
      paramSpannableStringBuilder.replace(paramSpannableStringBuilder.getSpanStart(localAnnotation), paramSpannableStringBuilder.getSpanEnd(localAnnotation), c.a(paramString2));
    return paramSpannableStringBuilder;
  }

  private boolean a(ConversationLoaderEntity paramConversationLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    return (!paramOngoingConferenceCallModel.conferenceInfo.isSelfInitiated()) && (paramConversationLoaderEntity != null) && (paramConversationLoaderEntity.isConversation1on1());
  }

  private BidiFormatter b()
  {
    if (this.c == null)
      this.c = BidiFormatter.getInstance();
    return this.c;
  }

  private SpannableStringBuilder c()
  {
    if (this.d == null)
      this.d = a(new SpannableStringBuilder(this.a.getText(R.string.invited_you_to_call_with)));
    return this.d;
  }

  private SpannableStringBuilder f()
  {
    if (this.e == null)
      this.e = a(new SpannableStringBuilder(this.a.getText(R.string.ongoing_call_with)));
    return this.e;
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    OngoingConferenceCallModel localOngoingConferenceCallModel = parama.h();
    if (localOngoingConferenceCallModel == null)
      return;
    String str;
    if (a(localConversationLoaderEntity, localOngoingConferenceCallModel))
      str = p.a(localOngoingConferenceCallModel.conferenceInfo, localConversationLoaderEntity.getParticipantMemberId());
    for (SpannableStringBuilder localSpannableStringBuilder1 = a(c(), "name", p.a(localConversationLoaderEntity.getParticipantName(), b())); ; localSpannableStringBuilder1 = f())
    {
      SpannableStringBuilder localSpannableStringBuilder2 = a(localSpannableStringBuilder1, "items", str);
      this.b.a(SpannableString.valueOf(localSpannableStringBuilder2));
      return;
      str = p.a(localOngoingConferenceCallModel.conferenceInfo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.e
 * JD-Core Version:    0.6.2
 */