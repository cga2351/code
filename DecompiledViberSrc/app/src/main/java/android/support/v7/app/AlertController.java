package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController
{
  private int A;
  private boolean B = false;
  private CharSequence C;
  private Drawable D;
  private CharSequence E;
  private Drawable F;
  private CharSequence G;
  private Drawable H;
  private int I = 0;
  private Drawable J;
  private ImageView K;
  private TextView L;
  private TextView M;
  private View N;
  private int O;
  private int P;
  private boolean Q;
  private int R = 0;
  private final View.OnClickListener S = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Message localMessage;
      if ((paramAnonymousView == AlertController.this.c) && (AlertController.this.d != null))
        localMessage = Message.obtain(AlertController.this.d);
      while (true)
      {
        if (localMessage != null)
          localMessage.sendToTarget();
        AlertController.this.p.obtainMessage(1, AlertController.this.a).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.e) && (AlertController.this.f != null))
          localMessage = Message.obtain(AlertController.this.f);
        else if ((paramAnonymousView == AlertController.this.g) && (AlertController.this.h != null))
          localMessage = Message.obtain(AlertController.this.h);
        else
          localMessage = null;
      }
    }
  };
  final f a;
  ListView b;
  Button c;
  Message d;
  Button e;
  Message f;
  Button g;
  Message h;
  NestedScrollView i;
  ListAdapter j;
  int k = -1;
  int l;
  int m;
  int n;
  int o;
  Handler p;
  private final Context q;
  private final Window r;
  private final int s;
  private CharSequence t;
  private CharSequence u;
  private View v;
  private int w;
  private int x;
  private int y;
  private int z;

  public AlertController(Context paramContext, f paramf, Window paramWindow)
  {
    this.q = paramContext;
    this.a = paramf;
    this.r = paramWindow;
    this.p = new b(paramf);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    this.O = localTypedArray.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    this.P = localTypedArray.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    this.l = localTypedArray.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    this.m = localTypedArray.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    this.n = localTypedArray.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    this.o = localTypedArray.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    this.Q = localTypedArray.getBoolean(R.styleable.AlertDialog_showTitle, true);
    this.s = localTypedArray.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
    localTypedArray.recycle();
    paramf.supportRequestWindowFeature(1);
  }

  private ViewGroup a(View paramView1, View paramView2)
  {
    if (paramView1 == null)
      if (!(paramView2 instanceof ViewStub))
        break label78;
    label78: for (View localView2 = ((ViewStub)paramView2).inflate(); ; localView2 = paramView2)
    {
      return (ViewGroup)localView2;
      if (paramView2 != null)
      {
        ViewParent localViewParent = paramView2.getParent();
        if ((localViewParent instanceof ViewGroup))
          ((ViewGroup)localViewParent).removeView(paramView2);
      }
      if ((paramView1 instanceof ViewStub));
      for (View localView1 = ((ViewStub)paramView1).inflate(); ; localView1 = paramView1)
        return (ViewGroup)localView1;
    }
  }

  static void a(View paramView1, View paramView2, View paramView3)
  {
    int i2;
    int i1;
    if (paramView2 != null)
    {
      if (paramView1.canScrollVertically(-1))
      {
        i2 = 0;
        paramView2.setVisibility(i2);
      }
    }
    else if (paramView3 != null)
    {
      boolean bool = paramView1.canScrollVertically(1);
      i1 = 0;
      if (!bool)
        break label51;
    }
    while (true)
    {
      paramView3.setVisibility(i1);
      return;
      i2 = 4;
      break;
      label51: i1 = 4;
    }
  }

  private void a(ViewGroup paramViewGroup)
  {
    View localView;
    if (this.v != null)
      localView = this.v;
    while (true)
    {
      int i1 = 0;
      if (localView != null)
        i1 = 1;
      if ((i1 == 0) || (!a(localView)))
        this.r.setFlags(131072, 131072);
      if (i1 == 0)
        break;
      FrameLayout localFrameLayout = (FrameLayout)this.r.findViewById(R.id.custom);
      localFrameLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      if (this.B)
        localFrameLayout.setPadding(this.x, this.y, this.z, this.A);
      if (this.b != null)
        ((LinearLayoutCompat.LayoutParams)paramViewGroup.getLayoutParams()).weight = 0.0F;
      return;
      if (this.w != 0)
        localView = LayoutInflater.from(this.q).inflate(this.w, paramViewGroup, false);
      else
        localView = null;
    }
    paramViewGroup.setVisibility(8);
  }

  private void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    final View localView1 = this.r.findViewById(R.id.scrollIndicatorUp);
    View localView2 = this.r.findViewById(R.id.scrollIndicatorDown);
    if (Build.VERSION.SDK_INT >= 23)
    {
      ViewCompat.setScrollIndicators(paramView, paramInt1, paramInt2);
      if (localView1 != null)
        paramViewGroup.removeView(localView1);
      if (localView2 != null)
        paramViewGroup.removeView(localView2);
    }
    label234: 
    while (true)
    {
      return;
      if ((localView1 != null) && ((paramInt1 & 0x1) == 0))
      {
        paramViewGroup.removeView(localView1);
        localView1 = null;
      }
      if ((localView2 != null) && ((paramInt1 & 0x2) == 0))
        paramViewGroup.removeView(localView2);
      while (true)
      {
        if ((localView1 == null) && (localObject == null))
          break label234;
        if (this.u != null)
        {
          this.i.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener()
          {
            public void onScrollChange(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
            {
              AlertController.a(paramAnonymousNestedScrollView, localView1, this.b);
            }
          });
          this.i.post(new Runnable()
          {
            public void run()
            {
              AlertController.a(AlertController.this.i, localView1, this.b);
            }
          });
          return;
        }
        if (this.b != null)
        {
          this.b.setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AlertController.a(paramAnonymousAbsListView, localView1, this.b);
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
            {
            }
          });
          this.b.post(new Runnable()
          {
            public void run()
            {
              AlertController.a(AlertController.this.b, localView1, this.b);
            }
          });
          return;
        }
        if (localView1 != null)
          paramViewGroup.removeView(localView1);
        if (localObject == null)
          break;
        paramViewGroup.removeView((View)localObject);
        return;
        localObject = localView2;
      }
    }
  }

  private void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }

  private static boolean a(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, localTypedValue, true);
    return localTypedValue.data != 0;
  }

  static boolean a(View paramView)
  {
    if (paramView.onCheckIsTextEditor())
      return true;
    if (!(paramView instanceof ViewGroup))
      return false;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int i1 = localViewGroup.getChildCount();
    while (i1 > 0)
    {
      i1--;
      if (a(localViewGroup.getChildAt(i1)))
        return true;
    }
    return false;
  }

  private void b(ViewGroup paramViewGroup)
  {
    if (this.N != null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(this.N, 0, localLayoutParams);
      this.r.findViewById(R.id.title_template).setVisibility(8);
      return;
    }
    this.K = ((ImageView)this.r.findViewById(16908294));
    int i1;
    if (!TextUtils.isEmpty(this.t))
      i1 = 1;
    while ((i1 != 0) && (this.Q))
    {
      this.L = ((TextView)this.r.findViewById(R.id.alertTitle));
      this.L.setText(this.t);
      if (this.I != 0)
      {
        this.K.setImageResource(this.I);
        return;
        i1 = 0;
      }
      else
      {
        if (this.J != null)
        {
          this.K.setImageDrawable(this.J);
          return;
        }
        this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
        this.K.setVisibility(8);
        return;
      }
    }
    this.r.findViewById(R.id.title_template).setVisibility(8);
    this.K.setVisibility(8);
    paramViewGroup.setVisibility(8);
  }

  private int c()
  {
    if (this.P == 0)
      return this.O;
    if (this.R == 1)
      return this.P;
    return this.O;
  }

  private void c(ViewGroup paramViewGroup)
  {
    this.i = ((NestedScrollView)this.r.findViewById(R.id.scrollView));
    this.i.setFocusable(false);
    this.i.setNestedScrollingEnabled(false);
    this.M = ((TextView)paramViewGroup.findViewById(16908299));
    if (this.M == null)
      return;
    if (this.u != null)
    {
      this.M.setText(this.u);
      return;
    }
    this.M.setVisibility(8);
    this.i.removeView(this.M);
    if (this.b != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.i.getParent();
      int i1 = localViewGroup.indexOfChild(this.i);
      localViewGroup.removeViewAt(i1);
      localViewGroup.addView(this.b, i1, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    paramViewGroup.setVisibility(8);
  }

  private void d()
  {
    View localView1 = this.r.findViewById(R.id.parentPanel);
    View localView2 = localView1.findViewById(R.id.topPanel);
    View localView3 = localView1.findViewById(R.id.contentPanel);
    View localView4 = localView1.findViewById(R.id.buttonPanel);
    ViewGroup localViewGroup1 = (ViewGroup)localView1.findViewById(R.id.customPanel);
    a(localViewGroup1);
    View localView5 = localViewGroup1.findViewById(R.id.topPanel);
    View localView6 = localViewGroup1.findViewById(R.id.contentPanel);
    View localView7 = localViewGroup1.findViewById(R.id.buttonPanel);
    ViewGroup localViewGroup2 = a(localView5, localView2);
    ViewGroup localViewGroup3 = a(localView6, localView3);
    ViewGroup localViewGroup4 = a(localView7, localView4);
    c(localViewGroup3);
    d(localViewGroup4);
    b(localViewGroup2);
    int i1;
    boolean bool1;
    label166: boolean bool2;
    label184: Object localObject;
    label277: label319: int i3;
    if ((localViewGroup1 != null) && (localViewGroup1.getVisibility() != 8))
    {
      i1 = 1;
      if ((localViewGroup2 == null) || (localViewGroup2.getVisibility() == 8))
        break label415;
      bool1 = true;
      if ((localViewGroup4 == null) || (localViewGroup4.getVisibility() == 8))
        break label421;
      bool2 = true;
      if ((!bool2) && (localViewGroup3 != null))
      {
        View localView10 = localViewGroup3.findViewById(R.id.textSpacerNoButtons);
        if (localView10 != null)
          localView10.setVisibility(0);
      }
      if (!bool1)
        break label427;
      if (this.i != null)
        this.i.setClipToPadding(true);
      View localView9;
      if (this.u == null)
      {
        ListView localListView2 = this.b;
        localView9 = null;
        if (localListView2 == null);
      }
      else
      {
        localView9 = localViewGroup2.findViewById(R.id.titleDividerNoCustom);
      }
      if (localView9 != null)
        localView9.setVisibility(0);
      if ((this.b instanceof RecycleListView))
        ((RecycleListView)this.b).a(bool1, bool2);
      if (i1 == 0)
      {
        if (this.b == null)
          break label456;
        localObject = this.b;
        if (localObject != null)
        {
          if (!bool1)
            break label465;
          i3 = 1;
          label332: if (!bool2)
            break label471;
        }
      }
    }
    label415: label421: label427: label456: label465: label471: for (int i4 = 2; ; i4 = 0)
    {
      a(localViewGroup3, (View)localObject, i4 | i3, 3);
      ListView localListView1 = this.b;
      if ((localListView1 != null) && (this.j != null))
      {
        localListView1.setAdapter(this.j);
        int i2 = this.k;
        if (i2 > -1)
        {
          localListView1.setItemChecked(i2, true);
          localListView1.setSelection(i2);
        }
      }
      return;
      i1 = 0;
      break;
      bool1 = false;
      break label166;
      bool2 = false;
      break label184;
      if (localViewGroup3 == null)
        break label277;
      View localView8 = localViewGroup3.findViewById(R.id.textSpacerNoTitle);
      if (localView8 == null)
        break label277;
      localView8.setVisibility(0);
      break label277;
      localObject = this.i;
      break label319;
      i3 = 0;
      break label332;
    }
  }

  private void d(ViewGroup paramViewGroup)
  {
    int i1 = 1;
    this.c = ((Button)paramViewGroup.findViewById(16908313));
    this.c.setOnClickListener(this.S);
    int i2;
    if ((TextUtils.isEmpty(this.C)) && (this.D == null))
    {
      this.c.setVisibility(8);
      i2 = 0;
      this.e = ((Button)paramViewGroup.findViewById(16908314));
      this.e.setOnClickListener(this.S);
      if ((!TextUtils.isEmpty(this.E)) || (this.F != null))
        break label257;
      this.e.setVisibility(8);
      label106: this.g = ((Button)paramViewGroup.findViewById(16908315));
      this.g.setOnClickListener(this.S);
      if ((!TextUtils.isEmpty(this.G)) || (this.H != null))
        break label321;
      this.g.setVisibility(8);
      label157: if (a(this.q))
      {
        if (i2 != i1)
          break label385;
        a(this.c);
      }
      label180: if (i2 == 0)
        break label417;
    }
    while (true)
    {
      if (i1 == 0)
        paramViewGroup.setVisibility(8);
      return;
      this.c.setText(this.C);
      if (this.D != null)
      {
        this.D.setBounds(0, 0, this.s, this.s);
        this.c.setCompoundDrawables(this.D, null, null, null);
      }
      this.c.setVisibility(0);
      i2 = i1;
      break;
      label257: this.e.setText(this.E);
      if (this.F != null)
      {
        this.F.setBounds(0, 0, this.s, this.s);
        this.e.setCompoundDrawables(this.F, null, null, null);
      }
      this.e.setVisibility(0);
      i2 |= 2;
      break label106;
      label321: this.g.setText(this.G);
      if (this.D != null)
      {
        this.D.setBounds(0, 0, this.s, this.s);
        this.c.setCompoundDrawables(this.D, null, null, null);
      }
      this.g.setVisibility(0);
      i2 |= 4;
      break label157;
      label385: if (i2 == 2)
      {
        a(this.e);
        break label180;
      }
      if (i2 != 4)
        break label180;
      a(this.g);
      break label180;
      label417: i1 = 0;
    }
  }

  public void a()
  {
    int i1 = c();
    this.a.setContentView(i1);
    d();
  }

  public void a(int paramInt)
  {
    this.v = null;
    this.w = paramInt;
    this.B = false;
  }

  public void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    if ((paramMessage == null) && (paramOnClickListener != null))
      paramMessage = this.p.obtainMessage(paramInt, paramOnClickListener);
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Button does not exist");
    case -1:
      this.C = paramCharSequence;
      this.d = paramMessage;
      this.D = paramDrawable;
      return;
    case -2:
      this.E = paramCharSequence;
      this.f = paramMessage;
      this.F = paramDrawable;
      return;
    case -3:
    }
    this.G = paramCharSequence;
    this.h = paramMessage;
    this.H = paramDrawable;
  }

  public void a(Drawable paramDrawable)
  {
    this.J = paramDrawable;
    this.I = 0;
    if (this.K != null)
    {
      if (paramDrawable != null)
      {
        this.K.setVisibility(0);
        this.K.setImageDrawable(paramDrawable);
      }
    }
    else
      return;
    this.K.setVisibility(8);
  }

  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.v = paramView;
    this.w = 0;
    this.B = true;
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    this.A = paramInt4;
  }

  public void a(CharSequence paramCharSequence)
  {
    this.t = paramCharSequence;
    if (this.L != null)
      this.L.setText(paramCharSequence);
  }

  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.i != null) && (this.i.executeKeyEvent(paramKeyEvent));
  }

  public ListView b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.J = null;
    this.I = paramInt;
    if (this.K != null)
    {
      if (paramInt != 0)
      {
        this.K.setVisibility(0);
        this.K.setImageResource(this.I);
      }
    }
    else
      return;
    this.K.setVisibility(8);
  }

  public void b(View paramView)
  {
    this.N = paramView;
  }

  public void b(CharSequence paramCharSequence)
  {
    this.u = paramCharSequence;
    if (this.M != null)
      this.M.setText(paramCharSequence);
  }

  public boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.i != null) && (this.i.executeKeyEvent(paramKeyEvent));
  }

  public int c(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.q.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.resourceId;
  }

  public void c(View paramView)
  {
    this.v = paramView;
    this.w = 0;
    this.B = false;
  }

  public Button d(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case -1:
      return this.c;
    case -2:
      return this.e;
    case -3:
    }
    return this.g;
  }

  public static class RecycleListView extends ListView
  {
    private final int a;
    private final int b;

    public RecycleListView(Context paramContext)
    {
      this(paramContext, null);
    }

    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
      this.b = localTypedArray.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
      this.a = localTypedArray.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      int i;
      int j;
      int k;
      if ((!paramBoolean2) || (!paramBoolean1))
      {
        i = getPaddingLeft();
        if (!paramBoolean1)
          break label51;
        j = getPaddingTop();
        k = getPaddingRight();
        if (!paramBoolean2)
          break label60;
      }
      label51: label60: for (int m = getPaddingBottom(); ; m = this.b)
      {
        setPadding(i, j, k, m);
        return;
        j = this.a;
        break;
      }
    }
  }

  public static class a
  {
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E = false;
    public boolean[] F;
    public boolean G;
    public boolean H;
    public int I = -1;
    public DialogInterface.OnMultiChoiceClickListener J;
    public Cursor K;
    public String L;
    public String M;
    public AdapterView.OnItemSelectedListener N;
    public a O;
    public boolean P = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public Drawable j;
    public DialogInterface.OnClickListener k;
    public CharSequence l;
    public Drawable m;
    public DialogInterface.OnClickListener n;
    public CharSequence o;
    public Drawable p;
    public DialogInterface.OnClickListener q;
    public boolean r;
    public DialogInterface.OnCancelListener s;
    public DialogInterface.OnDismissListener t;
    public DialogInterface.OnKeyListener u;
    public CharSequence[] v;
    public ListAdapter w;
    public DialogInterface.OnClickListener x;
    public int y;
    public View z;

    public a(Context paramContext)
    {
      this.a = paramContext;
      this.r = true;
      this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }

    private void b(final AlertController paramAlertController)
    {
      final AlertController.RecycleListView localRecycleListView = (AlertController.RecycleListView)this.b.inflate(paramAlertController.l, null);
      Object localObject;
      if (this.G)
        if (this.K == null)
        {
          localObject = new ArrayAdapter(this.a, paramAlertController.m, 16908308, this.v)
          {
            public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
            {
              View localView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
              if ((AlertController.a.this.F != null) && (AlertController.a.this.F[paramAnonymousInt] != 0))
                localRecycleListView.setItemChecked(paramAnonymousInt, true);
              return localView;
            }
          };
          if (this.O != null)
            this.O.a(localRecycleListView);
          paramAlertController.j = ((ListAdapter)localObject);
          paramAlertController.k = this.I;
          if (this.x == null)
            break label282;
          localRecycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AlertController.a.this.x.onClick(paramAlertController.a, paramAnonymousInt);
              if (!AlertController.a.this.H)
                paramAlertController.a.dismiss();
            }
          });
          label106: if (this.N != null)
            localRecycleListView.setOnItemSelectedListener(this.N);
          if (!this.H)
            break label306;
          localRecycleListView.setChoiceMode(1);
        }
      while (true)
      {
        paramAlertController.b = localRecycleListView;
        return;
        localObject = new CursorAdapter(this.a, this.K, false)
        {
          private final int d;
          private final int e;

          public void bindView(View paramAnonymousView, Context paramAnonymousContext, Cursor paramAnonymousCursor)
          {
            ((CheckedTextView)paramAnonymousView.findViewById(16908308)).setText(paramAnonymousCursor.getString(this.d));
            AlertController.RecycleListView localRecycleListView = localRecycleListView;
            int i = paramAnonymousCursor.getPosition();
            if (paramAnonymousCursor.getInt(this.e) == 1);
            for (boolean bool = true; ; bool = false)
            {
              localRecycleListView.setItemChecked(i, bool);
              return;
            }
          }

          public View newView(Context paramAnonymousContext, Cursor paramAnonymousCursor, ViewGroup paramAnonymousViewGroup)
          {
            return AlertController.a.this.b.inflate(paramAlertController.m, paramAnonymousViewGroup, false);
          }
        };
        break;
        if (this.H);
        for (int i1 = paramAlertController.n; ; i1 = paramAlertController.o)
        {
          if (this.K == null)
            break label243;
          Context localContext = this.a;
          Cursor localCursor = this.K;
          String[] arrayOfString = new String[1];
          arrayOfString[0] = this.L;
          localObject = new SimpleCursorAdapter(localContext, i1, localCursor, arrayOfString, new int[] { 16908308 });
          break;
        }
        label243: if (this.w != null)
        {
          localObject = this.w;
          break;
        }
        localObject = new AlertController.c(this.a, i1, 16908308, this.v);
        break;
        label282: if (this.J == null)
          break label106;
        localRecycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (AlertController.a.this.F != null)
              AlertController.a.this.F[paramAnonymousInt] = localRecycleListView.isItemChecked(paramAnonymousInt);
            AlertController.a.this.J.onClick(paramAlertController.a, paramAnonymousInt, localRecycleListView.isItemChecked(paramAnonymousInt));
          }
        });
        break label106;
        label306: if (this.G)
          localRecycleListView.setChoiceMode(2);
      }
    }

    public void a(AlertController paramAlertController)
    {
      if (this.g != null)
      {
        paramAlertController.b(this.g);
        if (this.h != null)
          paramAlertController.b(this.h);
        if ((this.i != null) || (this.j != null))
          paramAlertController.a(-1, this.i, this.k, null, this.j);
        if ((this.l != null) || (this.m != null))
          paramAlertController.a(-2, this.l, this.n, null, this.m);
        if ((this.o != null) || (this.p != null))
          paramAlertController.a(-3, this.o, this.q, null, this.p);
        if ((this.v != null) || (this.K != null) || (this.w != null))
          b(paramAlertController);
        if (this.z == null)
          break label269;
        if (!this.E)
          break label260;
        paramAlertController.a(this.z, this.A, this.B, this.C, this.D);
      }
      label260: label269: 
      while (this.y == 0)
      {
        return;
        if (this.f != null)
          paramAlertController.a(this.f);
        if (this.d != null)
          paramAlertController.a(this.d);
        if (this.c != 0)
          paramAlertController.b(this.c);
        if (this.e == 0)
          break;
        paramAlertController.b(paramAlertController.c(this.e));
        break;
        paramAlertController.c(this.z);
        return;
      }
      paramAlertController.a(this.y);
    }

    public static abstract interface a
    {
      public abstract void a(ListView paramListView);
    }
  }

  private static final class b extends Handler
  {
    private WeakReference<DialogInterface> a;

    public b(DialogInterface paramDialogInterface)
    {
      this.a = new WeakReference(paramDialogInterface);
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 0:
      default:
        return;
      case -3:
      case -2:
      case -1:
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.a.get(), paramMessage.what);
        return;
      case 1:
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }

  private static class c extends ArrayAdapter<CharSequence>
  {
    public c(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt1, paramInt2, paramArrayOfCharSequence);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public boolean hasStableIds()
    {
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AlertController
 * JD-Core Version:    0.6.2
 */