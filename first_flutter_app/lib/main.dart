import 'dart:core';
import 'package:english_words/english_words.dart';
import 'package:firstflutterapp/TestBtn2UI.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'LakeDemoUI.dart';
import 'TestBtn1UI.dart';
import 'TestBtn3UI.dart';
import 'TestBtn4UI.dart';
import 'TestClass.dart';

void main() => runApp(new MyApp("abc"));

class MyApp extends StatelessWidget {
  final _finalVar1;
  static const _constVar1 = "abc";
  BuildContext buildContext;

  MyApp(this._finalVar1);

  @override
  Widget build(BuildContext context) {
    this.buildContext = context;
    /////////////////////////////////////////////////////////////////////////
    testDart(buildContext);
    /////////////////////////////////////////////////////////////////////////
//    final wordPair = new WordPair.random();
    return new MaterialApp(
      title: 'Welcome to Flutter',
      theme: new ThemeData(primaryColor: Colors.cyan),
//      home: new Scaffold(
//        appBar: new AppBar(
//          title: new Text('Welcome to Flutter'),
//        ),
//        body: new Center(
////          child: new Text('Hello World'),
////          child: new Text(wordPair.asCamelCase),
//          child: new RandomWords()
//        ),
//      ),
      home: new RandomWords(),
    );
  }
}

class RandomWords extends StatefulWidget {
  @override
  State createState() {
    return new RandomWordsState();
  }
}

class RandomWordsState extends State<RandomWords> {
  final _suggestions = <WordPair>[];
  final _biggerFont = const TextStyle(fontSize: 18.0);
  final _saved = Set<WordPair>();
  BuildContext buildContext;

  @override
  Widget build(BuildContext context) {
    buildContext = context;
//    return new Text(new WordPair.random().asPascalCase);
    return Scaffold(
      appBar: AppBar(
        title: Text('Startup Name Generator'),
        actions: <Widget>[
          IconButton(icon: Icon(Icons.list), onPressed: _pushSaved),
          FlatButton(
              child: Text("LakeDemo", style: TextStyle(fontSize: 11.0)),
              onPressed: _openLakeDemoUI),
//          MaterialButton(child: Text("LakeDemo"),onPressed: _openLakeDemoUI),
//          IconButton(icon: Icon(Icons.remove), onPressed: _pushSaved),
//          IconButton(icon: Icon(Icons.apps), onPressed: _pushSaved),
//          IconButton(icon: Icon(Icons.access_alarms), onPressed: _pushSaved)
        ],
      ),
      body: _buildSuggestions(buildContext),
    );
  }

  void _pushSaved() {
    Navigator.of(context).push(new MaterialPageRoute(builder: (context) {
      final tiles = _saved.map((pair) {
        return new ListTile(
          title: new Text(pair.asPascalCase, style: _biggerFont),
        );
      });
      final dividedTiles =
          ListTile.divideTiles(context: context, tiles: tiles).toList();

      return new Scaffold(
        appBar: new AppBar(title: Text("Saved Suggestions")),
        body: ListView(children: dividedTiles),
      );
    }));
  }

  Widget _buildSuggestions(BuildContext buildContext) {
//    return Container(
//        height: 500,
//        child: ListView.builder(
//            padding: const EdgeInsets.all(16.0),
//            itemBuilder: (context, i) {
//              if (i.isOdd) return new Divider();
//
//              final index = i ~/ 2;
//              if (index >= _suggestions.length) {
//                _suggestions.addAll(generateWordPairs().take(10));
//              }
//              return _buildRow(_suggestions[index]);
//            }));
//  return ListView();
    return Column(
      children: <Widget>[
        Container(
          height: 500,
          child: ListView.builder(
              padding: const EdgeInsets.all(16.0),
              itemBuilder: (context, i) {
                if (i.isOdd) return new Divider();

                final index = i ~/ 2;
                if (index >= _suggestions.length) {
                  _suggestions.addAll(generateWordPairs().take(10));
                }
                return _buildRow(_suggestions[index]);
              }),
        ),
        Container(
          width: 700,
          height: 100,
//          padding: EdgeInsets.only(left: 20),
          child: Wrap(
            direction: Axis.horizontal,
            alignment: WrapAlignment.start,
//            mainAxisAlignment: MainAxisAlignment.start,
            children: <Widget>[
              Container(
                  padding: EdgeInsets.only(left: 5, right: 5),
                  child: RaisedButton(
                    child: Text("Btn1"),
                    onPressed: _onPressTestBtn1)),
              Container(
                  padding: EdgeInsets.only(left: 5, right: 5),
                  child: RaisedButton(
                    child: Text("Btn2"),
                    onPressed: _onPressTestBtn2)),
              Container(
                  padding: EdgeInsets.only(left: 5, right: 5),
                  child: RaisedButton(
                    child: Text("Btn3"),
                    onPressed: _onPressTestBtn3)),
              Container(
                  padding: EdgeInsets.only(left: 5, right: 5),
                  child: RaisedButton(
                    child: Text("Btn4"),
                    onPressed: _onPressTestBtn4)),
              Container(
                  padding: EdgeInsets.only(left: 5, right: 5),
                  child: RaisedButton(
                    child: Text("Btn5555555555"),
                    onPressed: null)),
//            MaterialButton(
//              child: Text("testBtn1"),
//              onPressed: _onPressTestBtn1,
//            ),
//            CupertinoButton(
//              child: Text("testBtn1"),
//              onPressed: _onPressTestBtn1,
//            ),
            ],
          ),
        ),
        Container(
          child: Row(
            children: <Widget>[
//            FlatButton(
//              child: Text("testBtn1"),
//              onPressed: _onPressTestBtn1,
//            ),
//            OutlineButton(
//              child: Text("testBtn1"),
//              onPressed: _onPressTestBtn1,
//            ),
//            FloatingActionButton(
//              child: Icon(Icons.add),
//              onPressed: _onPressTestBtn1,
//            ),
            ],
          ),
        )
      ],
    );

  }

  Widget _buildRow(WordPair suggestion) {
    final alreadyExist = _saved.contains(suggestion);

    return ListTile(
      title: Text(
        suggestion.asPascalCase,
        style: _biggerFont,
      ),
      trailing: Icon(
        alreadyExist ? Icons.favorite : Icons.favorite_border,
        color: alreadyExist ? Colors.red : null,
      ),
      onTap: () {
        setState(() {
          if (alreadyExist) {
            _saved.remove(suggestion);
          } else {
            _saved.add(suggestion);
          }
        });
      },
    );
  }

  void _openLakeDemoUI() {
    Navigator.of(context).push(MaterialPageRoute(
        builder: (context) {
          return LakeDemoUI(context);
        }));
  }

  void _onPressTestBtn1() {
    Navigator.of(buildContext).push(MaterialPageRoute(
        builder: (buildContext) {
          return loadTestBtn1UI();
        }));
  }
  void _onPressTestBtn2() {
    Navigator.of(buildContext).push(MaterialPageRoute(
        builder: (buildContext) {
          return TestBtn2UI();
        }));
  }
  void _onPressTestBtn3() {
    Navigator.of(buildContext).push(MaterialPageRoute(
        builder: (buildContext) {
          return TestBtn3UI();
        }));
  }
  void _onPressTestBtn4() {
    Navigator.of(buildContext).push(MaterialPageRoute(
      builder: (buildContext) {
        return TestBtn4UI();
      }
    ));
  }
}
