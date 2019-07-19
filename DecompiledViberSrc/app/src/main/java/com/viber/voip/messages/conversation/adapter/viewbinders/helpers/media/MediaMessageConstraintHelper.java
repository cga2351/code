package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;

public class MediaMessageConstraintHelper extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
{
  public MediaMessageConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public MediaMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public MediaMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MediaMessageConstraintHelper);
    int i = localTypedArray.getResourceId(R.styleable.MediaMessageConstraintHelper_descriptionViewId, 0);
    int j = localTypedArray.getResourceId(R.styleable.MediaMessageConstraintHelper_mediaViewId, 0);
    int k = localTypedArray.getResourceId(R.styleable.MediaMessageConstraintHelper_timestampViewId, 0);
    int m = localTypedArray.getResourceId(R.styleable.MediaMessageConstraintHelper_nameViewId, -1);
    int n = localTypedArray.getResourceId(R.styleable.MediaMessageConstraintHelper_replyViewId, -1);
    int i1 = localTypedArray.getResourceId(R.styleable.MediaMessageConstraintHelper_referralViewId, -1);
    int i2 = localTypedArray.getResourceId(R.styleable.MediaMessageConstraintHelper_mediaTimestampBottomConstraintViewId, 0);
    int i3 = localTypedArray.getInt(R.styleable.MediaMessageConstraintHelper_messageType, 0);
    localTypedArray.recycle();
    if (j != 0)
      a(new c(paramContext, j, i3));
    if ((i != 0) && (j != 0) && (k != 0) && (i2 != 0))
      a(new a(i, j, k, i2));
    if ((m != -1) && (i1 != -1))
    {
      Resources localResources = paramContext.getResources();
      a(new d(m, n, i1, localResources.getDimensionPixelOffset(R.dimen.media_message_name_bottom_padding), localResources.getDimensionPixelOffset(R.dimen.message_with_balloon_referral_small_vertical_padding), localResources.getDimensionPixelOffset(R.dimen.message_with_balloon_referral_big_vertical_padding)));
    }
  }

  public static class a
  {
    final int a;
    final int b;

    public a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.MediaMessageConstraintHelper
 * JD-Core Version:    0.6.2
 */