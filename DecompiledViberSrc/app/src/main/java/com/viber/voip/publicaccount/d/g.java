package com.viber.voip.publicaccount.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;
import com.viber.voip.widget.ae;
import com.viber.voip.widget.ae.a;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g
{
  private static final Logger a = ViberEnv.getLogger();
  private static Pattern b = Pattern.compile("\\S+");
  private Handler c = new Handler();
  private Handler d = new Handler();
  private int e;
  private int f;
  private Context g;
  private ae h;
  private TextView i;
  private int j;
  private a k = new a(null);
  private Set<String> l = new LinkedHashSet();
  private boolean m;

  private g(Context paramContext)
  {
    this.g = paramContext;
    this.e = paramContext.getResources().getColor(R.color.main_text);
    this.f = paramContext.getResources().getColor(R.color.link_text);
  }

  private Drawable a(Context paramContext, CharSequence paramCharSequence, float paramFloat, boolean paramBoolean)
  {
    Bitmap localBitmap = b(paramContext, paramCharSequence, paramFloat, paramBoolean);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap);
    localBitmapDrawable.setBounds(0, 0, localBitmapDrawable.getIntrinsicWidth(), localBitmapDrawable.getIntrinsicHeight());
    return localBitmapDrawable;
  }

  public static g a(ae paramae)
  {
    g localg = new g(paramae.getContext());
    localg.b(paramae);
    return localg;
  }

  private String a(String[] paramArrayOfString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int n = paramArrayOfString.length;
    for (int i1 = 0; i1 < n; i1++)
      localStringBuilder.append(paramArrayOfString[i1]).append(" ");
    if ((!paramBoolean) && (localStringBuilder.length() > 0))
      localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private void a(final int paramInt)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        if (paramInt <= g.b(g.this).getText().length())
          g.b(g.this).setSelection(paramInt);
      }
    });
  }

  private void a(Spannable paramSpannable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != paramInt2)
    {
      if (c(paramSpannable))
      {
        this.m = true;
        a(a(paramSpannable));
      }
    }
    else
      return;
    if (this.h != null);
    for (float f1 = this.h.getTextSize(); ; f1 = this.i.getTextSize())
    {
      paramSpannable.setSpan(new b(this.g, paramSpannable.subSequence(paramInt1, paramInt2), f1, paramBoolean), paramInt1, paramInt2, 33);
      return;
    }
  }

  private void a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getText();
    String str = localEditable.toString();
    int n = paramEditText.getSelectionStart();
    b[] arrayOfb = (b[])localEditable.getSpans(0, str.length(), b.class);
    int i1 = arrayOfb.length;
    int i2 = 0;
    if (i2 < i1)
    {
      b localb = arrayOfb[i2];
      int i3 = localEditable.getSpanStart(localb);
      int i4 = localEditable.getSpanEnd(localb);
      if ((n > i3) && (n <= i4));
      for (boolean bool = true; ; bool = false)
      {
        if (bool != localb.a)
        {
          localEditable.removeSpan(localb);
          a(localEditable, i3, i4, bool);
        }
        i2++;
        break;
      }
    }
  }

  private void a(TextView paramTextView, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    e(localSpannableStringBuilder);
    paramTextView.setText(localSpannableStringBuilder);
  }

  private boolean a(int paramInt, a parama)
  {
    Editable localEditable = this.h.getText();
    if (paramInt > localEditable.length());
    while ((localEditable.length() == 0) || ((paramInt < localEditable.length()) && (localEditable.charAt(paramInt) == ' ') && ((paramInt == 0) || ((paramInt > 0) && (localEditable.charAt(paramInt - 1) == ' ')))))
      return false;
    for (parama.a = paramInt; (parama.a > 0) && (localEditable.charAt(-1 + parama.a) != ' '); parama.a = (-1 + parama.a));
    if ((paramInt == localEditable.length()) || (localEditable.charAt(paramInt) == ' '))
      parama.b = paramInt;
    while (true)
    {
      return true;
      for (parama.b = (paramInt + 1); (parama.b < localEditable.length()) && (localEditable.charAt(parama.b) != ' '); parama.b = (1 + parama.b));
    }
  }

  private String[] a(Spannable paramSpannable)
  {
    this.l.clear();
    this.l.addAll(Arrays.asList(b(paramSpannable)));
    return (String[])this.l.toArray(new String[this.l.size()]);
  }

  private String[] a(String paramString)
  {
    if (paramString.isEmpty())
      return new String[0];
    return paramString.trim().split(" +", 0);
  }

  private Bitmap b(Context paramContext, CharSequence paramCharSequence, float paramFloat, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    int n = (int)localResources.getDimension(R.dimen.tags_formatter_stroke_width);
    int i1 = (int)localResources.getDimension(R.dimen.tags_formatter_text_horizontal_padding);
    int i2 = (int)localResources.getDimension(R.dimen.tags_formatter_text_vertical_padding);
    int i3 = (int)localResources.getDimension(R.dimen.tags_formatter_bottom_padding);
    int i4 = (int)localResources.getDimension(R.dimen.tags_formatter_border_corner_radius);
    Paint localPaint = new Paint(1);
    localPaint.setTextSize(paramFloat);
    if (paramBoolean);
    for (int i5 = this.f; ; i5 = this.e)
    {
      localPaint.setColor(i5);
      localPaint.setStrokeWidth(n);
      int i6 = i1 + (int)localPaint.measureText(paramCharSequence.toString());
      int i7 = i2 + (int)paramFloat;
      Bitmap localBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawText(paramCharSequence.toString(), i1 / 2, i7 - i3, localPaint);
      localPaint.setStyle(Paint.Style.STROKE);
      localCanvas.drawRoundRect(new RectF(n, n, i6 - n, i7 - n), i4, i4, localPaint);
      return localBitmap;
    }
  }

  private void b(ae paramae)
  {
    this.h = paramae;
    this.h.a();
    b();
  }

  private String[] b(Spannable paramSpannable)
  {
    return paramSpannable.toString().split(" ");
  }

  private int c()
  {
    return a().length;
  }

  private boolean c(Spannable paramSpannable)
  {
    this.l.clear();
    String[] arrayOfString = b(paramSpannable);
    int n = arrayOfString.length;
    for (int i1 = 0; ; i1++)
    {
      boolean bool = false;
      if (i1 < n)
      {
        String str = arrayOfString[i1];
        if (!this.l.add(str))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  private void d(Spannable paramSpannable)
  {
    int n = 0;
    b[] arrayOfb = (b[])paramSpannable.getSpans(0, paramSpannable.length(), b.class);
    int i1 = arrayOfb.length;
    while (n < i1)
    {
      paramSpannable.removeSpan(arrayOfb[n]);
      n++;
    }
    e(paramSpannable);
  }

  private void e(Spannable paramSpannable)
  {
    Matcher localMatcher = b.matcher(paramSpannable);
    while (localMatcher.find())
      a(paramSpannable, localMatcher.start(), localMatcher.end(), false);
  }

  public void a(String[] paramArrayOfString)
  {
    if (this.h != null)
    {
      a(this.h, a(paramArrayOfString, true));
      this.d.post(new Runnable()
      {
        public void run()
        {
          g.a(g.this).removeCallbacksAndMessages(null);
          g.b(g.this).setSelection(g.b(g.this).getText().length());
        }
      });
      return;
    }
    a(this.i, a(paramArrayOfString, false));
  }

  public String[] a()
  {
    if (this.h != null)
      return a(this.h.getText().toString());
    return a(this.i.getText().toString());
  }

  public void b()
  {
    final Runnable local2 = new Runnable()
    {
      public void run()
      {
        g.a(g.this, g.b(g.this));
      }
    };
    this.h.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt3 > paramAnonymousInt2)
        {
          paramAnonymousInt1++;
          if ((g.a(g.this, g.c(g.this), g.d(g.this))) && (!g.d(g.this).a(paramAnonymousInt1)))
          {
            g.b[] arrayOfb2 = (g.b[])g.b(g.this).getText().getSpans(g.d(g.this).a, g.d(g.this).b, g.b.class);
            if ((arrayOfb2 == null) || (arrayOfb2.length == 0))
              g.a(g.this, g.b(g.this).getText(), g.d(g.this).a, g.d(g.this).b, false);
          }
        }
        while (true)
        {
          if (paramAnonymousInt1 >= 0)
            g.a(g.this, paramAnonymousInt1);
          g.e(g.this).post(local2);
          return;
          if (paramAnonymousInt3 < paramAnonymousInt2)
          {
            if (g.a(g.this, paramAnonymousInt1, g.d(g.this)))
            {
              g.b[] arrayOfb1 = (g.b[])g.b(g.this).getText().getSpans(g.d(g.this).a, g.d(g.this).b, g.b.class);
              if ((arrayOfb1 != null) && (arrayOfb1.length > 0))
              {
                g.b localb = arrayOfb1[0];
                if (localb.a() > g.d(g.this).a())
                {
                  g.b(g.this).getText().removeSpan(localb);
                  g.b(g.this).getText().replace(g.d(g.this).a, g.d(g.this).b, "");
                }
              }
            }
          }
          else
            paramAnonymousInt1 = -1;
        }
      }
    });
    this.h.setOnSelectionChangedListener(new ae.a()
    {
      public void a(final int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i;
        if (paramAnonymousInt1 < g.b(g.this).getText().length())
          if (g.b(g.this).getText().charAt(paramAnonymousInt1) == ' ')
          {
            if ((paramAnonymousInt1 <= 0) || (g.b(g.this).getText().charAt(paramAnonymousInt1 - 1) != ' '))
              break label354;
            g.e(g.this).post(new Runnable()
            {
              public void run()
              {
                g.b(g.this).getText().replace(-1 + paramAnonymousInt1, paramAnonymousInt1, "");
              }
            });
            i = 0;
          }
        while (true)
        {
          if ((i == 0) && (g.c(g.this) != paramAnonymousInt1))
          {
            if ((g.a(g.this, g.c(g.this), g.d(g.this))) && (!g.d(g.this).a(paramAnonymousInt1)))
            {
              g.b[] arrayOfb = (g.b[])g.b(g.this).getText().getSpans(g.d(g.this).a, g.d(g.this).b, g.b.class);
              if ((arrayOfb == null) || (arrayOfb.length == 0))
                g.e(g.this).post(new Runnable()
                {
                  public void run()
                  {
                    g.a(g.this, g.b(g.this).getText(), g.d(g.this).a, g.d(g.this).b, false);
                  }
                });
            }
            g.a(g.this, paramAnonymousInt1);
            g.e(g.this).post(local2);
          }
          return;
          if ((paramAnonymousInt1 == 0) || ((paramAnonymousInt1 > 0) && (g.b(g.this).getText().charAt(paramAnonymousInt1 - 1) == ' ')))
          {
            for (int j = paramAnonymousInt1; (j < g.b(g.this).getText().length()) && (g.b(g.this).getText().charAt(j) != ' '); j++);
            if (!g.f(g.this))
              g.b(g.this, j);
            g.a(g.this, false);
            i = 1;
          }
          else
          {
            label354: i = 0;
          }
        }
      }
    });
    InputFilter local5 = new InputFilter()
    {
      public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        int i = paramAnonymousInt2 - paramAnonymousInt1;
        if (i > 0)
        {
          if (paramAnonymousInt3 == paramAnonymousSpanned.length())
            break label58;
          final CharSequence localCharSequence = paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt2);
          g.e(g.this).post(new Runnable()
          {
            public void run()
            {
              if ((g.b(g.this).getText().length() > 0) && (g.b(g.this).getText().charAt(-1 + g.b(g.this).getText().length()) != ' '))
                g.b(g.this).getText().insert(g.b(g.this).getText().length(), " ");
              g.b(g.this).getText().insert(g.b(g.this).getText().length(), localCharSequence);
              g.b(g.this).setSelection(g.b(g.this).getText().length());
            }
          });
          paramAnonymousCharSequence = "";
        }
        label58: int j;
        do
        {
          do
          {
            return paramAnonymousCharSequence;
            if (g.g(g.this) > 20)
              return "";
            if ((g.g(g.this) == 20) && ((paramAnonymousInt3 == 0) || (paramAnonymousSpanned.charAt(paramAnonymousInt3 - 1) == ' ')))
              return "";
            if (i == 1)
            {
              char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
              if ((c == ' ') && ((paramAnonymousInt3 == 0) || (paramAnonymousSpanned.charAt(paramAnonymousInt3 - 1) == ' ')))
                return "";
              if (c != ' ')
              {
                g.b[] arrayOfb = (g.b[])g.b(g.this).getText().getSpans(paramAnonymousInt3, paramAnonymousInt3, g.b.class);
                if ((arrayOfb != null) && (arrayOfb.length > 0))
                  return " " + c;
              }
              if (c == '\n')
                return "";
            }
          }
          while (!g.a(g.this, paramAnonymousInt3, g.d(g.this)));
          j = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
        }
        while ((g.d(g.this).b - g.d(g.this).a < 20) || (j == 32));
        return "";
      }
    };
    this.h.setFilters(new InputFilter[] { local5 });
    this.h.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
          paramAnonymousView.postDelayed(new Runnable()
          {
            public void run()
            {
              if (!paramAnonymousView.hasFocus())
              {
                g.b(g.this).append(" ");
                g.a(g.this, g.b(g.this).getEditableText());
              }
            }
          }
          , 200L);
      }
    });
  }

  private static class a
  {
    int a;
    int b;

    int a()
    {
      return this.b - this.a;
    }

    boolean a(int paramInt)
    {
      return (paramInt >= this.a) && (paramInt <= this.b);
    }

    public String toString()
    {
      return "Range{" + this.a + ".." + this.b + "}";
    }
  }

  private class b extends ImageSpan
  {
    boolean a;
    private CharSequence c;

    public b(Context paramCharSequence, CharSequence paramFloat, float paramBoolean, boolean arg5)
    {
      super(0);
      this.a = bool;
      this.c = paramFloat;
    }

    public int a()
    {
      if (this.c != null)
        return this.c.length();
      return 0;
    }

    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      Rect localRect = getDrawable().getBounds();
      if (paramFontMetricsInt != null)
      {
        paramFontMetricsInt.ascent = (-localRect.bottom);
        paramFontMetricsInt.descent = 0;
        paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      }
      return localRect.right;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.d.g
 * JD-Core Version:    0.6.2
 */