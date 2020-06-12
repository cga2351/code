import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class TestBtn4UI extends StatefulWidget {
  @override
  State createState() {
    return TestBtn4UIState();
  }
}

class TestBtn4UIState extends State<TestBtn4UI>
    with SingleTickerProviderStateMixin {
  BuildContext buildContext;

  List topTabString = ["TopTab1", "TopTab2", "TopTab3", "TopTab4"];
  TabController tabController;

  List bottomTabString = ["BottomTab1", "BottomTab2", "BottomTab3"];
  int currentBottomTabIndex = 0;

  List bottomPages = [BottomTabPage1(), BottomTabPage2(), BottomTabPage3()];
  PageView pageView;
  PageController pageViewController = PageController(initialPage: 0);

  @override
  void initState() {
    tabController = TabController(length: topTabString.length, vsync: this);

    pageView = PageView(
      children: <Widget>[
        BottomTabPage1(),
        BottomTabPage2(),
        BottomTabPage3()
        ],
      onPageChanged: (index){
        setState(() {
          currentBottomTabIndex = index;
        });
      },
      controller: pageViewController,
    );

  }

  @override
  Widget build(BuildContext context) {
    buildContext = context;
    return Scaffold(
//      appBar: AppBar(
//        title: Text("TestBtn4UI"),
//        bottom: TabBar(
//          indicatorColor: Colors.white,
//          labelColor: Colors.white,
//          tabs: topTabString.map((e) => Tab(text: e)).toList(),
//          controller: tabController,
//        ),
//      ),
//      body: TabBarView(
//        controller: tabController,
//        children: topTabString.map((e) {
//          return Center(
//              child: Text(e, style: TextStyle(fontSize: 50))
//          );
//        }).toList(),
//      ),

      appBar: AppBar(
        title: Text("TestBtn4UI"),
      ),

//      body: bottomPages[currentBottomTabIndex],
      body:pageView,

//      PageView.builder(
//        itemBuilder: (buildContext, index) {return bottomPages[index];},
//        itemCount:bottomPages.length,
//        controller: pageViewController,
//        onPageChanged: (index) {
//          setState(() {
//            currentBottomTabIndex = index;
//          });
//        },
//      ),




//      PageView(
//        children: <Widget>[
//          BottomTabPage1(),
//          BottomTabPage2(),
//          BottomTabPage3()
//        ],
//        controller: PageController(initialPage: 0),
//        onPageChanged: (index){
//          print("PageView changed to $index");
//        },
//      ),

      bottomNavigationBar: BottomNavigationBar(
        items: bottomTabString.map((e) {
          return BottomNavigationBarItem(
              icon: Icon(Icons.group, size: 30),
              title: Text(e, style: TextStyle(fontSize: 10),)
          );
        }).toList(),
        onTap: onBottomTabClicked,
        currentIndex: currentBottomTabIndex,
//        selectedFontSize: 10,
//        unselectedFontSize: 10,
      ),
    );
  }

  void onBottomTabClicked(int index) {
    print("item of $index cliecked");
    setState(() {
      currentBottomTabIndex = index;
      print("icurrentBottomTabIndex = $index");

      pageViewController.animateToPage(index, duration: Duration(milliseconds: 300), curve: Curves.ease);
    });
  }
}

class BottomTabPage1State extends State<BottomTabPage1>
    with SingleTickerProviderStateMixin {
  List topTabString = ["TopTab1", "TopTab2", "TopTab3"];
//  TabController tabController;

  @override
  void initState() {
//    tabController = TabController(length: topTabString.length, vsync: this);
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: topTabString.length,
      child: Scaffold(
        body: Column(
          children: <Widget>[
            Container(
              padding: EdgeInsets.all(5),
              child:TabBar(
                indicatorColor: Colors.redAccent,
                labelColor: Colors.redAccent,
                tabs: topTabString.map((e) => Tab(text: e)).toList(),
//                controller: tabController,
              ),
            ),
            Expanded(
              child: TabBarView(
//                  controller: tabController,
                  children: topTabString.map((e) {
                    return Center(
                        child: Text(e, style: TextStyle(fontSize: 30)));
                  }).toList()
              )
            )
          ],
        )
    ),
    );


//    return Scaffold(
////        appBar: AppBar(
////          automaticallyImplyLeading: false,
////          backgroundColor: Colors.white,
////          title: TabBar(
////            indicatorColor: Colors.redAccent,
////            labelColor: Colors.redAccent,
////            tabs: topTabString.map((e) => Tab(text: e)).toList(),
////            controller: tabController,
////          ),
////        ),
////        body: TabBarView(
////            controller: tabController,
////            children: topTabString.map((e) {
////              return Center(
////                  child: Text(e, style: TextStyle(fontSize: 30)));
////            }).toList()
////        )
//
//
//        body: Column(
//          children: <Widget>[
//            Container(
//              padding: EdgeInsets.all(5),
//              child:TabBar(
//                indicatorColor: Colors.redAccent,
//                labelColor: Colors.redAccent,
//                tabs: topTabString.map((e) => Tab(text: e)).toList(),
//                controller: tabController,
//              ),
//            ),
//            Expanded(
//              child: TabBarView(
//                  controller: tabController,
//                  children: topTabString.map((e) {
//                    return Center(
//                        child: Text(e, style: TextStyle(fontSize: 30)));
//                  }).toList()
//              )
//            )
//          ],
//        )
//
//    );
  }
}

class BottomTabPage1 extends StatefulWidget {
  @override
  State createState() {
    return BottomTabPage1State();
  }
}

class BottomTabPage2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
//      appBar: AppBar(
//        title: Text("Bottom Tab Page 2"),
//      ),
      body: Center(
        child: Text(
          "Bottom Tab Page 2",
          style: TextStyle(fontSize: 30),
        ),
      ),
    );
  }
}

class BottomTabPage3 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
//      appBar: AppBar(
//        title: Text("Bottom Tab Page 3"),
//      ),
      body: Center(
        child: Text(
          "Bottom Tab Page 3",
          style: TextStyle(fontSize: 30),
        ),
      ),
    );
  }
}
