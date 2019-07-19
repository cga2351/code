package android.support.v7.preference;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class g extends Fragment
  implements DialogPreference.a, j.a, j.b, j.c
{
  RecyclerView a;
  private j b;
  private boolean c;
  private boolean d;
  private Context e;
  private int f = R.layout.preference_list_fragment;
  private final a g = new a();
  private Handler h = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
      }
      g.this.c();
    }
  };
  private final Runnable i = new Runnable()
  {
    public void run()
    {
      g.this.a.focusableViewAvailable(g.this.a);
    }
  };
  private Runnable j;

  private void i()
  {
    if (this.b == null)
      throw new RuntimeException("This should be called after super.onCreate.");
  }

  private void j()
  {
    if (this.h.hasMessages(1))
      return;
    this.h.obtainMessage(1).sendToTarget();
  }

  private void k()
  {
    PreferenceScreen localPreferenceScreen = b();
    if (localPreferenceScreen != null)
      localPreferenceScreen.N();
    e();
  }

  public Preference a(CharSequence paramCharSequence)
  {
    if (this.b == null)
      return null;
    return this.b.a(paramCharSequence);
  }

  public j a()
  {
    return this.b;
  }

  public RecyclerView a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.e.getPackageManager().hasSystemFeature("android.hardware.type.automotive"))
    {
      RecyclerView localRecyclerView2 = (RecyclerView)paramViewGroup.findViewById(R.id.recycler_view);
      if (localRecyclerView2 != null)
        return localRecyclerView2;
    }
    RecyclerView localRecyclerView1 = (RecyclerView)paramLayoutInflater.inflate(R.layout.preference_recyclerview, paramViewGroup, false);
    localRecyclerView1.setLayoutManager(g());
    localRecyclerView1.setAccessibilityDelegateCompat(new k(localRecyclerView1));
    return localRecyclerView1;
  }

  public void a(int paramInt)
  {
    this.g.a(paramInt);
  }

  public void a(int paramInt, String paramString)
  {
    i();
    Object localObject = this.b.a(this.e, paramInt, null);
    if (paramString != null)
    {
      localObject = ((PreferenceScreen)localObject).a(paramString);
      if (!(localObject instanceof PreferenceScreen))
        throw new IllegalArgumentException("Preference object with key " + paramString + " is not a PreferenceScreen");
    }
    a((PreferenceScreen)localObject);
  }

  public void a(Drawable paramDrawable)
  {
    this.g.a(paramDrawable);
  }

  public abstract void a(Bundle paramBundle, String paramString);

  public void a(PreferenceScreen paramPreferenceScreen)
  {
    if ((this.b.a(paramPreferenceScreen)) && (paramPreferenceScreen != null))
    {
      e();
      this.c = true;
      if (this.d)
        j();
    }
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.s();
    boolean bool1 = false;
    if (str != null)
    {
      boolean bool2 = h() instanceof c;
      bool1 = false;
      if (bool2)
        bool1 = ((c)h()).a(this, paramPreference);
      if ((!bool1) && ((getActivity() instanceof c)))
        bool1 = ((c)getActivity()).a(this, paramPreference);
    }
    return bool1;
  }

  public PreferenceScreen b()
  {
    return this.b.d();
  }

  public void b(int paramInt)
  {
    i();
    a(this.b.a(this.e, paramInt, b()));
  }

  public void b(Preference paramPreference)
  {
    if ((h() instanceof b));
    for (boolean bool = ((b)h()).a(this, paramPreference); ; bool = false)
    {
      if ((!bool) && ((getActivity() instanceof b)))
        bool = ((b)getActivity()).a(this, paramPreference);
      if (bool);
      while (getFragmentManager().findFragmentByTag("android.support.v14.preference.PreferenceFragment.DIALOG") != null)
        return;
      Object localObject;
      if ((paramPreference instanceof EditTextPreference))
        localObject = b.a(paramPreference.C());
      while (true)
      {
        ((DialogFragment)localObject).setTargetFragment(this, 0);
        ((DialogFragment)localObject).show(getFragmentManager(), "android.support.v14.preference.PreferenceFragment.DIALOG");
        return;
        if ((paramPreference instanceof ListPreference))
        {
          localObject = c.a(paramPreference.C());
        }
        else
        {
          if (!(paramPreference instanceof AbstractMultiSelectListPreference))
            break;
          localObject = d.a(paramPreference.C());
        }
      }
      throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
    }
  }

  public void b(PreferenceScreen paramPreferenceScreen)
  {
    boolean bool1 = h() instanceof d;
    boolean bool2 = false;
    if (bool1)
      bool2 = ((d)h()).a(this, paramPreferenceScreen);
    if ((!bool2) && ((getActivity() instanceof d)))
      ((d)getActivity()).a(this, paramPreferenceScreen);
  }

  protected RecyclerView.Adapter c(PreferenceScreen paramPreferenceScreen)
  {
    return new h(paramPreferenceScreen);
  }

  void c()
  {
    PreferenceScreen localPreferenceScreen = b();
    if (localPreferenceScreen != null)
    {
      f().setAdapter(c(localPreferenceScreen));
      localPreferenceScreen.M();
    }
    d();
  }

  protected void d()
  {
  }

  protected void e()
  {
  }

  public final RecyclerView f()
  {
    return this.a;
  }

  public RecyclerView.LayoutManager g()
  {
    return new LinearLayoutManager(getActivity());
  }

  public Fragment h()
  {
    return null;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    TypedValue localTypedValue = new TypedValue();
    getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, localTypedValue, true);
    int k = localTypedValue.resourceId;
    if (k == 0)
      k = R.style.PreferenceThemeOverlay;
    this.e = new ContextThemeWrapper(getActivity(), k);
    this.b = new j(this.e);
    this.b.a(this);
    if (getArguments() != null);
    for (String str = getArguments().getString("android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT"); ; str = null)
    {
      a(paramBundle, str);
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    TypedArray localTypedArray = this.e.obtainStyledAttributes(null, R.styleable.PreferenceFragmentCompat, R.attr.preferenceFragmentCompatStyle, 0);
    this.f = localTypedArray.getResourceId(R.styleable.PreferenceFragmentCompat_android_layout, this.f);
    Drawable localDrawable = localTypedArray.getDrawable(R.styleable.PreferenceFragmentCompat_android_divider);
    int k = localTypedArray.getDimensionPixelSize(R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
    boolean bool = localTypedArray.getBoolean(R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
    localTypedArray.recycle();
    LayoutInflater localLayoutInflater = paramLayoutInflater.cloneInContext(this.e);
    View localView1 = localLayoutInflater.inflate(this.f, paramViewGroup, false);
    View localView2 = localView1.findViewById(16908351);
    if (!(localView2 instanceof ViewGroup))
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    ViewGroup localViewGroup = (ViewGroup)localView2;
    RecyclerView localRecyclerView = a(localLayoutInflater, localViewGroup, paramBundle);
    if (localRecyclerView == null)
      throw new RuntimeException("Could not create RecyclerView");
    this.a = localRecyclerView;
    localRecyclerView.addItemDecoration(this.g);
    a(localDrawable);
    if (k != -1)
      a(k);
    this.g.a(bool);
    if (this.a.getParent() == null)
      localViewGroup.addView(this.a);
    this.h.post(this.i);
    return localView1;
  }

  public void onDestroyView()
  {
    this.h.removeCallbacks(this.i);
    this.h.removeMessages(1);
    if (this.c)
      k();
    this.a = null;
    super.onDestroyView();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    PreferenceScreen localPreferenceScreen = b();
    if (localPreferenceScreen != null)
    {
      Bundle localBundle = new Bundle();
      localPreferenceScreen.a(localBundle);
      paramBundle.putBundle("android:preferences", localBundle);
    }
  }

  public void onStart()
  {
    super.onStart();
    this.b.a(this);
    this.b.a(this);
  }

  public void onStop()
  {
    super.onStop();
    this.b.a(null);
    this.b.a(null);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (paramBundle != null)
    {
      Bundle localBundle = paramBundle.getBundle("android:preferences");
      if (localBundle != null)
      {
        PreferenceScreen localPreferenceScreen = b();
        if (localPreferenceScreen != null)
          localPreferenceScreen.c(localBundle);
      }
    }
    if (this.c)
    {
      c();
      if (this.j != null)
      {
        this.j.run();
        this.j = null;
      }
    }
    this.d = true;
  }

  private class a extends RecyclerView.ItemDecoration
  {
    private Drawable b;
    private int c;
    private boolean d = true;

    a()
    {
    }

    private boolean a(View paramView, RecyclerView paramRecyclerView)
    {
      RecyclerView.ViewHolder localViewHolder1 = paramRecyclerView.getChildViewHolder(paramView);
      if (((localViewHolder1 instanceof l)) && (((l)localViewHolder1).b()));
      for (int i = 1; i == 0; i = 0)
        return false;
      boolean bool = this.d;
      int j = paramRecyclerView.indexOfChild(paramView);
      if (j < -1 + paramRecyclerView.getChildCount())
      {
        RecyclerView.ViewHolder localViewHolder2 = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(j + 1));
        if ((!(localViewHolder2 instanceof l)) || (!((l)localViewHolder2).a()))
          break label102;
      }
      label102: for (bool = true; ; bool = false)
        return bool;
    }

    public void a(int paramInt)
    {
      this.c = paramInt;
      g.this.a.invalidateItemDecorations();
    }

    public void a(Drawable paramDrawable)
    {
      if (paramDrawable != null);
      for (this.c = paramDrawable.getIntrinsicHeight(); ; this.c = 0)
      {
        this.b = paramDrawable;
        g.this.a.invalidateItemDecorations();
        return;
      }
    }

    public void a(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }

    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      if (a(paramView, paramRecyclerView))
        paramRect.bottom = this.c;
    }

    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      if (this.b == null);
      while (true)
      {
        return;
        int i = paramRecyclerView.getChildCount();
        int j = paramRecyclerView.getWidth();
        for (int k = 0; k < i; k++)
        {
          View localView = paramRecyclerView.getChildAt(k);
          if (a(localView, paramRecyclerView))
          {
            int m = (int)localView.getY() + localView.getHeight();
            this.b.setBounds(0, m, j, m + this.c);
            this.b.draw(paramCanvas);
          }
        }
      }
    }
  }

  public static abstract interface b
  {
    public abstract boolean a(g paramg, Preference paramPreference);
  }

  public static abstract interface c
  {
    public abstract boolean a(g paramg, Preference paramPreference);
  }

  public static abstract interface d
  {
    public abstract boolean a(g paramg, PreferenceScreen paramPreferenceScreen);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.g
 * JD-Core Version:    0.6.2
 */