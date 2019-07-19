package com.viber.voip.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.viber.voip.ui.ViberEditText;

public class ae extends ViberEditText
{
  private a a;
  private boolean b;

  public ae(Context paramContext)
  {
    this(paramContext, null);
  }

  public ae(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ae(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }

  private boolean a(int paramInt)
  {
    return (0x2000F & paramInt) == 131073;
  }

  private void b()
  {
    if ((a(getInputType())) && ((0xFF & getImeOptions()) != 0));
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      return;
    }
  }

  public void a()
  {
    setCustomSelectionActionModeCallback(new ActionMode.Callback()
    {
      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }

      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }

      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
      }

      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    });
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (this.b)
      paramEditorInfo.imeOptions = (0xBFFFFFFF & paramEditorInfo.imeOptions);
    return localInputConnection;
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    b();
  }

  protected void onSelectionChanged(final int paramInt1, final int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (this.a != null)
      new Handler().post(new Runnable()
      {
        public void run()
        {
          ae.a(ae.this).a(paramInt1, paramInt2);
        }
      });
  }

  public void setImeOptions(int paramInt)
  {
    super.setImeOptions(paramInt);
    b();
  }

  public void setInputType(int paramInt)
  {
    super.setInputType(paramInt);
    b();
  }

  public void setOnSelectionChangedListener(a parama)
  {
    this.a = parama;
  }

  public void setSingleLine(boolean paramBoolean)
  {
    super.setSingleLine(paramBoolean);
    b();
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ae
 * JD-Core Version:    0.6.2
 */