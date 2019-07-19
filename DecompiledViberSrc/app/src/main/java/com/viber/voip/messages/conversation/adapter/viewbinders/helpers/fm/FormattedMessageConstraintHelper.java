package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.d;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;

public class FormattedMessageConstraintHelper extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
{
  public FormattedMessageConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public FormattedMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FormattedMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormattedMessageConstraintHelper);
    try
    {
      int i = localTypedArray.getResourceId(R.styleable.FormattedMessageConstraintHelper_replyViewId, -1);
      int j = localTypedArray.getResourceId(R.styleable.FormattedMessageConstraintHelper_nameViewId, -1);
      int k = localTypedArray.getResourceId(R.styleable.FormattedMessageConstraintHelper_formattedMessageViewId, -1);
      int m = localTypedArray.getResourceId(R.styleable.FormattedMessageConstraintHelper_timestampViewId, -1);
      int n = localTypedArray.getResourceId(R.styleable.FormattedMessageConstraintHelper_referralViewId, -1);
      int i1 = localTypedArray.getInt(R.styleable.FormattedMessageConstraintHelper_messageType, 0);
      a(new c(k, paramContext, i1));
      a(new a(m, k));
      a(new b(k, i, j, i1));
      if ((j != -1) && (n != -1))
      {
        Resources localResources = paramContext.getResources();
        a(new d(j, i, n, localResources.getDimensionPixelOffset(R.dimen.media_message_fm_name_bottom_padding), localResources.getDimensionPixelOffset(R.dimen.message_with_balloon_referral_small_vertical_padding), localResources.getDimensionPixelOffset(R.dimen.message_with_balloon_referral_big_vertical_padding)));
      }
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public static class a
  {
    final FormattedMessage a;
    final boolean b;
    final boolean c;
    final boolean d;

    public a(FormattedMessage paramFormattedMessage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.a = paramFormattedMessage;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.FormattedMessageConstraintHelper
 * JD-Core Version:    0.6.2
 */