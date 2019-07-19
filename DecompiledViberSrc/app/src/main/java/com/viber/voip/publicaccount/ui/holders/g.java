package com.viber.voip.publicaccount.ui.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.widget.CarouselViewFlipper;

public final class g
{
  private static final int[][] a = arrayOfInt;

  static
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = R.string.create_public_account_welcome_carousel_first_page_title;
    arrayOfInt1[1] = R.string.create_public_account_welcome_carousel_first_page_description;
    arrayOfInt1[2] = R.drawable.carousel_image_01;
    arrayOfInt[0] = arrayOfInt1;
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = R.string.create_public_account_welcome_carousel_second_page_title;
    arrayOfInt2[1] = R.string.create_public_account_welcome_carousel_second_page_description;
    arrayOfInt2[2] = R.drawable.carousel_image_02;
    arrayOfInt[1] = arrayOfInt2;
    int[] arrayOfInt3 = new int[3];
    arrayOfInt3[0] = R.string.create_public_account_welcome_carousel_third_page_title;
    arrayOfInt3[1] = R.string.create_public_account_welcome_carousel_third_page_description;
    arrayOfInt3[2] = R.drawable.carousel_image_03;
    arrayOfInt[2] = arrayOfInt3;
  }

  public g(View paramView, LayoutInflater paramLayoutInflater)
  {
    a(paramView, paramLayoutInflater);
  }

  private static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt)
  {
    View localView = paramLayoutInflater.inflate(R.layout.create_public_account_welcome_carousel_item, paramViewGroup, false);
    ((TextView)localView.findViewById(R.id.public_account_welcome_carousel_title)).setText(a[paramInt][0]);
    ((TextView)localView.findViewById(R.id.public_account_welcome_carousel_description)).setText(a[paramInt][1]);
    ((ImageView)localView.findViewById(R.id.public_account_welcome_carousel_icon)).setImageResource(a[paramInt][2]);
    return localView;
  }

  private void a(View paramView, LayoutInflater paramLayoutInflater)
  {
    CarouselViewFlipper localCarouselViewFlipper = (CarouselViewFlipper)paramView.findViewById(R.id.welcome_carousel_flipper);
    localCarouselViewFlipper.addView(a(localCarouselViewFlipper, paramLayoutInflater, 0));
    localCarouselViewFlipper.addView(a(localCarouselViewFlipper, paramLayoutInflater, 1));
    localCarouselViewFlipper.addView(a(localCarouselViewFlipper, paramLayoutInflater, 2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.g
 * JD-Core Version:    0.6.2
 */