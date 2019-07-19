package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.constraint.a;
import android.support.constraint.a.a.c;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.conversation.aa;

public class RichMessageBottomConstraintHelper extends a
{
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = -1;
  private int n = -1;
  private Guideline o;
  private View p;

  public RichMessageBottomConstraintHelper(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public RichMessageBottomConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public RichMessageBottomConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private int a(BotReplyConfig paramBotReplyConfig)
  {
    return (this.j + this.k) * (-1 + paramBotReplyConfig.getButtonsGroupColumns()) + this.j;
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Resources localResources = paramContext.getResources();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RichMessageBottomConstraintHelper);
    try
    {
      this.m = localTypedArray.getResourceId(R.styleable.RichMessageBottomConstraintHelper_guidelineId, -1);
      this.n = localTypedArray.getResourceId(R.styleable.RichMessageBottomConstraintHelper_sentViaId, -1);
      localTypedArray.recycle();
      this.f = localResources.getDimensionPixelSize(R.dimen.conversations_content_right_padding);
      this.g = localResources.getDimensionPixelSize(R.dimen.rich_message_corner_radius);
      this.h = localResources.getDimensionPixelSize(R.dimen.conversation_user_photo_size);
      this.i = localResources.getDimensionPixelSize(R.dimen.outgoing_message_horizontal_padding);
      this.j = localResources.getDimensionPixelSize(R.dimen.rich_message_cell_size);
      this.l = localResources.getDimensionPixelSize(R.dimen.rich_message_like_view_width);
      this.k = localResources.getDimensionPixelSize(R.dimen.rich_message_button_gap_size);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private boolean b()
  {
    return this.m != -1;
  }

  private Guideline d(ConstraintLayout paramConstraintLayout)
  {
    if (this.o != null)
      return this.o;
    this.o = ((Guideline)paramConstraintLayout.a(this.m));
    return this.o;
  }

  private View e(ConstraintLayout paramConstraintLayout)
  {
    if (this.p != null)
      return this.p;
    this.p = paramConstraintLayout.a(this.n);
    return this.p;
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    super.a(paramConstraintLayout);
    if (!b());
    aa localaa;
    BotReplyConfig localBotReplyConfig;
    do
    {
      return;
      localaa = (aa)getTag();
      localBotReplyConfig = localaa.bx().getPublicAccountMsgInfo().getRichMedia();
    }
    while (localBotReplyConfig == null);
    Guideline localGuideline = d(paramConstraintLayout);
    if (localaa.ap())
    {
      localGuideline.setGuidelineEnd(a(localBotReplyConfig) + this.f - this.g);
      return;
    }
    localGuideline.setGuidelineBegin(a(localBotReplyConfig) + this.h + 2 * this.i - this.g);
  }

  public void c(ConstraintLayout paramConstraintLayout)
  {
    super.c(paramConstraintLayout);
    aa localaa = (aa)getTag();
    d locald = paramConstraintLayout.a(e(paramConstraintLayout));
    if (localaa.ap())
      locald.a(c.c.b).a(this.l + this.g + this.k);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm.RichMessageBottomConstraintHelper
 * JD-Core Version:    0.6.2
 */