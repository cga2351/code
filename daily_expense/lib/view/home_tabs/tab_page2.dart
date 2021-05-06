import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class TabPage2View extends StatefulWidget{

  @override
  State createState() {
    return TabPage2State();
  }
}
class TabPage2State extends State<TabPage2View> {
  List topTabStrings = ["feature1", "feature2", "feature3"];

  @override
  Widget build(BuildContext context) {
    return Center(
      child: DefaultTabController(
          length: topTabStrings.length,
          child: Container(
            child: Column(
              children: <Widget>[
                Container(
//                color: Colors.redAccent,
                  height: 50,
//              padding: EdgeInsets.all(10),
                  child: TabBar(
                    tabs:topTabStrings.map((e) {
                      return Text(e, style: TextStyle(fontSize: 15));
                    }).toList(),
                    indicatorColor: Colors.blue,
                    labelColor: Colors.blue,
                  ),
                ),
                Expanded(
                  child: TabBarView(
                      children: topTabStrings.map((e) {
                        return Center(child: Text(e, style: TextStyle(fontSize: 50),),);
                      }).toList()
                  ),
                )
              ],
            ),
          )
      ),
    );
  }
}