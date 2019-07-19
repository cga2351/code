package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.array;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.conversation.community.CreateCommunityActivity;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.k;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.j.av;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.bt;
import com.viber.voip.util.dj;
import com.viber.voip.widget.BulletTextTableView;

public class CommunityIntroActivity extends ViberFragmentActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, m.c
{
  private static final int[][] a = arrayOfInt;
  private b b;
  private LinearLayout c;
  private ImageView[] d;
  private ViewPager e;

  static
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = R.string.community_intro_item_1_title;
    arrayOfInt1[1] = R.string.community_intro_item_1_text;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = R.drawable.img_community_intro_1;
    arrayOfInt1[4] = R.drawable.img_community_intro_secondary_1;
    arrayOfInt[0] = arrayOfInt1;
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[0] = R.string.community_intro_item_2_title;
    arrayOfInt2[1] = -1;
    arrayOfInt2[2] = R.array.community_intro_item_2_text_options;
    arrayOfInt2[3] = R.drawable.img_community_intro_2;
    arrayOfInt2[4] = -1;
    arrayOfInt[1] = arrayOfInt2;
    int[] arrayOfInt3 = new int[5];
    arrayOfInt3[0] = R.string.community_intro_item_3_title;
    arrayOfInt3[1] = -1;
    arrayOfInt3[2] = R.array.community_intro_item_3_text_options;
    arrayOfInt3[3] = R.drawable.img_community_intro_3;
    arrayOfInt3[4] = -1;
    arrayOfInt[2] = arrayOfInt3;
  }

  private void b()
  {
    this.d = new ImageView[a.length];
    for (int i = 0; i < this.d.length; i++)
    {
      this.d[i] = new ImageView(this);
      this.d[i].setImageResource(R.drawable.dot_community_tutorial);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      int j = getResources().getDimensionPixelOffset(R.dimen.community_tutorial_dots_padding);
      localLayoutParams.setMargins(j, 0, j, 0);
      this.c.addView(this.d[i], localLayoutParams);
    }
    this.d[0].setSelected(true);
  }

  protected c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new k(), this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (1021 == paramInt1);
    switch (paramInt2)
    {
    default:
      return;
    case -1:
    }
    startActivity(paramIntent);
    finish();
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_start_community)
    {
      if (getIntent().hasExtra("extra_forward"))
        startActivityForResult((Intent)getIntent().getParcelableExtra("extra_forward"), 1021);
    }
    else
      return;
    if (TextUtils.isEmpty(UserManager.from(this).getUserData().getViberName()))
    {
      com.viber.voip.ui.dialogs.d.k().a(this).a(this);
      return;
    }
    Intent localIntent = new Intent(this, CreateCommunityActivity.class);
    localIntent.putExtra("members_extra", new GroupController.GroupMember[0]);
    setResult(-1, localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (ViberApplication.isTablet(this))
      dj.b(this);
    while (true)
    {
      super.onCreate(paramBundle);
      setContentView(R.layout.activity_community_intro);
      getSupportActionBar().b(true);
      setActionBarTitle(R.string.communities);
      this.b = new b(null);
      this.e = ((ViewPager)findViewById(R.id.view_pager));
      this.e.setAdapter(this.b);
      this.e.addOnPageChangeListener(this);
      this.e.setCurrentItem(0);
      findViewById(R.id.btn_start_community).setOnClickListener(this);
      this.c = ((LinearLayout)findViewById(R.id.pager_dots));
      b();
      return;
      com.viber.voip.n.a.d(this);
    }
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramInt == -1) && (paramm.a(DialogCode.D1012d)))
      ViberActionRunner.bt.d(this);
    while ((paramInt != -2) || (!paramm.a(DialogCode.D1012d)))
      return;
    setResult(0);
    finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPageScrollStateChanged(int paramInt)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    ImageView[] arrayOfImageView = this.d;
    int i = arrayOfImageView.length;
    for (int j = 0; j < i; j++)
      arrayOfImageView[j].setSelected(false);
    this.d[paramInt].setSelected(true);
  }

  private static class a extends LinearLayout
  {
    public a(Context paramContext, int paramInt)
    {
      super();
      a(paramInt);
    }

    private void a(int paramInt)
    {
      boolean bool1 = true;
      LayoutInflater.from(getContext()).inflate(R.layout.layout_community_intro_item, this, bool1);
      ((TextView)findViewById(R.id.page_title)).setText(CommunityIntroActivity.a()[paramInt][0]);
      TextView localTextView = (TextView)findViewById(R.id.page_body);
      if (CommunityIntroActivity.a()[paramInt][bool1] != -1)
        localTextView.setText(getContext().getResources().getString(CommunityIntroActivity.a()[paramInt][bool1]));
      boolean bool2;
      boolean bool3;
      label117: ImageView localImageView;
      int i;
      if (CommunityIntroActivity.a()[paramInt][bool1] != -1)
      {
        bool2 = bool1;
        dj.b(localTextView, bool2);
        if (CommunityIntroActivity.a()[paramInt][2] == 0)
          break label247;
        bool3 = bool1;
        if (bool3)
        {
          String[] arrayOfString = getContext().getResources().getStringArray(CommunityIntroActivity.a()[paramInt][2]);
          ((BulletTextTableView)findViewById(R.id.page_body_optional)).a(arrayOfString, R.layout.view_bullet_text_community_tutorial_item, R.id.text);
        }
        dj.b(findViewById(R.id.page_body_optional), bool3);
        ((ImageView)findViewById(R.id.page_image)).setImageResource(CommunityIntroActivity.a()[paramInt][3]);
        localImageView = (ImageView)findViewById(R.id.page_image_secondary);
        i = CommunityIntroActivity.a()[paramInt][4];
        if (i == -1)
          break label253;
      }
      while (true)
      {
        dj.b(localImageView, bool1);
        if (i != -1)
          localImageView.setImageResource(i);
        return;
        bool2 = false;
        break;
        label247: bool3 = false;
        break label117;
        label253: bool1 = false;
      }
    }
  }

  private static class b extends PagerAdapter
  {
    private SparseArrayCompat<CommunityIntroActivity.a> a = new SparseArrayCompat();

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      this.a.remove(paramInt);
      paramViewGroup.removeView((CommunityIntroActivity.a)paramObject);
    }

    public int getCount()
    {
      return CommunityIntroActivity.a().length;
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      CommunityIntroActivity.a locala = new CommunityIntroActivity.a(paramViewGroup.getContext(), paramInt);
      this.a.put(paramInt, locala);
      paramViewGroup.addView(locala);
      return locala;
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.CommunityIntroActivity
 * JD-Core Version:    0.6.2
 */