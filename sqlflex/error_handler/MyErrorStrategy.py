from antlr4 import RecognitionException
from antlr4.error.ErrorStrategy import DefaultErrorStrategy

class MyErrorStrategy(DefaultErrorStrategy):
  def __init__(self) -> None:
    super().__init__()
    
  
  def recover(self, recognizer, e):
    raise RecognitionException(f"Error in recover")
    
  
  def recoverInline(self, recognizer):
    raise RecognitionException(f"Error in recoverInline")
    
  # def sync(self, recognizer):
  #   pass