package android.support.v4.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeyEventDispatcher
{
  private static boolean sActionBarFieldsFetched = false;
  private static Method sActionBarOnMenuKeyMethod = null;
  private static boolean sDialogFieldsFetched = false;
  private static Field sDialogKeyListenerField = null;

  private static boolean actionBarOnMenuKeyEventPre28(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    if (!sActionBarFieldsFetched);
    try
    {
      sActionBarOnMenuKeyMethod = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      label27: sActionBarFieldsFetched = true;
      if (sActionBarOnMenuKeyMethod != null);
      try
      {
        boolean bool = ((Boolean)sActionBarOnMenuKeyMethod.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        return bool;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label64: break label64;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }

  private static boolean activitySuperDispatchKeyEventPre28(Activity paramActivity, KeyEvent paramKeyEvent)
  {
    paramActivity.onUserInteraction();
    Window localWindow = paramActivity.getWindow();
    if (localWindow.hasFeature(8))
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      if ((paramKeyEvent.getKeyCode() != 82) || (localActionBar == null) || (!actionBarOnMenuKeyEventPre28(localActionBar, paramKeyEvent)));
    }
    View localView;
    do
    {
      do
        return true;
      while (localWindow.superDispatchKeyEvent(paramKeyEvent));
      localView = localWindow.getDecorView();
    }
    while (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(localView, paramKeyEvent));
    if (localView != null);
    for (KeyEvent.DispatcherState localDispatcherState = localView.getKeyDispatcherState(); ; localDispatcherState = null)
      return paramKeyEvent.dispatch(paramActivity, localDispatcherState, paramActivity);
  }

  private static boolean dialogSuperDispatchKeyEventPre28(Dialog paramDialog, KeyEvent paramKeyEvent)
  {
    DialogInterface.OnKeyListener localOnKeyListener = getDialogKeyListenerPre28(paramDialog);
    if ((localOnKeyListener != null) && (localOnKeyListener.onKey(paramDialog, paramKeyEvent.getKeyCode(), paramKeyEvent)));
    View localView;
    do
    {
      Window localWindow;
      do
      {
        return true;
        localWindow = paramDialog.getWindow();
      }
      while (localWindow.superDispatchKeyEvent(paramKeyEvent));
      localView = localWindow.getDecorView();
    }
    while (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(localView, paramKeyEvent));
    if (localView != null);
    for (KeyEvent.DispatcherState localDispatcherState = localView.getKeyDispatcherState(); ; localDispatcherState = null)
      return paramKeyEvent.dispatch(paramDialog, localDispatcherState, paramDialog);
  }

  public static boolean dispatchBeforeHierarchy(View paramView, KeyEvent paramKeyEvent)
  {
    return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(paramView, paramKeyEvent);
  }

  public static boolean dispatchKeyEvent(Component paramComponent, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    if (paramComponent == null);
    do
    {
      return false;
      if (Build.VERSION.SDK_INT >= 28)
        return paramComponent.superDispatchKeyEvent(paramKeyEvent);
      if ((paramCallback instanceof Activity))
        return activitySuperDispatchKeyEventPre28((Activity)paramCallback, paramKeyEvent);
      if ((paramCallback instanceof Dialog))
        return dialogSuperDispatchKeyEventPre28((Dialog)paramCallback, paramKeyEvent);
    }
    while (((paramView == null) || (!ViewCompat.dispatchUnhandledKeyEventBeforeCallback(paramView, paramKeyEvent))) && (!paramComponent.superDispatchKeyEvent(paramKeyEvent)));
    return true;
  }

  private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog paramDialog)
  {
    if (!sDialogFieldsFetched);
    try
    {
      sDialogKeyListenerField = Dialog.class.getDeclaredField("mOnKeyListener");
      sDialogKeyListenerField.setAccessible(true);
      label23: sDialogFieldsFetched = true;
      if (sDialogKeyListenerField != null)
        try
        {
          DialogInterface.OnKeyListener localOnKeyListener = (DialogInterface.OnKeyListener)sDialogKeyListenerField.get(paramDialog);
          return localOnKeyListener;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
        }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }

  public static abstract interface Component
  {
    public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventDispatcher
 * JD-Core Version:    0.6.2
 */