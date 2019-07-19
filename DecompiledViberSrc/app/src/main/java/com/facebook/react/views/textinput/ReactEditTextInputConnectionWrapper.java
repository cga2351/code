package com.facebook.react.views.textinput;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import javax.annotation.Nullable;

class ReactEditTextInputConnectionWrapper extends InputConnectionWrapper
{
  public static final String BACKSPACE_KEY_VALUE = "Backspace";
  public static final String ENTER_KEY_VALUE = "Enter";
  public static final String NEWLINE_RAW_VALUE = "\n";
  private ReactEditText mEditText;
  private EventDispatcher mEventDispatcher;
  private boolean mIsBatchEdit;

  @Nullable
  private String mKey = null;

  public ReactEditTextInputConnectionWrapper(InputConnection paramInputConnection, ReactContext paramReactContext, ReactEditText paramReactEditText)
  {
    super(paramInputConnection, false);
    this.mEventDispatcher = ((UIManagerModule)paramReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
    this.mEditText = paramReactEditText;
  }

  private void dispatchKeyEvent(String paramString)
  {
    if (paramString.equals("\n"))
      paramString = "Enter";
    this.mEventDispatcher.dispatchEvent(new ReactTextInputKeyPressEvent(this.mEditText.getId(), paramString));
  }

  private void dispatchKeyEventOrEnqueue(String paramString)
  {
    if (this.mIsBatchEdit)
    {
      this.mKey = paramString;
      return;
    }
    dispatchKeyEvent(paramString);
  }

  public boolean beginBatchEdit()
  {
    this.mIsBatchEdit = true;
    return super.beginBatchEdit();
  }

  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    String str = paramCharSequence.toString();
    if (str.length() <= 1)
    {
      if (str.equals(""))
        str = "Backspace";
      dispatchKeyEventOrEnqueue(str);
    }
    return super.commitText(paramCharSequence, paramInt);
  }

  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    dispatchKeyEvent("Backspace");
    return super.deleteSurroundingText(paramInt1, paramInt2);
  }

  public boolean endBatchEdit()
  {
    this.mIsBatchEdit = false;
    if (this.mKey != null)
    {
      dispatchKeyEvent(this.mKey);
      this.mKey = null;
    }
    return super.endBatchEdit();
  }

  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      if (paramKeyEvent.getKeyCode() != 67)
        break label28;
      dispatchKeyEvent("Backspace");
    }
    while (true)
    {
      return super.sendKeyEvent(paramKeyEvent);
      label28: if (paramKeyEvent.getKeyCode() == 66)
        dispatchKeyEvent("Enter");
    }
  }

  public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    int i = this.mEditText.getSelectionStart();
    int j = this.mEditText.getSelectionEnd();
    boolean bool = super.setComposingText(paramCharSequence, paramInt);
    int k = this.mEditText.getSelectionStart();
    int m;
    int n;
    if (i == j)
    {
      m = 1;
      if (k != i)
        break label103;
      n = 1;
      label52: int i1;
      if (k >= i)
      {
        i1 = 0;
        if (k > 0);
      }
      else
      {
        i1 = 1;
      }
      if ((i1 == 0) && ((m != 0) || (n == 0)))
        break label109;
    }
    label103: label109: for (String str = "Backspace"; ; str = String.valueOf(this.mEditText.getText().charAt(k - 1)))
    {
      dispatchKeyEventOrEnqueue(str);
      return bool;
      m = 0;
      break;
      n = 0;
      break label52;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper
 * JD-Core Version:    0.6.2
 */