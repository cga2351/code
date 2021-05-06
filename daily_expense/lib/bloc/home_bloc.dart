
import 'package:flutter/widgets.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

///////////////////////////////////////////
// bloc
class HomeBloc extends Bloc<HomeEvent, HomeState> {
  HomeBloc(HomeState initialState) : super(initialState);
  // HomeState get initialState => HomeStateNormal(0, 0);

  @override
  Stream<HomeState> mapEventToState(HomeEvent event) async* {
    if (event is HomeEventSwitchTab) {
      HomeEventSwitchTab switchEvent = event;
      yield HomeStateNormal(switchEvent.newIndex, switchEvent.oldIndex);
    }
  }
}

///////////////////////////////////////////
// event
abstract class HomeEvent {}

class HomeEventSwitchTab extends HomeEvent{
  int newIndex;
  int oldIndex;

  HomeEventSwitchTab(this.newIndex, this.oldIndex);
}

///////////////////////////////////////////
// state
abstract class HomeState {}

class HomeStateNormal extends HomeState {
  int newIndex;
  int oldIndex;

  HomeStateNormal(this.newIndex, this.oldIndex);
}
