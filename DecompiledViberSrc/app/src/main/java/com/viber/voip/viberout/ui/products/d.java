package com.viber.voip.viberout.ui.products;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.viberout.ui.products.model.DestinationModel;
import java.util.Iterator;
import java.util.List;

public class d
  implements c
{
  private final LayoutInflater a;

  public d(LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
  }

  public void a(TableLayout paramTableLayout, List<DestinationModel> paramList)
  {
    int i = (int)paramTableLayout.getContext().getResources().getDimension(R.dimen.vo_destination_item_bottom_padding);
    Iterator localIterator = paramList.iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      DestinationModel localDestinationModel = (DestinationModel)localIterator.next();
      TableRow localTableRow = (TableRow)this.a.inflate(R.layout.vo_destination_item, paramTableLayout, false);
      ((ImageView)localTableRow.findViewById(R.id.dest_icon)).setImageResource(localDestinationModel.getIconResId());
      ((TextView)localTableRow.findViewById(R.id.dest_name)).setText(localDestinationModel.getName());
      ((TextView)localTableRow.findViewById(R.id.rate_line1)).setText(localDestinationModel.getRateLine1());
      TextView localTextView = (TextView)localTableRow.findViewById(R.id.rate_line2);
      localTextView.setText(localDestinationModel.getRateLine2());
      if (com.viber.common.d.c.a());
      for (int k = 8388611; ; k = 8388613)
      {
        localTextView.setGravity(k);
        localTableRow.setPadding(0, j, 0, i);
        paramTableLayout.addView(localTableRow);
        j = i;
        break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.d
 * JD-Core Version:    0.6.2
 */