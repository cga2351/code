
import 'package:flutter_bloc/flutter_bloc.dart';

class ExpenseEditModeBloc extends Bloc<ExpenseEditModeEvent, ExpenseEditModeState> {
  ExpenseEditModeBloc(ExpenseEditModeState initialState) : super(initialState);

  @override
  Stream<ExpenseEditModeState> mapEventToState(ExpenseEditModeEvent event) async* {
    if(event is ExpenseEditModeEventFadeIn) {
      yield ExpenseEditModeStateFadeIn();
    } else if (event is ExpenseEditModeEventFadeOut) {
      yield ExpenseEditModeStateFadeOut();
    } else if (event is ExpenseEditModeEventOn) {
      yield ExpenseEditModeStateOn();
    } else if (event is ExpenseEditModeEventOff) {
      yield ExpenseEditModeStateOff();
    }
  }

}

// --------------------- event ---------------------
abstract class ExpenseEditModeEvent {}

class ExpenseEditModeEventFadeIn extends ExpenseEditModeEvent {

}
class ExpenseEditModeEventFadeOut extends ExpenseEditModeEvent {

}
class ExpenseEditModeEventOn extends ExpenseEditModeEvent {

}
class ExpenseEditModeEventOff extends ExpenseEditModeEvent {

}
// --------------------- state ---------------------
abstract class ExpenseEditModeState {}

class ExpenseEditModeStateFadeIn extends ExpenseEditModeState {

}
class ExpenseEditModeStateFadeOut extends ExpenseEditModeState {

}
class ExpenseEditModeStateOn extends ExpenseEditModeState {

}
class ExpenseEditModeStateOff extends ExpenseEditModeState {

}
