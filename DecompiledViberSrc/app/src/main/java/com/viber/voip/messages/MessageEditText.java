package com.viber.voip.messages;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.viber.voip.R.dimen;
import com.viber.voip.widget.ac;
import com.viber.voip.widget.ac.a;
import com.viber.voip.widget.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageEditText extends AppCompatEditText
  implements ac, f
{
  private int a;
  private int b;
  private int c;
  private int d = 0;
  private a e;
  private a f;
  private ac.a g;
  private CopyOnWriteArrayList<View.OnFocusChangeListener> h;
  private CopyOnWriteArrayList<ac.a> i;

  public MessageEditText(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public MessageEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public MessageEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt2 + (paramInt2 - paramInt3) * (paramInt1 - 3);
  }

  private void a()
  {
    int j = 5;
    int k = getLineCount();
    if (this.d != k)
    {
      this.d = k;
      if (this.d > 1)
        break label39;
    }
    for (int m = this.a; ; m = this.b)
    {
      setLayoutHeight(m);
      return;
      label39: if (this.d != 2)
        break;
    }
    if (k >= j);
    while (true)
    {
      m = a(j, this.c, this.b);
      break;
      j = k;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (this.i == null);
    while (true)
    {
      return;
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
        ((ac.a)localIterator.next()).a(this, paramInt1, paramInt2);
    }
  }

  private void a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    this.a = localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_one_line);
    this.b = localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_two_line);
    this.c = localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_three_line);
    setMaxLines(5);
  }

  private void a(boolean paramBoolean)
  {
    if (this.h == null);
    while (true)
    {
      return;
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
        ((View.OnFocusChangeListener)localIterator.next()).onFocusChange(this, paramBoolean);
    }
  }

  private void setLayoutHeight(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = paramInt;
      setLayoutParams(localLayoutParams);
    }
  }

  public void a(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (this.h == null)
      this.h = new CopyOnWriteArrayList();
    if (!this.h.contains(paramOnFocusChangeListener))
      this.h.add(paramOnFocusChangeListener);
  }

  public void a(a parama, boolean paramBoolean)
  {
    int j;
    if (parama != this.f)
    {
      this.f = parama;
      j = getInputType();
      setInputType(0);
      if (!paramBoolean)
        break label58;
    }
    label58: for (int k = parama.f; ; k = parama.g)
    {
      super.setImeOptions(k);
      setInputType(j);
      setSelection(getText().length());
      return;
    }
  }

  public void a(ac.a parama)
  {
    if (this.i == null)
      this.i = new CopyOnWriteArrayList();
    if (!this.i.contains(parama))
      this.i.add(parama);
  }

  public void b(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (this.h == null)
      return;
    this.h.remove(paramOnFocusChangeListener);
  }

  public void b(ac.a parama)
  {
    if (this.i == null)
      return;
    this.i.remove(parama);
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((this.f != null) && (this.f.a()))
      paramEditorInfo.imeOptions = (0xBFFFFFFF & paramEditorInfo.imeOptions);
    return localInputConnection;
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    a(paramBoolean);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getMeasuredWidth();
    super.onMeasure(paramInt1, paramInt2);
    if (j != getMeasuredWidth())
      a();
  }

  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (this.g != null)
      this.g.a(this, paramInt1, paramInt2);
    a(paramInt1, paramInt2);
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((getWidth() > 0) && (paramInt2 != paramInt3))
      a();
  }

  public boolean onTextContextMenuItem(int paramInt)
  {
    if (this.e != null)
      switch (paramInt)
      {
      default:
      case 16908321:
      case 16908320:
      case 16908322:
      }
    do
    {
      do
      {
        do
          return super.onTextContextMenuItem(paramInt);
        while (!this.e.a(this));
        return true;
      }
      while (!this.e.b(this));
      return true;
    }
    while (!this.e.c(this));
    return true;
  }

  public void setEditTextContextMenuCallback(a parama)
  {
    this.e = parama;
  }

  public void setOnSelectionChangedListener(ac.a parama)
  {
    this.g = parama;
  }

  public static enum a
  {
    public int f;
    public int g;

    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }

    private a(int paramInt1, int paramInt2)
    {
      this.f = paramInt1;
      this.g = paramInt2;
    }

    public boolean a()
    {
      return (this != a) && (this != c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.MessageEditText
 * JD-Core Version:    0.6.2
 */