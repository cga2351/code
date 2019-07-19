package com.viber.voip.notif.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.Annotation;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.e;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.da;
import com.viber.voip.util.p;

public class d extends b
{
  private final OngoingConferenceCallModel a;
  private final String b;
  private final String c;

  public d(OngoingConferenceCallModel paramOngoingConferenceCallModel, String paramString1, String paramString2)
  {
    this.a = paramOngoingConferenceCallModel;
    this.b = paramString1;
    this.c = paramString2;
  }

  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Annotation localAnnotation = da.a(paramSpannableStringBuilder, "key", "items");
    if (localAnnotation != null)
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramSpannableStringBuilder.getSpanStart(localAnnotation), paramSpannableStringBuilder.getSpanEnd(localAnnotation), 18);
    return paramSpannableStringBuilder;
  }

  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2)
  {
    Annotation localAnnotation = da.a(paramSpannableStringBuilder, "key", paramString1);
    if (localAnnotation != null)
      paramSpannableStringBuilder.replace(paramSpannableStringBuilder.getSpanStart(localAnnotation), paramSpannableStringBuilder.getSpanEnd(localAnnotation), com.viber.common.d.c.a(paramString2));
    return paramSpannableStringBuilder;
  }

  public String R_()
  {
    return e.a(this.a.callToken);
  }

  public int a()
  {
    return e.b(this.a.conversationId);
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.a(true);
    arrayOfn[1] = paramo.b(b(paramContext));
    arrayOfn[2] = paramo.b(paramContext, a(), ViberActionRunner.r.a(paramContext, this.a), 134217728);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_call;
  }

  public CharSequence b(Context paramContext)
  {
    String str = p.a(this.a.conferenceInfo, this.b);
    return a(a(a(new SpannableStringBuilder(paramContext.getResources().getText(R.string.invited_you_to_call_with))), "name", p.a(this.c, null)), "items", str);
  }

  public CharSequence b_(Context paramContext)
  {
    return com.viber.common.d.c.a(this.c);
  }

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.a.d
 * JD-Core Version:    0.6.2
 */