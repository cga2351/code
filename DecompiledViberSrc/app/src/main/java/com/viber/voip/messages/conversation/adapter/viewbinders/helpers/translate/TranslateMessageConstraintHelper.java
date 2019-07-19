package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.translate;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.text.c;

public class TranslateMessageConstraintHelper extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
{
  public TranslateMessageConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public TranslateMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TranslateMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.TranslateMessageConstraintHelper);
    try
    {
      int i = localTypedArray.getResourceId(R.styleable.TranslateMessageConstraintHelper_textMessageViewId, -1);
      int j = localTypedArray.getResourceId(R.styleable.TranslateMessageConstraintHelper_translateViewId, -1);
      int k = localTypedArray.getResourceId(R.styleable.TranslateMessageConstraintHelper_nameViewId, -1);
      int m = localTypedArray.getResourceId(R.styleable.TranslateMessageConstraintHelper_replyViewId, -1);
      int n = localTypedArray.getResourceId(R.styleable.TranslateMessageConstraintHelper_referralViewId, -1);
      int i1 = localTypedArray.getInt(R.styleable.TextMessageConstraintHelper_messageType, 0);
      Resources localResources = paramContext.getResources();
      int i2 = localResources.getDimensionPixelOffset(R.dimen.message_with_balloon_referral_small_vertical_padding);
      int i3 = localResources.getDimensionPixelSize(R.dimen.balloon_content_top_padding);
      if (i1 == 0);
      for (int i4 = localResources.getDimensionPixelSize(R.dimen.balloon_name_bottom_padding); ; i4 = i3)
      {
        a(new a(i, j, k, m, n, i2));
        a(new c(i, k, m, n, i3, i4, i3));
        return;
      }
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.translate.TranslateMessageConstraintHelper
 * JD-Core Version:    0.6.2
 */