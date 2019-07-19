package com.viber.common.dialogs;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.c;
import android.support.v7.app.c.a;
import android.support.v7.app.g;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import com.viber.common.R.id;
import com.viber.common.R.layout;
import com.viber.common.a.e;
import com.viber.common.a.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class m extends g
{
  private static e a = f.a();
  private boolean A;
  private Object B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private int H;
  private boolean I;
  private boolean J;
  private boolean K;
  private Integer L;
  private boolean M;
  private boolean N;
  private int O;
  private boolean P;
  private CharSequence[] Q;
  private int R;
  private int S;
  private List<Parcelable> T;
  private int U;
  private boolean V;
  private int W;
  private int X;
  private int Y;
  private Long Z;
  private Long aa;
  private boolean ab;
  private final View.OnClickListener ac = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      m.d(m.this).onClick(m.this.getDialog(), -1);
      if (!m.e(m.this))
        m.c(m.this);
    }
  };
  private final DialogInterface.OnClickListener ad = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      m.this.a(m.f(m.this), m.g(m.this));
      if (!m.e(m.this))
        m.this.a();
    }
  };
  private final View.OnClickListener ae = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      m.h(m.this).onClick(m.this.getDialog(), -3);
      if (!m.i(m.this))
        m.c(m.this);
    }
  };
  private final DialogInterface.OnClickListener af = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      m.this.a(m.j(m.this), m.k(m.this));
      if (!m.i(m.this))
        m.this.a();
    }
  };
  private final View.OnClickListener ag = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      m.l(m.this).onClick(m.this.getDialog(), -2);
      if (!m.m(m.this))
        m.c(m.this);
    }
  };
  private final DialogInterface.OnClickListener ah = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      m.this.a(m.n(m.this), m.o(m.this));
      if (!m.m(m.this))
        m.this.a();
    }
  };
  private final DatePickerDialog.OnDateSetListener ai = new n(this);
  private final i.c aj = new o(this);
  private final i.b ak = new p(this);
  private String b;
  private int c;
  private CharSequence d;
  private int e;
  private int f;
  private String g;
  private int h;
  private int i;
  private String j;
  private String k;
  private int l;
  private int m;
  private String n;
  private String o;
  private int p;
  private int q;
  private String r;
  private int s;
  private int t;
  private boolean u;
  private DialogCodeProvider v;
  private a w;
  private boolean x;
  private String y;
  private String z;

  public static a a(Context paramContext, Intent paramIntent)
  {
    return a(paramContext, paramIntent.getExtras());
  }

  public static a a(Context paramContext, Bundle paramBundle)
  {
    a locala = d(paramBundle);
    if ((locala != null) && (locala.a(paramContext) != null))
      return locala;
    return null;
  }

  public static m a(Bundle paramBundle)
  {
    m localm = new m();
    localm.setArguments(paramBundle);
    return localm;
  }

  private void a(Dialog paramDialog)
  {
    paramDialog.setOnKeyListener(new v(this));
  }

  private void a(View paramView)
  {
    BottomSheetBehavior.from((View)paramView.getParent()).setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback()
    {
      public void onSlide(View paramAnonymousView, float paramAnonymousFloat)
      {
      }

      public void onStateChanged(View paramAnonymousView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 5)
        {
          m.this.a(m.a(m.this), m.b(m.this));
          m.c(m.this);
          m.this.a();
        }
      }
    });
  }

  private void b(i.a parama)
  {
    if (this.x)
    {
      if (this.w == null)
        break label24;
      this.w.onDialogDataListBind(this, parama);
    }
    label24: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof e)))
      {
        ((e)getParentFragment()).onDialogDataListBind(this, parama);
        return;
      }
    }
    while (!(getActivity() instanceof e));
    ((e)getActivity()).onDialogDataListBind(this, parama);
  }

  public static a d(Bundle paramBundle)
  {
    a locala = null;
    if (paramBundle == null);
    Bundle localBundle;
    do
    {
      do
      {
        return locala;
        localBundle = paramBundle.getBundle("all_isolated_extras");
        locala = null;
      }
      while (localBundle == null);
      locala = (a)localBundle.getSerializable("dialog_instance");
    }
    while (locala == null);
    return locala.a().a(localBundle).f();
  }

  private void e()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof BaseRemoteViberDialogsActivity))
      localFragmentActivity.finish();
    while ((localFragmentActivity == null) || (!this.D))
      return;
    localFragmentActivity.finish();
  }

  private void f()
  {
    Dialog localDialog = getDialog();
    if ((localDialog != null) && (this.E) && (!TextUtils.isEmpty(this.d)))
      if (-1 == this.f)
        break label68;
    label68: for (int i1 = this.e; ; i1 = 16908299)
    {
      if (-1 != i1)
      {
        View localView = localDialog.findViewById(i1);
        if ((localView instanceof TextView))
          ((TextView)localView).setMovementMethod(LinkMovementMethod.getInstance());
      }
      return;
    }
  }

  private void g()
  {
    Dialog localDialog = getDialog();
    if (localDialog != null)
    {
      localDialog.dismiss();
      return;
    }
    dismiss();
  }

  private LayoutInflater h()
  {
    return requireActivity().getLayoutInflater();
  }

  protected final void a()
  {
    if (this.L != null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
        localFragmentActivity.setRequestedOrientation(this.L.intValue());
    }
  }

  protected final void a(int paramInt)
  {
    if (this.x)
    {
      if (this.w == null)
        break label24;
      this.w.onDialogListAction(this, paramInt);
    }
    label24: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof g)))
      {
        ((g)getParentFragment()).onDialogListAction(this, paramInt);
        return;
      }
    }
    while (!(getActivity() instanceof g));
    ((g)getActivity()).onDialogListAction(this, paramInt);
  }

  protected final void a(int paramInt, Object paramObject)
  {
    if (this.x)
    {
      if (this.w == null)
        break label25;
      this.w.onDialogDataListAction(this, paramInt, paramObject);
    }
    label25: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof d)))
      {
        ((d)getParentFragment()).onDialogDataListAction(this, paramInt, paramObject);
        return;
      }
    }
    while (!(getActivity() instanceof d));
    ((d)getActivity()).onDialogDataListAction(this, paramInt, paramObject);
  }

  protected final void a(int paramInt, String paramString)
  {
    while (true)
    {
      try
      {
        if ((this.x) && (-2147483648 != paramInt))
        {
          if (this.w != null)
            this.w.onDialogAction(this, paramInt);
        }
        else
        {
          if ((!this.u) || (TextUtils.isEmpty(paramString)) || (w.a() == null))
            break;
          w.a().a(this.v.code(), paramString);
          return;
        }
        if ((this.C) && ((getParentFragment() instanceof c)))
        {
          ((c)getParentFragment()).onDialogAction(this, paramInt);
          continue;
        }
      }
      catch (Exception localException)
      {
        a.a(localException, "handleDialogAction:" + paramInt + ", " + paramString);
        return;
      }
      if ((getActivity() instanceof c))
        ((c)getActivity()).onDialogAction(this, paramInt);
    }
  }

  protected final void a(View paramView, int paramInt)
  {
    if (this.x)
    {
      if (this.w == null)
        break label25;
      this.w.onPrepareDialogView(this, paramView, paramInt);
    }
    label25: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof h)))
      {
        ((h)getParentFragment()).onPrepareDialogView(this, paramView, paramInt);
        return;
      }
    }
    while (!(getActivity() instanceof h));
    ((h)getActivity()).onPrepareDialogView(this, paramView, paramInt);
  }

  protected final void a(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.x)
    {
      if (this.w == null)
        break label28;
      this.w.onDateSet(this, paramDatePicker, paramInt1, paramInt2, paramInt3);
    }
    label28: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof b)))
      {
        ((b)getParentFragment()).onDateSet(this, paramDatePicker, paramInt1, paramInt2, paramInt3);
        return;
      }
    }
    while (!(getActivity() instanceof b));
    ((b)getActivity()).onDateSet(this, paramDatePicker, paramInt1, paramInt2, paramInt3);
  }

  public void a(Object paramObject)
  {
    if ((paramObject instanceof Parcelable))
      getArguments().putParcelable("attached_parcelable_data", (Parcelable)paramObject);
    while (!(paramObject instanceof Serializable))
      return;
    getArguments().putSerializable("attached_serializable_data", (Serializable)paramObject);
  }

  public boolean a(DialogCodeProvider paramDialogCodeProvider)
  {
    return z.a(this.v, paramDialogCodeProvider);
  }

  protected final void b()
  {
    if (this.x)
    {
      if (this.w == null)
        break label23;
      this.w.onDialogShow(this);
    }
    label23: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof j)))
      {
        ((j)getParentFragment()).onDialogShow(this);
        return;
      }
    }
    while (!(getActivity() instanceof j));
    ((j)getActivity()).onDialogShow(this);
  }

  protected final void b(Bundle paramBundle)
  {
    if (this.x)
    {
      if (this.w == null)
        break label24;
      this.w.onDialogSaveState(this, paramBundle);
    }
    label24: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof i)))
      {
        ((i)getParentFragment()).onDialogSaveState(this, paramBundle);
        return;
      }
    }
    while (!(getActivity() instanceof i));
    ((i)getActivity()).onDialogSaveState(this, paramBundle);
  }

  public DialogCodeProvider c()
  {
    return this.v;
  }

  protected final void c(Bundle paramBundle)
  {
    if (this.x)
    {
      if (this.w == null)
        break label24;
      this.w.onDialogRestoreState(this, paramBundle);
    }
    label24: 
    do
    {
      return;
      if ((this.C) && ((getParentFragment() instanceof i)))
      {
        ((i)getParentFragment()).onDialogRestoreState(this, paramBundle);
        return;
      }
    }
    while (!(getActivity() instanceof i));
    ((i)getActivity()).onDialogRestoreState(this, paramBundle);
  }

  public Object d()
  {
    return this.B;
  }

  public void dismiss()
  {
    getArguments().putBoolean("is_dismissed", true);
    if (getFragmentManager() != null);
    try
    {
      super.dismiss();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      a.b(localIllegalStateException, "dismiss()", new Object[0]);
    }
  }

  public void dismissAllowingStateLoss()
  {
    getArguments().putBoolean("is_dismissed", true);
    if (getFragmentManager() != null);
    try
    {
      super.dismissAllowingStateLoss();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      a.b(localIllegalStateException, "dismiss()", new Object[0]);
    }
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    a(this.s, this.y);
    super.onCancel(paramDialogInterface);
    a();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if ((localBundle == null) || (localBundle.isEmpty()))
      throw new IllegalStateException("Some arguments must be supplied to build an alert dialog");
    this.b = localBundle.getString("title");
    this.c = localBundle.getInt("title_id");
    this.d = localBundle.getCharSequence("body");
    this.e = localBundle.getInt("body_id");
    this.f = localBundle.getInt("body_layout_id");
    this.g = localBundle.getString("positive_button");
    this.h = localBundle.getInt("positive_button_id");
    this.i = localBundle.getInt("positive_action_request_code");
    this.j = localBundle.getString("analytics_positive_button");
    this.k = localBundle.getString("negative_button");
    this.l = localBundle.getInt("negative_button_id");
    this.m = localBundle.getInt("negative_action_request_code");
    this.n = localBundle.getString("analytics_negative_button");
    this.o = localBundle.getString("neutral_button");
    this.p = localBundle.getInt("neutral_button_id");
    this.q = localBundle.getInt("neutral_action_request_code");
    this.r = localBundle.getString("analytics_neutral_button");
    this.s = localBundle.getInt("cancel_action_request_code");
    this.t = localBundle.getInt("dismiss_action_request_code");
    this.u = localBundle.getBoolean("is_trackable");
    this.v = ((DialogCodeProvider)localBundle.getSerializable("dialog_code"));
    this.w = ((a)localBundle.getSerializable("isolated_handler"));
    this.x = localBundle.getBoolean("has_callbacks");
    this.y = localBundle.getString("analytics_cancel_action");
    this.z = localBundle.getString("analytics_dismiss_action");
    this.A = localBundle.getBoolean("is_cancelable");
    this.C = localBundle.getBoolean("has_target_fragment");
    this.D = localBundle.getBoolean("has_destroyable_underlay");
    this.E = localBundle.getBoolean("links_clickable");
    this.F = localBundle.getBoolean("is_restorable");
    this.G = localBundle.getBoolean("is_dismissed");
    this.H = localBundle.getInt("custom_style");
    this.I = localBundle.getBoolean("disable_dismiss_on_positive_button");
    this.J = localBundle.getBoolean("disable_dismiss_on_negative_button");
    this.K = localBundle.getBoolean("disable_dismiss_on_neutral_button");
    Integer localInteger;
    CharSequence[] arrayOfCharSequence;
    if (localBundle.containsKey("locked_orientation_current"))
    {
      localInteger = Integer.valueOf(localBundle.getInt("locked_orientation_current"));
      this.L = localInteger;
      this.M = localBundle.getBoolean("has_progress");
      this.N = localBundle.getBoolean("is_indeterminate_progress");
      this.O = localBundle.getInt("progress_indeterminate_drawable");
      this.P = localBundle.getBoolean("has_list");
      ArrayList localArrayList = localBundle.getStringArrayList("list_items");
      if ((localArrayList == null) || (localArrayList.isEmpty()))
        break label737;
      arrayOfCharSequence = (CharSequence[])localArrayList.toArray(new CharSequence[0]);
      label529: this.Q = arrayOfCharSequence;
      this.R = localBundle.getInt("selected_list_item");
      this.S = localBundle.getInt("list_style");
      this.T = localBundle.getParcelableArrayList("data_list_items");
      this.U = localBundle.getInt("data_list_item_layout_id");
      this.V = localBundle.getBoolean("has_date_picker");
      this.W = localBundle.getInt("day_of_month");
      this.X = localBundle.getInt("month_of_year");
      this.Y = localBundle.getInt("year");
      if (localBundle.containsKey("min_date_millis"))
        this.Z = Long.valueOf(localBundle.getLong("min_date_millis"));
      if (localBundle.containsKey("max_date_millis"))
        this.aa = Long.valueOf(localBundle.getLong("max_date_millis"));
      if (!localBundle.containsKey("attached_parcelable_data"))
        break label746;
      this.B = localBundle.getParcelable("attached_parcelable_data");
    }
    while (true)
    {
      if (!this.F)
      {
        localBundle.remove("isolated_handler");
        localBundle.remove("attached_parcelable_data");
        localBundle.remove("attached_serializable_data");
      }
      this.ab = localBundle.getBoolean("is_bottom_sheet");
      return;
      localInteger = null;
      break;
      label737: arrayOfCharSequence = new CharSequence[0];
      break label529;
      label746: if (localBundle.containsKey("attached_serializable_data"))
        this.B = localBundle.getSerializable("attached_serializable_data");
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if ((paramBundle != null) && (!this.F))
      dismiss();
    if (this.G)
      dismiss();
    c.a locala2;
    Object localObject1;
    c.a locala1;
    label76: ProgressDialog localProgressDialog1;
    ProgressDialog localProgressDialog2;
    if ((!this.M) && (!this.V))
      if (!this.ab)
        if (this.H != 0)
        {
          locala2 = new c.a(requireActivity(), this.H);
          localObject1 = null;
          locala1 = locala2;
          if (!this.M)
            break label923;
          localProgressDialog1 = new ProgressDialog(getActivity());
          if (this.O == 0)
            break label1295;
          localProgressDialog1.setIndeterminateDrawable(getResources().getDrawable(this.O));
          localProgressDialog2 = localProgressDialog1;
        }
    while (true)
    {
      label123: DatePickerDialog localDatePickerDialog1;
      DatePickerDialog localDatePickerDialog2;
      if (this.V)
      {
        localDatePickerDialog1 = new DatePickerDialog(requireActivity(), this.H, this.ai, this.Y, this.X, this.W);
        if (this.Z != null)
          localDatePickerDialog1.getDatePicker().setMinDate(this.Z.longValue());
        if (this.aa == null)
          break label1288;
        localDatePickerDialog1.getDatePicker().setMaxDate(this.aa.longValue());
        localDatePickerDialog2 = localDatePickerDialog1;
      }
      while (true)
      {
        label211: label235: View localView1;
        label264: label304: int i4;
        label486: label493: int i3;
        label569: label576: int i2;
        label652: label659: Object localObject2;
        if (!TextUtils.isEmpty(this.b))
        {
          if (localProgressDialog2 != null)
            localProgressDialog2.setTitle(this.b);
        }
        else
        {
          if ((!TextUtils.isEmpty(this.d)) && (localDatePickerDialog2 == null))
          {
            if (localProgressDialog2 == null)
              break label976;
            localProgressDialog2.setMessage(this.d);
          }
          int i1 = this.f;
          localView1 = null;
          if (-1 != i1)
          {
            localView1 = h().inflate(this.f, null);
            if (locala1 == null)
              break label1000;
            locala1.b(localView1);
            a(localView1, this.f);
          }
          if ((locala1 != null) && (-1 != this.c) && (localView1 != null))
          {
            View localView7 = localView1.findViewById(this.c);
            if ((localView7 instanceof TextView))
              ((TextView)localView7).setText(this.b);
          }
          if ((locala1 != null) && (-1 != this.e) && (localView1 != null))
          {
            View localView6 = localView1.findViewById(this.e);
            if ((localView6 instanceof TextView))
              ((TextView)localView6).setText(this.d);
          }
          if (locala1 != null)
          {
            if ((-1 == this.h) || (localView1 == null))
              break label1019;
            View localView5 = localView1.findViewById(this.h);
            if (localView5 != null)
            {
              localView5.setOnClickListener(this.ac);
              if ((localView5 instanceof TextView))
              {
                ((TextView)localView5).setText(this.g);
                if (!TextUtils.isEmpty(this.g))
                  break label1013;
                i4 = 8;
                localView5.setVisibility(i4);
              }
            }
          }
          if (locala1 != null)
          {
            if ((-1 == this.p) || (localView1 == null))
              break label1051;
            View localView4 = localView1.findViewById(this.p);
            if (localView4 != null)
            {
              localView4.setOnClickListener(this.ae);
              if ((localView4 instanceof TextView))
              {
                ((TextView)localView4).setText(this.o);
                if (!TextUtils.isEmpty(this.o))
                  break label1045;
                i3 = 8;
                localView4.setVisibility(i3);
              }
            }
          }
          if (locala1 != null)
          {
            if ((-1 == this.l) || (localView1 == null))
              break label1083;
            View localView3 = localView1.findViewById(this.l);
            if (localView3 != null)
            {
              localView3.setOnClickListener(this.ag);
              if ((localView3 instanceof TextView))
              {
                ((TextView)localView3).setText(this.k);
                if (!TextUtils.isEmpty(this.k))
                  break label1077;
                i2 = 8;
                localView3.setVisibility(i2);
              }
            }
          }
          if (!this.P)
            break label1281;
          if (locala1 == null)
            break label1145;
          if (this.S != 0)
            break label1109;
          locala1.a(this.Q, new s(this));
          localObject2 = localView1;
        }
        while (true)
        {
          label698: if ((!TextUtils.isEmpty(this.b)) && (localObject1 != null) && (localObject2 != null))
          {
            TextView localTextView = (TextView)((View)localObject2).findViewById(R.id.dialog_title_internal);
            if (localTextView != null)
            {
              localTextView.setVisibility(0);
              localTextView.setText(this.b);
              a((View)localObject2);
            }
          }
          if (localProgressDialog2 != null)
            localProgressDialog2.setIndeterminate(this.N);
          Object localObject3;
          if (localProgressDialog2 != null)
          {
            localObject3 = localProgressDialog2;
            label779: if (TextUtils.isEmpty(this.b))
            {
              if ((locala1 == null) || (!(localObject3 instanceof c)))
                break label1267;
              ((c)localObject3).supportRequestWindowFeature(1);
            }
          }
          while (true)
          {
            if (!this.A)
            {
              ((Dialog)localObject3).setCancelable(false);
              ((Dialog)localObject3).setCanceledOnTouchOutside(false);
            }
            a((Dialog)localObject3);
            ((Dialog)localObject3).setOnShowListener(new u(this));
            return localObject3;
            locala2 = new c.a(requireActivity());
            break;
            if (this.H != 0);
            for (BottomSheetDialog localBottomSheetDialog = new BottomSheetDialog(requireActivity(), this.H); ; localBottomSheetDialog = new BottomSheetDialog(requireActivity()))
            {
              localObject1 = localBottomSheetDialog;
              locala1 = null;
              break;
            }
            localObject1 = null;
            locala1 = null;
            break label76;
            label923: localProgressDialog2 = null;
            break label123;
            localDatePickerDialog2 = null;
            break label211;
            if (localDatePickerDialog2 != null)
            {
              localDatePickerDialog2.setTitle(this.b);
              break label235;
            }
            if ((-1 != this.c) || (locala1 == null))
              break label235;
            locala1.a(this.b);
            break label235;
            label976: if ((-1 != this.e) || (locala1 == null))
              break label264;
            locala1.b(this.d);
            break label264;
            label1000: if (localObject1 == null)
              break label304;
            localObject1.setContentView(localView1);
            break label304;
            label1013: i4 = 0;
            break label486;
            label1019: if (TextUtils.isEmpty(this.g))
              break label493;
            locala1.a(this.g, this.ad);
            break label493;
            label1045: i3 = 0;
            break label569;
            label1051: if (TextUtils.isEmpty(this.o))
              break label576;
            locala1.c(this.o, this.af);
            break label576;
            label1077: i2 = 0;
            break label652;
            label1083: if (TextUtils.isEmpty(this.k))
              break label659;
            locala1.b(this.k, this.ah);
            break label659;
            label1109: if (this.S != 1)
              break label1281;
            locala1.a(this.Q, this.R, new t(this));
            localObject2 = localView1;
            break label698;
            label1145: if (localObject1 == null)
              break label1281;
            View localView2 = h().inflate(R.layout.content_data_list_internal, null);
            RecyclerView localRecyclerView = (RecyclerView)localView2.findViewById(R.id.dialog_recycler_view);
            localRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
            localRecyclerView.setAdapter(new i(requireActivity(), this.T, this.aj, this.ak, this.U));
            localObject1.setContentView(localView2);
            localObject2 = localView2;
            break label698;
            if (localDatePickerDialog2 != null)
            {
              localObject3 = localDatePickerDialog2;
              break label779;
            }
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              break label779;
            }
            localObject3 = locala1.b();
            break label779;
            label1267: if (localObject1 == null)
              ((Dialog)localObject3).requestWindowFeature(1);
          }
          label1281: localObject2 = localView1;
        }
        label1288: localDatePickerDialog2 = localDatePickerDialog1;
      }
      label1295: localProgressDialog2 = localProgressDialog1;
    }
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    a(this.t, this.z);
    super.onDismiss(paramDialogInterface);
    e();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    b(paramBundle);
  }

  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    c(paramBundle);
  }

  public void setCancelable(boolean paramBoolean)
  {
    this.A = paramBoolean;
    super.setCancelable(paramBoolean);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new q(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new r(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }

  public static class a
    implements m.b, m.c, m.d, m.e, m.f, m.g, m.h, m.i, m.j, Serializable
  {
    public void onDateSet(m paramm, DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onDialogAction(m paramm, int paramInt)
    {
    }

    public void onDialogDataListAction(m paramm, int paramInt, Object paramObject)
    {
    }

    public void onDialogDataListBind(m paramm, i.a parama)
    {
    }

    public void onDialogDisplayingRejected(Context paramContext, m.f.a parama)
    {
    }

    public void onDialogListAction(m paramm, int paramInt)
    {
    }

    public void onDialogRestoreState(m paramm, Bundle paramBundle)
    {
    }

    public void onDialogSaveState(m paramm, Bundle paramBundle)
    {
    }

    public void onDialogShow(m paramm)
    {
    }

    public void onPrepareDialogView(m paramm, View paramView, int paramInt)
    {
    }
  }

  public static abstract interface b
  {
    public abstract void onDateSet(m paramm, DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3);
  }

  public static abstract interface c
  {
    public abstract void onDialogAction(m paramm, int paramInt);
  }

  public static abstract interface d
  {
    public abstract void onDialogDataListAction(m paramm, int paramInt, Object paramObject);
  }

  public static abstract interface e
  {
    public abstract void onDialogDataListBind(m paramm, i.a parama);
  }

  public static abstract interface f
  {
    public static enum a
    {
      static
      {
        a[] arrayOfa = new a[1];
        arrayOfa[0] = a;
      }
    }
  }

  public static abstract interface g
  {
    public abstract void onDialogListAction(m paramm, int paramInt);
  }

  public static abstract interface h
  {
    public abstract void onPrepareDialogView(m paramm, View paramView, int paramInt);
  }

  public static abstract interface i
  {
    public abstract void onDialogRestoreState(m paramm, Bundle paramBundle);

    public abstract void onDialogSaveState(m paramm, Bundle paramBundle);
  }

  public static abstract interface j
  {
    public abstract void onDialogShow(m paramm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.m
 * JD-Core Version:    0.6.2
 */