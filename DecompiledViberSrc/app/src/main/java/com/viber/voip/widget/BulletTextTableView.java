package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class BulletTextTableView extends TableLayout
{
  public BulletTextTableView(Context paramContext)
  {
    this(paramContext, null);
  }

  public BulletTextTableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    removeAllViews();
    if (paramArrayOfString.length == 0);
    while (true)
    {
      return;
      LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        TableRow localTableRow = new TableRow(getContext());
        ViewGroup localViewGroup = (ViewGroup)localLayoutInflater.inflate(paramInt1, localTableRow, false);
        ((TextView)localViewGroup.findViewById(paramInt2)).setText(str);
        localTableRow.addView(localViewGroup, new TableRow.LayoutParams(-2, -2));
        addView(localTableRow, new TableLayout.LayoutParams(-1, -2));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.BulletTextTableView
 * JD-Core Version:    0.6.2
 */