package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Annotation;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.messages.conversation.adapter.d.y;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.co;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import javax.annotation.Nullable;

public class ap extends e<a, i>
  implements View.OnClickListener
{
  private static final Logger a = ViberEnv.getLogger();
  private final TextView b;
  private final y c;

  @Nullable
  private GroupReferralInfo d;

  public ap(TextView paramTextView, y paramy)
  {
    this.b = paramTextView;
    this.c = paramy;
    this.b.setOnClickListener(this);
  }

  public void a(a parama, i parami)
  {
    boolean bool = true;
    super.a(parama, parami);
    aa localaa = parama.c();
    this.d = localaa.bx().getGroupReferralInfo();
    if (this.d != null)
    {
      dj.b(this.b, bool);
      i.a locala;
      int i;
      Drawable localDrawable;
      if (parama.n())
      {
        locala = parami.I();
        if (locala.f)
        {
          i = parami.u();
          localDrawable = parami.ac();
          this.b.setShadowLayer(locala.b, locala.c, locala.d, locala.e);
        }
      }
      while (true)
      {
        this.b.setTextColor(i);
        co.a(this.b, localDrawable);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.b.getContext().getText(R.string.from_template));
        Annotation localAnnotation = da.a(localSpannableStringBuilder, "key", "name");
        if (localAnnotation != null)
        {
          int j = localSpannableStringBuilder.getSpanStart(localAnnotation);
          int k = localSpannableStringBuilder.getSpanEnd(localAnnotation);
          localSpannableStringBuilder.setSpan(da.a(), j, k, 33);
          localSpannableStringBuilder.replace(j, k, c.a(dg.b(this.d.getGroupName())));
        }
        this.b.setText(localSpannableStringBuilder);
        return;
        i = locala.a;
        localDrawable = parami.ad();
        break;
        if ((localaa.ap()) && (localaa.ar()) && ((0x10 & localaa.E()) == 0));
        while (true)
        {
          if (!bool)
            break label293;
          i = parami.r();
          localDrawable = parami.ad();
          break;
          bool = false;
        }
        label293: i = parami.u();
        localDrawable = parami.ac();
      }
    }
    dj.b(this.b, false);
  }

  public void onClick(View paramView)
  {
    if (this.d != null)
      this.c.a(this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ap
 * JD-Core Version:    0.6.2
 */