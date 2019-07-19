package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.ivm;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.voip.R.styleable;

public class InstantVideoMessageConstraintHelper extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
{
  public InstantVideoMessageConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public InstantVideoMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public InstantVideoMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.InstantVideoMessageConstraintHelper);
    try
    {
      a(new a(localTypedArray.getResourceId(R.styleable.InstantVideoMessageConstraintHelper_nameViewId, -1), localTypedArray.getResourceId(R.styleable.InstantVideoMessageConstraintHelper_referralViewId, -1), localTypedArray.getResourceId(R.styleable.InstantVideoMessageConstraintHelper_contentViewId, -1)));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.ivm.InstantVideoMessageConstraintHelper
 * JD-Core Version:    0.6.2
 */