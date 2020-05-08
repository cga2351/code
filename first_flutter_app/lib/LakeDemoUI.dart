
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class LakeDemoUI extends StatefulWidget {
  final BuildContext buildContext;

  LakeDemoUI(this.buildContext);

  @override
  State createState() {
    return LakeDemoUIState();
  }
}

class LakeDemoUIState extends State {
  bool favorite = false;
  int favoriteNum = 60;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Lake Demo"),
      ),
      body: Container(
//        padding: EdgeInsets.all(20),
        child: Column(
          children: _buildSubView(),
        ),
      ),
    );
  }

  List<Widget> _buildSubView() {
    List<Widget> subViews = List<Widget>();

    // top image
    Image image = Image.asset("assets/images/lake.jpg");
//    Image image = Image.network("https://media.oss.navercorp.com/user/4356/files/a1bd5b80-7379-11ea-8730-dc36f319e42f");
    subViews.add(image);

    // title text
    // sub description column
    List<Widget> descriptions = List<Widget>();
    descriptions.add(new Container(padding: EdgeInsets.fromLTRB(30,30,30,3), child: Text("Oeschinen Lake Campground", style: TextStyle(fontSize: 16))));
    descriptions.add(new Container(padding: EdgeInsets.fromLTRB(30,3,30,30), child: Text("Kandersteg, Switzerland", style: TextStyle(color: Colors.grey, fontSize: 16))));
    Column descriptionColumn = Column(children: descriptions, crossAxisAlignment: CrossAxisAlignment.start,);
    Expanded descriptionExpanded = Expanded(child: descriptionColumn);
    // star icon
    Icon starIconSolid = Icon(Icons.star, color: Colors.red);
    Icon starIconBorder = Icon(Icons.star_border, color: Colors.red);
    Icon curIcon;
    if (favorite) {
      curIcon = starIconSolid;
    } else {
      curIcon = starIconBorder;
    }
    IconButton starIconButton = IconButton(
      icon: curIcon,
      onPressed: () {
        setState(() {
          favorite = !favorite;
          if (favorite) {
            favoriteNum++;
          } else {
            favoriteNum--;
          }
        });
      },
    );

    // star count
    Text starCount = Text(favoriteNum.toString(), style: TextStyle(fontSize: 16));
    // build title text row
    List<Widget> titleText = new List<Widget>();
    titleText.add(descriptionExpanded);
//    titleText.add(new Container(child: starIconSolid, padding: EdgeInsets.all(10),));
    titleText.add(new Container(child: starIconButton, padding: EdgeInsets.all(10),));
    titleText.add(new Container(child: starCount, padding: EdgeInsets.only(right: 30)));
    Row titleRow = Row(children: titleText, crossAxisAlignment: CrossAxisAlignment.center,);
    subViews.add(titleRow);

    // middle action button
    Row actionRow = Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: <Widget>[
        Column(
          mainAxisSize: MainAxisSize.min,
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Icon(Icons.phone, color: Colors.lightBlue, size: 30,),
            Container(
              padding: EdgeInsets.only(top: 10),
              child: Text("CALL", style: TextStyle(fontSize: 15, color: Colors.lightBlue),),
            ),
          ],
        ),
        Column(
          children: <Widget>[
            Icon(Icons.near_me, color: Colors.lightBlue, size: 30,),
            Container(
              padding: EdgeInsets.only(top: 10),
              child: Text("ROUTE", style: TextStyle(fontSize: 15, color: Colors.lightBlue),)
            ),
          ],
        ),
        Column(
          children: <Widget>[
            Icon(Icons.share, color: Colors.lightBlue, size: 30,),
            Container(
                padding: EdgeInsets.only(top: 10),
                child: Text("SHARE", style: TextStyle(fontSize: 15, color: Colors.lightBlue),)
            ),
          ],
        ),
      ],
    );
    subViews.add(actionRow);

    // bottom paragraph
    Container paragraphFiled = Container(
      padding: EdgeInsets.all(25),
      child: Text(
        "Lake Oeschinen lies at the foot of the Blüemlisalp in the Bernese Alps. Situated 1,578 meters above sea level, it is one of the larger Alpine Lakes. A gondola ride from Kandersteg, followed by a half-hour walk through pastures and pine forest, leads you to the lake, which warms to 20 degrees Celsius in the summer. Activities enjoyed here include rowing, and riding the summer toboggan run.",
        style: TextStyle(color: Colors.black),),
    );
    subViews.add((paragraphFiled));

    return subViews;
  }
}