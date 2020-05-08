
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class TestBtn2UI extends StatefulWidget {

  @override
  State createState() {
    return TestBtn2UIState();
  }
}

class TestBtn2UIState extends State {
  BuildContext buildContext;

  @override
  Widget build(BuildContext context) {
    buildContext = context;

    return Scaffold(
      appBar: AppBar(
        title: Text("Test Btn 2 UI"),
      ),
      body: Container(
        //
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            // left column
            Column(
              children: <Widget>[
                // title
                Center(
                  child: Text("Strawberry Pavlova", style: TextStyle(
                      fontSize: 18, fontWeight: FontWeight.w700),),
                ),
                // description
                Container(
                    width: 250,
                    padding: EdgeInsets.all(10),
                  child: Text(
                    "Pavlova is a meringue-based dessert named after the Russian ballerina Anna Pavlova. Pavlova features a crisp crusl and soft, light inside, topped with fruit and whipped cream",
                    style: TextStyle(fontSize: 13, letterSpacing: 0.5, height: 1.5),
                    textAlign: TextAlign.center,
                  )
                ),
                // info
                Container(
//                  padding: EdgeInsets.all(5),
                  child: Column(
                    children: <Widget>[
                      // star and review
                      Row(
                        children: <Widget>[
                          // star row
                          Row(
                            children: <Widget>[
                              Icon(Icons.star, color: Colors.black, size: 15,),
                              Icon(Icons.star, color: Colors.black, size: 15,),
                              Icon(Icons.star, color: Colors.black, size: 15,),
                              Icon(Icons.star, color: Colors.black, size: 15,),
                              Icon(Icons.star, color: Colors.black, size: 15,),
                            ],
                          ),
                          Text("170 Reviews", style: TextStyle(fontSize: 13),)
                        ],
                      ),
                      // time info
                      Container(
                        padding: EdgeInsets.all(10),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          children: <Widget>[
                            //prepare time
                            Container(
                              padding: EdgeInsets.all(10),
                              child: Column(
                                children: <Widget>[
                                  Icon(Icons.view_compact, color: Colors.lightGreen,),
                                  Text("PREP"),
                                  Container(
                                      padding: EdgeInsets.only(top:10),
                                      child: Text("25 min"),
                                  ),
                                ],
                              ),
                            ),
                            //cook time
                            Container(
                              padding: EdgeInsets.all(10),
                              child: Column(
                                children: <Widget>[
                                  Icon(Icons.timer, color: Colors.lightGreen,),
                                  Text("COOK"),
                                  Container(
                                    padding: EdgeInsets.only(top:10),
                                    child: Text("1 hr"),
                                  ),
                                ],
                              ),
                            ),
                            //feed time
                            Container(
                              padding: EdgeInsets.all(10),
                              child: Column(
                                children: <Widget>[
                                  Icon(Icons.restaurant, color: Colors.lightGreen,),
                                  Text("FEEDS"),
                                  Container(
                                    padding: EdgeInsets.only(top:10),
                                    child: Text("4-6"),
                                  ),
                                ],
                              ),
                            ),
                          ],
                        ),
                      )
                    ],
                  ),
                ),
              ],
            ),
            // image
            Expanded(
              child: Image.network("https://cdn.pixabay.com/photo/2016/06/20/23/50/mixed-berries-1470228_960_720.jpg"),
            ),
          ],
        ),
      ),
    );
  }
}