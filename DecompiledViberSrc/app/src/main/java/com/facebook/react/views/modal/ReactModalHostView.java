package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R.style;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.common.ContextUtils;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class ReactModalHostView extends ViewGroup
  implements LifecycleEventListener
{
  private String mAnimationType;

  @Nullable
  private Dialog mDialog;
  private boolean mHardwareAccelerated;
  private DialogRootViewGroup mHostView;

  @Nullable
  private OnRequestCloseListener mOnRequestCloseListener;

  @Nullable
  private DialogInterface.OnShowListener mOnShowListener;
  private boolean mPropertyRequiresNewDialog;
  private boolean mTransparent;

  public ReactModalHostView(Context paramContext)
  {
    super(paramContext);
    ((ReactContext)paramContext).addLifecycleEventListener(this);
    this.mHostView = new DialogRootViewGroup(paramContext);
  }

  private void dismiss()
  {
    if (this.mDialog != null)
    {
      if (this.mDialog.isShowing())
      {
        Activity localActivity = (Activity)ContextUtils.findContextOfType(this.mDialog.getContext(), Activity.class);
        if ((localActivity == null) || (!localActivity.isFinishing()))
          this.mDialog.dismiss();
      }
      this.mDialog = null;
      ((ViewGroup)this.mHostView.getParent()).removeViewAt(0);
    }
  }

  private View getContentView()
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.addView(this.mHostView);
    localFrameLayout.setFitsSystemWindows(true);
    return localFrameLayout;
  }

  @Nullable
  private Activity getCurrentActivity()
  {
    return ((ReactContext)getContext()).getCurrentActivity();
  }

  private void updateProperties()
  {
    Assertions.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
    Activity localActivity = getCurrentActivity();
    if (localActivity != null)
    {
      if ((0x400 & localActivity.getWindow().getAttributes().flags) == 0)
        break label68;
      this.mDialog.getWindow().addFlags(1024);
    }
    while (this.mTransparent)
    {
      this.mDialog.getWindow().clearFlags(2);
      return;
      label68: this.mDialog.getWindow().clearFlags(1024);
    }
    this.mDialog.getWindow().setDimAmount(0.5F);
    this.mDialog.getWindow().setFlags(2, 2);
  }

  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
  }

  public void addView(View paramView, int paramInt)
  {
    this.mHostView.addView(paramView, paramInt);
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }

  @TargetApi(23)
  public void dispatchProvideStructure(ViewStructure paramViewStructure)
  {
    this.mHostView.dispatchProvideStructure(paramViewStructure);
  }

  public View getChildAt(int paramInt)
  {
    return this.mHostView.getChildAt(paramInt);
  }

  public int getChildCount()
  {
    return this.mHostView.getChildCount();
  }

  @Nullable
  @VisibleForTesting
  public Dialog getDialog()
  {
    return this.mDialog;
  }

  public void onDropInstance()
  {
    ((ReactContext)getContext()).removeLifecycleEventListener(this);
    dismiss();
  }

  public void onHostDestroy()
  {
    onDropInstance();
  }

  public void onHostPause()
  {
  }

  public void onHostResume()
  {
    showOrUpdate();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void removeView(View paramView)
  {
    this.mHostView.removeView(paramView);
  }

  public void removeViewAt(int paramInt)
  {
    View localView = getChildAt(paramInt);
    this.mHostView.removeView(localView);
  }

  protected void setAnimationType(String paramString)
  {
    this.mAnimationType = paramString;
    this.mPropertyRequiresNewDialog = true;
  }

  protected void setHardwareAccelerated(boolean paramBoolean)
  {
    this.mHardwareAccelerated = paramBoolean;
    this.mPropertyRequiresNewDialog = true;
  }

  protected void setOnRequestCloseListener(OnRequestCloseListener paramOnRequestCloseListener)
  {
    this.mOnRequestCloseListener = paramOnRequestCloseListener;
  }

  protected void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.mOnShowListener = paramOnShowListener;
  }

  protected void setTransparent(boolean paramBoolean)
  {
    this.mTransparent = paramBoolean;
  }

  protected void showOrUpdate()
  {
    int i;
    Activity localActivity;
    if (this.mDialog != null)
    {
      if (this.mPropertyRequiresNewDialog)
        dismiss();
    }
    else
    {
      this.mPropertyRequiresNewDialog = false;
      i = R.style.Theme_FullScreenDialog;
      if (!this.mAnimationType.equals("fade"))
        break label166;
      i = R.style.Theme_FullScreenDialogAnimatedFade;
      localActivity = getCurrentActivity();
      if (localActivity != null)
        break label185;
    }
    label166: label185: for (Object localObject = getContext(); ; localObject = localActivity)
    {
      this.mDialog = new Dialog((Context)localObject, i);
      this.mDialog.setContentView(getContentView());
      updateProperties();
      this.mDialog.setOnShowListener(this.mOnShowListener);
      this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousKeyEvent.getAction() == 1)
          {
            if (paramAnonymousInt == 4)
            {
              Assertions.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
              ReactModalHostView.this.mOnRequestCloseListener.onRequestClose(paramAnonymousDialogInterface);
              return true;
            }
            Activity localActivity = ((ReactContext)ReactModalHostView.this.getContext()).getCurrentActivity();
            if (localActivity != null)
              return localActivity.onKeyUp(paramAnonymousInt, paramAnonymousKeyEvent);
          }
          return false;
        }
      });
      this.mDialog.getWindow().setSoftInputMode(16);
      if (this.mHardwareAccelerated)
        this.mDialog.getWindow().addFlags(16777216);
      if ((localActivity != null) && (!localActivity.isFinishing()))
        this.mDialog.show();
      return;
      updateProperties();
      return;
      if (!this.mAnimationType.equals("slide"))
        break;
      i = R.style.Theme_FullScreenDialogAnimatedSlide;
      break;
    }
  }

  static class DialogRootViewGroup extends ReactViewGroup
    implements RootView
  {
    private final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);

    public DialogRootViewGroup(Context paramContext)
    {
      super();
    }

    private EventDispatcher getEventDispatcher()
    {
      return ((UIManagerModule)getReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    private ReactContext getReactContext()
    {
      return (ReactContext)getContext();
    }

    public void handleException(Throwable paramThrowable)
    {
      getReactContext().handleException(new RuntimeException(paramThrowable));
    }

    public void onChildStartedNativeGesture(MotionEvent paramMotionEvent)
    {
      this.mJSTouchDispatcher.onChildStartedNativeGesture(paramMotionEvent, getEventDispatcher());
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.mJSTouchDispatcher.handleTouchEvent(paramMotionEvent, getEventDispatcher());
      return super.onInterceptTouchEvent(paramMotionEvent);
    }

    protected void onSizeChanged(final int paramInt1, final int paramInt2, int paramInt3, int paramInt4)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (getChildCount() > 0)
      {
        final int i = getChildAt(0).getId();
        ReactContext localReactContext = getReactContext();
        localReactContext.runOnNativeModulesQueueThread(new GuardedRunnable(localReactContext)
        {
          public void runGuarded()
          {
            ((UIManagerModule)ReactModalHostView.DialogRootViewGroup.this.getReactContext().getNativeModule(UIManagerModule.class)).updateNodeSize(i, paramInt1, paramInt2);
          }
        });
      }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      this.mJSTouchDispatcher.handleTouchEvent(paramMotionEvent, getEventDispatcher());
      super.onTouchEvent(paramMotionEvent);
      return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
    {
    }
  }

  public static abstract interface OnRequestCloseListener
  {
    public abstract void onRequestClose(DialogInterface paramDialogInterface);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ReactModalHostView
 * JD-Core Version:    0.6.2
 */