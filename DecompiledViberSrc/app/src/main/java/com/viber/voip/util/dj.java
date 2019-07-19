package com.viber.voip.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.d;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.bool;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.layout;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.b.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.m;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.i;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.j;
import com.viber.voip.widget.GroupIconView;
import com.viber.voip.widget.ab;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class dj
{
  private static final Logger a = ViberEnv.getLogger();
  private static Set<String> b;

  public static float a(Resources paramResources)
  {
    TypedValue localTypedValue = new TypedValue();
    paramResources.getValue(R.dimen.home_weight_left, localTypedValue, true);
    return localTypedValue.getFloat();
  }

  public static int a(ViewGroup paramViewGroup, int paramInt)
  {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++)
      if (paramInt == paramViewGroup.getChildAt(i).getId())
        return i;
    return -1;
  }

  public static Drawable a(int paramInt)
  {
    com.viber.common.ui.a.b localb = new com.viber.common.ui.a.b();
    localb.b(paramInt);
    return new ShapeDrawable(localb);
  }

  public static PowerManager.WakeLock a(Context paramContext, String paramString)
  {
    return ((PowerManager)paramContext.getSystemService("power")).newWakeLock(805306394, paramString);
  }

  public static View a(SearchView paramSearchView)
  {
    if (paramSearchView == null)
      return null;
    return paramSearchView.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
  }

  public static LinearLayout a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramLayoutInflater.inflate(R.layout.abs__action_bar_title_item, null);
    ((ImageView)localLinearLayout.findViewById(com.viber.voip.R.id.abs__up)).setImageResource(R.drawable.ic_ab_theme_light_back);
    ((TextView)localLinearLayout.findViewById(com.viber.voip.R.id.abs__action_bar_title)).setTextAppearance(paramContext, R.style.TextAppearance_Viber_Widget_ActionBar_Title_Light);
    TextView localTextView = (TextView)localLinearLayout.findViewById(com.viber.voip.R.id.abs__action_bar_subtitle);
    localTextView.setTextAppearance(paramContext, R.style.TextAppearance_Viber_Widget_ActionBar_Subtitle_Light);
    ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).setMargins(0, 0, 0, 0);
    return localLinearLayout;
  }

  private static TextView a(Snackbar paramSnackbar)
  {
    return (TextView)paramSnackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
  }

  public static CharSequence a(AppCompatActivity paramAppCompatActivity)
  {
    android.support.v7.app.a locala;
    if (paramAppCompatActivity != null)
    {
      locala = paramAppCompatActivity.getSupportActionBar();
      if (locala != null);
    }
    else
    {
      return null;
    }
    if (ViberApplication.isTablet(paramAppCompatActivity))
    {
      View localView = locala.a();
      if (localView == null)
        return "";
      TextView localTextView = (TextView)localView.findViewById(com.viber.voip.R.id.abs__action_bar_title);
      if (localTextView == null)
        return "";
      return localTextView.getText();
    }
    return locala.b();
  }

  public static Integer a(Context paramContext, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true))
    {
      int i = localTypedValue.resourceId;
      try
      {
        Integer localInteger = Integer.valueOf(ContextCompat.getColor(paramContext, i));
        return localInteger;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
      }
    }
    return null;
  }

  public static void a()
  {
  }

  public static void a(int paramInt, View paramView)
  {
    paramView.getLayoutParams().height = paramInt;
    if (ViewCompat.isLaidOut(paramView))
      paramView.requestLayout();
  }

  public static void a(Activity paramActivity)
  {
    a(paramActivity, 16, 32);
  }

  public static void a(Activity paramActivity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    a(paramActivity, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean, null);
  }

  public static void a(Activity paramActivity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, Configuration paramConfiguration)
  {
    int j;
    int k;
    if (paramConfiguration == null)
    {
      DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
      boolean bool = c(paramActivity);
      float f3 = localDisplayMetrics.widthPixels;
      float f4;
      if (bool)
      {
        j = (int)(f3 * paramFloat3);
        f4 = localDisplayMetrics.heightPixels;
        if (!bool)
          break label78;
      }
      while (true)
      {
        k = (int)(f4 * paramFloat4);
        a(paramActivity, j, k, false, paramBoolean);
        return;
        paramFloat3 = paramFloat1;
        break;
        label78: paramFloat4 = paramFloat2;
      }
    }
    int i;
    label96: label113: float f2;
    if (paramConfiguration.orientation == 2)
    {
      i = 1;
      float f1 = j.a(paramConfiguration.screenWidthDp);
      if (i == 0)
        break label154;
      j = (int)(f1 * paramFloat3);
      f2 = j.a(paramConfiguration.screenHeightDp);
      if (i == 0)
        break label159;
    }
    while (true)
    {
      k = (int)(f2 * paramFloat4);
      break;
      i = 0;
      break label96;
      label154: paramFloat3 = paramFloat1;
      break label113;
      label159: paramFloat4 = paramFloat2;
    }
  }

  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (c(paramActivity))
    {
      paramActivity.getWindow().setSoftInputMode(paramInt2);
      return;
    }
    paramActivity.getWindow().setSoftInputMode(paramInt1);
  }

  private static void a(final Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    localViewGroup.setBackgroundResource(R.color.solid_60);
    final View localView1 = localViewGroup.getChildAt(0);
    ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = 17;
    while (true)
    {
      View localView2 = localView1.findViewById(16908290);
      if (localView2 != null)
        localView2.setBackgroundColor(dc.d(paramActivity, R.attr.mainBackgroundColor));
      localViewGroup.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((paramAnonymousMotionEvent.getAction() == 0) && (this.a))
          {
            if (!dj.a(paramAnonymousMotionEvent.getRawX(), paramAnonymousMotionEvent.getRawY(), localView1))
              paramActivity.finish();
            return true;
          }
          return false;
        }
      });
      final Application localApplication = paramActivity.getApplication();
      localApplication.registerActivityLifecycleCallbacks(new b()
      {
        public void onActivityPaused(Activity paramAnonymousActivity)
        {
          if ((this.a == paramAnonymousActivity) && (paramAnonymousActivity.isFinishing()))
          {
            dj.d(paramAnonymousActivity);
            localApplication.unregisterActivityLifecycleCallbacks(this);
          }
        }
      });
      return;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
        ((FrameLayout.LayoutParams)localLayoutParams).gravity = 17;
    }
  }

  public static void a(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      b(paramActivity, paramInt1, paramInt2);
      return;
    }
    a(paramActivity, paramInt1, paramInt2, paramBoolean2);
  }

  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    boolean bool = c(paramActivity);
    int i;
    int j;
    if ((paramBoolean1) && (bool))
    {
      i = j.a(paramActivity, 400.0F);
      j = j.a(paramActivity, 650.0F);
      if (localDisplayMetrics.heightPixels <= i);
    }
    while (true)
    {
      a(paramActivity, j, i, false, paramBoolean2);
      return;
      i = (int)(0.98F * localDisplayMetrics.heightPixels);
      continue;
      i = j.a(paramActivity, 650.0F);
      j = j.a(paramActivity, 400.0F);
      if (localDisplayMetrics.heightPixels <= i)
        i = (int)(0.98F * localDisplayMetrics.heightPixels);
    }
  }

  public static void a(Snackbar paramSnackbar, int paramInt)
  {
    TextView localTextView = a(paramSnackbar);
    if (localTextView != null)
      localTextView.setTextColor(ContextCompat.getColor(localTextView.getContext(), paramInt));
  }

  public static void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (z.c(paramFragment.getFragmentManager(), DialogCode.D_PROGRESS) != null);
    for (boolean bool = true; paramBoolean == bool; bool = false)
      return;
    if (paramBoolean)
    {
      ad.b().b(true).b(paramFragment);
      return;
    }
    z.b(paramFragment, DialogCode.D_PROGRESS);
  }

  public static void a(AppCompatActivity paramAppCompatActivity, int paramInt)
  {
    a(paramAppCompatActivity, paramAppCompatActivity.getString(paramInt));
  }

  public static void a(AppCompatActivity paramAppCompatActivity, String paramString)
  {
    android.support.v7.app.a locala;
    if (paramAppCompatActivity != null)
    {
      locala = paramAppCompatActivity.getSupportActionBar();
      if (locala != null)
        break label14;
    }
    label14: TextView localTextView;
    do
    {
      return;
      View localView = locala.a();
      if ((localView == null) || (!ViberApplication.isTablet(paramAppCompatActivity)))
        break;
      localTextView = (TextView)localView.findViewById(com.viber.voip.R.id.abs__action_bar_title);
    }
    while (localTextView == null);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
    return;
    locala.a(paramString);
  }

  public static void a(AppCompatActivity paramAppCompatActivity, boolean paramBoolean)
  {
    a(paramAppCompatActivity, false, paramBoolean);
  }

  public static void a(AppCompatActivity paramAppCompatActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    android.support.v7.app.a locala = b(paramAppCompatActivity);
    if (locala == null);
    do
    {
      do
      {
        do
        {
          return;
          if ((!paramBoolean1) || (locala.h()))
            break;
          if (paramBoolean2)
            locala.h(false);
          locala.f();
        }
        while (!paramBoolean2);
        locala.h(true);
        return;
      }
      while ((paramBoolean1) || (!locala.h()));
      if (paramBoolean2)
        locala.h(false);
      locala.g();
    }
    while (!paramBoolean2);
    locala.h(true);
  }

  public static void a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null);
    try
    {
      paramRecyclerView.setAdapter(null);
      paramRecyclerView.removeAllViews();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(SearchView paramSearchView, int paramInt)
  {
    TextView localTextView = (TextView)paramSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
    if (localTextView != null)
      localTextView.setTextColor(paramInt);
  }

  public static void a(SearchView paramSearchView, Context paramContext)
  {
    if (paramSearchView != null)
    {
      paramSearchView.setMaxWidth(paramContext.getResources().getDimensionPixelOffset(R.dimen.search_view_max_width));
      a(paramSearchView, new Runnable()
      {
        public void run()
        {
          View localView = (View)this.a.getParent();
          if ((localView != null) && (localView.getLayoutParams().width != -1))
          {
            this.a.getLayoutParams().width = -1;
            localView.getLayoutParams().width = -1;
            localView.requestLayout();
          }
        }
      });
    }
  }

  public static void a(Toolbar paramToolbar, Drawable paramDrawable)
  {
    try
    {
      Field localField1 = Toolbar.class.getDeclaredField("mCollapseIcon");
      localField1.setAccessible(true);
      localField1.set(paramToolbar, paramDrawable);
      Field localField2 = Toolbar.class.getDeclaredField("mCollapseButtonView");
      localField2.setAccessible(true);
      ((ImageButton)localField2.get(paramToolbar)).setImageDrawable(paramDrawable);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(Menu paramMenu)
  {
    int i = paramMenu.size();
    for (int j = 0; j < i; j++)
      paramMenu.getItem(j).setVisible(false);
  }

  public static void a(MenuItem paramMenuItem, boolean paramBoolean)
  {
    if ((paramMenuItem == null) || (paramMenuItem.isVisible() == paramBoolean))
      return;
    paramMenuItem.setVisible(paramBoolean);
  }

  public static void a(View paramView)
  {
    if ((b()) && (paramView.getLayerType() != 2))
      paramView.setLayerType(2, null);
  }

  public static void a(View paramView, int paramInt)
  {
    a(paramView, paramInt, paramInt, paramInt, paramInt);
  }

  public static void a(View paramView, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    if (paramView == null);
    ViewParent localViewParent;
    do
    {
      return;
      localViewParent = paramView.getParent();
    }
    while (!(localViewParent instanceof View));
    final View localView = (View)localViewParent;
    a(localView, new a()
    {
      public boolean onGlobalLayout()
      {
        ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
        if (((this.a.getWidth() == 0) && (localLayoutParams.width != 0)) || ((this.a.getHeight() == 0) && (localLayoutParams.height != 0)))
          return false;
        Rect localRect = new Rect();
        this.a.getHitRect(localRect);
        localRect.left -= paramInt1;
        localRect.top -= paramInt2;
        localRect.right += paramInt3;
        localRect.bottom += paramInt4;
        TouchDelegate localTouchDelegate = new TouchDelegate(localRect, this.a);
        localView.setTouchDelegate(localTouchDelegate);
        return true;
      }
    });
  }

  @SuppressLint({"NewApi"})
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (com.viber.common.d.a.a())
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }

  public static void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    if (paramView != null)
      paramView.setOnClickListener(paramOnClickListener);
  }

  public static void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    if (paramView != null)
      paramView.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }

  public static void a(View paramView1, View paramView2, boolean paramBoolean)
  {
    if ((paramView1 == null) || (paramView2 == null))
      return;
    if (paramBoolean)
    {
      Context localContext = paramView1.getContext();
      paramView1.startAnimation(AnimationUtils.loadAnimation(localContext, 17432576));
      paramView2.startAnimation(AnimationUtils.loadAnimation(localContext, 17432577));
    }
    while (true)
    {
      paramView1.setVisibility(0);
      paramView2.setVisibility(8);
      return;
      paramView1.clearAnimation();
      paramView2.clearAnimation();
    }
  }

  public static void a(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }

  public static void a(final View paramView, a parama)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      @SuppressLint({"NewApi"})
      public void onGlobalLayout()
      {
        if (this.a.onGlobalLayout())
          dj.b(paramView, this);
      }
    });
  }

  public static void a(View paramView, final Runnable paramRunnable)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      @SuppressLint({"NewApi"})
      public void onGlobalLayout()
      {
        dj.b(this.a, this);
        paramRunnable.run();
      }
    });
  }

  public static void a(Window paramWindow, boolean paramBoolean)
  {
    WindowManager.LayoutParams localLayoutParams;
    if (com.viber.common.d.a.c())
    {
      localLayoutParams = paramWindow.getAttributes();
      if (!paramBoolean)
        break label28;
    }
    label28: for (int i = 0; ; i = 1)
    {
      localLayoutParams.rotationAnimation = i;
      paramWindow.setAttributes(localLayoutParams);
      return;
    }
  }

  @SuppressLint({"NewApi"})
  public static void a(ImageView paramImageView, int paramInt)
  {
    if (com.viber.common.d.a.a())
    {
      paramImageView.setImageAlpha(paramInt);
      return;
    }
    paramImageView.setAlpha(paramInt);
  }

  public static void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramImageView == null) || (paramDrawable == null))
      return;
    Object localObject = paramImageView.getDrawable();
    TransitionDrawable localTransitionDrawable;
    if ((localObject instanceof TransitionDrawable))
    {
      localObject = ((Drawable)localObject).getCurrent();
      localTransitionDrawable = new TransitionDrawable(new Drawable[] { localObject, paramDrawable });
      localTransitionDrawable.setCrossFadeEnabled(true);
      if (!d.i.j.d())
        break label107;
    }
    label107: for (int i = 2000; ; i = 200)
    {
      localTransitionDrawable.startTransition(i);
      paramImageView.setImageDrawable(localTransitionDrawable);
      return;
      if (localObject != null)
        break;
      if (paramBoolean)
      {
        localObject = new ColorDrawable(0);
        break;
      }
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }

  @TargetApi(11)
  public static void a(ListView paramListView, int paramInt)
  {
    paramListView.setVerticalScrollbarPosition(paramInt);
  }

  public static void a(ListView paramListView, boolean paramBoolean)
  {
    paramListView.setFastScrollAlwaysVisible(paramBoolean);
    paramListView.setFastScrollEnabled(paramBoolean);
  }

  public static void a(TextView paramTextView)
  {
    paramTextView.setPaintFlags(0x8 | paramTextView.getPaintFlags());
    if (!com.viber.common.d.a.j())
      paramTextView.setSingleLine();
  }

  public static void a(TextView paramTextView, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int i;
    int j;
    label60: int k;
    ColorStateList localColorStateList;
    if (((paramConversationItemLoaderEntity.isGroupBehavior()) || (paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())) && (paramConversationItemLoaderEntity.isMuteConversation()) && (!paramConversationItemLoaderEntity.isSnoozedConversation()) && (!paramConversationItemLoaderEntity.isNotJoinedCommunity()))
    {
      i = 1;
      if (((!paramConversationItemLoaderEntity.isGroupBehavior()) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())) || (!paramConversationItemLoaderEntity.isSnoozedConversation()))
        break label134;
      j = 1;
      paramTextView.setCompoundDrawablePadding(paramTextView.getResources().getDimensionPixelSize(R.dimen.verified_icon_padding));
      if (!paramConversationItemLoaderEntity.isAnonymous())
        break label139;
      k = R.drawable.ic_anonymous_chat_shield;
      localColorStateList = ColorStateList.valueOf(dc.d(paramTextView.getContext(), R.attr.conversationToolbarTitleIconTint));
    }
    while (true)
    {
      if (k != 0)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, df.a(ContextCompat.getDrawable(paramTextView.getContext(), k), localColorStateList, true), null);
        return;
        i = 0;
        break;
        label134: j = 0;
        break label60;
        label139: if ((paramConversationItemLoaderEntity.isSecret()) && (i != 0))
        {
          k = R.drawable.ic_muted_secret_toolbar;
          localColorStateList = null;
          continue;
        }
        if ((paramConversationItemLoaderEntity.isSecret()) && (j != 0))
        {
          k = R.drawable.ic_snoozed_secret_toolbar;
          localColorStateList = null;
          continue;
        }
        if (paramConversationItemLoaderEntity.isSecret())
        {
          k = R.drawable.ic_secret;
          localColorStateList = null;
          continue;
        }
        if (i != 0)
        {
          k = R.drawable.ic_muted_toolbar;
          localColorStateList = ColorStateList.valueOf(dc.d(paramTextView.getContext(), R.attr.conversationToolbarTitleIconTint));
          continue;
        }
        if (j == 0)
          break label264;
        k = R.drawable.ic_snoozed_toolbar;
        localColorStateList = ColorStateList.valueOf(dc.d(paramTextView.getContext(), R.attr.conversationToolbarTitleIconTint));
        continue;
      }
      paramTextView.setCompoundDrawables(null, null, null, null);
      return;
      label264: localColorStateList = null;
      k = 0;
    }
  }

  public static void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramTextView.setPaintFlags(0x8 | paramTextView.getPaintFlags());
      return;
    }
    paramTextView.setPaintFlags(0xFFFFFFF7 & paramTextView.getPaintFlags());
  }

  private static void a(GroupIconView paramGroupIconView, e parame, f paramf, Uri paramUri)
  {
    paramGroupIconView.a(1, false);
    parame.a(paramUri, paramGroupIconView, paramf);
  }

  public static void a(GroupIconView paramGroupIconView, e parame, f paramf, com.viber.voip.messages.d.b paramb, Uri paramUri, long[] paramArrayOfLong)
  {
    if (paramUri == null)
    {
      a(paramGroupIconView, parame, paramf, paramb, paramArrayOfLong);
      return;
    }
    a(paramGroupIconView, parame, paramf, m.a(paramGroupIconView.getContext(), paramUri));
  }

  private static void a(GroupIconView paramGroupIconView, e parame, f paramf, com.viber.voip.messages.d.b paramb, long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null);
    while (true)
    {
      return;
      int i = paramArrayOfLong.length;
      int j = 0;
      int k = 0;
      while (j < i)
      {
        if (paramArrayOfLong[j] > 0L)
          k++;
        j++;
      }
      if (k == 0)
      {
        paramGroupIconView.a();
        return;
      }
      paramGroupIconView.a(k, false);
      for (int m = -1 + paramGroupIconView.getMaxIcons(); m >= 0; m--)
      {
        long l = paramArrayOfLong[m];
        if (l > 0L)
          parame.a(paramb.a(l), paramGroupIconView, paramf);
      }
    }
  }

  public static boolean a(float paramFloat1, float paramFloat2, View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight()).contains(paramFloat1, paramFloat2);
  }

  public static boolean a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != null);
    for (View localView = paramActivity.getWindow().getCurrentFocus(); localView != null; localView = null)
      return a(localView, paramBoolean);
    return false;
  }

  public static boolean a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    return (localDisplayMetrics.widthPixels <= 480.0F) || (localDisplayMetrics.heightPixels <= 800.0F);
  }

  public static boolean a(View paramView, ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (paramViewGroup.getChildAt(j) == paramView)
          bool = true;
      }
      else
        return bool;
    }
  }

  public static boolean a(View paramView, boolean paramBoolean)
  {
    boolean bool;
    if (paramView == null)
      bool = false;
    do
    {
      return bool;
      bool = ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    while (!paramBoolean);
    paramView.clearFocus();
    return bool;
  }

  public static boolean a(View[] paramArrayOfView)
  {
    int i = paramArrayOfView.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        View localView = paramArrayOfView[j];
        if ((localView != null) && (localView.getVisibility() == 0))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  public static android.support.v7.app.a b(AppCompatActivity paramAppCompatActivity)
  {
    if (paramAppCompatActivity != null)
      return paramAppCompatActivity.getSupportActionBar();
    return null;
  }

  public static void b(Activity paramActivity)
  {
    a(paramActivity, false, true);
  }

  private static void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    localViewGroup.setBackgroundResource(R.color.solid_60);
    Object localObject = localViewGroup.getChildAt(0);
    localViewGroup.removeView((View)localObject);
    if ((localObject instanceof ab))
    {
      ab localab2 = (ab)localObject;
      View localView = localab2.getChildAt(0);
      localab2.removeView(localView);
      localObject = localView;
    }
    final ab localab1 = new ab(paramActivity);
    localViewGroup.addView(localab1);
    localab1.addView((View)localObject);
    a(localViewGroup, new Runnable()
    {
      public void run()
      {
        Rect localRect = new Rect();
        this.a.getWindowVisibleDisplayFrame(localRect);
        localab1.setOffset(localRect.top);
      }
    });
    ViewGroup.LayoutParams localLayoutParams = localab1.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = 17;
    while (!(localLayoutParams instanceof FrameLayout.LayoutParams))
      return;
    ((FrameLayout.LayoutParams)localLayoutParams).gravity = 17;
  }

  public static void b(Activity paramActivity, boolean paramBoolean)
  {
    View localView;
    if ((paramActivity != null) && (paramActivity.getWindow() != null))
    {
      localView = paramActivity.getWindow().getDecorView();
      if (localView != null)
        break label29;
    }
    label29: int i;
    do
    {
      return;
      localView = null;
      break;
      i = localView.getSystemUiVisibility();
    }
    while (((paramBoolean) && (av.d(i, 8192))) || ((!paramBoolean) && (!av.d(i, 8192))));
    localView.setSystemUiVisibility(av.b(i, 8192, paramBoolean));
    c(paramActivity, paramBoolean);
  }

  public static void b(Snackbar paramSnackbar, int paramInt)
  {
    TextView localTextView = a(paramSnackbar);
    if (localTextView != null)
      localTextView.setMaxLines(paramInt);
  }

  public static void b(AppCompatActivity paramAppCompatActivity, boolean paramBoolean)
  {
    a(paramAppCompatActivity, true, paramBoolean);
  }

  public static void b(SearchView paramSearchView, int paramInt)
  {
    TextView localTextView = (TextView)paramSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
    try
    {
      Field localField1 = TextView.class.getDeclaredField("mCursorDrawableRes");
      localField1.setAccessible(true);
      localField1.set(localTextView, Integer.valueOf(paramInt));
      Drawable localDrawable = ContextCompat.getDrawable(paramSearchView.getContext(), paramInt);
      Drawable[] arrayOfDrawable = { localDrawable, localDrawable };
      Field localField2 = TextView.class.getDeclaredField("mEditor");
      localField2.setAccessible(true);
      Object localObject = localField2.get(localTextView);
      Field localField3 = localObject.getClass().getDeclaredField("mCursorDrawable");
      localField3.setAccessible(true);
      localField3.set(localObject, arrayOfDrawable);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void b(View paramView, int paramInt)
  {
    if (com.viber.common.d.a.a())
    {
      if (paramInt != paramView.getMinimumHeight())
        paramView.setMinimumHeight(paramInt);
      return;
    }
    paramView.setMinimumHeight(paramInt);
  }

  public static void b(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    if (paramView != null)
    {
      if (com.viber.common.d.a.a())
        paramView.getViewTreeObserver().removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
    else
      return;
    paramView.getViewTreeObserver().removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }

  public static void b(View paramView, final Runnable paramRunnable)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        paramRunnable.run();
        return true;
      }
    });
  }

  public static void b(View paramView, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      c(paramView, i);
      return;
    }
  }

  public static boolean b()
  {
    return !e().contains(Build.MODEL.toUpperCase());
  }

  public static boolean b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("split_action_bar_is_narrow", "bool", "android");
    return (i > 0) && (localResources.getBoolean(i));
  }

  public static boolean b(AppCompatActivity paramAppCompatActivity, String paramString)
  {
    android.support.v7.app.a locala;
    if (paramAppCompatActivity != null)
    {
      locala = paramAppCompatActivity.getSupportActionBar();
      if (locala != null)
        break label15;
    }
    label15: TextView localTextView;
    do
    {
      return false;
      View localView = locala.a();
      if ((!ViberApplication.isTablet(paramAppCompatActivity)) || (localView == null))
        break;
      localTextView = (TextView)localView.findViewById(com.viber.voip.R.id.abs__action_bar_subtitle);
    }
    while (localTextView == null);
    String str = localTextView.getText().toString();
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      localTextView.setText("");
      localObject = str;
      label85: if (localObject == null)
        localObject = "";
      if (paramString == null)
        paramString = "";
      if (((CharSequence)localObject).toString().equals(paramString))
        break label150;
    }
    label150: for (boolean bool = true; ; bool = false)
    {
      return bool;
      localTextView.setVisibility(0);
      localTextView.setText(paramString);
      break;
      localObject = locala.c();
      locala.b(paramString);
      break label85;
    }
  }

  public static boolean b(View paramView)
  {
    if (paramView == null)
      return false;
    return ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 1);
  }

  public static int c()
  {
    Application localApplication = ViberApplication.getApplication();
    int i = localApplication.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0)
      return localApplication.getResources().getDimensionPixelSize(i);
    TypedValue localTypedValue = new TypedValue();
    if (localApplication.getTheme().resolveAttribute(16843499, localTypedValue, true))
      return localApplication.getResources().getDimensionPixelSize(localTypedValue.resourceId);
    return 0;
  }

  public static int c(AppCompatActivity paramAppCompatActivity)
  {
    try
    {
      int i = paramAppCompatActivity.getPackageManager().getActivityInfo(paramAppCompatActivity.getComponentName(), 128).theme;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return 0;
  }

  public static void c(Activity paramActivity)
  {
    boolean bool = d.ag.d.d();
    if ((!com.viber.common.d.a.o()) && (d.ag.c.d()));
    for (int i = 1; ; i = 0)
    {
      if ((bool) && (i != 0))
      {
        Window localWindow = paramActivity.getWindow();
        localWindow.addFlags(4718592);
        if (!h(paramActivity))
          localWindow.addFlags(2097152);
      }
      return;
    }
  }

  public static void c(Activity paramActivity, boolean paramBoolean)
  {
    if (!d.ad.Q.a())
      f();
    Class localClass1;
    if ((d.ad.Q.d()) && (br.f.a()) && (com.viber.common.d.a.j()))
      localClass1 = paramActivity.getWindow().getClass();
    try
    {
      Class localClass2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int i = localClass2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass2);
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = Integer.TYPE;
      Method localMethod = localClass1.getMethod("setExtraFlags", arrayOfClass);
      Window localWindow = paramActivity.getWindow();
      Object[] arrayOfObject = new Object[2];
      int j = 0;
      if (paramBoolean)
        j = i;
      arrayOfObject[0] = Integer.valueOf(j);
      arrayOfObject[1] = Integer.valueOf(i);
      localMethod.invoke(localWindow, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void c(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramInt != paramView.getVisibility()))
      paramView.setVisibility(paramInt);
  }

  public static void c(View paramView, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 0; ; i = 4)
    {
      c(paramView, i);
      return;
    }
  }

  @Deprecated
  public static boolean c(Context paramContext)
  {
    return (paramContext != null) && (paramContext.getResources().getBoolean(R.bool.is_landscape));
  }

  public static boolean c(View paramView)
  {
    return a(paramView, true);
  }

  public static float d(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    TypedValue localTypedValue = new TypedValue();
    localResources.getValue(R.dimen.home_weight_right_land, localTypedValue, true);
    return localTypedValue.getFloat();
  }

  public static <T extends View> T d(View paramView, int paramInt)
  {
    if (paramView != null)
      return paramView.findViewById(paramInt);
    return null;
  }

  public static void d(View paramView)
  {
    if (paramView != null)
      ((InputMethodManager)paramView.getContext().getSystemService("input_method")).restartInput(paramView);
  }

  public static void d(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
      paramView.setClickable(paramBoolean);
  }

  // ERROR //
  public static boolean d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: new 1105	java/io/BufferedReader
    //   5: dup
    //   6: new 1107	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 1113	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: ldc_w 1115
    //   16: ldc_w 1117
    //   19: invokevirtual 1121	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokevirtual 1125	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   25: invokevirtual 1131	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   28: invokespecial 1134	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: sipush 1024
    //   34: invokespecial 1137	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 1140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload_1
    //   45: invokevirtual 1143	java/io/BufferedReader:close	()V
    //   48: aload_1
    //   49: invokestatic 1148	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   52: ldc_w 1150
    //   55: aload 5
    //   57: invokevirtual 1154	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ireturn
    //   61: astore 6
    //   63: aload_0
    //   64: invokestatic 1148	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   67: iconst_0
    //   68: ireturn
    //   69: astore 4
    //   71: aload_0
    //   72: invokestatic 1148	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   75: aload 4
    //   77: athrow
    //   78: astore_3
    //   79: aload_1
    //   80: astore_0
    //   81: aload_3
    //   82: astore 4
    //   84: goto -13 -> 71
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: goto -27 -> 63
    //
    // Exception table:
    //   from	to	target	type
    //   2	38	61	java/lang/Exception
    //   2	38	69	finally
    //   38	48	78	finally
    //   38	48	87	java/lang/Exception
  }

  public static boolean d(Activity paramActivity)
  {
    return a(paramActivity, true);
  }

  public static int e(Activity paramActivity)
  {
    ComponentName localComponentName = paramActivity.getComponentName();
    try
    {
      int i = paramActivity.getPackageManager().getActivityInfo(localComponentName, 128).screenOrientation;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return -1;
  }

  public static <T extends View> T e(View paramView, int paramInt)
  {
    View localView = paramView.findViewById(paramInt);
    if ((localView instanceof ViewStub))
      localView = ((ViewStub)localView).inflate();
    return localView;
  }

  private static Set<String> e()
  {
    if (b == null)
    {
      b = new HashSet(30);
      b.add("A878 DUO");
      b.add("A898 DUO");
      b.add("CYNUS T1");
      b.add("I MOBILE I STYLE Q2");
      b.add("R8111");
      b.add("SKY");
      b.add("FLYLIFE CONNECT 7 85 3G 2");
      b.add("IQ441");
      b.add("HTC DESIRE C");
      b.add("HTC DESIRE V");
      b.add("HTC DESIRE 200");
      b.add("HTC ONE V");
      b.add("C5155");
      b.add("C5170");
      b.add("IDEATAB S6000 F");
      b.add("LENOVO A660");
      b.add("LENOVO A789");
      b.add("LENOVO P700I");
      b.add("LENOVO P780 ROW");
      b.add("LENOVO S820 ROW");
      b.add("A114");
      b.add("A8");
      b.add("AZ210A");
      b.add("ORANGE INFINITY 996");
      b.add("BLADE III");
      b.add("BLADE III IL");
      b.add("TURKCELL MAXI PLUS 5");
      b.add("ZTE BLADE III");
      b.add("UNIDEN PRIME 500");
    }
    return b;
  }

  public static boolean e(Context paramContext)
  {
    if (com.viber.common.d.a.j())
      return Settings.canDrawOverlays(paramContext);
    return true;
  }

  public static boolean e(View paramView)
  {
    return (paramView != null) && (paramView.getVisibility() == 0);
  }

  public static TextView f(View paramView)
  {
    if (paramView == null)
      return null;
    try
    {
      Field localField = paramView.getClass().getDeclaredField("mTitleTextView");
      localField.setAccessible(true);
      TextView localTextView = (TextView)localField.get(paramView);
      return localTextView;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static void f()
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      Object localObject = localClass.getMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { "ro.miui.ui.version.code" });
      String str;
      com.viber.common.b.b localb;
      if (!(localObject instanceof String))
      {
        str = "";
        localb = d.ad.Q;
        if (da.a(str))
          break label80;
      }
      label80: for (boolean bool = true; ; bool = false)
      {
        localb.a(bool);
        return;
        str = (String)localObject;
        break;
      }
    }
    catch (Throwable localThrowable)
    {
      d.ad.Q.a(false);
    }
  }

  public static void f(Activity paramActivity)
  {
    if (com.viber.common.d.a.g())
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(1280);
  }

  public static boolean f(Context paramContext)
  {
    boolean bool = e(paramContext);
    if (!bool)
      com.viber.voip.ui.dialogs.a.l().d();
    return bool;
  }

  public static float g(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getDisplayMetrics().widthPixels;
    return a(localResources) * i;
  }

  public static TextView g(View paramView)
  {
    if (paramView == null)
      return null;
    try
    {
      Field localField = paramView.getClass().getDeclaredField("mSubtitleTextView");
      localField.setAccessible(true);
      TextView localTextView = (TextView)localField.get(paramView);
      return localTextView;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static void h(View paramView)
  {
    if (!com.viber.common.d.a.g())
      paramView.setLayerType(1, null);
  }

  @SuppressLint({"NewApi"})
  public static boolean h(Context paramContext)
  {
    PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
    if (com.viber.common.d.a.f())
      return localPowerManager.isInteractive();
    return localPowerManager.isScreenOn();
  }

  public static int i(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(R.attr.actionBarSize, localTypedValue, true))
      return paramContext.getResources().getDimensionPixelSize(localTypedValue.resourceId);
    return 0;
  }

  public static void i(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ConstraintLayout))
      ((ConstraintLayout)localViewParent).a(paramView).e(paramView.getVisibility());
  }

  public static Set<String> j(Context paramContext)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = localInputMethodManager.getEnabledInputMethodList().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = localInputMethodManager.getEnabledInputMethodSubtypeList((InputMethodInfo)localIterator1.next(), false).iterator();
      while (localIterator2.hasNext())
      {
        InputMethodSubtype localInputMethodSubtype = (InputMethodSubtype)localIterator2.next();
        if (localInputMethodSubtype.getMode().equals("keyboard"))
        {
          String str = localInputMethodSubtype.getLocale();
          if (!da.a(str))
            localHashSet.add(str);
        }
      }
    }
    return localHashSet;
  }

  public static b.a k(Context paramContext)
  {
    switch (o(paramContext).densityDpi)
    {
    default:
      return b.a.d;
    case 120:
      return b.a.a;
    case 160:
      return b.a.c;
    case 240:
    }
    return b.a.b;
  }

  public static String l(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = o(paramContext);
    if (localDisplayMetrics.densityDpi <= 160)
      return "60";
    if (localDisplayMetrics.densityDpi <= 240)
      return "90";
    if (localDisplayMetrics.densityDpi <= 320)
      return "120";
    return "180";
  }

  public static int m(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("status_bar_height", "dimen", "android");
    int j = 0;
    if (i > 0)
      j = localResources.getDimensionPixelSize(i);
    return j;
  }

  public static View n(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackground(dc.g(paramContext, R.attr.listSectionDivider));
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(R.dimen.chat_info_edit_separator_height)));
    return localView;
  }

  private static DisplayMetrics o(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (com.viber.common.d.a.b())
      return j.a(localDisplay);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public static abstract interface a
  {
    public abstract boolean onGlobalLayout();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dj
 * JD-Core Version:    0.6.2
 */