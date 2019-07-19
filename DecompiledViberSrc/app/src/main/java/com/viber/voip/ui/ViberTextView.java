package com.viber.voip.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TextView.BufferType;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class ViberTextView extends AppCompatTextView
{
  private static final Logger a = ViberEnv.getLogger();
  private float b = -2.147484E+009F;
  private int c = -2147483648;
  private float d = -2.147484E+009F;
  private float e = -2.147484E+009F;
  private float f = -2.147484E+009F;
  private float g = -2.147484E+009F;
  private int h = -2147483648;
  private int i = -2147483648;
  private CharSequence j;
  private TextView.BufferType k;

  public ViberTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ViberTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ViberTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private boolean a()
  {
    Layout localLayout = getLayout();
    if (localLayout == null);
    while (true)
    {
      return false;
      int m = localLayout.getLineCount();
      CharSequence localCharSequence = localLayout.getText();
      for (int n = 0; n < m - 1; n++)
        if (localCharSequence.charAt(-1 + localLayout.getLineEnd(n)) == '\n')
          return true;
    }
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
  }

  public void a(SpannableString paramSpannableString)
  {
    this.j = paramSpannableString;
    this.k = TextView.BufferType.SPANNABLE;
    try
    {
      super.setText(this.j, this.k);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      setText(paramSpannableString.toString());
    }
  }

  protected void a(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    super.setText(paramCharSequence, this.k);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      setText(getText().toString());
      super.onDraw(paramCanvas);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      setText(getText().toString());
      super.onMeasure(paramInt1, paramInt2);
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    try
    {
      if (a.g())
      {
        super.onRestoreInstanceState(paramParcelable);
        return;
      }
      if (!(paramParcelable instanceof SafeSavedState))
      {
        super.onRestoreInstanceState(paramParcelable);
        return;
      }
      SafeSavedState localSafeSavedState = (SafeSavedState)paramParcelable;
      super.onRestoreInstanceState(localSafeSavedState.getSuperState());
      if (localSafeSavedState.text != null)
        setText(localSafeSavedState.text);
      if ((localSafeSavedState.selStart >= 0) && (localSafeSavedState.selEnd >= 0))
      {
        CharSequence localCharSequence = getText();
        if ((localCharSequence instanceof Spannable))
        {
          int m = localCharSequence.length();
          if ((localSafeSavedState.selStart > m) || (localSafeSavedState.selEnd > m))
          {
            if (localSafeSavedState.text == null);
          }
          else
          {
            Selection.setSelection((Spannable)localCharSequence, localSafeSavedState.selStart, localSafeSavedState.selEnd);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
    }
  }

  public Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable;
    if (a.g())
      localParcelable = super.onSaveInstanceState();
    while (true)
    {
      return localParcelable;
      localParcelable = super.onSaveInstanceState();
      boolean bool = getFreezesText();
      CharSequence localCharSequence = getText();
      int i2;
      int i3;
      int n;
      int i1;
      int m;
      if (localCharSequence != null)
      {
        i2 = getSelectionStart();
        i3 = getSelectionEnd();
        if ((i2 >= 0) || (i3 >= 0))
        {
          n = i2;
          i1 = 1;
          m = i3;
        }
      }
      while ((bool) || (i1 != 0))
      {
        SafeSavedState localSafeSavedState = new SafeSavedState(localParcelable);
        if (bool)
          if (!(localCharSequence instanceof Spanned))
            break label162;
        label162: for (localSafeSavedState.text = new SpannableStringBuilder(localCharSequence); ; localSafeSavedState.text = localCharSequence.toString())
        {
          if (i1 != 0)
          {
            localSafeSavedState.selStart = n;
            localSafeSavedState.selEnd = m;
          }
          if ((isFocused()) && (n >= 0) && (m >= 0))
            localSafeSavedState.frozenWithFocus = true;
          localSafeSavedState.error = getError();
          return localSafeSavedState;
        }
        n = i2;
        m = i3;
        i1 = 0;
        continue;
        m = -1;
        n = -1;
        i1 = 0;
      }
    }
  }

  public void setGravity(int paramInt)
  {
    if (this.i == paramInt)
      return;
    try
    {
      super.setGravity(paramInt);
      this.i = paramInt;
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      setText(getText().toString());
      super.setGravity(paramInt);
    }
  }

  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    if ((this.e != paramFloat1) || (this.f != paramFloat2) || (this.g != paramFloat3) || (this.h != paramInt))
    {
      this.e = paramFloat1;
      this.f = paramFloat2;
      this.g = paramFloat3;
      this.h = paramInt;
      super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    }
  }

  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((this.j == null) || (!this.j.equals(paramCharSequence)) || (paramBufferType != this.k) || (this.j.getClass() != paramCharSequence.getClass()) || (a()))
    {
      this.j = paramCharSequence;
      this.k = paramBufferType;
    }
    try
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      setText(paramCharSequence.toString());
    }
  }

  public void setTextSize(float paramFloat)
  {
    if (paramFloat != this.b)
    {
      this.b = paramFloat;
      super.setTextSize(paramFloat);
    }
  }

  public void setTextSize(int paramInt, float paramFloat)
  {
    if ((paramFloat != this.d) || (paramInt != this.c))
    {
      this.d = paramFloat;
      this.c = paramInt;
      super.setTextSize(paramInt, paramFloat);
    }
  }

  public static class SafeParcelableParcel
    implements Parcelable
  {
    public static final Parcelable.ClassLoaderCreator<SafeParcelableParcel> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public ViberTextView.SafeParcelableParcel a(Parcel paramAnonymousParcel)
      {
        return new ViberTextView.SafeParcelableParcel(paramAnonymousParcel, null);
      }

      public ViberTextView.SafeParcelableParcel a(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new ViberTextView.SafeParcelableParcel(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public ViberTextView.SafeParcelableParcel[] a(int paramAnonymousInt)
      {
        return new ViberTextView.SafeParcelableParcel[paramAnonymousInt];
      }
    };
    final ClassLoader mClassLoader;
    final Parcel mParcel = Parcel.obtain();

    public SafeParcelableParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.mClassLoader = paramClassLoader;
      int i = paramParcel.readInt();
      int j = paramParcel.dataPosition();
      this.mParcel.appendFrom(paramParcel, paramParcel.dataPosition(), i);
      paramParcel.setDataPosition(i + j);
    }

    public SafeParcelableParcel(ClassLoader paramClassLoader)
    {
      this.mClassLoader = paramClassLoader;
    }

    public int describeContents()
    {
      return 0;
    }

    public ClassLoader getClassLoader()
    {
      return this.mClassLoader;
    }

    public Parcel getParcel()
    {
      this.mParcel.setDataPosition(0);
      return this.mParcel;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mParcel.dataSize());
      paramParcel.appendFrom(this.mParcel, 0, this.mParcel.dataSize());
    }
  }

  public static class SafeSavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SafeSavedState> CREATOR = new Parcelable.Creator()
    {
      public ViberTextView.SafeSavedState a(Parcel paramAnonymousParcel)
      {
        try
        {
          ViberTextView.SafeSavedState localSafeSavedState = new ViberTextView.SafeSavedState(paramAnonymousParcel, null);
          return localSafeSavedState;
        }
        catch (Throwable localThrowable)
        {
        }
        return null;
      }

      public ViberTextView.SafeSavedState[] a(int paramAnonymousInt)
      {
        try
        {
          ViberTextView.SafeSavedState[] arrayOfSafeSavedState = new ViberTextView.SafeSavedState[paramAnonymousInt];
          return arrayOfSafeSavedState;
        }
        catch (Throwable localThrowable)
        {
        }
        return null;
      }
    };
    ViberTextView.SafeParcelableParcel editorState;
    CharSequence error;
    boolean frozenWithFocus;
    int selEnd = -1;
    int selStart = -1;
    CharSequence text;

    private SafeSavedState(Parcel paramParcel)
    {
      super();
      try
      {
        this.selStart = paramParcel.readInt();
        this.selEnd = paramParcel.readInt();
        if (paramParcel.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          this.frozenWithFocus = bool;
          this.text = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
          if (paramParcel.readInt() != 0)
            this.error = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
          if (paramParcel.readInt() != 0)
            this.editorState = ((ViberTextView.SafeParcelableParcel)ViberTextView.SafeParcelableParcel.CREATOR.createFromParcel(paramParcel));
          return;
        }
      }
      catch (Exception localException)
      {
      }
    }

    SafeSavedState(Parcelable paramParcelable)
    {
      super();
    }

    public String toString()
    {
      String str = "ViberTextView.SafeSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " start=" + this.selStart + " end=" + this.selEnd;
      if (this.text != null)
        str = str + " text=" + this.text;
      return str + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.selStart);
      paramParcel.writeInt(this.selEnd);
      int i;
      if (this.frozenWithFocus)
      {
        i = 1;
        paramParcel.writeInt(i);
        TextUtils.writeToParcel(this.text, paramParcel, paramInt);
        if (this.error != null)
          break label75;
        paramParcel.writeInt(0);
      }
      while (true)
      {
        if (this.editorState != null)
          break label92;
        paramParcel.writeInt(0);
        return;
        i = 0;
        break;
        label75: paramParcel.writeInt(1);
        TextUtils.writeToParcel(this.error, paramParcel, paramInt);
      }
      label92: paramParcel.writeInt(1);
      this.editorState.writeToParcel(paramParcel, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ViberTextView
 * JD-Core Version:    0.6.2
 */