package com.viber.voip.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.o;
import com.viber.voip.util.dj;

public class FocusablePinView extends FrameLayout
{
  private boolean a;
  private PinView b;
  private EditText c;
  private int d = 0;
  private Runnable e = new Runnable()
  {
    public void run()
    {
      FocusablePinView.c(FocusablePinView.this).requestFocus();
      dj.b(FocusablePinView.c(FocusablePinView.this));
    }
  };

  public FocusablePinView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public FocusablePinView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public FocusablePinView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    this.a = true;
    View localView = LayoutInflater.from(getContext()).inflate(R.layout.hidden_chat_view_focusable_pin_layout, this);
    this.c = ((EditText)localView.findViewById(R.id.edit_text));
    this.c.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() == FocusablePinView.a(FocusablePinView.this))
          return;
        if (FocusablePinView.a(FocusablePinView.this) > paramAnonymousCharSequence.length())
          FocusablePinView.b(FocusablePinView.this).a();
        while (true)
        {
          FocusablePinView.a(FocusablePinView.this, paramAnonymousCharSequence.length());
          return;
          char c = paramAnonymousCharSequence.charAt(-1 + paramAnonymousCharSequence.length());
          if (Character.isDigit(c))
            FocusablePinView.b(FocusablePinView.this).a(c);
        }
      }
    });
    this.b = ((PinView)localView.findViewById(R.id.pin_view));
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a)
    {
      this.a = false;
      postDelayed(this.e, 250L);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      post(this.e);
      return true;
    }
    return false;
  }

  public void setScreenData(o paramo)
  {
    this.b.setScreenData(paramo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.FocusablePinView
 * JD-Core Version:    0.6.2
 */