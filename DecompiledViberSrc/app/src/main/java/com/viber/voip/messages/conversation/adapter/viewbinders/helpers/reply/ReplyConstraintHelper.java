package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.reply;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.voip.R.styleable;

public class ReplyConstraintHelper extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
{
  public ReplyConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public ReplyConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ReplyConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = -1;
    int j;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ReplyConstraintHelper);
      j = localTypedArray.getResourceId(R.styleable.ReplyConstraintHelper_authorViewId, i);
      i = localTypedArray.getResourceId(R.styleable.ReplyConstraintHelper_quoteViewId, i);
      localTypedArray.recycle();
    }
    while (true)
    {
      a(new a(j, i));
      return;
      j = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.reply.ReplyConstraintHelper
 * JD-Core Version:    0.6.2
 */