package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;

public class StickerMessageConstraintHelper extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
{
  public StickerMessageConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public StickerMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public StickerMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.StickerMessageConstraintHelper);
    try
    {
      int i = localTypedArray.getResourceId(R.styleable.StickerMessageConstraintHelper_replyViewId, -1);
      int j = localTypedArray.getResourceId(R.styleable.StickerMessageConstraintHelper_nameViewId, -1);
      int k = localTypedArray.getResourceId(R.styleable.StickerMessageConstraintHelper_referralViewId, -1);
      int m = localTypedArray.getResourceId(R.styleable.StickerMessageConstraintHelper_contentViewId, -1);
      if (j != -1)
        a(new a(j, i, k, paramContext.getResources().getDimensionPixelOffset(R.dimen.media_message_name_bottom_padding)));
      a(new b(i, k, m));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker.StickerMessageConstraintHelper
 * JD-Core Version:    0.6.2
 */