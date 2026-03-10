from antlr4.error.ErrorListener import ErrorListener

class MyErrorListener(ErrorListener):
  def __init__(self) -> None:
    super().__init__()
    self.should_restart = False
    self.error_token = None
    
  def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e) -> None:
    self.should_restart = True
    self.error_token = offendingSymbol
    raise Exception(f"Syntax error")
  
  # def reportAmbiguity(self, recognizer, dfa, startIndex, stopIndex, exact, ambigAlts, configs) -> None:
  #   self.should_restart = True
  #   self.error_token = recognizer.getCurrentToken()
  #   raise Exception(f"Ambiguity at {startIndex}:{stopIndex}")
  
  # def reportAttemptingFullContext(self, recognizer, dfa, startIndex, stopIndex, conflictingAlts, configs) -> None:
  #   self.should_restart = True
  #   self.error_token = recognizer.getCurrentToken()
  #   raise Exception(f"Attempting full context at {startIndex}:{stopIndex}")
  
  # def reportContextSensitivity(self, recognizer, dfa, startIndex, stopIndex, prediction, configs) -> None:
  #   self.should_restart = True
  #   self.error_token = recognizer.getCurrentToken()
  #   raise Exception(f"Context sensitivity at {startIndex}:{stopIndex}")
    