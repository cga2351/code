package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride;
import com.google.android.exoplayer2.trackselection.d.a;
import java.util.Arrays;

public class TrackSelectionView extends LinearLayout
{
  private final int a;
  private final LayoutInflater b;
  private final CheckedTextView c;
  private final CheckedTextView d;
  private final a e;
  private boolean f;
  private h g;
  private CheckedTextView[][] h;
  private DefaultTrackSelector i;
  private int j;
  private TrackGroupArray k;
  private boolean l;
  private DefaultTrackSelector.SelectionOverride m;

  public TrackSelectionView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TrackSelectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TrackSelectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(new int[] { 16843534 });
    this.a = localTypedArray.getResourceId(0, 0);
    localTypedArray.recycle();
    this.b = LayoutInflater.from(paramContext);
    this.e = new a(null);
    this.g = new b(getResources());
    this.c = ((CheckedTextView)this.b.inflate(17367055, this, false));
    this.c.setBackgroundResource(this.a);
    this.c.setText(R.string.exo_track_selection_none);
    this.c.setEnabled(false);
    this.c.setFocusable(true);
    this.c.setOnClickListener(this.e);
    this.c.setVisibility(8);
    addView(this.c);
    addView(this.b.inflate(R.layout.exo_list_divider, this, false));
    this.d = ((CheckedTextView)this.b.inflate(17367055, this, false));
    this.d.setBackgroundResource(this.a);
    this.d.setText(R.string.exo_track_selection_auto);
    this.d.setEnabled(false);
    this.d.setFocusable(true);
    this.d.setOnClickListener(this.e);
    addView(this.d);
  }

  private void a()
  {
    for (int n = -1 + getChildCount(); n >= 3; n--)
      removeViewAt(n);
    if (this.i == null);
    for (d.a locala = null; (this.i == null) || (locala == null); locala = this.i.b())
    {
      this.c.setEnabled(false);
      this.d.setEnabled(false);
      return;
    }
    this.c.setEnabled(true);
    this.d.setEnabled(true);
    this.k = locala.b(this.j);
    DefaultTrackSelector.Parameters localParameters = this.i.a();
    this.l = localParameters.getRendererDisabled(this.j);
    this.m = localParameters.getSelectionOverride(this.j, this.k);
    this.h = new CheckedTextView[this.k.length][];
    for (int i1 = 0; i1 < this.k.length; i1++)
    {
      TrackGroup localTrackGroup = this.k.get(i1);
      int i2;
      int i3;
      label233: int i4;
      label273: CheckedTextView localCheckedTextView;
      if ((this.f) && (this.k.get(i1).length > 1) && (locala.a(this.j, i1, false) != 0))
      {
        i2 = 1;
        this.h[i1] = new CheckedTextView[localTrackGroup.length];
        i3 = 0;
        if (i3 >= localTrackGroup.length)
          continue;
        if (i3 == 0)
          addView(this.b.inflate(R.layout.exo_list_divider, this, false));
        if (i2 == 0)
          break label398;
        i4 = 17367056;
        localCheckedTextView = (CheckedTextView)this.b.inflate(i4, this, false);
        localCheckedTextView.setBackgroundResource(this.a);
        localCheckedTextView.setText(this.g.a(localTrackGroup.getFormat(i3)));
        if (locala.a(this.j, i1, i3) != 4)
          break label405;
        localCheckedTextView.setFocusable(true);
        localCheckedTextView.setTag(Pair.create(Integer.valueOf(i1), Integer.valueOf(i3)));
        localCheckedTextView.setOnClickListener(this.e);
      }
      while (true)
      {
        this.h[i1][i3] = localCheckedTextView;
        addView(localCheckedTextView);
        i3++;
        break label233;
        i2 = 0;
        break;
        label398: i4 = 17367055;
        break label273;
        label405: localCheckedTextView.setFocusable(false);
        localCheckedTextView.setEnabled(false);
      }
    }
    b();
  }

  private void a(View paramView)
  {
    if (paramView == this.c)
      c();
    while (true)
    {
      b();
      return;
      if (paramView == this.d)
        d();
      else
        b(paramView);
    }
  }

  private static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = Arrays.copyOf(paramArrayOfInt, 1 + paramArrayOfInt.length);
    arrayOfInt[(-1 + arrayOfInt.length)] = paramInt;
    return arrayOfInt;
  }

  private void b()
  {
    this.c.setChecked(this.l);
    CheckedTextView localCheckedTextView1 = this.d;
    boolean bool1;
    if ((!this.l) && (this.m == null))
    {
      bool1 = true;
      localCheckedTextView1.setChecked(bool1);
    }
    for (int n = 0; ; n++)
    {
      if (n >= this.h.length)
        return;
      int i1 = 0;
      label51: if (i1 < this.h[n].length)
      {
        CheckedTextView localCheckedTextView2 = this.h[n][i1];
        if ((this.m != null) && (this.m.groupIndex == n) && (this.m.containsTrack(i1)));
        for (boolean bool2 = true; ; bool2 = false)
        {
          localCheckedTextView2.setChecked(bool2);
          i1++;
          break label51;
          bool1 = false;
          break;
        }
      }
    }
  }

  private void b(View paramView)
  {
    this.l = false;
    Pair localPair = (Pair)paramView.getTag();
    int n = ((Integer)localPair.first).intValue();
    int i1 = ((Integer)localPair.second).intValue();
    if ((this.m == null) || (this.m.groupIndex != n) || (!this.f))
    {
      this.m = new DefaultTrackSelector.SelectionOverride(n, new int[] { i1 });
      return;
    }
    int i2 = this.m.length;
    int[] arrayOfInt = this.m.tracks;
    if (((CheckedTextView)paramView).isChecked())
    {
      if (i2 == 1)
      {
        this.m = null;
        this.l = true;
        return;
      }
      this.m = new DefaultTrackSelector.SelectionOverride(n, b(arrayOfInt, i1));
      return;
    }
    this.m = new DefaultTrackSelector.SelectionOverride(n, a(arrayOfInt, i1));
  }

  private static int[] b(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = new int[-1 + paramArrayOfInt.length];
    int n = paramArrayOfInt.length;
    int i1 = 0;
    int i2 = 0;
    int i4;
    if (i1 < n)
    {
      int i3 = paramArrayOfInt[i1];
      if (i3 == paramInt)
        break label58;
      i4 = i2 + 1;
      arrayOfInt[i2] = i3;
    }
    while (true)
    {
      i1++;
      i2 = i4;
      break;
      return arrayOfInt;
      label58: i4 = i2;
    }
  }

  private void c()
  {
    this.l = true;
    this.m = null;
  }

  private void d()
  {
    this.l = false;
    this.m = null;
  }

  public void setAllowAdaptiveSelections(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      a();
    }
  }

  public void setShowDisableOption(boolean paramBoolean)
  {
    CheckedTextView localCheckedTextView = this.c;
    if (paramBoolean);
    for (int n = 0; ; n = 8)
    {
      localCheckedTextView.setVisibility(n);
      return;
    }
  }

  public void setTrackNameProvider(h paramh)
  {
    this.g = ((h)a.a(paramh));
    a();
  }

  private class a
    implements View.OnClickListener
  {
    private a()
    {
    }

    public void onClick(View paramView)
    {
      TrackSelectionView.a(TrackSelectionView.this, paramView);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.TrackSelectionView
 * JD-Core Version:    0.6.2
 */