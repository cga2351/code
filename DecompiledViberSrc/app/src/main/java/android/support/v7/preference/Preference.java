package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Preference
  implements Comparable<Preference>
{
  private boolean A = true;
  private boolean B = true;
  private boolean C;
  private boolean D = true;
  private boolean E;
  private boolean F = true;
  private int G = R.layout.preference;
  private int H;
  private a I;
  private List<Preference> J;
  private PreferenceGroup K;
  private boolean L;
  private boolean M;
  private final View.OnClickListener N = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Preference.this.a(paramAnonymousView);
    }
  };
  private Context a;
  private j b;
  private e c;
  private long d;
  private boolean e;
  private b f;
  private c g;
  private int h = 2147483647;
  private int i = 0;
  private CharSequence j;
  private CharSequence k;
  private int l;
  private Drawable m;
  private String n;
  private Intent o;
  private String p;
  private Bundle q;
  private boolean r = true;
  private boolean s = true;
  private boolean t;
  private boolean u = true;
  private String v;
  private Object w;
  private boolean x = true;
  private boolean y = true;
  private boolean z = true;

  public Preference(Context paramContext)
  {
    this(paramContext, null);
  }

  public Preference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.preferenceStyle, 16842894));
  }

  public Preference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public Preference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Preference, paramInt1, paramInt2);
    this.l = TypedArrayUtils.getResourceId(localTypedArray, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
    this.n = TypedArrayUtils.getString(localTypedArray, R.styleable.Preference_key, R.styleable.Preference_android_key);
    this.j = TypedArrayUtils.getText(localTypedArray, R.styleable.Preference_title, R.styleable.Preference_android_title);
    this.k = TypedArrayUtils.getText(localTypedArray, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
    this.h = TypedArrayUtils.getInt(localTypedArray, R.styleable.Preference_order, R.styleable.Preference_android_order, 2147483647);
    this.p = TypedArrayUtils.getString(localTypedArray, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
    this.G = TypedArrayUtils.getResourceId(localTypedArray, R.styleable.Preference_layout, R.styleable.Preference_android_layout, R.layout.preference);
    this.H = TypedArrayUtils.getResourceId(localTypedArray, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
    this.r = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
    this.s = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
    this.u = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
    this.v = TypedArrayUtils.getString(localTypedArray, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
    this.A = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_allowDividerAbove, R.styleable.Preference_allowDividerAbove, this.s);
    this.B = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_allowDividerBelow, R.styleable.Preference_allowDividerBelow, this.s);
    if (localTypedArray.hasValue(R.styleable.Preference_defaultValue))
      this.w = a(localTypedArray, R.styleable.Preference_defaultValue);
    while (true)
    {
      this.F = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
      this.C = localTypedArray.hasValue(R.styleable.Preference_singleLineTitle);
      if (this.C)
        this.D = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_singleLineTitle, R.styleable.Preference_android_singleLineTitle, true);
      this.E = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
      this.z = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.Preference_isPreferenceVisible, R.styleable.Preference_isPreferenceVisible, true);
      localTypedArray.recycle();
      return;
      if (localTypedArray.hasValue(R.styleable.Preference_android_defaultValue))
        this.w = a(localTypedArray, R.styleable.Preference_android_defaultValue);
    }
  }

  private void a(SharedPreferences.Editor paramEditor)
  {
    if (this.b.f())
      paramEditor.apply();
  }

  private void a(View paramView, boolean paramBoolean)
  {
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      for (int i1 = -1 + localViewGroup.getChildCount(); i1 >= 0; i1--)
        a(localViewGroup.getChildAt(i1), paramBoolean);
    }
  }

  private void b()
  {
    if (TextUtils.isEmpty(this.v))
      return;
    Preference localPreference = e(this.v);
    if (localPreference != null)
    {
      localPreference.b(this);
      return;
    }
    throw new IllegalStateException("Dependency \"" + this.v + "\" not found for preference \"" + this.n + "\" (title: \"" + this.j + "\"");
  }

  private void b(Preference paramPreference)
  {
    if (this.J == null)
      this.J = new ArrayList();
    this.J.add(paramPreference);
    paramPreference.a(this, l());
  }

  private void c(Preference paramPreference)
  {
    if (this.J != null)
      this.J.remove(paramPreference);
  }

  private void e()
  {
    if (this.v != null)
    {
      Preference localPreference = e(this.v);
      if (localPreference != null)
        localPreference.c(this);
    }
  }

  private void f()
  {
    if (t() != null)
      a(true, this.w);
    do
    {
      return;
      if ((G()) && (J().contains(this.n)))
        break;
    }
    while (this.w == null);
    a(false, this.w);
    return;
    a(true, null);
  }

  public boolean A()
  {
    return this.s;
  }

  public final boolean B()
  {
    return this.z;
  }

  public String C()
  {
    return this.n;
  }

  void D()
  {
    if (TextUtils.isEmpty(this.n))
      throw new IllegalStateException("Preference does not have a key assigned.");
    this.t = true;
  }

  public boolean E()
  {
    return !TextUtils.isEmpty(this.n);
  }

  public boolean F()
  {
    return this.u;
  }

  protected boolean G()
  {
    return (this.b != null) && (F()) && (E());
  }

  public void H()
  {
    if (!z());
    do
    {
      j.c localc;
      do
      {
        do
        {
          return;
          k();
        }
        while ((this.g != null) && (this.g.a(this)));
        j localj = L();
        if (localj == null)
          break;
        localc = localj.i();
      }
      while ((localc != null) && (localc.a(this)));
    }
    while (this.o == null);
    I().startActivity(this.o);
  }

  public Context I()
  {
    return this.a;
  }

  public SharedPreferences J()
  {
    if ((this.b == null) || (t() != null))
      return null;
    return this.b.c();
  }

  protected void K()
  {
    if (this.I != null)
      this.I.b(this);
  }

  public j L()
  {
    return this.b;
  }

  public void M()
  {
    b();
  }

  public void N()
  {
    e();
    this.L = true;
  }

  public final void O()
  {
    this.L = false;
  }

  public PreferenceGroup P()
  {
    return this.K;
  }

  protected void Q()
  {
    e();
  }

  StringBuilder R()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharSequence localCharSequence1 = y();
    if (!TextUtils.isEmpty(localCharSequence1))
      localStringBuilder.append(localCharSequence1).append(' ');
    CharSequence localCharSequence2 = o();
    if (!TextUtils.isEmpty(localCharSequence2))
      localStringBuilder.append(localCharSequence2).append(' ');
    if (localStringBuilder.length() > 0)
      localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder;
  }

  public int a(Preference paramPreference)
  {
    if (this.h != paramPreference.h)
      return this.h - paramPreference.h;
    if (this.j == paramPreference.j)
      return 0;
    if (this.j == null)
      return 1;
    if (paramPreference.j == null)
      return -1;
    return this.j.toString().compareToIgnoreCase(paramPreference.j.toString());
  }

  protected Object a(TypedArray paramTypedArray, int paramInt)
  {
    return null;
  }

  public void a(Intent paramIntent)
  {
    this.o = paramIntent;
  }

  public void a(Drawable paramDrawable)
  {
    if (((paramDrawable == null) && (this.m != null)) || ((paramDrawable != null) && (this.m != paramDrawable)))
    {
      this.m = paramDrawable;
      this.l = 0;
      d_();
    }
  }

  public void a(Bundle paramBundle)
  {
    b(paramBundle);
  }

  protected void a(Parcelable paramParcelable)
  {
    this.M = true;
    if ((paramParcelable != BaseSavedState.EMPTY_STATE) && (paramParcelable != null))
      throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
  }

  public void a(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
  }

  final void a(a parama)
  {
    this.I = parama;
  }

  public void a(b paramb)
  {
    this.f = paramb;
  }

  public void a(c paramc)
  {
    this.g = paramc;
  }

  public void a(Preference paramPreference, boolean paramBoolean)
  {
    if (this.x == paramBoolean)
      if (paramBoolean)
        break label32;
    label32: for (boolean bool = true; ; bool = false)
    {
      this.x = bool;
      c(l());
      d_();
      return;
    }
  }

  void a(PreferenceGroup paramPreferenceGroup)
  {
    this.K = paramPreferenceGroup;
  }

  protected void a(j paramj)
  {
    this.b = paramj;
    if (!this.e)
      this.d = paramj.a();
    f();
  }

  protected void a(j paramj, long paramLong)
  {
    this.d = paramLong;
    this.e = true;
    try
    {
      a(paramj);
      return;
    }
    finally
    {
      this.e = false;
    }
  }

  public void a(l paraml)
  {
    int i1 = 4;
    paraml.itemView.setOnClickListener(this.N);
    paraml.itemView.setId(this.i);
    TextView localTextView1 = (TextView)paraml.a(16908310);
    if (localTextView1 != null)
    {
      CharSequence localCharSequence2 = y();
      if (TextUtils.isEmpty(localCharSequence2))
        break label306;
      localTextView1.setText(localCharSequence2);
      localTextView1.setVisibility(0);
      if (this.C)
        localTextView1.setSingleLine(this.D);
    }
    TextView localTextView2 = (TextView)paraml.a(16908304);
    label123: ImageView localImageView;
    View localView;
    if (localTextView2 != null)
    {
      CharSequence localCharSequence1 = o();
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localTextView2.setText(localCharSequence1);
        localTextView2.setVisibility(0);
      }
    }
    else
    {
      localImageView = (ImageView)paraml.a(16908294);
      if (localImageView != null)
      {
        if ((this.l != 0) || (this.m != null))
        {
          if (this.m == null)
            this.m = ContextCompat.getDrawable(I(), this.l);
          if (this.m != null)
            localImageView.setImageDrawable(this.m);
        }
        if (this.m == null)
          break label325;
        localImageView.setVisibility(0);
      }
      localView = paraml.a(R.id.icon_frame);
      if (localView == null)
        localView = paraml.a(16908350);
      if (localView != null)
      {
        if (this.m == null)
          break label352;
        localView.setVisibility(0);
      }
      if (!this.F)
        break label374;
      a(paraml.itemView, z());
    }
    while (true)
    {
      boolean bool = A();
      paraml.itemView.setFocusable(bool);
      paraml.itemView.setClickable(bool);
      paraml.a(this.A);
      paraml.b(this.B);
      return;
      label306: localTextView1.setVisibility(8);
      break;
      localTextView2.setVisibility(8);
      break label123;
      label325: if (this.E);
      for (int i2 = i1; ; i2 = 8)
      {
        localImageView.setVisibility(i2);
        break;
      }
      label352: if (this.E);
      while (true)
      {
        localView.setVisibility(i1);
        break;
        i1 = 8;
      }
      label374: a(paraml.itemView, true);
    }
  }

  protected void a(View paramView)
  {
    H();
  }

  protected void a(Object paramObject)
  {
  }

  public void a(boolean paramBoolean)
  {
    if (this.r != paramBoolean)
    {
      this.r = paramBoolean;
      c(l());
      d_();
    }
  }

  @Deprecated
  protected void a(boolean paramBoolean, Object paramObject)
  {
    a(paramObject);
  }

  void b(Bundle paramBundle)
  {
    if (E())
    {
      this.M = false;
      Parcelable localParcelable = d();
      if (!this.M)
        throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
      if (localParcelable != null)
        paramBundle.putParcelable(this.n, localParcelable);
    }
  }

  public void b(Preference paramPreference, boolean paramBoolean)
  {
    if (this.y == paramBoolean)
      if (paramBoolean)
        break label32;
    label32: for (boolean bool = true; ; bool = false)
    {
      this.y = bool;
      c(l());
      d_();
      return;
    }
  }

  public void b(CharSequence paramCharSequence)
  {
    if (((paramCharSequence == null) && (this.k != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.k))))
    {
      this.k = paramCharSequence;
      d_();
    }
  }

  public final void b(boolean paramBoolean)
  {
    if (this.z != paramBoolean)
    {
      this.z = paramBoolean;
      if (this.I != null)
        this.I.c(this);
    }
  }

  public boolean b(Object paramObject)
  {
    return (this.f == null) || (this.f.a(this, paramObject));
  }

  public boolean b(Set<String> paramSet)
  {
    boolean bool = true;
    if (!G())
      bool = false;
    while (paramSet.equals(c(null)))
      return bool;
    e locale = t();
    if (locale != null)
    {
      locale.a(this.n, paramSet);
      return bool;
    }
    SharedPreferences.Editor localEditor = this.b.e();
    localEditor.putStringSet(this.n, paramSet);
    a(localEditor);
    return bool;
  }

  public Set<String> c(Set<String> paramSet)
  {
    if (!G())
      return paramSet;
    e locale = t();
    if (locale != null)
      return locale.b(this.n, paramSet);
    return this.b.c().getStringSet(this.n, paramSet);
  }

  public void c(int paramInt)
  {
    this.G = paramInt;
  }

  public void c(Bundle paramBundle)
  {
    d(paramBundle);
  }

  public void c(CharSequence paramCharSequence)
  {
    if (((paramCharSequence == null) && (this.j != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.j))))
    {
      this.j = paramCharSequence;
      d_();
    }
  }

  public void c(Object paramObject)
  {
    this.w = paramObject;
  }

  public void c(boolean paramBoolean)
  {
    List localList = this.J;
    if (localList == null);
    while (true)
    {
      return;
      int i1 = localList.size();
      for (int i2 = 0; i2 < i1; i2++)
        ((Preference)localList.get(i2)).a(this, paramBoolean);
    }
  }

  long c_()
  {
    return this.d;
  }

  protected Parcelable d()
  {
    this.M = true;
    return BaseSavedState.EMPTY_STATE;
  }

  public void d(int paramInt)
  {
    if (paramInt != this.h)
    {
      this.h = paramInt;
      K();
    }
  }

  void d(Bundle paramBundle)
  {
    if (E())
    {
      Parcelable localParcelable = paramBundle.getParcelable(this.n);
      if (localParcelable != null)
      {
        this.M = false;
        a(localParcelable);
        if (!this.M)
          throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
      }
    }
  }

  public void d(String paramString)
  {
    this.n = paramString;
    if ((this.t) && (!E()))
      D();
  }

  protected boolean d(boolean paramBoolean)
  {
    boolean bool1 = true;
    if (!G())
      bool1 = false;
    boolean bool2;
    do
    {
      return bool1;
      bool2 = false;
      if (!paramBoolean)
        bool2 = bool1;
    }
    while (paramBoolean == e(bool2));
    e locale = t();
    if (locale != null)
    {
      locale.a(this.n, paramBoolean);
      return bool1;
    }
    SharedPreferences.Editor localEditor = this.b.e();
    localEditor.putBoolean(this.n, paramBoolean);
    a(localEditor);
    return bool1;
  }

  protected void d_()
  {
    if (this.I != null)
      this.I.a(this);
  }

  protected Preference e(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.b == null))
      return null;
    return this.b.a(paramString);
  }

  public void e(int paramInt)
  {
    c(this.a.getString(paramInt));
  }

  protected boolean e(boolean paramBoolean)
  {
    if (!G())
      return paramBoolean;
    e locale = t();
    if (locale != null)
      return locale.b(this.n, paramBoolean);
    return this.b.c().getBoolean(this.n, paramBoolean);
  }

  public void f(int paramInt)
  {
    a(ContextCompat.getDrawable(this.a, paramInt));
    this.l = paramInt;
  }

  protected boolean f(String paramString)
  {
    boolean bool = true;
    if (!G())
      bool = false;
    while (TextUtils.equals(paramString, g(null)))
      return bool;
    e locale = t();
    if (locale != null)
    {
      locale.a(this.n, paramString);
      return bool;
    }
    SharedPreferences.Editor localEditor = this.b.e();
    localEditor.putString(this.n, paramString);
    a(localEditor);
    return bool;
  }

  protected String g(String paramString)
  {
    if (!G())
      return paramString;
    e locale = t();
    if (locale != null)
      return locale.b(this.n, paramString);
    return this.b.c().getString(this.n, paramString);
  }

  protected boolean g(int paramInt)
  {
    boolean bool = true;
    if (!G())
      bool = false;
    while (paramInt == h(paramInt ^ 0xFFFFFFFF))
      return bool;
    e locale = t();
    if (locale != null)
    {
      locale.a(this.n, paramInt);
      return bool;
    }
    SharedPreferences.Editor localEditor = this.b.e();
    localEditor.putInt(this.n, paramInt);
    a(localEditor);
    return bool;
  }

  protected int h(int paramInt)
  {
    if (!G())
      return paramInt;
    e locale = t();
    if (locale != null)
      return locale.b(this.n, paramInt);
    return this.b.c().getInt(this.n, paramInt);
  }

  protected void k()
  {
  }

  public boolean l()
  {
    return !z();
  }

  public CharSequence o()
  {
    return this.k;
  }

  public Intent r()
  {
    return this.o;
  }

  public String s()
  {
    return this.p;
  }

  public e t()
  {
    if (this.c != null)
      return this.c;
    if (this.b != null)
      return this.b.b();
    return null;
  }

  public String toString()
  {
    return R().toString();
  }

  public Bundle u()
  {
    if (this.q == null)
      this.q = new Bundle();
    return this.q;
  }

  public final int v()
  {
    return this.G;
  }

  public final int w()
  {
    return this.H;
  }

  public int x()
  {
    return this.h;
  }

  public CharSequence y()
  {
    return this.j;
  }

  public boolean z()
  {
    return (this.r) && (this.x) && (this.y);
  }

  public static class BaseSavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator()
    {
      public Preference.BaseSavedState a(Parcel paramAnonymousParcel)
      {
        return new Preference.BaseSavedState(paramAnonymousParcel);
      }

      public Preference.BaseSavedState[] a(int paramAnonymousInt)
      {
        return new Preference.BaseSavedState[paramAnonymousInt];
      }
    };

    public BaseSavedState(Parcel paramParcel)
    {
      super();
    }

    public BaseSavedState(Parcelable paramParcelable)
    {
      super();
    }
  }

  static abstract interface a
  {
    public abstract void a(Preference paramPreference);

    public abstract void b(Preference paramPreference);

    public abstract void c(Preference paramPreference);
  }

  public static abstract interface b
  {
    public abstract boolean a(Preference paramPreference, Object paramObject);
  }

  public static abstract interface c
  {
    public abstract boolean a(Preference paramPreference);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.Preference
 * JD-Core Version:    0.6.2
 */