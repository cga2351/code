package com.viber.voip.user;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ListView;
import com.viber.voip.util.dj;

public class UserDetailPhotoSetter extends ImageViewDrawableSetter
{
  private static final int EVENT_COUNT = 3;
  private float[] lastYs = new float[3];
  private boolean mDisableTouch;
  private View mParentTarget;
  private int photoViewHeight = -1;
  private float startY = -1.0F;
  View.OnTouchListener touchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      switch (paramAnonymousMotionEvent.getAction())
      {
      default:
      case 2:
      case 1:
      }
      do
      {
        ListView localListView;
        do
        {
          do
          {
            return false;
            UserDetailPhotoSetter.this.updateEventStates(paramAnonymousMotionEvent);
            localListView = (ListView)paramAnonymousView;
            if ((!UserDetailPhotoSetter.this.isFirstVisible(localListView)) || (UserDetailPhotoSetter.this.startY != -1.0F) || (UserDetailPhotoSetter.this.mParentTarget == null))
              break;
            UserDetailPhotoSetter.access$202(UserDetailPhotoSetter.this, paramAnonymousMotionEvent.getY());
          }
          while (UserDetailPhotoSetter.this.photoViewHeight != -1);
          UserDetailPhotoSetter.access$402(UserDetailPhotoSetter.this, UserDetailPhotoSetter.this.mParentTarget.getMeasuredHeight());
          return false;
        }
        while ((UserDetailPhotoSetter.this.startY == -1.0F) || (localListView.isPressed()));
        UserDetailPhotoSetter.this.pullDown(UserDetailPhotoSetter.this.startY);
        return false;
      }
      while (UserDetailPhotoSetter.this.photoViewHeight == -1);
      UserDetailPhotoSetter.this.initializeYsHistory();
      UserDetailPhotoSetter.access$202(UserDetailPhotoSetter.this, -1.0F);
      UserDetailPhotoSetter.this.ensureHeaderPosition();
      return false;
    }
  };

  private float average(float[] paramArrayOfFloat)
  {
    float f = 0.0F;
    for (int i = 0; i < 3; i++)
      f += paramArrayOfFloat[i];
    return f / 3.0F;
  }

  public static void collapse(final int paramInt, View paramView1, final View paramView2)
  {
    Animation local2 = new Animation()
    {
      int newHeight = this.val$v.getMeasuredHeight();

      protected void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        if (this.newHeight > paramInt)
          this.newHeight = ((int)(this.newHeight - paramAnonymousFloat * (this.newHeight - paramInt)));
        this.val$v.getLayoutParams().height = this.newHeight;
        this.val$v.requestLayout();
        paramView2.getLayoutParams().height = this.newHeight;
        paramView2.requestLayout();
      }

      public boolean willChangeBounds()
      {
        return true;
      }
    };
    local2.setDuration((int)(paramView1.getMeasuredHeight() / paramView1.getContext().getResources().getDisplayMetrics().density));
    paramView1.startAnimation(local2);
  }

  private void ensureHeaderPosition()
  {
    if ((getTarget() != null) && (this.mParentTarget != null))
      collapse(this.photoViewHeight, this.mParentTarget, getTarget());
  }

  private void initializeYsHistory()
  {
    for (int i = 0; i < 3; i++)
      this.lastYs[i] = 0.0F;
  }

  private boolean isFirstVisible(ListView paramListView)
  {
    if (paramListView.getCount() == 0);
    do
    {
      return true;
      if (paramListView.getFirstVisiblePosition() != 0)
        break;
    }
    while ((paramListView.getChildAt(0) != null) && (paramListView.getChildAt(0).getTop() >= 0));
    return false;
    return false;
  }

  private void pullDown(float paramFloat)
  {
    int j;
    int k;
    if (this.mParentTarget != null)
    {
      int i = (int)Math.max(average(this.lastYs) - paramFloat, 0.0F);
      j = this.photoViewHeight + i / 2;
      k = this.mParentTarget.getWidth();
      if ((dj.c(this.mParentTarget.getContext())) || (this.mDisableTouch))
        break label93;
    }
    label93: for (int m = 1; ; m = 0)
    {
      if (((m != 0) && (j <= k)) || ((m == 0) && (j < 720)))
        setPhotoScroll(j);
      return;
    }
  }

  private void setPhotoScroll(int paramInt)
  {
    getTarget().getLayoutParams().height = paramInt;
    getTarget().requestLayout();
    this.mParentTarget.getLayoutParams().height = paramInt;
    this.mParentTarget.requestLayout();
  }

  private View.OnClickListener setupClickListener(Fragment paramFragment, Uri paramUri, boolean paramBoolean, int paramInt)
  {
    if (getTarget() == null)
      return null;
    return new PhotoClickListener(paramFragment, paramUri, paramBoolean, paramInt);
  }

  private void updateEventStates(MotionEvent paramMotionEvent)
  {
    System.arraycopy(this.lastYs, 1, this.lastYs, 0, 2);
    float f = paramMotionEvent.getY();
    this.lastYs[2] = f;
  }

  public View.OnTouchListener getTouchListener()
  {
    return this.touchListener;
  }

  public View.OnClickListener setupContactDetailsPhotoForClick(Fragment paramFragment, ImageView paramImageView, boolean paramBoolean1, View paramView, Uri paramUri, boolean paramBoolean2)
  {
    setTarget(paramImageView);
    this.mParentTarget = paramView;
    this.mDisableTouch = paramBoolean1;
    return setupClickListener(paramFragment, paramUri, paramBoolean2, 1);
  }

  public View.OnClickListener setupContactPhotoForClick(Fragment paramFragment, boolean paramBoolean1, ImageView paramImageView, View paramView, Uri paramUri, boolean paramBoolean2)
  {
    setTarget(paramImageView);
    this.mParentTarget = paramView;
    this.mDisableTouch = paramBoolean1;
    return setupClickListener(paramFragment, paramUri, paramBoolean2, 0);
  }

  private static final class PhotoClickListener
    implements View.OnClickListener
  {
    private final boolean mExpandPhotoOnClick;
    private final Fragment mFragment;
    private final int mMode;
    private final Uri mPhotoUri;

    public PhotoClickListener(Fragment paramFragment, Uri paramUri, boolean paramBoolean, int paramInt)
    {
      this.mFragment = paramFragment;
      this.mPhotoUri = paramUri;
      this.mExpandPhotoOnClick = paramBoolean;
      this.mMode = paramInt;
    }

    public void onClick(View paramView)
    {
      Intent localIntent = PhotoSelectionActivity.buildIntent(this.mPhotoUri, paramView, this.mMode, this.mExpandPhotoOnClick);
      this.mFragment.startActivityForResult(localIntent, 1233);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.UserDetailPhotoSetter
 * JD-Core Version:    0.6.2
 */