package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;

public class FileMessageConstraintHelper extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
{
  public FileMessageConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public FileMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FileMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.FileMessageConstraintHelper);
    try
    {
      int i = localTypedArray.getResourceId(R.styleable.FileMessageConstraintHelper_fileNameViewId, -1);
      int j = localTypedArray.getResourceId(R.styleable.FileMessageConstraintHelper_fileSizeViewId, -1);
      int k = localTypedArray.getResourceId(R.styleable.FileMessageConstraintHelper_replyViewId, -1);
      a(new a(i, j, localTypedArray.getResourceId(R.styleable.FileMessageConstraintHelper_nameViewId, -1), k, localTypedArray.getResourceId(R.styleable.FileMessageConstraintHelper_referralViewId, -1), paramContext.getResources().getDimensionPixelOffset(R.dimen.message_with_balloon_referral_small_vertical_padding)));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.FileMessageConstraintHelper
 * JD-Core Version:    0.6.2
 */