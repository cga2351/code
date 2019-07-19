package android.support.v7.view;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class i
  implements Window.Callback
{
  final Window.Callback b;

  public i(Window.Callback paramCallback)
  {
    if (paramCallback == null)
      throw new IllegalArgumentException("Window callback may not be null");
    this.b = paramCallback;
  }

  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.b.dispatchGenericMotionEvent(paramMotionEvent);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.b.dispatchKeyEvent(paramKeyEvent);
  }

  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.b.dispatchKeyShortcutEvent(paramKeyEvent);
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.b.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.b.dispatchTouchEvent(paramMotionEvent);
  }

  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.b.dispatchTrackballEvent(paramMotionEvent);
  }

  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.b.onActionModeFinished(paramActionMode);
  }

  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.b.onActionModeStarted(paramActionMode);
  }

  public void onAttachedToWindow()
  {
    this.b.onAttachedToWindow();
  }

  public void onContentChanged()
  {
    this.b.onContentChanged();
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.b.onCreatePanelMenu(paramInt, paramMenu);
  }

  public View onCreatePanelView(int paramInt)
  {
    return this.b.onCreatePanelView(paramInt);
  }

  public void onDetachedFromWindow()
  {
    this.b.onDetachedFromWindow();
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.b.onMenuItemSelected(paramInt, paramMenuItem);
  }

  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.b.onMenuOpened(paramInt, paramMenu);
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.b.onPanelClosed(paramInt, paramMenu);
  }

  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    this.b.onPointerCaptureChanged(paramBoolean);
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.b.onPreparePanel(paramInt, paramView, paramMenu);
  }

  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    this.b.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }

  public boolean onSearchRequested()
  {
    return this.b.onSearchRequested();
  }

  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    return this.b.onSearchRequested(paramSearchEvent);
  }

  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.b.onWindowAttributesChanged(paramLayoutParams);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.b.onWindowFocusChanged(paramBoolean);
  }

  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.b.onWindowStartingActionMode(paramCallback);
  }

  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return this.b.onWindowStartingActionMode(paramCallback, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.i
 * JD-Core Version:    0.6.2
 */